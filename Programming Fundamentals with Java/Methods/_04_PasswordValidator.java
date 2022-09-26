import java.util.Scanner;

public class _04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        testPass(scanner.nextLine());
    }

    // 6 – 10 characters (inclusive);
    // Consists only of letters and digits;
    // Have at least 2 digits.
    private static void testPass(String pass) {
        int digitCount = 0;
        boolean hasOtherSymbol = false;
        for (int i = 0; i < pass.length(); i++) {
            char currentChar = pass.charAt(i);
            if(!(Character.isLetter(currentChar) || Character.isDigit(currentChar))){
                hasOtherSymbol = true;
            }else if(Character.isDigit(currentChar)){
                digitCount++;
            }
        }

        boolean isValid = true;
        if(pass.length() < 6 || pass.length() > 10){
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        if(hasOtherSymbol){
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }
        if(digitCount < 2){
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }

        if(isValid){
            System.out.println("Password is valid");
        }
    }

}
