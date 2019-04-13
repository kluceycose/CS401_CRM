package com.cs401.crmapp.controller.display;

/**
 *
 * @author kluceycose
 */

/*
 * This AccountFragment class displays all the information contained in
 *  the Account it was initialized with. In the case of a new Account,
 *  default text is displayed instead (coded into the
 *  fragment_account.xml file). Contacts are displayed in a list using
 *  RecyclerView.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cs401.crmapp.model.Account;
import com.cs401.crmapp.model.AccountLab;
import com.cs401.crmapp.R;
import com.cs401.crmapp.model.Contact;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

public class AccountFragment extends Fragment {
    private Account mAccount;                   // An Account object reference
    private EditText mNameField;                // a Name EditText reference
    private EditText mAmountField;              // an Amount EditText reference
    private Button mDateButton;                 // a Date Button reference
    private Button mAddContact;                 // an Add Contact Button reference
    private RecyclerView mContactRecyclerView;  // a Contact RecyclerView reference
    private ContactAdapter mAdapter;            // a ContactAdapter reference

    // an argument key to add to the bundle during initialization
    private static final String ARG_ACCOUNT_ID = "account_id";
    //DatePicker's tag
    private static final String DIALOG_DATE = "DialogDate";
    //Date request code
    private static final int REQUEST_DATE = 0;
    //Contact request code
    private static final int REQUEST_CONTACT = 1;
    //Log tag for debug use
    private final String TAG = "AccountFragment_only";

    // creates an instance of AccountFragment with Account Id argument
    public static AccountFragment newInstance(UUID accountId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_ACCOUNT_ID, accountId);
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    // updates UI when onResume() is called
    public void onResume(){
        super.onResume();
        updateList();
    }


    @Override
    // initialize mAccount using the Account Id passed as an argument
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID accountID = (UUID)getArguments().getSerializable(ARG_ACCOUNT_ID);
        mAccount = AccountLab.get(getActivity()).getAccount(accountID);
    }

    @Override
    // creates the full View, and saves changes to fields
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account,
                container,
                false);

        // initialize mTitleField
        mNameField = (EditText)v.findViewById(R.id.account_name_field);
        mNameField.setText(mAccount.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s,   // User input
                                      int start, int before, int count) {
                mAccount.setAccountName(s.toString());  // set the name to the users input
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // initialize mAmountField
        mAmountField = (EditText)v.findViewById(R.id.account_amount_field);
        mAmountField.setText(mAccount.getAmount());
        mAmountField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s,   // User input
                                      int start, int before, int count) {
                String newS;
                if(s.length()>0){
                    if(s.charAt(0)!='$'){ //if user removed '$', add it before changing mAccount
                        newS = "$"+s.toString();
                    }
                    else
                        newS = s.toString();
                }
                else
                    newS = "$";
                mAccount.setAmount(newS);// set the amount to the users input
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Initialize mDateButton
        mDateButton = (Button)v.findViewById(R.id.account_close);
        final Calendar closeDate = mAccount.getCloseDate();
        if(closeDate != null){
            // add 1 to Calendar.MONTH to display correct Month number
            String closeString = (closeDate.get(Calendar.MONTH)+1) + "/" +
                    closeDate.get(Calendar.DAY_OF_MONTH) + "/" +
                    closeDate.get(Calendar.YEAR);
            mDateButton.setText(closeString);
        }
        // clicking mDateButton will open a DatePicker dialog to choose the date
        mDateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentManager fm = getFragmentManager();
                if(closeDate == null) //if no previous date, make a new one
                    mAccount.setCloseDate(new GregorianCalendar());
                DatePickerFragment dialog = DatePickerFragment.newInstance(
                        mAccount.getCloseDate().getTime());
                dialog.setTargetFragment(AccountFragment.this, REQUEST_DATE);
                dialog.show(fm, DIALOG_DATE);
            }
        });

        // initialize mContactRecyclerView
        mContactRecyclerView = (RecyclerView)v.findViewById(R.id.contact_recycler_view);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateList();

        // initialize mAddContact
        mAddContact = (Button)v.findViewById(R.id.button_add_contact);
        // clicking Add Contact button will create and add a new Contact to
        //  mAccount, then start an instance of ContactActivity using the
        //  new Contact
        mAddContact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mAccount.addContact(new Contact());
                Intent intent = ContactActivity.newIntent(getActivity(),
                        mAccount.getContacts().get(mAccount.getContacts().size()-1));
                startActivityForResult(intent, REQUEST_CONTACT);
            }
        });

        return v;
    }

    // initialize the ContactAdapter for the RecyclerView
    private void updateList(){
        List<Contact> contacts = mAccount.getContacts();

        // if mAdapter is null, create a new one
        if(mAdapter == null){
            mAdapter = new ContactAdapter(contacts);
            mContactRecyclerView.setAdapter(mAdapter);
        }
        // otherwise, notify Adapter something may have changed
        else{
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    // Handle returns from DatePickerFragment and ContactFragment
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode != Activity.RESULT_OK)
            return;
        // if returning from DatePickerFragment, get new Date from the intent
        //  and update mAccount with it
        if(requestCode == REQUEST_DATE){
            Date date = (Date)data.getSerializableExtra(
                    DatePickerFragment.EXTRA_DATE);
            GregorianCalendar closeDate = new GregorianCalendar();
            closeDate.setTime(date);
            mAccount.setCloseDate(closeDate);
            String closeString = (closeDate.get(Calendar.MONTH)+1) + "/" + closeDate.get(Calendar.DAY_OF_MONTH)+
                    "/"+closeDate.get(Calendar.YEAR);
            mDateButton.setText(closeString);
        }
        // if returning from ContactFragment, find which Contact to update in
        //  the list of Contacts from mAccount and update it
        if(requestCode == REQUEST_CONTACT){
            Contact contact = (Contact)data.getSerializableExtra(ContactFragment.EXTRA_CONTACT);
            List<Contact> contactList = mAccount.getContacts();
            Log.d(TAG, ("incoming id: "+ contact.getId().toString()));
            for(int i = 0; i< contactList.size(); i++){
                Log.d(TAG, "old id: "+contactList.get(i).getId().toString());
                if(contact.getId().equals(contactList.get(i).getId())){
                    contactList.set(i, contact);
                    break;
                }
            }
        }
    }

    // Holder class for use by ContactAdapter. Inflates view for each
    //  Contact in the list
    private class ContactHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView mContactName;
        private TextView mContactEmail;
        private TextView mContactPhone;
        private Contact mContact;

        // Constructor, initializes the text of each View element
        private ContactHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_contact, parent, false));
            itemView.setOnClickListener(this);

            mContactName = (TextView)itemView.findViewById(R.id.contact_name);
            mContactEmail = (TextView)itemView.findViewById(R.id.contact_email);
            mContactPhone = (TextView)itemView.findViewById(R.id.contact_phone);
        }

        // called when this Holder is recycled for a new Contact
        private void bind(Contact contact){
            mContact = contact;
            mContactName.setText(contact.getName());
            mContactEmail.setText(contact.getEmail());
            mContactPhone.setText(contact.getPhoneNumber());
        }

        @Override
        // when a Contact View is clicked, start a new instance of
        //  ContactActivity, passing mContact as an argument
        public void onClick(View view){
            Intent intent = ContactActivity.newIntent(getActivity(), mContact);
            startActivityForResult(intent, REQUEST_CONTACT);
        }
    }

    // ContactAdapter creates ContactHolders and distributes Contacts
    //  to created ContactHolders as requested by RecyclerView
    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder>{
        private List<Contact> mContacts;

        // Constructor initializes mContacts
        private ContactAdapter(List<Contact> contacts){
            mContacts = contacts;
        }

        @Override
        // Create and return a new ContactHolder
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ContactHolder(layoutInflater, parent);
        }

        @Override
        // Bind a Contact to an available ContactHolder
        public void onBindViewHolder(ContactHolder holder, int position){
            Contact contact = mContacts.get(position);
            holder.bind(contact);
        }

        @Override
        // return the size of the full list of Contacts
        public int getItemCount(){
            return mContacts.size();
        }
    }
}
