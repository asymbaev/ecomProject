package ecomProject;

public class MenClothes extends Clothes{
    private String jeans;
    private String Costums;

    public MenClothes(String name, int id, double price, String jeans, String costums) {
        super(name, id, price);
        this.jeans = jeans;
        Costums = costums;
    }

    public MenClothes(String name, int id, double price) {
        super(name, id, price);

    }

    public String getJeans() {
        return jeans;
    }

    public void setJeans(String jeans) {
        this.jeans = jeans;
    }

    public String getCostums() {
        return Costums;
    }

    public void setCostums(String costums) {
        Costums = costums;
    }

    @Override
    public String toString() {
        return "MenClothes{" +
                "jeans='" + jeans + '\'' +
                ", Costums='" + Costums + '\'' +
                "} " + super.toString();
    }
}
