package com.online_clothing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView=findViewById(R.id.recycleView);

        List<Items> itemlist = new ArrayList<>();
        try {
            FileInputStream fos = openFileInput("Item.txt");
            InputStreamReader isr=new InputStreamReader(fos);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null){
                String[] parts=line.split("->");

                int image= getResources().getIdentifier(parts[2],"drawable",getPackageName());
                itemlist.add(new Items(parts[0],parts[1],image,parts[3]));
            }

            ItemsAdapter clothesadapter=new ItemsAdapter(this,itemlist);
            recyclerView.setAdapter(clothesadapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));


        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
