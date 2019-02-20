package com.servicepartner.challenge.model;

public class WorkerRequest {
    private int [] rooms;
    private int senior;
    private int junior;

    public int[] getRooms() {
        return rooms;
    }

    public void setRooms(int[] rooms) {
        this.rooms = rooms;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }
}
