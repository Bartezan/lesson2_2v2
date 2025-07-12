package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

  private   Product[] products = new Product[5];
  private   int productCount = 0;

    public void addProductInBasket(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        } else {
            System.out.println("Карзина переполнена");
        }
    }

    public int getBasketPrice() {
        int sum = 0;
        for (int i = 0; i < productCount; i++) {
            sum = sum + products[i].getPrice();
        }
        return sum;
    }

    public void printBasket() {
        if (productCount > 0) {
            for (int i = 0; i < productCount; i++) {
                System.out.println((i + 1) + ": " + products[i].getName() + ": " + products[i].getPrice());
            }
            System.out.println("Общая стоимость корзины: " + getBasketPrice());
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean findForName(String name) {
        boolean result = false;
        for (int i = 0; i < productCount; i++) {
            if (name.equals(products[i].getName())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void clearBusket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;
    }
}



