package com.example.second_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int numberCoffees =0;
    boolean hasCream = false;
    boolean hasChocolate =false;
    String hasName = "Name";
    public void incrementQuantity(View view){
        numberCoffees++;
        display(numberCoffees);
    }
    public void decrementQuantity(View view){
        if(numberCoffees>0)numberCoffees--;
        display(numberCoffees);
    }
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    public void submitOrder(View view){
        CheckBox checkBox = (CheckBox) findViewById(R.id.notify_me_checkbox);
        hasCream = checkBox.isChecked();
        checkBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        hasChocolate = checkBox.isChecked();
        EditText editText = (EditText) findViewById(R.id.album_description_view);
        hasName = editText.getText().toString();

        displayPrice(numberCoffees * 20);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String name = "Name : ";
        if(hasName!=null) name+=hasName; else name+="from App";
        String text = name+"\n";
         text += String.format("Quantity : %d \n", numberCoffees);
        text += "Whipped cream :";
        if(hasCream) text += " YES\n"; else text += " NO\n";
        text += "Chocolate :";
        if(hasChocolate) text += " YES\n"; else text += " NO\n";
        text += "Total : "+NumberFormat.getCurrencyInstance().format(number)+"\n";


        priceTextView.setText(text);
        composeEmail(name,text);
    }
    public void composeEmail( String subject,String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}