package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedPriduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 12);
        DiscountedPriduct banana = new DiscountedPriduct("Банан", 10, 50);
        FixPriceProduct kiwi = new FixPriceProduct("Киви");

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

    }
}