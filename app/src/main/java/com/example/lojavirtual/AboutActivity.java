package com.example.lojavirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutActivity extends AppCompatActivity {
    private ImageButton menuOpener;
    private MenuControl control;
    private ImageButton returnButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        menuOpener = findViewById(R.id.menuOpener);
        control = new MenuControl(this, menuOpener);
        control.showMenu();

        returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected  void onResume() {
        super.onResume();
        control.hideItem();
    }
}