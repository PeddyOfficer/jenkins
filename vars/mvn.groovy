#!groovy

def call(env, mavenCommand) {
    final String composeId = uniqueComposeId(env)
    final String name = "'$composeId'_mvn_1"
    //sh "CURRENT_UID=`id -u` CURRENT_GID=`id -g` MVN_CMD='$mavenCommand' docker-compose -f docker-compose.yml --no-ansi -p $composeId up mvn"
    final String cmd = '$?'
    final String docker = "CURRENT_UID=`id -u` CURRENT_GID=`id -g` MVN_CMD='$mavenCommand' docker-compose -f docker-compose.yml --no-ansi -p $composeId up --exit-code-from mvn mvn; echo $cmd"
    final String exitCode = sh(returnStdout: true, script: "$docker").trim()

    //final int exitCode = sh(returnStdout: true, script: "docker inspect $name --format={{.State.ExitCode}}").trim()
    println("EXIT CODE: $exitCode")
    //if(!exitCode.equalsIgnoreCase("0")) {
    //    throw new Exception("Maven build failed")
    //}
}
