package model;

import java.util.*;

public class Charakteren {

    private int id;
    private String name;
    private String region;
    private List<Product> products;

    public Charakteren(String name, String region, List<Product> products) {
        this.name = name;
        this.region = region;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getRegion() {
        return region;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Charakteren{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", products=" + products +
                '}';
    }
}
