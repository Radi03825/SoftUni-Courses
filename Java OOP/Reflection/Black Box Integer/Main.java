import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class clazz = BlackBoxInt.class;

        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Object blackBoxInt = declaredConstructor.newInstance();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("_");

            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = clazz.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field field = clazz.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));

            input = scanner.nextLine();
        }

    }
}