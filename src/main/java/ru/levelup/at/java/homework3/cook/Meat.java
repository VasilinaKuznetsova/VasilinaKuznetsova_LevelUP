package ru.levelup.at.java.homework3.cook;

public class Meat extends Food {

    private MeatType meatType;

    public Meat() {

    }

    public Meat(String name) {
        super(name);
    }

    public Meat(String name, int calorie, int proteins, int fats, int carbohydrates,
                MeatType meatType) {
        super(name, calorie, proteins, fats, carbohydrates);
        this.meatType = meatType;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(MeatType meatType) {
        this.meatType = meatType;
    }

    @Override
    public void cook() {
        System.out.println("Cook meat: " + getName()
            + ". Meat is ready.");
    }


}
