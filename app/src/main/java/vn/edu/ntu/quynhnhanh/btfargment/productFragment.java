package vn.edu.ntu.quynhnhanh.btfargment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quynhnhanh.controller.IController;
import vn.edu.ntu.quynhnhanh.model.Product;


public class productFragment extends Fragment {
    RecyclerView rvListProduct;
    ProductAdapter adapter;
    List<Product> listProducts = new ArrayList<>();
    FloatingActionButton floatingActionButton;

   public productFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();

       switch (id){
           case  R.id.menuthoat:
               this.getActivity().finish();
           case R.id.menushopping:
                showshoppingcart();
       }
        return super.onOptionsItemSelected(item);
    }
    private void showshoppingcart(){
        NavController navController = NavHostFragment.findNavController(productFragment.this);
        navController.navigate(R.id.action_productFragment_to_shoppingcartFragment2);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product,container,false);
        addviews(view);
        addActions();
        return view;
    }
    private void addviews(View view){
       rvListProduct = view.findViewById(R.id.rvlistproduct);
        IController controller =((MainActivity)getActivity()).controller;
        listProducts =controller.getProduct();
        adapter = new ProductAdapter(listProducts);

        rvListProduct.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvListProduct.setAdapter(adapter);

        floatingActionButton = view.findViewById(R.id.floatingActionButton);
    }

    private void addActions(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = NavHostFragment.findNavController(productFragment.this);
                navController.navigate(R.id.action_productFragment_to_addProductFragment);
            }
        });
    }

    private class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtPrice, txtDesc;
        ImageView imgAddToCart, imgEdit, imgDel;
        Product p;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            imgAddToCart = itemView.findViewById(R.id.imgAddToCart);
            imgDel = itemView.findViewById(R.id.imgDel);

            imgAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        IController controller = ((MainActivity)getActivity()).controller;
                        if(controller.addToCart(p)){
                            Toast.makeText(productFragment.this.getActivity(), p.getName()+ " da them vao gio hang \n",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(productFragment.this.getActivity(), p.getName()+ " da co o trong gio hang \n",Toast.LENGTH_SHORT).show();
                    }
            });
        }

        public void bind(Product p){
            this.p = p;
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString() );
            txtDesc.setText(p.getDesc());
        }
    }
    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>{

        List<Product> listProducts = new ArrayList<>();

        public ProductAdapter(List<Product> listProducts) {
            this.listProducts = listProducts;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product,parent,false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(listProducts.get(position));
            holder.imgDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IController controller =((MainActivity)getActivity()).controller;

                }
            });
        }

        @Override
        public int getItemCount() {
            return listProducts.size();
        }
    }


}
