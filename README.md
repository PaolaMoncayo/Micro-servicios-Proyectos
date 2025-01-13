# Micro-Proyectos API

Este proyecto es un microservicio desarrollado con **Spring Boot** que expone una API REST para la gestión de proyectos. Su propósito es permitir operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una entidad llamada `Proyecto`. El sistema está preparado para ejecutarse en contenedores Docker y aplica validaciones automáticas.

---

## Funcionalidades principales

- **Gestión de Proyectos**: Soporte completo para operaciones CRUD.
- **Validaciones**: Validaciones automáticas en los datos ingresados.
- **API REST**: Endpoints bien definidos para interactuar con el sistema.
- **Soporte Docker**: Capacidad de construir y ejecutar el sistema en contenedores Docker.

---

## Requisitos previos

Antes de comenzar, asegúrate de contar con lo siguiente instalado:

- **Java 17**
- **Maven 3.8+**
- **Docker** y **Docker Compose**

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

## Instrucciones de uso

### Ejecución local (sin Docker)

1. **Clona el repositorio**:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <CARPETA_DEL_PROYECTO>
2. **Compilar el proyecto**:
Ejecuta el siguiente comando para limpiar y empaquetar el proyecto sin ejecutar las pruebas:
   ```bash
   mvn clean package -DskipTests
3. **Acceder a la API**:
   ```bash
   http://localhost:8005

# Instrucciones para Ejecutar el Proyecto con Docker

1. **Construir la imagen Docker:**  
   Ejecuta el siguiente comando para construir la imagen:  
   ```bash
   docker-compose build
   ```

2. **Levantar los contenedores:**  
   Usa este comando para iniciar los contenedores:  
   ```bash
   docker-compose up
   ```

3. **Acceder a la API:**  
   Una vez iniciado, la API estará disponible en:  
   ```bash
   http://localhost:8003
   ```




  

