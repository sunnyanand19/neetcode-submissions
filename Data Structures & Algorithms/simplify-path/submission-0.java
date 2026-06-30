class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for(String currPath: paths){
            if(currPath.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!currPath.equals("") && !currPath.equals(".")){
                stack.push(currPath);
            }
        }
        return "/" + String.join("/", stack);
    }
}