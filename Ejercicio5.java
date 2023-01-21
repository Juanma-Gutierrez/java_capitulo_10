
/**
 * Ejercicio5.java
 *
 * @version: 27/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Realiza de nuevo el ejercicio de la colección de discos pero utilizando esta
 * vez una lista para almacenar la información sobre los discos en lugar de un
 * array convencional. Comprobarás que el código se simplifica notablemente
 * ¿Cuánto ocupa el programa original hecho con un array? ¿Cuánto ocupa este
 * nuevo programa hecho con una lista?
 */
import java.util.ArrayList;
import java.util.Scanner;

import Ejercicio5.Disk;

public class Ejercicio5 {
    public static void main(String[] args) {
        // Var declarations
        ArrayList<Disk> collection;
        int option;

        // Var init
        collection = new ArrayList<Disk>();

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Process
        collection = createBase(collection);

        do {
            option = 0;
            option = printMenu(sc, collection);
        } while (option != 9);

        // Close scanner
        sc.close();
    }

    public static int printMenu(Scanner sc, ArrayList<Disk> collection) {
        // Var declaration
        int option;

        clearScreen();
        System.out.println("***********************");
        System.out.println("* COLECCIÓN DE DISCOS *");
        System.out.println("***********************");
        System.out.println("* 1. Crear Disco      *");
        System.out.println("* 2. Modificar Disco  *");
        System.out.println("* 3. Borrar Disco     *");
        System.out.println("* 4. Listar colección *");
        System.out.println("*                     *");
        System.out.println("* 9. Salir            *");
        System.out.println("***********************");
        option = sc.nextInt();
        switch (option) {
            case 1:
                createDisk(collection, sc);
                break;
            case 2:
                menuModifyDisk(collection, sc);
                break;
            case 3:
                menuDeleteDisk(collection, sc);
                break;
            case 4:
                listCollection(collection, sc);
                break;
        }
        return option;
    }

    public static ArrayList<Disk> createDisk(ArrayList<Disk> collection, Scanner sc) {
        clearScreen();
        sc.nextLine();
        System.out.println("***********************");
        System.out.println("*     CREAR DISCO     *");
        System.out.println("***********************");
        addDisk(collection, sc);
        return (collection);
    }

    public static ArrayList<Disk> menuModifyDisk(ArrayList<Disk> collection, Scanner sc) {
        int code;
        clearScreen();
        sc.nextLine();
        System.out.println("***********************");
        System.out.println("*   MODIFICAR DISCO   *");
        System.out.println("***********************");
        System.out.println();
        System.out.print("Introduce el código del disco: ");
        code = sc.nextInt();
        collection = modifyDisk(code, collection, sc);
        return (collection);
    }

    public static ArrayList<Disk> menuDeleteDisk(ArrayList<Disk> collection, Scanner sc) {
        int code;
        clearScreen();
        sc.nextLine();
        System.out.println("***********************");
        System.out.println("*    BORRAR DISCO     *");
        System.out.println("***********************");
        System.out.println();
        System.out.print("Introduce el código del disco: ");
        code = sc.nextInt();
        collection = deleteDisk(code, collection, sc);
        return (collection);
    }

    public static ArrayList<Disk> addDisk(ArrayList<Disk> collection, Scanner sc) {
        String author;
        String title;
        String genre;
        int duration;
        System.out.print("Introduce el autor del disco: ");
        author = sc.nextLine();
        System.out.print("Introduce el título del disco: ");
        title = sc.nextLine();
        System.out.print("Introduce el género del disco: ");
        genre = sc.nextLine();
        System.out.print("Introduce la duración del disco: ");
        duration = sc.nextInt();
        Disk disk = new Disk(author, title, genre, duration);
        collection.add(disk);
        sc.nextLine();
        pause("Disco grabado correctamente", sc);
        return collection;
    }

    public static ArrayList<Disk> modifyDisk(int code, ArrayList<Disk> collection, Scanner sc) {
        boolean find = false;
        boolean confirm = false;
        for (Disk disk : collection) {
            String author;
            String title;
            String genre;
            int duration;
            if (disk.getCode() == code) {
                find = true;
                Disk modifiedDisk = disk;
                System.out.println(disk);
                System.out.println("\nIntroduce las modificaciones que precises:");
                System.out.print("Autor (enter para no modificar): " + disk.getAuthor() + ": ");
                sc.nextLine(); // limpieza del buffer
                author = sc.nextLine();
                if (author == "")
                    author = disk.getAuthor();
                System.out.print("Título (enter para no modificar): " + disk.getTitle() + ": ");
                title = sc.nextLine();
                if (title == "")
                    title = disk.getTitle();
                System.out.print("Género (enter para no modificar): " + disk.getGenre() + ": ");
                genre = sc.nextLine();
                if (genre == "")
                    genre = disk.getGenre();
                System.out.print("Duración: " + disk.getDuration() + ": ");
                duration = sc.nextInt();
                modifiedDisk.setCode(disk.getCode());
                modifiedDisk.setAuthor(author);
                modifiedDisk.setTitle(title);
                modifiedDisk.setGenre(genre);
                modifiedDisk.setDuration(duration);
                confirm = confirm("modificar", modifiedDisk, sc);
                if (confirm) {
                    disk = modifiedDisk;
                    sc.nextLine();
                    pause("Modificación realizada correctamente", sc);
                } else {
                    sc.nextLine();
                    pause("Modificación cancelada", sc);
                }
            }
        }
        if (!find) {
            sc.nextLine();
            pause("No se ha encontrado el disco con el código indicado", sc);
        }
        return collection;
    }

    public static ArrayList<Disk> deleteDisk(int code, ArrayList<Disk> collection, Scanner sc) {
        boolean confirm = false;
        boolean find = false;
        for (Disk disk : collection) {
            if (disk.getCode() == code && disk.getAuthor() != null) {
                find = true;
                confirm = confirm("eliminar", disk, sc);
                if (confirm) {
                    collection.remove(disk);
                    sc.nextLine();
                    pause("Disco eliminado correctamente", sc);
                    break;
                } else {
                    sc.nextLine();
                    pause("Eliminación de disco cancelada", sc);
                }
            }
        }
        if (!find) {
            sc.nextLine();
            pause("No se ha encontrado el registro indicado", sc);
        }
        return collection;
    }

    public static void listCollection(ArrayList<Disk> collection, Scanner sc) {
        int option;
        boolean find = false;
        clearScreen();
        System.out.println("**************************");
        System.out.println("*    LISTAR COLECCIÓN    *");
        System.out.println("**************************");
        System.out.println("* 1. Listado completo    *");
        System.out.println("* 2. Listar por autor    *");
        System.out.println("* 3. Listar por género   *");
        System.out.println("* 4. Listar por duración *");
        System.out.println("*                        *");
        System.out.println("* 9. Salir               *");
        System.out.println("**************************");
        option = sc.nextInt();
        switch (option) {
            case 1:
                clearScreen();
                for (Disk disk : collection)
                    System.out.print(disk);
                sc.nextLine();
                pause("", sc);
                break;
            case 2:
                String author;
                System.out.print("Introduce el autor: ");
                sc.nextLine();
                author = sc.nextLine();
                clearScreen();
                for (Disk disk : collection)
                    if (disk.getAuthor().equals(author)) {
                        System.out.print(disk);
                        find = true;
                    }
                if (find)
                    pause("", sc);
                else
                    pause("No se ha encontrado ningún disco de: " + author, sc);
                break;
            case 3:
                String genre;
                System.out.print("Introduce el género: ");
                sc.nextLine();
                genre = sc.nextLine();
                clearScreen();
                for (Disk disk : collection)
                    if (disk.getGenre().equals(genre)) {
                        System.out.print(disk);
                        find = true;
                    }
                if (find)
                    pause("", sc);
                else
                    pause("No se ha encontrado ningún disco del género: " + genre, sc);
                break;
            case 4:
                int min;
                int max;
                sc.nextLine();
                System.out.print("Introduce la duración mínima: ");
                min = sc.nextInt();
                System.out.print("Introduce la duración máxima: ");
                max = sc.nextInt();
                clearScreen();
                for (Disk disk : collection)
                    if (disk.getDuration() >= min && disk.getDuration() <= max) {
                        System.out.print(disk);
                        find = true;
                    }
                sc.nextLine();
                if (find)
                    pause("", sc);
                else {
                    pause("No se ha encontrado ningún disco en ese rango de duración.", sc);
                }
                break;
        }
    }

    public static ArrayList<Disk> createBase(ArrayList<Disk> collection) {
        String[] author = { "Metallica", "The Doors", "Queen", "ACDC" };
        String[] title = { "The black album", "Riders on the storm", "Bohemian Rhapsody", "Thunderstruck" };
        String[] genre = { "Rock", "Rock", "Rock sinfónico", "Rock" };
        int[] duration = { 63, 72, 55, 58 };
        for (int i = 0; i < 4; i++) {
            Disk disk = new Disk(author[i], title[i], genre[i], duration[i]);
            collection.add(disk);
        }
        return collection;
    }

    public static boolean confirm(String process, Disk disk, Scanner sc) {
        String res;
        System.out.println("Se va a " + process + " el siguiente registro:");
        System.out.println(disk);
        System.out.print("¿Está seguro? (s/n): ");
        res = sc.next();
        if (res.equals("s") || res.equals("S")) {
            return true;
        } else {
            return false;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void pause(String phrase, Scanner sc) {
        String y = "\033[0;33m";
        String r = "\033[0m";
        System.out.println("\n" + phrase);
        System.out.println(y + "\nPulse una tecla para continuar" + r);
        sc.nextLine();
    }
}
