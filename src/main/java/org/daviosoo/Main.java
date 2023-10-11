package org.daviosoo;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Ingrese el nombre del empleado: ");
        String name = input.next();

        JobAdmin jobAdmin = new JobAdmin(name);

        int option = 9999;

        while( option != 0 ) {

            option = jobAdmin.getOption();

            switch (option) {
                case 1:
                    jobAdmin.registerDay();
                    break;
                case 2:
                    jobAdmin.requestPermission();
                    break;
                case 3:
                    jobAdmin.requestLicense();
                    break;
                case 4:
                    jobAdmin.requestInability();
                    break;
                case 5:
                    jobAdmin.requestVacations();
                    break;
                case 0:
                    System.out.println("Finalizando");
                    break;
                default:
                    System.out.println("La opción no es valida");
                    break;
            }
        }
    }
}