package simulador.batalla;

import simulador.pokemon.Pokemon;

public class Batalla {
   
   public String iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2){
      
      String ganador;

      while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
         
         pokemon1.atacar(pokemon2);

         if (pokemon2.getSalud() > 0 ){
            pokemon2.atacar(pokemon1);
         }//cierra if

      }//cierra while
      
      if (pokemon1.getSalud() <= 0) {
         ganador = pokemon1.getNombre();
      } else {
         ganador = pokemon2.getNombre();
      }//cierra if

      return ganador;
   }//cierra iniciarBatalla

}//cierra class