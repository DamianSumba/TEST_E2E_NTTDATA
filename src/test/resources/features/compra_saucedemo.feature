@flujo-compra
Feature: Flujo de Compra en SauceDemo
  As a registered SauceDemo user
  I want to complete a purchase
  So that I can buy products

  Background:
    Given que el usuario esta en la pagina de login de SauceDemo

  @compra-exitosa
  Scenario Outline: Completar flujo de compra con dos productos - <descripcion>
    When el usuario se autentica con usuario "<usuario>" y password "<password>"
    And agrega el producto "<producto1>" al carrito
    And agrega el producto "<producto2>" al carrito
    And navega al carrito de compras
    Then el carrito debe contener 2 productos
    When completa el formulario de compra con nombre "<nombre>", apellido "<apellido>" y codigo postal "<codigo_postal>"
    And finaliza la compra
    Then debe ver el mensaje de confirmacion "Thank you for your order!"

    Examples:
      | descripcion                        | usuario       | password     | producto1             | producto2                    | nombre  | apellido | codigo_postal |
      | happy path Backpack y Bike Light   | standard_user | secret_sauce | Sauce Labs Backpack   | Sauce Labs Bike Light        | Juan    | Perez    | 10001         |
      | variante Fleece Jacket y Bolt Shirt| standard_user | secret_sauce | Sauce Labs Fleece Jacket | Sauce Labs Bolt T-Shirt   | Maria   | Gomez    | 90210         |
      | problem_user flujo core            | problem_user  | secret_sauce | Sauce Labs Backpack   | Sauce Labs Bike Light        | Carlos  | Lopez    | 00100         |
