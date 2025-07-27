def call(String Project, String ImageTag, String dockerHubUser){
  echo "This stage push the Docker Image to Docker hub"
  withCredentials([usernamePassword('credentialsId':"dockerHubCred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")])
                {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                    sh "docker image tag mongo-shop-app:latest ${env.dockerHubUser}/mongo-shop-app:latest"
                    sh "docker push ${env.dockerHubUser}/mongo-shop-app:latest"
                    echo "DockerHub successfully login and push the image to DockerHub"
                }
}

