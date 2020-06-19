package vn.edu.ntu.quynhnhanh.controller;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quynhnhanh.model.AppDatabase;
import vn.edu.ntu.quynhnhanh.model.DaoProduct;
import vn.edu.ntu.quynhnhanh.model.Product;

public class ControllerDB implements IController{
    AppDatabase database;
    List<Product> listshoppingProduct = new ArrayList<>();
    DaoProduct daoProduct;

    public ControllerDB (Context context)
    {
        database = Room.databaseBuilder(context,
                AppDatabase.class, "appdb")
                .allowMainThreadQueries()
                .build();
        daoProduct = database.getProductDAO();
    }

    public List<Product> getProduct() {
        return daoProduct.getListProduct();
    }

    @Override
    public List<Product> getShopping() {
        return listshoppingProduct;
    }

    @Override
    public boolean checkShopping(Product product) {
        return false;
    }

    @Override
    public void clearShopping() {
        listshoppingProduct.clear();
    }

    @Override
    public void addProduct(Product p) {
        daoProduct.insertProduct(p);
    }

    @Override
    public boolean addToCart(Product p) {
        if(listshoppingProduct.contains(p)){
            return false;
        }
        listshoppingProduct.add(p);
        return true;
    }



}
