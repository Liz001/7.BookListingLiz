package com.example.android.booklisting;

/**
 * Created by Liz on 06/06/2017.
 */

public class Book {

    private String mThumbnail;
    private String mTitle;
    private StringBuilder mAuthor;
    private String mPublisher;
    private String mUrl;

    public Book(String thumbnail, String title, StringBuilder author, String publisher, String url) {

        mThumbnail = thumbnail;
        mTitle = title;
        mAuthor = author;
        mPublisher = publisher;
        mUrl = url;
    }
    public String getThumbnail(){return  mThumbnail;}

    public String getTitle() {
        return mTitle;
    }

    public StringBuilder getAuthor() {
        return mAuthor;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public String getUrl(){return mUrl;}
}
