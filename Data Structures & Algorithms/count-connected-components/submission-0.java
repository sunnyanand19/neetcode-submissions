class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int component = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(adj, i, visited);
                component++;
            }
        }
        return component;
    }
    private void dfs(List<Integer>[] adj, int u, boolean[] visited){
        visited[u] = true;
        for(int v: adj[u]){
            if(!visited[v]){
                dfs(adj, v, visited);
            }
        }
    }
}
