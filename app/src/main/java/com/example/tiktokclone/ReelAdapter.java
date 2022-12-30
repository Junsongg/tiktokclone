package com.example.tiktokclone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.databinding.ReelDesignBinding;

import java.util.ArrayList;

public class ReelAdapter extends RecyclerView.Adapter<ReelAdapter.ReelHolder>{

    Context mContext;
    ArrayList<Reel> reelArrayList;
    MediaPlayer mp;
    Boolean isPlaying = false;

    public ReelAdapter(Context mContext, ArrayList<Reel> reelArrayList) {
        this.mContext = mContext;
        this.reelArrayList = reelArrayList;
    }

    @NonNull
    @Override
    public ReelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.reel_design, parent, false);
        return new ReelHolder(view);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull ReelHolder holder, int position) {
        holder.binding.vvReel.setVideoPath(reelArrayList.get(position).getVideoUrl());
        holder.binding.tvVideoAuthorName.setText(reelArrayList.get(position).getName());
        holder.binding.ivProfileImage.setImageResource(reelArrayList.get(position).getProfileImage());
        holder.binding.vvReel.setOnPreparedListener(mediaPlayer -> {
            mp = mediaPlayer;
            if(mp.isPlaying()){
                mp.stop();
                mp.release();
                mp = new MediaPlayer();
            }
            mediaPlayer.start();
            isPlaying = true;
        });
        holder.binding.vvReel.setOnCompletionListener(mediaPlayer -> {
            mediaPlayer.start();
            isPlaying = true;
        });
        holder.binding.vvReel.setOnTouchListener((view, motionEvent) -> {
            if(isPlaying){
                mp.pause();
                isPlaying = false;
            }else{
                mp.start();
                isPlaying = true;
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return reelArrayList.size();
    }

    public static class ReelHolder extends RecyclerView.ViewHolder {
        ReelDesignBinding binding;

        public ReelHolder(@NonNull View itemView) {
            super(itemView);
            binding = ReelDesignBinding.bind(itemView);
        }
    }
}
