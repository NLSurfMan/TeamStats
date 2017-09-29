# TeamStats

## Description
Original description: TeamStats is a Java program that displays tables, matches and statistics from a league in some sport. You can also select two teams and compare them in a number of ways. TeamStats is primarily developed for soccer but can also be used with other sports such as ice-hockey, handball etc.

Due to a request on [java-forums.org](http://www.java-forums.org/java-applets/96419-how-can-i-get-old-applet-work.html), this project has been revived.

## History
This is an old applet, originally developed by Mats Bovin, back in 1996 (96-09-22, Version 1 Beta 1 ). Using WaybackMachine, 
it was possible to dig up the original sourcecode for the applet. After the original poster of the forum thread contacted Mats Bovin, he got permission to modify and republish the project  

See: [webarchive.org](https://web.archive.org/web/20111123212448/http://www.mbovin.com/ts/index.html)
   
## Java 1.0.2
The program was originally developed as an applet, using Java 1.0.2. After renaming variables "enum" to "enumeration" due to the keyword change in Java 5, 
the code compiled with Java 8 and actually ran like a charm using AppletViewer. Personally, I find that amazing. That's 20 years of language development, and the code 
still compiles and runs without modification (besides the enum-thing ofcourse).

## Goals
The goal of this project is make the applet usable as a standalone propgram. After that, possibily port this program to current UI standards, using JavaFX. 
  
##Usage
Download the JAR file from the dist directory. Save it to a directory for later.

To run this program, it requires one mandatory option: `Matchfile`. It should contain the match data in the format suitable for Teamstats. Since this program accepts a lot of other options, you can put all the options in one file, called the `Leaguefile` and point the program to that. All the paramaters in that file should separated by an equal-sign (=) (To be more precise, it needs to be in the [Java Properties format](http://docs.oracle.com/javase/6/docs/api/java/util/Properties.html#load(java.io.Reader))). 

##Bat/cmd file
In the `dist` directory is a `cmd`-file which you can copy and adapt, so you can setup multiple competitions for multiple periods.  
 
###Example Leaguefile
Let's assume all our data files are in directory `data` and the name of the leaguefile is `serie-a.txt` with this example content:

````
Matchfile=data/seriea97.txt
Line1=14
LeagueName=Serie A
Season=1996-97
````
then the call to start the program is 
 
````java.exe -jar TeamStats.jar Leaguefile=data/seria-a.txt````

*Make sure you have java.exe in your PATH! Instructions on how to update your PATH variable can be found [here](http://docs.oracle.com/javase/tutorial/essential/environment/paths.html)*.

###Width/height parameters
Normally for applets, the width and height are contained in the HTML file that defines the applet. Since this is a standalone version, you can optionally specifiy them as parameters:
````
java.exe -jar TeamStats.jar Leaguefile=data/seria-a.txt width=800 height=600
````
If you omit them, the defaults are Width=640, Height=480 (Don't you love those old resolutions :))

###Parameter overview
The table below contains all the parameters you can enter either on the command line or in the `Leaguefile`. For more information about the parameters, there is an old document describing them all in
 detail: [Setting parameters](manual/params.html)


| Name (* = required)| Type | Meaning |
| ---- | ---- | ------- |
| Leaguefile | url | URL to file with parameters |
| LeagueName | string | Name of league |
| Season | string | Season of league |
| Matchfile * | url | URL to file with matches |
| WinPoints | int | Points for winning a game |
| DrawPoints | int | Points for a draw |
| LossPoints | int | Points for loosing a game |
| SDWinPoints | int | Points for winning a game in SD |
| SDLossPoints | int | Points for loosing a game in SD |
| SuddenDeath | boolean | League uses Sudden Death |
| ShowSDInTable | boolean | Should SD-columns be showed in the table |
| GDiffSort | boolean | Use goaldiff to separate teams with equal points |
| LineX | int | Place a qualifying line at this position in the table |
| HideX | string | Hide a team |
| PointsX | string | Give extra points to a team |
| MarkX | string | Marks a team in the table |
| NoPrevSeason | boolean | Don't look for previous meetings |
| HideBorder | boolean | Hides border around applet |
| ForeCol | string | Sets foreground color |
| BackCol | string | Sets background color |
| PrimCol | string | Sets primary drawing color |
| SecCol | string | Sets secondary drawing color |
| ButtonCol | string | Sets button color |
| ButtonTextCol | string | Sets button text color |
| ButtonSelectCol | string | Color of selected button |
| DateChar | character | Sets date separator |
| Width | int| Sets the width of the applet |
| Height | int | Sets the height of the applet |
