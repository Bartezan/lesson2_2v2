package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductBasket {

    private Map<String, List<Product>> products = new TreeMap<>();

    public void addProductInBasket(Product product) {
        if (products.containsKey(product.getName())) {
            products.get(product.getName()).add(product);
        } else {
            List<Product> temp = new ArrayList<>();
            temp.add(product);
            products.put(product.getName(), temp);
        }
    }

    public int getBasketPrice() {
        int sum = 0;
        for (Map.Entry<String, List<Product>> i : products.entrySet()) {
            for (int count = 0; count < i.getValue().size(); count++) {
                sum = sum + i.getValue().get(count).getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        int specialCount = 0;
        if (!products.isEmpty()) {
            for (Map.Entry<String, List<Product>> i : products.entrySet()) {
                for (int count = 0; count < i.getValue().size(); count++) {
                    System.out.println(i.getValue().get(count));
                    if (i.getValue().get(count).isSpecial()) {
                        specialCount++;
                    }
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
        for (Map.Entry<String, List<Product>> i : products.entrySet()) {
            if (name.equals(i.getKey())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void clearBusket() {
        products.clear();
    }

    public List<Product> deleteByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Map.Entry<String, List<Product>> i : products.entrySet()) {
            if (name.equals(i.getKey())) {
                for (int count = 0; count < i.getValue().size(); count++) {
                    result.add(i.getValue().get(count));
                }
                products.remove(name);
                break;
            }
        }

        return result;
    }
}



