package esercizi.esercizio24;

import java.util.ArrayList;


public class ViaggioPerGruppi extends Viaggio{
    
    private static float QUOTA_GRUPPO = 5;
    
    //COSTRUTTORI
    public ViaggioPerGruppi(String titolo, double costoBase, int numeroPartecipanti, ArrayList<Giorno> listaGiorni) {
        super(titolo, costoBase, numeroPartecipanti, listaGiorni);
    }
    public ViaggioPerGruppi(String titolo, double costoBase, int numeroPartecipanti) {
        super(titolo, costoBase, numeroPartecipanti);
    }
    public ViaggioPerGruppi() {
        super();
    }
    public ViaggioPerGruppi(ViaggioPerGruppi v) {
        super(v);

    }

    //GETTERS & SETTERS
    public static float getQUOTA_GRUPPO() {
        return QUOTA_GRUPPO;
    }
    public static void setQUOTA_GRUPPO(float QUOTA_GRUPPO) {
        ViaggioPerGruppi.QUOTA_GRUPPO = QUOTA_GRUPPO;
    }
    
    
    @Override
    public double calcoloCosto() {
        return getCostoBase() + (getQUOTA_FISSA_GIORNALIERA()*getListaGiorni().size()) + (QUOTA_GRUPPO*getNumeroPartecipanti());
    }

    @Override
    public String toString() {
        return getTitolo() 
                + "\nViaggio per Gruppi"
                + "\nNumero partecipanti: " + getNumeroPartecipanti() 
                + "\nCosto Viaggio: " + calcoloCosto() + "€\n"
                + super.toString();
    }
    
    @Override
    public String toStringSmall() {
    return getTitolo() 
                + "\nViaggio per Gruppi"
                + "\nNumero partecipanti: " + getNumeroPartecipanti() 
                + "\nCosto Viaggio: " + calcoloCosto() + "€\n";
    }
    
}
