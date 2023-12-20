package clothingStore;


public class Clothes {
    static int id;
    static String type;
    static double size;
    static double price;
    static int quantity;

    public Clothes(int id, String type, double size, double price, int quantity) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
//Clothes //

