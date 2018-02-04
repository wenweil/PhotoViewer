package com.wenhao.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;


/**
 * Created by wenhao on 2018-01-15.
 */

public final class SourcePhoto implements Parcelable{

    private final String mSourceFile;
    private final String mTitle;

    public SourcePhoto(String sourceFile){
        this(sourceFile, (new File(sourceFile)).getName());
    }

    public SourcePhoto(String sourceFile, String title){
        this.mSourceFile = sourceFile;
        this.mTitle = title;
    }

    public SourcePhoto(Parcel source){
        this.mSourceFile = source.readString();
        this.mTitle = source.readString();
    }

    public static final Creator<SourcePhoto> CREATOR = new Creator<SourcePhoto>(){

        @Override
        public SourcePhoto createFromParcel(Parcel source) {
            return new SourcePhoto(source);
        }

        @Override
        public SourcePhoto[] newArray(int size) {
            return new SourcePhoto[size];
        }
    };

    public String getSourceFile(){
        return this.mSourceFile;
    }

    public String getTitle(){
        return this.mTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mSourceFile);
        dest.writeString(this.mTitle);

    }
}
