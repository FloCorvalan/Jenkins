pipeline {
	agent any
	tools {
       		gradle gradle
    	}
	stages {
		stage('prueba') {
			steps {
				echo "Probando"
			}
		}
		stage('SonarQube analysis') {
    			steps {
				withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
      					sh './gradlew sonarqube'
    				}
			}
  		}
	}
}