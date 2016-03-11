package com.zayatz.homework_8.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zayatz.homework_8.Constant;
import com.zayatz.homework_8.R;
import com.zayatz.homework_8.model.User;

/**
 * Created by Zayatz on 09.03.2016.
 */
public class UserAddActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etAge;
    private EditText etGender;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        etFirstName = (EditText) findViewById(R.id.et_add_first_name_AUA);
        etLastName = (EditText) findViewById(R.id.et_add_last_name_AUA);
        etAge = (EditText) findViewById(R.id.et_add_age_AUA);
        etGender = (EditText) findViewById(R.id.et_add_gender_AUA);
        etPhone = (EditText) findViewById(R.id.et_add_number_AUA);
        Button btnCreate = (Button) findViewById(R.id.btn_create_user_AUA);

        btnCreate.setOnClickListener(this);

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

    /*create user depends on inputs*/
    private User createUser() {
        User user = new User();

        user.setFirstName(etFirstName.getText().toString().trim());
        user.setLastName(etLastName.getText().toString().trim());
        user.setAge(etAge.getText().toString().trim());
        user.setGender(etGender.getText().toString().trim());
        user.setPhoneNumber(etPhone.getText().toString().trim());

        return user;
    }

    private void sendData() {
        Intent intent = new Intent();
        intent.putExtra(Constant.EXTRA_USER_PARCEL, createUser());
        setResult(RESULT_OK, intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_user_AUA:
                if (isValidInputs()) {
                    sendData();
                    finish();
                }
                break;
        }
    }

    /*check if first name and age is empty, show toast, also check if gender input is valid
    * (mast be female, Female, male, Male)*/
    private boolean isValidInputs() {
        if (TextUtils.isEmpty(etFirstName.getText().toString().trim()) ||
                TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            Toast.makeText(this, R.string.user_empty_must_fields, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!User.isValidGender(etGender.getText().toString().trim()) &&
                !TextUtils.isEmpty(etGender.getText().toString().trim())) {
            Toast.makeText(this, R.string.user_wrong_gender_input, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
