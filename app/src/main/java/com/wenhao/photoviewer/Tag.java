package com.wenhao.photoviewer;

import android.os.Parcelable;
import android.os.Parcel;
/**
 * Created by wenhao on 2017-11-04.
 */

public final class Tag implements Parcelable{

    private final String mName;

    public Tag(String name){
        this.mName = name;
    }

    public Tag(Parcel source){
        this.mName = source.readString();
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
        return mName;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i){
        dest.writeString(this.mName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return this.mName != null ? this.mName.equals(tag.mName) : tag.mName == null;
    }

    @Override
    public int hashCode() {
        return this.mName != null ? this.mName.hashCode() : 0;
    }
}
