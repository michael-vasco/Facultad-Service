### *facultad-service*

* *Responsable:*  michael stiven vasco cardenas (@michael-vasco)
* *Docker Hub:* michaelvasco/facultad-service:latest
* *Base URL (EC2):* http://<ip-o-dominio>:8080
* *Swagger UI:* http://<ip-o-dominio>:8080/swagger-ui

---

### *Entidades principales*

#### facultad

| Campo          | Tipo   | Restricciones             |
| -------------- | ------ | ------------------------- |
| id             | Long   | Autogenerado              |
| nombre         | String   | no vacio, no nulo, entre 2 a 50 caracteres            |
| contraseña     | String | Entre 6 y 100 caracteres  |
| descripcion         | String | no mas de 255 caracteres |
| direccion | String | Entre 5 y 100 caracteres, no nulo, no vacio  |
| ciudad            | String | entre 2 a 50 caracteres, no nulo, no vacio        |
| cupos       | Integer   | Numérico, no nulo, no vacio, entre 1 a 500 cupos |

---

### *Endpoints principales*

| Método     | Ruta                                           | Descripción                    |
| ---------- | ---------------------------------------------- | ------------------------------ |
| *GET*    | /api/v1/facultad-service/facultades             | Lista todos los facultades       |
| *GET*    | /api/v1/facultad-service/facultades/page/{page} | Lista facultades por página      |
| *GET*    | /api/v1/facultad-service/facultades/{id}        | Busca un facultad por ID        |
| *POST*   | /api/v1/facultad-service/facultades             | Crea un nuevo facultad          |
| *PUT*    | /api/v1/facultad-service/facultades             | Actualiza un facultad existente |
| *DELETE* | /api/v1/facultad-service/facultades             | Elimina un facultad existente   |

---

### *Tecnologías*

* *Spring Boot 3.4.4*
* *JDK 21*
* *Jakarta Validation (Bean Validation)*
* *Spring Data JPA*
* *Maven*
* *Docker*  (pendiente integración)
* *Swagger* (pendiente integración)

---

### *Características*

* API REST funcional con validaciones de entrada.
* Manejo de excepciones personalizadas (FacultadNoEncontradoException, ValidationException, etc.).
* Paginación implementada con PageRequest.
* Entidad Facultad completamente validada con anotaciones @NotNull, @Email, @Size, @Digits.
* Compatible con Swagger UI para documentación automática.

---

## *Responsables*

| Rol                     | Nombre          | Usuario GitHub          | Observaciones              |
| ----------------------- | --------------- | ----------------------- | -------------------------- |
| Autor del microservicio | michael stiven vasco cardenas  | @michael-vasco | Desarrollo y documentación |
| DevOps                  | michael stiven vasco cardenas  | @michael-vasco | none |

---

*Fecha:* 2025-11-11

### *Cambios relevantes*

* Implementación completa del CRUD de Facultad.
* Validaciones de datos y manejo de errores personalizado.
* Integración de paginación en endpoints de lectura.
* Pendiente: integración final de Swagger UI y despliegue en EC2.