package emanuel.calificaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import Controlador.Controlador;

public class principal extends ActionBarActivity {

    Button cmdcalcular;
    Controlador c = new Controlador();
    EditText nota1, nota2, nota3, examen;
    float n1 = (float) 1.0;
    float n2 = (float) 1.0;
    float n3 = (float) 1.0;
    float ex=0.0f;
    TextView falta, lleva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cmdcalcular=(Button)findViewById(R.id.cmdCalcular70);
        cmdcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nota1 = (EditText) findViewById(R.id.txtNota1);
                nota2 = (EditText) findViewById(R.id.txtNota2);
                nota3 = (EditText) findViewById(R.id.txtNota3);
                examen = (EditText) findViewById(R.id.txtExamen);

                n1 = Float.parseFloat(nota1.getText().toString());
                n2 = Float.parseFloat(nota2.getText().toString());
                n3 = Float.parseFloat(nota3.getText().toString());
               // ex = Float.parseFloat(examen.toString());

                ArrayList<String> result = c.calcularNotaFalta(n1, n2, n3);
                falta = (TextView) findViewById(R.id.lblNotaExamen);
                falta.setText(String.valueOf(result.get(0)));
                lleva = (TextView) findViewById(R.id.lblNotaDefinitiva);
                lleva.setText(String.valueOf(result.get(1)));
                Toast.makeText(getBaseContext(), "Falta: "+ result.get(0)+" lleva: "+result.get(1), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();


        if(id == R.id.action_limpiar){
            nota1.setText("");
            nota2.setText("");
            nota3.setText("");
            examen.setText("");
        }

        if(id == R.id.action_volver){
            super.onBackPressed();
        }

        if(id == R.id.action_salir){
            Intent act = new Intent(Intent.ACTION_MAIN);
            finish();
        }

        if (id == R.id.action_acerca)
            Toast.makeText(getBaseContext(), "Creado por Jairo y Emanuel", Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}
