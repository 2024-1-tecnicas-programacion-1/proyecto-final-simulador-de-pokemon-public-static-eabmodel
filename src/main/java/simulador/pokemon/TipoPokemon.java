package simulador.pokemon;

public class TipoPokemon extends Pokemon{

    TipoPokemon(String nombre, double salud, double puntosDeAtaque, String tipo, String estado) {
        super(nombre, salud, puntosDeAtaque, tipo, estado);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int atacar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atacar'");
    }

    @Override
    public int recibirDaño() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recibirDaño'");
    }

    @Override
    public String entrenar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrenar'");
    }
    
    public String obtenerMultiplicadorDeDaño() {
        return null;
    }
}
