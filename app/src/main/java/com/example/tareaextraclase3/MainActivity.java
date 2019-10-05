package com.example.tareaextraclase3;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Handler;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView numsOrdenar;
    private TextView iteracion;
    private TextView swapsText;
    private TextView comparisonText;
    private Random numberGenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numsOrdenar = findViewById(R.id.textNumsOrdenar);
        iteracion = findViewById(R.id.textDatos);
        comparisonText = findViewById(R.id.textComparisons);
        swapsText = findViewById(R.id.textSwaps);

    }

    public void sortSelection(View v){
        iteracion.setText("");
        selectionSort(randomArray(10));
    }

    public void sortBubble(View v){
        iteracion.setText("");
        bubbleSort(randomArray(10));
    }

    public void sortInsertion(View v){
        iteracion.setText("");
        insertionSort(randomArray(10));
    }

    private int[] randomArray(int size){
        int[] random = new int[size];
        numsOrdenar.setText("Numeros a ordenar: ");
        for (int x = 0; x < random.length; x++){
            random[x] = numberGenerator.nextInt(100);
            numsOrdenar.setText(numsOrdenar.getText()+String.valueOf(random[x]));
            if(x < random.length-1){
                numsOrdenar.setText(numsOrdenar.getText()+", ");
            }
        }
        return random;
    }

    private void selectionSort(int[] arr){
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                comparisons++;
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            if(index !=  i){
                swaps++;
                int smallerNumber = arr[index];
                arr[index] = arr[i];
                arr[i] = smallerNumber;
            }
            setIterationTexts(i+1, arr);
        }
        setSwapComparisonText(swaps, comparisons);
    }

    private void bubbleSort(int[] array){
        int n = array.length;
        int k;
        int comparisons = 0;
        int swaps = 0;
        int aux = n;
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < aux-1; i++) {
                k = i + 1;
                comparisons++;
                if (array[i] > array[k]) {
                    swaps++;
                    int temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
            setIterationTexts(m+1, array);
            aux--;
        }
        setSwapComparisonText(swaps, comparisons);
    }

    private void insertionSort(int[] array){
        int n = array.length;
        int comparisons = 0;
        int swaps = 0;
        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                comparisons++;
                if(array[j-1] > array[j]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    swaps++;
                }
            }

            setIterationTexts(i, array);

        }
        setSwapComparisonText(swaps, comparisons);
    }

    private void setIterationTexts(int iteration, int[] array){


        String arrayText = "";
        for (int x = 0; x < array.length; x++){
            arrayText += array[x];
            if(x < array.length -1){
                arrayText += ", ";
            }
        }
        iteracion.setText(iteracion.getText()+"Iteración #" +iteration+ ": "+arrayText+"\n\n");

    }

    private void setSwapComparisonText(int swaps, int comparisons){
        comparisonText.setText("Comparaciones: " + comparisons);
        swapsText.setText("Swaps: " + swaps);
    }
}
