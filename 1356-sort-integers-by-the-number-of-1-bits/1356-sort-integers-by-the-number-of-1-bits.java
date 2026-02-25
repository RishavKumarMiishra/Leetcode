class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] tempArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        Arrays.sort(tempArr, (a, b) -> {
            if (Integer.bitCount(b) != Integer.bitCount(a)) {
                return Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
            } else {
                return Integer.compare(a, b);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)tempArr[i];
        }
        return arr;
    }
}