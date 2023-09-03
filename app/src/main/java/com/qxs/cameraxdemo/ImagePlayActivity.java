package com.qxs.cameraxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.qxs.cameraxdemo.databinding.ActivityImagePlayBinding;

import java.io.File;
import java.io.IOException;

public class ImagePlayActivity extends AppCompatActivity {
    private ActivityImagePlayBinding binding;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImagePlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
    }

    private void initData(){
        Intent intent = getIntent();
        imageUri = intent.getData();
        Glide.with(this).load(imageUri).into(binding.imvPicture);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}