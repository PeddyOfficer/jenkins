#!groovy

def call(env) {
    sh "docker-compose --no-ansi -p " + new uniqueComposeId(env) + " down --rmi local -v"
}
