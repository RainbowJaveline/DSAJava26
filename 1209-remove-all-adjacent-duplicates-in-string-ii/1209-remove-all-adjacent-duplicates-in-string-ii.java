class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek()[0] == ch) {

                stack.peek()[1]++;

                if (stack.peek()[1] == k) {
                    stack.pop();
                }

            } else {

                stack.push(new int[]{ch, 1});
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();

            for (int i = 0; i < pair[1]; i++) {
                ans.append((char) pair[0]);
            }
        }

        return ans.reverse().toString();
    }

}

       // HashMap<Character , Integer> map = new HashMap<>();
        // StringBuilder str = new StringBuilder();
        // Stack<Character> stack = new Stack<>();
        // int min = 1;
        // for(int i=0 ; i<s.length() ; i++){
        //     char ch = s.charAt(i);
        //     if(stack.peek() == ch){
        //         min++;
        //     }
        //     if(min == k){
        //         while(!stack.isEmpty() && k != 0 ){
        //             stack.pop();
        //             k--;
        //         }   
        //         k = 1;
        //     }
        //     // char ch = s.charAt(i);
        //     // map.put(ch , map.getOrDefault(ch , 0) + 1);
        //     // stack.push(ch);
        //     // if(map.get(ch) == k){
        //     //     while(map.get(ch) != 0){
        //     //         stack.pop();
        //     //         map.put(ch , map.get(ch)-1);
        //     //     }
        //     //     // map.remove(ch);
        //     // }
        //     // int min = 1;
        //     // 
        //     // while(!stack.isEmpty() && stack.top == ch){
        //     //     min++;
        //     // }
        //     // if(min == k){
        //     //     stack.pop();
        //     // }else{
        //     //     stack.push(ch);
        //     // }
        // }

        // while(!stack.isEmpty()){
        //     str.append(stack.peek());
        //     stack.pop();
        // }
        // return str.reverse().toString();