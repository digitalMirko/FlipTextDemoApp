package com.digitalmirko.fliptextdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_input, et_output;
    Button btn_flip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_input = findViewById(R.id.et_input);
        et_output = findViewById(R.id.et_output);
        btn_flip = findViewById(R.id.btn_flip);

        btn_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldText = et_input.getText().toString();
                String newText = flipString(oldText);
                et_output.setText(newText);
            }
        });
    }

    // Used this url to help in flip text: http://www.upsidedowntext.com/
    private String flipString(String input){
        String normal = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$%^&*()[]{}|:;'<>,.?";
        String split = "0ƖᄅƐㄣϛ9ㄥ86ɐqɔpǝɟƃɥᴉɾʞlɯuodbɹsʇnʌʍxʎz∀qƆpƎℲפHIſʞ˥WNOԀQɹS┴∩ΛMX⅄Z,~¡@#$%^⅋*)(][}{|:;,><'˙¿";

        String output = "";
        char letter;
        for(int i = 0; i < input.length(); i++){
            letter = input.charAt(i);
            int a = normal.indexOf(letter);
            output += (a != -1) ? split.charAt(a):letter;
        }
        return new StringBuilder(output).reverse().toString();
    }
}