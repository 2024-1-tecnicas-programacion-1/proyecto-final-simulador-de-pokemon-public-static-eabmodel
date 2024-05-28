package simulador.entrenador;

import java.util.*;
import simulador.Principal;
import simulador.pokemon.Pokemon;


public class Entrenador { //✅
    private String nombre;
    private LinkedList <Pokemon> pokeLista = new LinkedList<>();
    


    // Constructor //

    public Entrenador(String nombre, LinkedList<Pokemon> pokemones) { //✅
        this.nombre = nombre;
        this.pokeLista = pokemones;
    }//cierra constructor



    //Getters y Setters//

    public String getNombre(){ //✅
        return this.nombre;
    }//cierra getNombre

    public void setNombre (String nombre){ //✅
        this.nombre = nombre;
    }//cierra setNombre

    public LinkedList<Pokemon> getPokeLista(){ //✅
        return this.pokeLista;
    }//cierra getPokemones

    public void setPokelista(){ //TODO: ¿Por qué amarillo?
        this.pokeLista = pokeLista;
    }//cierra setPokelista
 


    //Metodos//
    
    public void agregarPokemon(Pokemon pokemon){ //✅
        pokeLista.add(pokemon); 
    }//cierra agregarPokemon

    public void entrenarPokemon(Pokemon pokemon){ //✅
        double salud = pokemon.getSalud()+5;
        double daño = pokemon.getPuntosDeAtaque()+20;
    }//cierra entrenarPokemon

    public void mostrarPokemones(){ //✅
        for (int i = 0; i < pokeLista.size(); i++) {
            String pokeItem = pokeLista.get(i).getNombre();
            System.out.println("(" + i + ") | " + pokeItem);
        }//cierra for
    }//cierra mostrarPokemon

    public Pokemon prepararBatalla(){ //✅
        if (pokeLista.isEmpty() != true) {

            System.out.println("");
            System.out.println(" > > > TUS POKEMONES DISPONIBLES < < <");
            System.out.println("");

            mostrarPokemones();

            System.out.println("");
            System.out.println("Elige tu pokémon para luchar.");
            
            String palabraDeBusqueda = null ; //TODO: @Brian, aquí va el scanner.
            
            for (int i = 0; i < pokeLista.size(); i++) {
                String pokemonBusqueda = pokeLista.get(i).getNombre();
                if (palabraDeBusqueda.equals(pokeLista)){
                    Pokemon pokemonBatalla = pokeLista.get(i);
                    return pokemonBatalla;
                }//cierra if
            }//cierra for
        } else {
            System.out.println("No tienes pokemones disponibles para luchar.");
        }//cierra for-else

        return null;
    }//cierra prepararBatalla

}//cierra class
