# Sistema de Gestión de Préstamos Bancarios

Este es un sistema web desarrollado con Java y Spring Boot para la gestión de préstamos en una entidad bancaria. Permite administrar clientes, solicitudes de préstamo, estados de aprobación, pagos y consulta de saldo pendiente.

# Funcionalidades principales

### 1. Registro de Clientes
- Se pueden crear clientes proporcionando datos como nombre, apellido, CUI, fecha de nacimiento, correo, dirección y teléfono.

### 2. Solicitudes de Préstamos
- Un cliente registrado puede realizar una solicitud de préstamo especificando el monto, plazo e interés.
- La solicitud es asociada a un estado inicial: **En proceso**.

### 3. Gestión de Estados de Solicitud
- Un usuario puede cambiar el estado de una solicitud a:
  - **Aprobado**
  - **Rechazado**

### 4. Aprobación y Generación de Préstamos
- Una vez aprobada una solicitud, se genera un préstamo vinculado con su propio estado (**Activo** por defecto).

### 5. Registro de Pagos
- Los pagos se pueden registrar con fecha y monto.
- Cada pago se asocia a un préstamo específico.

### 6. Cálculo de Saldo Pendiente
- El sistema permite consultar cuánto debe un cliente en base a los pagos realizados y el monto inicial del préstamo.

## Despliegue con Docker

### Prerrequisitos
- Tener instalado [Docker Desktop](https://www.docker.com/).
- Tener instalado Maven https://maven.apache.org/download.cgi y debe estar añadido al path de Windows
- Se debe clonar el repositorio https://github.com/sidialpez/prestamos.git
- Abrir la terminal de Windows
- Ubicarse en el repositorio clonado y seguir los siguientes pasos:

### 1. Construcción del proyecto (generar JAR)
```bash
mvn clean package
```

### 2. Crear y levantar contenedores con Docker
```bash
docker-compose up --build
```
Esto hará lo siguiente:
- Crear un contenedor MySQL en el puerto `3307`.
- Ejecutar el script `init.sql` que crea las tablas necesarias y agrega datos iniciales.
- Levantar el contenedor del backend en el puerto `8080`.

### 3. Acceso al sistema
Abrir en el navegador la url: http://localhost:8080

## Tecnologías utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL 8
- Docker y Docker Compose
