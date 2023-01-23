package com.java20.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameData {
    private int randNumber;
    private List<Integer> memories;

    public GameData() {
        this.memories = new ArrayList<Integer>();
        this.randomNewNumber();
    }

    public void randomNewNumber() {
        Random rand = new Random();
        this.randNumber = rand.nextInt(1000) + 1;
    }

    public int getRandNumber() {
        return randNumber;
    }

    public void setRandNumber(int randNumber) {
        this.randNumber = randNumber;
    }

    public List<Integer> getMemories() {
        return memories;
    }

    public void setMemories(List<Integer> memories) {
        this.memories = memories;
    }
}
