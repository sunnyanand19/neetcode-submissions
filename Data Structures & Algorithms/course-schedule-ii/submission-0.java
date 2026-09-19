class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> result = new ArrayList<>();
        for(int course = 0; course < numCourses; course++){
            if(!dfs(course, graph, visited, inCurDFS, result)){
                return new int[0];
            }
        }
        int[] output = new int[numCourses];
        for(int res = 0; res < numCourses; res++){
            output[res] = result.get(res);
        }
        return output;
    }

    private boolean dfs(int course, List<Integer>[] graph, boolean[] visited,      boolean[] inCurDFS, List<Integer> result){
        if(inCurDFS[course]){
            return false;
        }
        if(visited[course]){
            return true;
        }
        inCurDFS[course] = true;
        for(int prerequisite: graph[course]){
            if(!dfs(prerequisite, graph, visited, inCurDFS, result)){
                return false;
            }
        }
        inCurDFS[course] = false;
        visited[course] = true;
        result.add(course);
        return true;
    }
}