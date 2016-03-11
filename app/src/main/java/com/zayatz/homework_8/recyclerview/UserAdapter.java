package com.zayatz.homework_8.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zayatz.homework_8.R;
import com.zayatz.homework_8.UserInterface;
import com.zayatz.homework_8.model.User;
import com.zayatz.homework_8.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zayatz on 08.03.2016.
 */
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> userList;
    private UserInterface mUserInterface;

    public void regUserInterface(UserInterface userInterface) {
        this.mUserInterface = userInterface;
    }

    public UserAdapter() {
        userList = new ArrayList<User>();
    }

    public void userAdd (User user) {
        int position = userList.size();
        this.userList.add(position, user);
        notifyItemInserted(position);


    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).inflate(R.layout.user_card_view, viewGroup, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);

        holder.bind(userList.get(position), mUserInterface);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    /*delete user from user list*/
    public void deleteUser(User user) {
        int position = userList.indexOf(user);

        /*catch error caused double-click on delete*/
        try {
            userList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException e){
            Log.d(Constant.TAG, "IndexOutOfBoundsException caught");
        }
    }

}
