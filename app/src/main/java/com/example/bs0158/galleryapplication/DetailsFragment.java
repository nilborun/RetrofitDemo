package com.example.bs0158.galleryapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    TextView mDetailsTextView;
//    public static DetailsFragment newInstance() {
//
//        Bundle args = new Bundle();
//        DetailsFragment fragment = new DetailsFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View v=inflater.inflate(R.layout.details_item_fragment,container,false);
        mDetailsTextView=v.findViewById(R.id.details_text);
        return v;
    }

    public void showDetailsText(String text){
        mDetailsTextView.setText(text);
    }
}
