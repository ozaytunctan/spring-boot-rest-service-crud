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
       
        stage('Build'){
            steps{
               // sh "rm -rf my-app"
                //sh "git clone https://github.com/ozaytunctan/spring-boot-rest-service-crud.git"
                //sh "mvn clean -f my-app"
               
               script {
                  echo "Branch Name:${env.BRANCH_NAME}"
                  try{
                   //slackSend channel: "${slackChannel}",color: "#0000FF",message:"Build started..."
                   notifyStarted("BUILD");
                   sh "mvn clean"
                   notifySuccessful("BUILD");
                   //slackSend channel: "${slackChannel}",color: "#0000FF",message:"Build successfully complete..."
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
                // slackSend channel: "${slackChannel}",color: "#008080",message:"Test started..."
                 notifyStarted("TEST");
                 sh "mvn test"
                 notifySuccessful("TEST");
               //  slackSend channel: "${slackChannel}",color: "#008080",message:"Test successfully complete..."
                  }catch(ex){
                     notifyFailed();
                    // slackSend channel: "${slackChannel}",color: "#0000FF",message:"Test Step Failed :face_with_symbols_on_mouth: ${ex.message}"
                  }
               }     
            }
        }
        //Deploment start stage
        stage('Deployment'){
            steps{
               script {
                 try{
                     notifyStarted("DEPLOYMENT");
                     //slackSend channel: "${slackChannel}",color: "##00FFFF'",message:"Deployment start..."  
                     sh "mvn package"
                    notifySuccessful("DEPLOYMENT");
                  //   slackSend channel: "${slackChannel}",color: "##00FFFF'",message:"Deployment succesfully complete..."  
                  }catch(ex){
                    notifyFailed()
                     // slackSend channel: "${slackChannel}",color: "#0000FF",message:"Deployment Step Failed :face_with_symbols_on_mouth: ${ex.message}"
                 }  
            } 
       }           
     }
  }
}

def notifyStarted(stage) {
   slackSend (color: '#FFFF00', message: "STARTED ${stage} :airplane: : Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
}

def notifySuccessful(stage) {
    slackSend (color: '#00FF00', message: "SUCCESSFUL ${stage} :airplane: : Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
    currentBuild.result = "SUCCESSFULL"
}

def notifyFailed() {
  slackSend (color: '#FF0000', message: "FAILED :face_with_symbols_on_mouth: : Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
  currentBuild.result = "FAILED"
}
