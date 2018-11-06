#!groovy

def call() {
    return "${env.JOB_NAME}-${env.BUILD_ID}"
            .replace("-", "")
            .replace("%2F", "")
            .replace("/", "")
}
