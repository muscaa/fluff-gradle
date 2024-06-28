# Fluff Gradle

[![](https://jitpack.io/v/muscaa/fluff-gradle.svg)](https://jitpack.io/#muscaa/fluff-gradle)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Description

A Gradle plugin that adds additional commands and features to your project.

## Usage

### settings.gradle

```gradle
pluginManagement {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

### build.gradle

```gradle
plugins {
    id "com.github.muscaa.fluff-gradle" version "VERSION"
}
```

Replace `VERSION` with the latest release available on [JitPack](https://jitpack.io/#muscaa/fluff-gradle).

## Commands

- copyDependencies --to \<destination>
