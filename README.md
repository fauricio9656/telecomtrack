# TelecomTrack 🔧

> Sistema web de inventario de herramientas y materiales para **Telecom Power Systems**

[![Java](https://img.shields.io/badge/Java-17-orange)](https://openjdk.org/)
[![Hibernate](https://img.shields.io/badge/Hibernate-JPA-blue)](https://hibernate.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

---

## 📋 Descripción

TelecomTrack es una aplicación web que digitaliza el control de activos físicos de Telecom Power Systems, una empresa dedicada al diseño, instalación y mantenimiento de infraestructura eléctrica y de telecomunicaciones.

**Problema que resuelve:** Eliminar el uso de hojas de cálculo y papel para controlar herramientas y materiales, evitando pérdidas, duplicación de compras y falta de trazabilidad.

---

## 👥 Equipo

| Nombre | Rol | GitHub |
|--------|-----|--------|
| Fauricio | Desarrollador / Líder técnico | [@fauricio9656](https://github.com/fauricio9656) |
| _(integrante 2)_ | _(rol)_ | _(usuario)_ |
| _(integrante 3)_ | _(rol)_ | _(usuario)_ |

---

## 🚀 Funcionalidades principales

- 📦 Gestión de catálogo de herramientas y materiales
- 📤 Solicitud y aprobación de salidas de inventario
- 🔄 Registro de devoluciones con estado del activo
- 📊 Reportes de consumo por proyecto y técnico
- 🔔 Alertas automáticas de stock mínimo
- 👤 Control de acceso por roles (Admin, Bodeguero, Técnico, Supervisor)

---

## 🛠️ Stack tecnológico

| Capa | Tecnología |
|------|-----------|
| Backend | Java 17 + Servlets |
| Persistencia | Hibernate / JPA |
| Base de datos | MySQL 8 |
| Frontend | JSP + Bootstrap 5 |
| Control de versiones | Git + GitHub |
| IDE | NetBeans / IntelliJ IDEA |

---

## 📁 Estructura del proyecto

```
telecomtrack/
├── docs/                  # Documentación (avances, diagramas, prototipo)
│   ├── avance1/
│   │   ├── TelecomTrack_Avance1.docx
│   │   └── erd_telecomtrack.png
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/telecomtrack/
│   │   │       ├── model/        # Entidades JPA
│   │   │       ├── dao/          # Capa de acceso a datos
│   │   │       ├── service/      # Lógica de negocio
│   │   │       └── controller/   # Servlets / controladores
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       └── views/            # JSP
├── .gitignore
├── CONTRIBUTING.md
└── README.md
```

---

## ⚙️ Cómo ejecutar (desarrollo local)

```bash
# 1. Clonar el repositorio
git clone https://github.com/fauricio9656/telecomtrack.git
cd telecomtrack

# 2. Configurar base de datos
# Crear BD en MySQL: CREATE DATABASE telecomtrack;
# Ajustar credenciales en src/main/resources/hibernate.cfg.xml

# 3. Compilar y desplegar
# Abrir en NetBeans → Build → Run en servidor Tomcat/GlassFish
```

---

## 📅 Avances del proyecto

| Avance | Descripción | Fecha entrega | Estado |
|--------|-------------|---------------|--------|
| Avance 1 | Planteamiento, HU, prototipo, modelo de datos | 13-14 jun 2026 | ✅ En progreso |
| Práctica 1 | CRUD con Hibernate/JPA | 20-21 jun 2026 | ⏳ Pendiente |
| Caso Práctico 1 | Funcionalidad completa (15%) | 27-28 jun 2026 | ⏳ Pendiente |

---

## 🤝 Contribuir

Ver [CONTRIBUTING.md](CONTRIBUTING.md) para el acuerdo de trabajo y convenciones del equipo.

---

*Proyecto académico — SC-403 Aplicaciones Web y Patrones — Universidad Fidélitas — 2026*
