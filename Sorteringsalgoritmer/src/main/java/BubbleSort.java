// This kode example is taken from https://www.javatpoint.com/bubble-sort-in-java
public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        int count = 0;
        boolean flag = true;

        //kører antal tal i arrayet
        for(int i=0; i < n && flag; i++){
            flag = false;
            count++;
            //andet loop kører 1 gang mindre for hver sortering
            for(int j=1; j < (n-i); j++){
                //hvis første tal er lavere end andet
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }

            }
        } System.out.println("\nSorteringsalgoritmen kører i alt: " + count + " gange\n");
    }
    public static void main(String[] args) {
        int[] arr = { 2, 6, 3, 5, 1, 7, 4, 5, 6, 4, 3, 5, 6, 2, 1, 6, 102, 392, 12};


        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();
        bubbleSort(arr);//sorting array elements using bubble sort
        long endTime = System.nanoTime();

        System.out.println("Array After Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println();
        System.out.println("tid: " + duration);

    }
}
