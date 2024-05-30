package simulador.batalla;

import simulador.Principal;
import simulador.pokemon.Pokemon;

public class Batalla {
   
   public static String iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2, boolean verif, String nombrePokemonGanador){
      
      while (verif == true){
         while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            
            Principal.subMenuDuranteLaBatalla();

            if (pokemon2.getSalud() > 0 ){
               Principal.subMenuDuranteLaBatalla();
               pokemon2.atacar(pokemon1);
            }//cierra if

         }//cierra while
         
         if (pokemon1.getSalud() < 0) {
            nombrePokemonGanador = pokemon2.getNombre();
         } else if (pokemon2.getSalud() < 0) {
            nombrePokemonGanador = pokemon1.getNombre();
         } else {
            nombrePokemonGanador = "Error de ganador.";
         }//cierra else-if
         
      }//cierra while
      return nombrePokemonGanador;
      
   }//cierra iniciarBatalla

}//cierra class