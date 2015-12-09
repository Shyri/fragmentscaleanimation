package es.shyri.fragmentscaleanimation;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by Shyri on 04/12/2015.
 */
public class FragmentScaleAnimationHandler {
    float lastTouchedX = 0;
    float lastTouchedY = 0;

    public Animation getFragmentScaleAnimation (int transit, boolean enter, int nextAnim) {
        ScaleAnimation animation;
        if (enter) {
            animation = new ScaleAnimation((float) 0.0, (float) 1.0, (float) 0.0, (float) 1.0, Animation.ABSOLUTE, lastTouchedX, Animation.ABSOLUTE, lastTouchedY);
        } else {
            animation = new ScaleAnimation((float) 1.0, (float) 0.0, (float) 1.0, (float) 0.0, Animation.ABSOLUTE, lastTouchedX, Animation.ABSOLUTE, lastTouchedY);
        }
        animation.setDuration(500);
        return animation;
    }

    public void setLastTochedX(float lastTouchedX) {
        this.lastTouchedX = lastTouchedX;
    }

    public void setLastTouchedY(float lastTouchedY) {
        this.lastTouchedY = lastTouchedY;
    }
}
