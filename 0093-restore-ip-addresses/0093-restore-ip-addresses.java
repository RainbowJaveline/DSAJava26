class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        if(s.length()<4 || s.length() > 12){
            return answer;
        }
        helper(answer , s , 0 , new StringBuilder() , 0);
        return answer;
    }
    static void helper(List<String> answer , String s , int idx , StringBuilder newS , int dots){
        if(idx == s.length() && dots==4){
            answer.add(newS.toString());
            return;
        }

        for(int i= idx ; i<s.length() && i<idx+3 ; i++){
            String part = s.substring(idx , i+1);
            if(isValid(part)){
                int len = newS.length();
                newS.append(part);
                if(dots<3){
                    newS.append(".");
                }
                helper(answer , s , i+1 , newS , dots + 1);
                newS.setLength(len);
            }
        }
    }

    static boolean isValid(String str){
        if(str.length() > 1 && str.startsWith("0")){
            return false;
        };
        int partNum = Integer.parseInt(str);
        return partNum >= 0 && partNum <= 255;
    }
}