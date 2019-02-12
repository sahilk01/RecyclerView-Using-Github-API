package com.elgigs.recycleronline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends AppCompatActivity {
    String pname, bio, imgUrl;
    CircleImageView dp;
    TextView titleName, titleBio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        pname = (String)bd.get("pname");
        bio=(String )bd.get("bio");
        imgUrl=(String)bd.get("imgurl");
        dp = findViewById(R.id.profile_activity_dp);
        titleName = findViewById(R.id.profile_activity_name);
        titleBio = findViewById(R.id.profile_activity_bio);
        titleName.setText(pname);
        titleBio.setText(bio);
        Picasso.get().load(imgUrl).into(dp);


    }
}
