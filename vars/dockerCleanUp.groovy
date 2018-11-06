#!groovy

def call() {
    sh "docker-compose --no-ansi -p " + uniqueComposeId + " down --rmi local -v"
}
