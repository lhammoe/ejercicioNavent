# ejercicioNavent

Sobre los ejercicios:

Desarrollé un proyecto maven con algunas librerías de spring (spring-boot más bien) intentando que todo compile, si bien no 
era el objetivo del ejercicio.

1- Para este ejercicio, asumí que ya están implementadas las transacciones a la base de datos. También, por simplicidad, se 
implementó una capa de servicio y una capa DAO.

3- En este ejercicio, me centré en el html y el js. Está creado el controller al que apunta el ajax pero sólo a modo de darle
un cierre a la solución.
Si se abre el html en algún navegador, asegurarse que el path al js dentro del html sea el correcto. 

2- A continuación la respuesta sobre este ejercicio:
Algunas consideraciones a tener en cuenta para tener una buena performance en las consultas son las siguientes:
	a- Tener índices implementados tanto en los where como joins puede acelerar mucho la respuesta del motor a una consulta.
	b- Tratar de limitar el set de datos que uno consulta. Quizá inicialmente una consulta funcionaba bien, pero 
	cuando la aplicación va creciendo la consulta se hace más lenta y hay que tratar de limitar el set de datos que trae.
	c- Siempre seleccionar las columnas que uno realmente necesita (obviamente, evitar el típico "select *"). 
	En los clientes de base de datos, evitar el acceso a columnas que no son necesarias disminuye el overhead de IO 
	(acceso a disco).
	d- Quitar tablas que uno pueda estar haciendo join y que no impactan en el resultado final de la query. Esto puede mejorar 
	bastante la performance ya que se evita la comparación de todos los registros de una tabla con la otra. 
	e- Evitar outer joins agregando valores en ambas tablas que estoy cruzando. Se estandariza y se evita a que un desarrollador
	tenga que estar haciendo cosas del estilo, "IFNULL()" al hacer una consulta.
	f- Evitar funciones que calculen algún valor en los where y en los joins y reemplazar por un campo que tenga esta valor ya
	calculado (desnormalización).
	g- Respecto a la capa de aplicación, la generación de conexiones a la base de datos tienen un overhead muy alto (apertura 
	de conexión, apertura, utilización y cierre de socket, cierre de conexión). Es por esto que la utilización de Pooles de 
	conexion mejora el acceso a la base de datos ya que permiten reutilizar las conexiones ya creadas entre los usuarios que 
	acceden a la Aplicación.

En el caso de los BLOBS, el motor MySQL almacena en cada registro que tenga un BLOB grande (mas de 1mb) un prefijo que ocupa 
bastantes bytes (800 aprox) que apunta al contenido real del BLOB almacenado "externamente", o sea en otro bloque. Si el BLOB 
no es tan grande, está almacenado en el mismo bloque que los demas datos del registro.
A partir de esto se entiende que cualquier consulta que lea un registro, levanta todo el bloque donde está el registro, con lo
cual por más que el BLOB no sea seleccionado lo va a traer igual (en el caso de BLOB grandes trea el prefijo que como dijimos 
es grande).
Por lo tanto en cualquier caso el manejo de BLOBS es complicado y poco óptimo.
Una solución que mejora la performance es moviendo los BLOBs a tablas separadas de la original.
Cada una de estas tablas tiene el id y el blob. Por lo tanto cada vez que se necesita traer los archivos que correspondan se 
hacen los joins correspondientes contra dichas tablas.
Otra solución es tenerlos directamente en disco y que en la tabla haya una columna con el path en filesystem en donde se 
encuentran.

	
