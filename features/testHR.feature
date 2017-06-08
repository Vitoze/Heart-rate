Feature: HR based-alarm
	I want this to work

Scenario: Get a alarm on HR peak
    Given HR peak
    When HR peak > 150
    Then Alarm count should increase.