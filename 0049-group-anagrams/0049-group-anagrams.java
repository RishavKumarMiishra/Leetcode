class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String x = new String(c);
            if (!m.containsKey(x)) {
                m.put(x, new ArrayList<>());
            }
            m.get(x).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: m.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}