#!groovy

def call(env, mavenCommand) {
    final String composeId = uniqueComposeId(env)

    final String docker = "CURRENT_UID=`id -u` CURRENT_GID=`id -g` MVN_CMD='$mavenCommand' docker-compose -f docker-compose.yml --no-ansi -p $composeId up --exit-code-from mvn mvn"
    final String exitCode = sh(returnStdout: true, script: "$docker").trim()

    if(!exitCode.equalsIgnoreCase("0")) {
        throw new Exception("Maven build failed")
    }
}