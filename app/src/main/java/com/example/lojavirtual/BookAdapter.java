package com.example.lojavirtual;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private ArrayList<Book> mBookData;
    private LayoutInflater mInflater;
    private Context mContext;

    public BookAdapter(Context context, ArrayList<Book> book) {
        mInflater = LayoutInflater.from(context);
        this.mBookData = book;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.product_item, parent, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {
        Object currentProduct = mBookData.get(position);
        holder.bindTo((Book) currentProduct);
    }

    @Override
    public int getItemCount() {
        return mBookData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mProductTitle;
        private TextView mProductDesc;
        private ImageView mProductImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mProductTitle = itemView.findViewById(R.id.bookName);
            mProductDesc = itemView.findViewById(R.id.bookDesc);
            mProductImg = itemView.findViewById(R.id.bookImage);

            itemView.findViewById(R.id.see_more_button).setOnClickListener(this);
        }

        void bindTo(Book currentBook) {
            mProductTitle.setText(currentBook.getName());
            mProductDesc.setText(currentBook.getDescription());
            Glide.with(mContext).load(currentBook.getImageResource()).into(mProductImg);
        }

        @Override
        public void onClick(View view) {
            Book currentBook = mBookData.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("book_name", currentBook.getName());
            detailIntent.putExtra("book_desc", currentBook.getDescription());
            detailIntent.putExtra("img_resource", currentBook.getImageResource());
            detailIntent.putExtra("author", currentBook.getAuthor());
            detailIntent.putExtra("gender", currentBook.getGender());
            detailIntent.putExtra("year", currentBook.getYear());
            detailIntent.putExtra("publisher", currentBook.getPublisher());
            detailIntent.putExtra("price", currentBook.getPrice());
            mContext.startActivity(detailIntent);
        }

    }
}
