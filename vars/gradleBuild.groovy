#!/usr/bin/env groovy

//import org.apache.commons.lang.StringUtils

def call() {
    try {
       echo 'Build Started'
       //currentBuild.displayName = "${env.BUILD_NUMBER + '-' + SHORT_GIT_COMMIT}"
       //buildVersionNumber = env.BUILD_NUMBER + '-' + SHORT_GIT_COMMIT + buildType
       sh 'chmod +x ./gradlew'
       sh './gradlew clean build '
       archiveArtifacts 'build/libs/*'
    } catch (e) {
       currentBuild.result = "FAILED"
       throw e
    } finally {
    }
}
