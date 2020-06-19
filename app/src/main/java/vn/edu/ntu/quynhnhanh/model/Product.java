package vn.edu.ntu.quynhnhanh.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Product")
public class Product {

    @PrimaryKey(autoGenerate = true)
            int id;
    @NonNull
    String Name;
    @NonNull
    int Price;
    @NonNull
    String Desc;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(String name, int price, String desc) {
        Name = name;
        Price = price;
        Desc = desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
