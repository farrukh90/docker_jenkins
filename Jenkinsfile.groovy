node{
    properties([parameters([string(defaultValue: '159.203.122.51', description: 'Docker Host', name: 'IP', trim: false), string(defaultValue: 'latest', description: 'Version of the App', name: 'VER', trim: false), string(defaultValue: '4000', description: 'What port would you like to run', name: 'PORT', trim: false)])])
    stage("Remove container"){
        try{
            sh "ssh root@${IP} docker rm -f Flaskex"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }
    
    stage("Run container"){
        sh "ssh   root@${IP}   docker run -d --name Flaskex  -p ${PORT}:4000 farrukhsadykov/flaskex:${VER}  "
    }
}