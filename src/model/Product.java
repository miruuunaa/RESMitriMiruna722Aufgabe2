package model;

public class Product {

    private int id;
    private String name;
    private float price;
    private String universum;

    public Product(String name, float price, String universum) {
        this.name = name;
        this.price = price;
        this.universum = universum;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getUniversum() {
        return universum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniversum(String universum) {
        this.universum = universum;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id + '\'' +
                "name='" + name + '\'' +
                ", price=" + price +
                ", universum='" + universum + '\'' +
                '}';
    }
}
