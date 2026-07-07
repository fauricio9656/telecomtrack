USE telecomtrack;

CREATE TABLE IF NOT EXISTS herramienta (
                                           id_herramienta INT AUTO_INCREMENT,
                                           codigo VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    estado VARCHAR(20) NOT NULL DEFAULT 'DISPONIBLE',
    fecha_baja DATE,
    justificacion_baja VARCHAR(255),
    fecha_retorno_estimada DATE,
    PRIMARY KEY (id_herramienta),
    UNIQUE KEY uk_herramienta_codigo (codigo)
    );
