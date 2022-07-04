package com.skel.appskeleton.domain.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.skel.appskeleton.domain.interfaces.IFragment;

public abstract class BaseFragment extends Fragment implements IFragment {

    protected View getView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        try {

            int content_layout = setContentLayout();
            if(content_layout == 0){
                showToast("MISSING LAYOUT");
                return null;
            }
            getView = inflater.inflate(content_layout, container, false);

            onCreateLayout(getView);

        }catch (Exception e){
            e.printStackTrace();
        }
        return getView;
    }

    protected void showToast(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
