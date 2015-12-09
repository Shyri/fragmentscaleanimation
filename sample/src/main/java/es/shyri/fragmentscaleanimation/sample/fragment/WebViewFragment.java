package es.shyri.fragmentscaleanimation.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;

import es.shyri.fragmentscaleanimation.FragmentScaleAnimationProvider;
import es.shyri.fragmentscaleanimation.sample.R;

/**
 * Created by Shyri on 09/12/2015.
 */
public class WebViewFragment extends Fragment {
    FragmentScaleAnimationProvider fragmentScaleAnimationProvider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        view.findViewById(R.id.web_view).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                return fragmentScaleAnimationProvider.updateTouch(view, event);
            }
        });

        view.findViewById(R.id.web_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                WebViewFragment webViewFragment = new WebViewFragment();
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://shyri.es");
                transaction.add(R.id.fragmentContainer, webViewFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ((WebView) view.findViewById(R.id.web_view)).loadUrl(getArguments().getString("url"));
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
