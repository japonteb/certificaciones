SELECT e.id, c.nombre, c.detalle, e.fecha_presentacion, e.precio_total 
FROM examen e 
INNER JOIN certificacion c 
ON 
c.id = e.certificacion_id 
WHERE
e.cliente_id = :clienteId;