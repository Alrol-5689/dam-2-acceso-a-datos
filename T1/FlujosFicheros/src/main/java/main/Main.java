package main;

import controller.OperacionesFicheros;

public class Main {
    public static void main(String[] args) {
        
        OperacionesFicheros operaciones = new OperacionesFicheros();

        var pathEjemplo = "src/main/resources/ficheros/ejemplo.txt";
        var pathEscritura = "src/main/resources/ficheros/escritura.txt";
        var pathEscrituraBuffer =  "src/main/resources/ficheros/escrituraBuffer.txt";
        var pathEscrituraObjetos = "src/main/resources/ficheros/escrituraObjetos.obj";

//         Primera lectura s
//
//         operaciones.lecturaFicheros(pathEjemplo);
//         operaciones.lecturaFicherosBuffer(pathEjemplo);
//
//         Escritura

//         operaciones.escrituraSimple(pathEscritura);
//         operaciones.escrituraCompleja(pathEscrituraBuffer);
//         operaciones.escrituraObjetos(pathEscrituraObjetos);
        operaciones.escrituraObjetosMultiple(pathEscrituraObjetos);


//         Segunda lectura

         operaciones.lecturaObjeto2(pathEscrituraObjetos);
//         operaciones.lecturaFicheros(pathEscritura);
//         operaciones.lecturaFicherosBuffer(pathEjemplo);
        
    }
}