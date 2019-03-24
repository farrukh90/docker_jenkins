node{
    properties([parameters([string(defaultValue: '127.0.0.1', description: 'What IP to build the container? ', name: 'IP', trim: false), string(defaultValue: 'latest', description: 'What version to build? ', name: 'VER', trim: false)])])
    stage("Remove container"){
        try{
            sh "ssh root@${IP} docker rm -f Flaskex"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }
    
    stage("Run container"){
        sh "ssh   root@${IP}   docker run -d --name Flaskex  -p 4400:4000 farrukhsadykov/flaskex  "
    }
}