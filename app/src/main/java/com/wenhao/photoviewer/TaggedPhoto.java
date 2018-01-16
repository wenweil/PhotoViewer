package com.wenhao.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by wenhao on 2017-11-04.
 */

public class TaggedPhoto implements Parcelable{

    private final SourcePhoto source;
    private String title;
    private final ArrayList<Tag> tags;

    public TaggedPhoto(SourcePhoto source){
        this(source, source.getTitle());
    }

    public TaggedPhoto(SourcePhoto source, String title){
        this.source = source;
        this.title = title;
        this.tags = new ArrayList<Tag>();
    }

    protected TaggedPhoto(Parcel source){
        this.source = (SourcePhoto) source.readParcelable(SourcePhoto.class.getClassLoader());
        this.title = source.readString();
        this.tags = new ArrayList<Tag>();
        source.readList(this.tags,Tag.class.getClassLoader());
    }

    public static final Creator<TaggedPhoto> CREATOR = new Creator<TaggedPhoto>(){
        @Override
        public TaggedPhoto createFromParcel(Parcel source) {
            return new TaggedPhoto(source);
        }

        @Override
        public TaggedPhoto[] newArray(int size) {
            return new TaggedPhoto[size];
        }
    };

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    public void addTags(Tag tag) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.source, 0);
        dest.writeString(this.title);
        dest.writeTypedList(this.tags);
    }
}
