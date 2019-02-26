/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.uiautomator.BasicSample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Basic sample for unbundled UiAutomator.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ChangeTextBehaviorTest {

//    private static final String BASIC_SAMPLE_PACKAGE
//            = "com.example.android.testing.uiautomator.BasicSample";
    private static final String BASIC_SAMPLE_PACKAGE = "com.myzaker.ZAKER_Phone";

    private static final int LAUNCH_TIMEOUT = 5000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        mDevice.pressMenu();
        mDevice.pressBack();
        mDevice.pressMenu();
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the blueprint app
        Context context = getApplicationContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    @Test
    public void testChangeText_sameActivity() throws Exception{
//         Type text and then press the button.
//        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "editTextUserInput"))
//                .setText(STRING_TO_BE_TYPED);
//        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "changeTextBt"))
//                .click();


//         改造写法
//        UiObject editTextUserInput = new UiObject(new UiSelector().resourceId("com.example.android.testing.uiautomator.BasicSample:id/editTextUserInput"));
//        editTextUserInput.setText(STRING_TO_BE_TYPED);
//        UiObject changeTextBt = new UiObject(new UiSelector().text("CHANGE TEXT"));
//        changeTextBt.click();

        // 打开zaker应用后，点击上方的搜索栏，并输入利物浦
//        UiObject search = new UiObject(new UiSelector().resourceId("com.myzaker.ZAKER_Phone:id/box_search_icon"));
//        search.click();
//        UiObject searchText = new UiObject(new UiSelector().resourceId("com.myzaker.ZAKER_Phone:id/search_field"));
//        searchText.setText("利物浦");
//        mDevice.pressEnter();

        // 打开zaker应用后，获取当前页面的列表控件，并找到环球网后点击
        UiScrollable zakerListView = new UiScrollable(new UiSelector().className("android.widget.ListView").scrollable(true));
        // 向下滚动
        zakerListView.flingForward();
        zakerListView.flingForward();
        UiObject hqw = new UiObject(new UiSelector().textContains("环球网"));
        zakerListView.scrollIntoView(hqw);
        hqw.click();

        // Verify the test is displayed in the Ui
//        UiObject2 changedText = mDevice
//                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "textToBeChanged")),
//                        500 /* wait 500ms */);
//        assertThat(changedText.getText(), is(equalTo(STRING_TO_BE_TYPED)));

        UiObject2 changedText = mDevice
                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "action_shares")),
                        500 /* wait 500ms */);
        // 按钮存不存在
        assertThat(changedText, notNullValue());
    }

    @Test
    public void testChangeText_newActivity() {
        // Type text and then press the button.
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "editTextUserInput"))
                .setText(STRING_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "activityChangeTextBtn"))
                .click();

        // Verify the test is displayed in the Ui
        UiObject2 changedText = mDevice
                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "show_text_view")),
                        500 /* wait 500ms */);
        assertThat(changedText.getText(), is(equalTo(STRING_TO_BE_TYPED)));
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
