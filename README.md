# Api de gerenciamento de armazém open source.
## Tecnologias utilizadas:
- Java 17
- Spring Framework 3
- spring Security
- Swagger com Openapi
- OpenFeign
- JUnit

## Arquitetura do sistema:
```mermaid
stateDiagram-v2
    [*] --> Endpoint
    Endpoint --> controller
    controller --> usecase
    usecase --> externalClientInterface
    externalClientInterface --> usecase
    externalClientInterface --> externalClient
    externalClient --> externalClientInterface
    usecase --> controller
    usecase --> domain
    usecase --> repositoryInterface
    gateway --> domain
    repositoryInterface --> repositoryImpl
    repositoryImpl --> repositoryInterface
    repositoryImpl --> gateway
    gateway --> scheme
    gateway --> repositoryImpl
    repositoryImpl --> repositoryJPA
    repositoryJPA --> repositoryImpl
    repositoryInterface --> usecase
    controller --> Endpoint