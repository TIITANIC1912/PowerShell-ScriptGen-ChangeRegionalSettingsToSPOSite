#Original Script From: https://www.sharepointdiary.com/2019/06/sharepoint-online-change-regional-settings-using-powershell.html
#Documentation for the Regional Options: https://docs.microsoft.com/en-us/previous-versions/office/sharepoint-csom/jj171195(v=office.15)
#Script Generator By: TIITANIC1912 - tiitanic1912@gmail.com
#Generator Version: 0.1, Build: 0001


#For this script to work, you need to download the following pre-requisite: https://www.microsoft.com/en-us/download/details.aspx?id=42038
#Load SharePoint CSOM Assemblies
Add-Type -Path "C:\Program Files\Common Files\Microsoft Shared\Web Server Extensions\16\ISAPI\Microsoft.SharePoint.Client.dll"
Add-Type -Path "C:\Program Files\Common Files\Microsoft Shared\Web Server Extensions\16\ISAPI\Microsoft.SharePoint.Client.Runtime.dll"

#Get Credentials to connect
$Cred= Get-Credential
$Credentials = New-Object Microsoft.SharePoint.Client.SharePointOnlineCredentials($Cred.Username, $Cred.Password)

#SITES LOOP START
#SITE LOOP NUMBER 0.
#SCRIPT LOOP FOR THE SITE https://mydomain.sharepoint.com/sites/mysite1
#Set up the context
$SiteURL = "https://mydomain.sharepoint.com/sites/mysite1"
$Ctx = New-Object Microsoft.SharePoint.Client.ClientContext($SiteUrl)

$Ctx.Credentials = $credential
$Web = $Ctx.Web

#Update Regional Settings in sharepoint online using powershell
$Web.RegionalSettings.LocaleId = 1033 #ENGLISH
$Web.RegionalSettings.WorkDayStartHour = 8
$Web.RegionalSettings.WorkDayEndHour = 6

$Web.RegionalSettings.FirstDayOfWeek = 1 #MONDAY
$Web.RegionalSettings.Time24 = True

$Web.RegionalSettings.CalendarType = 1 #GREGORIAN
$Web.RegionalSettings.AlternateCalendarType = 0 #NONE

#64 = Sunday; 32 = Monday; 16 = Tuesday; 8 = Wednesday; 4 = Thursday; 2 = Friday; 1 = Saturday; 
$Web.RegionalSettings.WorkDays = 124

$Web.Update()
$Ctx.ExecuteQuery()
#SITE LOOP NUMBER 0 ENDED.
#SITE LOOP NUMBER 1.
#SCRIPT LOOP FOR THE SITE https://mydomain.sharepoint.com/sites/mysite2
#Set up the context
$SiteURL = "https://mydomain.sharepoint.com/sites/mysite2"
$Ctx = New-Object Microsoft.SharePoint.Client.ClientContext($SiteUrl)

$Ctx.Credentials = $credential
$Web = $Ctx.Web

#Update Regional Settings in sharepoint online using powershell
$Web.RegionalSettings.LocaleId = 1033 #ENGLISH
$Web.RegionalSettings.WorkDayStartHour = 8
$Web.RegionalSettings.WorkDayEndHour = 6

$Web.RegionalSettings.FirstDayOfWeek = 1 #MONDAY
$Web.RegionalSettings.Time24 = True

$Web.RegionalSettings.CalendarType = 1 #GREGORIAN
$Web.RegionalSettings.AlternateCalendarType = 0 #NONE

#64 = Sunday; 32 = Monday; 16 = Tuesday; 8 = Wednesday; 4 = Thursday; 2 = Friday; 1 = Saturday; 
$Web.RegionalSettings.WorkDays = 124

$Web.Update()
$Ctx.ExecuteQuery()
#SITE LOOP NUMBER 1 ENDED.
#SITE LOOP NUMBER 2.
#SCRIPT LOOP FOR THE SITE https://mydomain.sharepoint.com/sites/mysite3
#Set up the context
$SiteURL = "https://mydomain.sharepoint.com/sites/mysite3"
$Ctx = New-Object Microsoft.SharePoint.Client.ClientContext($SiteUrl)

$Ctx.Credentials = $credential
$Web = $Ctx.Web

#Update Regional Settings in sharepoint online using powershell
$Web.RegionalSettings.LocaleId = 1033 #ENGLISH
$Web.RegionalSettings.WorkDayStartHour = 8
$Web.RegionalSettings.WorkDayEndHour = 6

$Web.RegionalSettings.FirstDayOfWeek = 1 #MONDAY
$Web.RegionalSettings.Time24 = True

$Web.RegionalSettings.CalendarType = 1 #GREGORIAN
$Web.RegionalSettings.AlternateCalendarType = 0 #NONE

#64 = Sunday; 32 = Monday; 16 = Tuesday; 8 = Wednesday; 4 = Thursday; 2 = Friday; 1 = Saturday; 
$Web.RegionalSettings.WorkDays = 124

$Web.Update()
$Ctx.ExecuteQuery()
#SITE LOOP NUMBER 2 ENDED.

echo "All Operations Completed."
pause

#SITES LOOP ENDED.
#END OF THE SCRIPT.