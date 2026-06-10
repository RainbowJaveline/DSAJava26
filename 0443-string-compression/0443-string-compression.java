class Solution {
    public int compress(char[] chars) {
    int write = 0;
    int read = 0;
    int n = chars.length;
    while(read < n){
    char current = chars[read];
    int count = 0;
    while(read < n && chars[read] == current){
        read++;
        count++;
    }
    chars[write++] = current;
    if(count > 1){
        String s = String.valueOf(count);

        for(char ch : s.toCharArray()){
            chars[write++] = ch;
            }
        }
    }
    return write;
        
    }
}