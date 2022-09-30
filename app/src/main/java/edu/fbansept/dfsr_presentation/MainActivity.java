package edu.fbansept.dfsr_presentation;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private final int GALLERY_REQ_CODE = 1000;
    ImageView imgGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imgGallery = findViewById(R.id.imgGallery);
        Button btnGallery = findViewById(R.id.btnCamera);

        btnGallery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE);
            }
        });

        Button animalslist = findViewById(R.id.animalslist);
        animalslist.setOnClickListener((View) -> {
                Intent intent = new Intent(this, AnimalsList.class);
                startActivity(intent);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                imgGallery.setImageURI(data.getData());
            }
        }
    }
}