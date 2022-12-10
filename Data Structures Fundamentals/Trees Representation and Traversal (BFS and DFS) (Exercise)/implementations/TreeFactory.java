package implementations;

import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private Map<Integer, Tree<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    public Tree<Integer> createTreeFromStrings(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String[] split = input[i].split("\\s+");
            int firstNumber = Integer.parseInt(split[0]);
            int secondNumber = Integer.parseInt(split[1]);

            addEdge(firstNumber, secondNumber);
        }

        return getRoot();
    }

    private Tree<Integer> getRoot() {
        for (Tree<Integer> tree : nodesByKeys.values()) {
            if (tree.getParent() == null) {
                return tree;
            }
        }

        return null;
    }

    public Tree<Integer> createNodeByKey(int key) {
        this.nodesByKeys.putIfAbsent(key, new Tree<>(key));
        return this.nodesByKeys.get(key);
    }

    public void addEdge(int parent, int child) {
        Tree<Integer> parentTree = this.createNodeByKey(parent);
        Tree<Integer> childTree = this.createNodeByKey(child);

        childTree.setParent(parentTree);
        parentTree.addChild(childTree);
    }
}



