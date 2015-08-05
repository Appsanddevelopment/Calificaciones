package emanuel.calificaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
=======
import android.view.View;
>>>>>>> a975add2803d209f66c76a0d420b4548d101091f
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import Controlador.Controlador;
<<<<<<< HEAD
=======





>>>>>>> a975add2803d209f66c76a0d420b4548d101091f

public class principal extends ActionBarActivity {

    Button cmdCalcular;
    Controlador c = new Controlador();
    EditText nota1, nota2, nota3, examen;
<<<<<<< HEAD
=======
    Button cmdcalcular;
Controlador c= new Controlador();
>>>>>>> a975add2803d209f66c76a0d420b4548d101091f

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nota1 = (EditText) findViewById(R.id.txtNota1);
        nota2 = (EditText) findViewById(R.id.txtNota2);
        nota3 = (EditText) findViewById(R.id.txtNota3);
        examen = (EditText) findViewById(R.id.txtExamen);

<<<<<<< HEAD
        float n1 = Float.parseFloat(nota1.toString());

        cmdCalcular = (Button) findViewById(R.id.cmdCalcular70);
        
=======
        cmdcalcular=(Button)findViewById(R.id.cmdCalcular70);

        cmdcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            //aqui programamos  todo
            public void onClick(View v) {



            }
        });



>>>>>>> a975add2803d209f66c76a0d420b4548d101091f
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
