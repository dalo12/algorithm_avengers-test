Feature: Editing a category

  Scenario: All fields filled
    Given the user is in the edition page of category with id "1"
    When the user edits the category Nombre field with "Categoría test"
    When the user edits the category Descripcion field with "Esta es una categoría de test"
    When the user clicks the Guardar button in category edition page
    Then the user is redirected to the categories page from edit

  Scenario: Empty category
    Given the user is in the edition page of category with id "1"
    When the user edits the category Nombre field with "Categoría test"
    When the user edits the category Descripcion field with ""
    When the user clicks the Guardar button in category edition page
    Then the user is redirected to the categories page from edit

  Scenario: Empty name
    Given the user is in the edition page of category with id "1"
    When the user edits the category Nombre field with ""
    When the user edits the category Descripcion field with "Esta es una categoría de test"
    When the user clicks the Guardar button in category edition page
    Then the user remains in the category edition page
    And the descripcion field is filled in edition page