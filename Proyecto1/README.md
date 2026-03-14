# Sistema de gestión de inventario
Proyecto desarrollado para el laboratorio de **Introducción a la Programación y Computación 1**. Consiste en utilizar java swing para la administración de existencias de ropa.
## Caracteristicas
+ **Gestión de Datos:** Funcionalidades completas para:
    * Registrar nuevos productos.
    * Buscar productos por ID, nombre o categoría.
    * Eliminar productos por ID.
    * Vender productos y que se actualice el stock.
* **Restricción Técnica:** Implementación basada exclusivamente en **arreglos estáticos**, sin el uso de `ArrayList`
## Funcionamiento
Se ejecucutará en NetBeans (no hay arhivo jar creado) en donde luego de ejecutar el codigo, le mostrara al usuario una ventana con varias opciones (cada opción es clara). toda opcione elejida tiene una funcionalidad la mayoria de estas abrirá una nueva ventana.
En las ventanas donde se pueda ingresar datos tambien habrá un recuadro donde se vean los cambios.
## Problemas encontrados
  * El generador del reporte HTML solo generá la un reporte del stock en el inventario no da detalles sobre lo que se vende.
  * Se pueden guardar 2 productos diferentes con el mismo nombre.
  * En la opción  **BUSCAR PRODUCTO** puede llenar los 3 campos y causar errores de tipeo.
  * En la opción **REGISTRAR VENTA** se puede llenar la opcion de Total, Fecha y hora, sin ser necesario.
## Mejoras posibles
  * Se puede usar un metodo diferente para guardar la informacion sobre la venta y luego utilizar dicha información para agregarla al Reporte HTML.
  * Se puede utilzar una combobox en la opción **BUSCAR PRODUCTO** para que no puedan llenar los 3 recuadros de texto.
  * Se puede generar un archivo jar para no tener que abrir el programa de NetBeans.
  * Se puede mejorar la apariencia de las ventanas.
