import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        
        parent = new int[n + 1];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        Set<Integer> networks = new HashSet<>();
        for(int i = 0; i < n; i++){
            networks.add(find(i));
        }
        
        return networks.size();
    }
    
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
    
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}