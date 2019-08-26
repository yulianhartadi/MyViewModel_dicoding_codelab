package com.rdstudio.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyButton myButton;
    private MyEditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.my_button);
        myEditText = findViewById(R.id.my_edit_text);

        setMyButtonEnable();


        // check myEditText, if user input some text myButton will be enable. And Toast will show if user click myButton
        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                setMyButtonEnable();
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, myEditText.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    // check to myEditText bother any text or not, if text is empty myButton is disable
    private void setMyButtonEnable(){
        Editable result = myEditText.getText();
        if (result != null && !result.toString().isEmpty()){
            myButton.setEnabled(true);
        } else {
            myButton.setEnabled(false);
        }
    }



}
