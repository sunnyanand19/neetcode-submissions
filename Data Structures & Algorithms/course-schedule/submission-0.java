class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] p: prerequisites){
            int course = p[0];
            int prerequisite = p[1];
            graph[course].add(prerequisite);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inCurDFS = new boolean[numCourses];
        for(int course = 0; course < numCourses; course++){
            if(!dfs(course, graph, visited, inCurDFS)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<Integer>[] graph, boolean[] visited, boolean[] inCurDFS){
        if(inCurDFS[course]){
            return false; //cycle detected
        }
        if(visited[course]){
            return true; //already processed
        }
        inCurDFS[course] = true;
        for(int prerequisite: graph[course]){
            if(!dfs(prerequisite, graph, visited, inCurDFS)){
                return false;
            }
        }
        inCurDFS[course] = false;
        visited[course] = true;

        return true;
    }
}