package es.shyri.fragmentscaleanimation.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;

import es.shyri.fragmentscaleanimation.FragmentScaleAnimationHandler;
import es.shyri.fragmentscaleanimation.FragmentScaleAnimationProvider;
import es.shyri.fragmentscaleanimation.sample.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements FragmentScaleAnimationProvider {
    FragmentScaleAnimationHandler fragmentScaleAnimationHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentScaleAnimationHandler = new FragmentScaleAnimationHandler();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer, new MainFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean updateTouch(View view, MotionEvent event) {
        fragmentScaleAnimationHandler.setLastTochedX(event.getRawX());
        fragmentScaleAnimationHandler.setLastTouchedY(event.getRawY());
        return false;
    }

    @Override
    public Animation getFragmentScaleAnimation(int transit, boolean enter, int nextAnim) {
        return fragmentScaleAnimationHandler.getFragmentScaleAnimation(transit, enter, nextAnim);
    }
}
