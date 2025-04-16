package com.example.mercedesbenzcardiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] mercedesBenzNames = {
            "Mercedes G63",
            "X-Class",
            "EQS",
            "Maxresdefault",
            "2011 C-Class",
            "2024 G-Class",
            "2022 GLC",
            "C300 AMG"
    };

    int[] mercedesBenzImages = {
            R.drawable.mercedes1,
            R.drawable.mercedes2,
            R.drawable.mercedes3,
            R.drawable.mercedes4,
            R.drawable.mercedes5,
            R.drawable.mercedes6,
            R.drawable.mercedes7,
            R.drawable.mercedes8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.wildCatGridView);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
            intent.putExtra("mercedesBenzName", mercedesBenzNames[position]);
            intent.putExtra("mercedesBenzImage", mercedesBenzImages[position]);
            startActivity(intent);
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mercedesBenzImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View gridItem = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView textView = gridItem.findViewById(R.id.mercedesBenz);
            ImageView imageView = gridItem.findViewById(R.id.mercedesBenzImage); // Corrected ID

            textView.setText(mercedesBenzNames[position]);
            imageView.setImageResource(mercedesBenzImages[position]);

            return gridItem;
        }
    }
}
