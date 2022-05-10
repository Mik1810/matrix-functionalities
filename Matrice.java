import java.util.Scanner;

public class Matrice{
    public static void main(String[] args){
        
        Scanner sc = new Scanner (System.in);
        System.out.print("Inserisci numero di righe: ");
        int nRighe = sc.nextInt();          //prende in input il numero di righe

        System.out.print("Inserisci numero di colonne: ");
        int nColonne = sc.nextInt();        //prende in input il numero di colonne
        int matrix[][] = new int[nRighe][nColonne];
        for(int i = 0; i < nRighe; i++){
            for(int j = 0; j < nColonne; j++){        //scorro righe e colonne e metto nelle varie posizioni i valori della matrice
                System.out.print("Inserisci elemento a riga:"+(i+1)+" e colonna: "+(j+1)+" >>");
                matrix[i][j] = sc.nextInt();
                
                
            }

        }
        for(int i = 0; i < nRighe; i++){
            String s = "";
            for(int j = 0; j < nColonne; j++){
                
                s = s + " "+ matrix[i][j];
                
                
            }
            System.out.println("["+s+"]");      //stampo le righe dell'array e poi le accorpo creando una matrice

        }
        sc.close();
    }
}