package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class SearchInventory {
    public static void main(String[] args) throws IOException {
        try {
            ArrayList<Product> inventory = getInventory();
            String fileName = "inventory.csv";

            for (Product product : inventory) {
                System.out.println(product);
            }

            FileReader fileReader = new FileReader(fileName);
            BufferedReader inventoryBufReader = new BufferedReader(fileReader);
            String line;
            while((line = inventoryBufReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                Product product = new Product(name, id, price);
                System.out.println(product.toString());
            }
// close the stream and release the resources
            inventoryBufReader.close();
        } catch (Exception e) {
            System.err.println("ERROR");
        }
    }

    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<>();
        return inventory;
    }
}
