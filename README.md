Duke ip project

1. Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

URL to download: https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html

Open Intellij (if you are not in the welcome screen, click File > Close Project to close the existing project dialog first)
Set up the correct JDK version, as follows:
Click Configure > Structure for New Projects and then Project Settings > Project > Project SDK
If JDK 11 is listed in the drop down, select it. If it is not, click New... and select the directory where you installed JDK 11
Click OK
Import the project into Intellij as follows:
Click Open or Import.
Select the project directory, and click OK
If there are any further prompts, accept the defaults.
After the importing is complete, locate the src/main/java/Duke.java file, right-click it, and choose Run Duke.main(). If the setup is correct, you should see something like the below:
