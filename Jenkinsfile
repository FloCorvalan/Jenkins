pipeline {
	agent any
	stages {
		stage('prueba') {
			steps {
				echo "Probando"
			}
		}
		stage('SonarQube analysis') {
    			steps {
				dir("/workspace/prueba/backend") {
					withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
						sh './gradlew sonarqube'
    					}
				}
			}
  		}
	}
}