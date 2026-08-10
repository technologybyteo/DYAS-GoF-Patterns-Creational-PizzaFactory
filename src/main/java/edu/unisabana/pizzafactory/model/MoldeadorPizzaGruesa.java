package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MoldeadorPizzaGruesa implements MoldeadorPizza {

    @Override
    public void moldearPizzaPequena() {
        registrar("[O] Moldeando pizza pequena de masa gruesa.");
    }

    @Override
    public void moldearPizzaMediana() {
        registrar("[O] Moldeando pizza mediana de masa gruesa.");
    }

    private void registrar(String mensaje) {
        Logger.getLogger(MoldeadorPizzaGruesa.class.getName()).log(Level.INFO, mensaje);
    }
}
