class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        Set<String> obs = new HashSet<>();
        for (int[] curr : obstacles) {
            obs.add(curr[0] + "," + curr[1]);
        }

        int[] dx = {0, -1, 0, 1}; 
        int[] dy = {1, 0, -1, 0};
        int dir = 0; 
        int x = 0, y = 0;
        int ans = 0;

        for (int curr : commands) {
            if (curr == -2) { 
                dir = (dir + 1) % 4;
            } else if (curr == -1) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < curr; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (!obs.contains(nx + "," + ny)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    } 
                }
            }
        }

        return ans;
    }
}