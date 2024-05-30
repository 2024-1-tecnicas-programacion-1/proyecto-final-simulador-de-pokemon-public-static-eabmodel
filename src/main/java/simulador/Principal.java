package simulador;

import java.util.*;

import simulador.batalla.Batalla;

import simulador.entrenador.Entrenador;

import simulador.persistencia.ArchivosConexion;

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

    static int option;
    static String busqueda;
    static int menuActual;
    static int entrenadorSeleccionado;
    static int pokemonSeleccionado;
    static int entrenadorBatalla1;
    static int entrenadorBatalla2;
    static Pokemon pokemonBatalla1;
    static Pokemon pokemonBatalla2;

    static boolean firstMenuGestionarEntrenadores = true;
    static boolean firstSubMenuSeleccionarEntrenadores = true;
    static boolean firstMenuGestionarPokemones = true;
    static boolean firstMenuIniciarBatalla = true;
    static boolean verif = true;
    static String nombrePokemonGanador;

    static LinkedList<Pokemon> pokemonesDisponibles = new LinkedList<>();
    static LinkedList<Entrenador> pokeEntrenadores = new LinkedList<>();

    // > > > > > > > > > > > > > > > > > > > > > M A I N < < < < < < < < < < < < < < < < < < < < < //
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        final String NOMBRE_ARCHIVO = "ListaDePokemones.pokemondongo";
        
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

        ArchivosConexion.guardar(pokemonesDisponibles, NOMBRE_ARCHIVO);

        // <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> <> */

        // Leer datos guardados //
        pokemonesDisponibles = (LinkedList<Pokemon>)ArchivosConexion.leer(NOMBRE_ARCHIVO);

        interfazDeCarga(); //✅
        interfazPokeMondonGo(); //✅
        menu1(); //✅

        sc.close(); //cierra Scanner

    }//cierra main










    // > > > > > > > > > > > > > > > > > M E N U S  &  S W I T C H E S < < < < < < < < < < < < < < < < < //



    // [] [] [] [] [] [] [] [] [] [] [] [] MENU 1 [] [] [] [] [] [] [] [] [] [] [] [] //
    
    public static void menu1(){ //✅
        
        wait(3);
        
        System.out.println("       ,___          .-;'|    |  | » » »     MENÚ PRINCIPAL     « « « |  | |';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`   |   |  |                                    |  |  |`.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /      |  |  |                                    |  |   | \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\      |  |  |  (1) | Gestionar entrenadores.     |  |   | /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|     |  |  |                                    |  |   ||)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       | |  |  (2) | Gestionar pokemones.        |  |    |\\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       | |  |                                    |  |    |;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\    |   |  |  (3) | Iniciar batalla.            |  |  | / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)   |   |  |                                    |  |  |(_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       | |  |  (4) | Salir.                      |  |    | \\    ,     ;-'\n" + //
                        "          \\    /   <       |  |  |                                    |  |   |   >   \\    /\n" + //
                        "           '. <`'-._)       | |  |                                    |  |    | (_,-'`> .'\n" + //
                        "            '._)            | |  | » » »      PokeMondonGo      « « « |  |    |     (_,'");

        switchMenu1(check());
    }//cierra menu1
   
    // {} {} {} {} {} {} {} {} {} {} {} {} SWITCH MENU 1 {} {} {} {} {} {} {} {} {} {} {} {} //
    
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

                wait(4);

                menu1();

                break;
        }//cierra switch

    }//cierra switchMenu1

     // [] [] [] [] [] [] [] [] [] MENU GESTIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //

    public static void menuGestionarEntrenadores(){ //✅

        while (firstMenuGestionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Gestionar Entrenadores » !");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarEntrenadores = false;
        }//cierra while
        
        wait(5);
    
        System.out.println("       ,___          .-;'|    |  | » » » GESTIONAR ENTRENADORES « « « |  | |';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`   |   |  |                                    |  |  |`.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /      |  |  |  (1) | Registrar nuevo entrenador. |  |   | \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\      |  |  |                                    |  |   | /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|     |  |  |  (2) | Ver lista de entrenadores.  |  |   ||)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       | |  |                                    |  |    |\\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       | |  |  (3) | Seleccionar un entrenador.  |  |    |;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\    |   |  |                                    |  |  | / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)   |   |  |  (4) | Volver al menú principal.   |  |  |(_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       | |  |                                    |  |    | \\    ,     ;-'\n" + //
                        "          \\    /   <       |  |  |  (5) | Salir.                      |  |   |   >   \\    /\n" + //
                        "           '. <`'-._)       | |  |                                    |  |    | (_,-'`> .'\n" + //
                        "            '._)            | |  | » » »      PokeMondonGo      « « « |  |    |     (_,'");
        
        switchMenuGestionarEntrenadores(check());
    }//cierra menuGestionarEntrenadores

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR ENTRENADORES {} {} {} {} {} {} {} {} {} //

    public static void switchMenuGestionarEntrenadores(int option){ //✅

        switch (option){
            case 1: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Registrar nuevo entrenador » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);
                
                System.out.println("¡Ingrese el nombre del nuevo entrenador!");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                
                sc.nextLine();//Limpia Scanner
                String nombreEntrenador = sc.nextLine();


                pokeEntrenadores.add(new Entrenador(nombreEntrenador, new LinkedList<>()));

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

            case 2: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver lista de entrenadores » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

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
    
                wait(5);

                menu1();

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

                wait(3);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarEntrenadores();

                break;
        }//cierra switch

    }//cierra switchMenuGestionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU SELECCIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //
    
    public static void subMenuSeleccionarEntrenadores(){ //✅

        entrenadorSeleccionado = 0; //Reset

        while (firstSubMenuSeleccionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Seleccionar Entrenadores » !");     
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstSubMenuSeleccionarEntrenadores = false;
        }//cierra while
            
        wait(5);

        interfazDeCarga();

        wait(4);

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

            entrenadorSeleccionado = check()-1; //Evita que salga de los límites.

        }//cierra else-if

        wait(4);

        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        System.out.println("¡Has seleccionado al entrenador « " + pokeEntrenadores.get(entrenadorSeleccionado) + " » !");     
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual

        wait(4);
        
        subMenuNombreEntrenador(entrenadorSeleccionado);

    }//cierra subMenuSeleccionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU NOMBRE ENTRENADOR [] [] [] [] [] [] [] [] [] //

    public static void subMenuNombreEntrenador(int entrenadorSeleccionado){ //✅

        System.out.println("       ,___          .-;'|    |  | » » » OPCIONES DE ENTRENADOR « « « |  | |';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`   |   |  |                                    |  |  |`.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /      |  |  |  (1) | Ver equipo de pokemones.    |  |   | \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\      |  |  |                                    |  |   | /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|     |  |  |  (2) | Agregar pokémon al equipo.  |  |   ||)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       | |  |                                    |  |    |\\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       | |  |  (3) | Entrenar pokémon.           |  |    |;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\    |   |  |                                    |  |  | / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)   |   |  |  (4) | Volver al menu anterior.    |  |  |(_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       | |  |                                    |  |    | \\    ,     ;-'\n" + //
                        "          \\    /   <       |  |  |  (5) | Salir.                      |  |   |   >   \\    /\n" + //
                        "           '. <`'-._)       | |  |                                    |  |    | (_,-'`> .'\n" + //
                        "            '._)            | |  | » » »      PokeMondonGo      « « « |  |    |     (_,'");
        
    
        switchNombreEntrenador(check(), entrenadorSeleccionado);
    }//cierra subMenuNombreEntrenador

    // {} {} {} {} {} {} {} {} {} SWITCH NOMBRE ENTRENADOR {} {} {} {} {} {} {} {} {} //

    public static void switchNombreEntrenador(int option, int entrenadorSeleccionado){ //✅
        switch (option){ //✅
            case 1: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver equipo de pokemones » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                Entrenador.mostrarPokemones();

                wait(5);

                miniMenu(5);

                break;

            case 2: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Agregar pokémon al equipo » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                pokeEntrenadores.get(entrenadorSeleccionado).agregarPokemon(pokemonesEquipo6(entrenadorSeleccionado));
                
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Agregando pokémon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println(" ☆ ☆ ☆ ¡Pokémon agregado al equipo con éxito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(4);

                subMenuNombreEntrenador(entrenadorSeleccionado);

                break;
            case 3: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Entrenar pokémon » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                pokeEntrenadores.get(entrenadorSeleccionado).entrenarPokemon(pokemonesEquipo6(entrenadorSeleccionado));
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Entrenando pokémon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Creando lazos más fuertes con el entrenador...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Perfeccionando movimientos...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Aumentando autoestima...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println(" ☆ ☆ ☆ ¡Pokémon entrenado con éxito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(4);

                subMenuNombreEntrenador(entrenadorSeleccionado); 

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
    }//cierra switchNombreEntrenador

    // [] [] [] [] [] [] [] [] [] POKEMONES EQUIPO 6 [] [] [] [] [] [] [] [] [] //

    public static Pokemon pokemonesEquipo6(int entrenadorSeleccionado){ //✅

        for (int i = 0; i < pokemonesDisponibles.size(); i++) {

            Pokemon p = pokemonesDisponibles.get(i);

            System.out.println("(" + (i+1) + ") | " + p.getNombre() + " | Salud -> " + p.getSalud() + " | Ataque -> " + p.getPuntosDeAtaque() + " | Tipo -> " + p.getTipo() + " |");
        }//cierra for
    
        return switchPokemonesEquipo6(check(), entrenadorSeleccionado);

    }//cierra pokemonesEquipo6

    // {} {} {} {} {} {} {} {} {} SWITCH POKEMONES EQUIPO 6 {} {} {} {} {} {} {} {} {} //

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

    public static void menuGestionarPokemones(){ //✅
        while (firstMenuGestionarPokemones == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Gestionar Pokémones » !");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarPokemones = false;
        }//cierra while
        
        wait(5);

        System.out.println("       ,___          .-;'|    | » » »  GESTIONAR  POKEMONES  « « « | |';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`   |   |                                    |  |`.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /      |  |                                    |   | \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\      |  | (1) | Ver pokemones registrados.   |   | /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|     |  |                                    |   ||)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       | | (2) | Registrar nuevo pokémon.     |    |\\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       | |                                    |    |;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\    |   | (3) | Volver al menú principal.    |  | / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)   |   |                                    |  |(_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       | | (4) | Salir.                       |    | \\    ,     ;-'\n" + //
                        "          \\    /   <       |  |                                    |   |   >   \\    /\n" + //
                        "           '. <`'-._)       | |                                    |    | (_,-'`> .'\n" + //
                        "            '._)            | | » » »      PokeMondonGo      « « « |    |     (_,'");
        
        switchMenuGestionarPokemones(check());
    }//cierra menuGestionarPokemones

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR POKEMONES {} {} {} {} {} {} {} {} {} //

    public static void switchMenuGestionarPokemones(int option){ //✅
        switch (option){
            case 1: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver pokemones registrados » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(3);

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
            
                wait(5);

                interfazDeCarga();

                wait(4);

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

                wait(5);

                System.out.println("Verificando en la Pokédex...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println(" ☆ ☆ ☆ ¡Pokémon registrado con éxito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Regresando al menú anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(4);

                menuGestionarPokemones();

                break;
            case 3: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú principal...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                menu1();

                break;
            case 4: //✅
                
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
                System.out.println("¡ Debes seleccionar una opción válida !");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(4);

                menuGestionarPokemones();

                break;
        }//cierra switch
    }//cierra switchMenuGestionarPokemones
    
    // [] [] [] [] [] [] [] [] [] MENU INICIAR BATALLA [] [] [] [] [] [] [] [] [] //

    public static void menuIniciarBatalla(){ //✅
        while (firstMenuIniciarBatalla == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡ Has seleccionado « Iniciar Batalla » !");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuIniciarBatalla = false;
        }//cierra while
        
        wait(5);

        System.out.println("       ,___          .-;'|    |  | » » »    INICIAR  BATALLA    « « « |  | |';-.          ___,\n" + //
                        "       `\"-.`\\_...._/`.`   |   |  |                                    |  |  |`.`\\_...._/`.-\"`\n" + //
                        "    ,      \\        /      |  |  |  (1) | Elegir entrenador #1.       |  |   | \\        /      ,\n" + //
                        " .-' ',    / ()   ()\\      |  |  |  (2) | Elegir entrenador #2.       |  |   | /()   () \\    .' `-.\n" + //
                        "`'._   \\  /()   .   (|     |  |  |  (3) | Seleccionar pokémon         |  |   ||)   .   ()\\  /   _.'`\n" + //
                        "    > .' ;,    -'-  /       | |  |           del entrenador#1.        |  |    |\\  -'-    ,; '. <\n" + //
                        "   / <   |;,     __.;       | |  |  (4) | Seleccionar pokémon         |  |    |;.__     ,;|   > \\\n" + //
                        "   '-.'-.|  , \\    , \\    |   |  |           del entrenador#2.        |  |  | / ,    / ,  |.-'.-'\n" + //
                        "      `>.|;, \\_)    \\_)   |   |  |  (5) | Comenzar batalla.           |  |  |(_/    (_/ ,;|.<'\n" + //
                        "       `-;     ,    /       | |  |  (6) | Volver al menú principal.   |  |    | \\    ,     ;-'\n" + //
                        "          \\    /   <       |  |  |  (7) | Salir.                      |  |   |   >   \\    /\n" + //
                        "           '. <`'-._)       | |  |                                    |  |    | (_,-'`> .'\n" + //
                        "            '._)            | |  | » » »      PokeMondonGo      « « « |  |    |     (_,'");
        
        sc.nextLine(); //Limpia Scanner
        switchIniciarBatalla(check());
    }//cierra menuIniciarBatalla

    // {} {} {} {} {} {} {} {} {} SWITCH INICIAR BATALLA {} {} {} {} {} {} {} {} {} //
    
    public static void switchIniciarBatalla(int option){ //🅿️
        switch (option){
            case 1: //✅

                wait(5);

                interfazDeCarga();
        
                wait(4);

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
        
                    entrenadorBatalla1 = check()-1; //Evita que salga de los límites.
        
                }//cierra else-if
        
                wait(4);
        
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado al entrenador « " + pokeEntrenadores.get(entrenadorBatalla1) + " » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(4);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú anterior...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(4);

                menuIniciarBatalla();

                break;
            case 2: //✅

                wait(5);

                interfazDeCarga();
        
                wait(4);

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
        
                wait(4);
        
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado al entrenador « " + pokeEntrenadores.get(entrenadorBatalla2) + " » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(4);

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menú anterior...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
                wait(4);

                menuIniciarBatalla();
                break;
            case 3: //✅
                pokemonBatalla1 = pokeEntrenadores.get(entrenadorBatalla1).prepararBatalla();
                break;
            case 4: //✅
                pokemonBatalla2 = pokeEntrenadores.get(entrenadorBatalla2).prepararBatalla();
                break;
            case 5: //🅿️
                
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

                wait(4);

                menu1();

                break;
            case 7: //✅
                
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
                System.out.println("¡ Debes seleccionar una opción válida s!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(4);

                menuIniciarBatalla();
                
                break;
        }//cierra switch
    }//cierra switchIniciarBatalla

    // [] [] [] [] [] [] [] [] [] SUBMENU DURANTE LA BATALLA [] [] [] [] [] [] [] [] [] //

    public static void subMenuDuranteLaBatalla(){ //✅
        
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        System.out.println("¡ HA INICIADO LA BATALLA !");   
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual

        wait(4);


        System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
        wait(3);

        System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual TODO: Revisar altura.
        System.out.println("(1) | "+ pokemonBatalla1.getNombre() + " -> Atacar.");
        System.out.println("(2) | "+ pokemonBatalla2.getNombre() + " -> Atacar.");
        System.out.println("(3) | Finalizar batalla.");


        switchSubMenuDuranteLaBatalla(check());
    }//cierra menuIniciarBatalla

    // {} {} {} {} {} {} {} {} {} SWITCH DURANTE LA BATALLA {} {} {} {} {} {} {} {} {} //
    
    public static void switchSubMenuDuranteLaBatalla(int option){ //🅿️
        switch (option){
            case 1: //✅

                wait(3);

                pokemonBatalla1.atacar(pokemonBatalla2);

                System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.
                System.out.println( pokemonBatalla1.getNombre() + " Ha atacado a " + pokemonBatalla2.getNombre());
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.

                wait(5);

                System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.
                System.out.println( " ¡ El ataque ha sido eficaz ! ");
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.

                wait(5);

                break;
            case 2: //✅

                wait(3);

                pokemonBatalla2.atacar(pokemonBatalla1);

                System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.
                System.out.println( pokemonBatalla2.getNombre() + " Ha atacado a " + pokemonBatalla1.getNombre());
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.

                wait(5);

                System.out.println("[ " + pokemonBatalla1.getNombre() + " ] VS [ " + pokemonBatalla2.getNombre() + " ]");
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.
                System.out.println( " ¡ El ataque ha sido eficaz ! ");
                System.out.println(" \n \n \n"); //Espacio visual TODO: Revisar altura.

                wait(5);

                break;
            case 3: //🅿️
                verif = false;
                System.out.println(nombrePokemonGanador);
                break;
            default: //🅿️
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡ Debes seleccionar una opción válida s!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(4);

                menuIniciarBatalla();
                
                break;
        }//cierra switch
    }//cierra switchIniciarBatalla

    // [] [] [] [] [] [] [] [] [] SALIR [] [] [] [] [] [] [] [] []//

    public static void salir(){ //✅
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual
        System.out.println("» » » Saliendo de PokeMondonGo « « «");
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual

        guardarPartida(pokemonesDisponibles, "ListaDePokemones.pokemondongo");
        
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

    public static void wait(int sec){ //✅
        try { //TODO: Preguntarle al profe si se puede quitar.
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

    }//cierra interfazPokeMondonGo
    
    // () () () () () () () () () VALIDACION () () () () () () () () () //
    
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

    public static void miniMenu(int actual){ //✅
        System.out.println(" > > > ¿Qué deseas hacer? < < <");
        System.out.println("(1) | Regresa al menú anterior.");
        System.out.println("(2) | Salir de PokeMondonGo.");
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

    public static void menusGlobales(int menuOpt){ //🅿️

        switch (menuOpt) {
            case 1: //✅
                interfazDeCarga();
                wait(4);
                menu1();
                break;
            case 2: //🅿️
                interfazDeCarga();
                wait(4);
                menuGestionarEntrenadores();
                break;
            case 3: //🅿️
                interfazDeCarga();
                wait(4);
                subMenuSeleccionarEntrenadores();
                break;
            case 4: //✅
                interfazDeCarga();
                wait(4);
                subMenuNombreEntrenador(entrenadorSeleccionado);
                break;
            case 5: //🅿️
                interfazDeCarga();
                wait(4);
                menuGestionarPokemones();
                break;
            case 6: //✅
                interfazDeCarga();
                wait(4);
                menuIniciarBatalla();
                break;
            case 7: //🅿️
                interfazDeCarga();
                wait(4);
                subMenuDuranteLaBatalla();
                break;
            default:
                break;
        }
    }//cierra menusGlobales
    
    // () () () () () () () () () GUARDAR ARCHIVO () () () () () () () () () //

    public static void guardarPartida(LinkedList<Pokemon> pokemonesDisponibles, String NOMBRE_ARCHIVO){ //✅

        ArchivosConexion.guardar(pokemonesDisponibles, NOMBRE_ARCHIVO);

    }//cierra guardarPartida

}//cierra class
