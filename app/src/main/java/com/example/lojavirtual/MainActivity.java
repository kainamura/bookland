package com.example.lojavirtual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Variables
    private ArrayList mProductData;
    private RecyclerView recyclerView;
    private BookAdapter mAdapter;
    private ImageButton menuOpener;
    private MenuControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProductData = new ArrayList();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        mAdapter = new BookAdapter(this, mProductData);
        recyclerView.setAdapter(mAdapter);

        // Custom Menu
        menuOpener = findViewById(R.id.menuOpener);
        control = new MenuControl(this, menuOpener);
        control.showMenu();

        // Init the object and set values
        initProduct();
    }

    @Override
    protected  void onResume() {
        super.onResume();
        control.hideItem();
    }

    private void initProduct() {
        String[] titleList = getResources().getStringArray(R.array.books_titles);
        String[] descList = getResources().getStringArray(R.array.books_desc);
        String[] authorList = getResources().getStringArray(R.array.books_author);
        String[] publisherList = getResources().getStringArray(R.array.books_publisher);
        String[] yearList = getResources().getStringArray(R.array.books_year);
        String[] genderList = getResources().getStringArray(R.array.books_gender);
        String[] priceList = getResources().getStringArray(R.array.books_price);
        TypedArray imgList = getResources().obtainTypedArray(R.array.books_img);

        mProductData.clear();

        for (int i = 0; i < titleList.length; i++) {
            mProductData.add(new Book(titleList[i], descList[i], imgList.getResourceId(i, 0), authorList[i], genderList[i], yearList[i], publisherList[i], priceList[i]));
        }

        imgList.recycle();
    }


}