package com.pieroapp.passwordgen.strategy;
import com.pieroapp.passwordgen.util.RandomUtil;

//esta clase implenta la estrategia que usa todos los caracteres posibles
//implementa la interfaz PasswrodStrategy, por lo que debe tener el metodo generate().


public class AllCharsStrategy implements PasswordStrategy {

    //POOL = conjunto de caracteres permitidos para forma la contraseña
    //letras mayusc, letras minusc, numeros y caracteres especiales
    private static final String POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ " + "abcdefghijklmnopqrstuvwxyz " + "0123456789" + "!@#$%^&*()-_=+[]{}|;:,.<>?";

    @Override
    public String generate(int length) {

        //usamos el StringBuilder porque es mas eficiente al construir strings en bucle
        StringBuilder sb = new StringBuilder(length);

        //repetimos tantas veces como longitud se pida
        for(int i = 0; i < length;i++) {

            //Elegimos un indice aleatorio dentro del POOL.
            int idx = RandomUtil.nextInt(POOL.length());

            //Agregamos el caracter aleatorio al Stringbuilder
            sb.append(POOL.charAt(idx));
        }

        //convertimos el stringbuilder a string (contraseña final)
        return sb.toString();
    }
}
