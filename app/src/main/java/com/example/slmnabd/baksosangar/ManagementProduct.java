package com.example.slmnabd.baksosangar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ManagementProduct extends AppCompatActivity {

    final int REQUEST_CODE_GALLERY=999;
    EditText namaMenu, harga;
    ImageView foto;
    Button simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_product);

        //inisialisasi variabel
        foto     = (ImageView)findViewById(R.id.fotoMenu);
        namaMenu = (EditText)findViewById(R.id.namaMenu);
        harga    = (EditText)findViewById(R.id.harga);
        simpan   = (Button)findViewById(R.id.simpanMenu);

        //membuat imageView jadi onClick
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        ManagementProduct.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, //request permission gallery
                        REQUEST_CODE_GALLERY
                );
            }
        });
    }

    //akses gallery
    @Override
    public void onRequestPermissionsResult (int RequestCode, @NonNull String [] permissions, @NonNull int[] grandResult ){
        if (RequestCode == REQUEST_CODE_GALLERY){
            if (grandResult.length>0 && grandResult[0]== PackageManager.PERMISSION_GRANTED){
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(this, "Don't have permission to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(RequestCode, permissions, grandResult);
    }

    //input image
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){

        if(resultCode != RESULT_CANCELED){

            Uri resultUri = data.getData();
            foto.setImageURI(resultUri);

        }


        super.onActivityResult(requestCode,resultCode,data);
    }


}
