# MCC Account Service

Microservicio encargado de la gestión de cuentas bancarias dentro del proyecto **microservices-bank**.

Este servicio permite crear cuentas, consultar información de cuentas y realizar operaciones como depósitos.  
Además, se comunica con el **Customer Service** para validar la información del cliente asociado a cada cuenta.

## Tecnologías

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven

## Estructura del proyecto

src/main/java/com/psantana/mcc_account_service

- controller -> Endpoints REST
- service -> Lógica de negocio
- repository -> Acceso a datos
- entity -> Entidades de base de datos
- dto -> Objetos de transferencia de datos
- client -> Cliente REST para comunicación con otros microservicios
- util -> Interfaces genéricas (CRUD y Mapper)