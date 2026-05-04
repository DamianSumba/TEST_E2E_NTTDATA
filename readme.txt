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

================================================================================
REQUISITOS PREVIOS - VERSIONES DE TECNOLOGIAS


1. JAVA (JDK)
   - Version requerida: JDK 11 o superior (recomendado JDK 11 LTS)
   - Descarga: https://adoptium.net/temurin/releases/?version=11
   - Verificar instalacion: java -version
   - Debe mostrar: openjdk version "17.x.x" o superior

2. MAVEN
   - Version requerida: Apache Maven 3.8.x o superior
   - Descarga: https://maven.apache.org/download.cgi
   - Verificar instalacion: mvn -version
   - Debe mostrar: Apache Maven 3.8.x o superior

3. GOOGLE CHROME
   - Version recomendada: Chrome 119 o superior (ultima version estable)
   - Descarga: https://www.google.com/chrome/
   - NOTA: WebDriverManager descarga automaticamente el ChromeDriver compatible
   - Verificar version: chrome://version en el navegador

4. GIT
   - Version requerida: Git 2.x o superior
   - Descarga: https://git-scm.com/downloads
   - Verificar instalacion: git --version

VERSIONES DE DEPENDENCIAS DEL PROYECTO (definidas en pom.xml):
   - Serenity BDD:          3.9.8
   - Serenity Screenplay:   3.9.8 (incluido en BOM)
   - Serenity Cucumber:     3.9.8 (incluido en BOM)
   - Cucumber Java:         7.14.0
   - JUnit:                 4.13.2
   - WebDriverManager:      5.6.3
   - AssertJ:               3.24.2

================================================================================
ESTRUCTURA DEL PROYECTO


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

================================================================================
INSTRUCCIONES DE INSTALACION Y CONFIGURACION


PASO 1: CLONAR EL REPOSITORIO

Abrir una terminal y ejecutar:

  git clone https://github.com/[USUARIO]/saucedemo-serenity-screenplay.git
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

Si prefiere usar Chrome en modo headless (sin interfaz grafica, ideal para CI/CD):
  Editar src/test/resources/serenity.conf y agregar "--headless=new" en args:
  
  args = ["--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", 
          "--window-size=1920,1080", "--headless=new"]

PASO 4: DESCARGAR DEPENDENCIAS MAVEN

En la raiz del proyecto ejecutar:

  mvn dependency:resolve

Esto descargara todas las dependencias necesarias al repositorio local Maven.
(Requiere conexion a internet la primera vez)

================================================================================
INSTRUCCIONES DE EJECUCION


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

================================================================================
VISUALIZAR REPORTES


REPORTE SERENITY (Principal - HTML interactivo):
  Abrir en navegador: target/site/serenity/index.html
  
  El reporte incluye:
  - Resumen ejecutivo de pruebas
  - Screenshots de cada paso
  - Historial de ejecucion por escenario
  - Detalle de tareas Screenplay ejecutadas

REPORTE CUCUMBER (JSON y HTML):
  - JSON: target/cucumber-reports/cucumber.json
  - HTML: target/cucumber-reports/cucumber.html

CAPTURAS DE PANTALLA:
  Las screenshots se guardan automaticamente en:
  target/site/serenity/screenshots/

================================================================================
SOLUCION DE PROBLEMAS COMUNES


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

