package simulador;

import java.util.*;

import simulador.persistencia.ArchivosConexion;

import simulador.entrenador.Entrenador;

import simulador.pokemon.TipoPokemon;
import simulador.pokemon.Pokemon;

import simulador.pokemones.Articuno;
import simulador.pokemones.Caterpie;
import simulador.pokemones.Charmander;
import simulador.pokemones.Diglett;
import simulador.pokemones.Drowzee;
import simulador.pokemones.Hitmonlee;
import simulador.pokemones.Jolteon;
import simulador.pokemones.Shellder;
import simulador.pokemones.Snorlax;
import simulador.pokemones.Tentacool;



public class Principal {

    // > > > > > > > > > > > > > > > > > > > G L O B A L E S < < < < < < < < < < < < < < < < < < < //

    static int option;
    static String busqueda;
    static int menuActual;
    static Scanner sc = new Scanner(System.in);
    static boolean firstMenuGestionarEntrenadores = true;
    static boolean firstSubMenuSeleccionarEntrenadores = true;
    static boolean firstMenuGestionarPokemones = true;
    static boolean firstMenuIniciarBatalla = true;

    // > > > > > > > > > > > > > > > > > > > > > M A I N < < < < < < < < < < < < < < < < < < < < < //
    public static void main(String[] args) {

        final String NOMBRE_ARCHIVO = "ListaDePokemones.pokemondongo";

        LinkedList<Pokemon> pokemonesDisponibles = new LinkedList<>();
        
                            // 🚫 N O   D E S C O M E N T A R 🚫 //
        /*/ <> <> <> <> <> <> INICIALIZACIÓN DE POKEMONES DISPONIBLES <> <> <> <> <> <> //

        Pokemon Articuno = new Articuno("Articuno", 90, 85, TipoPokemon.HIELO.VOLADOR); //✅
        pokemonesDisponibles.add(Articuno);
        Pokemon Caterpie = new Caterpie("Caterpie", 45, 30, TipoPokemon.HIELO.BICHO); //✅
        pokemonesDisponibles.add(Caterpie);
        Pokemon Charmander = new Charmander("Charmander", 39, 52, TipoPokemon.FUEGO); //✅
        pokemonesDisponibles.add(Charmander);
        Pokemon Diglett = new Diglett("Diglett", 10, 55, TipoPokemon.TIERRA); //✅
        pokemonesDisponibles.add(Diglett);
        Pokemon Drowzee = new Drowzee("Drowzee", 60, 48, TipoPokemon.PSIQUICO); //✅
        pokemonesDisponibles.add(Drowzee);
        Pokemon Hitmonlee = new Hitmonlee("Hitmonlee", 50, 120, TipoPokemon.LUCHA); //✅
        pokemonesDisponibles.add(Hitmonlee);
        Pokemon Jolteon = new Jolteon("Jolteon", 65, 65, TipoPokemon.ELECTRICO); //✅
        pokemonesDisponibles.add(Jolteon);
        Pokemon Shellder = new Shellder("Shellder", 30, 65, TipoPokemon.AGUA); //✅
        pokemonesDisponibles.add(Shellder);
        Pokemon Snorlax = new Snorlax("Snorlax", 160, 110, TipoPokemon.NORMAL); //✅
        pokemonesDisponibles.add(Snorlax);
        Pokemon Tentacool = new Tentacool("Tentacool", 90, 85, TipoPokemon.AGUA.VENENO); //✅
        pokemonesDisponibles.add(Tentacool);

        ArchivosConexion.guardar(pokemonesDisponibles, NOMBRE_ARCHIVO);

        // <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> */

        pokemonesDisponibles = (LinkedList<Pokemon>)ArchivosConexion.leer(NOMBRE_ARCHIVO);
        
        /*/
        System.out.println("Los pokemones guardados son:");

        for (int i = 0; i < pokemonesDisponibles.size(); i++) {

            Pokemon p = pokemonesDisponibles.get(i);

            System.out.println(p.getNombre() + " - Salud: " + p.getSalud() + " - Ataque: " + p.getPuntosDeAtaque() + " - Daño: " + p.getTipo() + " - Estado: " + p.getEstado());
        }//cierra for */

        interfazDeCarga();
        interfazPokeMondonGo();
        switchMenu1(option);

        sc.close(); //cierra Scanner

    }//cierra main










    // > > > > > > > > > > > > > > > > > M E N U S  &  S W I T C H E S < < < < < < < < < < < < < < < < < //



    // [] [] [] [] [] [] [] [] [] [] [] [] MENU 1 [] [] [] [] [] [] [] [] [] [] [] [] //
    
    public static int menu1(){ //✅
        
        wait(3);
        
        System.out.println("       ,___          .-;'                                    `;-.          ___,\n" + //
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
    
    public static void switchMenu1(int option){ //✅

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
                salir();
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

    public static void menuGestionarEntrenadores(){ //✅

        while (firstMenuGestionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado «Gestionar Entrenadores»!");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarEntrenadores = false;
        }//cierra while
        
    
        wait(5);
    
        System.out.println("       ,___          .-;'                                    `;-.          ___,\n" + //
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

    public static void switchMenuGestionarEntrenadores(int option){ //🅿️

        switch (option){
            case 1: //🅿️
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado «Registrar nuevo entrenador»!");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);
                
                System.out.println("¡Ingrese el nombre del nuevo entrenador!");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                sc.nextLine(); //TODO: @Brian preguntarle al profe sobre este reset del Scanner.
                String nombre = sc.nextLine();

                //TODO: @Mario aquí entra el nombre del entrenador, aquí se crea la lista de entrenadores?

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

            case 2: //🅿️

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado «Ver lista de entrenadores»!");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                //TODO: @Mario aquí va el método de la lista de entrenadores.

                miniMenu(check());
                
                break;
            case 3: //✅

                subMenuSeleccionarEntrenadores();

                break;
            case 4: //✅
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú principal...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
    
                wait(5);

                switchMenu1(menu1());
                break;
            case 5: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando estadísticas...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(5);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                salir();
                break;
            default: //✅
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
    
    public static void subMenuSeleccionarEntrenadores(){ //🅿️
        while (firstSubMenuSeleccionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado «Seleccionar Entrenadores»!");     
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstSubMenuSeleccionarEntrenadores = false;
        }//cierra while
            
        wait(5);

        interfazDeCarga();

        wait(4);

        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        System.out.println("Ingrese el nombre del entrenador que desea usar a continuación:");
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual

        wait(4);
        
        //TODO: @Brian Aquí va la lista de entrenadores de la linea 191.

        busquedaEntrenador(busquedaLimpia());

    }//cierra subMenuSeleccionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU NOMBRE ENTRENADOR [] [] [] [] [] [] [] [] [] //

    public static void subMenuNombreEntrenador(){ //✅

        System.out.println("       ,___          .-;'                                    `;-.          ___,\n" + //
                "       `\"-.`\\_...._/`.`   » » » Seleccione una opción: « « «   `.`\\_...._/`.-\"`\n" + //
                "    ,      \\        /                                            \\        /      ,\n" + //
                " .-' ',    / ()   ()\\      (1) | Ver equipo de pokemones.        /()   () \\    .' `-.\n" + //
                "`'._   \\  /()    .  (|                                          |)   .   ()\\   /   _.'`\n" + //
                "    > .' ;,     -'-  /     (2) | Agregar pokémon al equipo.      \\  -'-    ,; '.  <\n" + //
                "   / <   |;,     __.;                                            ;.__     ,;|   >  \\\n" + //
                "   '-.'-.|  , \\    , \\     (3) | Entrenar pokémon.              / ,    / ,  |.-'.-'\n" + //
                "      `>.|;, \\_)    \\_)                                        (_/    (_/ ,;|_.<`\n" + //
                "       `-;     ,    /      (4) | Volver al menu anterior.        \\    ,     ;-`\n" + //
                "          \\    /   <                                              >   \\    /\n" + //
                "           '. <`'-,_)      (5) | Salir.                          (_,-'`> .'\n" + //
                "            '._)                                                       (_,'");
    
        switchNombreEntrenador(check());
    }//cierra subMenuNombreEntrenador

    // {} {} {} {} {} {} {} {} {} SWITCH NOMBRE ENTRENADOR {} {} {} {} {} {} {} {} {} //

    public static void switchNombreEntrenador(int option){ //🔆
        switch (option){
            case 1: //🅿️
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado «Ver equipo de pokemones»!");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                //TODO: @Brian mostrar lista de pokemones del entrenador

                wait(5);

                miniMenu(check());

                break;

            case 2: //🅿️

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado «Agregar pokémon al equipo»!");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                pokemonesEquipo6();
                //TODO: @Brian poner lista de pokemones disponibles

                System.out.println("Digite (1) para regresar al menú anterior.");
                System.out.println("Digite (2) para salir de PokeMondonGo.");

                check(); //TODO: @Brian revisar si es necesario este cuando Mario ponga la linea 191.

                if (check() == 1) {
                    menuGestionarEntrenadores();
                } else if (check() == 2){
                    salir();
                }//cierra if

                break;
            case 3: //🅿️

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado «Entrenar pokémon»!");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                //TODO: @Brian agregar pokémon a la lista de pokemones del entrenador

                break;
            case 4: //✅
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú anterior...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
    
                wait(5);

                menuGestionarEntrenadores();
                break;
            case 5: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando estadísticas...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(5);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                salir();
                break;
            default: //✅
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opción válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarEntrenadores();
                break;
        }//cierra switch
    }//cierra nombreEntrenador

    // [] [] [] [] [] [] [] [] [] MENU POKEMONES EQUIPO 6 [] [] [] [] [] [] [] [] [] //

    public static void pokemonesEquipo6(){ //🅿️
        System.out.println("       ,___          .-;'                                    `;-.          ___,\n" + //
                "       `\"-.`\\_...._/`.`   » » » Seleccione nuevo pokémon:   « « «   `.`\\_...._/`.-\"`\n" + //
                "    ,      \\        /                                            \\        /      ,\n" + //
                " .-' ',    / ()   ()\\      (1) | Charmander. (2) | Shellder.     /()   () \\    .' `-.\n" + //
                "`'._   \\  /()    .  (|                                          |)   .   ()\\   /   _.'`\n" + //
                "    > .' ;,     -'-  /     (3) | Caterpie. (4) | Jolteon.        \\  -'-    ,; '.  <\n" + //
                "   / <   |;,     __.;                                            ;.__     ,;|   >  \\\n" + //
                "   '-.'-.|  , \\    , \\     (5) | Drowzee. (6) | Diglett.        / ,    / ,  |.-'.-'\n" + //
                "      `>.|;, \\_)    \\_)                                        (_/    (_/ ,;|_.<`\n" + //
                "       `-;     ,    /      (7) | Articuno. (8) | Snorlax.        \\    ,     ;-`\n" + //
                "          \\    /   <                                              >   \\    /\n" + //
                "           '. <`'-,_)      (9) | Hitmonlee. (10) | Tentacool.      (_,-'`> .'\n" + //
                "            '._)             (0) | Volver al menú anterior.             (_,'");
    
        switchPokemonesEquipo6(check());
    }//cierra pokemonesEquipo6

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR POKEMONES {} {} {} {} {} {} {} {} {} //

    public static void switchPokemonesEquipo6(int option){
        //TODO: @Brian revisar lista de pokemones disponibles.
    }//cierra switchMenuGestionarPokemones

    // [] [] [] [] [] [] [] [] [] MENU GESTIONAR POKEMONES [] [] [] [] [] [] [] [] [] //

    public static void menuGestionarPokemones(){ //🔆
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

    // [] [] [] [] [] [] [] [] [] SALIR [] [] [] [] [] [] [] [] []//

    public static void salir(){
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual
        System.out.println("» » » Saliendo de PokeMondonGo « « «");
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual

        wait(5);

        System.out.print("🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨\n" + //
                        "🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨\n" + //
                        "🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨\n" + //
                        "🟨⬛⬜🟨🟨🟨🟨🟨⬛⬜🟨  ██████  ██ ██   ██  █████      ██████  ██ ██   ██  █████  \n" + //
                        "🟨⬛⬛🟨🟨🟨🟨🟨⬛⬛🟨  ██   ██ ██ ██  ██  ██   ██     ██   ██ ██ ██  ██  ██   ██ \n" + //
                        "🟨⬛⬛🟨🟨⬛🟨🟨⬛⬛🟨  ██████  ██ █████   ███████     ██████  ██ █████   ███████\n" + //
                        "🟥🟨🟨🟨🟨🟨🟨🟨🟨🟨🟥  ██      ██ ██  ██  ██   ██     ██      ██ ██  ██  ██   ██ \n" + //
                        "🟥🟥🟨🟨🟨⬛🟨🟨🟨🟥🟥  ██      ██ ██   ██ ██   ██     ██      ██ ██   ██ ██   ██ \n" + //
                        "🟥🟥🟨🟨⬛🟨⬛🟨🟨🟥🟥\n" + //
                        "🟥🟨🟨🟨🟨🟨🟨🟨🟨🟨🟥\n" + //
                        "🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨\n" + //
                        " \n \n \n");

        System.exit(0); //kill program
    }//cierra salir
   









    // > > > > > > > > > > > > > > > > > > H E R R A M I E N T A S < < < < < < < < < < < < < < < < < < //



    // () () () () () () () () () TIEMPO DE ESPERA () () () () () () () () () //

    public static void wait(int sec){
        try { //TODO: Preguntarle al profe si se puede quitar.
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

    // () () () () () () () () () BUSQUEDA ENTRENADOR () () () () () () () () () //

    public static void busquedaEntrenador(String busqueda){ //🅿️
        
        busquedaLimpia();

        for (Entrenador entrenador : listaDeEntrenadores) {
            //TODO:@Brian poner el nombre de la lista de entrenadores
            if (entrenador.getNombre().equals(busqueda)) {

                subMenuNombreEntrenador();

            } else {

                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opción válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);    

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                
                subMenuSeleccionarEntrenadores();

                break;
            }//cierra if
        }//cierra foreach
    }//cierra busquedaEntrenador

    // () () () () () () () () () BUSQUEDA LIMPIA () () () () () () () () () //

    public static String busquedaLimpia(){ //✅
        
        busqueda = " "; //Reset de busqueda

        busqueda = sc.nextLine();

        busqueda.toLowerCase();//pEdRo => pedro
        busqueda.toUpperCase().charAt(0); //pedro => Pedro

        return busqueda;
    }//cierra busquedaLimpia

    // () () () () () () () () () MINI MENU () () () () () () () () () //

    public static int miniMenu(int option){
        System.out.println("Digite (1) para regresar al menú anterior.");
        System.out.println("Digite (2) para salir de PokeMondonGo.");

        check(); //TODO: @Brian revisar si es necesario este cuando Mario ponga la linea 191.

        boolean validation = true;

        while (validation == true){
            if (check() == 1) {
                menuAnterior();
            } else if (check() == 2){
                salir();
            } else {
                System.out.println("Ingrese una opción válida");
            }//cierra if
        }//cierra while
    }//cierra miniMenu
    
    // () () () () () () () () () MENU ANTERIOR () () () () () () () () () //

    public static void menuAnterior(){ //🔆
        menuActual -= 1; //TODO: @Brian Borrar pq cada menú tiene su numero

        switch (menuActual) {
            case 1:
                menu1();
                break;
            case 2:
                menuGestionarEntrenadores();
                break;
            case 3:
                
                break;
            case 4:
                menuIniciarBatalla();
                break;
            case 5:
                menu1();
                break;
            case 6:
                menuGestionarEntrenadores();
                break;
            case 7:
                menuGestionarPokemones();
                break;
            case 8:
                menuIniciarBatalla();
                break;
            case 9:
                menu1();
                break;
            case 10:
                menuGestionarEntrenadores();
                break;
            case 11:
                menuGestionarPokemones();
                break;
            case 12:
                menuIniciarBatalla();
                break;
            default:
                break;
        }
    }//cierra menuAnterior
    
    // () () () () () () () () () GUARDAR ARCHIVO () () () () () () () () () //

    public static void guardarPartida(LinkedList<Pokemon> pokemonesDisponibles, String NOMBRE_ARCHIVO){ //✅

        ArchivosConexion.guardar(pokemonesDisponibles, NOMBRE_ARCHIVO);

    }//cierra guardarPartida

}//cierra class
