package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basicPrise;
    private int percent;

    public DiscountedProduct(String name, int basicPrise, int percent) {
        super(name);
        if (basicPrise < 1) {
            throw new IllegalArgumentException("Базовая цена некорректна <1");
        }
        if (!(percent >= 0 && percent <= 100)) {
            throw new IllegalArgumentException("Процент не корректен");
        }
        this.basicPrise = basicPrise;
        this.percent = percent;
    }

    @Override
    public int getPrice() {
        return (basicPrise * (100 - percent) / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice() + " (" + percent + "%)";
    }
}
