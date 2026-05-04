package com.saucedemo.tasks;

import com.saucedemo.pages.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToCart implements Task {

    public static NavigateToCart page() {
        return instrumented(NavigateToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.SHOPPING_CART_ICON)
        );
    }
}
