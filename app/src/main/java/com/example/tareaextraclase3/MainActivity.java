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
    private int loop = 0, comparisons = 0, swaps = 0, tempLoop, insertPos, smallerNumber;
    private int[] array;
    private Random numberGenerator = new Random();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroIteracion = findViewById(R.id.textIteracion);
        iteracion = findViewById(R.id.textDatos);
        comparisonText = findViewById(R.id.textComparisons);
        swapsText = findViewById(R.id.textSwaps);

    }

    public void sortSelection(View v){
        clearTexts();
        comparisons = 0;
        swaps = 0;
        loop = 0;
        tempLoop = -1;
        smallerNumber = -1;
        randomArray(10);
        selectionSort(0);
    }

    public void sortBubble(View v){
        clearTexts();
        comparisons = 0;
        swaps = 0;
        loop = 0;
        tempLoop = -1;
        randomArray(10);
        bubbleSort(0, 1);
    }

    public void sortInsertion(View v){
        clearTexts();
        comparisons = 0;
        swaps = 0;
        loop = 0;
        tempLoop = -1;
        insertPos = -1;
        randomArray(10);
        insertionSort(0);
    }

    private void randomArray(int size){
        int[] random = new int[size];
        for (int x = 0; x < random.length; x++){
            random[x] = numberGenerator.nextInt(100);
        }
        this.array = random;
    }

    private void selectionSort(final int current){
        setIterationTexts(loop, array);
        handler.postDelayed(new Runnable(){
            public void run(){
                if(loop != tempLoop) {
                    setIterationTexts(loop, array);
                }
                tempLoop = loop;
                comparisons++;
                if (array[current] > array[smallerNumber]){
                    swaps++;
                    int temp = array[current];
                    array[current] = array[smallerNumber];
                    array[smallerNumber] = temp;
                }

                int n = current+1;
                loop++;
                if(n < array.length-1){
                    selectionSort(n);
                }
            }
        }, 300);

        smallerNumber = getSmallerNumber(current+1);
        setSwapComparisonText(this.swaps,this.comparisons);/*
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
        setSwapComparisonText(swaps, comparisons);*/
    }

    private int getSmallerNumber(int currentNumber){
        int smallerNumber = currentNumber;
        for (int i = currentNumber+1; i<array.length; i++){
            comparisons++;
            if(array[i] < array[smallerNumber]){
                smallerNumber = i;
            }
        }
        return smallerNumber;
    }

    private void bubbleSort(final int a, final int b){
        setIterationTexts(loop, array);
        handler.postDelayed(new Runnable(){
            public  void run(){
                if(loop != tempLoop) {
                    setIterationTexts(loop, array);
                }
                tempLoop = loop;
                comparisons++;
                if (array[a] > array[b]){
                    swaps++;
                    int temp = array[a];
                    array[a] = array[b];
                    array[b] = temp;
                }
                int i = a+1;
                int j = b+1;
                if (j == array.length-loop){
                    i = 0;
                    j = i+1;
                    loop++;
                }
                if(loop<array.length-1){
                    bubbleSort(i, j);
                }

            }
        }, 500);
        setSwapComparisonText(this.swaps,this.comparisons);
    }

    private void insertionSort(final int current){
        setIterationTexts(loop, array);
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                if(loop != tempLoop) {
                    setIterationTexts(loop, array);
                }
                tempLoop = loop;
                if (current != insertPos){
                    int temp = array[current];
                    comparisons++;
                    for (int i = current; i > insertPos; i--){
                        swaps++;
                        array[i] = array[i-1];
                    }
                    array[insertPos] = temp;
                }
                int n = current+1;
                loop++;
                if(n<array.length){
                    insertionSort(n);
                }
            }
        }, 500);

        insertPos = getInsertPos(current);
        setSwapComparisonText(this.swaps,this.comparisons);

        /*int comparisons = 0;
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
        setSwapComparisonText(swaps, comparisons);*/
    }

    private int getInsertPos(int currentNumber){
        int insertPosition = currentNumber;
        for (int i = 0; i<=insertPosition; i++ ){
            comparisons++;
            if(array[i] > array[insertPosition]){
                insertPosition = i;
            }
        }
        return insertPosition;
    }

    private void setIterationTexts(int iteration, int[] array){
        String arrayText = "";
        for (int x = 0; x < array.length; x++){
            arrayText += array[x] + "  ";
        }
        numeroIteracion.setText("Iteración #" + iteration);
        iteracion.setText(arrayText);

    }

    private void clearTexts(){
        numeroIteracion.setText("");
        iteracion.setText("");
        comparisonText.setText("");
        swapsText.setText("");
    }

    private void setSwapComparisonText(int swaps, int comparisons){
        comparisonText.setText("Comparaciones: " + comparisons);
        swapsText.setText("Swaps: " + swaps);
    }
}
