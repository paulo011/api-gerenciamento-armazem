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
  class Armazem{
    -Long id
    -Long userId
    -Long ProductId
    -ProductHistoric[] productHistoric
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
    -Long productId
    -Long userId
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
    -barcode
    -productName
    -description
    -Float value
    -Size Size
    -Float weight
    -Category category
    -Boolean inStock
  }

  class Category{
    -Long id,
    -String tipe
  }
  class Size {
    -Float width
    -Float height
  } 
  class TransactionEnum{
    added,
    deduct,
    return
  }
  class RoleEnum{
    user,
    adm
  }
  Armazem "1" *-- "*" User
  Armazem "1" o-- "*" ProductHistoric
  Armazem "1" *-- "*" Product
  User "*" o-- "1" Address
  User "1" *--* "*" RoleEnum
  Product "1" *-- "1" Size
  Product "*" o-- "1" Category
  ProductHistoric "1" *--* "1" TransactionEnum
  ProductHistoric "1" --* "1" User
  ProductHistoric "1" --* "1" Product

