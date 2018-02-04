package com.wenhao.photoviewer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;

/**
 * Created by wenhao on 2018-01-16.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder>{

    private Context mContext;
    private TaggedPhoto[] mTaggedPhotos;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView mPhotoImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                TaggedPhoto taggedPhoto = mTaggedPhotos[position];
                Intent intent = new Intent(mContext, TaggedPhotoActivity.class);
                intent.putExtra(TaggedPhotoActivity.EXTRA_TAGGED_PHOTO, taggedPhoto);
                mContext.startActivity(intent);
            }
        }
    }

    public GalleryAdapter(Context context, TaggedPhoto[] taggedPhotos){
        this.mContext = context;
        this.mTaggedPhotos = taggedPhotos;
    }


    @Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.photo_item, parent, false);
        GalleryAdapter.MyViewHolder viewHolder = new GalleryAdapter.MyViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.MyViewHolder holder, int position) {
        TaggedPhoto taggedPhoto = mTaggedPhotos[position];
        ImageView imageView = holder.mPhotoImageView;

       Glide.with(mContext)
                .load(taggedPhoto.getSourceFile())
                .placeholder(R.drawable.ic_place_holder)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return mTaggedPhotos.length;
    }
}
