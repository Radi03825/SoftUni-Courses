package main;

import java.util.*;
import java.util.stream.Collectors;

public class Hierarchy<T> implements IHierarchy<T> {
    private Map<T, HierarchyNode<T>> data;
    private HierarchyNode<T> root;

    public Hierarchy(T element) {
        this.data = new HashMap<>();

        HierarchyNode<T> root = new HierarchyNode<>(element);
        this.root = root;
        this.data.put(element, root);
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public void add(T element, T child) {
        HierarchyNode<T> parent = this.data.get(element);

        ensureExists(parent);

        if (this.contains(child)) {
            throw new IllegalArgumentException();
        }

        HierarchyNode<T> toBeAdded = new HierarchyNode<>(child);
        toBeAdded.setParent(parent);
        parent.getChildren().add(toBeAdded);

        this.data.put(child, toBeAdded);
    }

    @Override
    public void remove(T element) {
        HierarchyNode<T> toRemove = this.data.get(element);

        ensureExists(toRemove);

        HierarchyNode<T> parent = toRemove.getParent();

        if (parent == null) {
            throw new IllegalStateException();
        }

        List<HierarchyNode<T>> children = toRemove.getChildren();
        children.forEach(c -> c.setParent(parent));

        parent.getChildren().addAll(children);
        parent.getChildren().remove(toRemove);

        this.data.remove(toRemove.getValue());
    }

    @Override
    public Iterable<T> getChildren(T element) {
        HierarchyNode<T> current = this.data.get(element);

        ensureExists(current);

        return current.getChildren().stream().map(n -> n.getValue()).collect(Collectors.toList());
    }

    @Override
    public T getParent(T element) {
        HierarchyNode<T> current = this.data.get(element);

        ensureExists(current);

        HierarchyNode<T> parent = current.getParent();

        return parent == null ? null : parent.getValue();
    }

    @Override
    public boolean contains(T element) {
        return this.data.containsKey(element);
    }

    @Override
    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        ArrayList<T> result = new ArrayList<>();

        this.data.keySet().forEach(k -> {
            if (other.contains(k)) {
                result.add(k);
            }
        });

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Deque<HierarchyNode<T>> deque = new ArrayDeque<>(
                    Collections.singletonList(root)
            );

            @Override
            public boolean hasNext() {
                return deque.size() > 0;
            }

            @Override
            public T next() {
                HierarchyNode<T> nextElement = deque.poll();
                deque.addAll(nextElement.getChildren());
                return nextElement.getValue();
            }
        };
    }

    private void ensureExists(HierarchyNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
    }
}
