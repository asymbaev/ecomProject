package ecomProject;

public class ClothesServiceImplementation implements ClothService {
    // have just added some implementation but never tested it yet
    private final String Clothes[];
    private final int Maxsize;
    private int size;

    public ClothesServiceImplementation(String[] clothes, int maxsize, int size) {
        this.Clothes = new String[]{clothes[maxsize]};
        Maxsize = maxsize;
        this.size = 0;
    }


    @Override
    public void addClothes(ecomProject.Clothes clothes) {


    }



    @Override
    public void displayClothes() {

    }

    @Override
    public void UpdateClothes() {

    }

    @Override
    public void RemoveClothes() {

    }
}
