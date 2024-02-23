pipeline {

	agent any

	environment {
    DOCKERHUB_CREDENTIALS = credentials('jenkins')
	}

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

		

		stage('Login to Docker Hub') {
   			steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    			}
		}

		stage('Push Image'){
			steps{
			
			sh 'docker push z0s3r77/tomcat-hipotecas:${BUILD_NUMBER} '

			
			}
			
		}
	}	

}
