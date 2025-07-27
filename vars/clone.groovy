def call(String url, String branch){
        echo "This is Cloning the code form the github"
        git url: "${url}", branch: "${branch}"
        echo "Code cloning form GitHub successfully"
}
