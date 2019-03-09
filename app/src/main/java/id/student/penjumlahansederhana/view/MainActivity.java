package id.student.penjumlahansederhana.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.student.penjumlahansederhana.R;
import id.student.penjumlahansederhana.model.LuasPersegi;
import id.student.penjumlahansederhana.presenter.InterfaceMain;
import id.student.penjumlahansederhana.presenter.PresenterMain;

public class MainActivity extends AppCompatActivity  implements InterfaceMain {

    private EditText editTextPanjang;
    private EditText editTextLebar;
    private TextView textViewHasil;
    private Button buttonHitung;
    private PresenterMain presenterMain;
    private LuasPersegi luasPersegi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi objek
        editTextLebar = findViewById(R.id.ed_lebar);
        editTextPanjang = findViewById(R.id.ed_panjang);
        textViewHasil = findViewById(R.id.tv_hasil);
        buttonHitung = findViewById(R.id.button_hitunng);
        luasPersegi = new LuasPersegi();
        presenterMain = new PresenterMain(this);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextLebar.getText().toString().isEmpty() && !editTextPanjang.getText().toString().isEmpty()){
                    luasPersegi.setLebar(Integer.parseInt(editTextLebar.getText().toString()));
                    luasPersegi.setPanjang(Integer.parseInt(editTextPanjang.getText().toString()));
                    presenterMain.hitungLuas(luasPersegi);
                }else {
                    Toast.makeText(MainActivity.this,"Inputan Tidak Boleh Ada yang Kosong!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void hasil(LuasPersegi luasPersegi) {
        textViewHasil.setText("Hasilnya = " + luasPersegi.getHasil());
    }
}
