package ru.levelup.at.java.homework3.cook;

public class Vegetable extends Food {

    private String color;

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

    @Override
    public void cook() {
        System.out.printf("Cut vegetable: %s. Vegetable is ready.%n", getName());
    }

}
