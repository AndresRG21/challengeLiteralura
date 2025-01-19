package com.aluracursos.literalura;


import jakarta.persistence.*;

@Entity
@Table(name = "Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String autores;
    private String idiomas;
    private Integer descargas;

    public Libro(Integer numero, DatosLibro d) {

        this.titulo = d.titulo();
        this.autores = d.autores();
        this.idiomas = d.idiomas();
        this.descargas=d.descargas();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "TITULO= "+ titulo +
                "AUTOR/ES= " + autores+
                "IDIOMAS= " + idiomas +
                "TOTAL DE DESCARGAS= " + descargas;
    }


}
