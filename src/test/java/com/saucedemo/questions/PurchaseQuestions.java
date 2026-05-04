package com.saucedemo.questions;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


import java.util.List;

public class PurchaseQuestions {

    /**
     * Obtiene el texto del encabezado de confirmacion de orden
     */
    public static Question<String> confirmationMessage() {
        return actor -> Text.of(CheckoutPage.CONFIRMATION_HEADER).answeredBy(actor);
    }

    /**
     * Obtiene el numero de items en el carrito
     */
    public static Question<Integer> numberOfItemsInCart() {
        return actor -> CartPage.CART_ITEMS.resolveAllFor(actor).size();
    }

    /**
     * Verifica si la pagina de confirmacion esta visible
     */
    public static Question<Boolean> orderConfirmedPageIsVisible() {
        return actor -> {
            try {
                String headerText = Text.of(CheckoutPage.CONFIRMATION_HEADER).answeredBy(actor);
                return headerText != null && !headerText.isEmpty();
            } catch (Exception e) {
                return false;
            }
        };
    }
}
