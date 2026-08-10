
package edu.unisabana.pizzafactory.model;

/**
 * Fabrica abstracta de una familia compatible de componentes para pizza.
 */
public interface AFabricaPizza {

    AmasadorPizza crearAmasador();

    HorneadorPizza crearHorneador();

    MoldeadorPizza crearMoldeador();
}
