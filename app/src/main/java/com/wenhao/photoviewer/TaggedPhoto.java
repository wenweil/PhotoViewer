package com.wenhao.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by wenhao on 2017-11-04.
 */

public class TaggedPhoto implements Parcelable{

    private final SourcePhoto mSource;
    private String mTitle;
    private final Set<Tag> mTags;

    public TaggedPhoto(SourcePhoto source){
        this(source, source.getTitle());
    }

    public TaggedPhoto(SourcePhoto source, String title){
        this.mSource = source;
        this.mTitle = title;
        this.mTags = new HashSet<Tag>();
    }

    protected TaggedPhoto(Parcel source){
        this.mSource = (SourcePhoto) source.readParcelable(SourcePhoto.class.getClassLoader());
        this.mTitle = source.readString();
        ArrayList<Tag> tempTags = new ArrayList<Tag>();
        source.readList(tempTags,Tag.class.getClassLoader());
        this.mTags = new HashSet<Tag>(tempTags);
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
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public Set<Tag> getTags() {
        return this.mTags;
    }

    public void addTag(Tag tag) {
        this.mTags.add(tag);
    }

    public void removeTag(Tag tag){
        this.mTags.remove(tag);
    }

    public void removeAllTags(){
        this.mTags.clear();
    }

    public String getSourceTitle(){
        return this.mSource.getTitle();
    }

    public String getSourceFile(){
        return this.mSource.getSourceFile();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mSource, 0);
        dest.writeString(this.mTitle);
        ArrayList<Tag> tempTags = new ArrayList<Tag>(this.mTags);
        dest.writeTypedList(tempTags);
    }
}
