package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) throws IllegalArgumentException {
        super(name);
        if (price < 1) {
            throw new IllegalArgumentException("Некорректная цена <1");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + " : " + price;
    }
}
