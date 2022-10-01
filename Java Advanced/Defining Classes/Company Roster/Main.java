import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Employee>> departments = new HashMap<>();


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String department = tokens[3];

            Employee employee;

            if(tokens.length == 6){
                employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]));
            }else if(tokens.length == 5){
                if(tokens[tokens.length - 1].contains("@")){
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], -1);

                }else{
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], "n/a", Integer.parseInt(tokens[4]));
                }
            }else {
                employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], "n/a", -1);

            }


            if(!departments.containsKey(department)){
                departments.put(department, new ArrayList<>());
            }
            departments.get(department).add(employee);

        }

        String biggestName = "";
        double biggestAverageSalary = 0.0;

        for (Map.Entry<String, List<Employee>> entry : departments.entrySet()) {
            double averageSalary = findAverageSalary(entry);
            if(averageSalary > biggestAverageSalary){
                biggestAverageSalary = averageSalary;
                biggestName = entry.getKey();
            }
        }

        String finalBiggestName = biggestName;
        departments.entrySet().stream().filter(em -> em.getKey().equals(finalBiggestName))
                .forEach(e -> {
                    System.out.println("Highest Average Salary: " + finalBiggestName);
                    e.getValue().stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                            .forEach(el -> System.out.println(el));
                });


    }

    private static double findAverageSalary(Map.Entry<String, List<Employee>> entry) {
        List<Employee> value = entry.getValue();

        if(value.size() == 0){
            return 0.0;
        }

        int sum = 0;

        for (Employee employee : value) {
            sum += employee.getSalary();
        }

        return sum * 1.0 / value.size();
    }
}
