USE telecomtrack;

INSERT INTO herramienta (
    codigo,
    nombre,
    descripcion,
    estado
) VALUES
      (
          'HER-001',
          'Taladro percutor',
          'Taladro percutor inalámbrico de 18V.',
          'DISPONIBLE'
      ),
      (
          'HER-002',
          'Multímetro digital',
          'Multímetro para medición de voltaje y continuidad.',
          'DISPONIBLE'
      );

INSERT INTO herramienta (
    codigo,
    nombre,
    descripcion,
    estado,
    fecha_retorno_estimada
) VALUES
      (
          'HER-003',
          'Escalera telescópica',
          'Escalera de aluminio de 4 metros.',
          'MANTENIMIENTO',
          '2026-07-20'
      );

INSERT INTO herramienta (
    codigo,
    nombre,
    descripcion,
    estado,
    fecha_baja,
    justificacion_baja
) VALUES
      (
          'HER-004',
          'Pinza amperimétrica',
          'Pinza para medición de corriente alterna y directa.',
          'BAJA',
          '2026-06-15',
          'Daño irreparable en la carcasa y el sensor de medición.'
      );
