/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktreevisualization.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.scene.Group;

/**
 * @author ahcl
 */
public class FenWickTree extends Group {
    private int root;
    private int numberOfNode;
    private List<Integer> heights;
    private List<Integer> parents;
    private List<Integer> values;

    public FenWickTree(int numberOfNode) {
        this.root = 0;
        this.numberOfNode = numberOfNode;
        this.heights = new ArrayList<>(Collections.nCopies(numberOfNode + 1, 0));
        this.parents = new ArrayList<>(Collections.nCopies(numberOfNode + 1, -1));
        this.values = new ArrayList<>(Collections.nCopies(numberOfNode + 1, 0));
//        randomGenerateValues(1, 10);
    }

    public FenWickTree(List<Integer> values) {
        this.root = 0;
        this.numberOfNode = values.size();
        this.heights = new ArrayList<>(Collections.nCopies(numberOfNode + 1, 0));
        this.parents = new ArrayList<>(Collections.nCopies(numberOfNode + 1, -1));
        this.values = values;
    }

    public void randomGenerateValues(int from, int to) {
        if (this.values == null) this.values = new ArrayList<>();
        else this.values.clear();
        Random random = new Random();
        for (int i = 0; i < numberOfNode + 1; i++) {
            this.values.add(from + random.nextInt(to - from));
        }
    }

    private boolean findChilds(int index, int target, List<Boolean> visited, List<Boolean> isChilds, List<Integer> childs) {
        if (index == this.root) return false;
        visited.set(index, true);
        if (index == target) {
            childs.add(index);
            isChilds.set(index, true);
            return true;
        }
        int parent = this.parents.get(index);
        if (!visited.get(parent)) findChilds(parent, target, visited, isChilds, childs);
        if (isChilds.get(parent)) {
            childs.add(index);
            isChilds.set(index, true);
            return true;
        } else return false;
    }

    public List<Integer> getAllChild(int target) {
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(numberOfNode + 1, false));
        List<Integer> childs = new ArrayList<>();
        List<Boolean> isChilds = new ArrayList<>(Collections.nCopies(numberOfNode + 1, false));
        for (int i = 1; i <= numberOfNode; i++) {
            if (!visited.get(i)) {
                findChilds(i, target, visited, isChilds, childs);
            }
        }
        return childs;
    }

    public List<UpdateNodeStatus> getUpdateStepList (int index, int value) {
        List<UpdateNodeStatus> result = new ArrayList<>();
        while (index != this.root) {
            int newValue = this.values.get(index) + value;
            result.add(new UpdateNodeStatus(index, newValue));
            this.values.set(index, newValue);
            index = this.parents.get(index);
        }
        return result;
    }

    public List<GetNodeStatus> getGetStepList (int index) {
        List<GetNodeStatus> result = new ArrayList<>();
        int currentValue = 0;
        while (index != 0) {
            currentValue += this.values.get(index);
            result.add(new GetNodeStatus(index, currentValue));
            index -= (index & -index);
        }
        return result;
    }

    public int getParent(int index) {
        return this.parents.get(index);
    }

    private void dfs(int u, int numberOfNode, List<Boolean> visited) {
        if (visited.get(u)) {
            return;
        }
        visited.set(u, true);
        if (u == this.root) {
            return;
        }

        int parent = u + (u & -u);
        if (parent > numberOfNode) parent = this.root;
        dfs(parent, numberOfNode, visited);
        heights.set(u, heights.get(parent) + 1);
        parents.set(u, parent);
    }

    public int get(int u) {
        return 0;
    }

    public int getValue(int u) {
        return this.values.get(u);
    }


    public void buildTree() {
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(numberOfNode + 1, false));
        for (int i = 1; i <= numberOfNode; i++) {
            if (!visited.get(i)) {
                dfs(i, numberOfNode, visited);
            }
        }
    }

    public int getHeight(int index) {
        return heights.get(index);
    }

    public int getMaxHeight() {
        int res = 0;
        for (int x : heights) res = Math.max(res, x);
        return res;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getNumberOfNode() {
        return numberOfNode;
    }

    public void setNumberOfNode(int numberOfNode) {
        this.numberOfNode = numberOfNode;
    }

    public List<Integer> getHeights() {
        return heights;
    }

    public void setHeights(List<Integer> heights) {
        this.heights = heights;
    }

    public List<Integer> getParents() {
        return parents;
    }

    public void setParents(List<Integer> parents) {
        this.parents = parents;
    }
}
