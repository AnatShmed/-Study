Scenario Outline: Check menu buttons on the main page
    Given The user is on the main page (https://www.epam.com/)
    When The user clicks on <bName>
    Then Go to <address>
    
Examples:
      | bName | address |
      |Services  | https://www.epam.com/services |
      | How We Do It | https://www.epam.com/how-we-do-it |
      | Our Work | https://www.epam.com/our-work |
      | Insights | https://www.epam.com/insights |
      | About | https://www.epam.com/about |
      | Careers | https://www.epam.com/careers |
      
Scenario: Show jobs in Kyiv
    Given The user is on the Careers page (https://www.epam.com/careers)
    And choosed "Kyiv" from Location list
    When The user clicks on the find button
    Then Show all jobs available in Kyiv

Scenario: Show that "@gmail.com" is invalid email format
    Given The user is on the contact page (https://www.epam.com/about/who-we-are/contact)
     When The user input "@gmail.com" in the email form
     Then Show message about wrong email format

Scenario Outline: Check telephone format 
    Given The user is on the contact page (https://www.epam.com/about/who-we-are/contact)
     And user inputed <phone> in the phone form
     When <phone> contains forbidden characters (alphabetic characters, special characters except '+', '-' and ';')
     Then <isWrongFormat> is true
     And show message about wrong phone format
     When <phone> doesn`t contain forbidden characters (alphabetic characters, special characters except '+', '-' and ';')
     Then <isWrongFormat> is false
Examples:
      | phone | isWrongFormat |
      | qwe123 | true |
      | +123-456;+123 554 | false |
      | (097)-123 | true |
      | 23444533 | false |
      | *123-232-333 | true |


Scenario: Show news for 2002
    Given The user is on the In The News page (https://www.epam.com/about/newsroom/in-the-news)
     When The user choose "2002" from Year list
     Then Show news for 2002

Scenario: Show business news for 2001
    Given The user is on the Press Releases page (https://www.epam.com/about/newsroom/press-releases)
     When The user choose "2001" from Year list
     And choose "Business news" from News Type list
     Then Show business news for 2001

Scenario: Show Year In Reviev video
    Given The user is on the History page (https://www.epam.com/about/who-we-are/history)
     When The user click on play button
     Then Show video from youtube named 'EPAM’s 2019 Year In Review'

Scenario: The video stops when it is not displayed
    Given The user went to https://www.epam.com/services/consult-and-design
    And scrolled down to the video
    And clicked on the play button
    And the video began
     When The user scrolls up
     Then the video stops
