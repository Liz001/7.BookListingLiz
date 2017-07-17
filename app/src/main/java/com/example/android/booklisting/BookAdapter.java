package com.example.android.booklisting;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by Liz on 06/06/2017.
 */

public class BookAdapter  extends ArrayAdapter<Book>{

    private final static String AUTHOR = "Author: ";
    private final static String PUBLISHER = "Publisher: ";
    public BookAdapter (Activity context, ArrayList<Book> books){
        super(context,0,books);
    }
    private static class ViewHolder {
        ImageView thumbnail;
        TextView bookTitle;
        TextView author;
        TextView publisher;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        View bookList = convertView;
        if (bookList == null){
            bookList = LayoutInflater.from(getContext()).inflate(R.layout.book_listing_sample,parent,false);
            holder = new ViewHolder();
            holder.thumbnail = (ImageView)bookList.findViewById(R.id.thumbnail);
            holder.bookTitle = (TextView) bookList.findViewById(R.id.book_title);
            holder.author = (TextView) bookList.findViewById(R.id.author);
            holder.publisher = (TextView) bookList.findViewById(R.id.publisher);
            bookList.setTag(holder);
        }else {
            holder = (ViewHolder)bookList.getTag();
        }
        Book currentBook = getItem(position);
        //we use Picasso Library to convert the url from JSONObject imageLinks to a image(@thumbnail)
        Picasso.with(getContext()).load(currentBook.getThumbnail()).into(holder.thumbnail);

        holder.bookTitle.setText(currentBook.getTitle());
        holder.author.setText(AUTHOR + currentBook.getAuthor());
        holder.publisher.setText(PUBLISHER + currentBook.getPublisher());
        return bookList;
    }
}
