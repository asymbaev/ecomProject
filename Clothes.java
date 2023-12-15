package ecomProject;

public class Clothes {
    private  String[] name;
    private int[] id;
    private double[] price;

    public Clothes(String name, int id, double price) {
        this.name = new String[]{name};
        this.id = new int[]{id};
        this.price = new double[]{price};
    }

    public String[] getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new String[]{name};
    }

    public int[] getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new int[]{id};
    }

    public double[] getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = new double[]{price};
    }

    @Override
    public String toString() {
        return "ecomProject.Clothes{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
