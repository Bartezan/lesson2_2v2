package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    Product[] products = new Product[5];
    int productCount = 0;

    public void AddProductInBasket(Product product) {
        if (productCount < 5) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Карзина переполнена");
        }
    }

    public int GetBasketPrice() {
        int sum = 0;
        for (int i = 0; i < productCount; i++) {
            sum = sum + products[i].getPrice();
        }
        return sum;
    }

    public void PrintBasket() {
        if (productCount > 0) {
            for (int i = 0; i < productCount; i++) {
                System.out.println((i + 1) + ": " + products[i].getName() + ": " + products[i].getPrice());
            }
            System.out.println("Общая стоимость корзины: " + GetBasketPrice());
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean FindForName(String name) {
        boolean result = false;
        for (int i = 0; i < productCount; i++) {
            if (name.equals(products[i].getName())) {
                result = true;
            }
        }
        return result;
    }

    public void ClearBusket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;
    }
}



