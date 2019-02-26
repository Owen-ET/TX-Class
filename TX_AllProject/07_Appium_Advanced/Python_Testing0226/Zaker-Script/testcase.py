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

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)

class ZakerTest(unittest.TestCase):

    @classmethod    # 只执行一次
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '7.0'
        desired_caps['deviceName'] = 'Android Emulator'
        desired_caps['app'] = PATH(
            './Zaker.apk'
        )
        desired_caps['appPackage'] = 'com.myzaker.ZAKER_Phone'
        desired_caps['appActivity'] = 'com.myzaker.ZAKER_Phone.view.LogoActivity'
        desired_caps['unicodeKeyboard'] = 'true'  # 中文输入，安装appium输入法代替原有输入法
        desired_caps['resetKeyboard'] = 'true'

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        # end the session
        self.driver.quit()

    def test_find_elements(self):
        el = self.driver.find_element_by_accessibility_id('Graphics')
        el.click()
        el = self.driver.find_element_by_accessibility_id('Arcs')
        self.assertIsNotNone(el)

        self.driver.back()

        el = self.driver.find_element_by_accessibility_id("App")
        self.assertIsNotNone(el)

        els = self.driver.find_elements_by_android_uiautomator("new UiSelector().clickable(true)")
        self.assertGreaterEqual(12, len(els))

        self.driver.find_element_by_android_uiautomator('text("API Demos")')


    def test_simple_actions(self):
        el = self.driver.find_element_by_accessibility_id('Graphics')
        el.click()

        el = self.driver.find_element_by_accessibility_id('Arcs')
        el.click()

        self.driver.find_element_by_android_uiautomator('new UiSelector().text("Graphics/Arcs")')


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(SimpleAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)
