package com.newrdev.basketball.data.repository;

import com.newrdev.basketball.data.model.Player;

/**
 * Created by newrdev on 7/19/16.
 */
public interface PlayerRepository {
    Player createPlayer(String name);
}
