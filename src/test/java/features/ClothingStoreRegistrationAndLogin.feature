Feature: Customer Registration and login
  
  A new customer must register with a unique email address. A registered customer should be able login and view his/her profile page.

  @tag1
  Scenario: Registration with new customer with pre-built data
    Given A user opens magento.softwaretestingboard.com at chrome
    When A new customer registers
    Then A new customer is registered
    And Close Chrome

  @tag2
  Scenario Outline: Registration with new customer with data table
    Given A user opens magento.softwaretestingboard.com at chrome
    When A new customer registers with <firstName>, <lastName>, <email>, <password>, <cPassword>
    Then A new customer <firstName>, <lastName> is registered
    And Close Chrome

    Examples: 
      | firstName | lastName  | email              | password    | cPassword   |
      | udula     | rathnayake | udularatnayake011@gmail.com   | @Qa123tesing | @Qa123tesing |
      | Sam3     | Smith3      | samsmith3@gmail.com | @Qa123tesing | @Qa123tesing |

  @tag3
  Scenario Outline: Login of registered customer with data table
    Given A user opens magento.softwaretestingboard.com at chrome
    When A registered customer enter <email>, <password>
    Then A registered customer <firstName>, <lastName> is successfully logged
    And Close Chrome

    Examples: 
      | firstName | lastName  | email              | password    | cPassword   |
      | oshitest1     | weertest1 | oshidishashinthini@gmail.com   | @Qa123tesing | @Qa123tesing |
      | Sam2     | Smith2      | samsmith2@gmail.com | @Qa123tesing | @Qa123tesing |
