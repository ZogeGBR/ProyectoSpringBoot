-- =============================================
-- DATOS DE PRUEBA - AeroSystem
-- Se cargan automaticamente al iniciar la app
-- =============================================

-- CIUDADES
INSERT INTO ciudad (id, nombre_ciudad) VALUES (1, 'Buenos Aires');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (2, 'Mendoza');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (3, 'Bariloche');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (4, 'Córdoba');
INSERT INTO ciudad (id, nombre_ciudad) VALUES (5, 'Rosario');

-- AEROPUERTOS
INSERT INTO aeropuerto (id, nombre_aeropuerto, ciudad_id) VALUES (1, 'Aeropuerto Internacional Ezeiza', 1);
INSERT INTO aeropuerto (id, nombre_aeropuerto, ciudad_id) VALUES (2, 'Aeropuerto El Plumerillo',       2);
INSERT INTO aeropuerto (id, nombre_aeropuerto, ciudad_id) VALUES (3, 'Aeropuerto Bariloche',           3);
INSERT INTO aeropuerto (id, nombre_aeropuerto, ciudad_id) VALUES (4, 'Aeropuerto Ambrosio Taravella',  4);
INSERT INTO aeropuerto (id, nombre_aeropuerto, ciudad_id) VALUES (5, 'Aeropuerto Islas Malvinas',      5);

-- AEROLINEAS
INSERT INTO aerolinea (id, nombre_aerolinea) VALUES (1, 'Aerolíneas Argentinas');
INSERT INTO aerolinea (id, nombre_aerolinea) VALUES (2, 'LATAM Argentina');
INSERT INTO aerolinea (id, nombre_aerolinea) VALUES (3, 'Flybondi');

-- AVIONES
INSERT INTO avion (id, numero_avion) VALUES (1, 101);
INSERT INTO avion (id, numero_avion) VALUES (2, 202);
INSERT INTO avion (id, numero_avion) VALUES (3, 303);

-- ASIENTOS (avion 1)
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (1,  1, 'A', 'BUSINESS', 1);
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (2,  1, 'B', 'BUSINESS', 1);
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (3,  5, 'A', 'TURISTA',  1);
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (4,  5, 'B', 'TURISTA',  1);
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (5, 10, 'A', 'ECONOMY',  1);
-- ASIENTOS (avion 2)
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (6,  1, 'A', 'BUSINESS', 2);
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (7,  5, 'A', 'TURISTA',  2);
INSERT INTO asiento (id, fila_asiento, letra_asiento, clase_asiento, avion_id) VALUES (8, 10, 'A', 'ECONOMY',  2);

-- FECHAS
INSERT INTO fecha (id, fecha) VALUES (1, '2026-06-15');
INSERT INTO fecha (id, fecha) VALUES (2, '2026-06-15');
INSERT INTO fecha (id, fecha) VALUES (3, '2026-07-01');
INSERT INTO fecha (id, fecha) VALUES (4, '2026-07-01');
INSERT INTO fecha (id, fecha) VALUES (5, '2026-08-10');
INSERT INTO fecha (id, fecha) VALUES (6, '2026-08-10');

-- PILOTOS (hereda de persona via @MappedSuperclass)
INSERT INTO piloto (id, numero_piloto, dni_persona, nombre_persona, apellido_persona) VALUES (1, 1001, 25000001, 'Carlos',  'Rodríguez');
INSERT INTO piloto (id, numero_piloto, dni_persona, nombre_persona, apellido_persona) VALUES (2, 1002, 25000002, 'Martina', 'López');
INSERT INTO piloto (id, numero_piloto, dni_persona, nombre_persona, apellido_persona) VALUES (3, 1003, 25000003, 'Diego',   'Fernández');

-- VUELOS
INSERT INTO vuelo (id, numero_vuelo, aerolinea_id, avion_id, piloto_id, salida_id, destino_id) VALUES (1, 5401, 1, 1, 1, 1, 2);
INSERT INTO vuelo (id, numero_vuelo, aerolinea_id, avion_id, piloto_id, salida_id, destino_id) VALUES (2, 5402, 1, 2, 2, 3, 4);
INSERT INTO vuelo (id, numero_vuelo, aerolinea_id, avion_id, piloto_id, salida_id, destino_id) VALUES (3, 8801, 2, 3, 3, 5, 6);

-- AEROPUERTOS DE CADA VUELO (tabla intermedia ManyToMany)
INSERT INTO vuelo_aeropuerto (vuelo_id, aeropuerto_id) VALUES (1, 1);
INSERT INTO vuelo_aeropuerto (vuelo_id, aeropuerto_id) VALUES (1, 2);
INSERT INTO vuelo_aeropuerto (vuelo_id, aeropuerto_id) VALUES (2, 1);
INSERT INTO vuelo_aeropuerto (vuelo_id, aeropuerto_id) VALUES (2, 3);
INSERT INTO vuelo_aeropuerto (vuelo_id, aeropuerto_id) VALUES (3, 1);
INSERT INTO vuelo_aeropuerto (vuelo_id, aeropuerto_id) VALUES (3, 4);

-- TARIFAS
INSERT INTO tarifa (id, numero_tarifa, impuesto_tarifa, precio_tarifa, clase_tarifa, vuelo_id) VALUES (1, 1, 500,  45000, 'BUSINESS', 1);
INSERT INTO tarifa (id, numero_tarifa, impuesto_tarifa, precio_tarifa, clase_tarifa, vuelo_id) VALUES (2, 2, 300,  28000, 'TURISTA',  1);
INSERT INTO tarifa (id, numero_tarifa, impuesto_tarifa, precio_tarifa, clase_tarifa, vuelo_id) VALUES (3, 3, 200,  18000, 'ECONOMY',  1);
INSERT INTO tarifa (id, numero_tarifa, impuesto_tarifa, precio_tarifa, clase_tarifa, vuelo_id) VALUES (4, 4, 600,  55000, 'BUSINESS', 2);
INSERT INTO tarifa (id, numero_tarifa, impuesto_tarifa, precio_tarifa, clase_tarifa, vuelo_id) VALUES (5, 5, 350,  32000, 'TURISTA',  2);
INSERT INTO tarifa (id, numero_tarifa, impuesto_tarifa, precio_tarifa, clase_tarifa, vuelo_id) VALUES (6, 6, 250,  22000, 'ECONOMY',  3);

-- USUARIOS (hereda de persona via @MappedSuperclass)
INSERT INTO usuario (id, numero_usuario, dni_persona, nombre_persona, apellido_persona, contrasenia_usuario, correo_electronico_usuario)
  VALUES (1, 101, 35000001, 'Ana',    'García',    'pass123', 'ana.garcia@mail.com');
INSERT INTO usuario (id, numero_usuario, dni_persona, nombre_persona, apellido_persona, contrasenia_usuario, correo_electronico_usuario)
  VALUES (2, 102, 35000002, 'Lucas',  'Martínez',  'pass456', 'lucas.martinez@mail.com');
INSERT INTO usuario (id, numero_usuario, dni_persona, nombre_persona, apellido_persona, contrasenia_usuario, correo_electronico_usuario)
  VALUES (3, 103, 35000003, 'Sofía',  'Pérez',     'pass789', 'sofia.perez@mail.com');

-- PAGOS (tabla base para Tarjeta via herencia JOINED)
INSERT INTO pago (id, numero_pago, cantidad_pago) VALUES (1, 9001, 45000);
INSERT INTO pago (id, numero_pago, cantidad_pago) VALUES (2, 9002, 28000);
INSERT INTO pago (id, numero_pago, cantidad_pago) VALUES (3, 9003, 18000);

-- TARJETAS (hereda de pago, tabla separada por JOINED)
INSERT INTO tarjeta (id, numero_tarjeta, tipo_tarjeta, usuario_id) VALUES (1, 4111111111111111, 'CREDITO', 1);
INSERT INTO tarjeta (id, numero_tarjeta, tipo_tarjeta, usuario_id) VALUES (2, 4222222222222222, 'DEBITO',  2);
INSERT INTO tarjeta (id, numero_tarjeta, tipo_tarjeta, usuario_id) VALUES (3, 4333333333333333, 'CREDITO', 3);

-- RESERVAS
INSERT INTO reserva (id, numero_reserva, vuelo_id, usuario_id, pago_id) VALUES (1, 2001, 1, 1, 1);
INSERT INTO reserva (id, numero_reserva, vuelo_id, usuario_id, pago_id) VALUES (2, 2002, 1, 2, 2);
INSERT INTO reserva (id, numero_reserva, vuelo_id, usuario_id, pago_id) VALUES (3, 2003, 2, 3, 3);

-- CONSULTAS
INSERT INTO consulta (id, numero_consulta, usuario_id) VALUES (1, 3001, 1);
INSERT INTO consulta (id, numero_consulta, usuario_id) VALUES (2, 3002, 2);
INSERT INTO consulta (id, numero_consulta, usuario_id) VALUES (3, 3003, 3);

-- =============================================
-- RESETEAR SECUENCIAS para que los nuevos
-- registros no choquen con los datos de prueba
-- =============================================
ALTER TABLE ciudad      ALTER COLUMN id RESTART WITH 100;
ALTER TABLE aeropuerto  ALTER COLUMN id RESTART WITH 100;
ALTER TABLE aerolinea   ALTER COLUMN id RESTART WITH 100;
ALTER TABLE avion       ALTER COLUMN id RESTART WITH 100;
ALTER TABLE asiento     ALTER COLUMN id RESTART WITH 100;
ALTER TABLE fecha       ALTER COLUMN id RESTART WITH 100;
ALTER TABLE piloto      ALTER COLUMN id RESTART WITH 100;
ALTER TABLE vuelo       ALTER COLUMN id RESTART WITH 100;
ALTER TABLE tarifa      ALTER COLUMN id RESTART WITH 100;
ALTER TABLE usuario     ALTER COLUMN id RESTART WITH 100;
ALTER TABLE pago        ALTER COLUMN id RESTART WITH 100;
ALTER TABLE tarjeta     ALTER COLUMN id RESTART WITH 100;
ALTER TABLE reserva     ALTER COLUMN id RESTART WITH 100;
ALTER TABLE consulta    ALTER COLUMN id RESTART WITH 100;
