Feature: Edit a existing product

  Scenario: All fields completed
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user is redirected to the products page from edit

  Scenario: Empty category
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting none
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled except category

  Scenario: Invalid size
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "test"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled

  Scenario: Invalid sizes order
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XL,M,XS"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled

  Scenario: Empty sizes
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with ""
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled except size

  Scenario: Invalid image
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.mp4"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled

  Scenario: Empty image
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with ""
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user is redirected to the products page from edit

  Scenario: Price with comma
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420,69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user is redirected to the products page from edit

  Scenario: Price zero
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "0"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled

  Scenario: Negative price
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "-1"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled

  Scenario: Text in price
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "a"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled

  Scenario: Empty price
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with ""
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled except price

  Scenario: Empty description
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "Remera de test"
    When the user edits the Description field with ""
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user is redirected to the products page from edit

  Scenario: Empty name
    Given the user is in the edition page of product with id "2"
    When the user edits the Nombre field with "F"
    When the user edits the Description field with "Esta es una remera de test"
    When the user edits the Precio field with "420.69"
    When the user edits the Imagen field with "/home/david/IdeaProjects/Automation_Testing/src/test/resources/assets/test.jpg"
    When the user edits the Talles field with "XS,M,XL"
    When the user edits the Categoria field selecting 1
    When the user clicks the Guardar button in edit page
    Then the user remains in the product edition page
    And all fields in edition are filled except name