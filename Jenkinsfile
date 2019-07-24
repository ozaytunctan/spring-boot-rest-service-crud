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
               try{
                   sh "mvn clean"
                   echo "Project build ${successMessage}"
               }
               catch(ex){
                  echo "${errorMessage}"
               }
                           
            }            
        }
        
        stage('TEST'){
            steps{
               try{
                   sh "mvn test"
                 echo "Project test run ${successMessage}"
               }
               catch(ex){
                  echo "${errorMessage}"
               }
            }
        }
        
        stage('DEPLOY'){
            steps{
               try{
                  sh "mvn package"
                  echo "Project deployed ${successMessage}"
               }
               catch(ex){
                  echo "${errorMessage}"
               }
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
