package esercizi.esercizio24;


public class Giorno {
    
    private static int NUMERO_ORDINE = 1;
    private int numOrdine;
    private String luogo;
    private String descrizione;

    //COSTRUTTORI
    public Giorno(String luogo, String descrizione) {
        this.luogo = luogo;
        this.descrizione = descrizione;
        numOrdine = NUMERO_ORDINE;
        NUMERO_ORDINE++;
    }
    public Giorno() {
        this.luogo = "";
        this.descrizione = "";
        numOrdine = NUMERO_ORDINE;
        NUMERO_ORDINE++;
    }
    public Giorno(Giorno g) {
        this.luogo = g.luogo;
        this.descrizione = g.descrizione;
        numOrdine = NUMERO_ORDINE;
        NUMERO_ORDINE++;
    }

    public static int getNUMERO_ORDINE() {
        return NUMERO_ORDINE;
    }

    //GETTERS & SETTERS
    public int getNumOrdine() {
        return numOrdine;
    }
    public void setNumOrdine(int numOrdine) {
        this.numOrdine = numOrdine;
    }

    public String getLuogo() {
        return luogo;
    }
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    
    @Override
    public String toString() {
        return "     Codice giorno: " + numOrdine + 
                "\n     Luogo: " + luogo +
                "\n     " + descrizione;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Giorno){
            if(numOrdine == ((Giorno) obj).numOrdine) return true;
        }
        return false;
    }
    public boolean equals(int val) {
        if(numOrdine == val) return true;
        return false;
    }
    
}
