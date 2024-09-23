import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class PizzaBillException extends Exception {
    public PizzaBillException(String message) {
        super(message);
    }
}

class PizzaMenu {
    private static final Map<String, Double> BASE_PRICES = new HashMap<>();
    private static final Map<String, Double> TOPPING_PRICES = new HashMap<>();
    private static final Map<String, Double> CHEESE_PRICES = new HashMap<>();

    static {
        BASE_PRICES.put("Thin Crust", 350.0);
        BASE_PRICES.put("Thick Crust", 400.0);
        BASE_PRICES.put("Stuffed Crust", 450.0);

        TOPPING_PRICES.put("Pepperoni", 50.0);
        TOPPING_PRICES.put("Mushrooms", 40.0);
        TOPPING_PRICES.put("Onions", 30.0);
        TOPPING_PRICES.put("Peppers", 40.0);
        TOPPING_PRICES.put("Olives", 50.0);

        CHEESE_PRICES.put("Mozzarella", 60.0);
        CHEESE_PRICES.put("Cheddar", 70.0);
        CHEESE_PRICES.put("Parmesan", 80.0);
    }

    public static double getBasePrice(String base) throws PizzaBillException {
        if (BASE_PRICES.containsKey(base)) {
            return BASE_PRICES.get(base);
        } else {
            throw new PizzaBillException("Base not found in the menu: " + base);
        }
    }

    public static double getToppingPrice(String topping) throws PizzaBillException {
        if (TOPPING_PRICES.containsKey(topping)) {
            return TOPPING_PRICES.get(topping);
        } else {
            throw new PizzaBillException("Topping not found in the menu: " + topping);
        }
    }

    public static double getCheesePrice(String cheese) throws PizzaBillException {
        if (CHEESE_PRICES.containsKey(cheese)) {
            return CHEESE_PRICES.get(cheese);
        } else {
            throw new PizzaBillException("Cheese not found in the menu: " + cheese);
        }
    }
}

class PizzaOrder {
    private String base;
    private List<String> toppings;
    private List<String> cheese;

    public PizzaOrder(String base, List<String> toppings, List<String> cheese) {
        this.base = base;
        this.toppings = toppings;
        this.cheese = cheese;
    }

    public double calculateTotal() throws PizzaBillException {
        double total = PizzaMenu.getBasePrice(base);
        for (String topping : toppings) {
            total += PizzaMenu.getToppingPrice(topping);
        }
        for (String cheese : cheese) {
            total += PizzaMenu.getCheesePrice(cheese);
        }
        return total;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void removeTopping(String topping) throws PizzaBillException {
        if (toppings.size() <= 1) {
            throw new PizzaBillException("Pizza must have at least one topping.");
        }
        toppings.remove(topping);
    }

    public void addCheese(String cheese) {
        this.cheese.add(cheese);
    }

    public void removeCheese(String cheese) throws PizzaBillException {
        if (this.cheese.size() <= 1) {
            throw new PizzaBillException("Pizza must have at least one cheese.");
        }
        this.cheese.remove(cheese);
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getCheese() {
        return cheese;
    }

    @Override
    public String toString() {
        return "Base: " + base + ", Toppings: " + toppings + ", Cheese: " + cheese;
    }
}

class PizzaOrderSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Pizza Ordering System!");

            String base = chooseBase();
            List<String> toppings = chooseToppings();
            List<String> cheese = chooseCheese();

            PizzaOrder order = new PizzaOrder(base, toppings, cheese);
            double total = order.calculateTotal();

            System.out.println("Your current order:");
            System.out.println(order);
            System.out.println("Total Amount: Rs. " + total);

            modifyOrder(order);

            System.out.println("Final Order Details:");
            System.out.println(order);
            System.out.println("Total Amount: Rs. " + order.calculateTotal());
            System.out.println("Thank you for your order!");
        } catch (PizzaBillException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String chooseBase() {
        System.out.println("Choose your pizza base:");
        System.out.println("1. Thin Crust");
        System.out.println("2. Thick Crust");
        System.out.println("3. Stuffed Crust");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        switch (choice) {
            case 1:
                return "Thin Crust";
            case 2:
                return "Thick Crust";
            case 3:
                return "Stuffed Crust";
            default:
                System.out.println("Invalid choice. Choosing Thin Crust by default.");
                return "Thin Crust";
        }
    }

    private static List<String> chooseToppings() {
        List<String> chosenToppings = new ArrayList<>();
        while (true) {
            System.out.println("Choose your pizza toppings: ");
            System.out.println("1. Pepperoni");
            System.out.println("2. Mushrooms");
            System.out.println("3. Onions");
            System.out.println("4. Peppers");
            System.out.println("5. Olives");
            System.out.println("6. Done");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            
            switch (choice.trim()) {
                case "1":
                    chosenToppings.add("Pepperoni");
                    break;
                case "2":
                    chosenToppings.add("Mushrooms");
                    break;
                case "3":
                    chosenToppings.add("Onions");
                    break;
                case "4":
                    chosenToppings.add("Peppers");
                    break;
                case "5":
                    chosenToppings.add("Olives");
                    break;
                case "6":
                    return chosenToppings;
                default:
                    System.out.println("Invalid choice: " + choice);
            }
        }
        
    }

    private static List<String> chooseCheese() {
        List<String> chosenCheese = new ArrayList<>();
        while (true) {
            System.out.println("Choose your cheese :");
            System.out.println("1. Mozzarella");
            System.out.println("2. Cheddar");
            System.out.println("3. Parmesan");
            System.out.println("4. Done");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    chosenCheese.add("Mozzarella");
                    break;
                case 2:
                    chosenCheese.add("Cheddar");
                    break;
                case 3:
                    chosenCheese.add("Parmesan");
                    break;
                case 4:
                    return chosenCheese;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void modifyOrder(PizzaOrder order) {
        while (true) {
            System.out.println("Do you want to add or remove toppings/cheese? (add/remove/done)");
            String action = scanner.nextLine().trim();
            if (action.equalsIgnoreCase("done")) {
                break;
            }
            switch (action) {
                case "add":
                    addToppingOrCheese(order);
                    break;
                case "remove":
                    removeToppingOrCheese(order);
                    break;
                default:
                    System.out.println("Invalid action.");
            }
        }
    }

    private static void addToppingOrCheese(PizzaOrder order) {
        System.out.println("Do you want to add toppings or cheese? (toppings/cheese)");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "toppings":
                addTopping(order);
                break;
            case "cheese":
                addCheese(order);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void removeToppingOrCheese(PizzaOrder order) {
        System.out.println("Do you want to remove toppings or cheese? (toppings/cheese)");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "toppings":
                try {
                    removeTopping(order);
                } catch (PizzaBillException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case "cheese":
                try {
                    removeCheese(order);
                } catch (PizzaBillException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addTopping(PizzaOrder order) {
        System.out.println("Choose a topping to add:");
        System.out.println("1. Pepperoni");
        System.out.println("2. Mushrooms");
        System.out.println("3. Onions");
        System.out.println("4. Peppers");
        System.out.println("5. Olives");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
        switch (choice.trim()) {
            case "1":
                order.addTopping("Pepperoni");
                break;
            case "2":
                order.addTopping("Mushrooms");
                break;
            case "3":
                order.addTopping("Onions");
                break;
            case "4":
                order.addTopping("Peppers");
                break;
            case "5":
                order.addTopping("Olives");
                break;
            default:
                System.out.println("Invalid choice: " + choice);
        }
    }

    private static void removeTopping(PizzaOrder order) throws PizzaBillException {
        if (order.getToppings().size() <= 1) {
            throw new PizzaBillException("Pizza must have at least one topping.");
        }
        System.out.println("Choose a topping to remove:");
        for (int i = 0; i < order.getToppings().size(); i++) {
            System.out.println((i + 1) + ". " + order.getToppings().get(i));
        }
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (choice > 0 && choice <= order.getToppings().size()) {
            order.removeTopping(order.getToppings().get(choice - 1));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void addCheese(PizzaOrder order) {
        System.out.println("Choose a cheese to add:");
        System.out.println("1. Mozzarella");
        System.out.println("2. Cheddar");
        System.out.println("3. Parmesan");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        switch (choice) {
            case 1:
                order.addCheese("Mozzarella");
                break;
            case 2:
                order.addCheese("Cheddar");
                break;
            case 3:
                order.addCheese("Parmesan");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void removeCheese(PizzaOrder order) throws PizzaBillException {
        if (order.getCheese().size() <= 1) {
            throw new PizzaBillException("Pizza must have at least one cheese.");
        }
        System.out.println("Choose a cheese to remove:");
        for (int i = 0; i < order.getCheese().size(); i++) {
            System.out.println((i + 1) + ". " + order.getCheese().get(i));
        }
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (choice > 0 && choice <= order.getCheese().size()) {
            order.removeCheese(order.getCheese().get(choice - 1));
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
