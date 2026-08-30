class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for(int i = 0 ; i<temp.length ; i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        HashMap<Integer , Integer> map =  new HashMap<>();
        int idx = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(i > 0 && temp[i] == temp[i-1]){
                continue;
            }
            map.put(temp[i] , ++idx);
        }
        int[] ans = new int[temp.length];
        for(int i= 0 ; i<arr.length ; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}