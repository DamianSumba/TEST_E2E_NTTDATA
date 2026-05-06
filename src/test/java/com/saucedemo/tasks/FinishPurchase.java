package com.saucedemo.tasks;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FinishPurchase implements Task {

    public static FinishPurchase now() {
        return instrumented(FinishPurchase.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
        actor.attemptsTo(
                WaitUntil.the(InventoryPage.CART_BADGE, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
