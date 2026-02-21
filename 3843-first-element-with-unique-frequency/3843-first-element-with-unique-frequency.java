class Solution {
    public int firstUniqueFreq(int[] nums) {
        LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
        for (int i: nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        
        LinkedHashMap<Integer, Integer> l = new LinkedHashMap<>();
        Set<Integer> s = new HashSet<>();
        for (Map.Entry<Integer, Integer> e: m.entrySet()) {
            int num = e.getKey();
            int f = e.getValue();

            if (s.contains(f)) {
                l.remove(f);
            } else if (!s.contains(f)){
                l.put(f, num);
            }
            s.add(f);
        }
        if (l.isEmpty()) return -1;
        Iterator<Map.Entry<Integer, Integer>> iterator = l.entrySet().iterator();
        int x = iterator.next().getValue();
        System.out.println(x);
        return x;
    }
}                     