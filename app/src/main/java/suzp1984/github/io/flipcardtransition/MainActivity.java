package suzp1984.github.io.flipcardtransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import suzp1984.github.io.flipcardtransition.transition.CardFlipTransition;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.text_card)
    CardView mTextCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Small Card");

        ButterKnife.bind(this);

        setupCardFlipTransition();
        // setupSlideTransition();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.clickme)
    public void clickCard() {
        Log.d(TAG, "on Click text_card");
        Intent intent = new Intent(this, BigCardActivity.class);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }

    private void setupCardFlipTransition() {
        CardFlipTransition flip = new CardFlipTransition();
        flip.setDuration(500);
        flip.addTarget(mTextCard);
        flip.excludeTarget(android.R.id.navigationBarBackground, true);
        flip.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setExitTransition(flip);

        getWindow().setEnterTransition(flip);
        getWindow().setReenterTransition(flip);

        getWindow().setEnterTransition(flip);
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
