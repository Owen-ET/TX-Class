# TX-Class
[![Owen cnblogs](http://www.cnblogs.com/Owen-ET/)]

An extension library for adding [Selenium 3.0 draft](https://dvcs.w3.org/hg/webdriver/raw-file/tip/webdriver-spec.html) and [Mobile JSON Wire Protocol Specification draft](https://github.com/SeleniumHQ/mobile-spec/blob/master/spec-draft.md)
functionality to the Python language bindings, for use with the mobile testing
framework [Appium](https://appium.io).

# Getting the Appium Python client

There are three ways to install and use the Appium Python client.

1. Install from [PyPi](https://pypi.org), as
['Appium-Python-Client'](https://pypi.org/project/Appium-Python-Client/).

    ```shell
    pip install Appium-Python-Client
    ```

    You can see the history from [here](https://pypi.org/project/Appium-Python-Client/#history)

2. Install from source, via [PyPi](https://pypi.org). From ['Appium-Python-Client'](https://pypi.org/project/Appium-Python-Client/),
download and unarchive the source tarball (Appium-Python-Client-X.X.tar.gz).

    ```shell
    tar -xvf Appium-Python-Client-X.X.tar.gz
    cd Appium-Python-Client-X.X
    python setup.py install
    ```

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
