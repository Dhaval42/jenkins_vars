def notifystarted(email){
	echo "${email}- first mail"
    emailext (
    	 subject: "${currentBuild.currentResult}:Job ${env.JOB_NAME} ${env.BUILD_NUMBER}",
         body: """<p>${currentBuild.currentResult}:  Job ${env.JOB_NAME} </p>
         	   <p> BUild NUMBER: build ${env.BUILD_NUMBER}</p>
         	   <p> Check console Output at:<a href=${env.BUILD_URL}>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
            recipientProviders: [buildUser()],
    )
}
def notifystatus(email){
	echo "${email}- second mail"
	 emailext (
	  attachLog: true,     
	   subject: "STARTED :Job ${env.JOB_NAME} ${env.BUILD_NUMBER} "   , 
	 	body: """<p>STARTED: Job ${env.JOB_NAME} </p>
	 	<p> BUild NUMBER: build ${env.BUILD_NUMBER}</p>
	 	<p> Check console Output at:<a href=${env.BUILD_URL}>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""", 
            recipientProviders: [buildUser()]
	)
}	

