package ru.levelup.at.java.homework4.task1.cook;

import java.util.ArrayList;
import java.util.stream.Collectors;
import ru.levelup.at.java.homework4.task1.exception.GetCaloriesException;

public class Dish {

    private String name;
    private ArrayList<Food> ingredients;

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, ArrayList<Food> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Food> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Food> ingredients) {
        this.ingredients = ingredients;
    }

    public void cook() {
        System.out.println("Cook a dish: " + name);
        ingredients.forEach(Food::cook);
        System.out.println(name + " is ready.");
    }

    public int getCalories() {
        int sum = 0;
        for (int i = 0, ingredientsSize = ingredients.size(); i < ingredientsSize; i++) {
            Food food = ingredients.get(i);
            if (food.getCalorie() > 0) {
                sum += food.getCalorie();
            } else {
                throw new GetCaloriesException("It is impossible to count the calories of the dish " + name);
            }
        }
        return sum;
    }

    public ArrayList<String> getRedVegetables() {
        ArrayList<String> redVeg = ingredients.stream().filter(food -> food instanceof Vegetable)
                                              .filter(food -> ((Vegetable) food).getColor().equals("red"))
                                              .map(Food::getName).collect(Collectors.toCollection(ArrayList::new));
        return redVeg;

    }


    @Override
    public String toString() {
        return "name=" + name + ", \n"
            + "ingredients=" + ingredients;
    }
}
