package simulador;

import java.util.*;

import simulador.batalla.Batalla;

import simulador.entrenador.Entrenador;

import simulador.persistencia.ArchivosConexion;
import simulador.pokemon.Estado;
import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;

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

    static Scanner sc = new Scanner(System.in);

    static int sg = 4;
    static int option;
    static String busqueda;
    static int menuActual;
    static int entrenadorSeleccionado;
    static int pokemonSeleccionado;
    static int entrenadorBatalla1;
    static int entrenadorBatalla2;
    static Pokemon pokemonBatalla1;
    static Pokemon pokemonBatalla2;
    static Pokemon pokemonDeEntrenamiento;

    static boolean firstMenuGestionarEntrenadores = true;
    static boolean firstSubMenuSeleccionarEntrenadores = true;
    static boolean firstMenuGestionarPokemones = true;
    static boolean firstMenuIniciarBatalla = true;
    static boolean firstSubMenuDuranteLaBatalla = true;
    static boolean verif = true;
    static String nombrePokemonGanador;

    static LinkedList<Pokemon> pokemonesDisponibles = new LinkedList<>();
    static LinkedList<Entrenador> pokeEntrenadores = new LinkedList<>();

    // > > > > > > > > > > > > > > > > > > > > > M A I N < < < < < < < < < < < < < < < < < < < < < //
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        final String Archivo_Pokemones = "ListaDePokemones.pokemondongo";
        final String Archivo_Entrenadores = "ListaDeEntrenadores.pokemondongo";
        
                            // 🚫 N O   D E S C O M E N T A R 🚫 //
        /*/ <> <> <> <> <> <> INICIALIZACIÓN DE DATOS <> <> <> <> <> <> //

        Pokemon Articuno = new Articuno("Articuno", 90, 85, TipoPokemon.HIELO.VOLADOR); //🅿️ TODO:Dos tipos.
        pokemonesDisponibles.add(Articuno);
        Pokemon Caterpie = new Caterpie("Caterpie", 45, 30, TipoPokemon.HIELO.BICHO); //🅿️ TODO:Dos tipos.
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
        Pokemon Tentacool = new Tentacool("Tentacool", 90, 85, TipoPokemon.AGUA.VENENO); //🅿️ TODO:Dos tipos.
        pokemonesDisponibles.add(Tentacool);

        ArchivosConexion.guardar(pokemonesDisponibles, Archivo_Pokemones);
        ArchivosConexion.guardar(pokeEntrenadores, Archivo_Entrenadores);
        
        // <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> */

        // Leer datos guardados //
        pokemonesDisponibles = (LinkedList<Pokemon>)ArchivosConexion.leer(Archivo_Pokemones);
        
        pokeEntrenadores = (LinkedList<Entrenador>)ArchivosConexion.leer(Archivo_Entrenadores); //TODO

        interfazDeCarga(); //✅
        interfazPokeMondonGo(); //✅
        menu1(); //✅

        sc.close(); //cierra Scanner

    }//cierra main







    // > > > > > > > > > > > > > > > > > M E N U S  &  S W I T C H E S < < < < < < < < < < < < < < < < < //



    // [] [] [] [] [] [] [] [] [] [] [] [] MENU 1 [] [] [] [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(1) Tiempo constante
    public static void menu1(){ //✅
        
        wait(sg);
        
        System.out.println("       ,___          .-;'   |  | » » »     MENÚ PRINCIPAL     « « « |  |   ';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`     |  |                                    |  |    `.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /       |  |                                    |  |      \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\       |  |  (1) | Gestionar entrenadores.     |  |      /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|      |  |                                    |  |     |)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       |  |  (2) | Gestionar pokemones.        |  |      \\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       |  |                                    |  |      ;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\      |  |  (3) | Iniciar batalla.            |  |     / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)     |  |                                    |  |    (_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       |  |  (4) | Salir.                      |  |       \\    ,     ;-'\n" + //
                        "          \\    /   <        |  |                                    |  |        >   \\    /\n" + //
                        "           '. <`'-._)       |  |                                    |  |       (_,-'`> .'\n" + //
                        "            '._)            |  | » » »      PokeMondonGo      « « « |  |           (_,'");

        switchMenu1(check());
    }//cierra menu1
   
    // {} {} {} {} {} {} {} {} {} {} {} {} SWITCH MENU 1 {} {} {} {} {} {} {} {} {} {} {} {} //

    //Complejidad temporal: O(1) Tiempo constante
    public static void switchMenu1(int option){ //✅

        switch (option){
            case 1: //✅
                interfazDeCarga();
                menuGestionarEntrenadores(); 
                break;
            case 2: //✅
                interfazDeCarga();
                menuGestionarPokemones();
                break;
            case 3: //✅
                interfazDeCarga();
                menuIniciarBatalla();
                break;
            case 4: //✅
                salir();
                break;
            default: //✅
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opción válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(sg);

                menu1();

                break;
        }//cierra switch

    }//cierra switchMenu1

     // [] [] [] [] [] [] [] [] [] MENU GESTIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void menuGestionarEntrenadores(){ //✅

        while (firstMenuGestionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Gestionar Entrenadores » !");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarEntrenadores = false;
        }//cierra while
        
        wait(sg);
    
        System.out.println("       ,___          .-;'   |  | » » » GESTIONAR ENTRENADORES « « « |  |   ';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`     |  |                                    |  |    `.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /       |  |  (1) | Registrar nuevo entrenador. |  |      \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\       |  |                                    |  |      /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|      |  |  (2) | Ver lista de entrenadores.  |  |     |)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       |  |                                    |  |      \\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       |  |  (3) | Seleccionar un entrenador.  |  |      ;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\      |  |                                    |  |     / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)     |  |  (4) | Volver al menú principal.   |  |    (_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       |  |                                    |  |       \\    ,     ;-'\n" + //
                        "          \\    /   <        |  |  (5) | Salir.                      |  |        >   \\    /\n" + //
                        "           '. <`'-._)       |  |                                    |  |       (_,-'`> .'\n" + //
                        "            '._)            |  | » » »      PokeMondonGo      « « « |  |           (_,'");
        
        switchMenuGestionarEntrenadores(check());
    }//cierra menuGestionarEntrenadores

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR ENTRENADORES {} {} {} {} {} {} {} {} {} //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void switchMenuGestionarEntrenadores(int option){ //✅|

        switch (option){
            case 1: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Registrar nuevo entrenador » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(sg);

                interfazDeCarga();

                wait(sg);
                
                System.out.println("¡Ingrese el nombre del nuevo entrenador!");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                
                sc.nextLine();//Limpia Scanner
                String nombreEntrenador = sc.nextLine();

                Entrenador entrenadorNuevo = new Entrenador(nombreEntrenador, new LinkedList<>());
                pokeEntrenadores.add(entrenadorNuevo);
                //pokeEntrenadores.add(new Entrenador(nombreEntrenador, new LinkedList<>()));

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Creando nuevo entrenador...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println("Registrando en la Liga Pókemon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println(" ☆ ☆ ☆ ¡Entrenador registrado con éxito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                menuGestionarEntrenadores();

                break;

            case 2: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver lista de entrenadores » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(sg);

                interfazDeCarga();

                wait(sg);

                if (pokeEntrenadores.isEmpty()) {

                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                    System.out.println("¡ No hay entrenadores registrados !");
                    System.out.println(" \n \n \n "); //Espacio visual

                    miniMenu(3);

                } else{

                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                    System.out.println(" > > > Lista de Entrenadores < < < ");
                    System.out.println(""); //Espacio visual

                    for (int i = 0; i < pokeEntrenadores.size(); i++) {
                        String pokeNombre = pokeEntrenadores.get(i).getNombre();
                        System.out.println(" > | " + pokeNombre + " |");
                    }//cierra for

                    System.out.println(" \n \n "); //Espacio visual

                    miniMenu(3);

                }//cierra else-if

                menu1();

                break;
            case 3: //✅

                subMenuSeleccionarEntrenadores();

                break;
            case 4: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú principal...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
    
                wait(sg);

                menu1();

                break;
            case 5: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando estadísticas...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                salir();
                
                break;
            default: //✅
                
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opción válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(sg);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarEntrenadores();

                break;
        }//cierra switch

    }//cierra switchMenuGestionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU SELECCIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void subMenuSeleccionarEntrenadores(){ //✅

        entrenadorSeleccionado = 0; //Reset

        while (firstSubMenuSeleccionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Seleccionar Entrenadores » !");     
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstSubMenuSeleccionarEntrenadores = false;
        }//cierra while
            
        wait(sg);

        interfazDeCarga();

        wait(sg);

        if (pokeEntrenadores.isEmpty()) {
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡ No hay entrenadores registrados !");
            System.out.println(" \n \n \n "); //Espacio visual

            miniMenu(3);
        } else{

            System.out.println(" > > > Lista de Entrenadores < < < ");
            System.out.println(""); //Espacio visual

            for (int i = 0; i < pokeEntrenadores.size(); i++) {
                String pokeNombre = pokeEntrenadores.get(i).getNombre();
                System.out.println("(" + (i+1) + ") | " + pokeNombre + " |");
            }//cierra for

            System.out.println(""); //Espacio visual

            System.out.print("Selecciona el entrenador que deseas usar: ");

            entrenadorSeleccionado = check()-1; //Evita que salga de los límites.

        }//cierra else-if

        wait(sg);

        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        System.out.println("¡Has seleccionado al entrenador « " + pokeEntrenadores.get(entrenadorSeleccionado).getNombre() + " » !");     
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual

        wait(sg);
        
        subMenuNombreEntrenador(entrenadorSeleccionado);

    }//cierra subMenuSeleccionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU NOMBRE ENTRENADOR [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(1) Tiempo constante
    public static void subMenuNombreEntrenador(int entrenadorSeleccionado){ //✅

        System.out.println("       ,___          .-;'   |  | » » » OPCIONES DE ENTRENADOR « « « |  |   ';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`     |  |                                    |  |    `.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /       |  |  (1) | Ver equipo de pokemones.    |  |      \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\       |  |                                    |  |      /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|      |  |  (2) | Agregar pokémon al equipo.  |  |     |)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       |  |                                    |  |      \\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       |  |  (3) | Entrenar pokémon.           |  |      ;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\      |  |                                    |  |     / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)     |  |  (4) | Volver al menu anterior.    |  |    (_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       |  |                                    |  |       \\    ,     ;-'\n" + //
                        "          \\    /   <        |  |  (5) | Salir.                      |  |        >   \\    /\n" + //
                        "           '. <`'-._)       |  |                                    |  |       (_,-'`> .'\n" + //
                        "            '._)            |  | » » »      PokeMondonGo      « « « |  |           (_,'");
        
    
        switchNombreEntrenador(check(), entrenadorSeleccionado);
    }//cierra subMenuNombreEntrenador

    // {} {} {} {} {} {} {} {} {} SWITCH NOMBRE ENTRENADOR {} {} {} {} {} {} {} {} {} //

    //Complejidad temporal: O(1) Tiempo constante
    public static void switchNombreEntrenador(int option, int entrenadorSeleccionado){ //✅
        switch (option){ //✅
            case 1: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver equipo de pokemones » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(sg);

                interfazDeCarga();

                wait(sg);

                pokeEntrenadores.get(entrenadorSeleccionado).mostrarPokemones();

                wait(sg);

                miniMenu(5);

                break;

            case 2: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Agregar pokémon al equipo » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(sg);

                interfazDeCarga();

                wait(sg);

                pokeEntrenadores.get(entrenadorSeleccionado).agregarPokemon(pokemonesEquipo6(pokemonSeleccionado));
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Agregando pokémon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println(" ☆ ☆ ☆ ¡Pokémon agregado al equipo con éxito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                subMenuNombreEntrenador(entrenadorSeleccionado);

                break;
            case 3: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Entrenar pokémon » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(sg);

                interfazDeCarga();

                wait(sg);

                if (pokeEntrenadores.get(entrenadorSeleccionado).getPokeLista().isEmpty() !=true) {
                    pokemonDeEntrenamiento = pokeEntrenadores.get(entrenadorSeleccionado).prepararEntrenamiento();
                    pokeEntrenadores.get(entrenadorSeleccionado).entrenarPokemon(pokemonDeEntrenamiento);

                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                    System.out.println("Entrenando pokémon...");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    wait(sg);

                    System.out.println("Creando lazos más fuertes con el entrenador...");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    wait(sg);

                    System.out.println("Perfeccionando movimientos...");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    wait(sg);

                    System.out.println("Aumentando autoestima...");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    wait(sg);

                    System.out.println(" ☆ ☆ ☆ ¡Pokémon entrenado con éxito! ☆ ☆ ☆ ");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    wait(sg);
                } else {
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                    System.out.println("¡ Oh oh, tus pokemones están de vacaciones o no tienes !");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                }//cierra else-if

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                subMenuNombreEntrenador(entrenadorSeleccionado); 

                break;
            case 4: //✅
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú anterior...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
    
                wait(sg);

                menuGestionarEntrenadores();

                break;
            case 5: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando estadísticas...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                salir();
                break;
            default: //✅
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opción válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(sg);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarEntrenadores();
                break;
        }//cierra switch
    }//cierra switchNombreEntrenador

    // [] [] [] [] [] [] [] [] [] POKEMONES EQUIPO 6 [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(N) Tiempo lineal
    public static Pokemon pokemonesEquipo6(int entrenadorSeleccionado){ //✅

        for (int i = 0; i < pokemonesDisponibles.size(); i++) {

            Pokemon p = pokemonesDisponibles.get(i);

            System.out.println("(" + (i+1) + ") | " + p.getNombre() + " | Salud -> " + p.getSalud() + " | Ataque -> " + p.getPuntosDeAtaque() + " | Tipo -> " + p.getTipo() + " |");
        }//cierra for
    
        return switchPokemonesEquipo6(check(), entrenadorSeleccionado);

    }//cierra pokemonesEquipo6

    // {} {} {} {} {} {} {} {} {} SWITCH POKEMONES EQUIPO 6 {} {} {} {} {} {} {} {} {} //

    //Complejidad temporal: O(1) Tiempo constante
    public static Pokemon switchPokemonesEquipo6(int option, int entrenadorSeleccionado){ //✅🅿️
        switch (option) {
            case 1: //🅿️
                //Articuno
                
                Pokemon Articuno = new Articuno("Articuno", 90, 85, TipoPokemon.HIELO.VOLADOR); //🅿️ TODO:Dos tipos.
                
                return Articuno;
            case 2: //🅿️
                //Caterpie

                Pokemon Caterpie = new Caterpie("Caterpie", 45, 30, TipoPokemon.HIELO.BICHO); //🅿️ TODO:Dos tipos.

                return Caterpie;
            case 3: //✅
                //Charmander

                Pokemon Charmander = new Charmander("Charmander", 39, 52, TipoPokemon.FUEGO);

                return Charmander;
            case 4: //✅
                //Diglett
                
                Pokemon Diglett = new Diglett("Diglett", 10, 55, TipoPokemon.TIERRA);

                return Diglett;
            case 5: //✅
                //Drowzee
                
                Pokemon Drowzee = new Drowzee("Drowzee", 60, 48, TipoPokemon.PSIQUICO);

                return Drowzee;
            case 6: //✅
                //Hitmonlee
                
                Pokemon Hitmonlee = new Hitmonlee("Hitmonlee", 50, 120, TipoPokemon.LUCHA);

                return Hitmonlee;
            case 7: //✅
                //Jolteon
                
                Pokemon Jolteon = new Jolteon("Jolteon", 65, 65, TipoPokemon.ELECTRICO);

                return Jolteon;
            case 8: //✅
                //Shellder
                
                Pokemon Shellder = new Shellder("Shellder", 30, 65, TipoPokemon.AGUA);

                return Shellder;
            case 9: //✅
                //Snorlax
                
                Pokemon Snorlax = new Snorlax("Snorlax", 160, 110, TipoPokemon.NORMAL);

                return Snorlax;
            case 10: //🅿️
                //Tentacool
                
                Pokemon Tentacool = new Tentacool("Tentacool", 90, 85, TipoPokemon.AGUA.VENENO); //🅿️ TODO:Dos tipos.

                return Tentacool;
            default: //✅
                System.out.println("No se ha seleccionado un pokemon valido.");
                System.out.print("Ingresa una opción válida: ");
                switchPokemonesEquipo6(check(), entrenadorSeleccionado);
                break;
        }//cierra switch
        return null;
    }//cierra switchPokemonesEquipo6

    // [] [] [] [] [] [] [] [] [] MENU GESTIONAR POKEMONES [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void menuGestionarPokemones(){ //✅
        while (firstMenuGestionarPokemones == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Gestionar Pokémones » !");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarPokemones = false;
        }//cierra while
        
        wait(sg);

        System.out.println("       ,___          .-;'   | » » »  GESTIONAR  POKEMONES  « « « |   ';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`     |                                    |    `.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /       |                                    |      \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\       | (1) | Ver pokemones registrados.   |      /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|      |                                    |     |)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       | (2) | Registrar nuevo pokémon.     |      \\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       |                                    |      ;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\      | (3) | Volver al menú principal.    |     / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)     |                                    |    (_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       | (4) | Salir.                       |       \\    ,     ;-'\n" + //
                        "          \\    /   <        |                                    |        >   \\    /\n" + //
                        "           '. <`'-._)       |                                    |       (_,-'`> .'\n" + //
                        "            '._)            | » » »      PokeMondonGo      « « « |           (_,'");
        
        switchMenuGestionarPokemones(check());
    }//cierra menuGestionarPokemones

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR POKEMONES {} {} {} {} {} {} {} {} {} //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void switchMenuGestionarPokemones(int option){ //✅
        switch (option){
            case 1: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver pokemones registrados » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                for (int i = 0; i < pokemonesDisponibles.size(); i++) {

                    Pokemon p = pokemonesDisponibles.get(i);
    
                    System.out.println("| " + p.getNombre() + " | Salud -> " + p.getSalud() + " | Ataque -> " + p.getPuntosDeAtaque() + " | Tipo -> " + p.getTipo() + " |");
                
                }//cierra for

                miniMenu(6);

                break;
            case 2: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Registrar nuevo pokémon » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(sg);

                interfazDeCarga();

                wait(sg);

                for (int i = 0; i < pokemonesDisponibles.size(); i++) {

                    Pokemon p = pokemonesDisponibles.get(i);
    
                    System.out.println("(" + (i+1) + ") | " + p.getNombre() + " | Salud -> " + p.getSalud() + " | Ataque -> " + p.getPuntosDeAtaque() + " | Tipo -> " + p.getTipo() + " |");
                
                }//cierra for

                System.out.println(""); //Espacio visual
                System.out.println("¡ Elige el pokémon a registrar: ");
                pokemonSeleccionado = check()-1;

                Pokemon pokemonRegistrado = pokemonesDisponibles.get(pokemonSeleccionado);
                pokemonesDisponibles.add(pokemonRegistrado);
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Creando tu pokémon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println("Verificando en la Pokédex...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println(" ☆ ☆ ☆ ¡Pokémon registrado con éxito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                menuGestionarPokemones();

                break;
            case 3: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú principal...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                menu1();

                break;
            case 4: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando estadísticas...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                salir();

                break;
            default: //✅

                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡ Debes seleccionar una opción válida !");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(sg);

                menuGestionarPokemones();

                break;
        }//cierra switch
    }//cierra switchMenuGestionarPokemones
    
    // [] [] [] [] [] [] [] [] [] MENU INICIAR BATALLA [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void menuIniciarBatalla(){ //✅
        while (firstMenuIniciarBatalla == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡ Has seleccionado « Iniciar Batalla » !");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuIniciarBatalla = false;
        }//cierra while
        
        wait(sg);
        
        System.out.println("       ,___          .-;'   |  | » » »    INICIAR  BATALLA    « « « |  |   ';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`     |  |                                    |  |    `.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /       |  |  (1) | Elegir entrenador #1.       |  |      \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\       |  |  (2) | Elegir entrenador #2.       |  |      /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|      |  |  (3) | Seleccionar pokémon         |  |     |)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       |  |           del entrenador#1.        |  |      \\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       |  |  (4) | Seleccionar pokémon         |  |      ;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\      |  |           del entrenador#2.        |  |     / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)     |  |  (5) | Comenzar batalla.           |  |    (_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       |  |  (6) | Volver al menú principal.   |  |       \\    ,     ;-'\n" + //
                        "          \\    /   <        |  |  (7) | Salir.                      |  |        >   \\    /\n" + //
                        "           '. <`'-._)       |  |                                    |  |       (_,-'`> .'\n" + //
                        "            '._)            |  | » » »      PokeMondonGo      « « « |  |           (_,'");
        
        sc.nextLine(); //Limpia Scanner
        switchIniciarBatalla(check());
    }//cierra menuIniciarBatalla

    // {} {} {} {} {} {} {} {} {} SWITCH INICIAR BATALLA {} {} {} {} {} {} {} {} {} //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void switchIniciarBatalla(int option){ //✅
        switch (option){
            case 1: //✅

                wait(sg);

                interfazDeCarga();
        
                wait(sg);

                if (pokeEntrenadores.isEmpty()) {
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                    System.out.println("¡ No hay entrenadores registrados !");
                    System.out.println(" \n \n \n "); //Espacio visual
        
                    miniMenu(7);
                } else{
        
                    System.out.println(" > > > Lista de Entrenadores < < < ");
                    System.out.println(""); //Espacio visual
        
                    for (int i = 0; i < pokeEntrenadores.size(); i++) {
                        String pokeNombre = pokeEntrenadores.get(i).getNombre();
                        System.out.println("(" + (i+1) + ") | " + pokeNombre + " |");
                    }//cierra for
        
                    System.out.println(" \n \n "); //Espacio visual
        
                    System.out.print("Selecciona el entrenador que deseas usar: ");
        
                    entrenadorBatalla1 = check()-1; //Evita que salga de los límites.
        
                }//cierra else-if
        
                wait(sg);
        
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado al entrenador « " + pokeEntrenadores.get(entrenadorBatalla1).getNombre() + " » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú anterior...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                menuIniciarBatalla();

                break;
            case 2: //✅

                wait(sg);

                interfazDeCarga();
        
                wait(sg);

                if (pokeEntrenadores.isEmpty()) {
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                    System.out.println("¡ No hay entrenadores registrados !");
                    System.out.println(" \n \n \n "); //Espacio visual
        
                    miniMenu(3);
                } else{
        
                    System.out.println(" > > > Lista de Entrenadores < < < ");
                    System.out.println(""); //Espacio visual
        
                    for (int i = 0; i < pokeEntrenadores.size(); i++) {
                        String pokeNombre = pokeEntrenadores.get(i).getNombre();
                        System.out.println("(" + (i+1) + ") | " + pokeNombre + " |");
                    }//cierra for
        
                    System.out.println(" \n \n "); //Espacio visual
        
                    System.out.print("Selecciona el entrenador que deseas usar: ");
        
                    entrenadorBatalla2 = check()-1; //Evita que salga de los límites.
        
                }//cierra else-if
        
                wait(sg);
        
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado al entrenador « " + pokeEntrenadores.get(entrenadorBatalla2).getNombre() + " » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú anterior...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                menuIniciarBatalla();
                break;
            case 3: //✅
                
                pokemonBatalla1 = pokeEntrenadores.get(entrenadorBatalla1).prepararBatalla();
                menuIniciarBatalla();

                break;
            case 4: //✅

                pokemonBatalla2 = pokeEntrenadores.get(entrenadorBatalla2).prepararBatalla();
                menuIniciarBatalla();

                break;
            case 5: //✅
                
                if (pokeEntrenadores.get(entrenadorBatalla1).equals(null) || pokeEntrenadores.get(entrenadorBatalla2).equals(null)) {
                    System.out.println("> > > Te falta seleccionar un entrenador.");
                    System.out.println(""); //Espacio visual
                    miniMenu(7);
                    break;
                } else if (pokemonBatalla1.equals(null) || pokemonBatalla2.equals(null)) {
                    System.out.println("> > > Te falta seleccionar un pokémon.");
                    System.out.println(""); //Espacio visual
                    miniMenu(7);
                    break;
                } else {
                    Batalla.iniciarBatalla(pokemonBatalla1, pokemonBatalla2, verif, nombrePokemonGanador);
                }


                break;
            case 6: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú principal...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(sg);

                menu1();

                break;
            case 7: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando estadísticas...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(sg);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                salir();

                break;
            default: //✅
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡ Debes seleccionar una opción válida s!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(sg);

                menuIniciarBatalla();
                
                break;
        }//cierra switch
    }//cierra switchIniciarBatalla

    // [] [] [] [] [] [] [] [] [] SUBMENU DURANTE LA BATALLA [] [] [] [] [] [] [] [] [] //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void subMenuDuranteLaBatalla(String nombrePokemonGanador){ //✅
        while (firstSubMenuDuranteLaBatalla) {
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡ HA INICIADO LA BATALLA !");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstSubMenuDuranteLaBatalla = false;
        }//cierra while

        wait(4);

        if (pokemonBatalla1.getSalud() > 0 && pokemonBatalla2.getSalud() > 0) {
            
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
            wait(3);

            System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
            System.out.println(" \n \n \n "); //Espacio visual
            System.out.println("(1) | "+ pokemonBatalla1.getNombre() + " -> Atacar.");
            System.out.println("(2) | "+ pokemonBatalla2.getNombre() + " -> Atacar.");
            System.out.println("(3) | Finalizar batalla.");


            switchSubMenuDuranteLaBatalla(check(), nombrePokemonGanador);
        } else{
            
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("[ ⭐️ ⭐️ ⭐️ LA BATALLA HA TERMINADO ⭐️ ⭐️ ⭐️ ]");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual

            wait(sg);

            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("Volviendo al menú anterior...");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual

            menu1();

        }//cierra else-if
    }//cierra menuIniciarBatalla

    // {} {} {} {} {} {} {} {} {} SWITCH DURANTE LA BATALLA {} {} {} {} {} {} {} {} {} //

    //Complejidad temporal: O(N) Tiempo lineal
    public static void switchSubMenuDuranteLaBatalla(int option, String nombrePokemonGanador){ //🅿️
        switch (option){
            case 1: //✅

                wait(sg);

                if (pokemonBatalla2.getEstado().equals(Estado.NORMAL)) {

                    System.out.println(" \n \n \n \n "); //Espacio visual
                    System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
                    System.out.println(" \n \n "); //Espacio visual
                    System.out.println( pokemonBatalla1.getNombre() + " Ha atacado a " + pokemonBatalla2.getNombre());
                    System.out.println(" \n \n \n \n "); //Espacio visual

                    wait(sg);

                    System.out.println(" \n \n \n \n "); //Espacio visual
                    System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
                    System.out.println(" \n \n \n"); //Espacio visual
                    System.out.println( " ¡ El ataque ha sido eficaz ! ");
                    System.out.println(" \n \n \n \n "); //Espacio visual

                    pokemonBatalla2.recibirDaño(pokemonBatalla1.atacar(pokemonBatalla2));
                }else{

                    if (pokemonBatalla1.getSalud() <= 0) {
                        nombrePokemonGanador = pokemonBatalla2.getNombre();
                     } else if (pokemonBatalla2.getSalud() <= 0) {
                        nombrePokemonGanador = pokemonBatalla1.getNombre();
                     } else {
                        nombrePokemonGanador = "PEPPA PIG";
                    }//ciera else-if

                    System.out.println(" [ " + nombrePokemonGanador + " ] Ha ganado la batalla! ");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    wait(sg);

                    System.out.println(" [ " + nombrePokemonGanador + " ] Ha ganado la batalla! ");
                    System.out.println(" \n \n "); //Espacio visual

                    
                    System.out.println("           > > > ¿Qué deseas hacer? < < <");
                    System.out.println("(1) | Finalizar batalla.     (2) | Salir de PokeMondonGo.");
                    System.out.println("");
                    System.out.print("Escoge una opción: ");

                    boolean v = true;

                    while (v == true) {
                        check();
                    
                        if (option == 1) {
                            v = false;

                            System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                            System.out.println("Volviendo al menú anterior...");
                            System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                            wait(sg);

                            menuIniciarBatalla();
                        }else if (option == 2) {
                            v = false;
                            salir();
                        }else if (option == 1 && option == 2) {
                            System.out.println("Ingrese una opción válida");
                            v =true;
                        }//cierra else-if

                    }//cierra while

                }//cierra else-if

                subMenuDuranteLaBatalla(nombrePokemonGanador);

                break;
            case 2: //✅

                wait(sg);

                if (pokemonBatalla1.getEstado().equals(Estado.NORMAL)) {

                    System.out.println(" \n \n \n \n "); //Espacio visual
                    System.out.println("[ " + pokemonBatalla2.getNombre() + " ] VS [ " + pokemonBatalla1.getNombre() + " ]");
                    System.out.println(" \n \n "); //Espacio visual
                    System.out.println( pokemonBatalla2.getNombre() + " Ha atacado a " + pokemonBatalla1.getNombre());
                    System.out.println(" \n \n \n \n "); //Espacio visual

                    wait(sg);

                    System.out.println(" \n \n \n \n "); //Espacio visual
                    System.out.println("[ " + pokemonBatalla2.getNombre() + " ] VS [ " + pokemonBatalla1.getNombre() + " ]");
                    System.out.println(" \n \n \n"); //Espacio visual
                    System.out.println( " ¡ El ataque ha sido eficaz ! ");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    pokemonBatalla1.recibirDaño(pokemonBatalla2.atacar(pokemonBatalla1));

                }else{

                    if (pokemonBatalla1.getSalud() <= 0) {
                        nombrePokemonGanador = pokemonBatalla2.getNombre();
                    } else if (pokemonBatalla2.getSalud() <= 0) {
                        nombrePokemonGanador = pokemonBatalla1.getNombre();
                    } else {
                        nombrePokemonGanador = "PEPPA PIG";
                    }//ciera else-if

                    System.out.println(" [ " + nombrePokemonGanador + " ] Ha ganado la batalla! ");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                    wait(sg);

                    System.out.println(" [ " + nombrePokemonGanador + " ] Ha ganado la batalla! ");
                    System.out.println(" \n \n "); //Espacio visual

                    System.out.println("");
                    System.out.println("           > > > ¿Qué deseas hacer? < < <");
                    System.out.println("(1) | Finalizar batalla.     (2) | Salir de PokeMondonGo.");
                    System.out.println("");
                    System.out.print("Escoge una opción: ");

                    boolean v = true;

                    while (v == true) {
                        check();
                    
                        if (option == 1) {
                            v = false;

                            System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                            System.out.println("Volviendo al menú anterior...");
                            System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                            wait(sg);

                            menuIniciarBatalla();
                        }else if (option == 2) {
                            v = false;
                            salir();
                        }else if (option == 1 && option == 2) {
                            System.out.println("Ingrese una opción válida");
                            v =true;
                        }//cierra else-if
                        
                    }//cierra while

                }//cierra else-if

                subMenuDuranteLaBatalla(nombrePokemonGanador);

                break;
            case 3: //✅
                
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("Volviendo al menú anterior...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(sg);

                menuIniciarBatalla();

                break;
            default: //✅
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡ Debes seleccionar una opción válida !");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(sg);

                menuIniciarBatalla();
                
                break;
        }//cierra switch
    }//cierra switchIniciarBatalla

    // [] [] [] [] [] [] [] [] [] SALIR [] [] [] [] [] [] [] [] []//

    //Complejidad temporal: O(1) Tiempo constante
    public static void salir(){ //✅
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual
        System.out.println("» » » Saliendo de PokeMondonGo « « «");
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual

        guardarPartida(pokemonesDisponibles, pokeEntrenadores, "ListaDePokemones.pokemondongo", "ListaDeEntrenadores.pokemondongo");
        
        wait(sg);

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

    public static void wait(int sec){ //✅
        try {
            Thread.sleep(sec * 300);
         } catch (Exception e) {
            System.out.println(e);
         }
    }//cierra wait

    // () () () () () () () () () INTERFAZ DE CARGA () () () () () () () () () //

    public static void interfazDeCarga(){ //✅

        System.out.println(" \n \n \n \n \n "); //Espacio visual
        System.out.println("Cargando...");
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
    }//cierra interfaz de carga 

    // () () () () () () () () () INTERFAZ POKEMONDONGO () () () () () () () () () //

    public static void interfazPokeMondonGo(){ //✅

        wait(sg*2);
        
        System.out.println("» » » Bienvenido(a) a PokeMondonGo « « «");
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual

        wait(sg*2);

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

    }//cierra interfazPokeMondonGo
    
    // () () () () () () () () () VALIDACION () () () () () () () () () //

    //Complejidad temporal: O(N) Tiempo lineal
    public static int check(){ //✅

        option = 0; //Reset de option.

        boolean validation = false; //Reset de validation.

            while (validation == false) {

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

    // () () () () () () () () () MINI MENU () () () () () () () () () //

    //Complejidad temporal: O(1) Tiempo constante
    public static void miniMenu(int actual){ //✅
        System.out.println("");
        System.out.println("                  > > > ¿Qué deseas hacer? < < <");
        System.out.println("(1) | Regresa al menú anterior.     (2) | Salir de PokeMondonGo.");
        System.out.println("");
        System.out.print("Escoge una opción: ");

        int menuOpt = check();
        int menuActual = actual;

        if (menuOpt == 1) {
            menusGlobales(menuActual-1);
        } else if (menuOpt == 2){
            salir();
        } else {
            System.out.println("Ingrese una opción válida");
        }//cierra if

    }//cierra miniMenu
    
    // () () () () () () () () () MENUS GLOBALES () () () () () () () () () //

    //Complejidad temporal: O(1) Tiempo constante
    public static void menusGlobales(int menuOpt){ //🅿️

        switch (menuOpt) {
            case 1: //✅
                interfazDeCarga();
                wait(sg);
                menu1();
                break;
            case 2: //🅿️
                interfazDeCarga();
                wait(sg);
                menuGestionarEntrenadores();
                break;
            case 3: //🅿️
                interfazDeCarga();
                wait(sg);
                subMenuSeleccionarEntrenadores();
                break;
            case 4: //✅
                interfazDeCarga();
                wait(sg);
                subMenuNombreEntrenador(entrenadorSeleccionado);
                break;
            case 5: //🅿️
                interfazDeCarga();
                wait(sg);
                menuGestionarPokemones();
                break;
            case 6: //✅
                interfazDeCarga();
                wait(sg);
                menuIniciarBatalla();
                break;
            case 7: //🅿️
                interfazDeCarga();
                wait(sg);
                subMenuDuranteLaBatalla(nombrePokemonGanador);
                break;
            default:
                break;
        }
    }//cierra menusGlobales
    
    // () () () () () () () () () GUARDAR ARCHIVO () () () () () () () () () //

    public static void guardarPartida(LinkedList<Pokemon> pokemonesDisponibles, LinkedList<Entrenador> pokeEntrenadores, String Archivo_Pokemones, String Archivo_Entrenadores){ //✅

        ArchivosConexion.guardar(pokemonesDisponibles, Archivo_Pokemones);
        ArchivosConexion.guardar(pokeEntrenadores, Archivo_Entrenadores);

    }//cierra guardarPartida

}//cierra class
