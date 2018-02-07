# Technology stack
- Spring
- Springfox: for providing the dynamic api-docs
- SwaggerUI: for accessing the api using a browser
- Swagger Codegen: for generating client code stubs

## Springfox
- Provide complete api-docs for every @RESTController
    - services
    - supported verbs (GET/POST/...)
    - Request parameters/body
    - Response codes + body
- Many customization options

## Swagger UI
- Javascript application for accessing REST API using browser
- List all services directly from (dynamic) api-docs
- Always consistent with API

## Swagger codegen
- Client code stub generator
- Generates client stubs

## Why generate client code
- Ensure consistency between client code with API

## How to view
- Run server
- Open "http://localhost:9000/swagger-ui.html" to see the swagger-ui