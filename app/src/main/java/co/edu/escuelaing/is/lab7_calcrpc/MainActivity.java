package co.edu.escuelaing.is.lab7_calcrpc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button number0,number1,number2,number3,number4,number5,number6,number7,number8,number9;
    Button operSum, operRes,operMul,operDiv, operSin, operCos, operTan, point, operPow, btnDEL, btnAC, btnSpace;
    TextView txtResult, txtCurrent;

    CalcService rpnCalcService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rpnCalcService = new RPNCalcService();

        txtResult = findViewById(R.id.txtValue);
        txtCurrent = findViewById(R.id.txtCurrent);

        number0 = findViewById(R.id.Number0);
        number1 = findViewById(R.id.Number1);
        number2 = findViewById(R.id.Number2);
        number3 = findViewById(R.id.Number3);
        number4 = findViewById(R.id.Number4);
        number5 = findViewById(R.id.Number5);
        number6 = findViewById(R.id.Number6);
        number7 = findViewById(R.id.Number7);
        number8 = findViewById(R.id.Number8);
        number9 = findViewById(R.id.Number9);
        operSum = findViewById(R.id.OperSum);
        operRes = findViewById(R.id.OperRes);
        operMul = findViewById(R.id.OperMul);
        operDiv = findViewById(R.id.OperDiv);
        operSin = findViewById(R.id.btnSin);
        operCos = findViewById(R.id.btnCos);
        operTan = findViewById(R.id.btnTan);
        point = findViewById(R.id.Point);
        btnSpace = findViewById(R.id.btnSpace);

        operPow = findViewById(R.id.btnPow);
        btnDEL = findViewById(R.id.btnDEL);
        btnAC = findViewById(R.id.btnAC);

        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        operDiv.setOnClickListener(this);
        operMul.setOnClickListener(this);
        operRes.setOnClickListener(this);
        operSum.setOnClickListener(this);
        operTan.setOnClickListener(this);
        operSin.setOnClickListener(this);
        operCos.setOnClickListener(this);
        point.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnDEL.setOnClickListener(this);
        operPow.setOnClickListener(this);
        btnSpace.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == number0.getId()){
            txtCurrent.setText(rpnCalcService.addValue("0"));
        }else if(view.getId() == number1.getId()){
            txtCurrent.setText(rpnCalcService.addValue("1"));
        }else if(view.getId() == number2.getId()){
            txtCurrent.setText(rpnCalcService.addValue("2"));
        }else if(view.getId() == number3.getId()){
            txtCurrent.setText(rpnCalcService.addValue("3"));
        }else if(view.getId() == number4.getId()){
            txtCurrent.setText(rpnCalcService.addValue("4"));
        }else if(view.getId() == number5.getId()){
            txtCurrent.setText(rpnCalcService.addValue("5"));
        }else if(view.getId() == number6.getId()){
            txtCurrent.setText(rpnCalcService.addValue("6"));
        }else if(view.getId() == number7.getId()){
            txtCurrent.setText(rpnCalcService.addValue("7"));
        }else if(view.getId() == number8.getId()){
            txtCurrent.setText(rpnCalcService.addValue("8"));
        }else if(view.getId() == number9.getId()){
            txtCurrent.setText(rpnCalcService.addValue("9"));
        }else if(view.getId() == operSum.getId()){
            txtCurrent.setText(rpnCalcService.addValue("+"));
        }else if(view.getId() == operRes.getId()){
            txtCurrent.setText(rpnCalcService.addValue("-"));
        }else if(view.getId() == operMul.getId()){
            txtCurrent.setText(rpnCalcService.addValue("*"));
        }else if(view.getId() == operDiv.getId()){
            txtCurrent.setText(rpnCalcService.addValue("/"));
        }else if(view.getId() == point.getId()){
            if(!rpnCalcService.decimalValidation()){
                txtCurrent.setText(rpnCalcService.addValue("."));
            }
        }else if(view.getId() == operPow.getId()){
            txtCurrent.setText(rpnCalcService.addValue("^"));
        }else if(view.getId() == operSin.getId()){
            txtCurrent.setText(rpnCalcService.addValue("SIN"));
        }else if(view.getId() == operCos.getId()){
            txtCurrent.setText(rpnCalcService.addValue("COS"));
        }else if(view.getId() == operTan.getId()){
            txtCurrent.setText(rpnCalcService.addValue("TAN"));
        }else if(view.getId() == btnDEL.getId()){
            txtCurrent.setText(rpnCalcService.deleteLastValue());
        }else if(view.getId() == btnAC.getId()){
            txtCurrent.setText("");
            txtResult.setText("");
            rpnCalcService.resetValues();
        }else if(view.getId() == btnSpace.getId()){
            if(!rpnCalcService.spaceValidation()) {
                txtCurrent.setText(rpnCalcService.addValue(" "));
            }
        }
        String eval = rpnCalcService.evalExpression();
        txtResult.setText("");
        if(eval != null){
            txtResult.setText(eval);
        }
    }
}
