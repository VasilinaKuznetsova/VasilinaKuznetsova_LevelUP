package ru.levelup.at.java.homework4.task1.cook;

import java.util.ArrayList;
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
        for(Food food : ingredients) {
            if (food.getCalorie() > 0) {
                sum += food.getCalorie();
            } else {
                throw new GetCaloriesException("It is impossible to count the calories of the dish " + name);
            }
        }
        return sum;
    }

    public ArrayList<String> getRedVegetables() {
        ArrayList<String> redVeg = new ArrayList<>();
        for(Food food : ingredients) {
            if (food instanceof Vegetable) {
                if (((Vegetable) food).getColor().equals("red")) {
                    redVeg.add(food.getName());
                }
            }
        }
        return redVeg;

    }


    @Override
    public String toString() {
        return "name=" + name + ", \n"
            + "ingredients=" + ingredients;
    }
}
