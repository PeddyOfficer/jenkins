#!groovy

def call(services) {
    final String composeId = uniqueComposeId
    sh "CURRENT_UID=`id -u` CURRENT_GID=`id -g` docker-compose -f docker-compose.yml -p $composeId up -d $services"
}