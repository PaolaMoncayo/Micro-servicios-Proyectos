# Micro-Proyectos API

Este proyecto es un microservicio desarrollado con **Spring Boot** que expone una API REST para la gestión de proyectos. Su propósito es permitir operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una entidad llamada `Proyecto`. El sistema está preparado para ejecutarse en contenedores Docker y aplica validaciones automáticas.

---

## Funcionalidades principales

- **Gestión de Proyectos**: Soporte completo para operaciones CRUD.
- **Validaciones**: Validaciones automáticas en los datos ingresados.
- **API REST**: Endpoints bien definidos para interactuar con el sistema.
- **Soporte Docker**: Capacidad de construir y ejecutar el sistema en contenedores Docker.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (versión Ultimate recomendada para soporte completo de Spring Boot).
- [Docker Desktop](https://www.docker.com/products/docker-desktop/).
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).
- [Postman](https://www.postman.com/) o cualquier herramienta para realizar pruebas API.
---


## Endpoints de la API

La API proporciona los siguientes endpoints:

| Método | URL                  | Descripción                                  |
|--------|----------------------|----------------------------------------------|
| GET    | `/api/proyectos`     | Obtiene una lista de todos los proyectos.    |
| GET    | `/api/proyectos/{id}`| Obtiene los detalles de un proyecto por ID.  |
| POST   | `/api/proyectos`     | Crea un nuevo proyecto.                      |
| PUT    | `/api/proyectos/{id}`| Actualiza un proyecto existente.             |
| DELETE | `/api/proyectos/{id}`| Elimina un proyecto por su ID.               |

---

### 1. Clonar el repositorio

1. Abre tu terminal o línea de comandos y clona el repositorio del proyecto:
   bash
   git clone https://github.com/PaolaMoncayo/Micro-servicios-Proyectos.git

### 2. Ingresa al directorio del proyecto:


```bash
 cd micro-proyectos Paola
```
### 3. Abre el proyecto en IntelliJ IDEA:

- Inicia IntelliJ IDEA.
- Selecciona File > Open... y elige la carpeta del proyecto que acabas de clonar.

## Configuración de Docker para la base de datos

- Asegúrate de que Docker Desktop esté ejecutándose correctamente en tu máquina.

- Descarga la última imagen de MySQL ejecutando el siguiente comando en tu terminal:

```bash

docker pull mysql:latest
```

- Crea un contenedor de MySQL usando el comando:

```bash

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -d -p 3308:3306 mysql:latest
```

- --name mysql-container: Define el nombre del contenedor como mysql-container.
- -e MYSQL_ROOT_PASSWORD=rootpassword: Establece la contraseña del usuario root.
- -p 3308:3306: Expone el puerto 3306 del contenedor en el puerto 3308 de tu máquina.

### 1. Abre MySQL Workbench y crea una conexión a la base de datos:

- Hostname: localhost.
- Port: 3308.
- Username: root
- Password: rootpassword
- Una vez conectado, puedes administrar y explorar las tablas del proyecto.
- Crear base de datos sysdb2025

## Ejecutar el contenedor de la aplicación

- Ve al directorio del archivo micro-cursos:

```bash

cd micro-cursos
```
- Construye el contenedor de Docker para la aplicación:

```bash

docker compose build
```

- Una vez construido, ejecuta la aplicación:

```bash

docker compose up
```

##  Probar la API

- Abre un navegador y verifica si la API está funcionando accediendo a la siguiente URL:

```bash

http://localhost:8005/api/proyectos
```

- Para realizar pruebas en Postman, utiliza el siguiente JSON para crear un reclamo con una solicitud POST a la URL http://localhost:8005/api/proyectos

```bash
{
  "nombre": "Proyecto A",
  "descripcion": "Descripción del Proyecto A",
  "duracionMeses": 12,
  "fechaInicio": "2025-01-01"
}
```
  

