package simulador.entrenador;

import java.util.*;
import simulador.pokemon.Pokemon;


public class Entrenador {
    private String nombre;
    private LinkedList <Pokemon> pokemones = new LinkedList<>();
   
    Scanner sc = new Scanner(System.in);
    
    // Constructor //

    public Entrenador(String nombre, LinkedList<Pokemon> pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
    }//cierra constructor


    //Getters y Setters//

    public String getNombre(){
        return this.nombre;
    }//cierra getNombre

    public void setNombre (String nombre){
        this.nombre = nombre;
    }//cierra setNombre

    public LinkedList<Pokemon> getPokemones(){
        return this.pokemones;
    }//cierra getPokemones
 


    //Metodos//
    
    public void agregarPokemon(Pokemon pokemon){
        pokemones.add(pokemon);
        System.out.println("El pokemon" + getNombre() + "fue agregado"); 
    }//cierra agregarPokemon ✅

    public void entrenarPokemon(Pokemon pokemon){
        mostrarPokemon();
        System.out.println("Indique el pokémon a entrenar:");
        pokemon.entrenar();    
    }//cierra entrenarPokemon TODO:revisar 👀

    public void mostrarPokemon(){
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.getNombre());
        }//cierra for
    }//cierra mostrarPokemon ✅

    public Pokemon buscarPokemon(String palabraDeBusqueda){
        for (Pokemon pokemon : pokemones) {
            if(pokemon.getNombre().equals(palabraDeBusqueda)){
                return pokemon;
            }//cierra if
        }//cierra for
        return null; //¿Esto está bien? 👀
    }//cierra buscarPokemon 👀

    public Pokemon prepararBatalla(){
        mostrarPokemon();
        System.out.println("Seleccione el pokémon para la batalla:");
        String word = sc.nextLine();
        return buscarPokemon(word);
    }//cierra prepararBatalla ✅
    
   
}//cierra class
