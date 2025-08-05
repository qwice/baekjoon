class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true) {
            System.out.println(answer);
            if((a % 2 == 1 && a + 1 == b) || (b % 2 == 1 && b + 1 == a) ) {
                answer++;
                break;
            }
            a = (int) Math.round((float)a/2);
            b = (int) Math.round((float)b/2);
            answer++;
        }
        

        return answer;
    }
}