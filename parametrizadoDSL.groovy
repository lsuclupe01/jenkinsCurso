job('ejemplo-02-job-DSL'){
  description('Job DSL de ejemplo para el curso de Jenkins') 
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main'){node-> 
      node / gitConfigName('lsuclupe')
      node / gitConfigEmail('lsuclupe@gmail.com')
    }
  }
  parameters{
    	stringParam('nombre', defaultValue='Julian', description='Parametro de cadena para el Job booleano')
    	choiceParam('planeta', ['Mercurio','Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    	booleanParam('agente', false)
  }
  triggers{
    	cron('H/7 * * * *')
  }
  steps{
    	shell("bash jobscript.sh")
  }
  publishers{
    	mailer('lsuclupe@gmail.com',true,true)
    	slackNotifier {
           //commitInfoChoice(String value)      
           // Basedir of the fileset is Fileset ‘includes’ the workspace root.
           //artifactIncludes(String value)      
           // The slack token to be used to send notifications to Slack.
           //authToken(String value)      
           // Your Slack-compatible-chat's (e.g.
           //baseUrl(String value)      
           // Bot user option indicates the token belongs to a custom Slack app bot user in Slack.      
           //botUser(boolean value)
           // Enter a custom message that will be included with the notifications.
      /*
           customMessage(String value)
           customMessageAborted(String value)
           customMessageFailure(String value)
           customMessageNotBuilt(String value)
           customMessageSuccess(String value)
           customMessageUnstable(String value)
      */
           // Choose a custom emoji to use as the bot's icon in Slack, requires using a bot user, e.g.
        //   iconEmoji(String value)
      /*
           includeCustomMessage(boolean value)
           includeFailedTests(boolean value)
           includeTestSummary(boolean value)
           matrixTriggerMode(String value)
      */
           notifyAborted(true)
           notifyBackToNormal(true)
           notifyEveryFailure(true)
           //notifyFailure(boolean value)
           notifyNotBuilt(false)
           //notifyRegression(boolean value)
           notifyRepeatedFailure(false)
           notifySuccess(false)
           notifyUnstable(false)
          
           // Enter the channel names or user ids to which notifications should be sent.
          // room(String value)
      
           sendAs(null)
      
           // Send message as text as opposed to an attachment.
           //sendAsText(boolean value)
      
           //slackUserIdResolver {}
           startNotification(false)
      
           // Your team's workspace name.
           teamDomain(null)
      
           // Token to use to interact with slack.
           //tokenCredentialId(String value)
      
           //uploadFiles(boolean value)
      
           // Choose a custom username to use as the bot's name in Slack, requires using a bot user
           //username(String value)
          commitInfoChoice('NONE')
      }
  }
}