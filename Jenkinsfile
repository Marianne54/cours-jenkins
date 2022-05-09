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
    stage('Build project') {
        echo "building project"
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
    stage("Deploy") {
       configFileProvider([configFile(fileId: id_config, variable: 'MAVEN_SETTINGS')]) {
        // Exécuter la commande mvn avec le settings
        mvn -s $MAVEN_SETTINGS -Preposilite
}
    
}