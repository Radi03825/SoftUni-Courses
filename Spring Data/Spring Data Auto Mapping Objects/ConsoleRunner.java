package game_store;

import com.example.game_store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    public String execute(String command) {

        String[] params = command.split("\\|");

        switch (params[0]) {
            case "RegisterUser":
                userService.register();
                break;
            case "LoginUser":
                userService.login();
                break;
            case "Logout":
                userService.logout();
                break;
        }

        return null;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        System.out.println(execute(command));
    }
}
