import java.util.Scanner;

public class _04_VowelsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int points = 0;
        for (int i = 0; i < text.length(); i++){
            char a = text.charAt(i);
            if(a == 'a'){
                points += 1;
            }else if(a == 'e'){
                points += 2;
            }else if(a == 'i'){
                points += 3;
            }else if(a == 'o'){
                points += 4;
            }else if(a == 'u'){
                points += 5;
            }
        }
        System.out.println(points);
    }
}
