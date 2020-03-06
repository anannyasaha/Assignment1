# Assignment
Download Intellij from https://www.jetbrains.com/idea/download/ 
Click Create new Project
Go to File > Project Structure
Go to Project Settings > Libraries
Click on + button
Locate ..\openjfx-11.0.1_windows-x64_bin-sdk\javafx-sdk-11.0.1\lib folder from extracted zip of openJFX 11
Apply settings and click ok
Go to File > Settings
In Settings go to Appearance & Behavior > System Settings > Path Variables
Click on + and add new path variable name it PATH_TO_FX and in value field locate ..\openjfx-11.0.1_windows-x64_bin-sdk\javafx-sdk-11.0.1\lib folder
Apply settings and click ok
The go to Run > Edit Configurations
Select your Application from Application > {your application name}
Then click on Configuration tab and in VM options field write this: --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml
Then Click on Edit templates button select Application in Templates and again in VM options field write this: --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml
Apply settings and click ok and now you are good to go.
Give name to your project.
Clone the repository in your computer.
Transfer all the files from the cloned repository to the project folder.You will be able to open the .java file.
For the fileReader.java please copy paste the address of the file you want to find word count from your computer in the address box.
