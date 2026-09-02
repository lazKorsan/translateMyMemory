pipeline {
    agent any

    tools {
        maven 'Maven-3.9.6'
        jdk 'JDK-21'
    }

    stages {
        stage('Clean & Test') {
            steps {
                bat 'mvn clean test -Dtest=TestRunner'
            }
        }
    }

    post {
        always {
            // Cucumber Rapor
            cucumber buildStatus: "UNSTABLE",
                     fileIncludePattern: "**/cucumber.json",
                     jsonReportDirectory: "target/json-reports"

            // Allure Rapor
            allure includeProperties: false,
                   results: [[path: 'target/allure-results']]

            // Test sonuçlarını arşivle
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/json-reports/cucumber.json', allowEmptyArchive: true

            echo '✅ Build ve test tamamlandı!'
        }
    }
}