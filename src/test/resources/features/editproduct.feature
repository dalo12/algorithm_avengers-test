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
