package org.example;

public class Frequency {
    //includes values and names for hz.
    private String name;
    private final float frequency;

    public Frequency (String name, float frequency ) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }
    public float getFrequency() {
        return frequency;
    }

}
