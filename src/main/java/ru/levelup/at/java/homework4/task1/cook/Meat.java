package ru.levelup.at.java.homework4.task1.cook;

import ru.levelup.at.java.homework4.task1.exception.CutMeatException;

public class Meat extends Food {

    private MeatType meatType;
    private boolean isFrozen;

    public Meat() {

    }

    public Meat(String name) {
        super(name);
    }

    public Meat(String name, int calorie, int proteins, int fats, int carbohydrates,
                MeatType meatType, boolean isFrozen) {
        super(name, calorie, proteins, fats, carbohydrates);
        this.meatType = meatType;
        this.isFrozen = isFrozen;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(MeatType meatType) {
        this.meatType = meatType;
    }

    public void defrost() {
        this.isFrozen = false;
    }

    public void cut() {
        if (!isFrozen) {
            System.out.println("Cut meat " + getName());
        } else {
            throw new CutMeatException("It is impossible to cut the meat. The meat is still frozen.");
        }
    }

    @Override
    public void cook() {
        System.out.println("Cook meat: " + getName()
            + ". Meat is ready.");
    }


}
