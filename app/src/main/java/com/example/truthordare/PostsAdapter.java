package com.example.truthordare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>
{

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
        private VideoView video;
        private TextView tvDescription;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            username = itemView.findViewById(R.id.userName);
            video = itemView.findViewById(R.id.video);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        public void bind(Post post)
        {
            //Bind the post data to the view elements
            tvDescription.setText(post.getDescription());
            username.setText(post.getUser().getUsername());
            
        }
    }


}
