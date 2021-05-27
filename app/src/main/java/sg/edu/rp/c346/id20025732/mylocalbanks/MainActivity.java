package sg.edu.rp.c346.id20025732.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbstv, ocbctv, uobtv;
    String wordClicked = "";
    Boolean dbscolor = false;
    Boolean ocbccolor = false;
    Boolean uobcolor  = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbstv = findViewById(R.id.textViewDBS);
        ocbctv = findViewById(R.id.textViewOCBC);
        uobtv = findViewById(R.id.textViewUOB);
        registerForContextMenu(dbstv);
        registerForContextMenu(ocbctv);
        registerForContextMenu(uobtv);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(1, 1, 1, "Contact the bank");
        menu.add(2,2,2,"Toggle Favourite");

        if (v == dbstv) {
            wordClicked = getString(R.string.dbs);
        } else if (v == ocbctv) {
            wordClicked = getString(R.string.ocbc);
        } else if (v == uobtv) {
            wordClicked = getString(R.string.uob);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbswebsite)));
                startActivity(intent);

                return true;
            } else if (item.getItemId() == 1) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.dbsnumber)));
                startActivity(intent1);

                return true;

            } else if(!dbscolor){
                dbscolor = true;
                dbstv.setTextColor(Color.RED);
            } else{
                dbscolor = false;
                dbstv.setTextColor(Color.BLACK);
            }
        }
        if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcwebsite)));
                startActivity(intent2);

                return true;
            } else if (item.getItemId() == 1) {
                Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.ocbcnumber)));
                startActivity(intent3);

                return true;
            }else if(!ocbccolor){
                ocbccolor = true;
                ocbctv.setTextColor(Color.RED);
            }else{
                ocbccolor = false;
                ocbctv.setTextColor(Color.BLACK);
            }
        }
        if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobwebsite)));
                startActivity(intent4);

                return true;
            } else if (item.getItemId() == 1) {
                Intent intent5 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.uobnumber)));
                startActivity(intent5);

                return true;

            }else if(!uobcolor){
                uobcolor = true;
                uobtv.setTextColor(Color.RED);
            }else{
                uobcolor = false;
                uobtv.setTextColor(Color.BLACK);
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.EnglishSelection){
            dbstv.setText(getString(R.string.dbs));
            ocbctv.setText(R.string.ocbc);
            uobtv.setText(R.string.uob);
            return true;
        }
        else if(id == R.id.ChineseSelection){
            dbstv.setText(getString(R.string.dbschinese));
            ocbctv.setText(getString(R.string.ocbcchinese));
            uobtv.setText(R.string.uobchinese);
            return true;
        }
        else{
            dbstv.setText("Error Translation");
            ocbctv.setText("Error Translation");
            uobtv.setText("Error Translation");
        }
        return super.onOptionsItemSelected(item);
    }
}
