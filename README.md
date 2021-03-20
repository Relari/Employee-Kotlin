# Employee Kotlin
Este proyecto va a realizar un mantenimiento de empleados.

| Endpoint | Verb HTTP | Description |
| -------- | :-------: | ----------- |
| /employees | GET | List all employees. |
| /employees/{id} | GET | Find an employee. |
| /employees | POST | Create a new employee. |

## Getting Started

Siga las siguientes instrucciones para iniciar el desarrollo de este proyecto.

### Pre-requisites.

* [Project Lombok](https://projectlombok.org/) *Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.*
* [kukulkan](https://kukulkan-project.github.io/lineamientos/rest-guideline-kukulkan/) *Lineamientos para Servicios Rest.*
* [Udacity](https://udacity.github.io/git-styleguide/) *Udacity Git Commit Message Style Guide.*

### Arquitectura de Microservicios.
![Arquitectura de Microservicios](https://user-images.githubusercontent.com/50929974/86736585-4397b880-bff9-11ea-863d-fd4311744753.jpeg)

### Data model
| Description | Value |
| ----------- | ----- |
| DBMS | PostgreSQL |
| Database | demo |

#### *Employee*
| Name | Type | Primary Key | Auto Increment | Nullable |
| ---- | ---- | :---------: | :------------: | :------: |
| id | Integer | true | true | false | 
| father_last_name | Varchar(50) | - | - | false |
| mother_last_name | Varchar(50) | - | - | false |
| first_name | Varchar(50) | - | - | false |
| position | Varchar(50) | - | - | false |
| sex | Varchar(1) | - | - | false |
| salary | Double | - | - | false |
| is_active | Boolean | - | - | false |

## Autor
Renzo Lavado Rivas.
* [GitHub](https://github.com/Relari)
* [Facebook](https://www.facebook.com/Relari) 
