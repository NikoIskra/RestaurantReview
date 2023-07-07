package android.tvz.hr.kalkulatoriskra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.tvz.hr.kalkulatoriskra.databinding.ActivityMainBinding;
import android.view.View;
import android.widget.SeekBar;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.finalNajava.setVisibility(View.GONE);

        binding.seekBarNumStars.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i<80) {
                    binding.uslugaRatingBar.setNumStars(i / 10);
                    binding.cijenaRatingBar.setNumStars(i / 10);
                    binding.hranaRatingBar.setNumStars(i / 10);
                    binding.brzinaRatingBar.setNumStars(i / 10);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.finalNajava.setVisibility(View.VISIBLE);
                float numberOfStars=0;
                numberOfStars=numberOfStars + binding.uslugaRatingBar.getRating() + binding.cijenaRatingBar.getRating() + binding.hranaRatingBar.getRating() + binding.brzinaRatingBar.getRating();
                NumberFormat nf = new DecimalFormat("##.###");
                binding.ocjenaText.setText(String.valueOf(nf.format(numberOfStars)));
            }
        });


    }
}