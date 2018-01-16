package com.wenhao.photoviewer;

import android.os.Parcelable;
import android.os.Parcel;
/**
 * Created by wenhao on 2017-11-04.
 */

public final class Tag implements Parcelable{

    private final String name;

    public Tag(String name){
        this.name = name;
    }

    public Tag(Parcel source){
        this.name = source.readString();
    }

    public static final Creator<Tag> CREATOR = new Creator<Tag>() {
        @Override
        public Tag createFromParcel(Parcel source) {
            return new Tag(source);
        }

        @Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };

    public String getName() {
        return name;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i){
        dest.writeString(this.name);
    }
}
