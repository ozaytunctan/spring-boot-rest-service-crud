def successMessage="Successfuly "
def slackMessage="Slack "
def errorMessage="Error"

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
                   sh "mvn clean"
                   echo "Project build ${successMessage}"          
            }            
        }
        
        stage('TEST'){
            steps{
                 sh "mvn test"
                 echo "Project test run ${successMessage}"
            }
        }
        
        stage('DEPLOY'){
            steps{
                  sh "mvn package"
                  echo "Project deployed ${successMessage}"
              
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
