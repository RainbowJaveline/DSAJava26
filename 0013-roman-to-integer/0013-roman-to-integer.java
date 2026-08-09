class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer > map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        int ans = 0;
        char prev = s.charAt(s.length()-1);
        ans += map.get(prev);
        for (int i = s.length()-2; i >= 0; i--) {
            char current = s.charAt(i);
            if(map.get(current) < map.get(prev)){
                ans -=  map.get(current);
            }else{
                ans += map.get(current);
            }
            prev = s.charAt(i);
        }

        return ans;
    }
}