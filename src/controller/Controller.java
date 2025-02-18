package controller;

import model.*;
import repository.*;

import java.util.Comparator;
import java.util.List;

public class Controller {

    private final IRepository<Product> productIRepository;
    private final IRepository<Charakteren> charakterenIRepository;

    public Controller() {
        this.productIRepository = new ProductRepo();
        this.charakterenIRepository = new CharakterenRepo();
    }

    public Product getProduct(int id) {
        return productIRepository.read(id);
    }

    public Charakteren getCharakteren(int id) {
        return charakterenIRepository.read(id);
    }

    public void addProduct(Product product) {
        productIRepository.create(product);
    }

    public void addCharakter(Charakteren charakteren) {
        charakterenIRepository.create(charakteren);
    }

    public void updateProduct(int id, String name, float price, String universum) {
        Product product = getProduct(id);
        product.setName(name);
        product.setPrice(price);
        product.setUniversum(universum);
        productIRepository.update(product);
    }

    public void updateCharakter(int id, String name, String region, int productId) {
        Charakteren charakter = getCharakteren(id);
        charakter.setName(name);
        charakter.setRegion(region);
        List<Product> updatedProducts = charakter.getProducts();
        Product newProduct = productIRepository.read(productId);
        updatedProducts.add(newProduct);
        charakter.setProducts(updatedProducts);
        charakterenIRepository.update(charakter);
    }

    public void deleteProduct(int id) {
        productIRepository.delete(id);
    }

    public void deleteCharakter(int id) {
        charakterenIRepository.delete(id);
    }

    public List<Product> getAllProducts() {
        return productIRepository.getAll();
    }

    public List<Charakteren> getAllCharakteren() {
        return charakterenIRepository.getAll();
    }

    public void filterCharakterenByRegion(String region) {
        for (Charakteren charakteren : getAllCharakteren()) {
            if (charakteren.getRegion().equalsIgnoreCase(region))
                System.out.println(charakteren);
        }
    }

    public void findCharakterByUniversum(String universum) {
        for (Charakteren charakteren : getAllCharakteren()) {
            List<Product> customerProducts = charakteren.getProducts();
            for (Product product : customerProducts) {
                if (product.getUniversum().equalsIgnoreCase(universum)) {
                    System.out.println(charakteren);
                }
            }
        }
    }

    public void sortProductsForCharakterByPrice(int charakterId, String order) {
        Charakteren charakter = getCharakteren(charakterId);
        if (order.equalsIgnoreCase("asc")) {
            List<Product> charakterProductsProducts = charakter.getProducts();
            charakterProductsProducts.sort(Comparator.comparingDouble(Product::getPrice));
            System.out.println("Products sorted by price (ascending):");
            for (Product product : charakterProductsProducts) {
                System.out.println(product.toString());
            }
        } else if (order.equalsIgnoreCase("desc")) {
            List<Product> charakterProductsProducts = charakter.getProducts();
            charakterProductsProducts.sort(Comparator.comparingDouble(Product::getPrice).reversed());
            System.out.println("Products sorted by price (descending):");
            for (Product product : charakterProductsProducts) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Typo.. please try again");
        }
    }

    public void findCustomersByListe(String product) {
    }
}
