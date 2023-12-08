package org.example;

public class Frequency {
    private String name;
    private float frequency;

    public Frequency (String name, float frequency ) {

        this.name = name;
        this.frequency = frequency;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }
}
