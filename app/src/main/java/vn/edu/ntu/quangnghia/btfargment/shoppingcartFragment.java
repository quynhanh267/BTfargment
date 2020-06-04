package vn.edu.ntu.quangnghia.btfargment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.controller.IController;
import vn.edu.ntu.quangnghia.model.Product;


public class shoppingcartFragment extends Fragment {
    TextView txtShoppingCart;
    Button btnOK;
    Button btnCannel;
    List<Product> listProducts = new ArrayList<>();
    public shoppingcartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppingcart,container,false);
        addViews (view);
        addActions();
        return view;
    }
    private void addViews(View view){
        txtShoppingCart = view.findViewById(R.id.txtShoppingCart);
        btnOK = view.findViewById(R.id.btnOK);
        btnCannel = view.findViewById(R.id.btnCannel);

        IController controller = (IController) this.getActivity().getApplication();
        listProducts = controller.getShopping();
        StringBuilder builder = new StringBuilder();
        for(Product p:listProducts){
            builder.append(p.getName());
            builder.append(" : ");
            builder.append(p.getPrice());
            builder.append(" || ");
            builder.append(p.getDesc());
            builder.append("\n");
        }
        txtShoppingCart.setText(builder.toString());
    }
    private void addActions(){
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtShoppingCart.setText("Cảm ơn bạn đã mua hàng");
            }
        });

        btnCannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IController controller = (IController) shoppingcartFragment.this.getActivity().getApplication();
                controller.clearShopping();
                txtShoppingCart.setText("Không có mặt hàng nào");
            }
        });
    }
}
