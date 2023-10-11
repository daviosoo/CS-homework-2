package org.daviosoo;

import java.util.Scanner;

public class JobAdmin {
    static Scanner input = new Scanner(System.in);

    private String name;

    private boolean alreadyHasMotherLicence = false;
    private int daysInFatherLicense = 15;
    public JobAdmin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOption () {
        int option;

        System.out.println();
        System.out.println("Bienvenido al administrador");
        System.out.println();
        System.out.println("1. Registrar día laboral");
        System.out.println("2. Solicitar permisos");
        System.out.println("3. Solicitar licencia");
        System.out.println("4. Solicitar incapacidad");
        System.out.println("5. Solicitar vacaciones");
        System.out.println();
        System.out.println("0. Salir");
        System.out.println();

        System.out.println("Ingrese una opción");
        option = input.nextInt();

        return option;
    }

    public void registerDay () {
        System.out.println("Ingrese la hora de entrada en formato 24h: ");
        int entryHour = input.nextInt();

        System.out.println("Ingrese la hora de salida en formato 24h: ");
        int outHour = input.nextInt();

        int hoursWorked = outHour - entryHour;

        if(hoursWorked < 0) {
            System.out.println("El minimo de horas posibles a registrar es de 8");
            return;
        }

        System.out.println("Se ha registrado el día de trabajo");

    }

    public void requestPermission () {
        System.out.println();
        System.out.println("Ingrese la cantidad de horas a solicitar: ");
        int hours = input.nextInt();

        if(hours < 1) {
            System.out.println();
            System.out.println("Minimo se puede solicitar 1 hora");
            return;
        }

        if(hours > 15) {
            System.out.println();
            System.out.println("Maximo se puede solicitar 15 horas");
            System.out.println("Solicite una licencia");
            return;
        }

        System.out.println();
        System.out.println("Se le ha otorgado el permiso");
    }

    public void requestInability () {
        System.out.println();
        System.out.println("Ingrese la cantidad de días a solicitar: ");
        int days = input.nextInt();

        if(days < 1) {
            System.out.println();
            System.out.println("Minimo se puede solicitar 1 día");
            return;
        }

        if(days > 20) {
            System.out.println();
            System.out.println("Maximo se puede solicitar 20 días");
            return;
        }

        System.out.println();
        System.out.println("Se le ha otorgado la incapacidad");
    }

    public void requestVacations () {
        System.out.println();
        System.out.println("Ingrese la cantidad de días a solicitar: ");
        int days = input.nextInt();

        if(days < 1) {
            System.out.println();
            System.out.println("Minimo se puede solicitar 1 día");
            return;
        }

        if(days > 15) {
            System.out.println();
            System.out.println("Maximo se puede solicitar 15 días");
            return;
        }

        System.out.println();
        System.out.println("Se le ha otorgado las vacaiones");
    }

    public void requestLicense () {
        System.out.println();
        System.out.println("Ingrese el tipo de licencia: ");
        System.out.println();
        System.out.println("1. Normal");
        System.out.println("2. Maternidad");
        System.out.println("3. Paternal");
        System.out.println();

        int licenseType = input.nextInt();

        switch (licenseType) {
            case 1:
                System.out.println();
                System.out.println("Ingrese la cantidad de horas a solicitar: ");
                int hours = input.nextInt();

                if(hours > 96) {
                    System.out.println();
                    System.out.println("Las licencias normales son maximo hasta 4 días");
                    System.out.println("Solicite vacaciones");
                    return;
                }

                System.out.println();
                System.out.println("Se ha otorgado la licencia");

                break;
            case 2:
                if(!alreadyHasMotherLicence){
                    System.out.println();
                    System.out.println("Ingrese la cantidad de días a solicitar: ");
                } else {
                    System.out.println();
                    System.out.println("Ingrese la cantidad de días a ampliar: ");
                }

                int days = input.nextInt();

                if(days < 4) {
                    System.out.println();
                    System.out.println("La licencia por maternidad debe ser minimo 4 días");
                    return;
                }

                if (days > 180) {
                    System.out.println();
                    System.out.println("La licencia por maternidad debe ser maximo 180 días");
                    return;
                }

                if(!alreadyHasMotherLicence){
                    System.out.println();
                    System.out.println("Se ha otrogado la licencia por maternidad");
                } else {
                    System.out.println();
                    System.out.println("Se ha ampliado la licencia por maternidad");
                }

                if(!alreadyHasMotherLicence) {
                    alreadyHasMotherLicence = true;
                }

                break;
            case 3:
                System.out.println();
                System.out.println("Ingrese la cantidad de días a solicitar: ");
                int daysFather = input.nextInt();

                if(daysFather < 4) {
                    System.out.println();
                    System.out.println("La licencia por paternidad debe ser minimo 4 días");
                    return;
                }

                if (daysFather > 15) {
                    System.out.println();
                    System.out.println("La licencia por paternidad debe ser maximo 180 días");
                    return;
                }

                if (daysInFatherLicense > daysFather) {
                    System.out.println();
                    System.out.println("Los días solicitados superan la cantidad de días disponibles");
                    return;
                }

                System.out.println();
                System.out.println("Se ha otrogado la licencia por paternidad");

                daysInFatherLicense -= daysFather;

                System.out.println("Quedan disponibles " +  daysInFatherLicense + " de licencia por parternidad");

                break;
            default:
                System.out.println();
                System.out.println("Tipo de licencia invalida");
                break;
        }

    }
}
