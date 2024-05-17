package simulador;

import java.util.*;

import simulador.entrenador.Entrenador;

public class Principal {

    // > > > > > > > > > > > > > > > > > > > G L O B A L E S < < < < < < < < < < < < < < < < < < < //

    static int option;
    static Scanner sc = new Scanner(System.in);
    static boolean firstMenuGestionarEntrenadores = true;
    static boolean firstSubMenuSeleccionarEntrenadores = true;
    static boolean firstMenuGestionarPokemones = true;
    static boolean firstMenuIniciarBatalla = true;

    // > > > > > > > > > > > > > > > > > > > > > M A I N < < < < < < < < < < < < < < < < < < < < < //
    public static void main(String[] args) {
        
        interfazDeCarga();
        interfazPokeMondonGo();
        switchMenu1(option);

        sc.close(); //cierra Scanner

    }//cierra main










    // > > > > > > > > > > > > > > > > > M E N U S  &  S W I T C H E S < < < < < < < < < < < < < < < < < //



    // [] [] [] [] [] [] [] [] [] [] [] [] MENU 1 [] [] [] [] [] [] [] [] [] [] [] [] //
    
    public static int menu1(){
        wait(3);
            //TODO: Quitar Nico y Bri de todos los menus.
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

        return check();
    }//cierra menu1
   
    // {} {} {} {} {} {} {} {} {} {} {} {} SWITCH MENU 1 {} {} {} {} {} {} {} {} {} {} {} {} //
    
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

    }//cierra switchMenu1

     // [] [] [] [] [] [] [] [] [] MENU GESTIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //

    public static void menuGestionarEntrenadores(){

        while (firstMenuGestionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado «Gestionar Entrenadores»!");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarEntrenadores = false;
        }//cierra while
        
    
        wait(5);
    
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
                "           '. <`'-,_)      (5) | Salir.                          (_,-'`> .'\n" + //
                "            '._)                                                       (_,'");
                    
        switchMenuGestionarEntrenadores(check());
    }//cierra menuGestionarEntrenadores

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR ENTRENADORES {} {} {} {} {} {} {} {} {} //

    public static void switchMenuGestionarEntrenadores(int option){

        switch (option){
            case 1:
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado «Registrar nuevo entrenador»!");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);
                
                System.out.println("¡Ingrese el nombre del nuevo entrenador!");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                sc.nextLine(); //reset del Scanner si no falla xd
                String nombre = sc.nextLine();

                nuevoEntrenador(nombre);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Creando nuevo entrenador...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Registrando en la Liga Pókemon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println(" ☆ ☆ ☆ ¡Entrenador registrado con éxito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(4);

                menuGestionarEntrenadores();

                break;

            case 2:

                //TODO: Mostrar lista de entrenadores y retornar al menu anterior.
                break;
            case 3:

                subMenuSeleccionarEntrenadores(); //TODO: La lista de entrenadores debe ir dentro de este método.

                //TODO: Mostrar lista de entrenadores crear otro submenú.
                break;
            case 4:
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú principal...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
    
                wait(5);

                switchMenu1(menu1());
                break;
            case 5:

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando estadísticas...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(5);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                //TODO: snorlax y kill programa .
                break;
            default:
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opción válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarEntrenadores();
                break;
        }//cierra switch

    }//cierra switchMenuGestionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU SELECCIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //
    
    public static void subMenuSeleccionarEntrenadores(){
        while (firstSubMenuSeleccionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado «Seleccionar Entrenadores»!");     
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstSubMenuSeleccionarEntrenadores = false;
        }//cierra while
            
        wait(5);

        //TODO: Aquí va la lista de entrenadores.

        interfazDeCarga();

        //TODO: PIKACHUS.

        switchMenuGestionarPokemones(check());
    }//cierra subMenuSeleccionarEntrenadores

    // {} {} {} {} {} {} {} {} {} SWITCH SELECCIONAR ENTRENADORES {} {} {} {} {} {} {} {} {} //

    public static void switchSubMenuSeleccionarEntrenadores(int option){
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

                subMenuSeleccionarEntrenadores();
                break;
        }//cierra switch
    }//cierra switchSubMenuSeleccionarEntrenadores

    // [] [] [] [] [] [] [] [] [] MENU GESTIONAR POKEMONES [] [] [] [] [] [] [] [] [] //

    public static void menuGestionarPokemones(){
        while (firstMenuGestionarPokemones == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado «Gestionar Pokémones»!");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarPokemones = false;
        }//cierra while
        
        wait(5);

        //TODO: PIKACHUS.
        
        switchMenuGestionarPokemones(check());
    }//cierra menuGestionarPokemones

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR POKEMONES {} {} {} {} {} {} {} {} {} //

    public static void switchMenuGestionarPokemones(int option){
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

                menuGestionarPokemones();
                break;
        }//cierra switch
    }//cierra switchMenuGestionarPokemones
    
    // [] [] [] [] [] [] [] [] [] MENU INICIAR BATALLA [] [] [] [] [] [] [] [] [] //

    public static void menuIniciarBatalla(){
        while (firstMenuIniciarBatalla == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado «Iniciar Batalla»!");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuIniciarBatalla = false;
        }//cierra while
        
        wait(5);

        //TODO: PIKACHUS.
        
        switchIniciarBatalla(check());
    }//cierra menuIniciarBatalla

    // {} {} {} {} {} {} {} {} {} SWITCH INICIAR BATALLA {} {} {} {} {} {} {} {} {} //
    
    public static void switchIniciarBatalla(int option){
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

                menuIniciarBatalla();
                break;
        }//cierra switch
    }//cierra switchIniciarBatalla

    // [] [] [] [] [] [] [] [] [] MENU 1 SALIDA [] [] [] [] [] [] [] [] []//

    public static void menu1Salida(){
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual
        System.out.println("» » » Saliendo de PokeMondonGo « « «");
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual
    
        //TODO: Sería cool añadir un Snorlax aquí de despedida.
    }//cierra menu1Salida
   









    // > > > > > > > > > > > > > > > > > > H E R R A M I E N T A S < < < < < < < < < < < < < < < < < < //



    // () () () () () () () () () TIEMPO DE ESPERA () () () () () () () () () //

    public static void wait(int sec){
        try {
            Thread.sleep(sec * 300);
         } catch (Exception e) {
            System.out.println(e);
         }
    }//cierra wait

    // () () () () () () () () () INTERFAZ DE CARGA () () () () () () () () () //

    public static void interfazDeCarga(){

        System.out.println(" \n \n \n \n \n "); //Espacio visual
        System.out.println("Cargando...");
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
    }//cierra interfaz de carga 

    // () () () () () () () () () INTERFAZ POKEMONDONGO () () () () () () () () () //

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

        System.out.println(" \n \n \n \n "); //Espacio visual

        menu1();

    }//cierra interfazPokeMondonGo
    
    // () () () () () () () () () VALIDACION () () () () () () () () () //
    
    public static int check(){

        option = 0; //Reset de option.

        boolean validation = false; //Reset de validation.

            while (validation == false) {
                
                sc.nextLine();//Reset Scanner //TODO: Preguntarle al profe como solucionar esto.

                if (sc.hasNextInt()) { //Verificar que sea un entero.
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

    // () () () () () () () () () NUEVO ENTRENADOR () () () () () () () () () //

    public static void nuevoEntrenador(String nombre){
        
        Entrenador entrenador = new Entrenador(nombre, null);

        entrenador.setNombre(nombre);

    }//cierra nuevoEntrenador

}//cierra class
