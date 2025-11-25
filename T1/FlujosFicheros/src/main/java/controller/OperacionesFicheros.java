package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class OperacionesFicheros {

    public void lecturaFicheros(String path) {

        File file = new File(path);

        try (FileReader fileReader = new FileReader(file)) {
            try {
                int numero;
                while ((numero = fileReader.read()) != -1) {
                    System.out.print((char) (numero / 9));
                }
            } catch (IOException e) {
                System.out.println("Error de lectura: " + e.getMessage());
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error al cerrar el fichero: " + e.getMessage());
        }
    }

    public void lecturaFicherosBuffer(String path) {

        File file = new File(path);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            try {
                String linea = null;
                while ((linea = bufferedReader.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error de lectura: " + e.getMessage());
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error al cerrar el fichero: " + e.getMessage());
        }

    }

    public void escrituraSimple(String path) {
        
        File file = new File(path);
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        }
        String mensaje = "escrituraSimple() en escritura.txt";
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            try {
                for (int i = 0; i < mensaje.length(); i++) {
                    char letra = mensaje.charAt(i);
                    fileWriter.write((int) (letra * 9));
                }
            } catch (IOException e) {
                System.out.println("Error de escritura: " + e.getMessage());
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error al cerrar el fichero: " + e.getMessage());
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
        
        User user1 = new User(
                1,
                "Juan",
                "Pérez",
                "juan@gmail.com",
                "12345678A",
                600123456);

        File file = new File(path);

        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero");
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

    public void escrituraObjetosMultiple(String path) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"Juan1","Pérez","juan@gmail.com",600123456));
        users.add(new User(2,"Juan2","Pérez","juan@gmail.com",600123456));
        users.add(new User(3,"Juan3","Pérez","juan@gmail.com",600123456));
        users.add(new User(4,"Juan4","Pérez","juan@gmail.com",600123456));
        users.add(new User(5,"Juan5","Pérez","juan@gmail.com",600123456));
        File file = new File(path);
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero");
            }
        }
        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(new FileOutputStream(file));
            dos.writeObject(users);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero indicado incorrecto");
        } catch (IOException e) {
            System.out.println("No puedes escribir");
        }
    }

    public void lecturaObjeto2(String path) {
        File file = new File(path);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            try {
                ArrayList<User> users = (ArrayList<User>) ois.readObject();
                for (User u : users) {
                    System.out.println(u);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el fichero");
            }
        } catch (IOException e) {
            System.out.println("Error al cerrar el fichero");
        }


    }

}
