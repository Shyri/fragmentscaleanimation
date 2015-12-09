package es.shyri.fragmentscaleanimation;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;

/**
 * Created by Shyri on 04/12/2015.
 */
public interface FragmentScaleAnimationProvider {
    public boolean updateTouch (View view, MotionEvent event);
    public Animation getFragmentScaleAnimation(int transit, boolean enter, int nextAnim);
}
