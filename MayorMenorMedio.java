import java.util.Scanner;

public class MayorMenorMedio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nNumeros = 0;

        System.out.println("Cuantos numeros desea ingresar? (2 - 6)");
        while (nNumeros < 2 || nNumeros > 6) {
            nNumeros = scanner.nextInt();
            if (nNumeros < 2 || nNumeros > 6) {
                System.out.println("Error, ingrese nuevamente:");
            }
        }

        int n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0, tmp = 0;

        System.out.println("Ingrese los numeros:");
        n1 = scanner.nextInt();
        tmp = n1;
        n2 = scanner.nextInt();
        if (n2 < tmp) {
            n1 = n2;
            n2 = tmp;
        }
        tmp = n2;
        n3 = (nNumeros > 2) ? scanner.nextInt() : 0;
        if (n3 < tmp && nNumeros > 2) {
            n2 = n3;
            n3 = tmp;
            if (n2 < n1) {
                tmp = n1;
                n1 = n2;
                n2 = tmp;
            }
        }
        tmp = n3;
        n4 = (nNumeros > 3) ? scanner.nextInt() : 0;
        if (n4 < tmp && nNumeros > 3) {
            n3 = n4;
            n4 = tmp;
            if (n3 < n2) {
                tmp = n2;
                n2 = n3;
                n3 = tmp;
                if (n2 < n1) {
                    tmp = n1;
                    n1 = n2;
                    n2 = tmp;
                }
            }
        }
        tmp = n4;
        n5 = (nNumeros > 4) ? scanner.nextInt() : 0;
        if (n5 < tmp && nNumeros > 4) {
            n4 = n5;
            n5 = tmp;
            if (n4 < n3) {
                tmp = n3;
                n3 = n4;
                n4 = tmp;
                if (n3 < n2) {
                    tmp = n2;
                    n2 = n3;
                    n3 = tmp;
                    if (n2 < n1) {
                        tmp = n1;
                        n1 = n2;
                        n2 = tmp;
                    }
                }
            }
        }
        tmp = n5;
        n6 = (nNumeros > 5) ? scanner.nextInt() : 0;
        if (n6 < tmp && nNumeros > 5) {
            n5 = n6;
            n6 = tmp;
            if (n5 < n4) {
                tmp = n4;
                n4 = n5;
                n5 = tmp;
                if (n4 < n3) {
                    tmp = n3;
                    n3 = n4;
                    n4 = tmp;
                    if (n3 < n2) {
                        tmp = n2;
                        n2 = n3;
                        n3 = tmp;
                        if (n2 < n1) {
                            tmp = n1;
                            n1 = n2;
                            n2 = tmp;
                        }
                    }
                }
            }
        }
        scanner.close();

        int maximo = 0;
        if (nNumeros == 6) {
            maximo = n6;
        } else if (nNumeros == 5) {
            maximo = n5;
        } else if (nNumeros == 4) {
            maximo = n4;
        } else if (nNumeros == 3) {
            maximo = n3;
        } else if (nNumeros == 2) {
            maximo = n2;
        }
        int minimo = n1;
        int mediana = 0;

        if (nNumeros == 2) {
            mediana = (n1 + n2) / 2;
        }
        else if (nNumeros == 3) {
            mediana = n2;
        }
        else if (nNumeros == 4) {
            mediana = (n2 + n3) / 2;
        }
        else if (nNumeros == 5) {
            mediana = n3;
        }
        else if (nNumeros == 6) {
            mediana = (n3 + n4) / 2;
        }    
        
        System.out.println("Maximo: " + maximo);
        System.out.println("Minimo: " + minimo);
        System.out.println("Mediana: " + mediana);
    }
}