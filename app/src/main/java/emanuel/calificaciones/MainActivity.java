package emanuel.calificaciones;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import Controlador.Controlador;

/**
 * Clase controladora del layout 'MainActivity'
 *
 * @author Jairo Castañeda
 * @author Emanuel Martínez Pinzón
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    Button calcular70, calcularDef;
    EditText corte1, corte2, corte3, examen;
    TextView falta, lleva, definitiva;

    Controlador c = new Controlador();
    float c1, c2, c3, ex = (float) 0.0;
    DecimalFormat d = new DecimalFormat("####.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(R.string.title_activity_main);
        actionBar.setIcon(R.mipmap.ic_launcher);

        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("",
                res.getDrawable(R.drawable.clipboard));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("",
                res.getDrawable(R.drawable.icon_divisist));
        tabs.addTab(spec);

        TabHost.TabSpec finalSpec = spec;

        tabs.setCurrentTab(0);

        //Acciones para la tab1
        calcular70 = (Button) findViewById(R.id.cmdCalcular70);
        calcular70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    corte1 = (EditText) findViewById(R.id.txtNota1);
                    corte2 = (EditText) findViewById(R.id.txtNota2);
                    corte3 = (EditText) findViewById(R.id.txtNota3);

                    c1 = Float.parseFloat(corte1.getText().toString());
                    c2 = Float.parseFloat(corte2.getText().toString());
                    c3 = Float.parseFloat(corte3.getText().toString());

                    if(c1 > 5 || c2 > 5 || c3 > 5){
                        Toast.makeText(getBaseContext(), "Calma, calma, sólo números menores o iguales a 5",
                                Toast.LENGTH_LONG).show();
                        return;
                    }

                    ArrayList<String> nota70 = c.calcularNotaFalta(c1, c2, c3);

                    lleva = (TextView) findViewById(R.id.lblNotaMateria);
                    float notamm = Float.parseFloat(nota70.get(0));
                    String notam = d.format(notamm);
                    lleva.setText(notam);

                    falta = (TextView) findViewById(R.id.lblNotaExamen);
                    float notaff = Float.parseFloat((nota70.get(1)));
                    String nota = d.format(notaff);
                    falta.setText(nota);

                    if(notamm < 1.5)
                        Toast.makeText(getBaseContext(),"Yo de usted iria cancelando por que ni con 5 pasa",
                                Toast.LENGTH_LONG).show();
                    else if(notaff >= 1.5 && notaff <= 1.7)
                        Toast.makeText(getBaseContext(),"Tienes las misma posibilidades de pasar que de conseguir novia :v",
                                Toast.LENGTH_LONG).show();
                    else if(c1 == 5 && c2 == 5 && c3 == 5)
                        Toast.makeText(getBaseContext(), "¿Acaso eres Chuck Norris?",
                                Toast.LENGTH_LONG).show();
                    else if(notamm >= 3.0)
                        Toast.makeText(getBaseContext(),"Feliciades ya pasaste, cada vez mas cerca del carrito de bonice :v",
                                Toast.LENGTH_LONG).show();
                }catch(Exception ex){
                    Toast.makeText(getBaseContext(), "Debe ingresar todos los datos ",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        calcularDef = (Button) findViewById(R.id.cmdCalcularDefinitiva);
        calcularDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    corte1 = (EditText) findViewById(R.id.txtNota1);
                    corte2 = (EditText) findViewById(R.id.txtNota2);
                    corte3 = (EditText) findViewById(R.id.txtNota3);
                    examen = (EditText) findViewById(R.id.txtExamen);

                    c1 = Float.parseFloat(corte1.getText().toString());
                    c2 = Float.parseFloat(corte2.getText().toString());
                    c3 = Float.parseFloat(corte3.getText().toString());
                    ex = Float.parseFloat(examen.getText().toString());

                    String def = c.calcularNotafinal(c1, c2, c3, ex);
                    double deff = Double.parseDouble(def);
                    String  finall = d.format(deff);

                    definitiva = (TextView) findViewById(R.id.lblNotaDefinitiva);
                    definitiva.setText(finall);

                    if(deff < 2.95)
                        Toast.makeText(getBaseContext(), "baia, baia, debiste cancelar :v",
                                Toast.LENGTH_LONG).show();
                    else if(c1 == 5 && c2 == 5 && c3 == 5 && ex == 5)
                        Toast.makeText(getBaseContext(), "Definitivamente si eres Chuck Norris",
                                Toast.LENGTH_LONG).show();
                }catch(Exception ex){
                    Toast.makeText(getBaseContext(), "Debe ingresar todos los datos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        //Acciones para la tab2
        WebView wb= (WebView)findViewById(R.id.webView);
        WebSettings ws = wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());

        wb.loadUrl("http://www.divisist.ufps.edu.co");
        wb.getSettings().setBuiltInZoomControls(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            Intent i = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(i);
        }

        if( id == R.id.action_cleanField){
            corte1 = (EditText) findViewById(R.id.txtNota1);
            corte1.setText("");

            corte2 = (EditText) findViewById(R.id.txtNota2);
            corte2.setText("");

            corte3 = (EditText) findViewById(R.id.txtNota3);
            corte3.setText("");

            examen = (EditText) findViewById(R.id.txtExamen);
            examen.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}
