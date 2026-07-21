class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer , Integer> map = new HashMap<>();
       List<Integer>[] bucket = new List[nums.length + 1]; 
       for(int i : nums){
        map.put(i , map.getOrDefault(i , 0)+1);
       }
       //traverse in the hashMap
       for(int key : map.keySet()){
        int freq = map.get(key);
        if(bucket[freq] == null){
            bucket[freq] = new ArrayList();
        }
        bucket[freq].add(key);
       }
       int[] res = new int[k];
       int count = 0;
       for(int pos = nums.length; pos>=0 && count < k ; pos--){
        if(bucket[pos] != null){
            for(Integer integer : bucket[pos]){
                res[count++] = integer;
            }
        }
       }
       return res;
    }
}