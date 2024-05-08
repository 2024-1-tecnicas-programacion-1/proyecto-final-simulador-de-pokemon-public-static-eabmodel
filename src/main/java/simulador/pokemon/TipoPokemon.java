package simulador.pokemon;

public class TipoPokemon extends Pokemon{

    TipoPokemon(String nombre, double salud, double puntosDeAtaque, String tipo, String estado) {
        super(nombre, salud, puntosDeAtaque, tipo, estado);

    }//cierra constructor

    public int atacar() {

        return 0;
    }//cierra atacar

    public int recibirDaño() {
        
        return 0;
    }//cierra recibirDaño

    public String entrenar() {

        return "";
    }//cierra entrenar
    
    public String obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {
        
        return "";
    }//cierra obtenerMultiplicadorDeDaño

}//cierra class
