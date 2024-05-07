package simulador;

import java.util.*;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.println(" » » » ¡Bienvenidos a PokeMondonGO! « « «");

        System.out.println("   ___      _                               _               ___      \n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___  _ __   __| | ___  _ __   / _ \\___  \n" + //
                        " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\| '_ \\ / _` |/ _ \\| '_ \\ / /_\\/ _ \\ \n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) | | | | (_| | (_) | | | / /_\\\\ (_) |\n" + //
                        "\\/    \\___/|_|\\_\\___\\/    \\/\\___/|_| |_|\\__,_|\\___/|_| |_\\____/\\___/ \n" + //
                        "                                                                     ");

        System.out.println("");                        
       
        System.out.println("       ,___          .-;'                           `;-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.` » » » Selecciona una opción:  `.`\\_...._/`.-\\\"`\n" + //
                        "    ,      \\        /                                   \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\   (1) | Gestionar Entrenadores.   /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()    .  (|                                 |)   .   ()\\   /   _.'`\n" + //
                        "    > .' ;,     -'-  /  (2) | Gestionar Pokémones.      \\  -'-    ,; '.  <\n" + //
                        "   / <   |;,     __.;                                   ;.__     ,;|   >  \\\n" + //
                        "   '-.'-.|  , \\    , \\  (3) | Iniciar Batalla.         / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)                               (_/    (_/ ,;|_.<`\n" + //
                        "       `-;     ,    /   (4) | Salir.                    \\    ,     ;-`\n" + //
                        "          \\    /   <                                     >   \\    /\n" + //
                        "           '. <`'-,_)   » » » Enjoy                     (_,-'`> .'\n" + //
                        "        b&n '._)                                             (_,'  b&n");

        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("Has seleccionado «Gestionar Entrenadores»");


                break;
            case 2:
                System.out.println("Has seleccionado la opción 2");

                break;
            case 3:
                System.out.println("Has seleccionado la opción 3");
                
                break;
            default:
                System.out.println("Salir");
                break;
        }//cierra switch
    }//cierra main
}//cierra class
