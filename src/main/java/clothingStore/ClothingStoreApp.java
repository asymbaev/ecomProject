package clothingStore;

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
        Clothes c2 = new Clothes(id, type, size, price, quantity);
        clothingService.addClothes(c2);
        return (c2);
    }

    public static void main(String[] args) {

        clothingStore.JDBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        //ClothingServiceImp serviceImp = new ClothingServiceImp();
        ClothingService service= new ClothingServiceImp(JDBConnection.getConnection());
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
                        service.addClothes(c1);
                        service.displayClothes();
                        break;
                    case 2:
                        System.out.println("Your clothes list");
                        service.displayClothes();
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
                        System.out.println("Enter the clothes type to update");
                        String type2 = sc.next();
                        service.updateClothesByType(type2);
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
}

