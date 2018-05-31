pipeline {
    agent any
    options {
        disableConcurrentBuilds()
    }
    environment {
        TARGET_GIT_URL = "https://github.com/frankdong80/tw-nho29-backend.git"
        TARGET_GIT_BRANCH = "master"
    }
    stages {
        stage('prepare') {
            steps {
                sh '''#!/usr/local/bin/bash -l
                echo "do nothing"
                '''
            }
        }
        stage('test') {
            steps {
                sh '''
                ./gradlew test
                '''
            }
        }
        stage('package') {
            steps {
                sh '''
                ./gradlew build -x test
                '''
            }
        }
        stage('dockerize') {
            steps {
                sh '''
                ./gradlew docker
                '''
            }
        }
        stage('run') {
                    steps {
                        sh '''
                        docker run -idt --name=tw-nho29-backend -p 11880:8080 tw-nho29-backend
                        '''
                    }
                }

    }
    post {
        always {
            sh '''#!/usr/local/bin/bash -l
            echo "cleanup"
            '''
        }
        success {
            sh '''#!/usr/local/bin/bash -l
            echo "success"
            '''
        }
        failure {
            sh '''#!/usr/local/bin/bash -l
            echo "failure"
            '''
        }
    }
}