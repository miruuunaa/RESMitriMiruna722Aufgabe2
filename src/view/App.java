package view;

import controller.Controller;
import model.*;

import java.util.*;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n   - Menu -");
            System.out.println("1. Manage Products (CRUD)");
            System.out.println("2. Manage Charkteren (CRUD)");
            System.out.println("3. Filter Charkteren by Region");
            System.out.println("4. Find Charakteren by Product Liste");
            System.out.println("5. Sort Products for a Charakter by Price");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> manageProducts();
                case 2 -> manageCharakteren();
                case 3 -> {
                    System.out.println("Enter region: ");
                    String region = scanner.nextLine();
                    controller.filterCharakterenByRegion(region);
                }
                case 4 -> {
                    System.out.print("Enter charakter: ");
                    String product = scanner.nextLine();
                    controller.findCustomersByListe(product);
                }
                case 5 -> {
                    System.out.print("Enter charakter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Sort order (asc/desc): ");
                    String order = scanner.nextLine();
                    controller.sortProductsForCharakterByPrice(id, order);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageProducts() {
        while (true) {
            System.out.println("\n  - Manage Products -");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    float price = Float.parseFloat(scanner.nextLine());
                    System.out.print("Enter product universum: ");
                    String season = scanner.nextLine();
                    Product newProduct = new Product(name, price, season);
                    controller.addProduct(newProduct);
                    System.out.println("Product added successfully.");
                }
                case 2 -> {
                    System.out.println("\n");
                    for (Product product : controller.getAllProducts())
                        System.out.println(product.toString());
                }
                case 3 -> {
                    System.out.print("Enter product name to edit: ");
                    String name = scanner.nextLine();
                    Product product = findProductByName(name);
                    if (product != null) {
                        int id = product.getId();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new price: ");
                        float newPrice = Float.parseFloat(scanner.nextLine());
                        System.out.print("Enter new universum: ");
                        String newSeason = scanner.nextLine();
                        controller.updateProduct(id, newName, newPrice, newSeason);
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter product name to delete: ");
                    String name = scanner.nextLine();
                    Product product = findProductByName(name);
                    if (product != null) {
                        int id = product.getId();
                        controller.deleteProduct(id);
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static Product findProductByName(String name) {
        for (Product product : controller.getAllProducts()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    private static void manageCharakteren() {
        while (true) {
            System.out.println("\n  - Manage Charakteren -");
            System.out.println("1. Add Charakter");
            System.out.println("2. View All Charakteren");
            System.out.println("3. Edit Charakter");
            System.out.println("4. Delete Charakter");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer region: ");
                    String region = scanner.nextLine();
                    List<Product> charakterProducts = new ArrayList<>();
                    Charakteren newCharakter = new Charakteren(name, region, charakterProducts);
                    controller.addCharakter(newCharakter);
                    System.out.println("Customer added successfully.");
                }
                case 2 -> {
                    System.out.println("\n");
                    for (Charakteren charakteren : controller.getAllCharakteren())
                        System.out.println(charakteren.toString());
                }
                case 3 -> {
                    System.out.print("Enter charakter ID to edit: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Charakteren charakteren = controller.getCharakteren(id);
                    if (charakteren != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new region: ");
                        String newLocation = scanner.nextLine();
                        for (Product product : controller.getAllProducts())
                            System.out.println(product.toString());
                        System.out.print("Choose product by id: ");
                        int productId = Integer.parseInt(scanner.nextLine());
                        String newRegion = "";
                        controller.updateCharakter(id, newName, newRegion, productId);
                        System.out.println("Charakter updated successfully.");
                    } else {
                        System.out.println("Charakter not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter charakter ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Charakteren charakteren = controller.getCharakteren(id);
                    if (charakteren != null) {
                        controller.deleteCharakter(id);
                        System.out.println("Charakter deleted successfully.");
                    } else {
                        System.out.println("Charakter not found.");
                    }
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}