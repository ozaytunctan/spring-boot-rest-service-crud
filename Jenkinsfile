

pipeline {
    
    agent any
    
    stages{
        
        stage('Clone repo and clean it'){
            
            steps{
                sh "rm -rf my-app"
                sh "git clone https://github.com/ozaytunctan/spring-boot-rest-service-crud.git"
                sh "mvn clean -f my-app"
            }
            
        }
        
        
        stage('TEST'){

            steps{
                sh "mvn test -f my-app"
            }
            
        }
            stage('DEPLOY'){
            steps{
                sh "mvn package -f my-app"
            }
            
        }
        }
}
