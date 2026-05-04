package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {

    public static final Target PAGE_TITLE =
            Target.the("titulo de pagina del carrito")
                    .located(By.className("title"));

    public static final Target CART_ITEMS =
            Target.the("items del carrito")
                    .located(By.className("cart_item"));

    public static final Target CHECKOUT_BUTTON =
            Target.the("boton de checkout")
                    .located(By.id("checkout"));

    public static final Target CONTINUE_SHOPPING_BUTTON =
            Target.the("boton continuar comprando")
                    .located(By.id("continue-shopping"));

    public static final Target CART_ITEM_NAMES =
            Target.the("nombres de items en el carrito")
                    .located(By.className("inventory_item_name"));
}
