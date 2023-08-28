# University-Project-02
## University project 2 - Programming 1 - Patient Management System

The second project in the Programming 1 course. This is my first ever major project using classes and objects.

***The following is copied directly from the project.***

## Background information (preamble)

In this assignment you will develop a simple patient management system for a sports injury clinic that provides services for both injury assessment and management of injuries that require more extensive (reconstructive) treatment.

This patient management system will need to maintain records for patients who have been treated by the hospital, including a description of any procedures that have been scheduled / performed for the patient in question. The record for a Patient in the system can be in one of four possible states:

- ‘S’ (Scheduled) - procedure scheduled, patient is waiting to be admitted/treated
- ‘A’ (Admitted) - patient admitted, waiting for procedure
- ‘R’ (Recovery) - patient in recovery after procedure has been performed
- ‘D’ (Discharged) - patient has been released from the hospital

This class should also provide methods that allow transitions between states the patient can be in - the triggers for moving from one state to another are shown in the state diagram below: 

![Screenshot 2023-08-18 164702](https://github.com/Andrew-Sanger/University-Project-02/assets/74388624/4db26772-6313-4e84-8076-c6c3f986aa66)

Surgical procedures performed by the Sports-Fix clinic are categories into three different types (which relate to the complexity of the procedure to be performed) and each procedure type has a corresponding hourly charge for the clinic’s services (covers all other services the patient will use as part of the surgeon’s fee). The different procedure types and corresponding hourly rates are broken down in the table below:

![Screenshot 2023-08-18 164908](https://github.com/Andrew-Sanger/University-Project-02/assets/74388624/3b78382c-a390-45dc-895e-4dd787150148)

## Stage 1 - Implementing the Patient class (45 marks)

You are required to write a class named Patient to model the details of a patient who is scheduled to have a procedure performed by a physician at the sports injury clinic.

The design and functionality for this Patient class will be discussed below and you must adhere to this class design / functional specification - **no changes to this design are permitted unless a specific clarification or correction is made by the instructor, as part of this task is being able to understand and follow a design specification that you have been given.**

1. Define private instance variables to store basic Patient record details: the patient number (String) patient name (String), patient status (a char), procedure date (String), the procedure type (an int), patient notes (a String that will initially be a description of the patient’s injury, and which will subsequently have details of procedures that have been performed on the Patient appended to it), the total procedure time (an int) and the doctor name (a String). (4 marks)

2. Define constants representing the hourly charges for exploratory procedures ($400), reconstructive procedures ($800) and follow-up procedures ($200). (3 marks)

3. Provide a constructor for the class that accepts the patient number (a String), patient name (a String), procedure date (a String in the format dd/mm/yy), procedure type (an int), the injury description (a String) and the doctor name of the physician who is administering the patient’s treatment. This constructor should initialise the instance variables with the corresponding parameter values that have been passed in - it should also initialise the patient notes instance variable to the injury description that was passed in initially and initialise the patient status instance variable to ‘S’ (indicating that the new patient has had a procedure Scheduled). (4 marks)

> public Patient (String patientNo, String patientName, String procedureDate, int procedureType, String injuryDescription, String doctorName)

4. Implement accessors for the patient number, patient name, procedure date, patient notes and doctor name instance variables. (5 marks)

5. Implement a method public double calculateInvoiceCharge(), which calculates and returns the total charge for services rendered by the clinic - ie. total procedure hours * the applicable hourly charge (which is based on the procedure type). (5 marks)

6. Implement a method public boolean admitPatient(), which records when a Patient has been admitted to the clinic for a procedure. This method should start by checking to see if the patient status is not currently ‘S’ (Scheduled) - if that is the case then a false value should be returned, otherwise the patient status should be updated to ‘A’ (Admitted) and a true value should be returned. (4 marks)

7. Implement a method public boolean recordProcedure(String procedureNotes, int procedureLength), which records details of a procedure that has been performed on a Patient. This method should start by checking to see if the patient status is not currently ‘A’ (Scheduled) 'A' (Admitted) or ‘R’ (Recovery) - if that is the case then a false value should be returned, otherwise the patient details should be updated to reflect the performing of the procedure by doing the following: (8 marks)

    - reset the patient status to ‘R’ (Recovery)
    - append (concatenate) the procedureNotes that were passed in as a parameter onto the end of existing patient notes (remember that the patient notes String should be structured in such a way that each entry is on a separate line - this is a similar process to that specified for recording of damage repair / traffic infringement details in stage 3 of assignment 1)
    - add the procedureLength that was passed in as a parameter to the total procedure time.

Once the Patient details have been updated in the manner described above a true value should be returned.

8. Implement a method public double dischargePatient(), which records when a Patient has been discharged from the clinic. This method should start by checking to see if the patient status is not currently ‘R’ (Recovery) - if that is the case then the value Double.NaN (this is a constant in the predefined Double class) should be returned, otherwise the patient status should be updated to ‘D’ (Discharged) and the (final) invoice charge for the patient should be returned. (4 marks)

9. Implement a method public void displayPatientRecord() , which displays all of the details of a Patient to the screen in a neat, formatted manner - this summary should include the following details:

    - the patient number, patient name and patient status (note that the status should be displayed as “Scheduled”, “Admitted”, “Discharged”, etc)
    - the procedure date and procedure type (ie. 1, 2 or 3)
    - the doctor name and procedure length
    - the current total invoice charge (note: you will need to call the calculateInvoiceCharge() method here)
    - the patient notes

## Stage 2 - Using the Patient class (50 marks)

In this stage you will be implementing a separate application class PatientManagementSystem that will demonstrate the creation, storage and use / manipulation of a collection of Patient objects which
have been instantiated from the Patient class described previously in Stage 1.

This application class should be implemented in a separate file.

This set of Patient objects will be stored in an array of Patient references and you will need to demonstrate how this array of Patient objects can be iterated through, how specific objects can be located within the array and how these objects can be referred to or manipulated by calling methods defined previously within the Patient class (as described in Stage 1) for the objects that are being stored in the array.

We will be exploring how to approach creating and managing an array of objects during the week 6 learning materials and live chat sessions.

In the specification for each of the requirements below you will see snapshots of particular aspects of the application’s execution that are relevant to the requirement being discussed - these snapshots are actually just a single run through the program that has been broken down into sections corresponding to each of the functional requirements for this stage.

You should note that each of the requirements below should be implemented /executed in sequence within your main method (ie. one after another) - it is not acceptable to make the entire application class a menu driven program.

The description of the individual “features" you are required to implement in this application class begins below (these can all be done inside the main() method of your application class):

1. Declare an array named patients that can store the references of up to five (5) Patient objects. (2 marks)

2. Create five (5) Patient objects, passing in the values specified below to the constructor, and store the objects in the patients array. (5 marks)

3. Implement a basic feature which display the patient number, procedure date and doctor name for each Patient object stored in the array as shown below in the sample screenshot: (5 marks)

![Screenshot 2023-08-18 170148](https://github.com/Andrew-Sanger/University-Project-02/assets/74388624/02b5233f-3cac-4443-8458-917103c6e474)

**Note: You must do this by using a loop to iterate through the patients array and then call the appropriate accessors for each object in the array in order to retrieve the required details, so that they can be printed to the screen as shown above. It is not acceptable to create an extra method which does the printing over in the Patient class and then call that method for each object here.**

4. Implement another feature which allows the user to display the full history for a specified patient. This feature should prompt the user to enter the patient name they wish to search for and then display the procedure date, doctor name and patient notes for Patient records that are in the system for the specified patient name, as shown in the screen shot on the next page. (5 marks)

![1](https://github.com/Andrew-Sanger/University-Project-02/assets/74388624/e0fbcf5e-f3e1-4787-9278-2c6d242a1cb7)

If no Patient records were found for the specified patient name then a suitable error message should be displayed to the screen as shown below:

![2](https://github.com/Andrew-Sanger/University-Project-02/assets/74388624/f1c31b86-5c4b-4d89-be63-3c3836e19d8f)

5. Implement a menu-driven patient tracking feature, which provides options that allow the user to admit a patient, record procedure details for a patient, discharge a patient and display a summary of all patient records in the system as described below:

    - **Patient Tracking System Menu** - This case-insensitive menu (ie. one that accepts both the lower case and upper case versions of each valid menu selection) should provide options to borrow a Patient, record a procedure for a Patient , discharge a patient, display all patient record details in the system and exit the menu. This menu feature should continue to display the available options and prompt the user to enter their selection until they choose the “Exit” option and the menu should display a suitable error message when the user enters an invalid selection. 

    - **Admit Patient Feature** - The “Admit Patient” feature should start off by prompting the user to enter the patient number of the Patient that is being admitted, after which it should search for a matching Patient object in the patients array. If a Patient object with the specified patient number was not found in the patients array then a suitable error message should be displayed to the screen. Otherwise if a Patient with the specified patient number was found in the patients array, then the program should attempt to call the admitPatient() method for the Patient object that was located earlier, check the result it returns and display a message indicating whether the attempt to admit the patient was successful or not.

    - **Record Procedure Feature** - The “Record Procedure” feature should start off by prompting the user to enter the patient number of the Patient that is being admitted, after which it should search for a matching Patient object in the patients array. If a Patient object with the specified patient number was not found in the patients array then a suitable error message should be displayed to the screen, otherwise if a Patient with the specified patient number was found in the patients array, then the program should proceed to prompt the user to enter the procedure description and procedure length
(in hours). Once the required details have been entered by the user then the feature should attempt to call the recordProcedure() method for the Patient object that was located earlier (passing along the details entered by the user as parameters), check the result it returns and display a message indicating whether the attempt to record the procedure details for the patient was successful or not.

  - **Discharge Patient Feature** - The “Discharge Patient” feature should start off by prompting the user to enter the patient number of the Patient that is being discharged, after which it should search for a matching Patient object in the patients array. If a Patient object with the specified patient number was not found in the patients array then a suitable error message should be displayed to the screen, otherwise if a Patient with the specified patient number was found in the patients array, then the program should attempt to call the dischargePatient() method for the Patient object that was located earlier and trap the result (double value) that it returns. This result should be first checked to see if it was the “failure” signal (Double.NaN) - note that you cannot check for the value Double.NaN using the basic equality (‘==’) operator, so you will need to perform this check in a manner similar to that shown below:

> double result = someMethod();
> if (Double.isNaN(result) == true)
> {
> System.out.println(“The method returned an error!”);
> }

If the result was not Double.NaN then you should print that result, which represents the final invoice charge for services rendered whilst the patient was admitted to the clinic, to the screen.

  - **Display All Patient Records feature** - This feature should print details for all of the Patient objects in the system by using a loop to iterate (step) through the patients array and invoking (calling) the displayPatientRecord() method for each Patient object in turn.

## Coding Style (5 marks)

Your program should demonstrate appropriate coding style, which includes:

- Levels of 3 or 4 spaces used to indent rather than tabs - you can set up your IDE/editor to automatically replace tabs with levels of 3 or 4 spaces.
- Indentation levels used are consistent throughout program
- A new level of indentation added for each new class/method/ control structure used
- Going back to the previous level of indentation at the end of a class/method/control structure (before the closing brace if one is being used)
- Lines of code not exceeding 80 characters in length - lines which will exceed this limit are split into two or more segments where required
- Expressions are well spaced out and source is spaced out into logically related segments
- Use of appropriate identifiers wherever possible to improve code readability
- Use of comments to describe the purpose of each data class, each method within a data class and any non-trivial segments of code within those methods.

## General Implementation Notes/Guidelines

You are being assessed on your ability to write a program in an object-oriented manner in this assignment - as such you should treat the Patient class implementation as if it is a blueprint for a single Patient and demonstrate how you can create the required set of Patient objects in a separate application class (that contains a main method) and use/manipulate this set of Patient objects in different ways.

Your submission will be penalised heavily if you go against these guidelines by attempting to implementing the program in a procedural manner or treating the Patient class as a repository for all Patient information, instead of just a blueprint for a single Patient - refer to the material covered in weeks 5-6 of the course to get a better understanding of the philosophy behind developing your program for this assignment.

You should stick to using the standard Java API (version 1.6 and 1.7 are both ok) when implementing your program – use of third party API’s will mean that the markers will not be able to compile and run your program, which will result in significant penalties for a “non-functional” program being applied.

If you are using the Scanner class for reading input then it is likely that you will run into the “Scanner use bug” at some points in the user-input sequence for this program – the input sequences were deliberately structured to create a potential “Scanner use bug” issue at different points and you should deal with this problem in an appropriate manner.
