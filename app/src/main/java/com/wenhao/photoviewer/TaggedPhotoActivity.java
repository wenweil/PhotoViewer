package com.wenhao.photoviewer;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.wenhao.photoviewer.databinding.ActivityTaggedPhotoBinding;

public class TaggedPhotoActivity extends AppCompatActivity {

    public static final String EXTRA_TAGGED_PHOTO = "TaggedPhotoActivity.TAGGED_PHOTO";

    private ImageView mImageView;
    private ActivityTaggedPhotoBinding mBinding;
    private TaggedPhoto mTaggedPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_tagged_photo);

        mImageView = (ImageView) findViewById(R.id.image);
        mTaggedPhoto = getIntent().getParcelableExtra(EXTRA_TAGGED_PHOTO);


        mBinding.setNameSource(mTaggedPhoto);
        mBinding.setOnClickListener(this);

        Glide.with(this)
                .load(mTaggedPhoto.getSourceFile())
                .asBitmap()
                .error(R.drawable.ic_place_holder)
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target,
                                               boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap>
                            target, boolean isFromMemoryCache, boolean isFirstResource) {

                        onPalette(Palette.from(resource).generate());
                        mImageView.setImageBitmap(resource);

                        return false;
                    }

                    public void onPalette(Palette palette){
                        if(palette != null){
                            ViewGroup parent = (ViewGroup) mImageView.getParent().getParent();
                            parent.setBackgroundColor(Color.WHITE);
                        }
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }

    public void onClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = input.getText().toString();
                mTaggedPhoto.setTitle(title != null && !title.isEmpty() ?
                        title : mTaggedPhoto.getTitle());
                mBinding.setNameSource(mTaggedPhoto);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


}
