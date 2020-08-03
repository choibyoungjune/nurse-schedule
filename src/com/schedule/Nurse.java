package com.schedule;

public class Nurse {
    private String name;
    private int rank;
    private int night=0;

    public Nurse(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getNight() {
        return night;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }
}
