class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
         for (int cur : asteroids) {
            boolean alive = true;
            while (alive && cur < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -cur) {
                    stack.pop();          // top destroyed, keep checking below it
                } else if (top == -cur) {
                    stack.pop();          // both destroyed
                    alive = false;
                } else {
                    alive = false;        // current one destroyed
                }
            }
            if (alive) stack.push(cur);
        }
        // for(int i=0 ; i< asteroids.length ; i++){
        //     if(asteroids[i] > 0){
        //         stack.push(asteroids[i]);
        //     }
        //     else if(!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])){
        //         stack.pop();
        //         continue;
        //     }

        //     while(!stack.isEmpty() && stack.peek() < Math.abs(asteroids[i])){
        //         stack.pop();
        //     }
        //     if(stack.isEmpty()){
        //         stack.push(asteroids[i]);
        //     }
            
        // }
        int[] arr = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            arr[i] = stack.pop();
            i--;
        }
        return arr;   
    }
}