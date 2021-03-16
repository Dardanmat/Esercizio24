package esercizi.esercizio24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenzia {
    
    private ArrayList<Viaggio> listaViaggi;
    private String nome;

    //COSTRUTTORI
    public Agenzia(ArrayList<Viaggio> listaViaggi, String nome) {
        this.listaViaggi = (ArrayList<Viaggio>)listaViaggi.clone();
        this.nome = nome;
    }
    public Agenzia(String nome) {
        this.listaViaggi = new ArrayList<>();
        this.nome = nome;
    }
    public Agenzia() {
        this.listaViaggi = new ArrayList<>();
        this.nome = "";
    }
    public Agenzia(Agenzia a) {
        this.listaViaggi = (ArrayList<Viaggio>)a.listaViaggi.clone();
        this.nome = a.nome;
    }

    //GETTERS & SETTERS
    public ArrayList<Viaggio> getListaViaggi() {
        return listaViaggi;
    }
    public void setListaViaggi(ArrayList<Viaggio> listaViaggi) {
        this.listaViaggi = listaViaggi;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public boolean addViaggio(Viaggio v){
        if(v == null) return false;
        if(listaViaggi.contains(v)) return false;
        return listaViaggi.add(v);
    }
    
    public Viaggio removeViaggio(Viaggio v){
        return removeViaggio(v.getTitolo());
    }
    public Viaggio removeViaggio(String titolo){
        if(listaViaggi.isEmpty()) return null;
        return listaViaggi.remove(cercaViaggio(titolo));
    }
    
    private int cercaViaggio(String titolo){
        if(listaViaggi.isEmpty()) return -1;
        for(int i = 0; i < listaViaggi.size(); i++){
            if(listaViaggi.get(i).equals(titolo)) return i;
        }
        return -1;
    }
    private int cercaViaggio(Viaggio v){
        return cercaViaggio(v.getTitolo());
    }
    
    //la creazione della lista dei viaggi con costo inferiore ad un certo valore, in ordine decrescente
    //rispetto al costo;
    public ArrayList<Viaggio> listaViaggiCostoMinoreDi(double num){
        ArrayList<Viaggio> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            if(v.calcoloCosto() < num){
                lista.add(v);
            }
        }
        Collections.sort(lista, Comparator.comparing(Viaggio::calcoloCosto).reversed());
        return lista;
    }
    
    //la creazione della lista dei viaggi per singoli che passano da una certa località, in ordine alfabetico per
    //titolo del viaggio;
    public ArrayList<Viaggio> listaViaggiConLuogo(String luogo){
        ArrayList<Viaggio> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            for(Giorno g: v.getListaGiorni()){
                if(g.getLuogo().equals(luogo)){
                    lista.add(v);
                    break;
                }
            }
        }
        Collections.sort(lista, Comparator.comparing(Viaggio::getTitolo));
        return lista;
    }
    
    //la creazione della lista dei viaggi per gruppi con numero minimo di partecipanti uguale ad un certo
    //valore, ordinati per numero di giorni previsti;
    public ArrayList<ViaggioPerGruppi> listaViaggiGruppi_per_NumeroPartecipanti(int numeroMinimoPartecipanti){
        ArrayList<ViaggioPerGruppi> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            if(v instanceof ViaggioPerGruppi){
                
                if(v.getNumeroPartecipanti() < numeroMinimoPartecipanti){
                    lista.add((ViaggioPerGruppi) v);
                }
            }
        }
        Collections.sort(lista, Comparator.comparing(Viaggio::getListGiorniSize));
        return lista;
    }
    
    //la creazione della lista dei viaggi per gruppi che superano un certo numero di giorni.
    public ArrayList<ViaggioPerGruppi> listaViaggiGruppi_con_NumGiorniMinimo(int numeroGiorniMinimi){
        ArrayList<ViaggioPerGruppi> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            if(v instanceof ViaggioPerGruppi){
                
                if(v.getListGiorniSize() > numeroGiorniMinimi){
                    lista.add((ViaggioPerGruppi) v);
                }
            }
        }
        return lista;
    }
    
    public void print(){
        System.out.println("Agenzia viaggi " + this.nome + "\n");
        for(Viaggio v: listaViaggi){
            System.out.println("----------------------------------------------------\n" + v.toStringSmall());
        }
    }
    
    public void printAll(){
        System.out.println("Agenzia viaggi " + this.nome + "\n");
        for(Viaggio v: listaViaggi){
            System.out.println("----------------------------------------------------\n"+v.toString());
        }
    }
    
}
