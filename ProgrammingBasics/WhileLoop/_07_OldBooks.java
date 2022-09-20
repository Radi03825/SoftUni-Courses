import java.util.Scanner;

public class _07_OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        String book = scanner.nextLine();
        int bookCount = 0;
        boolean noMore = false;

        while(!bookName.equals(book)){
            bookCount++;
            book = scanner.nextLine();
            if(book.equals("No More Books")){
                noMore = true;
                break;
            }
        }
        if(noMore){
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", bookCount);
        }else {
            System.out.printf("You checked %d books and found it.", bookCount);
        }
    }
}
