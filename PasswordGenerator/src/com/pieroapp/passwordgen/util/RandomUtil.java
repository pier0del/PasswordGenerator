package com.pieroapp.passwordgen.util;
import java.security.SecureRandom;

// utilidad para generar numeros de forma aleatoria de forma segura
// se usa en la generacion de contraseñas

public class RandomUtil {
    //objeto SecureRandom es  un generador de numeros aleatorios
    //CRIPTOGRAFICAMENTE seguroo
    //Mucho mejor que java.util.Random
    private static final SecureRandom RANDOM = new SecureRandom();

    //metodo estatic que devuelve un numero aleatorio entre 0 (incluido)
    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

}
