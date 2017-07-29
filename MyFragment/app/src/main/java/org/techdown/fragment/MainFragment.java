package org.techdown.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 *
 */

public class MainFragment extends Fragment {

    // setContent가 없음.
    // 보통은 interface로 활용해 activity가 변경될경우에도 호환이되게 코드를 작성한다.
    MainActivity activity;

    @Override
    // 프래그먼트가 액티비티 위에 올라왔을때, (실행되기전) 호출
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();
    }

    @Override

    // 프래그먼트가 액티비티 위에서 내려올때, (종료되기전) 호출
    public void onDetach() {
        super.onDetach();

        activity = null;

    }

    @Nullable
    @Override
    // 부분화면을 담기위한 틀
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(1);
            }
        });


        return rootView;
    }
}
