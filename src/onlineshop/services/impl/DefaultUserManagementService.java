package onlineshop.services.impl;

import onlineshop.entities.User;
import onlineshop.services.UserManagementService;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserManagementService implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input an email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static DefaultUserManagementService instance;

    List<User> users;

    {
        users = new ArrayList<>();
    }

    private DefaultUserManagementService() {
    }

    @Override
    public String registerUser(User user) {
        String errorMessage = isValidEmail(user.getEmail());
        if (errorMessage.isEmpty()) {
            users.add(user);
            System.out.println("New user created");
            return NO_ERROR_MESSAGE;
        }
        return errorMessage;
    }

    private String isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        } else if (users.isEmpty()) {
            return NO_ERROR_MESSAGE;
        }
        for (User user : users) {
            if (user.getEmail().equals(email)){
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
            }
        }
        return NO_ERROR_MESSAGE;
    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }


    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        for (User user : users) {
            if (user.getEmail().equals(userEmail)) {
                return user;
            }
        }
        return null;
    }

    void clearServiceState() {
        users.clear();
    }
}
