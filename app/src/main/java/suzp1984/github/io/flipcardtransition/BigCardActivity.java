package suzp1984.github.io.flipcardtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Slide;
import android.transition.Visibility;
import android.util.Log;
import android.view.Gravity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import suzp1984.github.io.flipcardtransition.transition.CardFlipTransition;

public class BigCardActivity extends AppCompatActivity {

    private static final String TAG = "BigCardActivity";

    @BindView(R.id.big_card)
    CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_card);
        setTitle("Big Card");
        ButterKnife.bind(this);

        setupCardFlipTransition();
        // setupSlideTransition();
    }

    @OnClick(R.id.big_card)
    public void clickCard() {
        Log.d(TAG, "clicked big card");
        setResult(RESULT_OK);
        finishAfterTransition();
        // finish();
        // finishActivity(10);
    }

    private void setupCardFlipTransition() {
        CardFlipTransition flipIn = new CardFlipTransition();
        flipIn.setDuration(500);
        flipIn.setMode(Visibility.MODE_IN);
        flipIn.addTarget(R.id.big_card);
        flipIn.excludeTarget(android.R.id.navigationBarBackground, true);
        flipIn.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setEnterTransition(flipIn);

        CardFlipTransition flipOut = new CardFlipTransition();
        flipOut.setMode(Visibility.MODE_OUT);
        flipOut.setDuration(500);
        flipOut.addTarget(R.id.big_card);
        flipOut.excludeTarget(android.R.id.navigationBarBackground, true);
        flipOut.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setExitTransition(flipOut);
    }

    private void setupSlideTransition() {
        Slide slideEnter = new Slide();
        slideEnter.setSlideEdge(Gravity.LEFT);
        slideEnter.setDuration(500);
        slideEnter.setStartDelay(250);
        slideEnter.excludeTarget(android.R.id.navigationBarBackground, true);
        slideEnter.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setEnterTransition(slideEnter);

        Slide slideOut = new Slide();
        slideOut.setSlideEdge(Gravity.RIGHT);
        slideOut.setDuration(500);
        slideOut.setStartDelay(0);
        slideOut.excludeTarget(android.R.id.navigationBarBackground, true);
        slideOut.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setExitTransition(slideOut);
    }
}
