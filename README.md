# Universidad de La Sabana
## Diseño y Arquitectura de Software

**Mateo Ramírez Cabrera**

## Parte I — Fábrica Abstracta de pizzas

Refactoring del preparador de pizzas para desacoplar la secuencia de preparación
de los componentes concretos de cada máquina, aplicando el patrón Fábrica
Abstracta y el principio de Inversión de Dependencias.

## Diseño

`PreparadorPizza` conserva la secuencia estable del proceso: amasar, moldear,
aplicar ingredientes y hornear. Los componentes variables se obtienen mediante
`AFabricaPizza`, por lo que el preparador nunca referencia amasadores,
moldeadores u horneadores concretos.

Los productos abstractos son:

- `AmasadorPizza`
- `MoldeadorPizza`
- `HorneadorPizza`

Las familias concretas implementadas son:

- Pizza delgada: `FabricaPizzaDelgada`
- Pizza gruesa: `FabricaPizzaGruesa`
- Pizza integral: `FabricaPizzaIntegral`

El [diagrama de clases](docs/abstract-factory.md) presenta el modelo completo.

## Configuración

La familia activa se selecciona en `src/main/resources/pizza.properties`:

```properties
pizza.factory=edu.unisabana.pizzafactory.model.FabricaPizzaIntegral
```

También puede utilizarse:

```properties
pizza.factory=edu.unisabana.pizzafactory.model.FabricaPizzaDelgada
pizza.factory=edu.unisabana.pizzafactory.model.FabricaPizzaGruesa
```

Debe dejarse activa una sola propiedad. Cambiar la variante no requiere
modificar `PreparadorPizza`.

## Compilación y ejecución

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="edu.unisabana.pizzafactory.consoleview.PreparadorPizza"
```

Una variante puede probarse sin editar el archivo:

```bash
mvn exec:java \
  -Dexec.mainClass="edu.unisabana.pizzafactory.consoleview.PreparadorPizza" \
  -Dpizza.factory=edu.unisabana.pizzafactory.model.FabricaPizzaGruesa
```

Para agregar otra variante se crean sus tres productos concretos y una nueva
fábrica concreta. La lógica de `PreparadorPizza` permanece sin cambios.
