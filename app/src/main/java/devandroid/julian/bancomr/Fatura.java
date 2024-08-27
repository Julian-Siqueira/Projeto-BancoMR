package devandroid.julian.bancomr;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vinaygaba.creditcardview.CreditCardView;

import devandroid.julian.bancomr.databinding.ActivityFaturaBinding;

public class Fatura extends AppCompatActivity {

    ActivityFaturaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityFaturaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().hide();

        binding.toolbarFatura.setNavigationOnClickListener(view -> {
            finish();
        });

        CreditCardView creditCardView = binding.cartaoDeCredito;
        creditCardView.setCardName("Pedro L. Ferreira");
        creditCardView.setCardNumber("9987 4553 5499 2838");
        creditCardView.setExpiryDate("22/24");
    }
}