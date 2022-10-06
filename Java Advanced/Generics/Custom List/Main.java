import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String command = scanner.nextLine();

        while (!command.equals("END")){
            String[] tokens = command.split("\\s+");

            if(tokens[0].equals("Add")){
                list.add(tokens[1]);
            }else if(tokens[0].equals("Remove")){
                System.out.println(list.remove(Integer.parseInt(tokens[1])));
            }else if(tokens[0].equals("Contains")){
                System.out.println(list.contains(tokens[1]));
            }else if(tokens[0].equals("Swap")){
                int firstIndex = Integer.parseInt(tokens[1]);
                int secondIndex = Integer.parseInt(tokens[2]);
                list.swap(firstIndex, secondIndex);
            }else if(tokens[0].equals("Greater")){
                System.out.println(list.countGreaterThan(tokens[1]));
            }else if(tokens[0].equals("Max")){
                System.out.println(list.getMax());
            }else if(tokens[0].equals("Min")){
                System.out.println(list.getMin());
            }else if(tokens[0].equals("Sort")){
                list.sort();
            }else if(tokens[0].equals("Print")){
                list.print();
            }


            command = scanner.nextLine();
        }
    }
}
