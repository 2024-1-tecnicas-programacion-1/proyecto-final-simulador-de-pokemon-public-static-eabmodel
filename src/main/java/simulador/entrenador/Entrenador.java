package simulador.entrenador;

import java.util.*;

import java.io.Serializable;

import simulador.Principal;
import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;


public class Entrenador implements Serializable{ //✅
    private String nombre;
    private LinkedList <Pokemon> pokeLista;
    

    
    // Constructor //

    public Entrenador(String nombre, LinkedList<Pokemon> pokeLista) { //✅
        this.nombre = nombre;
        this.pokeLista = pokeLista;
    }//cierra constructor


    //Getters y Setters//

    public String getNombre(){ //✅
        return nombre;
    }//cierra getNombre

    public void setNombre (String nombre){ //✅
        this.nombre = nombre;
    }//cierra setNombre

    public LinkedList<Pokemon> getPokeLista(){ //✅
        return pokeLista;
    }//cierra getPokemones
 


    //Metodos//

    //Complejidad temporal: O(1) Tiempo constante
    public void agregarPokemon(Pokemon pokemon){ //✅
        pokeLista.add(pokemon);
    }//cierra agregarPokemon

    //Complejidad temporal: O(1) Tiempo constante
    public void entrenarPokemon(Pokemon pokemon){ //✅
        if (pokeLista.isEmpty()) {
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡ Oh oh, tus pokemones están de vacaciones o no tienes !");
            System.out.println(" \n \n "); //Espacio visual
        } else if (pokeLista.contains(pokemon)) {
            pokemon.entrenar();
        } else {
            System.out.println("El pokémon no se encuentra en tu inventario.");
            //TODO: añadir regreso.
        }//cierra if-else
    }//cierra entrenarPokemon

    //Complejidad temporal: O(N) Tiempo lineal
    public void mostrarPokemones(){ //✅
        if (pokeLista.isEmpty()) {
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡ Oh oh, no hay pokemones por aquí !");
            System.out.println(" \n \n "); //Espacio visual
        } else {

            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            for (int i = 0; i < pokeLista.size(); i++) {
                String pokeNombre = pokeLista.get(i).getNombre();
                double pokeSalud = pokeLista.get(i).getSalud();
                double pokeAtaque = pokeLista.get(i).getPuntosDeAtaque();
                TipoPokemon pokeTipo = pokeLista.get(i).getTipo();
                System.out.println(" > | " + pokeNombre + " | Salud -> " + pokeSalud + " | Ataque -> " + pokeAtaque + " | Tipo -> " + pokeTipo + " |");
            }//cierra for

        }//cierra else-if
        
    }//cierra mostrarPokemon

    //Complejidad temporal: O(N) Tiempo linea
    public void mostrarPokemonesIndex(){ //✅
        if (pokeLista.isEmpty()) {
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡ Oh oh, no hay pokemones por aquí !");
            System.out.println(" \n \n "); //Espacio visual
        } else {

            for (int i = 0; i < pokeLista.size(); i++) {
                String pokeNombre = pokeLista.get(i).getNombre();
                double pokeSalud = pokeLista.get(i).getSalud();
                double pokeAtaque = pokeLista.get(i).getPuntosDeAtaque();
                TipoPokemon pokeTipo = pokeLista.get(i).getTipo();
                System.out.println(" (" +  (i+1) + ") | " + pokeNombre + " | Salud -> " + pokeSalud + " | Ataque -> " + pokeAtaque + " | Tipo -> " + pokeTipo + " |");
            }//cierra for

        }//cierra else-if
        
    }//cierra mostrarPokemon

    //Complejidad temporal: O(1) Tiempo constante
    public Pokemon prepararBatalla(){ //✅
        if (pokeLista.isEmpty() != true) {

            System.out.println("");
            System.out.println(" > > > Tus Pokémon Disponibles < < <");
            System.out.println("");

            mostrarPokemonesIndex();

            System.out.println("");
            System.out.println("Digita el número de tu pokémon para luchar: ");
            
            Pokemon pokemonBatalla = pokeLista.get(Principal.check()-1);
            return pokemonBatalla;
            
        } else {
            System.out.println("No tienes pokemones disponibles para luchar.");
        }//cierra for-else

        return null;
    }//cierra prepararBatalla

    //Complejidad temporal: O(1) Tiempo constante
    public Pokemon prepararEntrenamiento(){ //✅
        if (pokeLista.isEmpty() != true) {

            System.out.println("");
            System.out.println(" > > > Tus Pokémon Disponibles < < <");
            System.out.println("");

            mostrarPokemonesIndex();

            System.out.println("");
            System.out.println("Digita el número de tu pokémon para entrenar: ");
            
            Pokemon pokemonDeEntrenamiento = pokeLista.get(Principal.check()-1);
            return pokemonDeEntrenamiento;
            
        } else {
            System.out.println("No tienes pokemones disponibles para entrenar.");
        }//cierra for-else

        return null;
    }//cierra prepararBatalla

}//cierra class
