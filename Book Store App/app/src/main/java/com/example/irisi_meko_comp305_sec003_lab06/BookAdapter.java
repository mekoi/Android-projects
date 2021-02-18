package com.example.bruno_brasil_irisi_meko_comp305_sec003_lab06;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    private ArrayList<Book> bookList;
    private OnItemClickListener bookListener;

    public interface OnItemClickListener{
        //void onItemClick(int position);
        void onAddToCartClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListener listener){
        bookListener=listener;
    }

    public BookAdapter(ArrayList<Book> List){
        bookList=List;
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent, false);
        return new BookHolder(itemView,bookListener);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Book currentbook = bookList.get(position);
        holder.textViewTitle.setText("Title: " + currentbook.getTitle());
        holder.textViewCategory.setText("Category: " + currentbook.getCategory());
        holder.textViewPrice.setText("Price: $" + String.valueOf(currentbook.getPrice()));
    }

    public static class BookHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewCategory;
        private TextView textViewPrice;
        private Button buttonAddToCard;

        public BookHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToCard=itemView.findViewById(R.id.buttonAddToCard);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null){
//                      int position = getAdapterPosition();
//                      if(position != RecyclerView.NO_POSITION){
//                          listener.onItemClick(position);
//                      }
//                    }
//                }
//            });

            buttonAddToCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onAddToCartClick(position);
                        }
                    }
                }
            });

        };
    }
}
