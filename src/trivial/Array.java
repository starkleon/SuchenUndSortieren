package trivial;

import java.util.Arrays;
import java.util.Random;

public class Array {
    int[] values;
    int length = 0;


    public Array(int initialLength){
        if(initialLength < 0){
            throw new IllegalArgumentException();
        }
        values = new int[initialLength == 0 ? 1 : initialLength];
    }

    public Array(){
        values = new int[1];
    }

    public void insert(int i){
        if(values.length <= length){
            values = Arrays.copyOf(values, values.length * 2);
        }

        values[length++] = i;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            sb.append(values[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }


    public int[] sort(){
        if(values.length <= 1){
            return values;
        }

        //int[] tmp = new int[values.length];

        for(int i = 0; i < length; i++){
            for(int j = 0 ; j + 1 < length; j++){
                if(values[j] > values[j+1]){
                    swap(values, j, j + 1);
                }
            }
        }
        return values;
    }

    private static void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }


    public static void main(String[] args){
        Array a = new Array();
        Random r = new Random();

        for(int i = 0; i < 1000; i++){
            a.insert(r.nextInt(-100, 1000));
        }


        System.out.println(a);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            return;
        }
        a.sort();
        System.out.println(a);


    }

}
