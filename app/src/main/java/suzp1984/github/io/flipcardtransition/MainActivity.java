package suzp1984.github.io.flipcardtransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.text_card)
    TextView mTextCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // setupCardFlipTransition();
        setupSlideTransition();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.text_card)
    public void clickCard() {
        Log.e(TAG, "on Click text_card");
        Intent intent = new Intent(this, BigCardActivity.class);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }

    private void setupCardFlipTransition() {


    }

    private void setupSlideTransition() {
        Slide slideEnter = new Slide();
        slideEnter.addTarget(R.id.text_card);
        slideEnter.setDuration(1000);
        slideEnter.setStartDelay(500);
        slideEnter.setSlideEdge(Gravity.RIGHT);
        slideEnter.excludeTarget(android.R.id.navigationBarBackground, true);
        slideEnter.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setEnterTransition(slideEnter);
        getWindow().setReenterTransition(slideEnter);

        Slide slideOut = new Slide();
        slideOut.addTarget(R.id.text_card);
        slideOut.setDuration(500);
        slideOut.setSlideEdge(Gravity.RIGHT);
        slideOut.excludeTarget(android.R.id.navigationBarBackground, true);
        slideOut.excludeTarget(android.R.id.statusBarBackground, true);
        getWindow().setExitTransition(slideOut);
    }
}
