package com.example.ashiagrawal.loginscreen;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ashiagrawal on 6/16/16.
 */
public class MemeAdapter extends ArrayAdapter<Meme> {

    public MemeAdapter(Context context, ArrayList<Meme> meme) {
        super(context, R.layout.item_meme, meme);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Meme Meme = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_meme, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        ImageView ivMeme = (ImageView) convertView.findViewById(R.id.ivMeme);
        tvName.setText(Meme.name);
        String imageUrl = Meme.imageURL;
        Picasso.with(getContext()).load(imageUrl).into(ivMeme);

        Log.d("MemesAdapter", "Position: " + position);

        //ivPoster.set
        return convertView;
    }

}