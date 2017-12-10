package com.wenhao.photoviewer;

import android.os.Parcelable;
import android.os.Parcel;
/**
 * Created by wenhao on 2017-11-04.
 */

public class Tag implements Parcelable{

    private String name;

    public Tag(String name){
        this.name = name;
    }

    public Tag(Parcel in){
        this.name = in.readString();
    }

    public static final Creator<Tag> CREATOR = new Creator<Tag>() {
        @Override
        public Tag createFromParcel(Parcel in) {
            return new Tag(in);
        }

        @Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(this.name);
    }
}
