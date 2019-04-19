package com.cs401.crmapp.controller.display;

/**
 *
 * @author kluceycose
 */

/*
 * This ContactFragment class displays all the information contained in
 *  the Contact it was initialized with. In the case of a new Contact,
 *  default text is displayed instead (coded into the
 *  fragment_account.xml file).
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cs401.crmapp.R;
import com.cs401.crmapp.model.Contact;

public class ContactFragment extends Fragment {
    //Contact argument key
    private static final String ARG_CONTACT = "contact";
    //Contact and Contact_ID extra keys
    public static final String EXTRA_CONTACT = "com.cs401.crmapp.controller.display.contact";
    private Contact mContact;

    // returns a new instance of ContactFragment with the Contact to be
    //  displayed attached as an Argument
    public static ContactFragment newInstance(Contact contact) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONTACT, contact);
        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    // initializes mContact with the Contact attached as an Argument
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContact = (Contact) getArguments().getSerializable(ARG_CONTACT);
    }

    @Override
    // creates the full View, and saves changes to fields
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact,
                container,
                false);

        //initialize mName
        EditText mName = (EditText) v.findViewById(R.id.contact_name_field);
        mName.setText(mContact.getName());
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mContact.setName(s.toString()); // update Contact name
                setContactResult(); // inform AccountFragment of a change
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //initialize mEmail
        EditText mEmail = (EditText) v.findViewById(R.id.contact_email_field);
        mEmail.setText(mContact.getEmail());
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mContact.setEmail(s.toString()); // update Contact email
                setContactResult(); // inform AccountFragment of a change
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //initialize mPhone
        EditText mPhone = (EditText) v.findViewById(R.id.contact_phone_field);
        mPhone.setText(mContact.getPhoneNumber());
        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mContact.setPhoneNumber(s.toString()); // update Contact phone number
                setContactResult(); // inform AccountFragment of a change
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }

    // returns RESULT_OK with the updated Contact as an Extra in the Intent
    public void setContactResult(){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CONTACT, mContact);
        getActivity().setResult(Activity.RESULT_OK, intent);
    }
}
