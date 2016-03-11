package com.zayatz.homework_8.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by Zayatz on 08.03.2016.
 */
public class User implements Parcelable{

    private String firstName;
    private String lastName;
    private String gender;
    private String age;
    private String phoneNumber;

    /*get user from parcel*/
    public User(Parcel in) {
        String[] data = new String[5];
        in.readStringArray(data);
        this.firstName = data[0];
        this.lastName = data[1];
        this.gender = data[2];
        this.age = data[3];
        this.phoneNumber = data[4];

    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender.toLowerCase();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.firstName, this.lastName, this.gender, this.age, this.phoneNumber});
    }

    public static final Creator<User> CREATOR = new Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public static boolean isValidGender (String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                return true;
            case "female":
                return true;
            default: return false;
        }
    }

    /*check if secondary fields empty*/
    public boolean haveSecondaryEmpty() {
        if (TextUtils.isEmpty(lastName) ||
                TextUtils.isEmpty(age) ||
                TextUtils.isEmpty(gender)) return true;
        else return false;
    }


}
