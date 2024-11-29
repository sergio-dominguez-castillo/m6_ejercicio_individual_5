### App Noticias
Si estás leyendo esto es porque la conexión con tu ViewModel está recibiendo datos correctamente... o eso espero.

1. Crea una primera vista que muestre la lista de noticias disponibles.
- Es importante que en un comienzo solo carguen 5 noticias, las demás comenzarán a cargar a medida que se requiera visualizarlas, es decir, cuando se haga scroll hasta ellas.

2. Crea una Card que contenga la información de cada noticia. El diseño es de libre elección, pero si se deben distribuir en ella los siguientes elementos:
- name
- author
- title
- urlToImage: Se debe visualizar como imagen, no como la url que está llegando desde la API.

3. Configura las rutas de navegación, marcando la lista de noticias como la vista principal de la aplicación.

4. Genera una segunda vista que se abrirá al momento de dar clic sobre una de las noticias.
- La forma en que se ejecute este proceso es de tu elección: por ejemplo, puede ser un botón de “Ver más”, un icono o que la Card por completo sea un elemento clickable.

5. La segunda viste debe tener un diseño en el que se visualice la totalidad de datos del model (Excepto id).

6. No olvides tener una TopBar que permita navegar de vuelta a la vista principal.

7. Una vez los cambios estén listos, actualiza tu repositorio de GitHub y sube el enlace a la plataforma por medio de un archivo .txt