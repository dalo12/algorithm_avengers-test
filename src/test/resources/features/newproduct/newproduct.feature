Feature: Create Product

  Scenario: All fields completed
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user is redirected to the products page
