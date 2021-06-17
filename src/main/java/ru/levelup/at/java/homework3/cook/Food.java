package ru.levelup.at.java.homework3.cook;

import java.util.Comparator;

public abstract class Food {
    private String name;
    private int calorie;
    private int proteins;
    private int fats;
    private int carbohydrates;

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    public Food(String name, int calorie, int proteins, int fats, int carbohydrates) {
        this.name = name;
        this.calorie = calorie;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public abstract void cook();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public static final Comparator<Food> COMPARE_BY_CARBOHYDRATES = new Comparator<>() {
        @Override
        public int compare(Food lhs, Food rhs) {
            return lhs.getCarbohydrates() - rhs.getCarbohydrates();
        }
    };


    @Override
    public String toString() {
        return "Food{"
            + "name='" + name + '\''
            + ", calorie=" + calorie
            + ", proteins=" + proteins
            + ", fats=" + fats
            + ", carbohydrates=" + carbohydrates + '}';
    }
}
