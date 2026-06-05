class Solution {
    public String interpret(String command) {
        String goal = command.replace("()" , "o");
        String newGoal = goal.replace("(al)" , "al");
        return newGoal;
    }
}