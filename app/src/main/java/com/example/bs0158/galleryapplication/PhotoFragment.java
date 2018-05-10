package com.example.bs0158.galleryapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoFragment extends Fragment {
    private List<Photo> mPhotos;
    private static final String TAG="PhotoFragment";
    private RecyclerView mPhotoRecylerview;
    Communication mCommunication;
//    public static PhotoFragment newInstance() {
//
//        Bundle args = new Bundle();
//
//        PhotoFragment fragment = new PhotoFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view=inflater.inflate(R.layout.photo_fragment,container,false);
         mPhotoRecylerview=view.findViewById(R.id.photo_fragment_recyclerview);
         mPhotoRecylerview.setLayoutManager(new GridLayoutManager(getActivity(),3));
         mCommunication=(Communication)getActivity();
         getAllPhotosInformation();
         getUserInfo();
         return view;
    }

    private void getUserInfo(){
        ApiInterface apiservice=ApiClient.getClient2("Bearer PJApHJ6oAZwWXVKGsKXnea8N38yDu6d-sH9ZVdCWiauWG8ifilyUH_I6P-sZzXtyz_GfVSnRyQA_Yq7CXypTImxKT6TETc5LQ-XKWjbxEITwDbyJotbOQIgqv3yd7dbtkP7yq6QeUWS8zKT6tvQHBESM9u7SW5Ty19YcCrhb8Q1IJ-XmulMM12QQs21B2vU7BoTZ2J-U2YghZOy9Gka68H17U-tkEl7OpxljKAnvZK4")
                .create(ApiInterface.class);
        Employee emp=new Employee();
        emp.setEmpcode("1000069");
        Call<User> userinfo=apiservice.getUserInfo(emp);
        userinfo.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user=response.body();
                Log.d(TAG,user.getBloodGroup());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG,"Exception: "+t.getMessage());

            }
        });

    }

    private void getAllPhotosInformation(){
        ApiInterface apiService=ApiClient.getClient().create(ApiInterface.class);

        Call<List<Photo>> photos=apiService.getAllPhotosInfo("abc123");

        photos.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                mPhotos=response.body();
                Log.e(TAG,"Success");
                mPhotoRecylerview.setAdapter(new PhotoAdapter(mPhotos));
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.e(TAG,t.getMessage());

            }
        });
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {
        private ImageView mPhotoImageView;

        public PhotoHolder(View view){
            super(view);
            mPhotoImageView=(ImageView) view.findViewById(R.id.photo_image_view);

        }

        public void setPhotoImageView(String url, final String text){
            Picasso.get().load(url).into(mPhotoImageView);
            mPhotoImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCommunication.sendData(text);
                }
            });



        }

    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder>{
        List<Photo> mPhotos;

        public PhotoAdapter(List<Photo> photos){
            mPhotos=photos;
        }

        @NonNull
        @Override
        public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            View view=inflater.inflate(R.layout.list_item,parent,false);
            return new PhotoHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
            Photo photo=mPhotos.get(position);
            holder.setPhotoImageView(photo.getPhotoUrl(),photo.getText());
        }

        @Override
        public int getItemCount() {
            return mPhotos.size();
        }
    }

}
