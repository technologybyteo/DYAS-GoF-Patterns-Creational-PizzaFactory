# Diagrama de clases — Fábrica Abstracta

```mermaid
classDiagram
    class PreparadorPizza
    class AFabricaPizza {
        <<interface>>
        +crearAmasador() AmasadorPizza
        +crearHorneador() HorneadorPizza
        +crearMoldeador() MoldeadorPizza
    }
    class AmasadorPizza {
        <<interface>>
        +amasar()
    }
    class HorneadorPizza {
        <<interface>>
        +hornear()
    }
    class MoldeadorPizza {
        <<interface>>
        +moldearPizzaPequena()
        +moldearPizzaMediana()
    }
    class FabricaPizzaDelgada
    class FabricaPizzaGruesa
    class FabricaPizzaIntegral

    PreparadorPizza --> AFabricaPizza
    AFabricaPizza --> AmasadorPizza
    AFabricaPizza --> HorneadorPizza
    AFabricaPizza --> MoldeadorPizza
    FabricaPizzaDelgada ..|> AFabricaPizza
    FabricaPizzaGruesa ..|> AFabricaPizza
    FabricaPizzaIntegral ..|> AFabricaPizza
```

Cada fábrica concreta produce una familia compatible de amasador, moldeador y
horneador. `FabricaPizzaProvider` selecciona la fábrica configurada sin que el
cliente dependa de una implementación concreta.
