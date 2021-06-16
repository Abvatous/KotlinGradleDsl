/**
 * FileName: KotlinConstants
 * Founder: LiuGuiLin
 * Profile: Kotlin 常量
 */

//全局常量
object KotlinConstants {

    //Gradle 版本
    const val gradle_version = "4.1.3"

    //Kotlin 版本
    const val kotlin_version = "1.4.31"
}

//应用配置
object AppConfig {

    //依赖版本
    const val compileSdkVersion = 30

    //编译工具版本
    const val buildToolsVersion = "30.0.3"

    //包名
    const val applicationId = "com.example.kotlingradledsl"

    //最小支持SDK
    const val minSdkVersion = 23

    //当前基于SDK
    const val targetSdkVersion = 30

    //版本编码
    const val versionCode = 1

    //版本名称
    const val versionName = "1.0"
}

//依赖配置
object DependenciesConfig {

    //Kotlin基础库
    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${KotlinConstants.kotlin_version}"
}