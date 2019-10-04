package com.example.tareaextraclase3;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Handler;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView numeroIteracion;
    private TextView iteracion;
    private TextView swapsText;
    private TextView comparisonText;
    private Random numberGenerator = new Random();
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iteracion = findViewById(R.id.textDatos);
        comparisonText = findViewById(R.id.textComparisons);
        swapsText = findViewById(R.id.textSwaps);

    }

    public void sortSelection(View v){
        selectionSort(randomArray(10));
    }

    public void sortBubble(View v){
        bubbleSort(randomArray(10));
    }

    public void sortInsertion(){
        insertionSort(randomArray(10));
    }

    private int[] randomArray(int size){
        int[] random = new int[size];
        for (int x = 0; x < random.length; x++){
            random[x] = numberGenerator.nextInt(100);
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
                    index = j;}}
            swaps++;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            setIterationTexts(i, arr);
        }
        setSwapComparisonText(swaps, comparisons);
    }

    private void bubbleSort(int[] array){
        int n = array.length;
        int k;
        int comparisons = 0;
        int swaps = 0;
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n - 1; i++) {
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

        }
        setSwapComparisonText(swaps, comparisons);
    }

    private void insertionSort(int[] input){
        int comparisons = 0;
        int swaps = 0;
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                comparisons++;
                if(input[j-1] > input[j]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                    swaps++;
                }
            }
            setIterationTexts(i, input);

        }
        setSwapComparisonText(swaps, comparisons);
    }

    private void setIterationTexts(int iteration, int[] array){
        String arrayText = "";
        for (int x = 0; x < array.length; x++){
            arrayText += array[x] + ", ";
        }
        iteracion.setText(iteracion.getText()+"Iteración #" +iteration+ ": "+arrayText+"\n\n");

    }

    private void setSwapComparisonText(int swaps, int comparisons){
        comparisonText.setText("Comparaciones: " + comparisons);
        swapsText.setText("Swaps: " + swaps);
    }
}
