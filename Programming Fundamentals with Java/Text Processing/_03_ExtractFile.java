import java.util.Scanner;

public class _03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] address = scanner.nextLine().split("[\\\\.]");

        System.out.printf("File name: %s%n", address[address.length - 2]);
        System.out.printf("File extension: %s%n", address[address.length - 1]);
    }
}
