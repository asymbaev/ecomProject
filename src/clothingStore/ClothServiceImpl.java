package ecomProject.src.clothingStore;

import java.util.ArrayList;

public class ClothServiceImpl implements ClothesService {

    private final ArrayList<Clothes> clothList;

    public ClothServiceImpl() {
        this.clothList = new ArrayList<>();
    }


    @Override
    public void addClothes(Clothes clothes) {
        clothList.add(clothes);
        System.out.println("Item added successfully");
    }
    @Override
    public void displayClothes() {

        if (clothList.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            for (Clothes cloth : clothList) {
                System.out.println(cloth);
            }
        }

    }
    @Override
    public void UpdateClothesById(Integer id, Clothes cloth) {
        // changed c1 to clothesToUpdate
        // changed cloth to clothesToRemove
        // just added else

        for (Clothes clothesToUpdate : clothList) {
            if (clothesToUpdate.getId() == id) {
                clothesToUpdate.setId(cloth.getId());
                clothesToUpdate.setPrice(clothesToUpdate.getPrice());
                System.out.println("Item successfully updated");

            } else {
                System.out.println("Item with id " + id + " not found");

            }
        }

    }

    @Override
    public void RemoveClothesById(Integer id, Clothes cloth) {
        for ( Clothes clothesToRemove: clothList){
            if(clothesToRemove.getId()==id){
                clothList.remove(clothesToRemove);
                System.out.println("Item removed successfully!");

    }
        }
    }
}
