package LoicMangele;

import java.time.LocalDate;

public class VideoGioco extends Gioco {
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    public VideoGioco(Long id, String titolo, LocalDate annoPubblicazione, int prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.durataGioco = durataGioco;
        this.genere = genere;
        this.piattaforma = piattaforma;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    @Override
    public String toString() {
        return "VideoGioco{" +
                "piattaforma: '" + piattaforma + '\'' +
                ", durataGioco: " + durataGioco + " ore" +
                ", genere: " + genere +
                ", titolo: '" + getTitolo() + '\'' +
                ", id: " + getId() +
                ", annoPubblicazione: " + getAnnoPubblicazione() +
                ", prezzo: " + getPrezzo() +
                '}';
    }
}
