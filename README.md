

### 🖧 Project structure

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…


### 📸 Preview

| Android | iOS|
|---------|----|
|![pedrope_android](https://github.com/user-attachments/assets/c4bac1c5-c55e-49d3-828a-4591628cf487)|![pedrope_ios](https://github.com/user-attachments/assets/1f1d52d6-6fc9-4889-8b61-c1752f161232)|
