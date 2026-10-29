package com.rest;

import com.rest.cli.MenuItemCLI;
import com.rest.cli.OrderCLI;
import com.rest.cli.PaymentCLI;
import com.rest.cli.TableCLI;
import com.rest.services.BillService;
import com.rest.services.MenuItemService;
import com.rest.services.OrderItemService;
import com.rest.services.Ordersservice;
import com.rest.services.PaymentService;
import com.rest.services.Tableservice;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        Tableservice     tableService     = new Tableservice();
        MenuItemService  menuItemService  = new MenuItemService();
        Ordersservice    ordersService    = new Ordersservice();
        OrderItemService orderItemService = new OrderItemService();
        BillService      billService      = new BillService();
        PaymentService   paymentService   = new PaymentService();


        Scanner scanner = new Scanner(System.in);


        TableCLI    tableCLI    = new TableCLI(tableService, scanner);
        MenuItemCLI menuItemCLI = new MenuItemCLI(menuItemService, scanner);
        OrderCLI    orderCLI    = new OrderCLI(ordersService, orderItemService,
                                               menuItemService, tableService, billService, scanner);
        PaymentCLI  paymentCLI  = new PaymentCLI(paymentService, billService, ordersService,
                                                 tableService, scanner);


        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║    RESTAURANT MANAGEMENT SYSTEM v1.0     ║");
        System.out.println("╚══════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            printMainMenu();
            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> tableCLI.show();
                case "2" -> menuItemCLI.show();
                case "3" -> orderCLI.show();
                case "4" -> paymentCLI.show();
                case "0" -> {
                    System.out.println("\n  Thank you for using the Restaurant Management System. Goodbye!");
                    running = false;
                }
                default -> System.out.println("  [!] Invalid option. Please enter 0-4.\n");
            }
        }

        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println();
        System.out.println("  ┌─────────────────────────────────┐");
        System.out.println("  │          MAIN MENU              │");
        System.out.println("  ├─────────────────────────────────┤");
        System.out.println("  │  1. Table Management            │");
        System.out.println("  │  2. Menu Item Management        │");
        System.out.println("  │  3. Order Management            │");
        System.out.println("  │  4. Payment & Billing           │");
        System.out.println("  │  0. Exit                        │");
        System.out.println("  └─────────────────────────────────┘");
    }
}

