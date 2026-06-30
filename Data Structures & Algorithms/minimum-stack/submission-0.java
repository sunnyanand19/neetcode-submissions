class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();    
    }
    
    public void push(int val) {
        int min = val;
        if(!minStack.isEmpty()){
            if(min > minStack.peek()){
                min = minStack.peek();
            }
        }
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
