def call(String Project, String ImageTag, String dockerhubuser){
  echo "This stage push the Docker Image to Docker hub"
  withCredentials([usernamePassword('credentialsId':"dockerHubCred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")])
                {
                    sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
                    //sh "docker image ${ImageTag} ${Project}:latest ${dockerhubuser}/mongo-shop-app:latest"
                    //docker tag ${Project}:${ImageTag} ${dockerhubuser}/${Project}:${ImageTag}
                    sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
                    echo "DockerHub successfully login and push the image to DockerHub"
                }
}
// def call(Map config = [:]) {
//     def imageName = config.imageName ?: error("Image name is required")
//     def imageTag = config.imageTag ?: 'latest'
//     def credentials = config.credentials ?: 'docker-hub-credentials'
    
//     echo "Pushing Docker image: ${imageName}:${imageTag}"
    
//     withCredentials([usernamePassword(
//         credentialsId: credentials,
//         usernameVariable: 'DOCKER_USERNAME',
//         passwordVariable: 'DOCKER_PASSWORD'
//     )]) {
//         sh """
//             echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
//             docker push ${imageName}:${imageTag}
//             docker push ${imageName}:latest
//         """
//     }
// }

