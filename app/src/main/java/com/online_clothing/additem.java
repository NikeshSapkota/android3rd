package com.online_clothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class additem extends AppCompatActivity {

    private Spinner spImage;
    private EditText etItemName, etItemPrice, etDes;
    private Button btnAddd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);


        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);
        etDes = findViewById(R.id.etDes);
        btnAddd = findViewById(R.id.btnAddd);

        spImage = findViewById(R.id.spImage);

        String[] items = new String[]{"tshirt", "pants", "hat", "shoes"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spImage.setAdapter(adapter);

        btnAddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Save();

            }
        });

    }


    private void Save()
    {
        try {
            PrintStream printstream = new PrintStream(openFileOutput("Item.txt", MODE_PRIVATE | MODE_APPEND));
            printstream.println(etItemName.getText().toString() + "->" + etItemPrice.getText().toString()
                    + "->" + spImage.getSelectedItem().toString() + "->" + etDes.getText().toString());

            Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(additem.this, MainActivity.class);
            startActivity(intent);
        }
        catch (IOException e)
        {
            Log.d("ITEM APP", "ERROR" + e.toString());
            e.printStackTrace();
        }

    }

}
