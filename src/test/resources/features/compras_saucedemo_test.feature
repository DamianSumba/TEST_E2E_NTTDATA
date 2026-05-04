Feature: Flujo de Compra en SauceDemo

  Como usuario registrado de SauceDemo
  Quiero poder realizar una compra completa
  Para obtener los productos que necesito

  Background:
    Given que el usuario esta en la pagina de login de SauceDemo

  Scenario: Completar flujo de compra con dos productos
    When el usuario se autentica con usuario "standard_user" y password "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And agrega el producto "Sauce Labs Bike Light" al carrito
    And navega al carrito de compras