package edu.unisabana.pizzafactory.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class FabricaPizzaProvider {

    private static final String ARCHIVO = "pizza.properties";
    private static final String PROPIEDAD = "pizza.factory";

    private FabricaPizzaProvider() {
    }

    public static AFabricaPizza cargarFabrica() {
        String clase = System.getProperty(PROPIEDAD);
        if (clase == null || clase.trim().isEmpty()) {
            clase = cargarPropiedades().getProperty(PROPIEDAD);
        }
        if (clase == null || clase.trim().isEmpty()) {
            throw new IllegalStateException("No se configuro la propiedad " + PROPIEDAD);
        }

        try {
            Object fabrica = Class.forName(clase.trim())
                    .getDeclaredConstructor().newInstance();
            if (!(fabrica instanceof AFabricaPizza)) {
                throw new IllegalStateException(clase + " no implementa AFabricaPizza");
            }
            return (AFabricaPizza) fabrica;
        } catch (ReflectiveOperationException ex) {
            throw new IllegalStateException("No fue posible crear la fabrica " + clase, ex);
        }
    }

    private static Properties cargarPropiedades() {
        Properties propiedades = new Properties();
        try (InputStream entrada = FabricaPizzaProvider.class.getClassLoader()
                .getResourceAsStream(ARCHIVO)) {
            if (entrada == null) {
                throw new IllegalStateException("No se encontro " + ARCHIVO);
            }
            propiedades.load(entrada);
            return propiedades;
        } catch (IOException ex) {
            throw new IllegalStateException("No fue posible leer " + ARCHIVO, ex);
        }
    }
}
