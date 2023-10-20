package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final Scanner sc = new Scanner(System.in);
    private static final Integer[] espresso = new Integer[]{250, 0, 16, 4};
    private static final Integer[] latte = new Integer[]{350, 75, 20, 7};
    private static final Integer[] cappuccino = new Integer[]{200, 100, 12, 6};
    private static final Integer[][] menu = new Integer[][]{espresso, latte, cappuccino};

    public static void main(String[] args) {
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int water = sc.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milk = sc.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int beans = sc.nextInt();
//        System.out.println("Write how many cups of coffee you will need: ");
//        int cups = sc.nextInt();
//        int canMake = Math.min(beans / 15, Math.min(water / 200, milk / 50));
//        if (canMake > cups) {
//            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", (canMake - cups));
//        } else if (canMake < cups) {
//            System.out.printf("No, I can make only %d cup(s) of coffee", canMake);
//        } else {
//            System.out.println("Yes, I can make that amount of coffee");
//        }
        stageFour();
    }

    public static void stageFour() {
        int water = 400;
        int milk = 540;
        int beans = 120;
        int disposable = 9;
        int costs = 550;
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.nextLine();
            if ("exit".equalsIgnoreCase(action)) {
                break;
            }
            if ("fill".equalsIgnoreCase(action)) {
                System.out.println("Write how many ml of water you want to add: ");
                int fillWater = Integer.parseInt(sc.nextLine());
                System.out.println("Write how many ml of milk you want to add: ");
                int fillMilk = Integer.parseInt(sc.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add: ");
                int fillBeans = Integer.parseInt(sc.nextLine());
                System.out.println("Write how many disposable cups you want to add: ");
                int fillDisposable = Integer.parseInt(sc.nextLine());
                water += fillWater;
                milk += fillMilk;
                beans += fillBeans;
                disposable += fillDisposable;
            } else if ("buy".equalsIgnoreCase(action)) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String choose = sc.nextLine();
                if ("back".equalsIgnoreCase(choose)) {
                    continue;
                }
                int buy = Integer.parseInt(choose);
                Integer[] coffee = menu[buy - 1];
                if (water - coffee[0] < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk - coffee[1] < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (beans - coffee[2] < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (disposable == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    water -= coffee[0];
                    milk -= coffee[1];
                    beans -= coffee[2];
                    disposable -= 1;
                    costs += coffee[3];
                    System.out.println("I have enough resources, making you a coffee!");
                }
            } else if ("remaining".equalsIgnoreCase(action)) {
                show(water, milk, beans, disposable, costs);
            } else {
                System.out.printf("I gave you $%d\n", costs);
                costs = 0;
            }
        }
    }

    public static void show(int water, int milk, int beans, int disposable, int costs) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(disposable + " disposable cups");
        System.out.printf("$%d of money\n", costs);
    }
}
