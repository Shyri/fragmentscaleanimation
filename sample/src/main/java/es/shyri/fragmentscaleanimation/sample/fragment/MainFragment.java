package es.shyri.fragmentscaleanimation.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import es.shyri.fragmentscaleanimation.FragmentScaleAnimationProvider;
import es.shyri.fragmentscaleanimation.sample.R;

/**
 * Created by Shyri on 09/12/2015.
 */
public class MainFragment extends Fragment {

    FragmentScaleAnimationProvider fragmentScaleAnimationProvider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                return fragmentScaleAnimationProvider.updateTouch(view, event);
            }
        });

        view.findViewById(R.id.btn_webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragmentContainer, new WebViewFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        fragmentScaleAnimationProvider = (FragmentScaleAnimationProvider) getActivity();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return fragmentScaleAnimationProvider.getFragmentScaleAnimation(transit, enter, nextAnim);
    }

}