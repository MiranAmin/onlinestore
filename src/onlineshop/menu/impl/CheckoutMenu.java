package onlineshop.menu.impl;

import onlineshop.config.ApplicationContext;
import onlineshop.entities.Order;
import onlineshop.entities.impl.DefaultOrder;
import onlineshop.menu.Menu;
import onlineshop.services.OrderManagementService;
import onlineshop.services.impl.DefaultOrderManagementService;

import java.util.Scanner;

public class CheckoutMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        while (true) {
            printMenuHeader();
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();

            if (!createOrder(userInput)) {
                continue;
            }
            context.getSessionCart().clear();
            break;
        }

        System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
        new MainMenu().start();

    }

    private boolean createOrder(String creditCardNumber) {
        Order order = new DefaultOrder();
        if (!order.isCreditCardNumberValid(creditCardNumber)) {
            return false;
        }

        order.setCreditCardNumber(creditCardNumber);
        order.setProducts(context.getSessionCart().getProducts());
        order.setCustomerId(context.getLoggedInUser().getId());
        orderManagementService.addOrder(order);
        return true;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHECKOUT *****");
        System.out.print(
                "Enter your credit card number without spaces and press enter if you confirm purchase: ");
    }
}