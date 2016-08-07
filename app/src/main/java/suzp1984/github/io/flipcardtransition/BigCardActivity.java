package suzp1984.github.io.flipcardtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BigCardActivity extends AppCompatActivity {

    private static final String TAG = "BigCardActivity";

    @BindView(R.id.big_card)
    TextView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_card);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.big_card)
    public void clickCard() {
        finishAfterTransition();
    }
}
