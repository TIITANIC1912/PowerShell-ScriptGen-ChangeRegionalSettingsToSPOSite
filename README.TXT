The purpose of this generator, is to create a PowerShell Script, to change the Regional Setting for the selected SPO Sites.

First Execute the Generator for the first time.

Now fill the files with the correct configuration of the options that you want to setup and the sites that you want to change the Regional Settings.

For the correct execution of this generator, you need to fill the files following files:

	-Options.txt, with the correct options for you Regional Configuration. And 
	-SitesURL.txt, with all the sites that you want to change the Regional Configuration with the following nomenclature.

	https://mydomain.sharepoint.com/sites/mysite

	Every site in a new line.

If the Generator respond with and error, the best option is to close all the open files, and delete the Options.txt and SitesURL.txt. Then re-run the Generator to create the deleted files corrected.

If you have any error, please send me and email to tiitanic1912@gmail.com or post and issue on the GitHub Page: https://github.com/TIITANIC1912/PowerShell-ScriptGen-ChangeRegionalSettingsToSPOSite/