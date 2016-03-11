package com.zayatz.homework_8.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.zayatz.homework_8.Constant;
import com.zayatz.homework_8.R;
import com.zayatz.homework_8.model.User;

/**
 * Created by Zayatz on 09.03.2016.
 */
public class UserShowActivity extends AppCompatActivity {

    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvGender;
    private TextView tvAge;
    private TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_show);

        findViews();
        showUser();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void findViews() {
        tvFirstName = (TextView) findViewById(R.id.tv_user_first_name_AUS);
        tvLastName = (TextView) findViewById(R.id.tv_user_last_name_AUS);
        tvGender = (TextView) findViewById(R.id.tv_user_gender_AUS);
        tvAge = (TextView) findViewById(R.id.tv_user_age_AUS);
        tvPhone = (TextView) findViewById(R.id.tv_user_phone_AUS);
    }

    private void showUser() {
        User user = (User) getIntent().getParcelableExtra(Constant.EXTRA_USER_PARCEL);
        tvFirstName.setText(user.getFirstName());
        tvLastName.setText(user.getLastName());
        tvGender.setText(user.getGender());
        tvAge.setText(user.getAge());
        tvPhone.setText(user.getPhoneNumber());
    }
}
