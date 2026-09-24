class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
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
        boolean[] visited = new boolean[n];
        if(hasCycle(0, -1, adj, visited)){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int u, int parent, 
                        List<Integer>[] adj, boolean[] visited){
        visited[u] = true;
        for(int v: adj[u]){
            if(!visited[v]){
                if(hasCycle(v, u, adj, visited)){
                    return true;
                }
            }else if(v != parent){
                return true;
            }
        }
        return false;
    }
}