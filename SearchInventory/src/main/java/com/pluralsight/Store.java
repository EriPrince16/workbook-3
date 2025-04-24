package com.pluralsight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        try {
            String filePath = "src/main/resources/inventory.csv";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    float price = Float.parseFloat(parts[2].trim());

                    Product product = new Product(id, name, price);
                    inventory.add(product);
                } else {
                    System.out.println("Hey this is an invalid line!" + line);
                }
            }

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }

//        inventory.add(new Product(1, "iPhone", 799.99f));
//        inventory.add(new Product(2, "Galaxy S21", 549.99f));
//        inventory.add(new Product(3, "MacBook Pro", 1899.99f));
//        inventory.add(new Product(4, "ASUS Gaming Laptop", 1399.99f));
//        inventory.add(new Product(5, "Playstation 5", 449.99f));

        // this method loads product objects into inventory
        // and its details are not shown

        return inventory;
    }
}
