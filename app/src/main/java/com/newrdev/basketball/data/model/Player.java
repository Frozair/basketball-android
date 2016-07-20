package com.newrdev.basketball.data.model;

/**
 * Class to be used by the presenter/view.
 *
 * Created by newrdev on 7/19/16.
 */
public class Player
{
    private String name;
    private int wonCount;
    private int lostCount;
    private int phoneNumber;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWonCount() {
        return wonCount;
    }

    public void setWonCount(int wonCount) {
        this.wonCount = wonCount;
    }

    public int getLostCount() {
        return lostCount;
    }

    public void setLostCount(int lostCount) {
        this.lostCount = lostCount;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wonCount=" + wonCount +
                ", lostCount=" + lostCount +
                ", phoneNumber=" + phoneNumber +
                ", id='" + id + '\'' +
                '}';
    }
}
