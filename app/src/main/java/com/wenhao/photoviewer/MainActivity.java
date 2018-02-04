package com.wenhao.photoviewer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button galleryButton = (Button) findViewById(R.id.Start);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(MainActivity.this,
                        GalleryActivity.class);
                startActivity(galleryIntent);
            }
        });
    }

    public static TaggedPhoto[] getTaggedPhotos(){
        SourcePhoto[] sourcePhotos = MainActivity.getSourcePhoto();
        List<TaggedPhoto> temp = new ArrayList<TaggedPhoto>();
        for(SourcePhoto photo: sourcePhotos){
            temp.add(new TaggedPhoto(photo));
        }
        TaggedPhoto taggedPhoto[] = temp.toArray(new TaggedPhoto[temp.size()]);
        return taggedPhoto;
    }
    
    private static SourcePhoto[] getSourcePhoto(){
        return new SourcePhoto[]{
                new SourcePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                new SourcePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                new SourcePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                new SourcePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                new SourcePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                new SourcePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
        };
    }
}
