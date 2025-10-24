package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import model.User;

public class OperacionesFicheros {

    public void lecturaFicheros(String path) {

        File file = new File(path);
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int numero;
            while ((numero = fileReader.read()) != -1) {
                System.out.print((char) numero / 9);  
            }
        } catch (IOException e ) {
            System.out.println("Error de lectura: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) fileReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }

    public void lecturaFicherosBuffer(String path) {

        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);  
            }
        } catch (IOException e ) {
            System.out.println("Error de lectura: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }

    }

    public void escrituraSimple(String path) {
        
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        }
        FileWriter fileWriter = null;
        String mensaje = "El enunciado del examen es este: la primera pregunta es XXXXX";
        try {
            fileWriter = new FileWriter(file, true);
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                fileWriter.write((int) letra * 9);
            }
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        } finally {
            try {
                if (fileWriter != null) fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }

    public void escrituraCompleja(String path) {
        
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        }

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("Esta es la primera línea ");
            printWriter.println("Esta es la segunda línea ");
        } catch (IOException e) {
            System.out.println("No hay permisos de IO");
        } finally {
            try {
                if (printWriter != null) printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }

    public void escrituraObjetos(String path) {
        
        User user1 = new User(1, "Juan", "Pérez", "juan@gmail.com", "12345678A", 600123456);
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        }

        ObjectOutputStream dos = null;

        try {
            dos = new ObjectOutputStream(new FileOutputStream(file));
            dos.writeObject(user1);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero indicado incorrecto");
        } catch (IOException e) {
            System.out.println("No puedes escribir");
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (NullPointerException | IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }

        
    }

}
