package simulador.entrenador;

import java.util.*;

import simulador.Principal;
import simulador.pokemon.Pokemon;


public class Entrenador { //✅
    private String nombre;
    private LinkedList <Pokemon> pokeLista;
    


    // Constructor //

    public Entrenador(String nombre) { //✅
        this.nombre = nombre;
        this.pokeLista = new LinkedList<>();
    }//cierra constructor



    //Getters y Setters//

    public String getNombre(){ //✅
        return this.nombre;
    }//cierra getNombre

    public void setNombre (String nombre){ //✅
        this.nombre = nombre;
    }//cierra setNombre

    public LinkedList<Pokemon> getPokeLista(){ //✅
        return pokeLista;
    }//cierra getPokemones
 


    //Metodos//
    
    public void agregarPokemon(Pokemon pokemon){ //✅
        pokeLista.add(pokemon);
    }//cierra agregarPokemon

    public void entrenarPokemon(Pokemon pokemon){ //✅

        if (pokeLista.isEmpty()) {
            System.out.println("No tienes pokemones para entrenar.");
        } else if (pokeLista.contains(pokemon)) {
            pokemon.entrenar();
        } else {
            System.out.println("El pokémon no se encuentra en tu Pokédex.");
            //TODO: añadir regreso.
        }//cierra if-else
        
    }//cierra entrenarPokemon

    public void mostrarPokemones(){ //✅
        for (int i = 0; i < pokeLista.size(); i++) {
            String pokeNombre = pokeLista.get(i).getNombre();
            double pokeSalud = pokeLista.get(i).getSalud();
            double pokeAtaque = pokeLista.get(i).getPuntosDeAtaque();
            System.out.println("(" + (i+1) + ") | " + pokeNombre + " -> Salud: " + pokeSalud + " -> Ataque: " + pokeAtaque + " |");
        }//cierra for
    }//cierra mostrarPokemon

    public Pokemon prepararBatalla(){ //✅
        if (pokeLista.isEmpty() != true) {

            System.out.println("");
            System.out.println(" > > > TUS POKEMONES DISPONIBLES < < <");
            System.out.println("");

            mostrarPokemones();

            System.out.println("");
            System.out.println("Digita el número de tu pokémon para luchar: ");
            
            Pokemon pokemonBatalla = pokeLista.get(Principal.check());

            return pokemonBatalla;
            
        } else {
            System.out.println("No tienes pokemones disponibles para luchar.");
        }//cierra for-else

        return null;
    }//cierra prepararBatalla

}//cierra class
