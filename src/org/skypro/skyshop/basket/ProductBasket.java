package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {

    private List<Product> products = new ArrayList<>();
    private int productCount = 0;

    public void addProductInBasket(Product product) {
        products.add(productCount++, product);
    }

    public int getBasketPrice() {
        int sum = 0;
        for (int i = 0; i < productCount; i++) {
            sum = sum + products.get(i).getPrice();
        }
        return sum;
    }

    public void printBasket() {
        int specialCount = 0;
        if (productCount > 0) {
            for (int i = 0; i < productCount; i++) {
                System.out.println((i + 1) + ": " + products.get(i));
                if (products.get(i).isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Общая стоимость корзины: " + getBasketPrice());
            System.out.println("Количество специальных товаров: " + specialCount);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean findForName(String name) {
        boolean result = false;
        for (int i = 0; i < productCount; i++) {
            if (name.equals(products.get(i).getName())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void clearBusket() {
        for (int i = productCount - 1; i > 0; i--) {
            products.remove(i);
        }
        productCount = 0;
    }

    public List<Product> deleteByName(String name) {
        List<Product> result = new ArrayList<>();
        for (int i = productCount - 1; i > 0; i--) {
            if (products.get(i).getName().equals(name)) {
                result.add(products.get(i));
                products.remove(i);
                productCount--;
            }
        }
        return result;
    }
}



