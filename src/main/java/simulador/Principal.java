package simulador;

import java.util.*;

public class Principal {

    //#//#//#//#//#//#//#//#//#//#//#// GLOBALES //#//#//#//#//#//#//#//#//#//#//#//

    static int option;
    static Scanner sc = new Scanner(System.in);

    //#//#//#//#//#//#//#//#//#//#//#// MAIN //#//#//#//#//#//#//#//#//#//#//#//
    public static void main(String[] args) {
        
        interfazDeCarga();
        interfazPokeMondonGo();
        switchMenu1(option);

        sc.close(); //cierra Scanner

    }//cierra main

    //#//#//#//#//#//#//#//#//#//#//#// TIEMPO DE ESPERA //#//#//#//#//#//#//#//#//#//#//#//

    public static void wait(int sec){
        try {
            Thread.sleep(sec * 300);
         } catch (Exception e) {
            System.out.println(e);
         }
    }//cierra wait
    
    //#//#//#//#//#//#//#//#//#//#//#// INTERFAZ DE CARGA //#//#//#//#//#//#//#//#//#//#//#//
    
    public static void interfazDeCarga(){

    System.out.println(" \n \n \n \n \n "); //Espacio visual

    System.out.println("Cargando...");

    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
    }//cierra interfaz de carga

    //#//#//#//#//#//#//#//#//#//#//#// INTERFAZ POKEMONDONGO //#//#//#//#//#//#//#//#//#//#//#//

    public static void interfazPokeMondonGo(){

        wait(6);
        
        System.out.println("» » » Bienvenido(a) a PokeMondonGo « « «");

        System.out.println(" \n \n \n \n \n \n"); //Espacio visual

        wait(6);

        System.out.println(" \n \n \n \n "); //Espacio visual //P

        System.out.println("   ___      \n" + //
                            "  / _ \\\n" + //
                            " / /_)/\n" + //
                            "/ ___/\n" + //
                            "\\/\n" + //
                            "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //PO
        
        wait(1);

        System.out.println("   ___      \n" + //
                        "  / _ \\___ \n" + //
                            " / /_)/ _ \\\n" + //
                            "/ ___/ (_) |\n" + //
                        "\\/    \\___/\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POK

        wait(1);

        System.out.println("   ___      _\n" + //
                            "  / _ \\___ | | __\n" + //
                            " / /_)/ _ \\| |/ /\n" + //
                            "/ ___/ (_) |   <\n" + //
                            "\\/    \\___/|_|\\_\\\n" + //
                            "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKE

        wait(1);

        System.out.println("   ___      _\n" + //
                        "  / _ \\___ | | _____  \n" + //
                        " / /_)/ _ \\| |/ / _ \\\n" + //
                            "/ ___/ (_) |   <  __/\n" + //
                        "\\/    \\___/|_|\\_\\___\\\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEM

        wait(1);

        System.out.println("   ___      _\n" + //
                        "  / _ \\___ | | _____  /\\/\\\n" + //
                        " / /_)/ _ \\| |/ / _ \\/    \\\n" + //
                            "/ ___/ (_) |   <  __/ /\\/\\ \\\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMO

        wait(1);

        System.out.println("   ___      _\n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___\n" + //
                        " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\\n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) |\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\\___/\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMON

        wait(1);

        System.out.println("   ___      _\n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___  _ __\n" + //
                        " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\| '_ \\\n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) | | | |\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\\___/|_| |_|\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMOND

        wait(1);

        System.out.println("   ___      _                               _\n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___  _ __   __| |\n" + //
                        " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\| '_ \\ / _` |\n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) | | | | (_| |\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\\___/|_| |_|\\__,_|\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMONDO

        wait(1);

        System.out.println("   ___      _                               _\n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___  _ __   __| | ___\n" + //
                        " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\| '_ \\ / _` |/ _ \\\n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) | | | | (_| | (_) |\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\\___/|_| |_|\\__,_|\\___/\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMONDON

        wait(1);

        System.out.println("   ___      _                               _               \n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___  _ __   __| | ___  _ __\n" + //
                        " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\| '_ \\ / _` |/ _ \\| '_ \\\n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) | | | | (_| | (_) | | | |\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\\___/|_| |_|\\__,_|\\___/|_| |_|\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMONDONG

        wait(1);

        System.out.println("   ___      _                               _               ___\n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___  _ __   __| | ___  _ __   / _ \\\n" + //
                    " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\| '_ \\ / _` |/ _ \\| '_ \\ / /_\\\n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) | | | | (_| | (_) | | | / /_\\\\\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\\___/|_| |_|\\__,_|\\___/|_| |_\\____/\n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMONDONGO

        wait(1);
        
        System.out.println("   ___      _                               _               ___      \n" + //
                        "  / _ \\___ | | _____  /\\/\\   ___  _ __   __| | ___  _ __   / _ \\___  \n" + //
                    " / /_)/ _ \\| |/ / _ \\/    \\ / _ \\| '_ \\ / _` |/ _ \\| '_ \\ / /_\\/ _ \\ \n" + //
                        "/ ___/ (_) |   <  __/ /\\/\\ \\ (_) | | | | (_| | (_) | | | / /_\\\\ (_) |\n" + //
                    "\\/    \\___/|_|\\_\\___\\/    \\/\\___/|_| |_|\\__,_|\\___/|_| |_\\____/\\___/ \n" + //
                        "                                                                     ");

        System.out.println(" \n \n \n \n "); //Espacio visual //POKEMONDONGO FINAL

        menu1();

    }//cierra interfazPokeMondonGo
    
    //#//#//#//#//#//#//#//#//#//#//#// VALIDACION //#//#//#//#//#//#//#//#//#//#//#//
    
    public static int check(){

        boolean validation = false;

            while (validation == false) {
                
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                    validation = true;
                } else {
                    System.out.println("» » » Por favor ingresa un número entero válido. « « «");
                    sc.next(); // Descarta la entrada del scanner
                    sc.nextLine();
                    validation = false;
                }//cierra if else

            }//cierra while

        return option;
    }//cierra check

    //#//#//#//#//#//#//#//#//#//#//#// [] MENU 1 [] //#//#//#//#//#//#//#//#//#//#//#//
    
    public static int menu1(){
        wait(3);
        
            System.out.println("[Nico] ,___          .-;'                                    `;-.          ___, [Bri]\n" + //
                            "       `\"-.`\\_...._/`.`   » » » Seleccione una opción: « « «   `.`\\_...._/`.-\"`\n" + //
                            "    ,      \\        /                                            \\        /      ,\n" + //
                            " .-' ',    / ()   ()\\      (1) | Gestionar Entrenadores.         /()   () \\    .' `-.\n" + //
                            "`'._   \\  /()   .   (|                                          |)   .   ()\\   /   _.'`\n" + //
                            "    > .' ;,    -'-  /      (2) | Gestionar Pokémones.            \\  -'-    ,; '.  <\n" + //
                            "   / <   |;,     __.;                                            ;.__     ,;|   >  \\\n" + //
                            "   '-.'-.|  , \\    , \\     (3) | Iniciar Batalla.               / ,    / ,  |.-'.-'\n" + //
                            "      `>.|;, \\_)    \\_)                                        (_/    (_/ ,;|_.<`\n" + //
                            "       `-;     ,    /      (4) | Salir.                          \\    ,     ;-`\n" + //
                            "          \\    /   <                                              >   \\    /\n" + //
                            "           '. <`'-,_)     » » »      PokeMondonGo      « « «      (_,-'`> .'\n" + //
                            "            '._)                                                       (_,'");

            check();
            return option;
    }//cierra menu1
   
    //#//#//#//#//#//#//#//#//#//#//#// {} SWITCH MENU 1 {} //#//#//#//#//#//#//#//#//#//#//#//
    
    public static void switchMenu1(int option){

        switch (option){
            case 1:
                menuGestionarEntrenadores(); 
                break;
            case 2:
                menuGestionarPokemones();
                break;
            case 3:
                menuIniciarBatalla();
                break;
            case 4:
                menu1Salida();
                break;
            default:
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                
                System.out.println("¡Debe seleccionar una opción válida!");

                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);

                System.out.println("Reiniciando...");

                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                interfazPokeMondonGo();
                break;
        }//cierra switch

    }//cierra switchCase1

     //#//#//#//#//#//#//#//#//#//#//#// [] MENU GESTIONAR ENTRENADORES [] //#//#//#//#//#//#//#//#//#//#//#//

    public static int menuGestionarEntrenadores(){
        System.out.println(" \n \n \n \n \n "); //Espacio visual
    
        System.out.println("¡Has seleccionado «Gestionar Entrenadores»!");
                    
        System.out.println(" \n \n \n \n \n "); //Espacio visual
    
        wait(3);
    
        System.out.println("[Nico] ,___          .-;'                                    `;-.          ___, [Bri]\n" + //
                "       `\"-.`\\_...._/`.`   » » » Seleccione una opción: « « «   `.`\\_...._/`.-\"`\n" + //
                "    ,      \\        /                                            \\        /      ,\n" + //
                " .-' ',    / ()   ()\\      (1) | Registrar nuevo entrenador.     /()   () \\    .' `-.\n" + //
                "`'._   \\  /()    .  (|                                          |)   .   ()\\   /   _.'`\n" + //
                "    > .' ;,     -'-  /     (2) | Ver lista de entrenadores.      \\  -'-    ,; '.  <\n" + //
                "   / <   |;,     __.;                                            ;.__     ,;|   >  \\\n" + //
                "   '-.'-.|  , \\    , \\     (3) | Seleccionar un entrenador.     / ,    / ,  |.-'.-'\n" + //
                "      `>.|;, \\_)    \\_)                                        (_/    (_/ ,;|_.<`\n" + //
                "       `-;     ,    /      (4) | Volver al menú principal.       \\    ,     ;-`\n" + //
                "          \\    /   <                                              >   \\    /\n" + //
                "           '. <`'-,_)     » » »      PokéMondonGo      « « «      (_,-'`> .'\n" + //
                "            '._)                                                       (_,'");
                    
        check();
        return option;
    }//cierra menuGestionarEntrenadores

    //#//#//#//#//#//#//#//#//#//#//#// {} SWITCH GESTIONAR ENTRENADORES {} //#//#//#//#//#//#//#//#//#//#//#//

    public static void switchMenuGestionarEntrenadores(){

        switch (option){
            case 1:
                
                break;
            case 2:

                break;
            case 3:
                
                break;
            case 4:
                
                break;
            default:
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                
                System.out.println("¡Debe seleccionar una opción válida!");

                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);

                System.out.println("Reiniciando...");

                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                interfazPokeMondonGo();
                break;
        }//cierra switch

    }//cierra switchMenuGestionarEntrenadores

    //#//#//#//#//#//#//#//#//#//#//#// [] MENU GESTIONAR POKEMONES [] //#//#//#//#//#//#//#//#//#//#//#//

    public static void menuGestionarPokemones(){
        System.out.println("¡Has seleccionado «Gestionar Pokémones»!");
    }//cierra menuGestionarPokemones

    //#//#//#//#//#//#//#//#//#//#//#// {} SWITCH GESTIONAR POKEMONES {} //#//#//#//#//#//#//#//#//#//#//#//
    
    //#//#//#//#//#//#//#//#//#//#//#// [] MENU INICIAR BATALLA [] //#//#//#//#//#//#//#//#//#//#//#//

    public static void menuIniciarBatalla(){
        System.out.println("¡Has seleccionado «Iniciar Batalla»!");
    }//cierra menuIniciarBatalla

    //#//#//#//#//#//#//#//#//#//#//#// {} SWITCH INICIAR BATALLA {} //#//#//#//#//#//#//#//#//#//#//#//
    
    //#//#//#//#//#//#//#//#//#//#//#// [] MENU 1 SALIDA [] //#//#//#//#//#//#//#//#//#//#//#//

    public static void menu1Salida(){
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                    System.out.println("» » » Saliendo de PokeMondonGo « « «");
                    System.out.println(" \n \n \n \n \n \n "); //Espacio visual
    
                    // Sería cool añadir un Snorlax aquí de despedida.
    }//cierra menu1Salida
   
}//cierra class
