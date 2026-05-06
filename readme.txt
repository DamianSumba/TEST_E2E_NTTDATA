================================================================================
         PROYECTO: SauceDemo E2E Tests - Serenity BDD con Screenplay
         Prueba Funcional Automatizada - Flujo de Compra Completo
================================================================================

DESCRIPCION
-----------
Proyecto de automatizacion de pruebas End-to-End (E2E) para el sitio web
https://www.saucedemo.com/ utilizando el framework Serenity BDD con el
patron de diseño Screenplay y Cucumber BDD.

El flujo automatizado cubre:
      1. Autenticacion con usuario: standard_user / password: secret_sauce
      2. Agregar dos productos al carrito (Sauce Labs Backpack + Sauce Labs Bike Light)
      3. Visualizacion del carrito de compras
      4. Completar formulario de informacion de compra
      5. Finalizar la compra hasta confirmacion "THANK YOU FOR YOUR ORDER"


1. ENTORNO DE EJECUCION

El proyecto fue desarrollado y probado con las siguientes versiones:

   - Java:              Version: 17 - 23
   - Maven:             Version: 3.8.6 o superior
   - Sistema Operativo: Windows / Linux

   VERSIONES DE DEPENDENCIAS DEL PROYECTO (definidas en pom.xml):

   - Serenity BDD:          3.9.8
   - Serenity Screenplay:   3.9.8 (incluido en BOM)
   - Serenity Cucumber:     3.9.8 (incluido en BOM)
   - Cucumber Java:         7.14.0
   - JUnit:                 4.13.2
   - WebDriverManager:      5.6.3
   - AssertJ:               3.24.2

  NOTA:
  Se recomienda utilizar versiones iguales o superiores para evitar problemas
  de compatibilidad.


2. EJECUCION DE PRUEBAS

   OPCION A: EJECUCION COMPLETA (recomendada)

       Ejecuta las pruebas Y genera el reporte HTML de Serenity:

         mvn clean verify

         - Las pruebas se ejecutan durante la fase "integration-test"
         - El reporte se genera en: target/site/serenity/index.html

   OPCION B: SOLO EJECUTAR PRUEBAS

     mvn clean test -Dtest=CucumberTestRunner

   OPCION C: EJECUTAR CON TAG ESPECIFICO

     mvn clean verify -Dcucumber.filter.tags="@compra-exitosa"

   OPCION D: EJECUTAR EN MODO HEADLESS (sin ventana del navegador)

   Editar serenity.conf y agregar --headless=new en args, luego:

     mvn clean verify


3. GENERACION DE REPORTES

   El framework Serenity BDD genera automáticamente reportes detallados luego
   de la ejecución de las pruebas.

   Ruta de generación de reportes:
     - target/site/serenity/

   Archivo principal del reporte:
     - target/site/serenity/index.html

   COMO VISUALIZAR LOS REPORTES

        1. Ejecutar las pruebas con Maven
        2. Navegar a la ruta:
           target/site/serenity/
        3. Abrir el archivo:
           index.html

        También se puede abrir directamente en el navegador: file:///.../target/site/serenity/index.html

   REPORTE CUCUMBER (JSON y HTML):
     - JSON: target/cucumber-reports/cucumber.json
     - HTML: target/cucumber-reports/cucumber.html

   CAPTURAS DE PANTALLA:
     Las screenshots se guardan automaticamente en:
     target/site/serenity/screenshots/

   CONTENIDO DE LOS REPORTES

    Los reportes generados por Serenity incluyen:

    * Estado de ejecución (PASSED / FAILED)
    * Detalle de escenarios ejecutados
    * Evidencia visual (screenshots por cada paso)
    * Trazabilidad completa de Steps, Tasks y Questions
    * Mensajes de error en caso de fallo

4. ESTRUCTURA DEL PROYECTO


    saucedemo-serenity/
    ├── pom.xml                                    # Configuracion Maven y dependencias
    ├── readme.txt                                 # Este archivo
    ├── conclusiones.txt                           # Hallazgos y conclusiones
    └── src/
        └── test/
            ├── java/
            │   └── com/saucedemo/
            │       ├── pages/                     # UI Maps (Page Objects)
            │       │   ├── LoginPage.java         # Targets de la pagina de login
            │       │   ├── InventoryPage.java     # Targets del inventario
            │       │   ├── CartPage.java          # Targets del carrito
            │       │   └── CheckoutPage.java      # Targets del checkout
            │       ├── tasks/                     # Tareas Screenplay
            │       │   ├── Authenticate.java      # Tarea: autenticarse
            │       │   ├── AddProductToCart.java  # Tarea: agregar producto
            │       │   ├── NavigateToCart.java    # Tarea: ir al carrito
            │       │   ├── CompleteCheckoutInformation.java  # Tarea: llenar formulario
            │       │   └── FinishPurchase.java    # Tarea: finalizar compra
            │       ├── questions/                 # Preguntas Screenplay
            │       │   └── PurchaseQuestions.java # Verificaciones del flujo
            │       ├── features/                  # Step Definitions de Cucumber
            │       │   └── CompraStepDefinitions.java
            │       └── runners/                   # Ejecutores de pruebas
            │           └── CucumberTestRunner.java
            └── resources/
                ├── serenity.conf                  # Configuracion de Serenity/WebDriver
                └── features/
                    └── compra_saucedemo.feature   # Escenario BDD en Gherkin


5. INSTRUCCIONES DE INSTALACION Y CONFIGURACION

    PASO 1: CLONAR EL REPOSITORIO
    Abrir una terminal y ejecutar:
      https://github.com/DamianSumba/TEST_E2E_NTTDATA.git
      cd saucedemo-serenity-screenplay

    PASO 2: VERIFICAR PREREQUISITOS
        Verificar que Java y Maven esten instalados correctamente:
          java -version
          mvn -version

        Si Java no esta instalado:
          - Windows/Mac: Descargar JDK 23 de https://adoptium.net/
          - Linux (Ubuntu/Debian): sudo apt install openjdk-23-jdk

        Si Maven no esta instalado:
          - Seguir instrucciones en https://maven.apache.org/install.html
          - O instalar via SDKMAN: sdk install maven

    PASO 3: VERIFICAR CHROME
        Asegurarse de tener Google Chrome instalado.
        WebDriverManager se encarga automaticamente de descargar el ChromeDriver correcto.

    PASO 4: DESCARGAR DEPENDENCIAS MAVEN

        En la raiz del proyecto ejecutar:

          mvn dependency:resolve

        Esto descargara todas las dependencias necesarias al repositorio local Maven.
        (Requiere conexion a internet la primera vez)


5. SOLUCION DE PROBLEMAS COMUNES

        PROBLEMA: "No se encuentra chromedriver"
        SOLUCION: WebDriverManager lo descarga automaticamente. Verificar conexion a internet.
                  Si hay proxy corporativo, configurar en serenity.conf.

        PROBLEMA: "Element not found" o TimeoutException
        SOLUCION: La pagina puede estar lenta. Verificar conexion a internet.
                  Aumentar timeouts en serenity.conf:
                  webdriver.wait.for.timeout = 10000

        PROBLEMA: "Maven no reconocido como comando"
        SOLUCION: Agregar Maven al PATH del sistema operativo.
                  Verificar JAVA_HOME este configurado correctamente.

        PROBLEMA: Chrome se cierra inmediatamente
        SOLUCION: Verificar que la version de Chrome sea compatible.
                  Actualizar Chrome a la ultima version estable.

        PROBLEMA: Tests fallan por cambio en la web
        SOLUCION: Verificar que saucedemo.com este disponible.
                  Los selectores pueden cambiar si el sitio se actualiza.

