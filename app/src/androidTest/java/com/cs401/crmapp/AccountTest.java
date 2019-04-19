package com.cs401.crmapp;

import android.content.Context;
import android.content.Intent;

import com.cs401.crmapp.controller.display.AccountActivity;
import com.cs401.crmapp.model.Account;
import com.cs401.crmapp.model.AccountLab;
import com.cs401.crmapp.model.Contact;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.GregorianCalendar;
import java.util.UUID;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
            account.addContact(new Contact("Dude Man",
                    "dudeman@company.net",
                    "9394029587"));
            account.addContact(new Contact("80's Guy",
                    "sleezinitup@backtothetop.net",
                    "9402847384"));
            testId = account.getId();
            AccountLab.get(targetContext).getAccounts().add(account);
            return AccountActivity.newIntent(targetContext, testId);
        }
    };

    @Test
    public void changeTextFields(){
        onView(withId(R.id.account_name_field))
                .perform(clearText(), typeText("Changed"), closeSoftKeyboard());
        onView(withText(AccountLab.get(targetContext).getAccount(testId).getName()))
                .check(matches(isDisplayed()));

        onView(withId(R.id.account_amount_field))
                .perform(clearText(), typeText(targetContext.getString(R.string.test_account_amount)),
                        closeSoftKeyboard());
        onView(withText(AccountLab.get(targetContext).getAccount(testId).getAmount()))
                .check(matches(isDisplayed()));
    }

    @Test
    public void changeDate() throws InterruptedException {
        onView(withId(R.id.account_close)).perform(click());
        onView(withId(R.id.dialog_date_picker)).perform(setDate(2019, 3, 17));
        onView(withText("OK")).perform(click());

        Thread.sleep(500); //give time to update the date displayed

        onView(withId(R.id.account_close)).check(matches(withText("3/17/2019")));
    }

    @Test
    public void contactList_CheckOrder(){
        onView(withId(R.id.contact_recycler_view))
                .check(matches(atPosition(
                        0, hasDescendant(withText(
                                AccountLab.get(targetContext)
                                        .getAccount(testId)
                                        .getContacts()
                                        .get(0).getName()))
                )));
    }

    @Test
    public void contactList_CheckOnClickListener(){
        onView(withId(R.id.contact_recycler_view)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.contact_name_field))
                .check(matches(withText(
                        AccountLab.get(targetContext)
                                .getAccount(testId)
                                .getContacts()
                                .get(0).getName()
                )));
    }

    @After
    public void tearDown(){
        if(AccountLab.get(targetContext).getAccount(testId)!=null)
            AccountLab.get(targetContext).getAccounts().remove(testId);
    }
}
