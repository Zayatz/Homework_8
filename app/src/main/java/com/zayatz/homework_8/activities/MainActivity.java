package com.zayatz.homework_8.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.zayatz.homework_8.R;
import com.zayatz.homework_8.UserInterface;
import com.zayatz.homework_8.model.User;
import com.zayatz.homework_8.recyclerview.UserAdapter;
import com.zayatz.homework_8.Constant;

public class MainActivity extends AppCompatActivity implements UserInterface {


    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView userList = (RecyclerView) findViewById(R.id.user_list);
        userList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        userList.setLayoutManager(llm);

        userAdapter = new UserAdapter();
        userAdapter.regUserInterface(this);
        userList.setAdapter(userAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ab_add_user:
                openUserAddActivity();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onUserClick(User user) {
        Intent intent = new Intent();
        intent.setClass(this, UserShowActivity.class);
        intent.putExtra(Constant.EXTRA_USER_PARCEL, user);
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(User user) {
        userAdapter.deleteUser(user);
    }

    public void openUserAddActivity () {
        Intent intent = new Intent();
        intent.setClass(this, UserAddActivity.class);
        startActivityForResult(intent, Constant.ACTION_OPEN_USER_ADD);
    }
    /* get user from UserAddActivity and add it to adapter*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            User user = (User) data.getParcelableExtra(Constant.EXTRA_USER_PARCEL);
            userAdapter.userAdd(user);
        }
    }
}
