package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{
    Context context;
    List<Tweet> tweets;
    // Pass in the context and list of tweets

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // For each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    // Bind values based ont he position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    // Get the data at postiion
        Tweet tweet = tweets.get(position);
        // Bind the tweet with the view holder
        holder.bind(tweet); // Create a method that would bind them together 

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    /** SWIPE REFRESH: clear() and addAll(list) **/
    // Clean all elements of the recycler
    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }
    // Add a list of items -- change to type used
    public void addAll(List<Tweet> tweetlist){
        tweets.addAll(tweetlist);
        notifyDataSetChanged();
    }

    // Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;

        // itemview: one row in the recycler view
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreen);
        }

        public void bind(Tweet tweet) {
            // Use to fill out the inputs
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);
        }
    }
}
