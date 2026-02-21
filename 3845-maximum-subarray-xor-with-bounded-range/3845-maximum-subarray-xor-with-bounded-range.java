class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];

        int count = 0;
    }

    class Trie {

        TrieNode root = new TrieNode();

        public void insert(int num) {
            TrieNode current = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num>>i)&1;
                if (current.child[bit] == null) {
                    current.child[bit] = new TrieNode();
                }
                current = current.child[bit];
                current.count++;
            }
        }

        public void remove(int num) {
            TrieNode node = root;

            for (int i=31; i >= 0 ; i--) {
                int bit = (num>>i)&1;
                node = node.child[bit];
                node.count--;
            }
        }

        public int maxXor(int num) {
            TrieNode node = root;
            int result = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int want = 1-bit;
                if (node.child[want] != null && node.child[want].count > 0) {
                    result |= (1 << i);
                    node = node.child[want];
                } else {
                    node = node.child[bit];
                }
            }

            return result;
        }
    }
    public int maxXor(int[] nums, int k) {
        List<Integer> max = new LinkedList<>();
        List<Integer> min = new LinkedList<>();
        int size = nums.length;
        int[] prefix = new int[size+1];
        int left = 0;
        int result = 0;

        Trie trie = new Trie();
        trie.insert(0);

        for (int right = 0; right < size; right++) {
            prefix[right+1] = prefix[right] ^ nums[right];

            while (max.size() != 0 && nums[max.getLast()] < nums[right]) {
                max.removeLast();
            }

            while (min.size() != 0 && nums[min.getLast()] > nums[right]) {
                min.removeLast();
            }
            
            max.addLast(right);
            min.addLast(right);

            while (nums[max.getFirst()] - nums[min.getFirst()] > k) {
                if (left == max.getFirst()) max.removeFirst();
                if (left == min.getFirst()) min.removeFirst();
                trie.remove(prefix[left]);
                left++;
            }  

            result = Math.max(result, trie.maxXor(prefix[right + 1]));
            trie.insert(prefix[right + 1]);       
        }

         return result;
    }
}