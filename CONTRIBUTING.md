# Acuerdo de Trabajo — TelecomTrack

## 🌿 Estrategia de ramas (Git Flow simplificado)

| Rama | Propósito | Quién escribe |
|------|-----------|---------------|
| `main` | Código estable, entregable. Solo se actualiza via PR aprobado | Nadie directamente |
| `develop` | Rama de integración. Las features se fusionan aquí primero | Todo el equipo |
| `feature/<hu-id>-<descripcion>` | Una historia de usuario o tarea | El responsable |
| `fix/<descripcion>` | Corrección de bug | El que lo detecta |
| `release/avance-<n>` | Preparación de un avance para entrega | Líder técnico |

### Ejemplos de nombres de rama
```
feature/hu-01-catalogo-herramientas
feature/hu-04-solicitud-materiales
fix/validacion-stock-negativo
release/avance-1
```

---

## ✍️ Convenciones de commits

Usamos **Conventional Commits** (https://www.conventionalcommits.org/):

```
<tipo>(<alcance>): <descripción corta en minúsculas>
```

| Tipo | Cuándo usarlo |
|------|--------------|
| `feat` | Nueva funcionalidad |
| `fix` | Corrección de bug |
| `docs` | Solo documentación |
| `style` | Formato, sin cambio lógico |
| `refactor` | Refactorización sin nueva feature ni fix |
| `test` | Agregar o corregir tests |
| `chore` | Tareas de build, dependencias |

### Ejemplos
```bash
feat(inventario): agregar registro de herramienta con código único
fix(solicitud): corregir validación de cantidad al aprobar
docs(readme): actualizar instrucciones de instalación
```

---

## 🔄 Flujo de trabajo

```
1. Tomar una HU del backlog
2. git checkout develop && git pull
3. git checkout -b feature/hu-XX-descripcion
4. Desarrollar + commits frecuentes
5. git push origin feature/hu-XX-descripcion
6. Abrir Pull Request hacia develop
7. Mínimo 1 revisión aprobada antes de fusionar
8. Eliminar la rama feature tras el merge
```

---

## ✅ Checklist antes de abrir un Pull Request

- [ ] El código compila sin errores
- [ ] No hay credenciales ni contraseñas hardcodeadas
- [ ] Los nombres de clases, métodos y variables están en inglés o español consistente
- [ ] Se actualizó la documentación si aplica
- [ ] Se probó manualmente el flujo principal

---

## 🚫 Reglas

- **No hacer push directo a `main`** — siempre PR
- **No commitear archivos de IDE** (.idea/, nbproject/, *.iml) — están en .gitignore
- **No commitear credenciales** — usar variables de entorno o archivo local no versionado
- **Resolver conflictos en la rama feature**, no en develop

---

## 📞 Coordinación

- Reuniones: según acuerdo del equipo (mínimo 1 por semana)
- Issues de GitHub para registrar bugs y tareas
- PR description debe referenciar la HU: `Cierra HU-04`
