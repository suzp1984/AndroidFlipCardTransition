package suzp1984.github.io.flipcardtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import suzp1984.github.io.flipcardtransition.transition.CardFlipTransition;

public class BigCardActivity extends AppCompatActivity {

    private static final String TAG = "BigCardActivity";

    @BindView(R.id.big_card)
    TextView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_card);

        ButterKnife.bind(this);

        setupCardFlipTransition();
        // setupSlideTransition();
    }

    @OnClick(R.id.big_card)
    public void clickCard() {
        finishAfterTransition();
    }

    private void setupCardFlipTransition() {
        CardFlipTransition flip = new CardFlipTransition();
        flip.setDuration(500);
        flip.addTarget(mCardView);
        flip.excludeTarget(android.R.id.navigationBarBackground, true);
        flip.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setExitTransition(flip);

        getWindow().setEnterTransition(flip);
        getWindow().setReenterTransition(flip);

        getWindow().setEnterTransition(flip);
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
