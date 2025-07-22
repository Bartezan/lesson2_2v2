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
    }
}