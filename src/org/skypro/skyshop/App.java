package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

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

        SearchEngine searchEngine1 = new SearchEngine(10);

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

        Searchable[] result = searchEngine1.search("Яблоко");

        for (int i = 0; i < result.length; i++) {
            if (result[i] == null) break;
            System.out.println(result[i].getStringRepresentation());
        }

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
        }

        try {
            DiscountedProduct tomato = new DiscountedProduct("Помидор", 0, 50);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        try {
            DiscountedProduct tomato = new DiscountedProduct(null, 5, 50);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        } catch (NullPointerException ex) {
            System.out.println("Одно из полей пусто");
        }

        try {
            Searchable result1 = searchEngine1.getBestSearch("слива");
            System.out.println(result1.getStringRepresentation());
        } catch (BestResultNotFound ex) {
            System.out.println(ex.toString());
        }

        try {
            Searchable result1 = searchEngine1.getBestSearch("а");
            System.out.println(result1.getStringRepresentation());
        } catch (BestResultNotFound ex) {
            System.out.println(ex.toString());
        }
    }
}