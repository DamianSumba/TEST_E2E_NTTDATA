package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage extends PageObject {

    // Checkout Step One - Information
    public static final Target FIRST_NAME_FIELD =
            Target.the("campo nombre")
                    .located(By.id("first-name"));

    public static final Target LAST_NAME_FIELD =
            Target.the("campo apellido")
                    .located(By.id("last-name"));

    public static final Target POSTAL_CODE_FIELD =
            Target.the("campo codigo postal")
                    .located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON =
            Target.the("boton continuar")
                    .located(By.id("continue"));

    public static final Target CANCEL_BUTTON =
            Target.the("boton cancelar")
                    .located(By.id("cancel"));

    // Checkout Step Two - Overview
    public static final Target FINISH_BUTTON =
            Target.the("boton finalizar")
                    .located(By.id("finish"));

    public static final Target OVERVIEW_SUBTOTAL =
            Target.the("subtotal del resumen")
                    .located(By.className("summary_subtotal_label"));

    public static final Target OVERVIEW_TOTAL =
            Target.the("total del resumen")
                    .located(By.className("summary_total_label"));

    // Checkout Complete
    public static final Target CONFIRMATION_HEADER =
            Target.the("encabezado de confirmacion")
                    .located(By.className("complete-header"));

    public static final Target CONFIRMATION_TEXT =
            Target.the("texto de confirmacion")
                    .located(By.className("complete-text"));

    public static final Target BACK_HOME_BUTTON =
            Target.the("boton volver al inicio")
                    .located(By.id("back-to-products"));
}
