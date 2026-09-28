class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            boolean[] visited = new boolean[n+1];
            //if u and v are already connected, this edge is redundant
            if(dfs(adj, u, v, visited)){
                return edge;
            }
            adj[u].add(v);
            adj[v].add(u);
        }
        return new int[0];
    }

    private boolean dfs(List<Integer>[] adj, int src, int target, boolean[] visited){
        //Have we found a path from the starting node to the target node
        if(src == target){
            return true;
        }
        visited[src] = true;
        for(int nei: adj[src]){
            if(!visited[nei] && dfs(adj, nei, target, visited)){
                return true;
            }
        }
        return false;
    }
}