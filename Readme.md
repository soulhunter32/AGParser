# AGParser

### This Parser will take 2 html files and compare them against a component ID by searching the high amount of attributes matches.
 
 ## Instructions
- Desired comparing html should be placed on the home folder
- Located on the home folder, execute the following command: `java -jar AGParser.jar
 <origin_file_name> <target_file_name> <element_id>`
- First and second parameters are mandatory, the third one is optional. If no optional ID is entered, the default
 id "make-everything-ok-button" will be used.
 - The expected output will be something like this:
> <br>**Origin attributes**:
> <br>id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"
> <br>**Target attributes found:** 
> <br> a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize
(); return false;"> Do all GREAT </a (Some characters are scaped due markdown)
> <br>**Target XPATH:** 
> <br>html > body > div > div > div[row] > div[col-lg-8] > div[panel, panel-default] > div[panel-footer]

## Different Outputs

- sample-0-origin.html VS sample-1-evil-gemini.html
> <br>**Target attributes found:** 
> <br> a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize
(); return false;"> Do all GREAT </a (Some characters are scaped due markdown)
> <br>**Target XPATH:** 
> <br>html > body > div > div > div[row] > div[col-lg-8] > div[panel, panel-default] > div[panel-footer] 

- sample-0-origin.html VS sample-2-container-and-clone.html
> <br>**Target attributes found:** 
> <br> a class="btn test-link-ok" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okComplete(); return false;"> Make everything OK </a
> <br>**Target XPATH:** 
> <br>html > body > div > div > div[row] > div[col-lg-8] > div[panel, panel-default] > div[panel-body] > div[some-container]

- sample-0-origin.html VS sample-3-the-escape.html
> <br>**Target attributes found:** 
> <br> a class="btn btn-success" href="#ok" title="Do-Link" rel="next" onclick="javascript:window.okDone(); return false;"> Do anything perfect </a
> <br>**Target XPATH:** 
> <br>html > body > div > div > div[row] > div[col-lg-8] > div[panel, panel-default] > div[panel-footer]

- sample-0-origin.html VS sample-4-the-mash.html
> <br>**Target attributes found:** 
> <br> a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize(); return false;"> Do all GREAT </a
> <br>**Target XPATH:** 
> <br>html > body > div > div > div[row] > div[col-lg-8] > div[panel, panel-default] > div[panel-footer]