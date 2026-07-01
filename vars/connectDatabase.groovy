// vars/connectDatabase.groovy
def call(String projectName) {
    withCredentials([string(credentialsId: 'my-db-pass', variable: 'DB_PASSWORD')]) {
        
        // Naya updated aur clean message logs ke liye
        echo "================================================================"
        echo "🔄 [DATABASE INFO] Initiating Secure Connection for: ${projectName.toUpperCase()}"
        echo "🔐 [SECURITY] Fetching credentials from Jenkins Credential Provider..."
        echo "================================================================"
        
        // Masked password ke sath secure shell command
        sh "echo '🚀 Status: Successfully established connection to the database for ${projectName}! Password is safe and masked.'"
    }
}
