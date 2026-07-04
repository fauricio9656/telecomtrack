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
| No trabajar en `main` | Todo cambio debe realizarse en una rama independiente. |
| Mantener cambios enfocados | Una rama y un pull request deben atender un objetivo concreto. |
| Conservar la trazabilidad | Cada integrante debe trabajar y confirmar cambios desde su propia cuenta. |
| Verificar antes de integrar | El código debe compilar, ejecutarse y conservar el funcionamiento existente. |
| Proteger la información | No subir contraseñas, tokens, llaves, datos personales ni configuraciones privadas. |
| Actualizar la documentación | Los cambios que afecten instalación, alcance o comportamiento deben documentarse. |

> [!IMPORTANT]
> **Un cambio lógico terminado = un commit.**

---

## 🧩 Uso de Issues

Los issues se utilizan inicialmente para asignar las tareas del backlog. También pueden emplearse para errores, dudas, documentación o mejoras.

Su uso posterior es recomendado, pero no obligatorio para cambios pequeños acordados por todo el equipo.

### 📝 Estructura de un Buen Issue

```markdown
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
```

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

La rama `main` representa la versión estable e integrable del proyecto.

Está prohibido desarrollar, corregir archivos o hacer push directamente sobre `main`.

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

### 2️⃣ Actualizar `main`

```bash
git switch main
git pull origin main
```

### 3️⃣ Crear la Rama

```bash
git switch -c feat/hu-01-catalogo-herramientas
```

La rama debe crearse desde la versión más reciente de `main`.

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

El pull request debe apuntar hacia `main` y explicar:

```markdown
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

## Limitaciones

Limitaciones conocidas o `Ninguna`.
```

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

El merge solamente puede realizarse cuando:

- El cambio está completo.
- La validación fue documentada.
- Existe al menos una aprobación formal de otro integrante en GitHub.
- El equipo confirma que el cambio puede integrarse.
- No existen conversaciones pendientes ni conflictos.

Los cambios que afecten seguridad, roles, base de datos, transacciones, dependencias, navegación principal o estructura del proyecto requieren aprobación explícita de todo el equipo.

El autor no debe integrar su propio cambio sin cumplir estas condiciones.

### 1️⃣1️⃣ Sincronizar el Entorno

Después del merge:

```bash
git switch main
git pull origin main
```

La rama integrada puede eliminarse cuando el equipo confirme que el cambio quedó estable.

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

Para cambios únicamente documentales:

- Previsualizar el Markdown.
- Verificar enlaces y rutas.
- Confirmar que el contenido coincide con el estado real del repositorio.

---

## 🚫 Cambios No Permitidos

No se aceptarán contribuciones que:

- Trabajen directamente sobre `main`.
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
- Cumple el [Código de Conducta](CODE_OF_CONDUCT.md).
