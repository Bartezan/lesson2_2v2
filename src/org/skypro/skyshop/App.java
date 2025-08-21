package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.*;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 12);
        DiscountedProduct banana = new DiscountedProduct("Банан", 10, 50);
        FixPriceProduct kiwi = new FixPriceProduct("Киви");
        Article appleArticle = new Article("Яблоко сорт Антоновка", "О вкусовых качествах данного сорта");

        ProductBasket basket = new ProductBasket();

        basket.addProductInBasket(apple);
        basket.addProductInBasket(banana);
        basket.addProductInBasket(kiwi);
        basket.addProductInBasket(apple);
        basket.addProductInBasket(kiwi);
        basket.addProductInBasket(kiwi);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getBasketPrice());

        System.out.println("Банан присутствует в корзине: " + basket.findForName("Банан"));

        System.out.println("Виноград присутствует в корзине: " + basket.findForName("Виноград"));

        basket.clearBusket();

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getBasketPrice());

        System.out.println("Банан присутствует в корзине: " + basket.findForName("Банан"));

        SearchEngine searchEngine1 = new SearchEngine();

        searchEngine1.add(apple);
        searchEngine1.add(apple);
        searchEngine1.add(banana);
        searchEngine1.add(kiwi);
        searchEngine1.add(appleArticle);
        searchEngine1.add(banana);
        searchEngine1.add(kiwi);
        searchEngine1.add(kiwi);
        searchEngine1.add(appleArticle);
        searchEngine1.add(banana);
        searchEngine1.add(banana);

        Set<Searchable> result = searchEngine1.search("Яблоко");
        System.out.println("----------");
        if (result.isEmpty()) {
            System.out.println("Поиск результатов не дал");
        } else {
            System.out.println(result);
        }
        System.out.println("----------");
        try {
            SimpleProduct potato = new SimpleProduct("  ", 12);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            SimpleProduct potato = new SimpleProduct("Картофель", 0);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            DiscountedProduct tomato = new DiscountedProduct("Помидор", 10, 101);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        } catch (NullPointerException ex) {
            System.out.println("Одно из полей пусто");
        }

        try {
            DiscountedProduct tomato = new DiscountedProduct("Помидор", 0, 50);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        } catch (NullPointerException ex) {
            System.out.println("Одно из полей пусто");
        }

        try {
            DiscountedProduct tomato = new DiscountedProduct(null, 5, 50);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        } catch (NullPointerException ex) {
            System.out.println("Одно из полей пусто");
        }
        System.out.println("----------");
        try {
            Searchable result1 = searchEngine1.getBestSearch("слива");
            System.out.println(result1.getStringRepresentation());
        } catch (BestResultNotFound ex) {
            System.out.println(ex.toString());
        }
        System.out.println("----------");
        try {
            Searchable result1 = searchEngine1.getBestSearch("а");
            System.out.println(result1.getStringRepresentation());
        } catch (BestResultNotFound ex) {
            System.out.println(ex.toString());
        }
        System.out.println("----------");
        //HW5
        System.out.println("HW5");
        basket.printBasket();

        basket.addProductInBasket(apple);
        basket.addProductInBasket(banana);
        basket.addProductInBasket(kiwi);
        basket.addProductInBasket(apple);
        basket.addProductInBasket(kiwi);
        basket.addProductInBasket(kiwi);

        basket.printBasket();

        List<Product> deletedProduct = new ArrayList<>();

        deletedProduct = basket.deleteByName("Киви");
        System.out.println("-------------");
        if (deletedProduct.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product deleted : deletedProduct) {
                System.out.println(deleted.toString());
            }
        }
        System.out.println("-------------");
        basket.printBasket();
        System.out.println("-------------");

        deletedProduct = basket.deleteByName("Киви");
        if (deletedProduct.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product deleted : deletedProduct) {
                System.out.println(deleted.toString());
            }
        }

        System.out.println("-------------");
        basket.printBasket();
    }
}