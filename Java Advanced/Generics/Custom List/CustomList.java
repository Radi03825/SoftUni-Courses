import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        return this.list.remove(index);
    }

    public boolean contains(T element){
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex){
        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element){
        return (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax(){
        return Collections.max(list);
    }

    public T getMin(){
        return Collections.min(list);
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T t : list) {
            sb.append(t);
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    public void sort(){
        Collections.sort(list);
    }
}