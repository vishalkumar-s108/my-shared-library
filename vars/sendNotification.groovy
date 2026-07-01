// vars/sendNotification.groovy

// Isme hum do parameters le rahe hain: status (SUCCESS/FAILURE) aur customMessage
def call(String status, String customMessage) {
    
    // Jenkins ke environment variables se hum build number aur project name utha rahe hain
    def jobName = env.JOB_NAME
    def buildNumber = env.BUILD_NUMBER
    def buildUrl = env.BUILD_URL

    echo "=== [NOTIFICATION LIBRARY] Preparing Alert ==="

    if (status.toUpperCase() == 'SUCCESS') {
        // Build pass hone par green signal alert ka logic
        echo "🟢 SUCCESS ALERT: Job '${jobName}' (Build #${buildNumber}) successfully complete ho gayi hai!"
        echo "Message: ${customMessage}"
        echo "Build URL: ${buildUrl}"
        
        // Real industry mein yahan plugin use hota hai, jaise:
        // slackSend channel: '#mlops-alerts', color: 'good', message: "SUCCESS: ${customMessage}"
        
    } else if (status.toUpperCase() == 'FAILURE') {
        // Build fail hone par red signal/warning alert ka logic
        echo "🔴 FAILURE ALERT: Warning! Job '${jobName}' (Build #${buildNumber}) FAILED ho gayi hai. Check karo!"
        echo "Reason/Message: ${customMessage}"
        echo "Fix karne ke liye logs yahan dekhein: ${buildUrl}console"
        
        // Real industry mein yahan fail hone par email ya slack trigger hota hai:
        // slackSend channel: '#mlops-alerts', color: 'danger', message: "FAILED: ${customMessage}"
    } else {
        // Koi aur status ho toh normal info alert
        echo "ℹ️ INFO ALERT: Job '${jobName}' Status: ${status} | Message: ${customMessage}"
    }
}
