@flujo-compra
Feature: Flujo de Compra en SauceDemo
  As a registered SauceDemo user
  I want to complete a purchase
  So that I can buy products

  Background:
    Given que el usuario esta en la pagina de login de SauceDemo

  @compra-exitosa
  Scenario: Completar flujo de compra con dos productos
    When el usuario se autentica con usuario "standard_user" y password "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And agrega el producto "Sauce Labs Bike Light" al carrito
    And navega al carrito de compras
    Then el carrito debe contener 2 productos
    When completa el formulario de compra con nombre "Juan", apellido "Perez" y codigo postal "10001"
    And finaliza la compra
    Then debe ver el mensaje de confirmacion "THANK YOU FOR YOUR ORDER"
