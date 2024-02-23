pipeline {

	agent any

	stages {
	
		stage('SCM Checkout'){

			steps{

			git branch: 'master', credentialsId: 'Github', url: 'https://github.com/z0s3r77/tomcat-hipotecas'
			}

		}

	}
}

