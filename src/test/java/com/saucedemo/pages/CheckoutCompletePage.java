package com.saucedemo.pages;


import net.serenitybdd.screenplay.targets.Target;

public class CheckoutCompletePage {

    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de compra exitosa")
            .locatedBy(".complete-header");

    public static final Target BACK_HOME_BUTTON = Target.the("botón volver al inicio")
            .locatedBy("#back-to-products");
}
