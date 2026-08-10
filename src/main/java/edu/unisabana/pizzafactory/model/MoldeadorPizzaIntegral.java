package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MoldeadorPizzaIntegral implements MoldeadorPizza {

    @Override
    public void moldearPizzaPequena() {
        registrar("[O] Moldeando pizza pequena de masa integral.");
    }

    @Override
    public void moldearPizzaMediana() {
        registrar("[O] Moldeando pizza mediana de masa integral.");
    }

    private void registrar(String mensaje) {
        Logger.getLogger(MoldeadorPizzaIntegral.class.getName()).log(Level.INFO, mensaje);
    }
}
