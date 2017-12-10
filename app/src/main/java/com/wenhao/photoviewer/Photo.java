package com.wenhao.photoviewer;

import java.util.ArrayList;

/**
 * Created by wenhao on 2017-11-04.
 */

public class Photo {

    private String sourceFile;
    private String sourceTitle;
    private String title;
    private ArrayList<Tag> tags;


    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourceTitle() {
        return sourceTitle;
    }

    public void setSourceTitle(String sourceTitle) {
        this.sourceTitle = sourceTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }



}
