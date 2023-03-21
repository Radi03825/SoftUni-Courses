import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Class clazz = RichSoilLand.class;

		int n = 100;

		String modifierType = scanner.nextLine();

		Field[] fields = clazz.getDeclaredFields();

		StringBuilder sb = new StringBuilder();

		while (n > 0 && !modifierType.equals("HARVEST")) {
			n--;

			if(modifierType.equals("all")) {
				for (Field field : fields) {
					field.setAccessible(true);
					sb.append(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
					sb.append(System.lineSeparator());
				}
			}else {
				String finalModifierType = modifierType;
				Arrays.stream(fields).filter(p -> Modifier.toString(p.getModifiers()).equals(finalModifierType)).forEach(e -> sb.append(String.format("%s %s %s", Modifier.toString(e.getModifiers()), e.getType().getSimpleName(), e.getName())).append(System.lineSeparator()));
			}

			modifierType = scanner.nextLine();
		}

		System.out.println(sb.toString().trim());

	}
}
