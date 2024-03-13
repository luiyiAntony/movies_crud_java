BASE DE DATOS
TABLAS:

- peliculas (id, nombre, anio, estrellas, categoria_id, director_id)
- categorias (id, nombre_categoria, clasificacion (VARCHAR))
  clasification by audience:
  G => General Audience
  PG => Parental Guidance Suggested
  PG-13 => Parents Strongly Cautioned
  R => Restricted, restricted to audience to 17 and older
  NC-17 => No One 17 and Under Admitted
- directores (id, nombre, pais_origen, oscar TINYINT(1))

METODOS:
PERMITIDO
buscar por categoria

NO PERMITIDO
eliminar una pelicula

### BACKEND
- list directors
- list categories
- list movies
