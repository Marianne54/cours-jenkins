#!/usr/bin/groovy
def VERSION
def TAGGED


node {
    stage('Checkout Source Code') {
        echo "Checkout Source Code"
        checkout scm

        if (env.TAG_NAME){
            VERSION = env.TAG_NAME.substring(1)
            echo "${VERSION}"
            TAGGED = true
        } else {
            TAGGED = false
        }
    }

  /*  stage('Checkout branch') {
        echo "Checkout branch"
        checkout scm

        if (env.BRANCH_NAME){
            VERSION = env.BRANCH_NAME.substring(1)
            echo "${BRANCH}"
            N0BRANCH = true
        } else {
            N0BRANCH = false
        }
    }*/


    stage('Run unit tests'){
        echo "Running unit test"
        sh "mvn test"
    }

    stage("prepare release"){
        if (TAGGED){
            sh "mvn -e -B versions:set -DnewVersion=${VERSION}"
            sh "mvn -e -B versions:commit"
        }
    }
    stage('Build project') {
        echo "building project"
        sh "mvn package -DskipTests"
    }
    
     stage("Deploy"){
        configFileProvider([configFile(fileId:"4c67d90d-f1d0-485d-a32b-ed13e070de5f", variable: 'MAVEN_SETTINGS')]) {
        // Exécuter la commande mvn avec le settings
      sh "mvn deploy -s $MAVEN_SETTINGS -Preposilite"
      }
    }

    stage("Update integration"){
        echo "get the latest version in the registry and restart the service"
        sh '''
            ssh root@172.16.44.89 /opt/sample-springboot/update.sh
        '''
    }
 
    
}