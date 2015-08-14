package emanuel.calificaciones;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.prefs.Preferences;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cmdabrir = (Button)findViewById(R.id.cmdabrir2);
        Button cmdDivisit=(Button)findViewById(R.id.cmdDivisit);

        cmdabrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(MainActivity.this,principal.class);
                startActivity(i);
                //mire emanuel si necesita pasar referencias el intent tiene un metodo putextras, reviselo pasa arreglos string lo que sea



            }
        });


        cmdDivisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://divisist.ufps.edu.co";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        //Cierra la aplicación
        if (id == R.id.action_salir)
            System.exit(0);

        //Resultado de tocar un "Acerca de"
        else if(id==R.id.action_acerca)
            Toast.makeText(getBaseContext(),"Creado por Jairo y Emanuel",Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
