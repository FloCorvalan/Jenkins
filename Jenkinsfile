pipeline {
	agent any
	stages {
		stage('prueba') {
			steps {
				echo "Probando JUnit"
			}
		}
		stage('SonarQube analysis') {
    			steps {
				dir("/var/lib/jenkins/workspace/prueba/backend") {
					withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    					}
				}
			}
  		}
		stage('JUnit'){
			steps {
				dir("/var/lib/jenkins/workspace/prueba/backend") {
					sh './gradlew test'
				}
				dir("/var/lib/jenkins/workspace/prueba/backend/build/test-results/test") {
					junit '**/test-results/*.xml'
				}
			}
		}
	}
}