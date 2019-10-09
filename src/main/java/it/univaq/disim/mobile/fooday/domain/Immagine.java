package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.*;
import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "immagini")
public class Immagine {

    @Id
    @GeneratedValue
    @Column(name = "ID_IMMAGINE", nullable = false)
    private Long id;

    @Column(name = "SRC", nullable = false)
    private String src;
    
    @Column(name = "FILE")
    @Lob
    private byte[] file;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE")
    private Ristorante ristorante;

    public Immagine() {
    }

    public Immagine(String src, Ristorante ristorante) throws IOException {
        this.src = src;
        this.ristorante = ristorante;
        this.file = getImmagine(src);
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String nome) {
        this.src = nome;
    }

    public byte[] getImmagine(String filePathStr) throws IOException {
        // get path object pointing to fil
        Path filePath = Paths.get(filePathStr);
        // get byte array with file contents
        byte[] fileContent = Files.readAllBytes(filePath);
        return fileContent;
    }
    
    public byte[] getFile() {
        return Base64.encodeBase64(file);
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
