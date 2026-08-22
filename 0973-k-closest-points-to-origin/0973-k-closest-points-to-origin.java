class Solution {
    class Pairs{
        double dist;
        int idx;
        Pairs(double dist , int idx){
            this.dist = dist;
            this.idx= idx;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pairs> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.dist != b.dist){
                    return Double.compare(b.dist , a.dist);
                }

                return a.idx - b.idx ;
            }
        );
        
        for(int i=0 ; i<points.length ; i++){
            double x = points[i][0];
            double y = points[i][1];
            double distance = Math.sqrt(x * x + y * y);
            Pairs curr = new Pairs(distance , i);
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }
            
            if(curr.dist < pq.peek().dist){
                pq.poll();
                pq.add(curr);
            }
        }

        int[][] ans = new int[k][2];
        for(int i=0 ; i<k ; i++){
            if(!pq.isEmpty()){
                ans[i] = points[pq.poll().idx];
            }
        }
        return ans;
    }
}