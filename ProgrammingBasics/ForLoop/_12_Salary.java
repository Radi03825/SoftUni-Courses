import java.util.Scanner;

public class _12_Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= tabs; i++){
            if(salary <= 0){
                break;
            }
            String tabsName = scanner.nextLine();
            if(tabsName.equals("Facebook")){
                salary -= 150;
            }else if(tabsName.equals("Instagram")){
                salary -= 100;
            }else if(tabsName.equals("Reddit")){
                salary -= 50;
            }
        }
        if(salary > 0){
            System.out.println(salary);
        }else {
            System.out.println("You have lost your salary.");
        }
    }
}
