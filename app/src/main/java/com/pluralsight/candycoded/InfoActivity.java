package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    /**
     * This method creates a Uri and passes it as a parameter in an
     * {@link Intent}.
     * Then Starts an activity if @see #getPackageManager is not null
     *
     * @param view an instance of {@link View}
     */
    public void createMapIntent(View view) {

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801"));
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mapIntent);
        }
    }

    /**
     * This method will attach to a click view.
     * Create an intent and sets data
     * @param view instance {@link View}
     */
    public void createPhoneIntent(View view) {

        String stringIntent = Intent.ACTION_DIAL;
        Intent intent = new Intent(stringIntent);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }
}
