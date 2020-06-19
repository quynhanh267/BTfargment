package vn.edu.ntu.quynhnhanh.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoProduct {

    @Insert
    public void insertProduct(Product...products);

    @Update
    public void updateProduct(Product...products);

    @Delete
    public void deleteProduct(Product...products);

    @Query("SELECT * FROM Product")
    List<Product> getListProduct();

    @Query("SELECT * FROM Product WHERE id = :id")
    public Product getProductByID(int id);

}
