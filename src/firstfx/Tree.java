/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfx;

import java.util.Arrays;

/**
 *
 * @author ahcl
 */
public class Tree {
    private int numsOfNode;
    private int[] height;
    
    private void visit (int u, boolean[] visited, int[] height, int n) {
        visited[u] = true;
        int parent = u + (u & - u);
        if (parent > n) {
            height[u] = 0;
            return;
        }
        if (!visited[parent]) {
            visit(parent, visited, height, n);
        }
        height[u] = height[parent] + 1;
    }
    
    public void buildTree() {
        boolean[] visited = new boolean[this.numsOfNode + 1];
        Arrays.fill(visited, false);
        height = new int[this.numsOfNode + 1];
        for(int i=1;i<=this.numsOfNode;i++) {
            if (!visited[i]) {
                visit(i, visited, height,  this.numsOfNode);
            }
        }
    }
    
    public Tree (int n) {
        this.numsOfNode = n;
    }
    
    public int getHeight(int node) {
        return height[node];
    }
}
