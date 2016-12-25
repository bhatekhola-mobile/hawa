
```
$ ./gradlew --version

------------------------------------------------------------
Gradle 2.14.1
------------------------------------------------------------

Build time:   2016-07-18 06:38:37 UTC
Revision:     d9e2113d9fb05a5caabba61798bdb8dfdca83719

Groovy:       2.4.4
Ant:          Apache Ant(TM) version 1.9.6 compiled on June 29 2015
JVM:          1.8.0_111 (Oracle Corporation 25.111-b14)
OS:           Mac OS X 10.11.6 x86_64
```

```
minSdkVersion 11
targetSdkVersion 25
```

uses `plugin: 'kotlin-android'`

Tested on Nexus 4 API 22


```
./gradlew clean build

$ ll app/build/outputs/apk/
total 8200
-rw-r--r--  1 prayagupd  DN\Domain Users  2181451 Dec 24 23:41 app-debug.apk
-rw-r--r--  1 prayagupd  DN\Domain Users  2013787 Dec 24 23:41 app-release-unsigned.apk
```

run
----

```
/Users/prayagupd/Library/Android/sdk/tools/emulator -netdelay none -netspeed full -avd Nexus_4_API_22
adb push /Users/prayagupd/divine-projects/hawa/app/build/outputs/apk/app-debug.apk /data/local/tmp/hawa.com.hawa
adb shell pm install -r "/data/local/tmp/hawa.com.hawa"
adb shell am start -n "hawa.com.hawa/hawa.com.hawa.HawaDashboardViewController" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
```