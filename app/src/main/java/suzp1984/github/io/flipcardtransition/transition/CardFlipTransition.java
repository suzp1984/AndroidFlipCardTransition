package suzp1984.github.io.flipcardtransition.transition;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jacobsu on 8/7/16.
 */
public class CardFlipTransition extends Visibility {

    private static final String PROPNAME_VIEW_ROTATION = "android:flip:angular";

    @Override
    public Animator onAppear(ViewGroup sceneRoot, View view,
                             TransitionValues startValues, TransitionValues endValues) {

        return null;
    }

    @Override
    public Animator onDisappear(ViewGroup sceneRoot, View view,
                                TransitionValues startValues, TransitionValues endValues) {

        return null;
    }
}
