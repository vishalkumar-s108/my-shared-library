// vars/connectDatabase.groovy
def call(String projectName) {
    withCredentials([string(credentialsId: 'my-db-pass', variable: 'DB_PASSWORD')]) {
        echo "=== [LIBRARY] Starting database logic for ${projectName} ==="
        sh "echo 'Connecting to DB with masked password: ${DB_PASSWORD}'"
    }
}
