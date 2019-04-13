package com.cs401.crmapp;

import com.cs401.crmapp.controller.list.AccountListActivity;
import com.cs401.crmapp.controller.list.AccountListFragment;
import com.cs401.crmapp.model.AccountLab;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.PickerActions.setDate;
import static com.cs401.crmapp.TestUtils.atPosition;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AccountListTest {
    @Rule
    public ActivityTestRule<AccountListActivity> activityRule =
            new ActivityTestRule<>(AccountListActivity.class, true, true);

    @Test
    public void checkListDisplay(){
        //Ensure first item in RecyclerView is the first item added to AccountLab
        onView(withId(R.id.account_recycler_view))
                .check(matches(atPosition(
                        0, hasDescendant(withText(
                            AccountLab.get(activityRule.getActivity().getBaseContext())
                                        .getAccounts().get(0).getName())))));
    }

    @Test
    public void openItem() {
        //Ensure correct Account is opened on click
        onView(withId(R.id.account_recycler_view))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.account_name_field))
                .check(matches(withText(
                        AccountLab.get(activityRule.getActivity().getBaseContext())
                            .getAccounts().get(0).getName())));
    }

    @Test
    public void addAccount(){
        //Ensure new Accounts are added to end of the list
        onView(withId(R.id.add_account_button)).perform(click());
        onView(withId(R.id.account_name_field))
                .perform(typeText("sample account"), closeSoftKeyboard());
        Espresso.pressBack();
        int position = AccountLab.get(activityRule.getActivity().getBaseContext())
                            .getAccounts().size()-1;
        onView(withId(R.id.account_recycler_view))
                .check(matches(atPosition(
                        position, hasDescendant(withText(
                                AccountLab.get(activityRule.getActivity().getBaseContext())
                                        .getAccounts().get(position).getName())))));
    }
}
