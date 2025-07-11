package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко",12);
        Product banana = new Product("Банан",15);
        Product kiwi = new Product("Киви",25);

        ProductBasket basket=new ProductBasket();

        basket.addProductInBasket(apple);
        basket.addProductInBasket(banana);
        basket.addProductInBasket(kiwi);
        basket.addProductInBasket(apple);
        basket.addProductInBasket(kiwi);
        basket.addProductInBasket(kiwi);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: "+basket.getBasketPrice());

        System.out.println("Банан присутствует в корзине: "+basket.findForName("Банан"));

        System.out.println("Виноград присутствует в корзине: "+basket.findForName("Виноград"));

        basket.clearBusket();

        basket.printBasket();

        System.out.println("Общая стоимость корзины: "+basket.getBasketPrice());

        System.out.println("Банан присутствует в корзине: "+basket.findForName("Банан"));


    }
}