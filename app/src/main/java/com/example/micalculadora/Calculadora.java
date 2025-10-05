package com.example.micalculadora;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputTx = findViewById(R.id.inputTx);
        radBtn = findViewById(R.id.radBtn);
        inputQueue = new LinkedList<Character>();
        lastWasNumber = false;
        inDegrees = false;
        clear();
    }

    LinkedList<Character> inputQueue;
    Boolean lastWasNumber;
    Boolean inDegrees;
    protected Log log;
    
    public TextView inputTx;
    public Button radBtn;

    public void on1BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('1');
        renderText();
    }
    public void on2BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('2');
        renderText();
    }
    public void on3BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('3');
        renderText();
    }
    public void on4BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('4');
        renderText();
    }
    public void on5BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('5');
        renderText();
    }
    public void on6BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('6');
        renderText();
    }
    public void on7BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('7');
        renderText();
    }
    public void on8BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('8');
        renderText();
    }
    public void on9BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('9');
        renderText();
    }
    public void on0BtnClick(android.view.View v)
    {
        lastWasNumber = true;
        inputQueue.add('0');
        renderText();
    }
    public void onAddBtnClick(android.view.View v)
    {
        if(!lastWasNumber) return;
        inputQueue.add('+');
        lastWasNumber = false;
        renderText();
    }
    public void onSubstractBtnClick(android.view.View v)
    {
        if(!lastWasNumber) return;
        inputQueue.add('-');
        lastWasNumber = false;
        renderText();
    }
    public void onMultiplyBtnClick(android.view.View v)
    {
        if(!lastWasNumber) return;
        inputQueue.add('x');
        lastWasNumber = false;
        renderText();
    }
    public void onDivisionBtnClick(android.view.View v)
    {
        if(!lastWasNumber) return;
        inputQueue.add('/');
        lastWasNumber = false;
        renderText();
    }
    public void onEqualsBtnClick(android.view.View v)
    {
        Log.d("Wenjie","Equals...");
        computeResult();
    }

    public void onSinBtnClick(android.view.View v)
    {
        if(!lastWasNumber) return;
        computeResult();
        double resultado = Integer.parseInt( inputTx.getText().toString() );
        resultado = inDegrees ? Math.toRadians(resultado) : resultado;
        inputTx.setText(String.format("%.3f",Math.sin(resultado)));
    }
    public void onCosBtnClick(android.view.View v)
    {
        if(!lastWasNumber) return;
        computeResult();
        double resultado = Integer.parseInt( inputTx.getText().toString() );
        resultado = inDegrees ? Math.toRadians(resultado) : resultado;
        inputTx.setText(String.format("%.3f",Math.cos(resultado)));
    }
    public void onTanBtnClick(android.view.View v)
    {
        if(!lastWasNumber) return;
        computeResult();
        double resultado = Integer.parseInt( inputTx.getText().toString() );
        resultado = inDegrees ? Math.toRadians(resultado) : resultado;
        inputTx.setText(String.format("%.3f",Math.tan(resultado)));
    }

    public void onClearBtnClick(android.view.View v)
    {
        clear();
    }

    public void onRadBtnClick(android.view.View v)
    {
        if(inDegrees)
        {
            inDegrees = false;
            radBtn.setText("Radians");
        }
        else
        {
            inDegrees = true;
            radBtn.setText("Degrees");
        }
    }

    public void clear()
    {
        inputTx.setText("0");
        lastWasNumber = false;
        inputQueue.clear();
    }

    public void renderText()
    {
        String text = "";
        for( Character c : inputQueue)
        {
            /*
            switch (c){
                case '1':
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
                    break;
                case '6':
                    break;
                case '7':
                    break;
                case '8':
                    break;
                case '9':
                    break;
                case '0':
                    break;
                default: // simbolos
                    break;
            }
            */

            text += c;
        }
        inputTx.setText(text);

    }

    public void computeResult() // basicamente he creado un interprete matematico
    {
        //Stack<Integer> numbers = new Stack<Integer>();
        int buffer = 0;
        int resultado = 0;
        char operand = ' ';
        for( int i = 0; i < inputQueue.size(); i++)
        {
            Character c = inputQueue.get(i);
            Log.d("Wenjie",String.format("%c", c));
            switch (c){
                case '1':
                    buffer = buffer * 10 + 1;
                    break;
                case '2':
                    buffer = buffer * 10 + 2;
                    break;
                case '3':
                    buffer = buffer * 10 + 3;
                    break;
                case '4':
                    buffer = buffer * 10 + 4;
                    break;
                case '5':
                    buffer = buffer * 10 + 5;
                    break;
                case '6':
                    buffer = buffer * 10 + 6;
                    break;
                case '7':
                    buffer = buffer * 10 + 7;
                    break;
                case '8':
                    buffer = buffer * 10 + 8;
                    break;
                case '9':
                    buffer = buffer * 10 + 9;
                    break;
                case '0':
                    buffer = buffer * 10 + 0;
                    break;
                default: // simbolos
                    if(resultado == 0) {
                        //numbers.push(buffer);
                        resultado = buffer;
                        operand = c;
                    }
                    else {
                        //int operante = numbers.pop();
                        //int res = 0;
                        Log.d("Wenjie",String.format("operacion: %d %c %d", resultado, operand, buffer));
                        resultado = interpretSymbol(resultado,buffer,operand);
                        operand = c;
                        Log.d("Wenjie",String.format("resultado: %d", resultado));
                        //numbers.push(res);
                    }
                        buffer = 0;
                    break;
            }


        }

        //int res2 = 0;
        if(buffer != 0)
        {
            if(resultado != 0) {
                //res2 = numbers.pop();
                resultado = interpretSymbol(resultado,buffer,operand);
            }
            else resultado = buffer;
        }
        clear();
        inputTx.setText(String.format("%d",resultado));
    }

    protected Integer interpretSymbol(int a, int b, Character c)
    {
        int res = Integer.MAX_VALUE;
        switch (c) {
            case '+':
                res = a + b;
                break;
            case '-':
                res= a - b;
                break;
            case 'x':
                res= a * b;
                break;
            case '/':
                res = a / b;
                break;
        }
        return res;
    }


}