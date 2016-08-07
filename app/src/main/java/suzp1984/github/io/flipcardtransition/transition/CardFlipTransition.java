package suzp1984.github.io.flipcardtransition.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/**
 * Created by jacobsu on 8/7/16.
 */
public class CardFlipTransition extends Visibility {

    private static final String PROPNAME_VIEW_ROTATION = "android:flip:angular";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);

        captureValues(transitionValues);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);

        captureValues(transitionValues);
    }

    @Override
    public Animator onAppear(ViewGroup sceneRoot, View view,
                             TransitionValues startValues, TransitionValues endValues) {

        view.setRotationY(-90);
        Animator rotateY = ObjectAnimator.ofFloat(view, "rotationY", 0);
        rotateY.setDuration(1000);
        rotateY.setStartDelay(500);
        CardFlipRotationListener listener = new CardFlipRotationListener(view);
        rotateY.addListener(listener);
        addListener(listener);
        rotateY.addPauseListener(listener);
        // set Interpolator later

        return rotateY;
    }

    @Override
    public Animator onDisappear(ViewGroup sceneRoot, View view,
                                TransitionValues startValues, TransitionValues endValues) {
        view.setRotationY(0);
        Animator rotateY = ObjectAnimator.ofFloat(view, "rotationY", 90);
        rotateY.setDuration(500);
        CardFlipRotationListener listener = new CardFlipRotationListener(view);
        rotateY.addListener(listener);
        addListener(listener);
        rotateY.addPauseListener(listener);
        // set Interpolator later

        return rotateY;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        float angular;

        angular = view.getRotationY();
        transitionValues.values.put(PROPNAME_VIEW_ROTATION, angular);
    }

    private static class CardFlipRotationListener extends AnimatorListenerAdapter implements TransitionListener {

        private final View mView;

        public CardFlipRotationListener(View view) {
            mView = view;
        }

        @Override
        public void onAnimationStart(Animator animator) {

        }

        @Override
        public void onAnimationEnd(Animator animator) {
            mView.setRotationY(0);
        }

        @Override
        public void onAnimationPause(Animator animator) {

        }

        @Override
        public void onAnimationResume(Animator animator) {

        }

        // TransitionListener
        @Override
        public void onTransitionStart(Transition transition) {

        }

        @Override
        public void onTransitionEnd(Transition transition) {
            mView.setRotationY(0);
        }

        @Override
        public void onTransitionCancel(Transition transition) {

        }

        @Override
        public void onTransitionPause(Transition transition) {

        }

        @Override
        public void onTransitionResume(Transition transition) {

        }
    }

}
