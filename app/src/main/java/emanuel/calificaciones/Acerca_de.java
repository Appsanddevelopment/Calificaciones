package emanuel.calificaciones;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Acerca_de extends ActionBarActivity {

    Button cmdcontactar, cmdSource, cmdVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        cmdcontactar = (Button) findViewById(R.id.cmdContactar);
        cmdSource = (Button) findViewById(R.id.cmd_Source);
        cmdVolver = (Button) findViewById(R.id.cmdvolver);

        cmdcontactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Esta opción aún esta en contrucción", Toast.LENGTH_SHORT).show();
            }
        });

        cmdSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/Appsanddevelopment/Calificaciones";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        cmdVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
