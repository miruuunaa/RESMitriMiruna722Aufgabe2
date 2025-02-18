package repository;

import model.Product;

import java.util.*;

public class ProductRepo implements IRepository<Product> {

    private final List<Product> products = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void create(Product obj) {
        obj.setId(currentId++);
        products.add(obj);
    }

    @Override
    public Product read(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product obj) {
        Product product = read(obj.getId());
        if (product != null) {
            product.setName(obj.getName());
            product.setPrice(obj.getPrice());
            product.setUniversum(obj.getUniversum());
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

}
