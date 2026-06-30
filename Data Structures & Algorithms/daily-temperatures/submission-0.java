class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= stack.peek()[0]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = 0;
            }else {
                res[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}