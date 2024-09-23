import java.util.Scanner;

class Coffee {
    String name;
    Ingredients ingredients;
    double cost;

    public Coffee(String name, Ingredients ingredients, double cost) {
        this.name = name;
        this.ingredients = ingredients;
        this.cost = cost;
    }
}

class Ingredients {
    int water;
    int milk;
    int coffee;

    public Ingredients(int water, int milk, int coffee) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
    }
}

class CoffeeMachine {
    static double profit = 0;
    static int water = 5000;
    static int milk = 3500;
    static int coffee = 300;

    public static boolean isResourceSufficient(Ingredients orderIngredients, String size) {
        int requiredWater = orderIngredients.water;
        int requiredMilk = orderIngredients.milk;
        int requiredCoffee = orderIngredients.coffee;
        if (size.equals("Grande")) {
            requiredWater += 30;
            requiredMilk += 20;
            requiredCoffee += 5;
        } else if (size.equals("Venti")) {
            requiredWater += 80;
            requiredMilk += 50;
            requiredCoffee += 10;
        }
        if (requiredWater > water) {
            System.out.println("Sorry there is not enough water.");
            return false;
        }
        if (requiredMilk > milk) {
            System.out.println("Sorry there is not enough milk.");
            return false;
        }
        if (requiredCoffee > coffee) {
            System.out.println("Sorry there is not enough coffee.");
            return false;
        }
        return true;
    }

    public static double processPrices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many 500 Rs. note : ");
        int five_hundred = scanner.nextInt();
        System.out.println("How many 200 Rs. note : ");
        int two_hundred = scanner.nextInt();
        System.out.println("How many 100 Rs. note : ");
        int one_hundred = scanner.nextInt();
        System.out.println("How many 50 Rs. note : ");
        int fifty = scanner.nextInt();
        System.out.println("How many 20 Rs. note : ");
        int twenty = scanner.nextInt();
        System.out.println("How many 10 Rs. note : ");
        int ten = scanner.nextInt();
        int totalPrice = five_hundred * 500 + two_hundred * 200 + one_hundred * 100 + fifty * 50 + twenty * 20
                + ten * 10;
        System.out.println("Total money given : " + totalPrice);
        return totalPrice;
    }

    public static boolean isTransactionSuccessful(double moneyReceived, double drinkCost) {
        if (moneyReceived >= drinkCost) {
            double change = moneyReceived - drinkCost;
            System.out.println("Here is Rs." + change + " in change.\n");
            profit += drinkCost;
            return true;
        } else {
            System.out.println("Sorry that's not enough money. Money refunded.");
            return false;
        }
    }

    public static void makeCoffee(String drinkName, Ingredients orderIngredients, String size) {
        int requiredWater = orderIngredients.water;
        int requiredMilk = orderIngredients.milk;
        int requiredCoffee = orderIngredients.coffee;
        if (size.equals("Grande")) {
            requiredWater += 30;
            requiredMilk += 20;
            requiredCoffee += 5;
        } else if (size.equals("Venti")) {
            requiredWater += 80;
            requiredMilk += 50;
            requiredCoffee += 10;
        }
        water -= requiredWater;
        milk -= requiredMilk;
        coffee -= requiredCoffee;
        System.out.println("Here is your coffee");
    }

    public static String coffeeSize(Coffee drinkCoffee) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String size = null;
        while (true) {
            System.out.println("What would you like to have : ");
            System.out.println("1. Tall");
            System.out.println("2. Grande");
            System.out.println("3. Venti");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    size = "Tall";
                    break;
                case 2:
                    size = "Grande";
                    break;
                case 3:
                    size = "Venti";
                    break;
                default:
                    System.out.println("Invalid choice :) ");
                    throw new NullPointerException("Invalid input");
            }
            return size;
        }
    }

    public static void menuCoffee() {
        int count = 0;
        for (Coffee coffee : MENU) {
            count++;
            System.out.println("Item: " + count + "\t\tName: " + coffee.name + "\t\tCost: " + coffee.cost);
        }
    }

    static final Coffee[] MENU = {
            new Coffee("espresso", new Ingredients(100, 50, 18), 250),
            new Coffee("latte", new Ingredients(100, 100, 24), 220),
            new Coffee("cappucino", new Ingredients(250, 100, 24), 300),
            new Coffee("gelato", new Ingredients(200, 100, 18), 230),
            new Coffee("hazelnut", new Ingredients(150, 150, 22), 190),
            new Coffee("mocha", new Ingredients(100, 200, 20), 250),
            new Coffee("macchiato", new Ingredients(100, 200, 20), 170)
    }; // Create a list of Objects to represent coffee options in the function coffee
       // machine.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isOn = true;
        double coffeePrice = 0;
        String size = null;
        while (isOn) {
            menuCoffee();
            System.out.print("What would you like to have? ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("off")) {
                isOn = false;
            } else if (choice.equals("report")) {
                System.out.println("Water: " + water + "ml");
                System.out.println("Milk: " + milk + "ml");
                System.out.println("Coffee: " + coffee + "g");
                System.out.println("Money made: " + profit);
            } else {
                Coffee drink = null;
                for (Coffee coffee : MENU) {
                    if (coffee.name.equals(choice)) {
                        drink = coffee;
                        size = coffeeSize(drink);
                        if (size.equals("Tall")) {
                            coffeePrice = drink.cost;
                        } else if (size.equals("Grande")) {
                            coffeePrice = drink.cost + 80;
                        } else {
                            coffeePrice = drink.cost + 120;
                        }
                        break;
                    }
                }
                if (drink != null && coffeePrice != 0) {
                    if (isResourceSufficient(drink.ingredients, size)) {
                        System.out.println("*****Here is your bill*****");
                        System.out.println("Your coffee : " + drink.name + "\tcost : " + coffeePrice);
                        double payment = processPrices();
                        if (isTransactionSuccessful(payment, coffeePrice)) {
                            makeCoffee(choice, drink.ingredients, size);
                        }
                    }
                } else {
                    System.out.println("Invalid choice. Please choose again.");
                }
            }
        }
    }
}
