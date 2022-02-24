@Library('ceiba-jenkins-library@master') _
pipeline{
	
    agent {
        label 'Slave_Induccion'
    }

	  options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }
	
    tools {
        jdk 'JDK8_Centos'
    }
	
    // Parametros disponibles en jenkins
     /*parameters{
            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
            text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
            booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
            choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
            password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a passwor')
     }*/
	
    stages{
        stage('Checkout') {
            steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                //Esta opción se usa para el checkout sencillo de un microservicio
                gitCheckout(
                    urlProject:'https://github.com/japonteb/certificaciones/certificaciones.git',
                    branchProject: '${BRANCH_NAME}',
                )

                //Esta opción se usa cuando el comun está centralizado para varios microservicios
                /*gitCheckoutWithComun(
                    urlProject:'<url repositorio proyecto>',
                    branchProject: '${BRANCH_NAME}',
                    urlComun: '<url repositorio proyecto comun>'
                )*/

                dir("${PROJECT_PATH_BACK}"){
                    sh 'chmod +x ./gradlew'
                    sh './gradlew clean'
                }
            }
        }

        stage('Compilacion y Test Unitarios'){
            // El "parallel" es si vamos a correr los test del frontend en paralelo con los test de backend, se configura en otro stage dentro de parallel
            parallel {
                stage('Test- Backend'){
                    steps {
                        echo '------------>Test Backend<------------'
                        dir("${PROJECT_PATH_BACK}"){
                            sh './gradlew --stacktrace test'
                        }
                    }
                    post{
                        always {
                            junit '**/build/test-results/test/*.xml' //Configuración de los reportes de JUnit
                        }
                    }
                }
                /*
                stage('Test- Frontend'){
                    steps {
                        echo '------------>Test Frontend<------------'
                        dir("${PROJECT_PATH_FRONT}"){
                            // comando ejecucion test
                        }
                    }
                }
                */
            }
        }
        stage('Static Code Analysis') {
            environment {
                SONARSCANNER = "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
            }
            steps{
                echo '------------>Análisis de código estático<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${env.SONARSCANNER} -Dsonar.projectKey=co.com.ceiba.certificaciones:certificaciones.${BRANCH_NAME} -Dsonar.projectName=co.com.ceiba.certificaciones:certificaciones${BRANCH_NAME} -Dproject.settings=./sonar-project.properties"
                }
                echo '------------>Revision de Quality Gates<------------'
                sleep 5
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
			}
        }

        stage('Build'){
            parallel {
                stage('construcción Backend'){
                    steps{
                        echo "------------>Compilación backend<------------"
                        dir("${PROJECT_PATH_BACK}"){
                            sh './gradlew build -x test'
                        }
                    }
                }
            }
         }
    }
	
    post {
        failure {
            mail(
                to: 'javier.aponte@ceiba.com.co',
                body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
                subject: "ERROR CI: ${env.JOB_NAME}"
            )
            updateGitlabCommitStatus name: 'IC Jenkins', state: 'failed'
        }
        success {
            updateGitlabCommitStatus name: 'IC Jenkins', state: 'success'
        }
    }	
}