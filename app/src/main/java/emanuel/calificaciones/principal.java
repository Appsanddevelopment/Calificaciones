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
    Button cmddefinitiva;
    Controlador c = new Controlador();
    EditText nota1, nota2, nota3, examen;
    float n1 = (float) 0.0;
    float n2 = (float) 0.0;
    float n3 = (float) 0.0;
    float ex = (float) 0.0;
    TextView minima, lleva, definitiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        cmddefinitiva=(Button)findViewById(R.id.calcularDefinitiva);
        cmdcalcular=(Button)findViewById(R.id.cmdCalcular70);
        cmdcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    nota1 = (EditText) findViewById(R.id.txtNota1);
                    nota2 = (EditText) findViewById(R.id.txtNota2);
                    nota3 = (EditText) findViewById(R.id.txtNota3);
                    examen=(EditText)findViewById(R.id.txtExamen);

                    n1 = Float.parseFloat(nota1.getText().toString());
                    n2 = Float.parseFloat(nota2.getText().toString());
                    n3 = Float.parseFloat(nota3.getText().toString());

                    ArrayList<String> result = c.calcularNotaFalta(n1, n2, n3);
                    minima = (TextView) findViewById(R.id.lblNotaExamen);
                    minima.setText(String.valueOf(result.get(1)));
                    lleva = (TextView) findViewById(R.id.lblNotaMateria);
                    lleva.setText(String.valueOf(result.get(0)));
                    definitiva = (TextView) findViewById(R.id.lblNotaDefinitiva);
                    definitiva.setText(String.valueOf(result.get(1)));

                    float mini=Float.parseFloat(minima.getText().toString());
                    float notafinal=Float.parseFloat(c.calcularNotafinal(n1, n2, n3, mini));
                    float lleva=Float.parseFloat(result.get(0));

                    if((lleva)<1.5f){
                        Toast.makeText(getBaseContext(),"Amig@ lamentamos decirle que usted  ni sacando 5 pasa , debio cancelar ",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if((lleva)>2.95f){
                        Toast.makeText(getBaseContext(),"Felicidades ya pasaste , pase por su premio",Toast.LENGTH_SHORT).show();
                        return;
                    }

                }catch(Exception ex){
                    Toast.makeText(getBaseContext(), "Debe ingresar los datos", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

        cmddefinitiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Esto no esta conectado", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        try {
            if (id == R.id.action_limpiar) {
                nota1.setText("");
                nota1.invalidate();
                nota2.setText("");
                nota2.invalidate();
                nota3.setText("");
                nota3.invalidate();
                examen.setText("");
                examen.invalidate();
             return true;
            }

            if (id == R.id.action_volver)
                super.onBackPressed();

            if (id == R.id.action_salir) {
                Intent act = new Intent(Intent.ACTION_MAIN);
                finish();
            }

            if (id == R.id.action_acerca){
                Intent i = new Intent(principal.this, Acerca_de.class);
                startActivity(i);
            }
        }catch(Exception ex){
            Toast.makeText(getBaseContext(),"excepcion"+ex.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
