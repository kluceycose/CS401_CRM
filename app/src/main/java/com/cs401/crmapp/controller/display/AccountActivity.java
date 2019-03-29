package com.cs401.crmapp.controller.display;

/**
 *
 * @author kluceycose
 */

/*
 * This Activity starts and holds an AccountFragment, initialized with the
 * Account clicked on by the user in the RecyclerView list of Accounts
 */

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.cs401.crmapp.controller.SingleFragmentActivity;

import java.util.UUID;

public class AccountActivity extends SingleFragmentActivity {
    private static final String EXTRA_ACCOUNT_ID = "com.cs401.crmapp.controller.account_id";

    //Create a new AccountActivity intent, and add an Account id as an extra
    // before returning the intent
    public static Intent newIntent(Context packageContext, UUID account_id){
        Intent intent = new Intent(packageContext, AccountActivity.class);
        intent.putExtra(EXTRA_ACCOUNT_ID, account_id);
        return intent;
    }

    @Override
    //Get the Account id from the intent and pass it to AccountFragment
    // to initialize with before returning the new AccountFragment
    protected Fragment createFragment(){
        UUID accountID = (UUID)getIntent().getSerializableExtra(EXTRA_ACCOUNT_ID);
        return AccountFragment.newInstance(accountID);
    }
}
