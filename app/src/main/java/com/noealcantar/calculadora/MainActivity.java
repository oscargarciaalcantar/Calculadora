package com.noealcantar.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String operacion="C";
    double resultado=0;
    boolean operacionEnCurso = false;
    String operaciontmp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNumberClick(View v){


        Button btnClicked = (Button) v;
        String text = btnClicked.getText().toString();

        double entrada = 0;
        try{
            entrada = Double.parseDouble(((TextView)findViewById(R.id.txtIN)).getText().toString());
        }catch(Exception e){}

        if(operacion=="=" || operacion=="C")
            resultado = entrada;


        switch(text){
            case "+":
                operarAnterior(entrada);
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"+");
                ((TextView)findViewById(R.id.txtIN)).setText(resultado+"");
                operacion = "+";
                operacionEnCurso = true;
                break;

            case "-":
                operarAnterior(entrada);
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"-");
                ((TextView)findViewById(R.id.txtIN)).setText(resultado+"");
                operacion = "-";
                operacionEnCurso = true;
                break;


            case "X":
                operarAnterior(entrada);
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"x");
                ((TextView)findViewById(R.id.txtIN)).setText(resultado+"");
                operacion = "X";
                operacionEnCurso = true;
                break;

            case "/":
                operarAnterior(entrada);
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"/");
                ((TextView)findViewById(R.id.txtIN)).setText(resultado+"");
                operacion = "/";
                operacionEnCurso = true;
                break;


            case "C":
                resultado=0;
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"");
                ((TextView)findViewById(R.id.txtIN)).setText("");
                operacion = "C";
                operaciontmp = "";
                break;


            case "+/-":
                try {
                    double valor = Double.parseDouble(((TextView)findViewById(R.id.txtIN)).getText().toString());
                    ((TextView) findViewById(R.id.txtIN)).setText((valor * (-1)) + "");
                }catch(Exception e){}
                break;

            case ".":

                String inputI = (((TextView)findViewById(R.id.txtIN)).getText().toString());
                if(inputI.indexOf(".")!=-1)
                {
                    System.out.println("there is 'b' in temp string");
                }else {
                    String newText = ((TextView) findViewById(R.id.txtIN)).getText().toString();
                    ((TextView) findViewById(R.id.txtIN)).setText(newText + ".");
                    System.out.println(newText + " ici");
                }

                break;

            case "x^":
                //System.out.println("here");
                //operarAnterior(entrada);
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"^");
                operacion = "x^";
                operacionEnCurso = true;
                break;

            case "√":
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"√");
                operacion = "√";
                operacionEnCurso = true;
                break;

            case "sin":
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"sin");
                operacion = "sin";
                operacionEnCurso = true;
                break;

            case "cos":
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"cos");
                operacion = "cos";
                operacionEnCurso = true;
                break;

            case "tan":
                ((TextView)findViewById(R.id.txtOUT)).setText(resultado+"tan");
                operacion = "tan";
                operacionEnCurso = true;
                break;


            case "=":
                operarAnterior(entrada);
                ((TextView)findViewById(R.id.txtIN)).setText(resultado+"");
                operacion = "=";
                break;


            default:

                String newText = ((TextView)findViewById(R.id.txtIN)).getText().toString();
                String lastEntry = ((TextView)findViewById(R.id.txtOUT)).getText().toString();

                if (operacionEnCurso){
                    operaciontmp = lastEntry;
                    newText = "";
                }

                if (operacionEnCurso && operacion.equals("x^")){

                }


                newText = newText+=text;
                ((TextView)findViewById(R.id.txtOUT)).setText(operaciontmp + "" + newText);
                ((TextView)findViewById(R.id.txtIN)).setText(newText);

                operacionEnCurso = false;
                break;
        }
    }

    public void operarAnterior(double entrada){

        try {

            switch (operacion) {
                case "+":
                    resultado = resultado + entrada;
                    break;

                case "-":
                    resultado = resultado - entrada;
                    break;

                case "X":
                    if(entrada!=0){
                        resultado = resultado * entrada;
                    }

                    break;

                case "/":
                    if(entrada!=0){
                        resultado = resultado / entrada;
                    }
                    break;

                case "x^":
                    resultado = Math.pow(resultado, entrada);
                    break;

                case "√":
                    resultado = Math.sqrt(entrada);
                    break;

                case "sin":
                    resultado = Math.sin(entrada);
                    break;

                case "cos":
                    resultado = Math.cos(entrada);
                    break;

                case "tan":
                    resultado = Math.tan(entrada);
                    break;

                default:
                    break;
            }
        }catch(Exception e){}
    }
}
