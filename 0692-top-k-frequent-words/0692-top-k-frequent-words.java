class Solution {
    class Pairs{
        int freq;
        String word;
        Pairs(int freq , String word){
            this.freq = freq;
            this.word = word;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Pairs> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq != b.freq){
                    return a.freq-b.freq;
                }
                return (b.word).compareTo(a.word);
            }
        );

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            Pairs curr = new Pairs(entry.getValue() , entry.getKey());
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }

            if(curr.freq > pq.peek().freq ||
   (curr.freq == pq.peek().freq &&
    curr.word.compareTo(pq.peek().word) < 0)){
                pq.poll();
                pq.add(curr);    
            }
            
        }

        List<String> list = new ArrayList<>();
        for(int i=0 ; i<k;i++){
            list.add(pq.peek().word);
            pq.poll();
        }
        return list.reversed();

    }
}