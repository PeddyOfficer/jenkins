#!groovy

def call(env, services) {
    final String composeId = new uniqueComposeId(env)
    sh "CURRENT_UID=`id -u` CURRENT_GID=`id -g` docker-compose -f docker-compose.yml -p $composeId up -d $services"
}