node{
    properties([parameters([string(defaultValue: '127.0.0.1', description: 'Please specify IP to create container', name: 'IP', trim: false)])])
    stage("Remove container"){
        try{
            sh "ssh root@${IP} docker rm -f Flaskex"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }
    
    stage("Run container"){
        sh "ssh   root@${IP}   docker run -d --name Flaskex  -p 6000:4000 farrukhsadykov/flaskex  "
    }
}