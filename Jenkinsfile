pipeline {

	agent any

	stages {
	
		stage('SCM Checkout'){

			steps{

			git branch: 'dev', credentialsId: 'Github', url: 'https://github.com/z0s3r77/tomcat-hipotecas'
			}

		}

		stage('Maven compile webapp'){
			steps{
			sh 'mvn clean package'
			}			
		}

		stage('Build Docker Image'){
			steps {

sh 'docker build -t z0s3r77/tomcat-hipotecas:${BUILD_NUMBER} .'
			}
		}
	}

}
