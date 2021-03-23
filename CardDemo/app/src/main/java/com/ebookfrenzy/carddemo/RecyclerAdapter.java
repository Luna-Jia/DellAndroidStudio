package com.ebookfrenzy.carddemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;

import java.util.Random;

public class RecyclerAdapter
        extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Data data = new Data();

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View v) {

                    Intent i = new Intent(v.getContext(), RecievingActivity.class);
                    String titleText = itemTitle.getText().toString();
                    String detailText = itemDetail.getText().toString();

                    Drawable drawable = itemImage.getDrawable();
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();

                    i.putExtra("picture", b);
                    i.putExtra("titleText", titleText);
                    i.putExtra("detailText", detailText);
                    v.getContext().startActivity(i);
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Random rand = new Random();
        int size = data.getArrCount();

        int n=rand.nextInt(size);
        viewHolder.itemTitle.setText(data.getTitles(n));

        n=rand.nextInt(size);
        viewHolder.itemDetail.setText(data.getDetails(n));

        n=rand.nextInt(size);
        viewHolder.itemImage.setImageResource(data.getImages(n));
    }

    @Override
    public int getItemCount() {
        return data.getArrCount();
    }
}