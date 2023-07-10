# Capacitor Image Cropx

[![npm](https://img.shields.io/npm/v/@triplesense/capacitor-image-cropx.svg)](https://www.npmjs.com/package/@triplesense/capacitor-image-cropx)
[![npm](https://img.shields.io/npm/dt/@triplesense/capacitor-image-cropx.svg?label=npm%20downloads)](https://www.npmjs.com/package@triplesense/capacitor-image-cropx)

## Installation

- `npm i @triplesense/capacitor-image-cropx`

## Usage

### Android

Add the following to your Android.manifest

```xml
<activity
            android:name="com.yalantis.ucrop.UCropActivity"
            android:screenOrientation="portrait"
            android:theme="@style/Theme.AppCompat.Light.NoActionBar"/>
```

#### customize the cropper activity

```xml
   <!--uCrop Activity-->
    <color name="ucrop_color_toolbar">#FF6E40</color>
    <color name="ucrop_color_statusbar">#CC5833</color>
    <color name="ucrop_color_toolbar_widget">#fff</color>
    <color name="ucrop_color_widget">#000</color>
    <color name="ucrop_color_widget_active">#FF6E40</color>
    <color name="ucrop_color_widget_background">#fff</color>
    <color name="ucrop_color_widget_text">#000</color>
    <color name="ucrop_color_progress_wheel_line">#808080</color>
    <color name="ucrop_color_crop_background">#000</color>

    <!--Crop View-->
    <color name="ucrop_color_default_crop_grid">#80ffffff</color>
    <color name="ucrop_color_default_crop_frame">#ffffff</color>
    <color name="ucrop_color_default_dimmed">#8c000000</color>
    <color name="ucrop_color_default_logo">#4f212121</color>
```

```ts
import { ImageCropx, CropResult } from '@triplesense/capacitor-image-cropx';


ImageCropx.show({
    source:'path' // use `~/` for app root
    width:300,
    height:300,
    ratio:"16:9"
}).then(response =>{
   // response.value image path
})
.catch(err =>{})
```

## Api

| Method                                                                          | Default | Type                      | Description  |
| ------------------------------------------------------------------------------- | ------- | ------------------------- | ------------ |
| show(options: { source: string, width: number, height: number, ratio: string }) |         | `Promise<{value:string}>` | Show cropper |

## Reference

Based on [https://github.com/TeamHive/capacitor-image-crop](TeamHive/capacitor-image-crop)
