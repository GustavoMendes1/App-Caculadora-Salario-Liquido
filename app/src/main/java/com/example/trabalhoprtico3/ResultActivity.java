package com.example.trabalhoprtico3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {


    private Float SalarioBruto;
    private Double Descontos;
    private Float Outroadescontos;
    private Double CalculoINSS;
    private Double CalculoIRRF;
    private Double SalarioLiquido;

    DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        SalarioBruto =  Float.parseFloat(intent.getStringExtra(MainActivity.SALARIO_BRUTO));
        Outroadescontos =  Float.parseFloat(intent.getStringExtra(MainActivity.OUTROS_DESCONTOS));

        TextView labelSalarioBruto = (TextView)findViewById(R.id.OutputSalario);
        TextView labelINSS = (TextView)findViewById(R.id.OutputINSS);
        TextView labelIRRF = (TextView)findViewById(R.id.outputIRRF);
        TextView labelOutrosDescontos = (TextView)findViewById(R.id.OutputOutrosDescontos);
        TextView labelSalarioLiquido = (TextView)findViewById(R.id.OutputSalarioLiquido);
        TextView labelDescontos = (TextView)findViewById(R.id.OutputDescontos);

        realizarcalculoINSS();
        realizarcalculoIRRF();
        SalarioLiquido();

        labelSalarioBruto.setText(SalarioBruto.toString());
        labelINSS.setText("- "+df.format(CalculoINSS));
        labelIRRF.setText("- "+df.format(CalculoIRRF));
        labelOutrosDescontos.setText("- "+Outroadescontos.toString());
        labelSalarioLiquido.setText(df.format(SalarioLiquido));
        labelDescontos.setText(df.format(Descontos)+"%");
    }

    private void SalarioLiquido(){

        SalarioLiquido = SalarioBruto - CalculoIRRF - CalculoINSS - Outroadescontos;
        Descontos = ((SalarioBruto-SalarioLiquido)*100)/SalarioBruto;
    }

    private  void  realizarcalculoINSS(){

        if(SalarioBruto<= 1045){
            CalculoINSS = 0.075*SalarioBruto;
        }else if(SalarioBruto>1045 && SalarioBruto<=2089.60){
            CalculoINSS = (0.09*SalarioBruto)-15.67;
        }else if(SalarioBruto>2089.60 && SalarioBruto<=3134.40){
            CalculoINSS =  (0.12*SalarioBruto)-78.36;
        }else{
            CalculoINSS =  (0.14*SalarioBruto)-141.05;
        }

    }

    private void realizarcalculoIRRF(){
        double SalarioBase = SalarioBruto - CalculoINSS;

        if(SalarioBase<= 1903.98){
            CalculoIRRF = 0.0;
        }else if(SalarioBase>1903.98 && SalarioBase<=2826.65){
            CalculoIRRF = (0.075*SalarioBase)-142.80;
        }else if(SalarioBase>2826.65 && SalarioBase<=3751.05){
            CalculoIRRF =  (0.15*SalarioBase)-354.80;
        }else if(SalarioBase>3751.05 && SalarioBase<=4664.68){
            CalculoIRRF =  (0.225*SalarioBase)-636.13;
        }else{

            CalculoIRRF =  (0.275*SalarioBase)-869.36;
        }

    }


}