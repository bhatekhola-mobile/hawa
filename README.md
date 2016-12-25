
```
minSdkVersion 11
targetSdkVersion 25
```

uses `plugin: 'kotlin-android'`

Tested on Nexus 4 API 22


```
./gradlew clean build
```

run
----

```
/Users/prayagupd/Library/Android/sdk/tools/emulator -netdelay none -netspeed full -avd Nexus_4_API_22
adb push /Users/prayagupd/divine-projects/hawa/app/build/outputs/apk/app-debug.apk /data/local/tmp/hawa.com.hawa
adb shell pm install -r "/data/local/tmp/hawa.com.hawa"
adb shell am start -n "hawa.com.hawa/hawa.com.hawa.HawaDashboardViewController" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
```