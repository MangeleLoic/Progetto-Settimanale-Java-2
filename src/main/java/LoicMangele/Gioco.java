package LoicMangele;

import java.time.LocalDate;

public abstract class Gioco {
    private Long id;
    private String titolo;
    private LocalDate annoPubblicazione;
    private int prezzo;

    public Gioco(Long id, String titolo, LocalDate annoPubblicazione, int prezzo) {
        if (id == null) {
            throw new IllegalArgumentException("ID non può essere nullo.");
        }
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere negativo.");
        }
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
