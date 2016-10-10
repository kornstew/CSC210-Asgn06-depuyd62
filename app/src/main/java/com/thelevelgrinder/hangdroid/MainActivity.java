package com.thelevelgrinder.hangdroid;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText; //
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Damian Depuy
 * CSC 210
 * The main class that runs the application Hang Droid
 * @version 1.0 Beta one word only
 *
 */
public class  MainActivity extends AppCompatActivity
{
    // Application word is test
    String mWord = "TEST";
    int mFailedCounter = 0; // counter for failed guesses to determine game over
    int mGuessedLetters = 0; // counter for guessed correctly to determine win


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * takes letter from editText and runs it to see if it belongs to string
     * @param v button is clicked
     */
    public void introduceLetter(View v)
    {
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        // hides the keyboard after the button is clicked when virtual keyboard blocks image
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        //letter passed through string
        String letter = myEditText.getText().toString().toUpperCase();
        myEditText.setText("");
        

        if (letter.length() == 1) {
            checkLetter(letter);
        }else{
            Toast.makeText(this,"Please Introduce letter", Toast.LENGTH_SHORT).show(); // if no letter is entered Toast message
        }
    }

    /**
     * checks letter against the string (word)
     * @param introduceLetter letter from user
     */
    public void checkLetter(String introduceLetter)
    {
        char charIntroduced = introduceLetter.charAt(0); // easier to read in for loop
        boolean letterGuessed = false;
        for( int i = 0; i < mWord.length(); i++)
        {
           char charFromTheWord = mWord.charAt(i);
            if (charFromTheWord == charIntroduced)
            {
                letterGuessed = true;
                showLettersAtIndex(i,charIntroduced);
                mGuessedLetters++; // increase correct guess variable
           }
        }
        if (!letterGuessed)
        {
            letterFailed(Character.toString(charIntroduced).toUpperCase()); // calls method to display letters used
        }
        if (mGuessedLetters == mWord.length())
        {
            // when all the letters are guessed the clearScreen method starts the game over
            clearScreen();
        }

    }
    public void clearScreen()
    {
        TextView textViewFailed = (TextView) findViewById(R.id.textView6);
        textViewFailed.setText("");

        mGuessedLetters = 0;
        mFailedCounter = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);
        // creates dashes back on screen
        for (int i = 0; i < layoutLetters.getChildCount(); i++)
        {
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }

    }
    public void letterFailed(String letterFailed)
    {
        TextView textViewFailed = (TextView) findViewById(R.id.textView6);
        String previousFail = textViewFailed.getText().toString().toUpperCase();
        textViewFailed.setText(previousFail+letterFailed); // display previous and current guessed wrong characters
        mFailedCounter++;
        // find androidBot imageview which is currently empty
        ImageView imageView = (ImageView) findViewById(R.id.androidBot);
        // for each failed counter a new image is displayed
        if (mFailedCounter == 1)
        {
            imageView.setImageResource(R.drawable.android_robot1);
        }else if (mFailedCounter == 2)
        {
            imageView.setImageResource(R.drawable.android_robot2);
        }
        else if (mFailedCounter == 3)
        {
            imageView.setImageResource(R.drawable.android_robot3);
        }
        else if (mFailedCounter == 4)
        {
            imageView.setImageResource(R.drawable.android_robot4);
        }
        else if (mFailedCounter == 5)
        {
            imageView.setImageResource(R.drawable.android_robot5);
        }
        else if (mFailedCounter == 6)
        {
            imageView.setImageResource(R.drawable.android_robot6);
        }
        else if (mFailedCounter == 7)
        {
            // game over and call new intent activity
            Intent gameOverIntent = new Intent(this,GameOverActivity.class);
            startActivity(gameOverIntent);
        }

    }
    /**
     * Displays letters in textView when correct.
     * @param position the letters position
     * @param letterGuessed letter guessed
     */
    public void showLettersAtIndex(int position, char letterGuessed)
    {
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));

    }


}
