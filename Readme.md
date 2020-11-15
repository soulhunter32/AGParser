# AGParser

### This Parser will take 2 html files and compare them against a component ID by searching the high amount of attributes matches.
 
 
 ## Instructions
 - Clone Repository: `git clone https://github.com/soulhunter32/AGParser.git`
 - Build project: `mvn clean install`
 - Place the desired html files to compare on the /target folder

## Run Application
- Located on /target folder, execute the following command: `java -jar AGParser-1.0-SNAPSHOT-jar-with-dependencies.jar
 <origin_file_name> <target_file_name> <element_id>`
- First and second parameters are mandatory, the third one is optional. If no optional ID is entered, the default
 id "make-everything-ok-button" will be used.
 - The expected output will be something like this:
> <br>**Origin attributes**:
> <br>id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"
> <br>**Target attributes found:** 
> <br> <a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize
(); return false;"> Do all GREAT </a>
> <br>**Target XPATH:** 
> <br>html > body > div > div > div[row] > div[col-lg-8] > div[panel, panel-default] > div[panel-footer]