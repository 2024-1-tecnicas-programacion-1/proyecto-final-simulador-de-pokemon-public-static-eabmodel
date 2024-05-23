package simulador.batalla;

import simulador.pokemon.Pokemon;

public class Batalla {
   
   public Pokemon iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2){
      
      while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
         pokemon1.atacar(pokemon2);
         if (pokemon2.getSalud() > 0 ){
            pokemon2.atacar(pokemon1);
         }
      }
   if (pokemon1.getSalud() <= 0) {
      System.out.println("El ganador es: " + pokemon2.getNombre());
   } else {
      System.out.println("El ganador es: " + pokemon1.getNombre());
   }
      //esperar metodookemon.atacar

      return pokemon1;
   }//cierra iniciarBatalla

   /*
      int tipoPokemon1 = 1;
      int tipoPokemon2 = 2;

        if(tipoPokemon1==TipoPokemon.BICHO && tipoPokemon2==TipoPokemon.DRAGON){
            System.out.println("Gana el bicho");
        } //ESTO LO HIZO EL PROFE XD
   
   */

}//cierra class