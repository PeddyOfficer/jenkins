#!groovy

def call(env, mavenCommand) {
    final String composeId = uniqueComposeId(env)

    sh "CURRENT_UID=`id -u` CURRENT_GID=`id -g` MVN_CMD='$mavenCommand' docker-compose -f docker-compose.yml --no-ansi -p $composeId up --exit-code-from mvn mvn"
}