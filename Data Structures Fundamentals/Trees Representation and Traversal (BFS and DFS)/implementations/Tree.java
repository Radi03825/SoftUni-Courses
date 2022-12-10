package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
    public List<E> orderBfs() {
        ArrayList<E> result = new ArrayList<>();

        if (this.key == null) {
            return result;
        }

        ArrayDeque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (queue.size() > 0) {
            Tree<E> current = queue.poll();
            result.add(current.key);

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }

        }

        return result;
    }

    @Override
    public List<E> orderDfs() {
        ArrayList<E> result = new ArrayList<>();
        this.dfs(this, result);

        return result;
    }

    private void dfs(Tree<E> tree, ArrayList<E> result) {
        for (Tree<E> child : tree.children) {
            this.dfs(child, result);
        }

        result.add(tree.key);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> tree = find(this, parentKey);

        if (tree == null) {
            throw new IllegalArgumentException();
        }

        tree.children.add(child);
        child.parent = tree;
    }

    private Tree<E> find(Tree<E> current, E parentKey) {
        if (current.key.equals(parentKey)) {
            return current;
        }

        for (Tree<E> child : current.children) {
            Tree<E> found = this.find(child, parentKey);

            if (found != null) {
                return found;
            }
        }

        return null;
    }

    private Tree<E> findBfs(E key) {
        ArrayDeque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (queue.size() > 0) {
            Tree<E> current = queue.poll();

            if(current.key == key) {
                return current;
            }

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }

        }

        return null;
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> toRemove = find(this, nodeKey);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        for (Tree<E> child : toRemove.children) {
            child.parent = null;
        }

        toRemove.children.clear();
        Tree<E> parent = toRemove.parent;

        if (parent != null) {
            parent.children.remove(toRemove);
        }

        toRemove.key = null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = findBfs(firstKey);
        Tree<E> secondNode = findBfs(secondKey);

        if (firstNode == null || secondNode == null) {
            throw new IllegalArgumentException();
        }

        Tree<E> firstParent = firstNode.parent;
        Tree<E> secondParent = secondNode.parent;

        if (firstParent == null) {
            swapRoot(secondNode);
            return;
        } else if (secondParent == null) {
            swapRoot(firstNode);
            return;
        }

        firstNode.parent = secondParent;
        secondNode.parent = firstParent;
        int firstIndex = firstParent.children.indexOf(firstNode);
        int secondIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstIndex, secondNode);
        secondParent.children.set(secondIndex, firstNode);
    }

    private void swapRoot(Tree<E> node) {
        this.key = node.key;
        this.parent = null;
        this.children = node.children;
        node.parent = null;
    }
}



