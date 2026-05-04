package com.saucedemo.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
//import org.openqa.selenium.By;



public class InventoryPage extends PageObject {

    public static final Target PRODUCT_TITLE =
            Target.the("titulo de pagina de inventario")
                    .located(By.className("title"));

    public static final Target SHOPPING_CART_ICON =
            Target.the("icono del carrito de compras")
                    .located(By.id("shopping_cart_container"));

    public static final Target CART_BADGE =
            Target.the("insignia del carrito")
                    .located(By.className("shopping_cart_badge"));

    public static Target addToCartButtonFor(String productName) {
        String dataTestId = "add-to-cart-" + productName.toLowerCase()
                .replace(" ", "-")
                .replace(".", "");
        return Target.the("boton agregar al carrito para " + productName)
                .located(By.cssSelector("[data-test='" + dataTestId + "']"));
    }

    public static final Target ALL_ADD_TO_CART_BUTTONS =
            Target.the("todos los botones agregar al carrito")
                    .located(By.cssSelector("[data-test^='add-to-cart']"));
}
