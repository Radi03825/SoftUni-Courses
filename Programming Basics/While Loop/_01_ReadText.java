import java.util.Scanner;

public class _01_ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String text = scanner.nextLine();
            if(text.equals("Stop")){
                break;
            }
            System.out.println(text);
        }
    }
}
