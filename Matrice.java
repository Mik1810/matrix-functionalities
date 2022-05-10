import java.util.Scanner;

public class Matrice{

    static int n;

    public static void main(String[] args){
        
        Scanner sc = new Scanner (System.in);
        System.out.print("Inserisci numero di righe: ");
        int nRows = sc.nextInt();          //prende in input il numero di righe

        System.out.print("Inserisci numero di colonne: ");
        int nColumns = sc.nextInt();        //prende in input il numero di colonne
        int matrix[][] = new int[nRows][nColumns];
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){        //scorro righe e colonne e metto nelle varie posizioni i valori della matrice
                System.out.print("Inserisci elemento a riga:"+(i+1)+" e colonna: "+(j+1)+" >>");
                matrix[i][j] = sc.nextInt();
                
                
            }

        }
        for(int i = 0; i < nRows; i++){
            String s = "";
            for(int j = 0; j < nColumns; j++){
                
                s = s + " "+ matrix[i][j];
                
            }
            System.out.println("["+s+"]");      //stampo le righe dell'array e poi le accorpo creando una matrice
        }
        n = nRows;
        sc.close();
        if(nRows == nColumns){
            System.out.println("Il determinante di questa matrice: "+det(n,matrix));
        }
    }
    public static int det(int n, int matrix[][]){   //metodo statico per il calcolo del determinante
        int det = 0;
        int[][] subMatrix = new int[n][n];
        switch(n){
            case 1: 
                return matrix[0][0];

            case 2: 
                return (matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]);
        }
        for(int i=0; i < n; i++){ //scorro le sottomatrici
             int m=0;
             for(int j=1; j < n; j++){
                  int l=0;
                  for(int k=0; k < n; k++){
                       if(k == i) continue; //questo se ci troviamo nella colonna da elimanare
                       subMatrix[m][l] = matrix[j][k];
                       l++;
                    }
                    m++;
                }
            det = (int)(det + Math.pow(-1, i) * matrix[0][i] * det(n-1,subMatrix));
        }
        return det;
        }
}