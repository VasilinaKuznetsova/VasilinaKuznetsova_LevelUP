package ru.levelup.at.java.homework4.task1.cook;

import ru.levelup.at.java.homework4.task1.exception.CookVegetableException;

public class Vegetable extends Food {

    private String color;
    private boolean isClean = false;

    public Vegetable() {

    }

    public Vegetable(String name) {
        super(name);
    }

    public Vegetable(String name, int calorie, int proteins, int fats, int carbohydrates,
                     String color) {
        super(name, calorie, proteins, fats, carbohydrates);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void clean() {
        this.isClean = true;
    }

    @Override
    public void cook() {
        if (isClean) {
            System.out.println("Cut vegetable: " + getName()
                + ". Vegetable is ready.");
        } else {
            throw new CookVegetableException("It is impossible to cook the vegetable " + getName()
                + ". The vegetable isn't clean.");
        }

    }
}
