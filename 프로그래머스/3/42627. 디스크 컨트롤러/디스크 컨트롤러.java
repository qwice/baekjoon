import java.util.*;

class Act implements Comparable<Act> {
    int order;
    int offer;   // 작업 요청 시점
    int during;  // 작업 소요 시간

    public Act(int order, int offer, int during) {
        this.order = order;
        this.offer = offer;
        this.during = during;
    }

    @Override
    public int compareTo(Act a1) {
        // 작업 소요 시간 기준 오름차순 (작은 작업부터 처리)
        if (this.during != a1.during)
            return this.during - a1.during;
        // 소요 시간이 같으면 요청 시간 오름차순
        if (this.offer != a1.offer)
            return this.offer - a1.offer;
        // 요청 시간도 같으면 order 순서대로
        return this.order - a1.order;
    }

    @Override
    public String toString() {
        return "Act(order=" + order + ", offer=" + offer + ", during=" + during + ")";
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;

        // 작업 요청 시간 기준 정렬 (나중에 순서대로 작업 요청 처리하기 위함)
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Act> pq = new PriorityQueue<>();
        int time = 0;       // 현재 시각
        int idx = 0;        // jobs 배열 탐색용 인덱스
        int completed = 0;  // 완료된 작업 수
        int totalWait = 0;  // 누적 대기 시간

        while (completed < size) {
            // 현재 시각까지 도착한 작업 모두 우선순위 큐에 삽입
            while (idx < size && jobs[idx][0] <= time) {
                pq.offer(new Act(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (pq.isEmpty()) {
                // 처리할 작업 없으면 시간 증가 (CPU idle)
                time = jobs[idx][0];
            } else {
                Act current = pq.poll();
                time += current.during; // 작업 완료 시간 증가
                totalWait += (time - current.offer); // 작업이 완료된 시점 - 요청 시점 = 대기시간 + 실행시간
                completed++;
            }
        }

        answer = totalWait / size;
        return answer;
    }
}
