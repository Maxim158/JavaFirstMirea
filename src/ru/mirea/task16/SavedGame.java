package ru.mirea.task16;

import java.io.Serializable;

public class SavedGame implements Serializable {
    private static final long serialVersionUID = 1L;

    private long coins;

    public SavedGame(long coins){
        this.coins = coins;
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins){
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "coins=" + coins +
                '}';
    }
}
