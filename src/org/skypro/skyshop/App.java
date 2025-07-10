package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко",12);
        Product banana = new Product("Банан",15);
        Product kiwi = new Product("Киви",25);

        ProductBasket basket=new ProductBasket();

        basket.AddProductInBasket(apple);
        basket.AddProductInBasket(banana);
        basket.AddProductInBasket(kiwi);
        basket.AddProductInBasket(apple);
        basket.AddProductInBasket(kiwi);
        basket.AddProductInBasket(kiwi);

        basket.PrintBasket();

        System.out.println("Общая стоимость корзины: "+basket.GetBasketPrice());

        System.out.println("Банан присутствует в корзине: "+basket.FindForName("Банан"));

        System.out.println("Виноград присутствует в корзине: "+basket.FindForName("Виноград"));

        basket.ClearBusket();

        basket.PrintBasket();

        System.out.println("Общая стоимость корзины: "+basket.GetBasketPrice());

        System.out.println("Банан присутствует в корзине: "+basket.FindForName("Банан"));


    }
}