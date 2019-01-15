package james.metronome.simple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import james.metronome.activities.MetronomeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMetronome();
            }
        });
    }

    private void startMetronome() {
        Intent intent = new Intent(this, MetronomeActivity.class);
        this.startActivity(intent);
    }
}
