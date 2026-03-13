class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long ans = 0;
        long l = 1;
        long r = (long)1e18;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (findPossible(mountainHeight, workerTimes, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean findPossible(int height, int[] workerTimes, long time) {
        long totalHeight = 0;

        for (int t : workerTimes) {
            totalHeight += reduceHeight(time, t);
            if (totalHeight >= height) return true;
        }

        return false;
    }

    public int reduceHeight(long time, int workerTime) {
        long val = (2 * time) / workerTime;
        int k = (int)((Math.sqrt(1 + 4 * val) - 1) / 2);
        return k;
    }
}