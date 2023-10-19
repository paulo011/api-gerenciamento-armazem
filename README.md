# api-gerenciamento-de-armazem
Api de gerenciamento de armazém open source.
## Tecnologias usadas:
- Java 17
- Spring Framework 3
- spring Security
- Swagger com Openapi
- OpenFeign
- JUnit

## Diagrama de entidades:
```mermaid

classDiagram
  class Warehouse{
    -Long id
    -String name
    -User[] userList
    -Product[] ProductList
  }
  class User {
    -Long id
    -String firstName
    -String lastName
    -String email
    -Address addres
    -Role[] roles
  }

  class ProductHistoric {
    -Long id
    -Product product
    -User user
    -Date date
    -Transaction transaction
    -String description
  }
  class Address {
    -String zipCode
    -String street
    -String district
    -String state
    -String uf
    -String ddd
    -String house
    -String complement
  }
  class Product {
    -String barcode
    -String name
    -String description
    -Float value
    -Float width
    -Float height
    -Float weight
    -Category category
    -Boolean inStock
    -ProductHistoric[] productHistoric
  }

  class Category{
    -Long id,
    -String type
  }
 
  class TransactionEnum{
    ADDED,
    REMOVED
  }
  class RoleEnum{
    USER,
    MANAGER
  }
  Warehouse "1" *-- "*" User
  Warehouse "1" *-- "*" Product
  User "*" o-- "1" Address
  User "1" *--* "*" RoleEnum
  Product "*" o-- "1" Category
  ProductHistoric "1" *--* "1" TransactionEnum
  ProductHistoric "*" --* "1" User
  ProductHistoric "*" --* "1" Product

