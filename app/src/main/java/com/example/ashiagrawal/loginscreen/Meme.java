package com.example.ashiagrawal.loginscreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ashiagrawal on 6/16/16.
 */
public class Meme {
    public static final String MEME_DATABASE_URL = "http://version1.api.memegenerator.net/Instances_Select_ByPopular";
    public String name;
    public String imageURL;

    public Meme(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public static ArrayList<Meme> fromJsonList(JSONObject response){
        JSONArray memeList = new JSONArray();
        try {
            memeList = response.getJSONArray("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList<Meme> returnList = new ArrayList<Meme>();
        JSONObject memeJSON;
        for (int i = 0; i < memeList.length(); i ++) {
            try {
                memeJSON = memeList.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Meme meme = Meme.fromJson(memeJSON);
            if (meme != null) {
                returnList.add(meme);
            }
        }
        return returnList;
    }

    private static Meme fromJson(JSONObject memeJSON){
        String name;
        String imageURL;
        try {
            name = memeJSON.getString("displayName");
            imageURL = memeJSON.getString("imageUrl");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        Meme newMeme = new Meme (name, imageURL);
        return newMeme;
    }

    @Override
    public String toString() {
        return name;
    }
}