import java.util.Scanner;

public class Matrice{
    public static void main(String[] args){
        
        Scanner sc = new Scanner (System.in);
        System.out.print("Inserisci numero di righe: ");
        int nRighe = sc.nextInt();          //prende in input il numero di righe

        System.out.print("Inserisci numero di colonne: ");
        int nColonne = sc.nextInt();        //prende in input il numero di colonne
        int matrix[][] = new int[nRighe][nColonne];
        for(int i = 0; i < nColonne; i++){
            for(int j = 0; j < nRighe; j++){        //scorro righe e colonne e metto nelle varie posizioni i valori della matrice
                matrix[i][j] = sc.nextInt();
                
            }

        }
        for(int i = 0; i < nColonne; i++){
            String s = "";
            for(int j = 0; j < nRighe; j++){
                
                s = s + " "+ matrix[i][j];
                
                
            }
            System.out.println("["+s+"]");      //stampo le righe dell'array e poi le accorpo creando una matrice

        }
        sc.close();
    }
}