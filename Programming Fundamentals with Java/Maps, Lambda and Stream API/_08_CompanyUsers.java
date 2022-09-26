import java.util.*;

public class _08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")){
            boolean isEqual = false;
            String[] tokens = command.split(" -> ");

            String company = tokens[0];
            String employee = tokens[1];

            if(!companies.containsKey(company)){
                companies.put(company, new ArrayList<>());
                companies.get(company).add(employee);
            }else {
                for (String s : companies.get(company)) {
                    if (s.equals(employee)) {
                        isEqual = true;
                        break;
                    }
                }
                if(!isEqual){
                    companies.get(company).add(employee);
                }
            }

            command = scanner.nextLine();
        }
        companies.entrySet().stream().sorted((f, s) -> f.getKey().compareTo(s.getKey())).forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().stream().forEach(em -> System.out.println("-- " + em));
        });
    }
}
