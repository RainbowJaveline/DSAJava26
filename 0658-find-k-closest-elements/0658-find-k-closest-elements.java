class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0 ; i<k ; i++){
            pq.add(arr[i]);
        }

        for(int i =k ; i<arr.length ; i++){
            int diff1 = Math.abs(pq.peek() - x);
            int diff2 = Math.abs(arr[i]-x);
            if(diff2 < diff1){
                pq.poll();
                pq.add(arr[i]);
            }else if ((diff1 == diff2) && pq.peek() > arr[i] ){
                pq.poll();
                pq.add(arr[i]);
            }else{
                continue;
            } 
        }
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        //Collections.reverse(list);    
        return list;
    }
}