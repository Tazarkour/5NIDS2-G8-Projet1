pipeline {
    agent any
    environment
    {
        registry = "omar0ouennich/devops"
        registryCredential = 'dcc1fedb-f678-4e70-a1bd-3b04d4058b6c'
        dockerImage = ''
    }
    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                echo "pulling...."
                // Checkout code from GitHub
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/omar-ouennich-5nids2-g8']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/Tazarkour/5NIDS2-G8-Projet1.git',
                    ]]
                ])
            }
        }
        stage('Build Maven') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }
        stage('Date') {
            steps {
                // Display the current date and time
                sh 'date'
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=123456789'
            }
        }
        stage('Test Mockito') {
            steps {


                // Run your Mockito tests may fail
                sh 'mvn test'  // Assumes you're using Maven for your project

            }
        }

        stage('Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }
        stage('Building  image') {

            steps {

                script {

                    dockerImage = docker.build registry + ":$BUILD_NUMBER"


}

            }

        }

        stage('Deploy  image') {

            steps {

                script {

                    docker.withRegistry( '', registryCredential ) {

                        dockerImage.push()

                    }


                }

            }

        }

        stage('Docker Compose Up') {
            steps {
                script {

                        sh "docker compose up -d"

                }
            }
        }
stage('Trivy Scan') {
    steps {
        script {
            // Define the name of the Docker image you want to scan (including repository and tag)
            def imageName = 'omar0ouennich/devops'+":$BUILD_NUMBER" // Replace 'tag' with your desired image tag

            // Define your Docker credential ID for authentication
            def dockerCredentialId = 'dcc1fedb-f678-4e70-a1bd-3b04d4058b6c' // Replace with your Jenkins credential ID

            // Use Docker credentials for authentication
            withDockerRegistry([credentialsId: dockerCredentialId, url: 'https://index.docker.io/v1/']) {
                // Run Trivy scan on the specified Docker image
                def trivyCmd = "trivy image  --severity HIGH,CRITICAL --scanners vuln --format json -o trivy_scan_result_${BUILD_NUMBER}.json ${imageName}"
                sh trivyCmd



        }
    }
}

}
    stage('Final Message') {
    steps {
        echo 'Congrats, your pipeline is working, go to sleep...zzzzz'
    }
}



    }
}
