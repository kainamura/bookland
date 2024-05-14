package com.example.lojavirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView detailImage;
    private TextView detailName;
    private TextView detailDesc;
    private TextView detailAuthor;
    private TextView detailGender;
    private TextView detailYear;
    private TextView detailPublisher;
    private TextView detailPrice;
    private Button backButton;
    private Button buyButton;
    private ImageButton returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Book Attributes
        detailImage = findViewById(R.id.bookImageDetail);
        detailName = findViewById(R.id.bookNameDetail);
        detailDesc = findViewById(R.id.bookDescDetail);
        detailAuthor = findViewById(R.id.authorValue);
        detailGender = findViewById(R.id.genderValue);
        detailYear = findViewById(R.id.yearValue);
        detailPublisher = findViewById(R.id.publisherValue);
        detailPrice = findViewById(R.id.bookPrice);

        // Fill book information
        detailName.setText(getIntent().getStringExtra("book_name"));
        detailDesc.setText(getIntent().getStringExtra("book_desc"));
        detailAuthor.setText(getIntent().getStringExtra("author"));
        detailGender.setText(getIntent().getStringExtra("gender"));
        detailYear.setText(getIntent().getStringExtra("year"));
        detailPublisher.setText(getIntent().getStringExtra("publisher"));
        detailPrice.setText(getIntent().getStringExtra("price"));
        Glide.with(this).load(getIntent().getIntExtra("img_resource", 0)).into(detailImage);

        // Catch Buttons
        backButton = findViewById(R.id.back_button);
        buyButton = findViewById(R.id.buy_button);
        returnButton = findViewById(R.id.returnButton);

        // On Click Listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}