package it.stopcode.api_bibilioteca.model;

import java.time.LocalDate;
import java.util.Date;

public class Book {

    private String id;
    private String title;
    private String author;
    private LocalDate publishYear;
    // Il formato da mettere sul JSON solo per la data è YYYY-MM-DD
    /* NOTA:
    *  Analizzando i due tipi di data, la scelta migliore è LocalDate poiché sulla risposta del POST mostra soltanto la data messa da input, mentre
    *  sulla risposta del POST di util.Date mostra la data precisa con l'ora, i minuti ed i secondi
    *  (o solo i millisecondi non convertiti in data)
    * */

    public String getId() {
        return id;
    }

    // Da mettere nel controller o service: String requestId = UUID.randomUUID().toString();

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDate publishYear) {
        this.publishYear = publishYear;
    }
}
