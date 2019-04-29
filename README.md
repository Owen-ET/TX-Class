# TX-Class
[[Owen cnblogs]](http://www.cnblogs.com/Owen-ET/)

这是我的个人博客，里面记录遇到的问题以及安装、配置、开发等测试技术随笔。

# 命令



一. 常用命令

    ```shell

    1、手机截图
    IOS手机截图好办法：
    $ idevicescreenshot

    Screenshot saved to screenshot-2018-11-28-01-55-26.png

    $ open screenshot-2018-11-28-01-55-26.png


    安卓截图：
    cd /Users/zhangc/Desktop/拾起卖相关资料/测试文档/C2BApp/Android/图片

    adb shell screencap -p /sdcard/新文件夹/test.png

    adb pull /sdcard/新文件夹/test.png


    2、下载apk：
    cd /Users/zhangc/Desktop/公共机构相关资料/测试文档/C2BApp/Android/apk/B2B/供应商
    cd /Users/zhangc/Desktop/公共机构相关资料/测试文档/C2BApp/Android/apk/B2B/加盟商
    cd /Users/zhangc/Desktop/公共机构相关资料/测试文档/C2BApp/Android/apk/C2B公共机构

    wget

    3、启动安卓模拟器：
    ①cd /Users/zhangc/Desktop/mine/install/android-sdk-macosx/tools

    ②emulator -list-avds

    ③./emulator @Nexus_5X_API_24

    4-1、公司项目文档下载
    ①cd /Users/zhangc/Desktop/mine/测试资料文档/公司全部项目资料

    ②svn checkout https://192.168.2.80:4701/svn/Products/

    ③svn checkout https://192.168.2.80:4701/svn/CM_B2B_Document/

    4-2、SVN提交命令：
    ①svn add *

    ②svn commit -m “xxx”

    4-3、SVN更新命令：
    ①svn update XXX(更新指定文件/文件夹)

    ②svn ci -m "test-update"
    
    4-4、SVN删除命令：
    ①svn delete xxx(删除指定文件)
    
    ②svn ci -m “delete test”

    5、命令行启动WDA

    ①
    cd Desktop/mine/Stu资料/Git/WebDriverAgent/
    ./start.sh 

    ②iproxy 8100 8100

    6、上传github代码
    ①cd /Users/zhangc/Desktop/mine/Stu资料/课堂

    ②git status

    ③git add 文件夹

    ④git commit -s -m “xxx”

    ⑤git push

    =========================

    删除github上的文件

    # 删除target文件夹
    git rm -r --cached python_stu/

    # 提交,添加操作说明
    git commit -m '删除stu文件夹'

    # 将本次更改更新到github项目上去
    git push -u origin master

    =========================
    强制更新
    git fetch --all
    git reset --hard origin/master
    git pull

    =========================
    修改文件名
    git mv readme.txt(旧) read.txt(新)
    git commit -s -m "修改名字"
    git push

    7、启动appium并生成日志

    cd /tmp/appium_log/

    appium -g /tmp/appium_log/appium_android_$(date +%Y-%m-%d_%H:%M:%S).log



    8、maven插件路径
    cd /Users/zhangc/.m2/repository


    9、下载视频
    ffmpeg -i https://media.wanmen.org/e118fb5c-6518-47f9-8b17-0a52f5d741c0_pc_mid.m3u8?sign=38e08abc38948f5022d4d71887f362ed&t=5c88f636&r=41ab8381e0c56d4c1da55cd7b7450580 -c copy -bsf:a aac_adtstoasc /Users/zhangc/Desktop/output.mp4


    10、获取app的包名、activity名
    adb shell dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'

    adb shell dumpsys window |grep Focus= # 获取当前的信息

    adb shell dumpsys activity | grep LAUNCHER |sed -n '1p' # 获取第一行
    ```

二. 课程更新步骤

    ```shell
    
    ①下载课程
    ②放到本地
    ③同步网盘
    ④更新Excel
    ⑤git更新Excel
    ⑥拷贝U盘
    ⑦拔掉U盘

    ⑧家里拷贝
    ⑨更新Excel
    ⑩git更新Excel
    ```

三.样例如下
3. Install from source via [GitHub](https://github.com/appium/python-client).

    ```shell
    git clone git@github.com:appium/python-client.git
    cd python-client
    python setup.py install
    ```

# Development

- Style Guide: https://www.python.org/dev/peps/pep-0008/
    - `autopep8` helps to format code automatically
        ```
        $ python -m autopep8 -r --global-config .config-pep8 -i .
        ```
- You can customise `CHANGELOG.rst` with commit messages following [.gitchangelog.rc](.gitchangelog.rc)
    - It generates readable changelog
- Setup
    - `pip install -r development.txt`
    - `pre-commit install`
