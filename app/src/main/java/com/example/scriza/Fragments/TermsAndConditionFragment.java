package com.example.scriza.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.scriza.R;
import com.example.scriza.databinding.FragmentTermsAndConditionBinding;


public class TermsAndConditionFragment extends Fragment {
    FragmentTermsAndConditionBinding binding;


    public TermsAndConditionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_terms_and_condition, container, false);
        basicMethod();
        binding.webview.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog = null;

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                binding.webview.loadUrl(url);
                return true;
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(getActivity());
                    progressDialog.setMessage("Please wait...");
                    progressDialog.show();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                try {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                } catch (Exception e) {

                }

            }
        });


        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.loadUrl("https://www.app-privacy-policy.com/live.php?token=zydmZ9Eq0EHFhtN7UZzWZwAREHRNyCBF");


        return binding.getRoot();
    }

    private void basicMethod() {
        binding.imageBack.setOnClickListener(view -> {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new ProfileFragment());
            fragmentTransaction.commit();
        });

    }
}