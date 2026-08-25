class Pairs{
        int num;
        int freq;

        public Pairs(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
class Solution {
    public int[] frequencySort(int[] nums) {
         HashMap<Integer,Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            Pairs[] arr = new Pairs[map.size()];
            int idx = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                Pairs curr = new Pairs(entry.getKey(),entry.getValue());
                arr[idx++] = curr;
            }

            Arrays.sort(arr , (a,b)-> {
                if(a.freq != b.freq){
                    return a.freq-b.freq;
                }

                return b.num - a.num;
            });

            int[] ans = new int[nums.length];
            int index = 0;
            idx= 0;
            while(index != ans.length){
                int freq = arr[idx].freq;
                while(freq!=0){
                  ans[index++] = arr[idx].num;
                  freq--;
                }
                idx++;
            }

            return ans;

    }
}
