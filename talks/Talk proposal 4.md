# Creating a Flutter APK without "flutter build apk" - internals deep dive

Have you ever thought what kind of crazy magic happens when you "flutter build apk"? How does the final APK get created?

In this talk, I'll walk you through building the counter app we all know and love, but without calling neither "flutter build apk" nor "gradle :app:assemble". Instead, we'll use lower level tools like "flutter assemble", compile our Dart to AOT assembly manually, and directly call Android SDK tools like d8, aapt2, and apksigner.

You'll walk away with a better idea of what's going on under the hood, appreciate that you don't have to care about it, and gain knowledge that may turn out useful in debugging real-world issues.

### Description

### Share your experience with this topic

I'm a software engineering intern at the startup called mobile.dev, where I work the Maestro UI testing framework and other initiatives in the mobile QA space.

Apart from that, I'm also a Computer Science student, with a few years of expertise in Flutter, both in app and tooling development. I was the main developer of the Patrol testing framework (I gave a talk about it on last year's Fluttercon), which is at ~800 GitHub stars and has enabled Flutter developers to finally fully E2E test their apps.

I'm also a member of the #flutter-hackers group (people with commit access in the Flutter org on GitHub), and over the past year I've created ~100 pull requests and issues, mainly related to Flutter's integration with Gradle on Android and better support for UI testing. I also maintain several popular projects in the Flutter ecosystem, such as package:flutter_downloader, package:location and the Flutter GitHub Action (subosito/flutter-action), and have contributed to many more throughout the years.

I run a modest blog at https://garden.pacia.tech, where I sometimes write about mobile development and any other programming topic that I find is interesting.
