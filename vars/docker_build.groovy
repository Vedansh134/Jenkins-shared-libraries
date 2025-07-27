def call(String ProjectName, String ImageTag, String DockerHubUser){
   echo "This is Building the code"
   sh "whoami"
   sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
}

