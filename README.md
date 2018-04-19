Building with SettingItem
=====

Gradle example:
```gradle
    allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
   }
   dependencies {
        compile 'com.github.GaoleiFu:SettingItem:1.0'
   }
```
**使用方法**
 - ImeSettingsItemView
```gradle
    <com.devdroid.itemsetting.view.ImeSettingsItemView
        android:id="@+id/isiv_demo"
        style="@style/ime_setting_item_style"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:settingItemTitle="设置"
        app:settingItemIcon="@mipmap/icon_ime_setting_dict"/>
```
 - RadioSettingsView
```gradle
    <com.devdroid.itemsetting.view.RadioSettingsView
        android:id="@+id/rsv_demo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:itemRadioChecked="true"
        app:itemRadioName="开启"/>
```
 - SwitchViewSettingsView
```gradle
    <com.devdroid.itemsetting.view.SwitchViewSettingsView
        android:id="@+id/svsv_demo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:itemCheckBoxChecked="true"
        app:itemCheckBoxName="开启手势"
        app:itemCheckBoxSummary="使用手势进行操作"/>
```
 - SeekBarSettingsView
```gradle
    <com.devdroid.itemsetting.view.SeekBarSettingsView
        android:id="@+id/sbsv_demo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:itemSeekBarProgress="50"
        app:itemSeekBarMaxProgress="100"
        app:itemSeekBarName="震动强度"
        app:itemSeekBarValueStartIcon="@mipmap/keyboard_vibrate_start"
        app:itemSeekBarValueEndIcon="@mipmap/keyboard_vibrate_end"/>
```
 - Divider
```gradle
    <ImageView
        style="@style/Input_Settings_Itme_Divider"/>
```

使用它吧
=====
