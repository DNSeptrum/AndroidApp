package com.example.javaandriod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoPagerAdapter extends RecyclerView.Adapter<PhotoPagerAdapter.PhotoViewHolder> {

    private Context context;
    private int[] photoResIds;
    private String[] photoNames;

    public PhotoPagerAdapter(Context context, int[] photoResIds, String[] photoNames) {
        this.context = context;
        this.photoResIds = photoResIds;
        this.photoNames = photoNames;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, final int position) {
        holder.imageView.setImageResource(photoResIds[position]);

        // Dodaj obsługę kliknięcia na zdjęcie
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPhotoDialog(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoResIds.length;
    }

    private void showPhotoDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(photoNames[position]);

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(photoResIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        builder.setView(imageView);
        builder.setPositiveButton("OK", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}