package com.pieroapp.passwordgen.generator;

import com.pieroapp.passwordgen.strategy.PasswordStrategy;

public class PasswordGenerator {
    //guardamos una estrategia concreta que sabra generar contraseñas
    //puede ser solo: letras, letras+numeros, fuertes, debiles, etc..
    private final PasswordStrategy strategy;

    //constructor

    public PasswordGenerator (PasswordStrategy strategy) {
        this.strategy = strategy;
    }

    //metodo publico para generar contraseña
    //el PasswordGenerator no hace el trabajo duro
    //simplemente le da la tarea a la estrategia elegida
    public String generate(int length) {
        return strategy.generate(length);

    }
}