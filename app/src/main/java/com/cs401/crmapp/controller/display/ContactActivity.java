package com.cs401.crmapp.controller.display;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.cs401.crmapp.controller.SingleFragmentActivity;
import com.cs401.crmapp.model.Contact;

public class ContactActivity extends SingleFragmentActivity {
    private static final String EXTRA_CONTACT = "com.cs401.crmapp.controller.contact";

    //Create a new ContactActivity intent, and add a Contact as an extra
    // before returning the intent
    public static Intent newIntent(Context packageContext, Contact contact){
        Intent intent = new Intent(packageContext, ContactActivity.class);
        intent.putExtra(EXTRA_CONTACT, contact);
        return intent;
    }

    @Override
    //Get the Contact from the intent and pass it to ContactFragment
    // to initialize with before returning the new ContactFragment
    protected Fragment createFragment(){
        Contact contact = (Contact)getIntent().getSerializableExtra(EXTRA_CONTACT);
        return ContactFragment.newInstance(contact);
    }
}
