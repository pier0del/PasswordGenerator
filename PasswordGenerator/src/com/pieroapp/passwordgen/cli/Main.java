package com.pieroapp.passwordgen.cli;
import java.util.Scanner;
import com.pieroapp.passwordgen.strategy.*;
import com.pieroapp.passwordgen.generator.PasswordGenerator;
//importamos las configuraciones


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("introduzca el tipo de contraseña que quieres generar: ");
        System.out.println("Opciones: LETTERS, NUMBERS, SPECIALS, LETTERS_NUMBERS, NUMBERS_SPECIALS, ALL");
        System.out.println("tipo: ");
        String type = sc.nextLine().toUpperCase();

        //preguntamos x la longitud
        System.out.print("introduza la longitud de la contraseña: ");

        int length;
        try{
            length = Integer.parseInt(sc.nextLine());

        } catch (NumberFormatException e) {

            //si  no es un numero valido, avisamos al usuario
            System.err.println("la longitud debe ser un numero entero");
            sc.close();
            return;
        }

        //vamos a decidir cual estrategia usar segun el tipo
        PasswordStrategy strategy;

        //Elegimos la estrategia correspondiente usando switch
        switch (type) {
            case "LETTERS":
                strategy = new LetterStrategy();
                break;
            case "NUMBERS":
                strategy = new NumbersStrategy();
                break;
            case "SPECIALS":
                strategy = new SpecialCharStrategy();
                break;
            case "LETTERS_NUMBERS":
                strategy = new LetterNumberStrategy();
                break;
            case "NUMBERS_SPECIALS":
                strategy = new NumbersSpecialStrategy();
                break;
            case "ALL":
                strategy = new AllCharsStrategy();
                break;
            default:
                //si el usuario escribe un tipo que no existe
                System.err.println("Tipo desconocido: " + type);
                sc.close();
                return;
        }
        //creamos un PasswordGenerator usando la estrategia elegida
        PasswordGenerator generator = new PasswordGenerator(strategy);

        //Generamos la contraseña con la longitud indicada x el usuario
        String password = generator.generate(length);

        //imprimimos por pantalla el resultado final.
        System.out.println("contraseña generada : " + password);
        sc.close();

    }
}
