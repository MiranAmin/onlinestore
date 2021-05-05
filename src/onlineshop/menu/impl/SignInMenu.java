package onlineshop.menu.impl;

import onlineshop.config.ApplicationContext;
import onlineshop.entities.User;
import onlineshop.menu.Menu;
import onlineshop.services.UserManagementService;
import onlineshop.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {

    private static final String INVALID_EMAIL_OR_PASSWORD = "Unfortunately, the email and password does not exist";
    private static final String WELCOME_BACK_MESSAGE = "Glad to see you back ";

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email");
        String email = scanner.nextLine();

        System.out.println("Enter password");
        String password = scanner.nextLine();

        User user = userManagementService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)){
            context.setLoggedInUser(user);
            System.out.println(WELCOME_BACK_MESSAGE + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println(INVALID_EMAIL_OR_PASSWORD);
        }

        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN IN *****");
    }
}
