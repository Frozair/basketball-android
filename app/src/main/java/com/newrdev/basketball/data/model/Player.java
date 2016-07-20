package com.newrdev.basketball.data.model;

/**
 * Class to be used by the presenter/view.
 *
 * Created by newrdev on 7/19/16.
 */
public class Player {
    private String name;
    private int winCount;
    private int lostCount;
    private int phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", winCount=" + winCount +
                ", lostCount=" + lostCount +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
