#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2019/02/26 17:08
# @Author  : zc
# @File    : testcase.py

#coding：utf-8
import os
from time import sleep
import unittest
from appium import webdriver
from selenium.webdriver.common.by import By

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)

class ZakerTest(unittest.TestCase):

    # @classmethod    # 只执行一次
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '7.0'
        desired_caps['deviceName'] = 'Android Emulator'
        # desired_caps['app'] = PATH(
        #     './Zaker.apk'
        # )
        desired_caps['appPackage'] = 'com.myzaker.ZAKER_Phone'
        desired_caps['appActivity'] = '.view.LogoActivity'
        desired_caps['unicodeKeyboard'] = 'true'  # 中文输入，安装appium输入法代替原有输入法
        desired_caps['resetKeyboard'] = 'true'

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)
        # 添加隐式等待
        sleep(2)
        # self.driver.implicitly_wait(20)
        # self.public()


    # @classmethod
    def tearDown(self):
        # end the session
        # self.driver.quit()
        print("stop!")


    def testZakerSerchBtn(self):
        self.public()
        # searchBtn = self.driver.find_element(By.ID,"box_search_icon")
        # searchBtn.click()
        # inputText = self.driver.find_element(By.ID,"search_perent_view")
        # inputText.send_keys("利物浦")
        # sleep(5)
        # self.driver.press_keycode(66)

        sleep(5)
        # self.driver.find_element_by_android_uiautomator(u'(new UiScrollable(new UiSelector().className("android.widget.ListView").scrollable(true))).scrollIntoView(new UiObject(new UiSelector().textContains("环球网")))')
        self.driver.find_element_by_android_uiautomator(u'new UiSelector().textContains("新华网")').click()


    def public(self):
        # self.driver.find_element_by_id("com.myzaker.ZAKER_Phone:id/launcher_grant_next_btn").click()
        self.driver.find_element_by_android_uiautomator(u'new UiSelector().resourceId("com.myzaker.ZAKER_Phone:id/launcher_grant_next_btn")').click()
        for i in range(3):
            # self.driver.find_element_by_id("com.android.packageinstaller:id/permission_allow_button").click()
            self.driver.find_element_by_android_uiautomator(u'new UiSelector().text("ALLOW")').click()




    # def test_find_elements(self):
    #     el = self.driver.find_element_by_accessibility_id('Graphics')
    #     el.click()
    #     el = self.driver.find_element_by_accessibility_id('Arcs')
    #     self.assertIsNotNone(el)
    #
    #     self.driver.back()
    #
    #     el = self.driver.find_element_by_accessibility_id("App")
    #     self.assertIsNotNone(el)
    #
    #     els = self.driver.find_elements_by_android_uiautomator("new UiSelector().clickable(true)")
    #     self.assertGreaterEqual(12, len(els))
    #
    #     self.driver.find_element_by_android_uiautomator('text("API Demos")')
    #
    #
    # def test_simple_actions(self):
    #     el = self.driver.find_element_by_accessibility_id('Graphics')
    #     el.click()
    #
    #     el = self.driver.find_element_by_accessibility_id('Arcs')
    #     el.click()
    #
    #     self.driver.find_element_by_android_uiautomator('new UiSelector().text("Graphics/Arcs")')


if __name__ == '__main__':
    # suite = unittest.TestLoader().loadTestsFromTestCase(ZakerTest)
    # unittest.TextTestRunner(verbosity=2).run(suite)
    unittest.main()
