def successMessage="Successfuly "
def slackMessage="Slack "

/*pipeline {
    
    agent any
    
   -  tools {
        maven 'apache-maven-3.6.1' 
    }
    
    stages{
        
        stage('Clone repo and clean it'){
            
            steps{
               // sh "rm -rf my-app"
                //sh "git clone https://github.com/ozaytunctan/spring-boot-rest-service-crud.git"
                //sh "mvn clean -f my-app"
                   //withEnv(["PATH=${tool 'maven-3.6.1'}/bin:${tool 'jdk-1.8.0_211'}/bin:${env.PATH}"]) {
              
                     //  sh "mvn clean"
               
                       echo "${successMessage} PATH = ${PATH};"
                       
                   
            }
            
        }
        
        
        stage('TEST'){

            steps{
              
                //sh "mvn test -f my-app"
               // sh "mvn test"
                echo "TEST running successfully"
                
           
            }
            
        }
            stage('DEPLOY'){
            steps{
              //  sh "mvn package -f my-app"
                echo "Deploy running successfully"
               // sh "mvn package"
            }
            
        }
        }
}*/



pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.1'
        jdk 'jdk8'
    }
    stages {
        stage('Build') {
            steps {
                sh 'printenv'
                withMaven(mavenSettingsConfig: 'maven-settings-global') {
                    sh 'mvn clean package'
                }
            }
        }     
    }    
}
