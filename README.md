# snake-game-oom
OOM Snake Game Assignment

How to run this App?

This is a Desktop application and to run this, you should have installed the Java 1.8 version with the JVM.

First you need to clone the GitHub repository of this project.
Please follow the below steps.

1) First make sure you have installed the git client version controller software.
If not refer this link, download and install it.

    https://git-scm.com/downloads

    You can find multiple platform downloads there. After the installation you can use 
    your terminal for git bash commands.


2) Next, open your terminal, it already configured to git bash commands. run below command to clone the repository to your machine.


    git clone https://github.com/vidurajith-darshana/snake-game-oom.git

3) Now it start to download the repository from the git server.


4) 100% download complete, open your favourite editor. If you are using IDE, it identified the project is gradle project and configured it automatically. If you are using Intellij Idea or Eclipse it will be easy import the libraries to your gradle scripts.


5) If you are using other code editor, please import the below libraries to your gradle script and setup the gradle in your machine.
    * JUnit4
    * junit5
    * JUnit5.7.0
   

6) go to **app** -> **src** -> **com** -> **swlc** -> **bolton** -> **snakeoom**

First you must setup the gradle in your IDE. ByDefault the IDEs gives message to load the gradle plugins. you can configure click on those baloons or IDE appearance settings.

And find the for the file called `Main.java`. If you are using an IDE you can find
a method called `public static void main ()` and you can see triangle button in number line section. press on it and you can run the app.

if not you are using an IDE, you need to configure the gradle build tool. Visit to gradle official site and check the documentation there.

https://docs.gradle.org/current/userguide/installation.html

After you setup the gradle, follow below command to run the app.

if you are using Linux or Unix, 
`./gradlew run`

if you are using Windows,
`gradle run`

    
    