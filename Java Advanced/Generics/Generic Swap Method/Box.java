import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) throws Exception {
        checkIndex(firstIndex, secondIndex);
        T firstElement = elements.get(firstIndex);
        T secondElement = elements.get(secondIndex);

        elements.set(firstIndex, secondElement);
        elements.set(secondIndex, firstElement);
    }

    private void checkIndex(int firstIndex, int secondIndex) throws Exception {
        if (firstIndex >= elements.size() || secondIndex >= elements.size()){
            throw new Exception("OutOfBoundException");
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (T element : elements) {
            output.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return output.toString().trim();
    }
}
