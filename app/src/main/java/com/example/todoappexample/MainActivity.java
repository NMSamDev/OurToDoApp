package com.example.todoappexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity

        /**
         * Compile time -> handled while the code is building
         * Runtime -> handled while the code is running
         *
         * OOP -> Object Oriented Programming
         *  - Polymorphism ->   Taking many forms
         *                      overloading ->
         *                          compile time
         *                          two or more methods of the same name, but different parameters
         *                      overriding
         *                          runtime
         *                          pulling methods from the parent class/interface
         *  - Abstraction -> Only showing the needed functionality
         *  - Inheritance -> one class derives from another class
         *  - Encapsulation ->
         *                      hiding the data
         *                      variables are private
         *                      methods are public
         *                      getters and setters
         *
         * Visibility Modifiers
         *  - public -> everything can see
         *  - private -> Only visible within the class
         *  - protected -> Only visible to its children
         *
         */
        implements View.OnClickListener{
    //global variables
    EditText etInput;
    Button btnSubmit;
    ListView lvTodos;
    ImageButton ibtnPlus;
    TextView tvMiddleText;

    //Adapter -> layout
    ArrayAdapter<String> lvAdapter;
    String displayText;
    final String KEY = "key1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_layout);

        etInput = findViewById(R.id.et_input);
        btnSubmit = findViewById(R.id.button4);
        lvTodos = findViewById(R.id.lv_todos);
        ibtnPlus = findViewById(R.id.ibtn_plus);
        tvMiddleText = findViewById(R.id.tv_middle_text);

        if(savedInstanceState != null){
            displayText = savedInstanceState.getString(KEY);
            tvMiddleText.setText(displayText);
        }

        // Context and ID of the layout
        // Context -> current state of our application
        lvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvTodos.setAdapter(lvAdapter);

        btnSubmit.setOnClickListener(this);
        ibtnPlus.setOnClickListener(view -> {
            tvMiddleText.setText(etInput.getText().toString());
            etInput.getText().clear();
        });
    }

    @Override
    public void onClick(View view) {
        String input = etInput.getText().toString();

        if(input.trim().isEmpty()){
            Toast.makeText(this, "Input cannot be empty", Toast.LENGTH_LONG).show();
        }
        else {
            addNewTodo(input);
        }
    }

    public void addNewTodo(String input){
        lvAdapter.add(input);
        etInput.getText().clear();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY,tvMiddleText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        displayText = savedInstanceState.getString(KEY);

    }
}