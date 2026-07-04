# 🤝 Guía de Contribución

Esta guía define cómo se planifica, desarrolla, revisa e integra el trabajo de TelecomTrack.

> [!IMPORTANT]
> Este repositorio forma parte del curso **SC-403 Desarrollo de Aplicaciones Web y Patrones**.  
> Toda contribución debe respetar el enunciado, la materia impartida, la estructura desarrollada en clase y el [Código de Conducta](CODE_OF_CONDUCT.md).

---

## 📌 Reglas Generales

| Regla | Aplicación |
|---|---|
| Respetar el alcance | No agregar tecnologías, dependencias, arquitecturas o formas de implementación no autorizadas por el curso. |
| No trabajar directamente en `main` | `main` contiene únicamente versiones estables y entregables. |
| No trabajar directamente en `develop` | Todo cambio debe ingresar a `develop` mediante una rama y un pull request aprobado. |
| Mantener cambios enfocados | Una rama y un pull request deben atender un objetivo concreto. |
| Conservar la trazabilidad | Cada integrante debe trabajar y confirmar cambios desde su propia cuenta. |
| Verificar antes de integrar | El código debe compilar, ejecutarse y conservar el funcionamiento existente. |
| Proteger la información | No subir contraseñas, tokens, llaves, datos personales ni configuraciones privadas. |
| Actualizar la documentación | Los cambios que afecten instalación, alcance o comportamiento deben documentarse. |

> [!IMPORTANT]
> **Un cambio lógico terminado = un commit.**

---

## 🧩 Uso de Issues

Los issues se utilizan para asignar y documentar las tareas del backlog, errores, dudas, documentación o mejoras.

Durante el Avance 2, todo cambio funcional, estructural o de configuración debe estar relacionado con un issue asignado. Cada issue debe desarrollarse en una rama independiente y completarse mediante un pull request hacia `develop`.

### 📝 Estructura de un Buen Issue


## Objetivo

Explicar qué debe resolverse.

## Alcance

Indicar qué módulos, archivos o historias de usuario están involucrados.

## Criterios de aceptación

- [ ] Criterio verificable
- [ ] Criterio verificable

## Validación

Explicar cómo se comprobará que la tarea funciona.

## Dependencias

Indicar si requiere otra tarea o cambio previo.


### 🏷️ Títulos Recomendados

```text
✨ [HU-01] Registrar herramientas
✨ [HU-04] Crear solicitud de materiales
🐛 [ERROR] Corregir descuento de stock
📝 [DOCS] Actualizar instrucciones de ejecución
```

### 🏷️ Etiquetas Disponibles

| Etiqueta | Uso |
|---|---|
| `bug` | Error reproducible o comportamiento incorrecto. |
| `documentation` | Cambios en README, guías o documentación. |
| `enhancement` | Nueva funcionalidad o mejora aprobada. |
| `question` | Duda que necesita definición del equipo. |
| `help wanted` | Tarea que requiere apoyo de otro integrante. |
| `good first issue` | Tarea pequeña y claramente delimitada. |
| `duplicate` | Issue que ya está registrado. |
| `invalid` | Solicitud incorrecta o fuera del alcance. |
| `wontfix` | Cambio que el equipo decidió no implementar. |

Cada issue debe asignarse al integrante responsable antes de comenzar el desarrollo.

---

## 🌿 Flujo de Ramas

La rama `main` representa la versión estable y entregable del proyecto.

La rama `develop` se utiliza para integrar, revisar y probar los cambios correspondientes al milestone activo antes de actualizar `main`.

Está prohibido desarrollar, corregir archivos o hacer push directamente sobre `main` o `develop`. Todo cambio debe realizarse en una rama creada desde la versión más reciente de `develop`.

El flujo general es:

```text
main
└── develop
    ├── chore/project-foundation
    ├── feat/hu-10-user-security
    ├── feat/tools-management
    ├── feat/materials-stock
    └── feat/requests-history
```

### 🧭 Nombres de Rama

Usar el formato:

```text
<tipo>/<descripcion-corta>
```

Ejemplos:

```text
feat/hu-01-catalogo-herramientas
feat/hu-04-solicitud-materiales
fix/validacion-stock-negativo
docs/actualizar-readme
refactor/organizar-servicio-material
test/validar-solicitud
chore/configurar-proyecto
```

Para el Avance 2 se utilizarán las siguientes ramas:

```text
chore/project-foundation
feat/hu-10-user-security
feat/tools-management
feat/materials-stock
feat/requests-history
```

Cada rama debe crearse desde develop y debe corresponder con el issue asignado.

Tipos permitidos:

| Tipo | Uso |
|---|---|
| `feat` | Nueva funcionalidad aprobada. |
| `fix` | Corrección de un error. |
| `docs` | Documentación. |
| `refactor` | Mejora interna sin cambiar el comportamiento. |
| `test` | Pruebas o validaciones. |
| `chore` | Configuración o mantenimiento del repositorio. |

No utilizar nombres personales, ambiguos o generales como:

```text
rama-alberto
cambios
prueba
final
trabajo
arreglos
```

---

## 🔄 Pipeline de Trabajo

### 1️⃣ Seleccionar la Tarea

- Elegir un issue asignado o una tarea aprobada por el equipo.
- Confirmar que no exista otra persona trabajando en lo mismo.
- Revisar sus criterios de aceptación y dependencias.

### 2️⃣ Actualizar `develop`

```bash
git switch develop
git pull origin develop
```

### 3️⃣ Crear la Rama
La rama debe crearse desde la versión más reciente de `develop` y utilizar el nombre indicado en el issue.

```bash
git switch -c feat/hu-01-catalogo-herramientas
```

### 4️⃣ Desarrollar y Revisar

Antes de confirmar cambios:

```bash
git status
git diff
```

Agregar solamente los archivos relacionados con el cambio:

```bash
git add ruta/del/archivo
```

### 5️⃣ Crear Commits Claros

Usar el formato:

```text
<emoji> <tipo>(<alcance>): <acción> <objeto>
```

Ejemplos:

```text
📝 docs(readme): actualizar alcance de entregas
✨ feat(herramienta): agregar registro de herramientas
🐛 fix(material): corregir validación de stock
♻️ refactor(solicitud): simplificar aprobación de solicitudes
✅ test(inventario): agregar validación de movimientos
🔧 chore(config): configurar propiedades del proyecto
```

Reglas:

- Escribir la descripción en español.
- Mantener el tipo de Conventional Commits en minúscula.
- Usar un verbo en infinitivo.
- Mantener la primera línea breve y específica.
- Incluir un alcance útil.
- No mezclar cambios sin relación.
- No usar mensajes como `cambios`, `update`, `final`, `arreglos` o `listo`.

### 6️⃣ Publicar la Rama

```bash
git push -u origin feat/hu-01-catalogo-herramientas
```

### 7️⃣ Abrir el Pull Request

El pull request debe apuntar desde la rama de trabajo hacia `develop` y explicar:


## Resumen

Qué se completó.

## Motivo

Por qué era necesario.

## Cambios

- Cambio realizado
- Cambio realizado

## Validación

Cómo se comprobó el funcionamiento.

## Issue Relacionado

Closes #numero
El uso de `Closes #numero` permite que GitHub cierre automáticamente el issue cuando el pull request sea integrado.

## Limitaciones

Limitaciones conocidas o `Ninguna`.


El título debe seguir el mismo formato de los commits:

```text
✨ feat(herramienta): agregar registro de herramientas
```

### 8️⃣ Avisar al Equipo

Cuando el trabajo esté listo, enviar en el canal acordado por el equipo:

```text
Pull request listo para revisión

Issue:
Rama:
Enlace del PR:
Cambio realizado:
Validación ejecutada:
Limitaciones conocidas:
```

También deben asignarse revisores dentro del pull request.

Los pull requests creados por Allan, Carlos o Sebastián deben asignar obligatoriamente a `@BetoxPrograming` como revisor.
Los pull requests creados por `@BetoxPrograming` deben asignar al menos a otro integrante del equipo como revisor.

### 9️⃣ Revisar y Probar

La revisión debe comprobar:

- Correspondencia con el issue y sus criterios de aceptación.
- Uso de la estructura y forma de codificación del curso.
- Compilación y ejecución del proyecto.
- Funcionamiento del flujo afectado.
- Persistencia correcta cuando aplique.
- Compatibilidad con las funcionalidades existentes.
- Ausencia de credenciales y archivos privados.
- Documentación actualizada cuando corresponda.

El autor debe atender todas las observaciones antes de solicitar una nueva revisión.

### 🔟 Aprobar el Merge

Todo pull request debe ser comunicado al grupo.

Los pull requests creados por Allan, Carlos o Sebastián solamente pueden integrarse después de recibir la aprobación formal de `@BetoxPrograming`, responsable de administrar la integración del proyecto.

Los pull requests creados por `@BetoxPrograming` requieren la aprobación formal de al menos otro integrante del equipo.

El merge solamente puede realizarse cuando:

- El cambio está completo.
- El pull request apunta hacia `develop`.
- El issue correspondiente está relacionado mediante `Closes #numero`.
- La validación fue documentada.
- Existe la aprobación formal requerida en GitHub.
- No existen conversaciones pendientes.
- No existen conflictos con `develop`.
- El código compila y ejecuta correctamente.
- Los criterios de aceptación del issue fueron comprobados.

El autor debe atender todas las observaciones antes de solicitar una nueva revisión.

Ningún autor puede aprobar su propio pull request.

### 1️⃣1️⃣ Sincronizar el Entorno

Después de integrar un pull request en `develop`, todos los integrantes deben actualizar su entorno:

```bash
git switch develop
git pull origin develop
```

Las ramas que continúen en desarrollo deben incorporar los cambios recientes de develop antes de abrir su pull request.

La rama integrada puede eliminarse cuando el equipo confirme que el cambio quedó estable.

### 1️⃣2️⃣ Integrar el Milestone en `main`

Cuando todos los issues del milestone estén completados, integrados y probados, se debe abrir un pull request desde `develop` hacia `main`.

Este pull request final debe incluir:

- Resumen de las historias implementadas.
- Lista de issues completados.
- Evidencia de compilación y ejecución.
- Resultado de las pruebas integradas.
- Limitaciones conocidas.
- Confirmación de que el README refleja el estado real del proyecto.

El pull request de `develop` hacia `main` solamente puede integrarse cuando la versión sea estable y esté lista para entregarse.

---

## ✅ Verificación Antes del Pull Request

Cuando el proyecto Spring Boot y Maven Wrapper estén incorporados, ejecutar:

### 🪟 Windows

```powershell
.\mvnw.cmd clean package
```

### 🐧 Linux o macOS

```bash
./mvnw clean package
```

También debe verificarse manualmente, según el cambio:

- La aplicación inicia sin errores.
- Las vistas afectadas cargan correctamente.
- Los formularios y enlaces funcionan.
- La operación se guarda correctamente en la base de datos.
- Los datos existentes continúan visibles.
- Los roles no acceden a funciones no autorizadas.
- Bootstrap y Thymeleaf se utilizan conforme a lo trabajado en clase.
- No se introdujeron tecnologías o dependencias no aprobadas.
- El pull request apunta hacia `develop`.
- El issue correspondiente está relacionado mediante `Closes #numero`.
- El revisor obligatorio fue asignado.
- La rama incorpora los cambios más recientes de `develop`.

Para cambios únicamente documentales:

- Previsualizar el Markdown.
- Verificar enlaces y rutas.
- Confirmar que el contenido coincide con el estado real del repositorio.

---

## 🚫 Cambios No Permitidos

No se aceptarán contribuciones que:

- Trabajen directamente sobre `main` o `develop`.
- Integren cambios en `develop` sin un pull request aprobado.
- Abran pull requests funcionales directamente hacia `main`.
- Aprueben o integren su propio pull request sin la revisión requerida.
- Sustituyan Spring Boot, Thymeleaf, Bootstrap, Hibernate/JPA o la estructura MVC requerida.
- Incorporen Bootstrap de una forma distinta a la vista en clase.
- Agreguen dependencias no revisadas y aprobadas por el equipo.
- Copien código, documentos o diseños sin autorización y trazabilidad.
- Simulen participación mediante commits vacíos o superficiales.
- Presenten funcionalidades planificadas como terminadas.
- Incluyan credenciales, información personal o datos confidenciales.
- Mezclen cambios funcionales, visuales y documentales sin relación.
- Eliminen evidencia del proceso colaborativo.

---

## ✅ Criterios de Aceptación de una Contribución

Una contribución puede integrarse cuando:

- Resuelve la tarea asignada.
- Cumple los criterios de aceptación.
- Permanece dentro del alcance académico.
- Utiliza la estructura existente.
- Conserva el funcionamiento del proyecto.
- Incluye validación suficiente.
- Mantiene commits claros y trazables.
- No afecta negativamente el trabajo de otros integrantes.
- Está relacionada con un issue asignado.
- Fue desarrollada desde una rama creada a partir de `develop`.
- Fue enviada mediante un pull request hacia `develop`.
- Cuenta con la aprobación formal del revisor requerido.
- Cumple el [Código de Conducta](CODE_OF_CONDUCT.md).
