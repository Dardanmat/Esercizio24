package esercizi.esercizio24;
import java.util.ArrayList;

public abstract class Viaggio {
    
    public static double QUOTA_FISSA_GIORNALIERA = 40;
    
    private String titolo;
    private double costoBase;
    private ArrayList<Giorno> listaGiorni;
    private int numeroPartecipanti;

    //COSTRUTTORI
    public Viaggio(String titolo, double costoBase, int numeroPartecipanti,ArrayList<Giorno> listaGiorni) {
        this.titolo = titolo;
        this.costoBase = costoBase;
        this.numeroPartecipanti = numeroPartecipanti;
        this.listaGiorni = (ArrayList<Giorno>)listaGiorni.clone();
    }
    public Viaggio(String titolo, double costoBase, int numeroPartecipanti) {
        this.titolo = titolo;
        this.costoBase = costoBase;
        this.numeroPartecipanti = numeroPartecipanti;
        this.listaGiorni = new ArrayList<>();
    }
    public Viaggio() {
        this.titolo = "";
        this.costoBase = 0;
        this.numeroPartecipanti = 0;
        this.listaGiorni = new ArrayList<>();
    }
    public Viaggio(Viaggio v) {
        this.titolo = v.titolo;
        this.costoBase = v.costoBase;
        this.numeroPartecipanti = v.numeroPartecipanti;
        this.listaGiorni = new ArrayList<>();
    }

    //GETTERS & SETTERS
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getCostoBase() {
        return costoBase;
    }
    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
    
    public int getNumeroPartecipanti() {
        return numeroPartecipanti;
    }
    public void setNumeroPartecipanti(int numeroPartecipanti) {
        this.numeroPartecipanti = numeroPartecipanti;
    }

    public ArrayList<Giorno> getListaGiorni() {
        return listaGiorni;
    }
    public void setListaGiorni(ArrayList<Giorno> listaGiorni) {
        this.listaGiorni = listaGiorni;
    }

    public static double getQUOTA_FISSA_GIORNALIERA() {
        return QUOTA_FISSA_GIORNALIERA;
    }
    public static void setQUOTA_FISSA_GIORNALIERA(double QUOTA_FISSA_GIORNALIERA) {
        Viaggio.QUOTA_FISSA_GIORNALIERA = QUOTA_FISSA_GIORNALIERA;
    }
    
    protected int getListGiorniSize(){
        return listaGiorni.size();
    }
    
    public boolean addGiorno(Giorno g){
        if(g == null) return false;
        if(listaGiorni.contains(g)) return false;
        return listaGiorni.add(g);
    }
    
    public Giorno removeGiorno(Giorno g){
        return removeGiorno(g.getNumOrdine());
    }
    public Giorno removeGiorno(int numOrdine){
        if(listaGiorni.isEmpty()) return null;
        return listaGiorni.remove(cercaGiorno(numOrdine));
    }
    
    private int cercaGiorno(int numOrdine){
        if(listaGiorni.isEmpty()) return -1;
        for(int i = 0; i < listaGiorni.size(); i++){
            if(listaGiorni.get(i).equals(numOrdine)) return i;
        }
        return -1;
    }
    private int cercaGiorno(Giorno g){
        return cercaGiorno(g.getNumOrdine());
    }

    @Override
    public String toString() {
        String s = "";
        for(Giorno v: listaGiorni){
            s += "\n" + v.toString() + "\n";
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String){
            if(((String) obj).equalsIgnoreCase(titolo)) return true;
        }
        
        if(obj instanceof Viaggio){
            if(((Viaggio) obj).titolo.equals(titolo)) return true;
        }
        return false;
    }
    
    public abstract double calcoloCosto();
    public abstract String toStringSmall();
    
}
