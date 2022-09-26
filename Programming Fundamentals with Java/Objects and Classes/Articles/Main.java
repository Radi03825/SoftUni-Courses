import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(scanner.nextLine());

        Articles articles = new Articles(input[0], input[1], input[2]);
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(": ");
            if(command[0].equals("Edit")){
                articles.setContent(command[1]);
            }else if (command[0].equals("ChangeAuthor")){
                articles.setAuthor(command[1]);
            }else if (command[0].equals("Rename")){
                articles.setTitle(command[1]);
            }
        }

        System.out.printf("%s - %s: %s%n", articles.getTitle(), articles.getContent(), articles.getAuthor());
    }
}
