package com.example.second_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int numberCoffees =0;
    public void incrementQuantity(View view){
        numberCoffees++;
        display(numberCoffees);
    }
    public void decrementQuantity(View view){
        if(numberCoffees>0)numberCoffees--;
        display(numberCoffees);
    }
    public void submitOrder(View view){

        displayPrice(numberCoffees * 20);
    }
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }
    /**
     * This method displays the given price on the screen.
     */

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}