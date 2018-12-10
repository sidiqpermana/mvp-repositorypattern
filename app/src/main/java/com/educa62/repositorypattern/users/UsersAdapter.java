package com.educa62.repositorypattern.users;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.educa62.repositorypattern.R;
import com.educa62.repositorypattern.model.User;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<User> listData;


    public interface onItemClickListener {
        void onItemClick(User user);
    }

    public UsersAdapter(List<User> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewRoot = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new MyViewHolder(viewRoot);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        User myModel = listData.get(i);
        myViewHolder.bind(myModel);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName, itemUsername, itemEmail;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemUsername = (TextView) itemView.findViewById(R.id.item_username);
            itemEmail = (TextView) itemView.findViewById(R.id.item_email);

        }


        private void bind(final User data) {
            itemName.setText(data.name);
            itemUsername.setText(data.username);
            itemEmail.setText(data.email);
        }


    }

}
