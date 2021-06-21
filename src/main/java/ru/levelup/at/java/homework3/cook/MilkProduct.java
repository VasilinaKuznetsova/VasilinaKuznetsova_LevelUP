package ru.levelup.at.java.homework3.cook;

public class MilkProduct extends Food {

    private String brand;

    public MilkProduct() {

    }

    public MilkProduct(String name) {
        super(name);
    }

    public MilkProduct(String name, int calorie, int proteins, int fats, int carbohydrates, String brand) {
        super(name, calorie, proteins, fats, carbohydrates);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void cook() {
        System.out.println("Add milk product: " + getName()
            + ". Milk product is ready.");
    }

}
