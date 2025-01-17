package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
        maven {
            name = "build: clean test"
            goals = "clean test"
            pomLocation = "ch-simple/pom.xml"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        maven {
            name = "build: clean package"
            goals = "clean package"
            pomLocation = "ch-simple/pom.xml"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }
    steps {
        update<MavenBuildStep>(1) {
            name = "build2: clean package"
            clearConditions()
        }
    }
}
