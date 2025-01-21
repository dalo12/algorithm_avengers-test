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
    And there is one more product in the products page

  Scenario: Category empty
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled except category

  Scenario: Invalid size test
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "test" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled

  Scenario: Invalid order size
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XL,M,XS" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled

  Scenario: Invalid empty size
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled except size

  Scenario: Invalid image
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.mp4" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled

  Scenario: Empty image
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled except image

  Scenario: Price with comma
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420,69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user is redirected to the products page
    And there is one more product in the products page

  Scenario: Price 0
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "0" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled

  Scenario: Negative price
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "-1" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled

  Scenario: String in price
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "a" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled

  Scenario: Empty price
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled except price

  Scenario: Empty description
    Given the user is in the product creation page
    When the user enters "Remera de test" in Nombre field
    When the user enters "" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user is redirected to the products page
    And there is one more product in the products page

  Scenario: Empty description
    Given the user is in the product creation page
    When the user enters "" in Nombre field
    When the user enters "Esta es una remera de test" in Descripcion field
    When the user enters "420.69" in Precio field
    When the user enters "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg" in Imagen field
    When the user enters "XS,M,XL" in Talles field
    When the user selects 1 in Categoria select
    When the user clicks the Guardar button
    Then the user remains in the product creation page
    And all fields are filled except name
