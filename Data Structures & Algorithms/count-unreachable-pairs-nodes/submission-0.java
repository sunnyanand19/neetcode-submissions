class Solution {

    private int find(int i, int[] parent){
        if(i == parent[i]){
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
    private void union(int x, int y, int[] parent, int[] rank){
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        if(x_parent == y_parent){
            return;
        }
        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, rank);
        }
        Map<Integer, Integer> componentsSize = new HashMap<>();
        for(int i = 0; i < n; i++){
            int component = find(i, parent);
            componentsSize.merge(component, 1, Integer::sum);
        }
        long result = 0;
        long remainingNodes = n;
        for(int size: componentsSize.values()){
            result += size * (remainingNodes - size);
            remainingNodes -= size;
        }
        return result;
    }
}