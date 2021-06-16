// 引用插件
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

// Android 属性
android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // 签名类型
    signingConfigs {
        register("release") {
            // 别名
            keyAlias = "zjgsu"
            // 别名密码
            keyPassword = "123456"
            // 路径
            storeFile = file("src/main/jks/kotlindsl.jks")
            // 签名文件密码
            storePassword = "123456"
        }
    }

    // 编译类型
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            // 自动签名打包
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // 输出类型
    android.applicationVariants.all {
        // 编译类型
        val buildType = this.buildType.name
        outputs.all {
            // 判断是否是输出 apk 类型
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                this.outputFileName = "KOTLIN_DSL_V${defaultConfig.versionName}_$buildType.apk"
            }
        }
    }

    // 指定 JDK
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(DependenciesConfig.STD_LIB)
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
}