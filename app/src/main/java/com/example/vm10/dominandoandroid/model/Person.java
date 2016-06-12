package com.example.vm10.dominandoandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.joda.time.DateTime;

public class Person implements Parcelable {

    private int id;
    private String name;
    private DateTime dateOfBirth;

    public Person(int id, String name, DateTime dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeSerializable(this.dateOfBirth);
    }

    protected Person(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.dateOfBirth = (DateTime) in.readSerializable();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\nName: ").append(this.name);
        sb.append("\nDate of Birth: ").append(this.dateOfBirth.toString("dd/MM/yyyy"));
        return sb.toString();
    }
}
