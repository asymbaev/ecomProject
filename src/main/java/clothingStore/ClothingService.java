package clothingStore;

//in this method we will use basically some services such as add display and other

import java.util.List;

public interface ClothingService {
    void addClothes  (Clothes clothes);
    List<Clothes> displayClothes();

    Clothes removeClothesById(int Id);

    void updateClothesByType(String type);

}
