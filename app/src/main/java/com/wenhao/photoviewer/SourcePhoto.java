package com.wenhao.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


/**
 * Created by wenha on 2018-01-15.
 */

public final class SourcePhoto implements Parcelable{

    private final String sourceFile;
    private final String title;

    public SourcePhoto(String sourceFile, String title){
        this.sourceFile = sourceFile;
        this.title = title;
    }

    public SourcePhoto(Parcel source){
        this.sourceFile = source.readString();
        this.title = source.readString();
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
        return this.sourceFile;
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sourceFile);
        dest.writeString(this.title);

    }
}
