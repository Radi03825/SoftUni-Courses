import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        Map<String, Integer> drivers = new LinkedHashMap<>();

        Pattern patternName = Pattern.compile("[A-Za-z]+");
        Pattern patternDistance = Pattern.compile("\\d");

        while (!command.equals("end of race")){

            Matcher matcherName = patternName.matcher(command);
            StringBuilder name = new StringBuilder();
            while (matcherName.find()){
                name.append(matcherName.group());
            }
            if(input.contains(name.toString())){
                Matcher matcherDistance = patternDistance.matcher(command);
                int distance = 0;
                while (matcherDistance.find()){
                    distance += Integer.parseInt(matcherDistance.group());
                }
                if(drivers.containsKey(name.toString())){
                    distance += drivers.get(name.toString());
                }
                drivers.put(name.toString(), distance);
            }
            command = scanner.nextLine();
        }

        List<String> top3 = new ArrayList<>();
        drivers.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                .limit(3).forEach(racer -> top3.add(racer.getKey()));
        for (int i = 0; i < 3; i++) {
            if(i == 0){
                System.out.println("1st place: " + top3.get(0));
            }else if(i == 1){
                System.out.println("2nd place: " + top3.get(1));
            }else {
                System.out.println("3rd place: " + top3.get(2));
            }
        }


    }
}
