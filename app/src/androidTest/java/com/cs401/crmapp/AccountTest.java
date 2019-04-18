package com.cs401.crmapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.cs401.crmapp.controller.display.AccountActivity;
import com.cs401.crmapp.controller.display.AccountFragment;
import com.cs401.crmapp.model.Account;
import com.cs401.crmapp.model.AccountLab;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.GregorianCalendar;
import java.util.UUID;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
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
public class AccountTest {
    UUID testId;
    Context targetContext;
    @Rule
    public ActivityTestRule<AccountActivity> activityRule =
            new ActivityTestRule<AccountActivity>(AccountActivity.class, true, true){
        @Override
        protected void afterActivityFinished(){
        }
        @Override
        protected void beforeActivityLaunched(){

        }
        @Override
        protected Intent getActivityIntent(){
            targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Account account = new Account(
                    "test account", "$1", new GregorianCalendar());
            testId = account.getId();
            AccountLab.get(targetContext).getAccounts().add(account);
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            return AccountActivity.newIntent(context, testId);
        }
    };

    @Before
    public void setUp(){
    }

    @Test
    public void changeTextFields(){
        onView(withId(R.id.account_name_field)).perform(
                clearText(), typeText("Changed"), closeSoftKeyboard());
        onView(withId(R.id.account_name_field)).check(matches(
                withText(AccountLab.get(targetContext).getAccount(testId).getName())));

        onView(withId(R.id.account_amount_field)).perform(
                clearText(), typeText("2"), closeSoftKeyboard());
        onView(withId(R.id.account_amount_field)).check(matches(
                withText(AccountLab.get(targetContext).getAccount(testId).getAmount())));
    }

    /*@Test
    public void changeDate(){

    }*/

    @After
    public void tearDown(){
        if(AccountLab.get(targetContext).getAccount(testId)!=null)
            AccountLab.get(targetContext).getAccounts().remove(testId);
    }
}
