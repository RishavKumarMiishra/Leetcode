class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> c = new HashSet<>();
        for (Integer b: bulbs) {
            if (c.contains(b)) {
                c.remove(b);
            } else {
                c.add(b);
            }
        }

        for (Integer b: c) {
            ans.add(b);
        }
        Collections.sort(ans);
        return ans;
    }
}