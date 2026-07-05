USE telecomtrack;

INSERT INTO usuario (
    nombre,
    apellido,
    correo,
    rol,
    activo
) VALUES
      (
          'Ana',
          'Rodríguez',
          'ana.rodriguez@telecomtrack.com',
          'Administrador',
          TRUE
      ),
      (
          'Carlos',
          'Mora',
          'carlos.mora@telecomtrack.com',
          'Bodeguero',
          TRUE
      ),
      (
          'Luis',
          'Vargas',
          'luis.vargas@telecomtrack.com',
          'Técnico',
          TRUE
      ),
      (
          'María',
          'Fernández',
          'maria.fernandez@telecomtrack.com',
          'Supervisor',
          TRUE
      ),
      (
          'José',
          'Castro',
          'jose.castro@telecomtrack.com',
          'Técnico',
          FALSE
      );