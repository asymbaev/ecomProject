package ecomProject.src.clothingStore;


public class Clothes {
    private String type;
    private int id;
    private int quantity;
    private double price;
    private double size;

    public Clothes(String type, int id, int quantity, double price, double size) {
        this.type = type;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}


