import java.util.List;

public class Smartphone implements Browsable, Callable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone (List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if(checkForDigits(url)) {
                sb.append(String.format("Browsing: " + url + "!")).append(System.lineSeparator());
            }else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    private boolean checkForDigits(String url) {
        for (int i = 0; i < url.length(); i++) {
            char current = url.charAt(i);
            if(Character.isDigit(current)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if(checkForOtherSymbols(number)) {
                sb.append(String.format("Calling... " + number)).append(System.lineSeparator());
            }else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    private boolean checkForOtherSymbols(String number) {
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            if(!Character.isDigit(current)) {
                return false;
            }
        }
        return true;
    }
}
