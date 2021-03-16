package esercizi.esercizio24;


public class Test {
    public static void main(String[] args) {
        
        Agenzia agenzia = new Agenzia("Cornelio");
        
        //CREAZIONE VIAGGI
        Viaggio v1 = (new ViaggioPerSingoli("Si va al bar", 50, 2));
        Viaggio v2 = (new ViaggioPerSingoli("Puglia", 70, 3));
        Viaggio v3 = (new ViaggioPerSingoli("Austria", 250, 1));
        
        Viaggio v4 = (new ViaggioPerGruppi("Roma", 140, 20));
        Viaggio v5 = (new ViaggioPerGruppi("Livorno", 20, 16));
        
        //AGGIUNTA GIORNI AI VIAGGI
        v1.addGiorno(new Giorno("Bar", "Un bel bar"));
        
        v2.addGiorno(new Giorno("Viaggio", "Si monta sul treno"));
        v2.addGiorno(new Giorno("Bari", "Si osserva bari da lontano"));
        v2.addGiorno(new Giorno("Ritorno", "Torniamo a casa"));
        
        v3.addGiorno(new Giorno("Treno", "Viaggio sul trenino rosso"));
        v3.addGiorno(new Giorno("Sbaglio", "Siamo andati in Svizzera per sbaglio"));
        
        v4.addGiorno(new Giorno("Colosseo", "Qui ci giocavano mi pare"));
        v4.addGiorno(new Giorno("Autobus", "La classica esperienza romana, borseggio"));
        
        v5.addGiorno(new Giorno("Bimbi si vola", "Si parte per Livorno"));
        v5.addGiorno(new Giorno("Secondo giorno", "Perché abbiamo organizzato un viaggio di 4 giorni a Livorno?"));
        v5.addGiorno(new Giorno("Terzo giorno", "Ci siamo persi per le strade di Livo"));
        v5.addGiorno(new Giorno("Ritorno", "Finalmente"));
        
        //AGGIUNTA VIAGGI ALL'AGENZIA
        agenzia.addViaggio(v1);
        agenzia.addViaggio(v2);
        agenzia.addViaggio(v3);
        agenzia.addViaggio(v4);
        agenzia.addViaggio(v5);
        
        ViaggioPerGruppi.setQUOTA_GRUPPO(4);
        
        agenzia.print();
        agenzia.removeViaggio("Si va al bar");
        System.out.println("\n:::::::::::::::::::Rimozione di si va al bar:::::::::::::::::::\n");
        agenzia.print();
        
    }
}
