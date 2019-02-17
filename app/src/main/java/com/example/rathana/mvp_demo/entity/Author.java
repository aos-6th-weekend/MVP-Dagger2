package com.example.rathana.mvp_demo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Author  implements Parcelable {

    @SerializedName("IMAGE_URL")
    private String imageUrl;
    @SerializedName("FACEBOOK_ID")
    private String facebookId;
    @SerializedName("STATUS")
    private String status;
    @SerializedName("TELEPHONE")
    private String telephone;
    @SerializedName("GENDER")
    private String gender;
    @SerializedName("EMAIL")
    private String email;
    @SerializedName("NAME")
    private String name;
    @SerializedName("ID")
    private int id;


    public Author() {
    }

    protected Author(Parcel in) {
        imageUrl = in.readString();
        facebookId = in.readString();
        status = in.readString();
        telephone = in.readString();
        gender = in.readString();
        email = in.readString();
        name = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(facebookId);
        dest.writeString(status);
        dest.writeString(telephone);
        dest.writeString(gender);
        dest.writeString(email);
        dest.writeString(name);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "imageUrl='" + imageUrl + '\'' +
                ", facebookId='" + facebookId + '\'' +
                ", status='" + status + '\'' +
                ", telephone='" + telephone + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
