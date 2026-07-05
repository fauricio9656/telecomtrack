USE telecomtrack;

CREATE TABLE IF NOT EXISTS ubicacion (
                                         id_ubicacion INT AUTO_INCREMENT,
                                         nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    responsable VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_ubicacion)
    );