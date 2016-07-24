package com.newrdev.basketball.data.repository;

import com.newrdev.basketball.data.model.Player;
import com.newrdev.basketball.data.model.RealmPlayer;

import io.realm.Realm;

/**
 * Created by newrdev on 7/20/16.
 */
public class RealmPlayerRepository implements PlayerRepository
{
    @Override
    public void save(Player player)
    {
        Realm realm = Realm.getDefaultInstance();

        long id = realm.where(RealmPlayer.class).max("id").longValue();
        player.setId(Long.toString(id));

        realm.beginTransaction();

        RealmPlayer realmPlayer = realm.createObject(RealmPlayer.class);
        realmPlayer.setId(id);
        realmPlayer.setName(player.getName());
        realmPlayer.setPhoneNumber(player.getPhoneNumber());
        realmPlayer.setWonCount(player.getWonCount());
        realmPlayer.setLostCount(player.getLostCount());
        realmPlayer.setOrder(player.getOrder());

        realm.commitTransaction();
    }

    @Override
    public void update(Player player)
    {
        Realm realm = Realm.getDefaultInstance();

        RealmPlayer realmPlayer = realm.where(RealmPlayer.class).equalTo("id", player.getId()).findFirst();

        realm.beginTransaction();

        realmPlayer.setName(player.getName());
        realmPlayer.setPhoneNumber(player.getPhoneNumber());
        realmPlayer.setWonCount(player.getWonCount());
        realmPlayer.setLostCount(player.getLostCount());
        realmPlayer.setOrder(player.getOrder());

        realm.commitTransaction();
    }

    @Override
    public void delete(Player player)
    {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        realm.where(RealmPlayer.class).equalTo("id", player.getId()).findFirst().deleteFromRealm();

        realm.commitTransaction();
    }
}
