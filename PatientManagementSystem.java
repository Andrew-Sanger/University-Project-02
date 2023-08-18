/* COSC2135 - Programming 1 - Assignment 2
 * Study Period 3 - 2013
 * 
 * Student - Andrew John Sanger 
 * 
 * Student Number - 3440468
 * 
 * Assignment 2 - Part 2 - Patient Management System
 * 
 * This program tests the Patient class, by creating 5 different Patient
 * objects and putting them into a patients[] array. First all details of
 * the 5 objects are shown on screen. Then the user can input an
 * individual patients name and get details on just that patient.
 * The next part of the program is a menu driven system which allows the
 * user to A - Admit a patient, B - Record a procedure, C - Discharge a
 * patient, D - Display all patient records and X - Exit the menu (and
 * end the program itself. Input validation has been used in all parts
 * of the program to ensure incorrect input is not entered.  
 */

import java.util.Scanner;

public class PatientManagementSystem
{
   public static void main(String[] args)
   {
      // Creates a new Scanner object.
      Scanner input = new Scanner(System.in);

      // Creates 5 new empty Patient objects into the array patients.
      Patient[] patients = new Patient[5];

      // Constructs 5 new patient objects.
      patients[0] = new Patient("13-0602", "Dempster, S.", "09/04/13", 2,
                                "Wrist Fracture", "A. Jowett");
      patients[1] = new Patient("13-0751", "Toovey, A.", "29/04/13", 2,
                                "Knee Injury", "J. Feller");
      patients[2] = new Patient("13-0908", "Dempster, S.", "13/06/13", 3,
                                "Wrist Fixator Removal", "A. Jowett");
      patients[3] = new Patient("13-1013", "Watson, J.", "08/07/13", 2,
                                "Collarbone Fracture", "B.Reid");
      patients[4] = new Patient("13-1365", "Lynch, Q.", "15/11/13", 1,
                                "Finger Fracture", "J. Harvey");

      // Prints all patient records created onto the screen using a for loop.
      System.out.print("Current Patient List:");

      for (int i = 0; i < patients.length; i++)
      {
         System.out.printf("\n\n%-20s%-20s", "Patient No:",
                           patients[i].getPatientNumber());
         System.out.printf("\n%-20s%-20s", "Patient Name:",
                           patients[i].getPatientName());
         System.out.printf("\n%-20s%-20s", "Procedure Date:",
                           patients[i].getProcedureDate());
         System.out.printf("\n%-20s%-20s", "Doctor Assigned:",
                           patients[i].getDoctorName());
      }

      System.out.println("\n\n=========================================");

      // Allows the user to search for a specific patients records.
      System.out.print("\nEnter patient name: ");
      String patientName = input.nextLine();

      System.out.println("\nPatient history for " + patientName);
      System.out.println("-----------------------------------------");

      /*
       * This variable contains how many records were found for the entered
       * patients name.
       */
      int patientRecordFound = 0;

      /*
       * This for loop searches all patients records and matches them to the
       * user-entered patient name. It then procedes to display patient info
       * and increase the patientRecordFound variable by 1.
       */
      for (int i = 0; i < patients.length; i++)
      {
         if (patientName.equals(patients[i].getPatientName()))
         {
            patientRecordFound++;

            System.out.println("Procedure Date: " +
                               patients[i].getProcedureDate());
            System.out.println("Doctor Assigned: " +
                               patients[i].getDoctorName());
            System.out.println("Patient Notes:\n" +
                               patients[i].getPatientNotes());
            System.out.println(" ");
         }
      }

      /*
       * This next part finds if patient records were found and displays how
       * many records were found for the specified patient, on the other hand 
       * if no records were found, it says that instead.
       */
      if (patientRecordFound == 0)
      {
         System.out.println("No records found for " + patientName);
      }
      else
      {
         System.out.println("(" + patientRecordFound +
                            " records found for " + patientName + ")");
      }

      // Creates a char variable to hold the menu selection.
      char menuSelection = ' ';

      /*
       * This do-while loop encompasses the entire menu selection part of the
       * program.
       */
      do
      {
         // Displays menu choices.
         System.out.println("\n=========================================");
         System.out.println("\nPatient Management Menu");
         System.out.println("-----------------------");
         System.out.println("A - Admit Patient");
         System.out.println("B - Record Procedure");
         System.out.println("C - Discharge Patient");
         System.out.println("D - Display All Patient Records");
         System.out.println("X - Exit Menu\n");

         System.out.print("Enter your menu selection: ");
         menuSelection = input.nextLine().toUpperCase().charAt(0);

         /*
          * If incorrect menu selection is made, an error message is displayed.
          */
         if (menuSelection != 'A' && menuSelection != 'B' &&
             menuSelection != 'C' && menuSelection != 'D' &&
             menuSelection != 'X')
         {
            System.out.println("\n---Error - Incorrect menu selection. " +
                               "Please try again");
         }

         /*
          * This next else statement runs the Admit Patient part of the program
          * if A is entered by the user.
          */
         else if (menuSelection == 'A')
         {
            System.out.print("\nPlease enter patient number for patient" +
                             " being admitted: ");
            String patientNumber = input.nextLine();
            int patientFound = 0;

            // Searches all patients records for matching patient number.
            for (int i = 0; i < patients.length; i++)
            {
               if (patientNumber.equals(patients[i].getPatientNumber()))
               {
                  boolean admitted = patients[i].admitPatient();

                  if (admitted == false)
                  {
                     System.out.println("\n---Error - Patient " +
                                        patients[i].getPatientName() +
                                        " has already been admitted!");
                  }
                  else
                  {
                     System.out.println("\nPatient " +
                                        patients[i].getPatientName() +
                                        " was admitted successfully.");
                  }

                  // If a matching patient was found, this is increased.
                  patientFound++;
               }
            }

            /*
             * If no patient was found with entered number, this error message
             * is displayed.
             */
            if (patientFound == 0)
            {
               System.out.println("\n---Error - Patient number not " +
                                  "found. Please try again.");
            }
         }

         /*
          * This next else statement runs the Record Procedure part of the
          * program if B is entered by the user.
          */
         else if (menuSelection == 'B')
         {
            System.out.print("\nPlease enter patient number of record" +
                             " to be updated: ");
            String patientNumber = input.nextLine();
            int patientFound = 0;

            for (int i = 0; i < patients.length; i++)
            {
               if (patientNumber.equals(patients[i].getPatientNumber()))
               {
                  System.out.print("\nEnter procedure description: ");
                  String procedureDescription = input.nextLine();

                  System.out.print("\nEnter procedure length " +
                                   "(in hours): ");
                  int procedureLength = input.nextInt();

                  // Checks for trailing new line and removes it.
                  if (input.hasNextLine())
                  {
                     input.nextLine();
                  }

                  boolean recorded =
                           patients[i].recordProcedure(
                                                       procedureDescription,
                                                       procedureLength);

                  if (recorded == false)
                  {
                     System.out.println("\n---Error - Patient " +
                                        patients[i].getPatientName() +
                                        " is not currently admitted!");
                  }
                  else
                  {
                     System.out.println("\nProcedure details recorded " +
                                        "for patient " +
                                        patients[i].getPatientName());
                  }

                  patientFound++;
               }
            }

            if (patientFound == 0)
            {
               System.out.println("\n---Error - Patient number not " +
                                  "found. Please try again.");
            }
         }

         /*
          * This next else statement runs the Discharge Patient part of the
          * program if a C is entered.
          */
         else if (menuSelection == 'C')
         {
            System.out.print("\nPlease enter number of patient to " +
                             "be discharged: ");
            String patientNumber = input.nextLine();
            int patientFound = 0;

            for (int i = 0; i < patients.length; i++)
            {
               if (patientNumber.equals(patients[i].getPatientNumber()))
               {
                  double discharged = patients[i].dischargePatient();

                  // If Double.NaN is true, an error is shown.
                  if (Double.isNaN(discharged) == true)
                  {
                     System.out.println("\n---Error - patient " +
                                        patients[i].getPatientName() +
                                        " is not currently in recovery!");
                  }
                  else
                  {
                     System.out.println("\nPatient " +
                                        patients[i].getPatientName() +
                                        " has been successfully discharged.");
                     System.out.println("Final invoice amount: $" +
                                        discharged);
                  }

                  patientFound++;
               }
            }

            if (patientFound == 0)
            {
               System.out.println("\n---Error - Patient number not " +
                                  "found. Please try again.");
            }
         }

         /*
          * This next else statement runs the Display All Patient Records part
          * of the program if a D is entered.
          */
         else if (menuSelection == 'D')
         {
            System.out.println("\nSummary of all patient records in the " +
                               "system:");
            System.out.println("--------------------------------------" +
                               "-------");

            // Displays patients[i] records.
            for (int i = 0; i < patients.length; i++)
            {
               patients[i].displayPatientRecord();
               System.out.println("----------------------------------" +
                                  "-----------");
            }
         }
      } while (menuSelection != 'X');
   }
}
