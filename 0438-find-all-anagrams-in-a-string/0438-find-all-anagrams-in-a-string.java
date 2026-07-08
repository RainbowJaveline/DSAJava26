class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0;
        int start = 0;
        List<Integer> ans = new ArrayList<>();
        HashMap<Character , Integer> needed = new HashMap<>();
        HashMap<Character , Integer> formed = new HashMap<>();
        for(int i = 0 ; i<p.length();i++){
            needed.put(p.charAt(i) , needed.getOrDefault(p.charAt(i),0)+1);
        }
        for(int h = 0 ; h < s.length() ; h++){
            formed.put(s.charAt(h), formed.getOrDefault(s.charAt(h),0)+1);
            if(h-l+1 == p.length()){
                if(formed.equals(needed)) ans.add(l);
                formed.put(s.charAt(l) , formed.get(s.charAt(l))-1);
                if(formed.get(s.charAt(l)) == 0 ){
                    formed.remove(s.charAt(l));
                }
                l++;
            }

        }
        return ans;
    }
}