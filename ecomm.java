import java.util.ArrayList;
import java.util.Scanner;

class body {
    ArrayList<String> products = new ArrayList<String>();
    ArrayList<String> price = new ArrayList<String>();
    ArrayList<String> user_name = new ArrayList<String>();
    ArrayList<String> admin_name = new ArrayList<String>();
    ArrayList<String> user_pass = new ArrayList<String>();
    ArrayList<String> admin_pass = new ArrayList<String>();
    int choice, totalPrice = 0, Count = 0, electronic_size = 1, cloth_size = 1, shoe_size = 1, watch_size = 1,
            toy_size = 1, book_size = 1;
    String email_gmail, string_temp, new_product;
    ArrayList<Integer> cart = new ArrayList<Integer>();

    Scanner input = new Scanner(System.in);

    body() {
        user_name.add("bhavy");
        user_pass.add("1234");
        admin_name.add("admin");
        admin_pass.add("admin");

        products.add("Apple Laptop");
        products.add("T-shirt");
        products.add("Sneaker");
        products.add("FastTrack");
        products.add("car");
        products.add("Psychology of Money");

        price.add("250000");
        price.add("1000");
        price.add("9000");
        price.add("2000");
        price.add("1200");
        price.add("500");

        home_section();
    }

    void sub_signup() {
        System.out.print("\tEnter Full Your Name : ");
        string_temp = input.nextLine();
        System.out.print("\tEnter Your Email : ");
        email_gmail = input.nextLine();
        System.out.print("\tEnter Your User Name : ");
        string_temp = input.nextLine();
        user_name.add(string_temp);
        System.out.print("\tCreate Your Password : ");
        string_temp = input.nextLine();
        user_pass.add(string_temp);
        System.out.print("\tConfirm Your Password : ");
        string_temp = input.nextLine();
        if (user_pass.get(user_pass.size() - 1).compareTo(string_temp) == 0) {
            System.out.println("\t\t\t\t\t\t\t*** Successfully Signed Up ***");
        } else {
            System.out.println("\t\t\t\t\t\t\t***Password Doesn't Match***");
        }
    }

    void signin_section() {
        Count = 0;
        String name, pass;
        System.out.print("\033[H\033[2J");
        // System.out.flush();
        System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm again***");
        System.out.print("\tEnter your user name : ");
        name = input.nextLine();
        System.out.print("\tEnter your password : ");
        pass = input.nextLine();
        for (int i = 0; i < admin_name.size(); i++) {
            if ((name.compareTo(admin_name.get(i)) == 0) && (pass.compareTo(admin_pass.get(i)) == 0)) {
                Count = 1;
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                admin_section();
                break;
            }
        }
        for (int i = 0; i < user_name.size(); i++) {
            if ((name.compareTo(user_name.get(i)) == 0) && (pass.compareTo(user_pass.get(i)) == 0)) {
                Count = 1;
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                user_Section();
                break;
            }
        }
        if (Count == 0) {
            System.out.print("\033[H\033[2J");
            // System.out.flush();
            System.out.println("\t\t\t\t\t\t\t***Invalid user name or password***\n");
            home_section();
        }

    }

    void signup_section() {
        System.out.print("\033[H\033[2J");
        // System.out.flush();
        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
        sub_signup();
        home_section();
    }

    void home_section() {
        int choice;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
        System.out.println("\t1.Sign In\n\t2.Sign Up");
        System.out.print("\tChoice From (1/2) : ");
        choice = input.nextInt();
        string_temp = input.nextLine();
        switch (choice) {
            case 1:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                signin_section();
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                signup_section();
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Successfully sign up***\n");
                signin_section();
                break;
            default:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\t\t\t\t\t\t\t*** Invalid Choice *** Try Again ***");
                home_section();
        }
    }

    void admin_section() {
        System.out.println(
                "\t1.Change user name\n\t2.Change Password\n\t3.Add Sub Admin\n\t4.Add Product\n\t5.Delete product\n\t6.Log Out\n\t0.Exit");
        System.out.print("\tChoice From (0/1/2/3/4/5/6) : ");
        choice = input.nextInt();
        string_temp = input.nextLine();
        switch (choice) {
            case 1:
                Count = 0;
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.print("\tEnter Password : ");
                string_temp = input.nextLine();
                for (int i = 0; i < admin_name.size(); i++) {
                    if (string_temp.compareTo(admin_pass.get(i)) == 0) {
                        Count = 1;
                        admin_name.remove(i);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                        System.out.print("\tEnter New User Name : ");
                        string_temp = input.nextLine();
                        admin_name.add(string_temp);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("\t\t\t\t\t\t\t***User Name Change Successfullyn***");
                        home_section();
                        break;
                    }
                }
                if (Count == 0) {
                    System.out.print("\033[H\033[2J");
                    // System.out.flush();
                    System.out.println("\t\t\t\t\t\t\t***Invalid Password***Try Again***\n");
                    signin_section();
                }
                break;
            case 2:
                Count = 0;
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.print("\tEnter Password : ");
                string_temp = input.nextLine();
                for (int i = 0; i < admin_name.size(); i++) {
                    if (string_temp.compareTo(admin_pass.get(i)) == 0) {
                        Count = 1;
                        admin_pass.remove(i);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                        System.out.print("\tEnter New Password : ");
                        string_temp = input.nextLine();
                        admin_pass.add(string_temp);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("\t\t\t\t\t\t\t***User Name Change Successfully***n");
                        home_section();
                        break;
                    }
                }
                if (Count == 0) {
                    System.out.print("\033[H\033[2J");
                    // System.out.flush();
                    System.out.println("\t\t\t\t\t\t\t***Invalid Password***Try Again***\n");
                    signin_section();
                }
                break;
            case 3:
                Count = 0;
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.print("\tEnter Password : ");
                string_temp = input.nextLine();
                for (int i = 0; i < admin_name.size(); i++) {
                    if (string_temp.compareTo(admin_pass.get(i)) == 0) {
                        Count = 1;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                        System.out.print("\tEnter Sub Admin User Name : ");
                        string_temp = input.nextLine();
                        admin_name.add(string_temp);
                        System.out.print("\tEnter Sub Admin Password : ");
                        string_temp = input.nextLine();
                        admin_pass.add(string_temp);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("\t\t\t\t\t\t\t***Sub Admin Added Successfully***\n");
                        admin_section();
                        break;
                    }
                }
                if (Count == 0) {
                    System.out.print("\033[H\033[2J");
                    // System.out.flush();
                    System.out.println("\t\t\t\t\t\t\t***Invalid Password***Try Again***\n");
                    signin_section();
                }
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.print("\tEnter Product Type : ");
                string_temp = input.nextLine();
                switch (string_temp) {
                    case "electronics":
                        choice = electronic_size;
                        break;
                    case "cloth":
                        choice = electronic_size + cloth_size;
                        break;
                    case "shoe":
                        choice = electronic_size + cloth_size + shoe_size;
                        break;
                    case "watch":
                        choice = electronic_size + cloth_size + shoe_size + watch_size;
                        break;
                    case "toy":
                        choice = electronic_size + cloth_size + shoe_size + watch_size + toy_size;
                        break;
                    case "book":
                        choice = electronic_size + cloth_size + shoe_size + watch_size + toy_size + book_size;
                        break;
                }
                System.out.print("\tEnter Product Name : ");
                new_product = input.nextLine();
                products.add(choice, new_product);
                System.out.print("\tEnter Price Of The Product : ");
                new_product = input.nextLine();
                price.add(choice, new_product);
                switch (string_temp) {
                    case "electronics":
                        electronic_size++;
                        break;
                    case "cloth":
                        cloth_size++;
                        break;
                    case "shoe":
                        shoe_size++;
                        break;
                    case "watch":
                        watch_size++;
                        break;
                    case "toy":
                        toy_size++;
                        break;
                    case "book":
                        book_size++;
                        break;
                }
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.println("\t\t\t\t\t\t\t***Item Added Successfully***");
                admin_section();
                break;
            case 5:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                for (int i = 0; i < products.size(); i++) {
                    System.out.println("\t" + i + "\t" + products.get(i) + "\t" + "USD " + price.get(i) + "$");
                }
                System.out.print("\tEnter Product Code : ");
                choice = input.nextInt();
                for (int i = 0; i < products.size(); i++) {
                    if (choice == i) {
                        products.remove(choice);
                    }
                }
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.println("\t\t\t\t\t\t\t***Item Removed Successfully***\n");
                admin_section();
                break;
            case 6:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                home_section();
                break;
            case 0:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.println("\t\t\t\t\t\t\t\t***Have A Good Day***");
                System.exit(1);
                break;
            default:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Welcome To Ecomm Again Admin Panel***");
                System.out.println("\t\t\t\t\t\t\t*** Invalid Choice *** Try Again ***");
                admin_section();
        }
    }

    void user_Section() {
        System.out.println(
                "\t1.Change user name\n\t2.Change Password\n\t3.Buy Product\n\t4.PayBill\n\t5.View Cart\n\t6.Log Out\n\t0.Exit");
        System.out.print("\tChoice From (0/1/2/3/4/5): ");
        choice = input.nextInt();
        string_temp = input.nextLine();
        switch (choice) {
            case 1:
                Count = 0;
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.print("\tEnter Password : ");
                string_temp = input.nextLine();
                for (int i = 0; i < user_pass.size(); i++) {
                    if (string_temp.compareTo(user_pass.get(i)) == 0) {
                        Count = 1;
                        user_name.remove(i);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.print("\tEnter New User Name : ");
                        string_temp = input.nextLine();
                        user_name.add(string_temp);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("\t\t\t\t\t\t\t***User Name Change Successfully***\n");
                        home_section();
                        break;
                    }
                }
                if (Count == 0) {
                    System.out.print("\033[H\033[2J");
                    // System.out.flush();
                    System.out.println("\t\t\t\t\t\t\t***Invalid Password***Try Again***\n");
                    signin_section();
                }
                break;
            case 2:
                Count = 0;
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.print("\tEnter Password : ");
                string_temp = input.nextLine();
                for (int i = 0; i < user_pass.size(); i++) {
                    if (string_temp.compareTo(user_pass.get(i)) == 0) {
                        Count = 1;
                        user_pass.remove(i);
                        // System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.print("\tEnter New Password : ");
                        string_temp = input.nextLine();
                        user_pass.add(string_temp);
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        home_section();
                        break;
                    }
                }
                if (Count == 0) {
                    System.out.print("\033[H\033[2J");
                    // System.out.flush();
                    System.out.println("\t\t\t\t\t\t\t***Invalid Password***Try Again***\n");
                    signin_section();
                }
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\tCATEGORIES : ");
                System.out.println(
                        "\t\t1.Electronics\n\t\t2.Clothes\n\t\t3.Shoes\n\t\t4.Watches\n\t\t5.Toyes\n\t\t6.Books\n\t\t0.Main Menu");
                System.out.print("\t\tChoice Categories (0/1/2/3/4/5/6) : ");
                choice = input.nextInt();
                string_temp = input.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("CATEGORIES : Electronics");
                        for (int i = 0; i < electronic_size; i++) {
                            System.out.println("\t" + i + "\t" + products.get(i) + "\t" + "INR " + price.get(i) + "₹");
                        }
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("CATEGORIES : Clothes");
                        for (int i = electronic_size; i < electronic_size + cloth_size; i++) {
                            System.out.println("\t" + i + "\t" + products.get(i) + "\t" + "INR " + price.get(i) + "₹");
                        }
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("CATEGORIES : Shoes");
                        for (int i = electronic_size + cloth_size; i < electronic_size + cloth_size + shoe_size; i++) {
                            System.out.println("\t" + i + "\t" + products.get(i) + "\t" + "INR " + price.get(i) + "₹");
                        }
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("CATEGORIES : Watches");
                        for (int i = electronic_size + cloth_size + shoe_size; i < electronic_size + cloth_size + shoe_size
                                + watch_size; i++) {
                            System.out.println("\t" + i + "\t" + products.get(i) + "\t" + "INR " + price.get(i) + "₹");
                        }
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("CATEGORIES : Toyes");
                        for (int i = electronic_size + cloth_size + shoe_size + watch_size; i < electronic_size + cloth_size
                                + shoe_size + watch_size + toy_size; i++) {
                            System.out.println("\t" + i + "\t" + products.get(i) + "\t" + "INR " + price.get(i) + "₹");
                        }
                        break;
                    case 6:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("CATEGORIES : Books");
                        for (int i = electronic_size + cloth_size + shoe_size + watch_size + toy_size; i < products
                                .size(); i++) {
                            System.out.println("\t" + i + "\t" + products.get(i) + "\t" + "INR " + price.get(i) + "₹");
                        }
                        break;
                    case 0:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        user_Section();
                        break;
                }
                System.out.print("\tEnter Product Code, Separeted By Space(-1 For Main Menu) : ");
                string_temp = input.nextLine();
                if (string_temp.compareTo("-1") == 0) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                    user_Section();
                }
                String[] itemCodeStr = string_temp.split(" ", products.size() * 3);
                for (int i = 0; i < itemCodeStr.length; i++) {
                    int temp = Integer.parseInt(itemCodeStr[i]);
                    cart.add(temp);
                    totalPrice += Integer.parseInt(price.get(temp));
                }
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\t\t\t\t\t\t\t***Successfully Added To Cart***\n");
                user_Section();
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\tTotal Amount Is : " + totalPrice);
                System.out.print("\tEnter Account Number : ");
                string_temp = input.nextLine();
                System.out.print("\tEnter Password : ");
                string_temp = input.nextLine();
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\t\t\t\t\t\t\t***Payment Successfull***\n");
                cart.clear();
                user_Section();
                break;
            case 5:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\t\t\t\t\t\t\t\t***Cart Details***");
                if (cart.size() <= 0) {
                    System.out.println("\t\t\t\t\t\t\t\t\t Empty\n");
                }
                for (int i = 0; i < cart.size(); i++) {
                    for (int j = 0; j < products.size(); j++) {
                        if (cart.get(i) == j) {
                            System.out.println("\t" + j + "\t" + products.get(j) + "\t" + "INR " + price.get(j) + "₹");
                        }
                    }
                }
                System.out.println();
                System.out.print("\tPress 1 For Main Menu Or 0 For Exit : ");
                choice = input.nextInt();
                string_temp = input.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        user_Section();
                        break;
                    case 0:
                        System.out.print("\033[H\033[2J");
                        // System.out.flush();
                        System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                        System.out.println("\t\t\t\t\t\t\t\t***Have A Good Day***");
                        System.exit(1);
                        break;
                }
                break;
            case 6:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                home_section();
                break;
            case 0:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\t\t\t\t\t\t\t\t***Have A Good Day***");
                System.exit(1);
                break;
            default:
                System.out.print("\033[H\033[2J");
                // System.out.flush();
                System.out.println("\t\t\t\t\t\t\t***Here You Are At Ecomm Again***");
                System.out.println("\t\t\t\t\t\t\t*** Invalid Choice *** Try Again ***");
                admin_section();
        }
    }
}

class Ecomm {
    public static void main(String[] args) {
        body child = new body();
        child.toString();
    }
}
