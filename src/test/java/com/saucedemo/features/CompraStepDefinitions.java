package com.saucedemo.features;

import com.saucedemo.questions.PurchaseQuestions;
import com.saucedemo.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;

public class CompraStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    private Actor usuario;

    @Before
    public void setupStage() {
        setTheStage(new OnlineCast());
        usuario = theActorCalled("Usuario");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario esta en la pagina de login de SauceDemo")
    public void queElUsuarioEstaEnLaPaginaDeLogin() {
        usuario.attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }

    @When("el usuario se autentica con usuario {string} y password {string}")
    public void elUsuarioSeAutenticaConUsuarioYPassword(String username, String password) {
        usuario.attemptsTo(
                Authenticate.withCredentials(username, password)
        );
    }

    @And("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String productName) {
        usuario.attemptsTo(
                AddProductToCart.named(productName)
        );
    }

    @And("navega al carrito de compras")
    public void navegaAlCarritoDeCompras() {
        usuario.attemptsTo(
                NavigateToCart.page()
        );
    }

    @Then("el carrito debe contener {int} productos")
    public void elCarritoDebeContenerProductos(int expectedCount) {
        usuario.should(
                seeThat(PurchaseQuestions.numberOfItemsInCart(), equalTo(expectedCount))
        );
    }

    @When("completa el formulario de compra con nombre {string}, apellido {string} y codigo postal {string}")
    public void completaElFormularioDeCompra(String firstName, String lastName, String postalCode) {
        usuario.attemptsTo(
                CompleteCheckoutInformation.with(firstName, lastName, postalCode)
        );
    }

    @And("finaliza la compra")
    public void finalizaLaCompra() {
        usuario.attemptsTo(
                FinishPurchase.now()
        );
    }

    @Then("debe ver el mensaje de confirmacion {string}")
    public void debeVerElMensajeDeConfirmacion(String expectedMessage) {
        usuario.should(
                seeThat(PurchaseQuestions.confirmationMessage(),
                        equalToIgnoringCase(expectedMessage))
        );
    }
}
