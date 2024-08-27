package devandroid.julian.bancomr;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.julian.bancomr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blue));
        }

        binding.imgSaldo.setOnClickListener(this);
        binding.imgFaturas.setOnClickListener(this);
        binding.imgTransferencia.setOnClickListener(this);
        binding.imgPoupanca.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.img_saldo) {
            Intent navegarTelaSaldo = new Intent(MainActivity.this, Saldo.class);
            startActivity(navegarTelaSaldo);
        } else if (id == R.id.img_faturas) {
            Intent navegarTelaFatura = new Intent(MainActivity.this, Fatura.class);
            startActivity(navegarTelaFatura);
        } else if (id == R.id.img_transferencia) {
            Intent navegarTelaTransferencia = new Intent(MainActivity.this, Transferencia.class);
            startActivity(navegarTelaTransferencia);
        } else {
            Intent navegarTelaPoupanca = new Intent(MainActivity.this, Poupanca.class);
            startActivity(navegarTelaPoupanca);
        }
    }
}