package suzp1984.github.io.flipcardtransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Slide;
import android.transition.Visibility;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import suzp1984.github.io.flipcardtransition.transition.CardFlipTransition;

public class FlipCardTransitionActivity extends AppCompatActivity {

    private static final String TAG = "FlipCardTransition";

    @BindView(R.id.text_card)
    CardView mTextCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_card_transition);
        setTitle("Small Card");

        ButterKnife.bind(this);

        setupCardFlipTransition();
        // setupSlideTransition();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // super.onActivityResult(requestCode, resultCode, intent);
        Log.d(TAG, "onActivityResult: " + requestCode + ", " + resultCode);
    }

    @OnClick(R.id.clickme)
    public void startFlipCardTransition() {
        Log.d(TAG, "start flip card transition");

        Intent intent = new Intent(this, BigCardActivity.class);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        // startActivity(intent, options.toBundle());
        startActivityForResult(intent, 10, options.toBundle());
    }

    private void setupCardFlipTransition() {
        CardFlipTransition flipOut = new CardFlipTransition();
        flipOut.setDuration(500);
        flipOut.setMode(Visibility.MODE_OUT);
        flipOut.addTarget(R.id.text_card);
        flipOut.excludeTarget(android.R.id.navigationBarBackground, true);
        flipOut.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setExitTransition(flipOut);

        CardFlipTransition flipIn = new CardFlipTransition();
        flipIn.setDuration(500);
        flipIn.setMode(Visibility.MODE_IN);
        flipIn.addTarget(R.id.text_card);
        flipIn.excludeTarget(android.R.id.navigationBarBackground, true);
        flipIn.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setEnterTransition(flipIn);

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
        // Tips: Cann't set same Transition object to more than one Transition callbacks.
        // getWindow().setReenterTransition(slideEnter);

        Slide slideOut = new Slide();
        slideOut.addTarget(R.id.text_card);
        slideOut.setDuration(500);
        slideOut.setSlideEdge(Gravity.RIGHT);
        slideOut.excludeTarget(android.R.id.navigationBarBackground, true);
        slideOut.excludeTarget(android.R.id.statusBarBackground, true);
        getWindow().setExitTransition(slideOut);
    }
}
