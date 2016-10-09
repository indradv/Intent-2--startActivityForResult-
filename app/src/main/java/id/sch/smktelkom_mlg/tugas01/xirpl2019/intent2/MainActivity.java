package id.sch.smktelkom_mlg.tugas01.xirpl2019.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 123;
    private static final int REQUEST_CODE1 = REQUEST_CODE;

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE1){
            if (resultCode==RESULT_OK){
                String nama = data.getStringExtra(InputActivity.NAMA);
                int thnlhr = data.getIntExtra(InputActivity.TAHUN_LAHIR, 0);
                TextView tvBiodata = (TextView) findViewById(R.id.textViewBiodata);
                tvBiodata.setText
                        ("Nama\t\t\t\t\t\t\t\t\t\t: " +
                                ""+nama +"\nTahun Kelahiran\t: "+thnlhr);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonInput).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, InputActivity.class), REQUEST_CODE1);
            }
        });
    }
}
