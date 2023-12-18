package ecomProject.src.clothingStore;

//in this method we will use basically some services such as add display and other

public interface ClothesService {
    void addClothes(Clothes clothes);
    void displayClothes();
    // changed implementation name
    void UpdateClothesById(Integer id, Clothes cloth);

    void RemoveClothesById(Integer id, Clothes cloth);

}
