package com.example.bs0158.galleryapplication;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GalleryActivity extends AppCompatActivity implements Communication{

    PhotoFragment mListfragment;
    DetailsFragment mDetailsFragment;
//    @Override
//    protected Fragment creatFragment() {
//        return PhotoFragment.newInstance();
//    }

    @LayoutRes
    private int getlayoutId(){
        return R.layout.activity_gallery;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        FragmentManager fragmentManager = getSupportFragmentManager();
        mListfragment = new PhotoFragment();
       mDetailsFragment = new DetailsFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.list_container, mListfragment);
        transaction.add(R.id.details_container, mDetailsFragment);
        transaction.commit();
    }

    @Override
    public void sendData(String text) {
        mDetailsFragment.showDetailsText(text);

    }
}
