package clothingStore;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClothingStoreApp {
    private static ClothingService clothingService = new ClothingServiceImp(JDBConnection.getConnection());

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
        Clothes clothesList = new Clothes(id, type, size, price, quantity);
        clothingService.addClothes(clothesList);
        return (clothesList);
    }

    public static void main(String[] args) {

        clothingStore.JDBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        //ClothingServiceImp serviceImp = new ClothingServiceImp();
        ClothingService service = new ClothingServiceImp(JDBConnection.getConnection());
        int choice;
        boolean option = true;
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
                        service.addClothes(c1);
                        service.displayClothes();
                        break;
                    case 2:
                        System.out.println("Your list of items on our current cart: ");
                        displayBooks(sc);
//                        service.displayClothes();
//                        System.out.println("Your clothes list");
////                        clothingService.displayClothes();
                        break;
                    case 3:
                        service.displayClothes();
                        sc.nextLine();
                        System.out.println("Enter clothes id to remove: ");
                        int id = sc.nextInt();
                        service.removeClothesById(id);
                        break;
                    case 4:
                        sc.nextLine();
                        service.displayClothes();
                        System.out.println("Enter the clothes id to update");
                        int id2 = sc.nextInt();
                        System.out.println("Please create the new item");
                        Clothes updatedItem = createClothes(sc);
                        service.updateClothesById(id2, updatedItem);


                        service.removeClothesById(id2);
                        System.out.println(updatedItem);

                        break;
                    case 5:
                        System.out.println("Bye, Come back soon!");
                        option = false;
                        break;
                }
            } while (choice != 5);
        } catch (InputMismatchException e) {
            System.out.println("Sorry, Wrong input! ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayBooks(Scanner sc) throws SQLException {
        for (Clothes clothes : clothingService.displayClothes()) {
            System.out.println(clothes.toString());
        }
    }
}

