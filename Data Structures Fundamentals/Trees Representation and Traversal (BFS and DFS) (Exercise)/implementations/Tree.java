package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key, Tree<E>... children) {
        this.key = key;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.key).append(System.lineSeparator());
        int spaceCount = 0;
        createTreeAsString(this, builder, spaceCount);

        return builder.toString().trim();
    }

    private void createTreeAsString(Tree<E> tree, StringBuilder builder, int spaceCount) {
        spaceCount += 2;

        for (Tree<E> child : tree.children) {
            builder.append(returnSpaces(spaceCount))
                    .append(child.key)
                    .append(System.lineSeparator());

            if (child.children.size() > 0) {
                createTreeAsString(child, builder, spaceCount);
            }
        }
    }

    private String returnSpaces(int spaceCount) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < spaceCount; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    @Override
    public List<E> getLeafKeys() {
        ArrayList<Tree<E>> leafs = new ArrayList<>();
        getLeafs(this, leafs);

        ArrayList<E> result = new ArrayList<>();
        leafs.forEach(l -> result.add(l.getKey()));

        return result;
    }

    private void getLeafs(Tree<E> tree, ArrayList<Tree<E>> leafs) {
        for (Tree<E> child : tree.children) {
            if (child.children.size() > 0) {
                getLeafs(child, leafs);
            } else {
                leafs.add(child);
            }
        }
    }

    @Override
    public List<E> getMiddleKeys() {
        ArrayList<E> middleKeys = new ArrayList<>();
        getMiddleElements(this, middleKeys);
        return middleKeys;
    }

    private void getMiddleElements(Tree<E> tree, ArrayList<E> middleKeys) {
        for (Tree<E> child : tree.children) {
            if (child.parent != null && child.children.size() > 0) {
                middleKeys.add(child.getKey());
            }
            if (child.children.size() > 0) {
                getMiddleElements(child, middleKeys);
            }
        }
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        ArrayList<Tree<E>> leafs = new ArrayList<>();
        getLeafs(this, leafs);

        Tree<E> deepestNode = null;
        int maxEdgeCount = 0;
        for (Tree<E> leaf : leafs) {
            int currentEdgeCount = countEdges(leaf);
            if (currentEdgeCount > maxEdgeCount) {
                deepestNode = leaf;
                maxEdgeCount = currentEdgeCount;
            }
        }

        return deepestNode;
    }

    private int countEdges(Tree<E> node) {
        int counter = 0;
        while (node.parent != null) {
            node = node.parent;
            counter++;
        }

        return counter;
    }

    @Override
    public List<E> getLongestPath() {
        ArrayList<E> list = new ArrayList<>();
        Tree<E> deepestLeftmostNode = getDeepestLeftmostNode();

        while (deepestLeftmostNode != null) {
            list.add(deepestLeftmostNode.getKey());
            deepestLeftmostNode = deepestLeftmostNode.parent;
        }

        Collections.reverse(list);

        return list;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        ArrayList<Tree<E>> leafs = new ArrayList<>();
        getLeafs(this, leafs);

        ArrayList<List<E>> lists = new ArrayList<>();

        for (Tree<E> leaf : leafs) {
            int currentSum = 0;
            ArrayList<E> currentList = new ArrayList<>();
            while (leaf != null) {
                currentSum += (int) leaf.getKey();
                currentList.add(leaf.getKey());
                leaf = leaf.parent;
            }

            if (currentSum == sum) {
                Collections.reverse(currentList);
                lists.add(currentList);
            }
        }

        return lists;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return findParentsOfNodesWithEqualSum(sum);
    }

    private List<Tree<E>> findParentsOfNodesWithEqualSum(int sum) {
        ArrayList<Tree<E>> parents = new ArrayList<>();

        ArrayDeque<Tree<E>> trees = new ArrayDeque<>();
        trees.offer(this);

        int currentSum = 0;

        while (trees.size() > 0) {
            Tree<E> currentParent = trees.poll();

            currentSum = (int) currentParent.getKey();

            currentSum = getCurrentSum(trees, currentSum, currentParent);

            if (currentSum == sum) {
                parents.add(currentParent);
            }
        }

        return parents;
    }

    private int getCurrentSum(ArrayDeque<Tree<E>> trees, int currentSum, Tree<E> currentParent) {
        for (Tree<E> child : currentParent.children) {
            currentSum += (int) child.getKey();
            if (!trees.contains(child)) {
                trees.offer(child);
                System.out.println(child.key);
            }
            if (child.children.size() > 0) {
                currentSum += getCurrentSum(trees, 0, child);
            }
        }
        return currentSum;
    }

}