package ecomProject.src.clothingStore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClothesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 1 for men's clothing and type 2 women's clothing: ");
        ClothServiceImpl ClothImplementation=new ClothServiceImpl();

        Integer gender = sc.nextInt();

        ClothServiceImpl service = new ClothServiceImpl();
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
                        serviceImp.displayCLothes();
                        break;
                    case 2:
                        System.out.println("Your clothes list");
                        ClothesService.displayCLothes();
                        break;
                    case 3:
                        ClothImplementation.displayClothes();
                        sc.nextLine();
                        System.out.println("Enter clothes type to remove: ");
                        String type1 = sc.next();
                        ClothImplementation.removeClothesById(type1);
                        break;
                    case 4:
                        sc.nextLine();
                        serviceImp.displayCLothes();
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

//        int choice;
//        choice = sc.nextInt();
//        Clothes clothes = new Clothes(1, "Shirt", 4,15.99, 1);
        }

    }
}



       

    }
}
