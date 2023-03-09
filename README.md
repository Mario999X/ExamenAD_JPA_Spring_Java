# -- ENUNCIADO --

R2D2 crea una BBDD usando JPA + Hibernate (o Spring Data en este caso) y en ella almacena tres entidades:

- Naves: identificador, tipo de nave (X-WIND, T-FIGHTER), fecha de alta, misiles protonicos y salto hiper espacial.
- Piloto: Identificador, nombre, planeta de origen, fecha incorporacion, experiencia.
- Batalla: Identificador, planeta, fecha

Teniendo en cuenta lo anterior, se agregan los siguientes datos:

Una nave solo puede pertenecer a un piloto y un piloto solo puede tener una nave.
En una batalla pueden participar muchos pilotos, y ellos solo podian participar en 1, y como maximo uno de ellos puede
ser capitan

Se pedia:

- Plantear las relaciones entre cada entidad, preparar los modelos con las notaciones respectivas.
- Realizar las operaciones CRUD de la BBDD (repositorios, controlador y main); solo 1 controlador.
- Realizar los test del controlador y repositorios

Tiempo para resolverlo: 4h:30min