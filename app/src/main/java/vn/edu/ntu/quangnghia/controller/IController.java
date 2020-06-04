package vn.edu.ntu.quangnghia.controller;

import java.util.List;

import vn.edu.ntu.quangnghia.model.Product;

public interface IController {
    public List<Product> getProduct();

    public List<Product> getShopping();
    public boolean checkShopping(Product product);
    public void clearShopping();
}
