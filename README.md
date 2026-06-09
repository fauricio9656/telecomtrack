# TelecomTrack

Sistema web de inventario de herramientas y materiales para **Telecom Power Systems**

---

## Descripcion

TelecomTrack es una aplicacion web que digitaliza el control de activos fisicos de Telecom Power Systems, empresa dedicada al diseno, instalacion y mantenimiento de infraestructura electrica y de telecomunicaciones.

**Problema que resuelve:** Eliminar el uso de hojas de calculo y papel para controlar herramientas y materiales, evitando perdidas, duplicacion de compras y falta de trazabilidad.

---

## Equipo

| Nombre | Rol | GitHub |
|--------|-----|--------|
| Fauricio | Desarrollador / Lider tecnico | [@fauricio9656](https://github.com/fauricio9656) |
| Carlos | Desarrollador | [@ZerepSolrac412](https://github.com/ZerepSolrac412) |
| Sebastian | Desarrollador | [@SebastianSC11](https://github.com/SebastianSC11) |
| Beto | Desarrollador | [@BETOXPROGRAMING](https://github.com/BETOXPROGRAMING) |

---

## Funcionalidades principales

- Gestion de catalogo de herramientas y materiales
- Solicitud y aprobacion de salidas de inventario
- Registro de devoluciones con estado del activo
- Reportes de consumo por proyecto y tecnico
- Alertas automaticas de stock minimo
- Control de acceso por roles: Administrador, Bodeguero, Tecnico de Campo, Supervisor

---

## Stack tecnologico

| Capa | Tecnologia |
|------|-----------|
| Backend | Java 17 + Servlets |
| Persistencia | Hibernate / JPA |
| Base de datos | MySQL 8 |
| Frontend | JSP + Bootstrap 5 |
| Control de versiones | Git + GitHub |
| IDE | NetBeans / IntelliJ IDEA |

---

## Estructura del proyecto

```
telecomtrack/
├── docs/
│   └── avance1/
│       ├── TelecomTrack_Avance1.docx
│       └── erd_telecomtrack.png
├── src/
│   └── main/
│       ├── java/
│       │   └── com/telecomtrack/
│       │       ├── model/
│       │       ├── dao/
│       │       ├── service/
│       │       └── controller/
│       └── webapp/
│           ├── WEB-INF/
│           └── views/
├── .gitignore
├── CONTRIBUTING.md
└── README.md
```

---

## Como ejecutar (desarrollo local)

1. Clonar el repositorio

```bash
git clone https://github.com/fauricio9656/telecomtrack.git
cd telecomtrack
```

2. Configurar base de datos en MySQL

```sql
CREATE DATABASE telecomtrack;
```

3. Ajustar credenciales en `src/main/resources/hibernate.cfg.xml`

4. Abrir en NetBeans, compilar y desplegar en Tomcat o GlassFish

---

## Avances del proyecto

| Avance | Descripcion | Fecha entrega | Estado |
|--------|-------------|---------------|--------|
| Avance 1 | Planteamiento, historias de usuario, modelo de datos, prototipo | 13-14 jun 2026 | En progreso |
| Practica 1 | CRUD con Hibernate/JPA | 20-21 jun 2026 | Pendiente |
| Caso Practico 1 | Funcionalidad completa (15%) | 27-28 jun 2026 | Pendiente |

---

## Contribuir

Ver [CONTRIBUTING.md](CONTRIBUTING.md) para el acuerdo de trabajo y convenciones del equipo.

---

*Proyecto academico — SC-403 Aplicaciones Web y Patrones — Universidad Fidelitas — 2026*
