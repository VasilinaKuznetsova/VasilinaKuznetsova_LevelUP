package ru.levelup.at.java.homework3;

import java.util.ArrayList;
import ru.levelup.at.java.homework3.cook.Dish;
import ru.levelup.at.java.homework3.cook.Food;
import ru.levelup.at.java.homework3.cook.Meat;
import ru.levelup.at.java.homework3.cook.MeatType;
import ru.levelup.at.java.homework3.cook.MilkProduct;
import ru.levelup.at.java.homework3.cook.Vegetable;

public class App {

    public static void main(String[] args) {
        App cookApp = new App();
        cookApp.start();
    }

    public void start() {

        Vegetable tomato = new Vegetable("tomato", 24,
            1, 0, 4, "red");
        Vegetable cucumber = new Vegetable("cucumber", 14,
            1, 0, 3, "green");
        Vegetable beet = new Vegetable("beet", 43,
            2, 0, 7, "red");
        Vegetable carrot = new Vegetable("carrot", 32,
            1, 0, 7, "orange");
        Vegetable potato = new Vegetable("potato", 77,
            2, 0, 16, "yellow");

        Meat chickenLegs = new Meat("chicken legs", 244,
            23, 17, 0, MeatType.LEG);
        Meat beefFillet = new Meat("beef fillet", 158,
            22, 7, 0, MeatType.FILLET);

        MilkProduct cheese = new MilkProduct("cheese", 364,
            23, 30, 0, "Hochland");
        MilkProduct yogurt = new MilkProduct("yogurt", 92,
            5, 6, 4, "Epica");

        System.out.println("There is food in the fridge:");
        System.out.println(tomato);
        System.out.println(cucumber);
        System.out.println(beet);
        System.out.println(carrot);
        System.out.println(potato);
        System.out.println(chickenLegs);
        System.out.println(beefFillet);
        System.out.println(cheese);
        System.out.println(yogurt);


        ArrayList<Food> ingredients1 = new ArrayList<>();
        ingredients1.add(tomato);
        ingredients1.add(cucumber);
        ingredients1.add(yogurt);

        ArrayList<Food> ingredients2 = new ArrayList<>();
        ingredients2.add(beet);
        ingredients2.add(carrot);
        ingredients2.add(potato);
        ingredients2.add(beefFillet);
        ingredients2.add(yogurt);

        Dish salad = new Dish("Salad");
        salad.setIngredients(ingredients1);

        Dish borscht = new Dish("Borscht");
        borscht.setIngredients(ingredients2);

        System.out.println();
        System.out.println("Cook dinner:");

        salad.cook();
        System.out.println("Calorie " + salad.getName() + " - " + salad.getCalories() + " kcal");
        System.out.println();

        borscht.cook();
        System.out.println("Calorie " + borscht.getName() + " - " + borscht.getCalories() + " kcal");
        System.out.println();

        System.out.println("Sorted ingredients of the " + salad.getName() + " by carbohydrates:");
        salad.getIngredients().sort(Food.COMPARE_BY_CARBOHYDRATES);
        System.out.println(salad);
        System.out.println();

        System.out.println("Red vegetables in the " + borscht.getName() + ":");
        System.out.println(borscht.getRedVegetables());
    }
}
