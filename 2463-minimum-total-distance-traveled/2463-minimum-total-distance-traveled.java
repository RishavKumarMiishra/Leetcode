class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f: factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }
        long[][] dp = new long[robot.size()][factoryPositions.size()];
        for (int i = 0; i < robot.size(); i++) {
            Arrays.fill(dp[i], -1);
        }


        return calculateMinDistance(0, 0, robot, factoryPositions, dp);
    }

    private long calculateMinDistance(int robotIdx, int factoryIdx, List<Integer> robot, List<Integer> factoryPositions, long[][] dp) {
        if (robotIdx == robot.size()) return 0;

        if (factoryIdx == factoryPositions.size()) return (long) 1e12;
        
        if (dp[robotIdx][factoryIdx] != -1) return dp[robotIdx][factoryIdx];
        long assign = Math.abs(robot.get(robotIdx) - factoryPositions.get(factoryIdx)) + calculateMinDistance(
            robotIdx + 1,
            factoryIdx + 1,
            robot,
            factoryPositions,
            dp
        );

        long skip = calculateMinDistance(robotIdx, factoryIdx+1, robot, factoryPositions, dp);

        return dp[robotIdx][factoryIdx] = Math.min(assign, skip);
    }
}