Feature: Handle notes

  Users want to save notes easily
  Notes should be saved automatically

  Scenario: Malin want to save a note about an upcoming concert

    Given Malin want to remember to book Eric Ericssonhallen for Kårsdragets concert in autumn
    When she has entered the details
    Then should Malin be able to see the note
