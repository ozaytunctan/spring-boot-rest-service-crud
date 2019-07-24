def successMessage="Successfuly "
def slackMessage="Slack "
def errorMessage="Error"
def slackChannel="#atlas-jenkins"
def projectName="Atlas Backend Application"

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
               
               script {
                  try{
                   sh "mvn clean"
                   slackSend channel: "${slackChannel}",color: "#0000FF",message:"Succes Build ${projectName}"
                  }catch(ex){
                   slackSend channel: "${slackChannel}",color: "#0000FF",message:"Step Failed :face_with_symbols_on_mouth: ${ex.message}"
                  }
               }
            }            
        }
    
        stage('Test'){
            steps{
               script {
                  try{
                 sh "mvn test"
                 slackSend channel: "${slackChannel}",color: "#008080",message:"Successfully Test ${projectName}"
                 echo "Project test run ${successMessage}"
                  
                  }catch(ex){
                     slackSend channel: "${slackChannel}",color: "#0000FF",message:"Test Step Failed :face_with_symbols_on_mouth: ${ex.message}"
                  }
               
               }     
            }
        }
      
          
        
        stage('Deployment'){
            steps{
                  sh "mvn package"
                  echo "Project deployed ${successMessage}"
                  slackSend channel: "${slackChannel}",color: "##00FFFF'",message:"Successfully Test ${projectName}"  
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
