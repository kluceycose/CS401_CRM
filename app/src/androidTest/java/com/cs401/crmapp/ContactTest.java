package com.cs401.crmapp;

import android.content.Context;
import android.content.Intent;

import com.cs401.crmapp.controller.display.ContactActivity;
import com.cs401.crmapp.model.Contact;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ContactTest {

    UUID testId;
    Context targetContext;
    Contact contact;
    @Rule
    public ActivityTestRule<ContactActivity> activityRule =
            new ActivityTestRule<ContactActivity>(ContactActivity.class, true, true) {
                @Override
                protected void afterActivityFinished() {
                }

                @Override
                protected void beforeActivityLaunched() {

                }

                @Override
                protected Intent getActivityIntent() {
                    targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    contact = new Contact("Dude Man",
                            "dudeman@company.net",
                            "9394029587");
                    testId = contact.getId();
                    return ContactActivity.newIntent(targetContext, contact);
                }
            };

    @Test
    public void changeTextFields(){
        onView(withId(R.id.contact_name_field)).perform(
                clearText(),
                typeText(targetContext.getString(R.string.test_contact_name)),
                closeSoftKeyboard()
        );
        onView(withText(R.string.test_contact_name)).check(matches(isDisplayed()));

        onView(withId(R.id.contact_email_field)).perform(
                clearText(),
                typeText(targetContext.getString(R.string.test_contact_email)),
                closeSoftKeyboard()
        );
        onView(withText(R.string.test_contact_email)).check(matches(isDisplayed()));

        onView(withId(R.id.contact_phone_field)).perform(
                clearText(),
                typeText(targetContext.getString(R.string.test_contact_phone)),
                closeSoftKeyboard()
        );
        onView(withText(R.string.test_contact_phone)).check(matches(isDisplayed()));
    }
}
