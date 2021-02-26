class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 1)
            return 0;
        Trie root = new Trie();
        //Build trie for all numbers
        for(int num : nums){
            Trie curr = root;

            for(int i = 31; i >= 0; i--){
                int curBit = (num >>> i) & 1;
                if(curr.children[curBit] == null){
                    curr.children[curBit] = new Trie();
                }
                curr = curr.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums ){
            //    System.out.println( "num="+ num);
            Trie curr = root;
            int curXor = 0;
            for(int i = 31; i >= 0; i--){
                int currBit = (num >>> i) & 1 ;
                if(curr.children[currBit ^ 1] != null){
                    //          System.out.println( curXor + "  " + (i << i));
                    curXor +=  (1 << i);
                    curr = curr.children[ currBit ^ 1];
                } else {
                    curr = curr.children[ currBit];
                }
            }
            max = Math.max(max, curXor);
        }
        return max ;
    }
}
class Trie{
    Trie[] children = new Trie[2];
}