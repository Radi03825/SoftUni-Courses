import java.util.Scanner;

public class _01_ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if(usernameCheck(username)){
                System.out.println(username);
            }
        }


    }

    private static boolean usernameCheck(String username) {
        boolean isRight = false;
        if(username.length() >= 3 && username.length() <= 16){
            for (int i = 0; i < username.length(); i++) {
                char currentChar = username.charAt(i);
                if(Character.isLetter(currentChar) || Character.isDigit(currentChar) || currentChar == '-' || currentChar == '_'){
                    isRight = true;
                }else {
                    return false;
                }
            }
        }
        return isRight;
    }
}
