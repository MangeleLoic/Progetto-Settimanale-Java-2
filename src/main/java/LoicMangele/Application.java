package LoicMangele;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();
        Scanner scanner = new Scanner(System.in);

        Gioco[] giochiCollezione = {
                new GiocoDaTavolo(143567L, "Monopoly", LocalDate.of(1935, 11, 5), 20, 2, 120),
                new GiocoDaTavolo(266490L, "Dungeons & Dragons", LocalDate.of(1977, 4, 18), 30, 4, 180),
                new GiocoDaTavolo(577390L, "Risiko", LocalDate.of(1957, 6, 15), 25, 4, 180),
                new VideoGioco(564832L,"Fifa23", LocalDate.of(2022,9,27),59, "PS5",1,Genere.SPORT),
                new VideoGioco(656432L,"Call of Duty: Modern Warfare II ", LocalDate.of(2009,11,10),119, "Xbox",3,Genere.GUERRA),
                new GiocoDaTavolo(878390L, "Uno", LocalDate.of(1971, 1, 31), 15, 2, 10),
                new VideoGioco(886415L,"Call of Duty: Vanguard ", LocalDate.of(2021,11,5),89, "PC",3,Genere.GUERRA),
        };

        boolean exit = false;

        while (!exit) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi Gioco");
            System.out.println("2. Cerca Gioco per ID");
            System.out.println("3. Cerca Giochi per Prezzo");
            System.out.println("4. Cerca Giochi da Tavolo per Numero Giocatori");
            System.out.println("5. Rimuovi Gioco");
            System.out.println("6. Visualizza Statistiche");
            System.out.println("7. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    aggiungiGioco(collezione, scanner);
                    break;
                case 2:
                    cercaGiocoPerId(collezione, scanner);
                    break;
                case 3:
                    cercaGiochiPerPrezzo(collezione, scanner);
                    break;
                case 4:
                    cercaGiochiPerNumeroGiocatori(collezione, scanner);
                    break;
                case 5:
                    rimuoviGioco(collezione, scanner);
                    break;
                case 6:
                    collezione.visualizzaStatistiche();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }


    private static void aggiungiGioco(Collezione collezione, Scanner scanner) {
        try {
            System.out.println("Inserisci ID:");
            Long id = scanner.nextLong();
            scanner.nextLine();
            System.out.println("Inserisci Titolo:");
            String titolo = scanner.nextLine();
            System.out.println("Inserisci Anno di Pubblicazione (YYYY-MM-DD):");
            LocalDate anno = LocalDate.parse(scanner.nextLine());
            System.out.println("Inserisci Prezzo:");
            int prezzo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("È un gioco da tavolo? (sì/no)");
            String isGiocoDaTavolo = scanner.nextLine();

            if (isGiocoDaTavolo.equalsIgnoreCase("sì")) {
                System.out.println("Inserisci Numero di Giocatori:");
                int numGiocatori = scanner.nextInt();
                System.out.println("Inserisci Durata Partita (in minuti):");
                int durataPartita = scanner.nextInt();
                scanner.nextLine();
                collezione.aggiungiGioco(new GiocoDaTavolo(id, titolo, anno, prezzo, numGiocatori, durataPartita));
            } else {
                System.out.println("Inserisci Piattaforma:");
                String piattaforma = scanner.nextLine();
                System.out.println("Inserisci Numero di Giocatori:");
                int numGiocatori = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci Genere (SPORT/GUERRA/AVVENTURA/MMORPG/SURVIVAL):");
                String genereStr = scanner.nextLine();
                Genere genere = Genere.valueOf(genereStr.toUpperCase());
                collezione.aggiungiGioco(new VideoGioco(id, titolo, anno, prezzo, piattaforma, numGiocatori, genere));
            }

            System.out.println("Gioco aggiunto con successo.");
        } catch (Exception e) {
            System.out.println("Errore nell'aggiunta del gioco: " + e.getMessage());
        }
    }


    private static void cercaGiocoPerId(Collezione collezione, Scanner scanner) {
        System.out.println("Inserisci l'ID del gioco da cercare:");
        Long idRicerca = scanner.nextLong();
        Optional<Gioco> gioco = collezione.ricercaPerId(idRicerca);
        if (gioco.isPresent()) {
            System.out.println(gioco.get());
        } else {
            System.out.println("Gioco non trovato.");
        }
    }


    private static void cercaGiochiPerPrezzo(Collezione collezione, Scanner scanner) {
        System.out.println("Inserisci il prezzo massimo:");
        int prezzo = scanner.nextInt();
        collezione.ricercaPerPrezzo(prezzo).forEach(System.out::println);
    }


    private static void cercaGiochiPerNumeroGiocatori(Collezione collezione, Scanner scanner) {
        System.out.println("Inserisci il numero di giocatori:");
        int numeroGiocatori = scanner.nextInt();
        collezione.ricercaPerNumeroGiocatori(numeroGiocatori).forEach(System.out::println);
    }


    private static void rimuoviGioco(Collezione collezione, Scanner scanner) {
        System.out.println("Inserisci l'ID del gioco da rimuovere:");
        Long idDaRimuovere = scanner.nextLong();
        if (collezione.rimuoviGioco(idDaRimuovere)) {
            System.out.println("Gioco rimosso con successo.");
        } else {
            System.out.println("Gioco non trovato.");
        }
    }
}
