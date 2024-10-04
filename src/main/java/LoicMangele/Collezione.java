package LoicMangele;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collezione {
    private List<Gioco> giochi;

    public Collezione() {
        giochi = new ArrayList<>();
    }


    public void aggiungiGioco(Gioco gioco) {
        giochi.add(gioco);
    }


    public Optional<Gioco> ricercaPerId(Long id) {
        return giochi.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst();
    }


    public boolean rimuoviGioco(Long id) {
        Optional<Gioco> giocoDaRimuovere = ricercaPerId(id);
        if (giocoDaRimuovere.isPresent()) {
            giochi.remove(giocoDaRimuovere.get());
            return true;
        }
        return false;
    }


    public List<Gioco> ricercaPerPrezzo(int prezzo) {
        return giochi.stream()
                .filter(g -> g.getPrezzo() <= prezzo)
                .collect(Collectors.toList());
    }


    public List<GiocoDaTavolo> ricercaPerNumeroGiocatori(int numeroGiocatori) {
        return giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(g -> g.getNumeroGiocatori() == numeroGiocatori)
                .collect(Collectors.toList());
    }


    public void visualizzaStatistiche() {
        long numeroGiochi = giochi.size();
        long giochiDaTavolo = giochi.stream().filter(g -> g instanceof GiocoDaTavolo).count();
        long videoGiochi = giochi.stream().filter(g -> g instanceof VideoGioco).count();
        double prezzoMedio = giochi.stream().mapToInt(Gioco::getPrezzo).average().orElse(0);

        System.out.println("Numero totale di giochi: " + numeroGiochi);
        System.out.println("Numero di giochi da tavolo: " + giochiDaTavolo);
        System.out.println("Numero di videogiochi: " + videoGiochi);
        System.out.println("Prezzo medio: " + prezzoMedio + "€");
    }
}
