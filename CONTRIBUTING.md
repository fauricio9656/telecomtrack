# Acuerdo de Trabajo — TelecomTrack

## Estrategia de ramas

| Rama | Proposito | Quien escribe |
|------|-----------|---------------|
| `main` | Codigo estable y entregable. Solo se actualiza via Pull Request aprobado | Nadie directamente |
| `develop` | Rama de integracion. Todas las features se fusionan aqui primero | Todo el equipo |
| `feature/<hu-id>-<descripcion>` | Desarrollo de una historia de usuario especifica | El responsable |
| `fix/<descripcion>` | Correccion de errores | El que lo detecta |
| `release/avance-<n>` | Preparacion de entrega de avance | Lider tecnico |

### Ejemplos de nombres de rama

```
feature/hu-01-catalogo-herramientas
feature/hu-04-solicitud-materiales
fix/validacion-stock-negativo
release/avance-1
```

---

## Convenciones de commits

Se utiliza la especificacion Conventional Commits (https://www.conventionalcommits.org/):

```
<tipo>(<alcance>): <descripcion corta en minusculas>
```

| Tipo | Cuando usarlo |
|------|--------------|
| `feat` | Nueva funcionalidad |
| `fix` | Correccion de bug |
| `docs` | Solo documentacion |
| `style` | Formato, sin cambio logico |
| `refactor` | Refactorizacion sin nueva feature ni fix |
| `test` | Agregar o corregir tests |
| `chore` | Tareas de build o dependencias |

### Ejemplos

```
feat(inventario): agregar registro de herramienta con codigo unico
fix(solicitud): corregir validacion de cantidad al aprobar
docs(readme): actualizar instrucciones de instalacion
```

---

## Flujo de trabajo

```
1. Tomar una historia de usuario del backlog
2. git checkout develop && git pull
3. git checkout -b feature/hu-XX-descripcion
4. Desarrollar con commits frecuentes y descriptivos
5. git push origin feature/hu-XX-descripcion
6. Abrir Pull Request hacia develop en GitHub
7. Minimo 1 revision aprobada antes de fusionar
8. Eliminar la rama feature tras el merge
```

---

## Checklist antes de abrir un Pull Request

- [ ] El codigo compila sin errores
- [ ] No hay credenciales ni contrasenas en el codigo
- [ ] Los nombres de clases y metodos son consistentes
- [ ] Se actualizo la documentacion si aplica
- [ ] Se probo manualmente el flujo principal

---

## Reglas del equipo

- No hacer push directo a main — siempre mediante Pull Request
- No subir archivos de IDE (.idea/, nbproject/, *.iml) — incluidos en .gitignore
- No subir credenciales — usar archivo local no versionado
- Resolver conflictos en la rama feature, no en develop
- Las Pull Requests deben referenciar la historia: Cierra HU-04

---

## Coordinacion

- Usar Issues de GitHub para registrar tareas y bugs
- Revision semanal del estado del proyecto
