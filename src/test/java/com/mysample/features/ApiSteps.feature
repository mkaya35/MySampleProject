Feature: API Tests

  @smoke
  Scenario: GET request to /users
    Given existing server application 'https://reqres.in/api'
    Then on GET request to '/users' returns expected users list

  @smoke
  Scenario: GET request to single user
    Given existing server application 'https://reqres.in/api'
    Then on GET request to '/users/2' it returns expected welcome message

  @smoke
  Scenario: GET request to nonexisted user
    Given existing server application 'https://reqres.in/api'
    Then on GET request to '/users/23' it returns 404 status code