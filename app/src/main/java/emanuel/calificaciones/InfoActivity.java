package emanuel.calificaciones;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import emanuel.calificaciones.R;
import android.view.View;
import java.util.List;

/**
 * Clase controladora del layout 'activity info'
 *
 * @author Jairo Andrés Castañeda Pacheco
 * @author Emanuel Martínez Pinzón
 * @version 1.0
 */

public class InfoActivity extends AppCompatActivity {

    TextView verWeb, sendEmail, facebook, twitter, verCodigo, verLicencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.title_activity_info);
        actionBar.setSubtitle(R.string.subtitle_activity_info);

        Resources res = getResources();

        TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("",
                res.getDrawable(R.drawable.credits));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("tab3");
        spec.setContent(R.id.tab2);
        spec.setIndicator("",
                res.getDrawable(R.drawable.icon_contact));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("tab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("",
                res.getDrawable(R.drawable.src));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);




    }

    private void enviarEmail(){
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/html");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"labapps.sbg@gmail.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_TITLE, "Calificaciones App");
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Contacto desde Calificaciones App");
        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar E-mail a LabApp's"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(InfoActivity.this, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();
        }
    }

    private Intent getFacebookIntent() {
        final Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/121752338175275"));

        if(isInstalled(facebookIntent))
            return  facebookIntent;

        final String url = "https://www.facebook.com/labappsSBG";
        final Intent facebookUrlIntent = new Intent(Intent.ACTION_VIEW);
        facebookIntent.setData(Uri.parse(url));
        return facebookUrlIntent;
    }

    private Intent getTwitterIntent() {
        final Intent TwitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/labappsSBG"));

        if(isInstalled(TwitterIntent))
            return  TwitterIntent;

        final String url = "https://twitter.com/labappsSBG";
        final Intent twitterUrlIntent = new Intent(Intent.ACTION_VIEW);
        twitterUrlIntent.setData(Uri.parse(url));
        return twitterUrlIntent;
    }

    private boolean isInstalled(final Intent intent) {
        List<ResolveInfo> lista = getPackageManager().queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return lista.size() > 0;
    }
}
