package Gradle_Check_TestCoverageForkedJava7Linux.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.BuildType

class Gradle_Check_TestCoverageForkedJava7Linux_1(bucket: String) : BuildType({
    template(Gradle_Check.buildTypes.Gradle_Check_TestCoverageForkedLinux)
    uuid = "10e384cf-e5fc-4b6c-abe9-cf0b52766a5f"
    extId = "Gradle_Check_TestCoverageForkedJava7Linux_$bucket"
    name = "Test Coverage - Forked Java7 Linux ($bucket)"

    params {
        param("org.gradle.test.bucket", bucket)
        param("org.gradle.test.buildType", "platform")
        param("webhook.body", """
            {
            "text":" ${'$'}{buildResult} - *${'$'}{buildName}* <${'$'}{buildStatusUrl}|#${'$'}{buildNumber}> (triggered by ${'$'}{triggeredBy})"
            }
        """.trimIndent())
    }
})