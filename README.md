# DaE - Decode and Encode
[CTFCrackTools](https://github.com/Acmesec/CTFCrackTools) 's BurpSuite Plugin - Decode and Encode

Many people suggested that I develop BurpSuite version, so I ported this tool to Burp

 [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://github.com/0Chencc/DaE/blob/main/LICENSE)
 [![language](https://img.shields.io/badge/Language-Java/Kotlin-orange.svg)](https://github.com/0Chencc/DaE/)
# Support

***Decode/Encode as***
 - MorseCode

 - BaconCode

 - Base64

 - Base32

 - URL

 - Unicode

 - HtmlCode

 - VigenereCode

   ......

***Decrypt as***

 - Fence

 - Casar

 - PigCode

 - Rot13

 - Hex2String

 - String2Hex

 - Unicode2Ascii

 - Ascii2Unicode

 - Reverse

   ......

***Plugin***

You can write your own plug-in to import into this framework

(Due to jython problems, python3 is not supported)

Required method:*main*,*author_info*

```python
#-*- coding:utf-8 -*-
#demo
def main(input,a,b,c):
    return a+b+c
  
#authorinfo
def author_info():
    info = {
    "author":"0chen",
    "name":"test_version",
    "key":["a","b","c"],
    "describe":"plugin describe"
    }
    return info
```



# Usage

![](img/1.png)
