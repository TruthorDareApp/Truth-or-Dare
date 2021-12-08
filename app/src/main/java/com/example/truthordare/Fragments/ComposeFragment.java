package com.example.truthordare.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cottacush.android.currencyedittext.CurrencyEditText;
import com.example.truthordare.Post;
import com.example.truthordare.R;
import com.example.truthordare.Request;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class ComposeFragment extends Fragment {

    public static final String TAG = "ComposeFragment";
    //image request code
    private EditText etDescription;
    private CurrencyEditText etDollarAmt;
    private Button btnSubmit;
    private ToggleButton togBtnReq;
    public boolean reqType;

    //empty constructor
    public ComposeFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compose, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etDollarAmt = view.findViewById(R.id.etDollarAmt);
        etDescription = view.findViewById(R.id.etDescription);
        togBtnReq = view.findViewById(R.id.togBtnReq);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        queryRequests();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dollarAmt = etDollarAmt.getText().toString();
                String description = etDescription.getText().toString();

                if(description.isEmpty()) {
                    Toast.makeText(getContext(), "Description cannot be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                if(dollarAmt.isEmpty()) {
                    Toast.makeText(getContext(), "Request amount cannot be zero", Toast.LENGTH_LONG).show();
                    return;
                }
                togBtnReq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        reqType = isChecked;
                    }
                });

                ParseUser currentUser = ParseUser.getCurrentUser();
                saveRequest(currentUser, description, dollarAmt, reqType, false);
            }
        });
    }

    private void saveRequest(ParseUser currentUser, String description, String dollarAmt, boolean reqType, boolean status) {
        Request request = new Request();

        double dollar = Double.parseDouble(dollarAmt.substring(1));

        request.setUser(currentUser);
        request.setDescription(description);
        request.setDollarAmt(dollar);
        request.setReqType(reqType);
        request.setStatus(status);
        request.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error while saving" + e);
                    Toast.makeText(getContext(), "Error while saving", Toast.LENGTH_LONG).show();
                    return;
                }
                Log.i(TAG, "post save was successful");
                Toast.makeText(getContext(), "Saved post!", Toast.LENGTH_SHORT).show();
                etDescription.setText("");
                etDollarAmt.setText("");
                //set videoFile to empty;
            }

        });
    }

    private void queryRequests() {
        ParseQuery<Request> query = ParseQuery.getQuery(Request.class);
        query.findInBackground(new FindCallback<Request>() {
            @Override
            public void done(List<Request> requests, ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for(Request request : requests) {
                    Log.i(TAG, "Post: " + request.getDescription());
                }
            }
        });
    }
}
