package main;

import controller.OperacionesFicheros;

public class Main {
    public static void main(String[] args) {
        
        OperacionesFicheros operaciones = new OperacionesFicheros();

        var pathEjemplo = "src/main/resources/ficheros/ejemplo.txt";
        var pathEscritura = "src/main/resources/ficheros/escritura.txt";
        var pathEscrituraBuffer =  "src/main/resources/ficheros/escrituraBuffer.txt";
        var pathEscrituraObjetos = "src/main/resources/ficheros/escrituraObjetos.obj";

        // Primera lectura s

        // operaciones.lecturaFicheros("src/main/resources/ficheros/escritura.txt");
        // operaciones.lecturaFicherosBuffer("src/main/resources/ficheros/ejemplo.txt");

        // Escritura

        operaciones.escrituraSimple("src/main/resources/ficheros/escritura.txt");
        // operaciones.escrituraCompleja("src/main/resources/ficheros/escrituraBuffer.txt");
        // operaciones.escrituraObjetos("src/main/resources/ficheros/escrituraObjetos.obj");

        // Segunda lectura

        operaciones.lecturaFicheros("src/main/resources/ficheros/escritura.txt");
        // operaciones.lecturaFicherosBuffer("src/main/resources/ficheros/ejemplo.txt");
        
    }
}