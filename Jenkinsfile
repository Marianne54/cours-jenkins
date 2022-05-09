<<<<<<< HEAD:jenkinsfile
def VERSION
def TAGGED


node {
    stage('Checkout Source Code') {
        echo "Checkout Source Code"
        checkout scm
    }
    
    stage('Run unit tests'){
        echo "mvn test"
        sh "mvn test"
    }
    stage('Build artifact') {
        echo "building Source Code"
        sh "mvn package -DskipTests"
    }
    stage('checkout') {
        checkout scm
        if (env.TAG_NAMR) {
            TAGGED = True
            VERSION = env.TAG_NAME.substring(1)
        } else {
            TAGGED = false
            VERSION = "snapshot"
        }

    }
    
=======
def VERSION
def TAGGED


node {
    stage('Checkout Source Code') {
        echo "Checkout Source Code"
        checkout scm
    }
    
    stage('Run unit tests'){
        echo "mvn test"
        sh "mvn test"
    }
    stage('Build artifact') {
        echo "building Source Code"
        sh "mvn package -DskipTests"
    }
    stage('checkout') {
        checkout scm
        if (env.TAG_NAMR) {
            TAGGED = True
            VERSION = env.TAG_NAME.substring(1)
        } else {
            TAGGED = false
            VERSION = "snapshot"
        }

    }
    
>>>>>>> c3c19d50cb3e072c4184f5ab1d72d0387c4db1c9:Jenkinsfile
}