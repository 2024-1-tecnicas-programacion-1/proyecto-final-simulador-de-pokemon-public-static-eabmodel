package simulador.entrenador;

import java.util.*;

import simulador.pokemon.Pokemon;

public class Entrenador {
    private String nombre;

    Scanner sc = new Scanner(System.in);

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }//cierra constructor

    LinkedList <Pokemon> pokemones = new LinkedList<>();

    public void agregarPokemon(Pokemon pokemon){
        pokemones.add(pokemon);
    }//cierra agregarPokemon

    public void entrenarPokemon(){}//cierra entrenarPokemon #TODO: esperar explicacion del profe

    public void mostrarPokemon(){
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.getNombre());
        }//cierra for
    }//cierra mostrarPokemon

    public Pokemon buscarPokemon(String palabraDeBusqueda){
        for (Pokemon pokemon : pokemones) {
            if(pokemon.getNombre().equals(palabraDeBusqueda)){
                return pokemon;
            }//cierra if
        }//cierra for
        return null;
    }//cierra buscarPokemon

    public void prepararBatalla(){
        mostrarPokemon();
        System.out.println("Seleccione el pokémon para la batalla:");
        String word = sc.nextLine();
        buscarPokemon(word);

        //TODO
    }//cierra prepararBatalla #TODO: esperar explicacion del profe
        
}//cierra class
