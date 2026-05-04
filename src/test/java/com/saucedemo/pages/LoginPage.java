package com.saucedemo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD =
            Target.the("campo de usuario")
                    .located(By.id("user-name"));

    public static final Target PASSWORD_FIELD =
            Target.the("campo de contraseña")
                    .located(By.id("password"));

    public static final Target LOGIN_BUTTON =
            Target.the("boton de login")
                    .located(By.id("login-button"));

    public static final Target ERROR_MESSAGE =
            Target.the("mensaje de error")
                    .located(By.cssSelector("[data-test='error']"));
}
