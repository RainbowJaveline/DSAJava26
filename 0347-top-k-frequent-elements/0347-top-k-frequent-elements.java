class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pairs> pq = new PriorityQueue<>(
            (a,b) -> {
            if(a.freq != b.freq){
                return a.freq - b.freq;
            }
            return a.num-b.num;
            }
        );
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pairs curr = new Pairs(entry.getValue() , entry.getKey());
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }

            if(curr.freq < pq.peek().freq){
                continue;
            }
            pq.poll();
            pq.add(curr);
        }
        
        int[] answer = new int[k];
        for(int i= 0 ; i<answer.length ; i++){
            answer[i] = pq.peek().num;
            pq.poll();
        }

        return answer;
    }
    class Pairs{
        int freq;
        int num;
        Pairs(int freq , int num){
            this.freq = freq;
            this.num = num;
        }
    }
}