package vn.edu.ntu.quangnghia.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.model.Product;

public class Controller extends Application implements IController {
    List<Product> products = new ArrayList<>();
    List<Product> productsShopping = new ArrayList<>();

    public Controller() {
        products.add(new Product("Xoài",60000,"xanh và chua"));
        products.add(new Product("Chuối",70000,"Bự thiệt bự"));
        products.add(new Product("Bưởi",50000,"ngon ngọt thịt"));
        products.add(new Product("Nho",90000,"xanh tươi tắn"));
        products.add(new Product("Táo",30000,"to và bự"));
        products.add(new Product("Quýt",20000,"ngọt nước"));
    }


    @Override
    public List<Product> getProduct() {
        return products;
    }

    @Override
    public List<Product> getShopping() {
        return productsShopping;
    }

    @Override
    public boolean checkShopping(Product product) {
        if(productsShopping.contains(product)){
            return false;
        }
        else
        {
            productsShopping.add(product);
            return true;
        }
    }

    @Override
    public void clearShopping() {
        productsShopping.clear();
    }


}
