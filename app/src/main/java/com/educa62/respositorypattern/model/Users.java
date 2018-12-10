package com.educa62.respositorypattern.model;

import com.google.gson.annotations.SerializedName;


public class Users {
    @SerializedName("company")
    public Company company;
    @SerializedName("website")
    public String website;
    @SerializedName("phone")
    public String phone;
    @SerializedName("address")
    public Address address;
    @SerializedName("email")
    public String email;
    @SerializedName("username")
    public String username;
    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public int id;

    public static class Company {
        @SerializedName("bs")
        public String bs;
        @SerializedName("catchPhrase")
        public String catchPhrase;
        @SerializedName("name")
        public String name;
    }

    public static class Address {
        @SerializedName("geo")
        public Geo geo;
        @SerializedName("zipcode")
        public String zipcode;
        @SerializedName("city")
        public String city;
        @SerializedName("suite")
        public String suite;
        @SerializedName("street")
        public String street;
    }

    public static class Geo {
        @SerializedName("lng")
        public String lng;
        @SerializedName("lat")
        public String lat;
    }
}
