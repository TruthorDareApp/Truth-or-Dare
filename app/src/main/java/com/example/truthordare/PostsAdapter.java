package com.example.truthordare;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>
{
    public static final String TAG = "PostsAdapter";
    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts)
    {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount()
    {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        private TextView username;
        private VideoView videoView;
        private TextView tvDescription;
        private TextView likes;
        private TextView price;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            username = itemView.findViewById(R.id.userName);
            videoView = itemView.findViewById(R.id.video);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            likes = itemView.findViewById(R.id.likes);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(Post post)
        {
            //Bind the post data to the view elements
            tvDescription.setText(post.getDescription());
            username.setText(post.getUser().getUsername());
            likes.setText(post.getLikeCount() + " likes");
            price.setText("$" + post.getDollarAmt() + " ");
            ParseFile postVideo = post.getVideo();

            if (postVideo != null)
            {
                String url = postVideo.getUrl();
                Log.i(TAG, "set video");
                videoView.setVideoURI(Uri.parse(url));
                videoView.start();

                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        videoView.start();
                    }
                });

                //pause/play on video touch
                videoView.setOnTouchListener(new View.OnTouchListener() {

                    int currentPosition;
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if(videoView.isPlaying()) {
                            videoView.pause();
                            currentPosition = videoView.getCurrentPosition();
                        }
                        else {
                            videoView.start();
                        }
                        return false;
                    }
                });
            }

        }
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Post> allPosts) {
        posts.addAll(allPosts);
        notifyDataSetChanged();
    }
}
