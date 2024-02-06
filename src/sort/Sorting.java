package sort;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void bogoSort(int [] array){
        int count = 0;
        boolean isSorted = false;
        while(!isSorted){
            shuffle(array);
            isSorted = true;
            for(int i = 0; i < array.length -1 ; i++){
                if(array[i] > array[i+1]){
                    isSorted = false;
                    break;
                }
            }
            count++;
            System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array) + " \t Anzahl trys: " +count);
    }


    private static void shuffle(int[] a){
        Random r = new Random();
        int tmp = 0;
        for(int i = 0 ; i < a.length; i++){
            int nextI = r.nextInt(0, a.length -1);
            tmp = a[i];
            a[i] = a[nextI];
            a[nextI] = tmp;
        }
    }





    public static int[] mergeSort(int[] array){
        if(array == null){
            throw new IllegalArgumentException();
        }
        if(array.length == 1 || array.length == 0){
            return array;
        }

        int middle = array.length / 2;

        int[] leftSorted = mergeSort(Arrays.copyOfRange(array, 0, middle));
        int[] rightSorted = mergeSort(Arrays.copyOfRange(array, middle, array.length));

        return mergeSort(leftSorted,rightSorted);

    }

    private static int[] mergeSort(int[] array1, int [] array2){

        int[] merged = new int[array1.length + array2.length];
        int pos = 0;
        int posFirst = 0;
        int posScnd = 0;

        while ((posFirst < array1.length) && (posScnd < array2.length)){
            if(array1[posFirst] < array2[posScnd]){
                merged[pos++] = array1[posFirst++];
            }else{
                merged[pos++] = array2[posScnd++];
            }
        }

        while (posFirst < array1.length){
            merged[pos++] = array1[posFirst++];
        }

        while (posScnd < array2.length){
            merged[pos++] = array2[posScnd++];
        }
        return merged;
    }


    public static void stoogeSort(int[] array){
        if(array.length == 1 || array.length ==0){
            return;
        }
        if(array.length == 2){
            if(array[0] > array[1]){
                swap(array, 0,1);
            }
            return;
        }
        stoogeSort(array, 0, array.length);
    }

    private static void stoogeSort(int[] array, int from, int to){
        int l = to - from;
        if(l == 2 && array[from] > array[from+1]){
            int tmp = array[from];
            array[from] = array[from + 1];
            array[from+1] = tmp;
        }
        if(l <= 2){
            return;
        }

        int third = from + l / 3;
        int tthird = to - l / 3;

        stoogeSort(array, from, tthird);
        stoogeSort(array,third, to);
        stoogeSort(array, from, tthird);
    }

    public static void selectionSort(int[] array){
        selectionSort(array, array.length -1);
    }

    private static void selectionSort(int[] array, int to){
        if(to < 1){
            return;
        }
        int indMax = -1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= to; i++){
            if(array[i] > max){
                indMax = i;
                max = array[i];
            }
        }
        if(indMax == -1){
            return;
        }

        array[indMax] = array[to];
        array[to] = max;

        selectionSort(array, to - 1);

    }



    private static void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }



    public static void main(String[] args){
        Random r = new Random();
        int[] ints = new int[5];
        for(int i = 0; i < ints.length; i++){
            ints[i] = r.nextInt(0, 20);
        }

        //System.out.println(Arrays.toString(ints));


        bogoSort(ints);
        //System.out.println(Arrays.toString(ints));
    }
}
