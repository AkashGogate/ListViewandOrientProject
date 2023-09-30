package com.example.listviewandorientationproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Character implements Parcelable {

    CharSequence kind;
    CharSequence character;
    int pic;
    CharSequence home;
    CharSequence weapon;



    public Character(CharSequence type, CharSequence homeworld, CharSequence description, int picId, CharSequence weaponOfChoice) {
        pic = picId;
        character = description;
        kind = type;
        home = homeworld;
        weapon = weaponOfChoice;
    }

    protected Character(Parcel in) {
        kind = in.readString();
        pic = in.readInt();
        home = in.readString();
        weapon = in.readString();
        character = in.readString();

    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public CharSequence getKind(){
        return kind;
    }
    public int getPic(){
        return pic;
    }
    public CharSequence getHome(){
        return home;
    }
    public CharSequence getWeapon(){
        return weapon;
    }
    public CharSequence getDescription(){
        return character;
    }

    @Override
    public String toString() {
        return "Character{" +
                "kind=" + kind +
                ", pic=" + pic +
                ", home=" + home +
                ", weapon=" + weapon +
                ", character=" + character +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kind.toString());
        parcel.writeInt(pic);
        parcel.writeString(home.toString());
        parcel.writeString(weapon.toString());
        parcel.writeString(character.toString());
    }
}
