class FreqStack {
    private Map<Integer, Integer> cnt;
    private Map<Integer, Stack<Integer>> stacks;
    private int maxCnt;

    public FreqStack() {
        cnt = new HashMap<>();
        stacks = new HashMap<>();
        maxCnt = 0;
    }
    
    public void push(int val) {
        //increment the frequency count
        int valCnt = cnt.getOrDefault(val, 0) + 1;
        cnt.put(val, valCnt);
        if(valCnt > maxCnt){
            maxCnt = valCnt;
            stacks.putIfAbsent(valCnt, new Stack<>());
        }
        stacks.get(valCnt).push(val);
    }
    
    public int pop() {
        //remove the highest freq element
        int res = stacks.get(maxCnt).pop();
        cnt.put(res, cnt.get(res) - 1); //decrement its freq count
        if(stacks.get(maxCnt).isEmpty()){
            maxCnt--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */