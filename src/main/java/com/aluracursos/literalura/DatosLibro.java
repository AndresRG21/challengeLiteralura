package com.aluracursos.literalura;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") String autores,
                         @JsonAlias("languages") String idiomas,
                         @JsonAlias("download_count") Integer descargas) {
}
