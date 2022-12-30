package com.example.tiktokclone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.tiktokclone.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Reel> reelArrayList;
    ReelAdapter reelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        reelArrayList = new ArrayList<>();
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.a, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.b, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.c, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.d, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.e, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.f, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.g,"Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.h, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.i, "Jannniceee", R.drawable.ic_person));
        reelArrayList.add(new Reel("android.resource://" + getPackageName() + "/" + R.raw.j, "Jannniceee", R.drawable.ic_person));
        reelAdapter = new ReelAdapter(MainActivity.this, reelArrayList);
        binding.vpReel.setAdapter(reelAdapter);
    }
}