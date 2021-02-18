package com.example.bruno_brasil_irisi_meko_comp305_sec003_lab06;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String CART = "Bruno_Brasil_Irisi_Meko_COMP305_Sec003_Lab06";

    private RecyclerView bookRecyclerView;
    private BookAdapter bookAdapter;
    private  RecyclerView.LayoutManager bookLayoutManager;
    private ArrayList<Book> books;
    private Cart shoppingCart = new Cart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        createBooksList();
        buildRecyclerView();
    }

    public void createBooksList(){
        books = new ArrayList<Book>();
        books.add(new Book("Eight Years of Solitude     ","Novel",50.99,0));
        books.add(new Book("Light and Thunder Story   ","Novel",41.99,0));
        books.add(new Book("The Old Man and The Sea","Novel",31.99,0));
    }

    public void buildRecyclerView(){

        bookRecyclerView = findViewById(R.id.recyclerViewBook);
        bookRecyclerView.setHasFixedSize(true);
        bookLayoutManager=new LinearLayoutManager(this);
        bookAdapter=new BookAdapter(books);
        bookRecyclerView.setLayoutManager(bookLayoutManager);
        bookRecyclerView.setAdapter(bookAdapter);

        bookAdapter.setOnItemClickListner(new BookAdapter.OnItemClickListener() {

//            @Override
//            public void onItemClick(int position) {
//                books.get(position);
//                bookAdapter.notifyItemChanged(position);
//            }

            @Override
            public void onAddToCartClick(int position) {
                Book book=new Book();
                book=books.get(position);
                shoppingCart.addToCart(book);
                Toast.makeText(getApplicationContext(), book.getTitle() +" is added to your cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showShoppingCart(View view) {
        Gson gson = new Gson();
        Intent intent = new Intent(getBaseContext(), CartActivity.class);
        intent.putExtra(CART, gson.toJson(shoppingCart));
        startActivity(intent);
        shoppingCart = new Cart();
    }
}