package com.newrdev.basketball.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by newrdev on 7/20/16.
 */
public class RealmPlayer extends RealmObject
{
    @PrimaryKey
    private long id;
    private String name;
    private int wonCount;
    private int lostCount;
    private int phoneNumber;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    private int order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
