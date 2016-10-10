package com.thelevelgrinder.hangdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.util.Log;
import android.view.View;
import android.widget.EditText; // for bill amount input
import android.widget.LinearLayout;
import android.widget.TextView; // for displaying text
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    String mWord = "TEST";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * takes letter from editText
     * @param v button is clicked
     */
    public void introduceLetter(View v)
    {
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString().toUpperCase();
        Log.d("MYLOG","The letter is "+letter);
        if (letter.length() == 1) {
            checkLetter(letter);
        }else{
            Toast.makeText(this,"Please Introduce letter", Toast.LENGTH_SHORT).show();
        }



    }

    /**
     * checks letter afainst teh string (word)
     * @param introduceLetter letter from user
     */
    public void checkLetter(String introduceLetter)
    {
        char charIntroduced = introduceLetter.charAt(0);

        for( int i = 0; i < mWord.length(); i++)
        {
           char charFromTheWord = mWord.charAt(i);
            if (charFromTheWord == charIntroduced)
            {
                showLettersAtIndex(i,charIntroduced);
           }
        }
    }
    public void showLettersAtIndex(int position, char letterGuessed)
    {
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));

    }

}
