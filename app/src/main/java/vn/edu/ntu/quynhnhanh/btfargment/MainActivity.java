package vn.edu.ntu.quynhnhanh.btfargment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.os.Bundle;

import vn.edu.ntu.quynhnhanh.controller.ControllerDB;
import vn.edu.ntu.quynhnhanh.controller.IController;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    IController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new ControllerDB(this);
    }
}
