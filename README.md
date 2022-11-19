WheelPicker
===
iOS-style scroll wheel picker

![GitHub tag (latest SemVer)](https://img.shields.io/github/v/tag/ty0x2333/WheelPicker)
![Maven Central](https://img.shields.io/maven-central/v/sh.tyy/wheelpicker)
[![codebeat badge](https://codebeat.co/badges/346d671e-d683-4471-be7d-a3d6f742de86)](https://codebeat.co/projects/github-com-ty0x2333-wheelpicker-master)

Read this in other languages: [*简体中文*](README.zh-cn.md)

Feature
---
1. Support jetpack compose
2. Support date picker and time picker

Download
---
```gradle
implementation 'com.github.PT-Akar-Inti-Teknologi:WheelPicker_android:<version>'
```

Preview
---
![Preview](resources/preview.gif)

Quick Start
--
call this function to onClick function on compose
#### Date Picker
call this function to onClick function on compose
```kotlin
    datePickerComposeAction(
        value = date, // string value
        context = this, // context
        window = window, //window
        title = "Date Picker", // must string
        date = { 
            date = it // set value
        }
    )
```
#### Time Picker
```kotlin
    timePickerComposeAction(
        value = times, // string value
        context = this, // context
        window = window, //window
        title = "Time Picker", // must string
        date = { 
            times = it // set value
        }
    )
```

Inspiration and Reference
---
WheelPicker is inspired by 
[devilist/RecyclerWheelPicker](https://github.com/devilist/RecyclerWheelPicker) &
[ty0x2333/WheelPicker](https://github.com/ty0x2333/WheelPicker)

License
---
WheelPicker is available under the Apache 2.0 license. See the LICENSE file for more info.
