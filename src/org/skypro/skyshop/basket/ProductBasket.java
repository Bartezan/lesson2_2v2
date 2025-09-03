package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private int getSpecialCount() {
        return (int) products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        int specialCount = 0;
        if (!products.isEmpty()) {
            products.values()
                    .stream()
                    .flatMap(Collection::stream)
                    .forEach(new Consumer<Product>() {
                        @Override
                        public void accept(Product product) {
                            System.out.println(product);
                        }
                    });
            System.out.println("Общая стоимость корзины: " + getBasketPrice());
            System.out.println("Количество специальных товаров: " + getSpecialCount());
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean findForName(String name) {
        boolean result = false;
        result = products.values()
                .stream()
                .flatMap(Collection::stream)
                .anyMatch(new Predicate<Product>() {
                    @Override
                    public boolean test(Product product) {
                        return name.equals(product.getName());
                    }
                });
        return result;
    }

    public void clearBusket() {
        products.clear();
    }

    public List<Product> deleteByName(String name) {
        List<Product> result = products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(product -> {
                    return name.equals(product.getName());
                })
                .toList();
        products.remove(name);

        return result;
    }
}



