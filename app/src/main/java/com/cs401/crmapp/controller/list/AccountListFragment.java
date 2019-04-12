package com.cs401.crmapp.controller.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.cs401.crmapp.R;
import com.cs401.crmapp.controller.display.AccountActivity;
import com.cs401.crmapp.model.Account;
import com.cs401.crmapp.model.AccountLab;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class AccountListFragment extends Fragment {
    private RecyclerView mAccountRecyclerView;
    private Button mAddAccountButton;
    private AccountAdapter mAdapter;

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_account_list, container, false);

        mAccountRecyclerView = (RecyclerView)view.findViewById(R.id.account_recycler_view);
        mAccountRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        mAddAccountButton = (Button)view.findViewById(R.id.add_account_button);
        mAddAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AccountActivity.newIntent(getActivity(), addAccount());
                startActivity(intent);
            }
        });

        return view;
    }

    private void updateUI(){
        AccountLab accountLab = AccountLab.get(getActivity());
        List<Account> accounts = accountLab.getAccounts();

        if(mAdapter == null){
            mAdapter = new AccountAdapter(accounts);
            mAccountRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.notifyDataSetChanged();
        }
    }

    private UUID addAccount(){
        AccountLab accountLab = AccountLab.get(getActivity());
        List<Account> accounts = accountLab.getAccounts();
        accounts.add(new Account());
        return accounts.get(accounts.size()-1).getId();
    }

    private class AccountHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView mAccountName;
        private TextView mAccountAmount;
        private TextView mCloseDate;
        private Account mAccount;

        public AccountHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_account, parent, false));
            itemView.setOnClickListener(this);

            mAccountName = (TextView)itemView.findViewById(R.id.account_name_list);
            mAccountAmount = (TextView)itemView.findViewById(R.id.account_amount_list);
            mCloseDate = (TextView)itemView.findViewById(R.id.close_date_list);
        }

        public void bind(Account account){
            mAccount = account;
            mAccountName.setText(account.getName());
            mAccountAmount.setText(account.getAmount());
            Calendar closeDate = account.getCloseDate();
            if(closeDate != null){
                String closeString = (closeDate.get(Calendar.MONTH)+1) + "/" + closeDate.get(Calendar.DAY_OF_MONTH)+
                        "/"+closeDate.get(Calendar.YEAR);
                mCloseDate.setText(closeString);
            }
        }

        @Override
        public void onClick(View view){
            Intent intent = AccountActivity.newIntent(getActivity(), mAccount.getId());
            startActivity(intent);
        }
    }

    private class AccountAdapter extends RecyclerView.Adapter<AccountHolder>{
        private List<Account> mAccounts;

        public AccountAdapter(List<Account> accounts){
            mAccounts = accounts;
        }

        @Override
        public AccountHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new AccountHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(AccountHolder holder, int position){
            Account account = mAccounts.get(position);
            holder.bind(account);
        }

        @Override
        public int getItemCount(){
            return mAccounts.size();
        }
    }
}
