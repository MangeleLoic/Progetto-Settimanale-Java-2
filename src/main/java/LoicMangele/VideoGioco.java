package LoicMangele;

import java.time.LocalDate;

public class VideoGioco extends Gioco {
    private String piattaforma;
    private int durataGioco;
    private  Genere genere;


    public VideoGioco(Long id, String titolo, LocalDate annoPubblicazione, int prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.durataGioco = durataGioco;
        this.genere = genere;
    }
}
