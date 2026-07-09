class Solution {
    public int maximumSum(int[] arr) {
       int noDel = arr[0];
       int oneDel = Integer.MIN_VALUE;
       int res = arr[0];
       for(int i = 1 ; i<arr.length ; i++){
        int prevNoDel = noDel;
        int prevOneDel = oneDel;
        noDel = Math.max(arr[i] , (noDel+arr[i]));
        int v1;
        if(prevOneDel == Integer.MIN_VALUE){
            v1 = arr[i];
        }else{
            v1 = prevOneDel + arr[i];
        }
        oneDel = Math.max(v1 , prevNoDel);

        res = Math.max(res , Math.max(noDel , oneDel));
       }

       return res; 
    }
}