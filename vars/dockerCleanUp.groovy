#!groovy

def call(env) {
    sh "docker-compose --no-ansi -p " + uniqueComposeId(env) + " down --rmi local -v"
}
