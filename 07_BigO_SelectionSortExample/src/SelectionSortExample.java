public class SelectionSortExample {
    public static void selectionSort(int[] arrayToSort){
        for (int i = 0; i < arrayToSort.length - 1; i++)
        {
            int cursor = i; // Dette er markørens position til at starte med

            //Finder laveste tals position og indsætter
            for (int j = i + 1; j < arrayToSort.length; j++){
                if (arrayToSort[j] < arrayToSort[cursor]){
                    cursor = j;
                }
            }

            int smallestNumberTemp = arrayToSort[cursor]; // Gemmer laveste tal i en temp variabel
            arrayToSort[cursor] = arrayToSort[i]; // Flytter tallet fra markørens plads over på laveste tals position
            arrayToSort[i] = smallestNumberTemp; // Flytter laveste tal over på første usorterede position
            System.out.println("\nArrayet er nu loopet igennem, startende fra postion "
                    + i + ". Laveste tal (" + smallestNumberTemp
                    + ") bliver placeret i position " + i
                    + " (bytter plads med " + arrayToSort[cursor]
                    + "), og markøren rykker en frem.");

            for(int num:arrayToSort){
                System.out.print(num+" ");
            }

            System.out.println();
        }
    }

    public static void main(String a[]){
        int[] n = {9,14,3,2,43,11,58,22};

        System.out.println("Arrayet før vi starter:");

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