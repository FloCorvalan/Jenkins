pipeline {
	agent any
	stages {
		stage('Inicio') {
			steps {
				echo "Inicio"
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
				dir("/var/lib/jenkins/workspace/prueba/backend/build/test-results/test") {
					sh 'rm *.xml'
				}
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    			dir("/var/lib/jenkins/workspace/prueba/backend") {
						sh './gradlew test'
					}
                		}
				dir("/var/lib/jenkins/workspace/prueba/backend/build/test-results/test") {
					junit '*.xml'
				}
			}
		}
		stage('Fin') {
			steps {
				echo "Fin"
			}
		}
	}
}