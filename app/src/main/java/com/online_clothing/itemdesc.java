package com.online_clothing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class itemdesc extends AppCompatActivity {

    CircleImageView imgview;
    TextView tvname,tvprice,tvdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdesc);


        imgview=findViewById(R.id.imgProfile);
        tvname=findViewById(R.id.tvName);
        tvprice=findViewById(R.id.tvPrice);
        tvdesc=findViewById(R.id.tvDesc);


        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){
            imgview.setImageResource(bundle.getInt("image"));
            tvname.setText("name: "+bundle.getString("name"));
            tvprice.setText("Price: "+bundle.getString("price"));
            tvdesc.setText("Description: "+bundle.getString("desc"));

        }

    }
}
