package vn.edu.ntu.quynhnhanh.controller;

import java.util.List;

import vn.edu.ntu.quynhnhanh.model.Product;

public interface IController {
    public List<Product> getProduct();

    public List<Product> getShopping();
    public boolean checkShopping(Product product);
    public void clearShopping();
    public void addProduct(Product p);
    public boolean addToCart(Product p);
}
