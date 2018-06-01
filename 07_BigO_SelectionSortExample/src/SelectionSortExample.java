public class SelectionSortExample {
    public static void selectionSort(int[] n){
        for (int i = 0; i < n.length - 1; i++)
        {
            int index = i; // Dette er mark�rens position til at starte med
            for (int j = i + 1; j < n.length; j++){
                if (n[j] < n[index]){
                    index = j; // Looper igennem arrayet, finder laveste tals position og inds�tter
                }
            }
            int smallerNumber = n[index]; // Gemmer laveste tal i en temp variabel
            n[index] = n[i]; // Flytter tallet fra mark�rens plads over p� laveste tals position
            n[i] = smallerNumber; // Flytter laveste tal over p� f�rste usorterede position
            System.out.println("\nArrayet er nu loopet igennem, startende fra postion " + i + ". Laveste tal (" + smallerNumber + ") bliver placeret i position " + i + " (bytter plads med " + n[index] + "), og mark�ren rykker en frem.");
            for(int num:n){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static void main(String a[]){
        int[] n = {9,14,3,2,43,11,58,22};
        System.out.println("Arrayet f�r vi starter:");
        for(int i:n){
            System.out.print(i+" ");
        }
        System.out.println("\n-----");

        selectionSort(n);//sorting array using selection sort

        System.out.println("\nArrayet er nu sorteret:");
        for(int num:n){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}