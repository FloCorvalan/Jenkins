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
				withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
      					dir("/workspace/prueba/backend") {
						sh './gradlew sonarqube'
    					}
				}
			}
  		}
	}
}