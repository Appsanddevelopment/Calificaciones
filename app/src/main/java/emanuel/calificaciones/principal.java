package emanuel.calificaciones;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class principal extends ActionBarActivity {

    EditText nota1, nota2, nota3, examen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nota1 = (EditText) findViewById(R.id.txtNota1);
        nota2 = (EditText) findViewById(R.id.txtNota2);
        nota3 = (EditText) findViewById(R.id.txtNota3);
        examen = (EditText) findViewById(R.id.txtExamen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_acerca)
            Toast.makeText(getBaseContext(), "Creado por Jairo y Emanuel", Toast.LENGTH_LONG).show();

        if(id == R.id.action_limpiar){
            nota1.setText("");
            nota2.setText("");
            nota3.setText("");
            examen.setText("");
        }

        if(id == R.id.action_salir)
            System.exit(0);


        return super.onOptionsItemSelected(item);
    }
}
