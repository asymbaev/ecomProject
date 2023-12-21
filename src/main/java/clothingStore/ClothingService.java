package clothingStore;
import java.sql.SQLException;
import java.util.List;

//in this method we will use basically some services such as add display and other

import java.util.Scanner;

public interface ClothingService {

    void addClothes  (Clothes clothes);
    List <Clothes> displayClothes() throws SQLException;

    Clothes removeClothesById(int Id);

    void updateClothesById(int id2, Clothes clothes);

}
