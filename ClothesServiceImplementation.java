package ecomProject;

public class ClothesServiceImplementation implements ClothService {
    private final String Clothes[];
    private final int Maxsize;
    private int size;

    public ClothesServiceImplementation(String[] clothes, int maxsize, int size) {
        this.Clothes = new String[]{clothes[maxsize]};
        Maxsize = maxsize;
        this.size = size;
    }


    @Override
    public void addClothes() {


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
