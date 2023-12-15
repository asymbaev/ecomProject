package ecomProject.src.clothingStore;

import java.util.ArrayList;
import java.util.List;

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
    public List<Clothes> getClothes() {
        return clothList;
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
    public void UpdateClothes(Integer id, Clothes cloth) {

        for (Clothes cl : clothList) {
            if (cl.getId() == id) {
                cl.setId(cloth.getId());
                cl.setPrice(cl.getPrice());
                System.out.println("product successfully updated");
            }
        }

    }

    @Override
    public void RemoveClothes(Clothes cloth) {
        if (getClothes().remove(cloth)) {
            System.out.println("Item removed successfully");
        } else {
            System.out.println("product not found ");
        }

    }
}
