class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkRoom(String[] room) {
        int n = 5;

        int[] dr1 = {-1, 1, 0, 0};
        int[] dc1 = {0, 0, -1, 1};

        int[] dr2 = {-2, 2, 0, 0};
        int[] dc2 = {0, 0, -2, 2};

        int[] dr3 = {-1, -1, 1, 1};
        int[] dc3 = {-1, 1, -1, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (room[r].charAt(c) != 'P') continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr1[d];
                    int nc = c + dc1[d];
                    if (inRange(nr, nc) && room[nr].charAt(nc) == 'P') {
                        return false;
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr2[d];
                    int nc = c + dc2[d];
                    int mr = r + dr1[d];
                    int mc = c + dc1[d];

                    if (inRange(nr, nc) && room[nr].charAt(nc) == 'P') {
                        if (room[mr].charAt(mc) != 'X') {
                            return false;
                        }
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr3[d];
                    int nc = c + dc3[d];

                    if (inRange(nr, nc) && room[nr].charAt(nc) == 'P') {
                        if (room[r].charAt(nc) != 'X' || room[nr].charAt(c) != 'X') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean inRange(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
}
