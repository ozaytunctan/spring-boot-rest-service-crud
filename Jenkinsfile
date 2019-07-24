def successMessage="Successfuly "
def slackMessage="Slack "

pipeline {
   agent any
    
    tools {
        maven 'M2'
    }
    stages{
       
        stage('BUILD'){
            steps{
               // sh "rm -rf my-app"
                //sh "git clone https://github.com/ozaytunctan/spring-boot-rest-service-crud.git"
                //sh "mvn clean -f my-app"
                   //withEnv(["PATH=${tool 'maven-3.6.1'}/bin:${tool 'jdk-1.8.0_211'}/bin:${env.PATH}"]) 
                     sh "mvn clean"
                     echo "${successMessage} PATH = ${PATH};"          
            }            
        }
        
        stage('TEST'){
            steps{
                sh "mvn test"
                echo "TEST running successfully"
            }
        }
        
        stage('DEPLOY'){
            steps{
                echo "Deploy running successfully"
                sh "mvn package"
       }           
     }
  }
}



/*pipeline {
    agent any
    tools {
        maven 'M2'
    }
    stages {
        stage('Build') {
            steps {
                sh 'printenv'
                    sh 'mvn clean package'
                
            }
        }     
    }    
}*/
