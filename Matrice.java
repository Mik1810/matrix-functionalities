import java.util.Scanner;

public class Matrice {

    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Insert number of rows: ");
        int nRows = sc.nextInt(); // prende in input il numero di righe

        System.out.print("Insert number of columns: ");
        int nColumns = sc.nextInt(); // prende in input il numero di colonne

        System.out.print("Enter the degree of tolerance for the decimal digits (from 1 to 6): " );
        int decimalDigits = sc.nextInt();
        int matrix[][] = new int[nRows][nColumns];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) { // scorro righe e colonne e metto nelle varie posizioni i valori della matrice
                System.out.print("Insert element at row: " + (i + 1) + " and column: " + (j + 1) + " >>");
                matrix[i][j] = sc.nextInt();
            }
        }

        /*Matrix displayer with integer values */

        for (int i = 0; i < nRows; i++) {
            String s = "";
            for (int j = 0; j < nColumns; j++) {
                if (matrix[i][j] >= 0) {
                    s = s + "  " + matrix[i][j]; // per l'indentazione
                } else {
                    s = s + " " + matrix[i][j];
                }

            }
            System.out.println("[" + s + " ]"); // stampo le righe dell'array e poi le accorpo creando una matrice
        }
        /*Matrix displayer with double values */

        double[][] formattedMatrix = new double[nRows][nColumns];   //metodo riduzione a gradini

        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){
                formattedMatrix[i][j] = matrix[i][j];   //matrice di double per valori non interi
            }
        } 
        
        for(int i = 0; i < nRows; i++){
           double f = 1.0;
            for(int j = 0; j < nColumns; j++){
                if(j == 0) f = formattedMatrix[i][0];
                formattedMatrix[i][j] = formattedMatrix[i][j] / f;
            }

        }
        for (int i = 0; i < nRows; i++) {
            String s = "";
            for (int j = 0; j < nColumns; j++) {
                switch(decimalDigits){
                    case 1:
                        if (formattedMatrix[i][j] >= 0) {
                            s = s + "  " + String.format("%.1f", formattedMatrix[i][j]); // per l'indentazione
                        } else {
                            s = s + " " + String.format("%.1f", formattedMatrix[i][j]);
                        }break;
                    case 2: 
                        if (formattedMatrix[i][j] >= 0) {
                            s = s + "  " + String.format("%.2f", formattedMatrix[i][j]); // per l'indentazione
                        } else {
                            s = s + " " + String.format("%.2f", formattedMatrix[i][j]);
                        }break;
                    case 3:
                        if (formattedMatrix[i][j] >= 0) {
                            s = s + "  " + String.format("%.3f", formattedMatrix[i][j]); 
                        } else {
                            s = s + " " + String.format("%.3f", formattedMatrix[i][j]);
                        }break;
                    case 4:
                        if (formattedMatrix[i][j] >= 0) {
                            s = s + "  " + String.format("%.4f", formattedMatrix[i][j]); 
                        } else {
                            s = s + " " + String.format("%.4f", formattedMatrix[i][j]);
                        }break;
                    case 5:
                        if (formattedMatrix[i][j] >= 0) {
                            s = s + "  " + String.format("%.5f", formattedMatrix[i][j]); 
                        } else {
                            s = s + " " + String.format("%.5f", formattedMatrix[i][j]);
                        }break;
                    default:
                        if (formattedMatrix[i][j] >= 0) {
                            s = s + "  " + String.format("%.6f", formattedMatrix[i][j]); 
                        } else {
                            s = s + " " + String.format("%.6f", formattedMatrix[i][j]);
                        }break;
                }
            }
            System.out.println("[" + s + " ]"); // stampo le righe dell'array e poi le accorpo creando una matrice
        }
        n = nRows;      //duplicated value for the matrix calculation method

        sc.close();

        /*check on the calculation of the determinant */

        if (nRows == nColumns) {    
            System.out.println("The determinant of the matrix is: " + det(n, matrix));
        }
    } //close the main method

    public static int det(int n, int matrix[][]) { // static method to calculate the determinant
        int det = 0;
        int[][] subMatrix = new int[n][n];
        switch(n){
            case 1: 
                return matrix[0][0];

            case 2: 
                return (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);

            default:
                for (int i = 0; i < n; i++) { // fisso la riga
                    int m = 0;
                    for (int j = 1; j < n; j++) {   //fisso la colonna
                        int l = 0;
                        for (int k = 0; k < n; k++) {   //scorro l'elemento 
                            if (k == i)
                                continue;
                            subMatrix[m][l] = matrix[j][k];
                            l++;
                        }
                        m++;
                    }
                    det = (int) (det + Math.pow(-1, i) * matrix[0][i] * det(n - 1, subMatrix));
                }
            return det;
        }
    } //close the method
}