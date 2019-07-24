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
                   sh "mvn clean"
                   echo "Project build ${successMessage}"  
                   slackSend channel: "${slackChannel}",color: "#0000FF",message:"Succes Build ${projectName}"
            }            
        }
      
       try{
          
        stage('Test'){
            steps{
              
                 sh "mvn test"
                 slackSend channel: "${slackChannel}",color: "#008080",message:"Successfully Test ${projectName}"
                 echo "Project test run ${successMessage}"
            }
        }}
       catch(ex){
        slackSend channel: "${slackChannel}",color: "#008080",message:"Filed Test ${projectName}"
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
