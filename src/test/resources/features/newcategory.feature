Feature: Creating a new category

  Scenario: All fields filled
    Given the user is in the category creation page
    When the user enters "Categoría test" in Nombre field in category creation page
    When the user enters "Esta es una categoría de test" in Descripcion field  in category creation page
    When the user clicks the Guardar button in category creation page
    Then the user is redirected to the categories page
    And there is one more category in the categories page
