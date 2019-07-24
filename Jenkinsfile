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
                   slackSend channel: "${slackChannel}",color: "#0000FF",message:"Build started..."
                   sh "mvn clean"
                   slackSend channel: "${slackChannel}",color: "#0000FF",message:"Build successfully complete..."
                  }catch(ex){
                   slackSend channel: "${slackChannel}",color: "#0000FF",message:"Buil step failed :face_with_symbols_on_mouth: ${ex.message}"
                  }
               }
            }            
        }
    
        stage('Test'){
            steps{
               script {
                  try{
                 slackSend channel: "${slackChannel}",color: "#008080",message:"Test started..."
                 sh "mvn test"
                 slackSend channel: "${slackChannel}",color: "#008080",message:"Test successfully complete..."
                  }catch(ex){
                     slackSend channel: "${slackChannel}",color: "#0000FF",message:"Test Step Failed :face_with_symbols_on_mouth: ${ex.message}"
                  }
               }     
            }
        }
        //Deploment start stage
        stage('Deployment'){
            steps{
               script {
                 try{
                     slackSend channel: "${slackChannel}",color: "##00FFFF'",message:"Deployment start..."  
                     sh "mvn package"
                     slackSend channel: "${slackChannel}",color: "##00FFFF'",message:"Deployment succesfully complete..."  
                  }catch(ex){
                      slackSend channel: "${slackChannel}",color: "#0000FF",message:"Deployment Step Failed :face_with_symbols_on_mouth: ${ex.message}"
                 }  
            } 
       }           
     }
  }
}
