package LoicMangele;

import java.time.LocalDate;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durataPartita;

    public GiocoDaTavolo(Long id, String titolo, LocalDate annoPubblicazione, int prezzo, int numeroGiocatori, int durataPartita) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durataPartita = durataPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurataPartita() {
        return durataPartita;
    }

    public void setDurataPartita(int durataPartita) {
        this.durataPartita = durataPartita;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "id: " + getId() +
                ", titolo: '" + getTitolo() + '\'' +
                ", annoPubblicazione: " + getAnnoPubblicazione() +
                ", prezzo: " + getPrezzo() +
                ", numeroGiocatori: " + numeroGiocatori +
                ", durataPartita: " + durataPartita + " min" +
                '}';
    }
}
