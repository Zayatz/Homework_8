package com.zayatz.homework_8.recyclerview;

import android.graphics.Color;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;;

import com.zayatz.homework_8.R;
import com.zayatz.homework_8.UserInterface;
import com.zayatz.homework_8.model.User;

/**
 * Created by Zayatz on 08.03.2016.
 */
public class UserViewHolder extends RecyclerView.ViewHolder {

    protected TextView mUserName;
    protected ImageButton mDelBtn;
    protected RelativeLayout mCardBackground;

    UserViewHolder(View itemView) {
        super(itemView);

        mCardBackground = (RelativeLayout) itemView.findViewById(R.id.card_view_background);
        mUserName = (TextView) itemView.findViewById(R.id.user_name_card_view);
        mDelBtn = (ImageButton) itemView.findViewById(R.id.user_del_button);
    }

    public void bind(final User user, final UserInterface userInterface) {

        /*set background depends on secondary fields*/
        if (user.haveSecondaryEmpty()) mCardBackground.setBackgroundColor(Color.RED);
        else mCardBackground.setBackgroundColor(Color.YELLOW);

        this.mUserName.setText(user.getFirstName());

        /*name and delete click listeners*/
        View.OnClickListener itemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.user_del_button:
                        userInterface.onDeleteClick(user);
                        break;
                    case R.id.user_name_card_view:
                        userInterface.onUserClick(user);
                        break;
                }
            }
        };

        mUserName.setOnClickListener(itemClickListener);
        mDelBtn.setOnClickListener(itemClickListener);
    }
}
