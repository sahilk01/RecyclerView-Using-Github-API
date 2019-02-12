package com.elgigs.recycleronline;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {
    private Context context;
    private User[] data;
    public GithubAdapter (Context context, User[] data)
    {
            this.context = context;
            this.data = data;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycleview_layout, viewGroup, false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder githubViewHolder, int i) {
        final User user = data[i];
        githubViewHolder.pname.setText(user.getLogin());
        Picasso.get().load(user.getAvatarUrl()).into(githubViewHolder.proPic);
        githubViewHolder.bio.setText(user.getType());
        githubViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent openProfile = new Intent(context, profile.class);
                openProfile.putExtra("pname", user.getLogin());
                openProfile.putExtra("imgurl", user.getAvatarUrl());
                openProfile.putExtra("bio", user.getType());
                context.startActivity(openProfile);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView proPic;
        TextView pname, bio;
        Context context;
        ItemClickListener itemClickListener;
        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);
            proPic = itemView.findViewById(R.id.profle_pic);
            pname = itemView.findViewById(R.id.perosn_name);
            bio = itemView.findViewById(R.id.person_bio);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }
    }
}
