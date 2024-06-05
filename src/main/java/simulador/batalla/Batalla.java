package simulador.batalla;

import simulador.Principal;
import simulador.pokemon.Pokemon;

public class Batalla {
   
   //Complejidad temporal: O(N) Tiempo lineal
   public static String iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2, boolean verif, String nombrePokemonGanador){

      nombrePokemonGanador = "PEPE";

      while (verif == true){

         while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            
            Principal.subMenuDuranteLaBatalla(nombrePokemonGanador);

         }//cierra while
         
         verif = false;
         
      }//cierra while

      return nombrePokemonGanador;
      
   }//cierra iniciarBatalla

}//cierra class
