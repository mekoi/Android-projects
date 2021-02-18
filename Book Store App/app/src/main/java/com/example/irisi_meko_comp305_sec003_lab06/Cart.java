package com.example.bruno_brasil_irisi_meko_comp305_sec003_lab06;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart {
    ArrayList<Book> shoppingCart = new ArrayList<Book>();

    public void addToCart(Book book) {
        String toastString="";
        int pos=existInCard(book);
        if (pos==-1){
            shoppingCart.add(book);
            book.setQuantity(1);
        }
        else{
            shoppingCart.get(pos).setQuantity(shoppingCart.get(pos).getQuantity() + 1);
        }
    }

    public int existInCard(Book book) {
        int pos=-1;
        for(int i=0;i<shoppingCart.size();i++)
        {
            if(shoppingCart.get(i).getTitle()==book.getTitle()){
                pos=i;
                break;
            }
        }
        return pos;
    }
}
