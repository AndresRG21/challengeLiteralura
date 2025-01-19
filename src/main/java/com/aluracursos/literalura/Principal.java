package com.aluracursos.literalura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibro> datosSeries = new ArrayList<>();

    private LibroRepository repositorio;
    private Optional<Libro> libroBuscado;

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Busqueda de libro por titulo
                    2 - Lista de todos los episodios
                    3 - Mostrar series buscadas
                    4 - Buscar series por titulo
                    5 - Top 5 mejores series
                    6 - Buscar series por categoria
                    7 - Filtrar series
                    8 - Buscar episodios por nombre
                    9 - Top 5 episodios por serie
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorNombre();
                    break;
                case 2:
                    mostrarTodosLosLibros();
                    break;


            }
        }

    }

    private DatosLibro getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+"));
        System.out.println(json);
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }

        private void mostrarTodosLosLibros() {
        }


        private void buscarLibroPorNombre() {
            System.out.println("ESCRIBE EL NOMBRE DE LA SERIE QUE DESEAS BUSCAR ");
            var nombreSerie = teclado.nextLine();
            libroBuscado = repositorio.findByTituloContainsIgnoreCase(nombreSerie);
            if (libroBuscado.isPresent()) {
                System.out.println("El libro buscado es: " + libroBuscado.get());
            } else {
                System.out.println("SERIE NO ENCONTRADA");
            }

        }
    }
