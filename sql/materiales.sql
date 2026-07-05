-- ============================================================
-- TelecomTrack — Módulo: Materiales y Control de Stock
-- HU-02 (registrar materiales) | HU-03 (entradas) | HU-09 (alertas)
-- ============================================================

CREATE TABLE IF NOT EXISTS categoria (
    id_categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(80)  NOT NULL,
    tipo         VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS proveedor (
    id_proveedor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    contacto     VARCHAR(100),
    correo       VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS material (
    id_material  BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_unico VARCHAR(50)  NOT NULL UNIQUE,
    nombre       VARCHAR(100) NOT NULL,
    unidad_medida VARCHAR(30) NOT NULL,
    stock_actual INT          NOT NULL DEFAULT 0,
    stock_minimo INT          NOT NULL DEFAULT 0,
    id_categoria BIGINT,
    id_proveedor BIGINT,
    CONSTRAINT fk_mat_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
    CONSTRAINT fk_mat_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE IF NOT EXISTS movimiento (
    id_movimiento BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo          VARCHAR(20)  NOT NULL,
    cantidad      INT          NOT NULL,
    fecha         DATETIME     NOT NULL,
    observacion   VARCHAR(255),
    id_material   BIGINT,
    CONSTRAINT fk_mov_material FOREIGN KEY (id_material) REFERENCES material(id_material)
);

-- ── Datos de prueba ───────────────────────────────────────────────────────────

INSERT INTO categoria (nombre, tipo) VALUES
    ('Cableado',       'Material'),
    ('Conectores',     'Material'),
    ('Herramientas',   'Herramienta'),
    ('Equipos activos','Equipo');

INSERT INTO proveedor (nombre, contacto, correo) VALUES
    ('Distribuidora TEC',  'Juan Mora',    'jmora@dtec.cr'),
    ('CableCR S.A.',       'Ana Solís',    'asolis@cablecr.com'),
    ('ElectroInsumos',     'Pedro Rojas',  'projas@electroinsumos.cr');

INSERT INTO material (codigo_unico, nombre, unidad_medida, stock_actual, stock_minimo, id_categoria, id_proveedor) VALUES
    ('CAB-UTP-001', 'Cable UTP Cat6',       'metro',  500, 100, 1, 2),
    ('CON-RJ45-001','Conector RJ-45',       'unidad', 200,  50, 2, 2),
    ('HER-PEL-001', 'Pelacables',           'unidad',  10,   5, 3, 1),
    ('HER-CRI-001', 'Crimpeadora RJ-45',    'unidad',   3,   2, 3, 1),
    ('MAT-CEL-001', 'Cintillo plástico 20cm','bolsa',  30,  10, 1, 3),
    ('EQ-SW-001',   'Switch 8p no manejable','unidad',  2,   1, 4, 3);

INSERT INTO movimiento (tipo, cantidad, fecha, observacion, id_material) VALUES
    ('ENTRADA', 500, NOW(), 'Compra inicial — Orden #2024-001', 1),
    ('ENTRADA', 200, NOW(), 'Compra inicial — Orden #2024-001', 2),
    ('ENTRADA',  10, NOW(), 'Dotación herramientas',            3),
    ('ENTRADA',   3, NOW(), 'Dotación herramientas',            4),
    ('ENTRADA',  30, NOW(), 'Stock inicial',                    5),
    ('ENTRADA',   2, NOW(), 'Compra inicial',                   6);
