package ru.levelup.at.java.homework4.task1;

import java.util.ArrayList;
import ru.levelup.at.java.homework4.task1.cook.Dish;
import ru.levelup.at.java.homework4.task1.cook.Food;
import ru.levelup.at.java.homework4.task1.cook.Meat;
import ru.levelup.at.java.homework4.task1.cook.MeatType;
import ru.levelup.at.java.homework4.task1.cook.MilkProduct;
import ru.levelup.at.java.homework4.task1.cook.Vegetable;
import ru.levelup.at.java.homework4.task1.exception.CookVegetableException;
import ru.levelup.at.java.homework4.task1.exception.CutMeatException;
import ru.levelup.at.java.homework4.task1.exception.GetCaloriesException;

public class App {

    public static void main(String[] args) {
        App cookApp = new App();
        cookApp.start();
    }

    public void start() {

        Vegetable tomato = new Vegetable("tomato");
        Vegetable cucumber = new Vegetable("cucumber", 14,
            1, 0, 3, "green");
        MilkProduct yogurt = new MilkProduct("yogurt", 92,
            5, 6, 4, "Epica");

        ArrayList<Food> ingredients1 = new ArrayList<>();
        ingredients1.add(tomato);
        ingredients1.add(cucumber);
        ingredients1.add(yogurt);

        Dish salad = new Dish("Salad");
        salad.setIngredients(ingredients1);

        try {
            salad.cook();
        } catch (CookVegetableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Calorie of the " + salad.getName() + " :");
        try {
            System.out.println(salad.getCalories());
        } catch (GetCaloriesException e) {
            System.out.println(e.getMessage());
        }


        Meat beefFillet = new Meat("beef fillet", 158,
            22, 7, 0, MeatType.FILLET, true);
        System.out.println();
        System.out.println("Try to cut " + beefFillet.getName() + ".");
        try {
            beefFillet.cut();
        } catch (CutMeatException e) {
            System.out.println(e.getMessage());
        }
    }
}
