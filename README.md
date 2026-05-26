#  AeroSystem — Sistema de Gestión de Vuelos

Proyecto académico desarrollado en Java con Spring Boot que implementa una API REST completa para la gestión de vuelos, reservas, usuarios y recursos aeronáuticos. Incluye una interfaz web integrada construida con React.

---

## Tecnologías utilizadas

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 17+ | Lenguaje principal |
| Spring Boot | 3.2.5 | Framework backend |
| Spring Data JPA | 3.2.5 | Acceso a base de datos |
| Hibernate | 6.4.4 | ORM |
| H2 Database | 2.2.224 | Base de datos en memoria |
| Spring Validation | 3.2.5 | Validación de datos |
| Jackson | 2.15.4 | Serialización JSON |
| React 18 | CDN | Interfaz web |
| Maven | 3.x | Gestión de dependencias |

---

## Arquitectura — Patrón MVC

El proyecto sigue el patrón **Model-View-Controller** con separación en capas:

```
Browser/Cliente
      ↓  HTTP (GET / POST / PUT / DELETE)
  Controller      →  Recibe la petición y delega al Service
      ↓
   Service        →  Ejecuta la lógica de negocio
      ↓
  Repository      →  Interactúa con la base de datos via JPA
      ↓
  H2 Database     →  Base de datos en memoria
```

---

## Estructura del proyecto

```
src/main/java/com/example/vuelos/
├── VuelosApplication.java               # Clase principal
├── config/
│   ├── JacksonConfig.java               # Configuración de serialización JSON
│   └── WebConfig.java                   # Configuración CORS
├── controller/                          # Capa Controller — endpoints REST
│   ├── AerolineaController.java
│   ├── AeropuertoController.java
│   ├── AsientoController.java
│   ├── AvionController.java
│   ├── CiudadController.java
│   ├── ConsultaController.java
│   ├── FechaController.java
│   ├── PagoController.java
│   ├── PilotoController.java
│   ├── ReservaController.java
│   ├── TarifaController.java
│   ├── TarjetaController.java
│   ├── UsuarioController.java
│   └── VueloController.java
├── exception/
│   └── GlobalExceptionHandler.java      # Manejo global de errores
├── model/                               # Capa Model — entidades JPA
│   ├── Persona.java                     # @MappedSuperclass (padre de Usuario y Piloto)
│   ├── Usuario.java
│   ├── Piloto.java
│   ├── Pago.java                        # @Inheritance(JOINED) (padre de Tarjeta)
│   ├── Tarjeta.java
│   ├── Vuelo.java
│   ├── Reserva.java
│   ├── Tarifa.java
│   ├── Avion.java                       # implements Especificacion
│   ├── Asiento.java
│   ├── Aeropuerto.java
│   ├── Aerolinea.java
│   ├── Ciudad.java
│   ├── Fecha.java
│   ├── Consulta.java
│   ├── Especificacion.java              # <<interface>>
│   ├── Clase.java                       # enum: BUSINESS, TURISTA, ECONOMY
│   └── TipoTarjeta.java                 # enum: DEBITO, CREDITO
├── repository/                          # Capa Repository — acceso a datos
│   └── [14 interfaces JpaRepository]
└── service/                             # Capa Service — lógica de negocio
    └── [14 interfaces + 14 implementaciones]

src/main/resources/
├── application.properties              # Configuración de la app
├── data.sql                            # Datos de prueba (carga automática)
└── static/
    └── index.html                      # Interfaz web React
```

---

##  Modelo de datos

### Jerarquías de herencia

**`Persona` (`@MappedSuperclass`)** — heredan `dniPersona`, `nombrePersona`, `apellidoPersona`:
- `Piloto`
- `Usuario`

**`Pago` (`@Inheritance JOINED`)** — tabla separada por subclase:
- `Tarjeta` (agrega `numeroTarjeta`, `tipoTarjeta`)

### Relaciones principales

| Relación | Tipo |
|---|---|
| Vuelo → Aeropuerto | `@ManyToMany` |
| Vuelo → Avion | `@ManyToOne` |
| Vuelo → Aerolinea | `@ManyToOne` |
| Vuelo → Piloto | `@ManyToOne` |
| Vuelo → Tarifa | `@OneToMany` |
| Avion → Asiento | `@OneToMany` |
| Aeropuerto → Ciudad | `@ManyToOne` |
| Reserva → Vuelo | `@ManyToOne` |
| Reserva → Usuario | `@ManyToOne` |
| Reserva → Pago | `@OneToOne` |
| Tarjeta → Usuario | `@ManyToOne` |
| Consulta → Usuario | `@ManyToOne` |

---

## Cómo ejecutar el proyecto

### Requisitos previos

- Java 17 o superior instalado
- IntelliJ IDEA Community Edition
- Conexión a internet (primera vez, para descargar dependencias Maven)

### Pasos

**1.** Clonar o descargar el repositorio y abrir la carpeta `proyectoVuelos` en IntelliJ:

```
File → Open → seleccionar la carpeta proyectoVuelos
```

**2.** Esperar que Maven descargue las dependencias (barra de progreso en la parte inferior).

**3.** Abrir `VuelosApplication.java` y ejecutar con el botón ▶.

**4.** Al iniciar correctamente, la consola mostrará:

```
========================================
  AEROSYSTEM - Gestión de Vuelos
========================================
  Local:    http://localhost:8080
  Red:      http://192.168.X.X:8080
  H2:       http://localhost:8080/h2-console
  API:      http://localhost:8080/api/vuelos
========================================
```

**5.** Abrir el navegador en `http://localhost:8080`

### Consola H2 (base de datos)

Ir a `http://localhost:8080/h2-console` y usar:

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:mem:testdb` |
| User Name | `sa` |
| Password | *(vacío)* |

---

## API REST — Endpoints disponibles

Cada entidad expone los mismos 5 endpoints:

| Método | URL | Descripción |
|---|---|---|
| `GET` | `/api/{entidad}` | Obtener todos los registros |
| `GET` | `/api/{entidad}/{id}` | Obtener por ID |
| `POST` | `/api/{entidad}` | Crear nuevo registro |
| `PUT` | `/api/{entidad}/{id}` | Actualizar registro existente |
| `DELETE` | `/api/{entidad}/{id}` | Eliminar registro |

**Entidades disponibles:**
`vuelos` · `reservas` · `consultas` · `aeropuertos` · `aerolineas` · `aviones` · `asientos` · `ciudades` · `fechas` · `usuarios` · `pilotos` · `tarifas` · `pagos` · `tarjetas`

### Ejemplo — Crear un vuelo

```bash
curl -X POST http://localhost:8080/api/vuelos \
  -H "Content-Type: application/json" \
  -d '{
    "numeroVuelo": 1234,
    "aerolinea": { "id": 1 },
    "avion": { "id": 1 },
    "piloto": { "id": 1 },
    "salida": { "id": 1 },
    "destino": { "id": 2 }
  }'
```

### Ejemplo — Crear una reserva

```bash
curl -X POST http://localhost:8080/api/reservas \
  -H "Content-Type: application/json" \
  -d '{
    "numeroReserva": 5001,
    "vuelo": { "id": 1 },
    "usuario": { "id": 1 },
    "pago": { "id": 1 }
  }'
```

---

##  Datos de prueba precargados

Al iniciar la app se cargan automáticamente desde `data.sql`:

| Entidad | Registros |
|---|---|
| Ciudades | 5 (Buenos Aires, Mendoza, Bariloche, Córdoba, Rosario) |
| Aeropuertos | 5 (Ezeiza, El Plumerillo, Bariloche, Taravella, Islas Malvinas) |
| Aerolíneas | 3 (Aerolíneas Argentinas, LATAM, Flybondi) |
| Aviones | 3 |
| Asientos | 8 |
| Pilotos | 3 |
| Vuelos | 3 |
| Tarifas | 6 |
| Usuarios | 3 |
| Pagos / Tarjetas | 3 |
| Reservas | 3 |

> Los IDs de nuevos registros comienzan desde **100** para no colisionar con los datos de prueba.

---

## Validaciones implementadas

Si un campo es incorrecto, la API devuelve un error descriptivo:

```json
{
  "error": "Datos inválidos",
  "campos": {
    "numeroVuelo": "El número de vuelo debe ser mayor a 0",
    "aerolinea": "La aerolínea es obligatoria"
  }
}
```

| Anotación | Uso |
|---|---|
| `@NotNull` | Campo obligatorio (objetos) |
| `@NotBlank` | Campo de texto obligatorio y no vacío |
| `@Min` | Valor numérico mínimo |
| `@Email` | Formato de email válido |

---

##  Autora

**Zoe García Badiola**
Proyecto académico — Programación Orientada a Objetos
Spring Boot · JPA · Hibernate · REST API · React

---

## Notas técnicas

- La base de datos H2 es **en memoria**: los datos se reinician cada vez que se reinicia la aplicación.
- Para compartir en red local, usar la IP que aparece en consola al iniciar.
- El proyecto **no requiere instalar ninguna base de datos externa**.
