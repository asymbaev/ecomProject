package clothingStore;

import clothingStore.Clothes;
import clothingStore.ClothingService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClothingStoreApp {


    public static Clothes createClothes(Scanner sc) {
        System.out.println("Please enter the Clothes id: ");
        int id = sc.nextInt();
        System.out.println("Please enter the Clothes type");
        String type = sc.next();
        System.out.println("Please enter your clothes size ");
        double size = sc.nextDouble();
        System.out.println("Please enter the price:");
        double price = sc.nextDouble();
        System.out.println("Please enter the quantity");
        int quantity = sc.nextInt();
        Clothes c2 = new Clothes(id, type, size, price, quantity);
        return (c2);
    }

    public static void main(String[] args) {

        JDBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        ClothingServiceImp serviceImp = new ClothingServiceImp();
        int choice;
        boolean options = true;
        try {
            do {
                System.out.println("""
                         Welcome to our clothing store! 
                            Please choose from the following option: 
                           1-Add Clothes/items 
                           2-Display clothes/items in your cart
                           3-Remove items 
                           4-Update items
                           5-Exit
                        """);
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        Clothes c1 = createClothes(sc);
                        serviceImp.addClothes(c1);
                        serviceImp.displayClothes();
                        break;
                    case 2:
                        System.out.println("Your clothes list");
                        serviceImp.displayClothes();
                        break;
                    case 3:
                        serviceImp.displayClothes();
                        sc.nextLine();
                        System.out.println("Enter clothes id to remove: ");
                        int id = sc.nextInt();
                        serviceImp.removeClothesById(id);
                        break;
                    case 4:
                        sc.nextLine();
                        serviceImp.displayClothes();
                        System.out.println("Enter the clothes type to update");
                        String type2 = sc.next();
                        serviceImp.updateClothesByType(type2);
                        System.out.println("Please create the updated item");
                        Clothes updatedItem = createClothes(sc);
                        System.out.println(updatedItem);
                        break;
                    case 5:
                        System.out.println("Bye, Come back soon!");
                        options = false;
                        break;
                }
            } while (options);
        }catch (InputMismatchException e){
            System.out.println("Sorry ,Wrong input! ");
        }

    }

    public static class ClothingServiceImp implements ClothingService {

        private Connection connection;

        public ClothingServiceImp(Connection connection) {
            this.connection = connection;
        }

        private ArrayList<Clothes> clothesList = new ArrayList<>();

        public ClothingServiceImp() {
            this.clothesList = clothesList;
        }

        @Override
        public void addClothes(Clothes clothes) {
            clothesList.add(clothes);
            System.out.println("Added successfully!");
        }

        @Override
        public void displayClothes() {
            if (clothesList.isEmpty()) {
                System.out.println("Your cart is empty!");
            } else
                for (Clothes clothes : clothesList) {
                    System.out.println(clothes);
                }
        }

        @Override
        public void removeClothesById(int Id) {
    //        Scanner sc = new Scanner (System.in);
    //        System.out.println("Enter the clothes type to remove");
    //        String type
            for (Clothes c1 : clothesList) {
                try {
                    if (c1.getId() == (Id)) {
                        clothesList.remove(c1);
                        System.out.println("Your item removed from your card successfully");
                        break;

                    } else {
                        System.out.println("No items found");
                    }

                } catch (ConcurrentModificationException e) {
                    System.out.println("error");
                }

            }
        }

        @Override
        public void updateClothesByType(String type) {
            for (Clothes c1 : clothesList) {
                if (c1.getType().equals(type)) {
                    c1.setType(c1.getType());
                } else {
                    System.out.println("Item with " + type + " not found");


                }
            }
        }
    }
}

