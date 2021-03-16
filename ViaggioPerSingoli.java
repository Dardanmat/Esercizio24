package esercizi.esercizio24;

import java.util.ArrayList;


public class ViaggioPerSingoli extends Viaggio{

    //COSTRUTTORI
    public ViaggioPerSingoli(String titolo, double costoBase, int numeroPartecipanti, ArrayList<Giorno> listaGiorni) {
        super(titolo, costoBase, numeroPartecipanti, listaGiorni);
    }
    public ViaggioPerSingoli(String titolo, double costoBase, int numeroPartecipanti) {
        super(titolo, costoBase, numeroPartecipanti);
    }
    public ViaggioPerSingoli() {
        super();
    }
    public ViaggioPerSingoli(ViaggioPerSingoli v) {
        super(v);
    }

    @Override
    public double calcoloCosto() {
        return getCostoBase() + (getQUOTA_FISSA_GIORNALIERA()*getListaGiorni().size());
    }

    @Override
    public String toString() {
        return getTitolo() 
                + "\nViaggio per singoli\n" 
                + "\nCosto Viaggio: " + calcoloCosto() + "€\n"
                + super.toString();
    }
    
    @Override
    public String toStringSmall() {
        return getTitolo() 
                + "\nViaggio per singoli\n" 
                + "\nCosto Viaggio: " + calcoloCosto() + "€\n";
    }
    
}
