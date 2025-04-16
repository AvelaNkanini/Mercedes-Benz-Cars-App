package com.example.mercedesbenzcardiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GridItemActivity extends AppCompatActivity {

    TextView mercedesBenzName;
    ImageView mercedesBenzImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        // Corrected IDs based on updated XML
        mercedesBenzName = findViewById(R.id.mercedesBenz);
        mercedesBenzImage = findViewById(R.id.mercedesBenzImage);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("mercedesBenzName");
            int imageId = intent.getIntExtra("mercedesBenzImage", R.drawable.mercedes1);

            mercedesBenzName.setText(name);
            mercedesBenzImage.setImageResource(imageId);
        }
    }
}
