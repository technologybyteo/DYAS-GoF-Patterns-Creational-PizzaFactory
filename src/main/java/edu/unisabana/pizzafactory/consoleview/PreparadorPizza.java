
package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.model.AFabricaPizza;
import edu.unisabana.pizzafactory.model.AmasadorPizza;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.FabricaPizzaProvider;
import edu.unisabana.pizzafactory.model.HorneadorPizza;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.MoldeadorPizza;
import edu.unisabana.pizzafactory.model.Tamano;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {

    private final AFabricaPizza fabrica;

    public PreparadorPizza() {
        this(FabricaPizzaProvider.cargarFabrica());
    }

    public PreparadorPizza(AFabricaPizza fabrica) {
        if (fabrica == null) {
            throw new IllegalArgumentException("La fabrica de pizza no puede ser nula");
        }
        this.fabrica = fabrica;
    }

    public static void main(String args[]){
        try {
            Ingrediente[] ingredientes=new Ingrediente[]{new Ingrediente("queso",1),new Ingrediente("jamon",2)};            
            PreparadorPizza pp=new PreparadorPizza();            
            pp.prepararPizza(ingredientes, Tamano.MEDIANO);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparacion de la Pizza", ex);
        }
                
    }
    
    
    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam)
            throws ExcepcionParametrosInvalidos {
        AmasadorPizza am = fabrica.crearAmasador();
        HorneadorPizza hp = fabrica.crearHorneador();
        MoldeadorPizza mp = fabrica.crearMoldeador();
        am.amasar();
        if (tam == Tamano.PEQUENO) {
            mp.moldearPizzaPequena();
        } else if (tam == Tamano.MEDIANO) {
            mp.moldearPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
        }
	aplicarIngredientes(ingredientes);
        hp.hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
        
        
    }


}
