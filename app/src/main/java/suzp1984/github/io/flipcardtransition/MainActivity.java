package suzp1984.github.io.flipcardtransition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        ButterKnife.bind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.windows_transition_btn)
    public void startFlipCardTransition(View v) {
        Intent intent = new Intent(this, FlipCardTransitionActivity.class);

        startActivity(intent);
    }

}
