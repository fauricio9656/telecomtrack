# 📡 TelecomTrack

Sistema web transaccional para gestionar herramientas y materiales de **Telecom Power Systems**, mejorar la trazabilidad del inventario y registrar las operaciones asociadas a proyectos y personal técnico.

> [!IMPORTANT]
> TelecomTrack es el proyecto final del curso **SC-403 Desarrollo de Aplicaciones Web y Patrones** de la Universidad Fidélitas.  
> La implementación debe respetar las tecnologías, dependencias, estructura MVC y forma de codificación trabajadas durante el curso. Un cambio fuera de esos parámetros puede invalidar el avance correspondiente.

---

## 📋 Descripción

Telecom Power Systems administra herramientas y materiales mediante hojas de cálculo y registros manuales. Esto dificulta conocer las existencias reales, identificar responsables, controlar las asignaciones y consultar el historial de movimientos.

TelecomTrack busca centralizar ese proceso mediante una aplicación web con inventario, solicitudes, aprobaciones, devoluciones, proyectos, usuarios, roles y registros transaccionales.

---

## 🚧 Estado del Proyecto

Estado actual: **preparación del Avance 2**.

| Entrega | Estado |
|---|---|
| Avance 1 | Finalizado |
| Avance 2 | En preparación |
| Entrega final y defensa | Planificada |

---

## 📦 Alcance por Entrega

### 1️⃣ Entrega 1 — Avance 1

El primer avance definió el problema, el cliente, los usuarios, las historias de usuario, los criterios de aceptación, la priorización del backlog, el flujo de navegación, el modelo preliminar de datos y el prototipo inicial.

La documentación de esta entrega se encuentra en [`docs/avance1/`](docs/avance1/).

### 2️⃣ Entrega 2 — Avance 2

El segundo avance debe demostrar una implementación funcional del proyecto e incluir:

- Al menos el 50 % de las historias de usuario o los flujos de mayor prioridad completamente funcionales.
- Proyecto Java con Spring Boot organizado en `domain`, `repository`, `service` y `controller`.
- Vistas dinámicas con Thymeleaf.
- Bootstrap incorporado según lo trabajado en clase.
- Persistencia mediante Hibernate/JPA y una base de datos relacional.
- CRUD de las entidades principales.
- Navegación coherente con el prototipo del Avance 1.
- Participación verificable de todos los integrantes mediante ramas, commits, revisiones y pull requests.
- Instrucciones preliminares de configuración y ejecución.
- Demostración del funcionamiento real del sistema.

### 3️⃣ Entrega 3 — Artículo, Aplicación Final y Defensa

La tercera entrega debe completar el alcance académico y técnico del proyecto:

- Aplicación web transaccional terminada.
- Base de datos con al menos ocho tablas y una tabla destinada a registrar transacciones.
- Autenticación, roles y restricciones de acceso funcionales.
- Internacionalización mediante archivos de idioma.
- Integración de al menos seis temas desarrollados en el curso.
- Una funcionalidad o tecnología adicional investigada por el equipo.
- Script, respaldo o instrucciones para crear y poblar la base de datos.
- Usuarios de prueba para los roles implementados.
- README técnico actualizado.
- Artículo científico en formato IEEE.
- Evidencia final de colaboración en GitHub.
- Presentación y demostración funcional durante la defensa.

---

## 👥 Equipo

Las responsabilidades se asignan y actualizan en cada avance según el backlog aprobado por el equipo.

| Integrante | GitHub | Responsabilidad actual |
|---|---|---|
| Allan Fauricio Fonseca Batista | [@fauricio9656](https://github.com/fauricio9656) | Pendiente de asignación para el Avance 2 |
| Carlos Roberto Pérez Rodríguez | [@ZerepSolrac412](https://github.com/ZerepSolrac412) | Pendiente de asignación para el Avance 2 |
| Sebastián Segura Camacho | [@SebastianSC11](https://github.com/SebastianSC11) | Pendiente de asignación para el Avance 2 |
| Alberto Manuel Zúñiga Sánchez | [@BETOXPROGRAMING](https://github.com/BETOXPROGRAMING) | Pendiente de asignación para el Avance 2 |

---

## 🛠️ Tecnologías y Herramientas

| Área | Tecnología o herramienta | Estado |
|---|---|---|
| Lenguaje | Java 21 | Preparación |
| Framework | Spring Boot | Preparación |
| Arquitectura | Modelo MVC | Preparación |
| Vistas | HTML5, CSS y Thymeleaf | Preparación |
| Interfaz | Bootstrap mediante WebJars | Preparación |
| Persistencia | Spring Data JPA e Hibernate | Preparación |
| Base de datos | MySQL | Preparación |
| Construcción | Maven Wrapper | Preparación |
| Control de versiones | Git y GitHub | En uso |
| Prototipado | Figma | Utilizado en el Avance 1 |

> [!NOTE]
> Las tecnologías marcadas como **Preparación** se actualizarán cuando su implementación quede integrada y validada en la rama principal.

---

## 🗂️ Estructura del Repositorio

```text
telecomtrack/
├── docs/
│   └── avance1/
├── src/
├── .gitignore
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
└── README.md
```

- `docs/`: documentación y evidencias de cada entrega.
- `src/`: código fuente de la aplicación.
- `CONTRIBUTING.md`: flujo de trabajo, ramas, commits, issues y pull requests.
- `CODE_OF_CONDUCT.md`: normas de convivencia y responsabilidad académica.

La estructura se actualizará conforme se incorpore la base oficial del proyecto Spring Boot.

---

## 🤝 Contribución

El desarrollo directo corresponde a los integrantes del equipo y debe mantenerse dentro del alcance definido por el curso.

Antes de realizar cambios, es obligatorio leer:

- [Guía de contribución](CONTRIBUTING.md)
- [Código de conducta](CODE_OF_CONDUCT.md)

El incumplimiento de las normas académicas, técnicas o de colaboración puede poner en riesgo la entrega y será comunicado al docente cuando corresponda.
