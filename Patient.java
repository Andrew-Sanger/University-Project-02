/* COSC2135 - Programming 1 - Assignment 2
 * Study Period 3 - 2013
 * 
 * Student - Andrew John Sanger 
 * 
 * Student Number - 3440468
 * 
 * Assignment 2 - Part 1 - Patient Class
 * 
 * This class creates a Patient object using a constructor. It creates private
 * instance variables to store basic details, and constants to store hourly
 * rates for different level procedures. It allows the user to access the
 * patients number, name, procedure date, patient notes and doctors name
 * using accessors. It also allows information and statuses to be changed 
 * for the patient using various different methods. A patient can be admitted, 
 * invoice charge worked out, record a procedure, discharge a patient,
 * and print all patient information to the screen
 */

public class Patient
{
   // The following instance variables contain all patients details.
   private String patientNumber;
   private String patientName;
   private char patientStatus;
   private String procedureDate;
   private int procedureType;
   private String patientNotes;
   private int totalProcedureTime;
   private String doctorName;

   // The following constants contain the costs of the different procedures.
   final double EXPLORATORY_1 = 400.00;
   final double RECONSTRUCTIVE_2 = 800.00;
   final double FOLLOW_UP_3 = 200.00;

   public Patient(String patientNum, String patientName,
                  String procedureDate, int procedureType, String injuryDesc,
                  String doctorName)
   {
      /*
       * This is the constructor for the Patient class. It uses user created
       * variables in most variables, and initiates patientStatus as S -
       * Scheduled.
       */
      this.patientNumber = patientNum;
      this.patientName = patientName;
      this.patientStatus = 'S';
      this.procedureDate = procedureDate;
      this.procedureType = procedureType;
      this.patientNotes = ("- " + injuryDesc);
      this.totalProcedureTime = 0;
      this.doctorName = doctorName;
   }

   // The following accessors return information stored in the class.
   public String getPatientNumber()
   {
      return this.patientNumber;
   }

   public String getPatientName()
   {
      return this.patientName;
   }

   public String getProcedureDate()
   {
      return this.procedureDate;
   }

   public String getPatientNotes()
   {
      return this.patientNotes;
   }

   public String getDoctorName()
   {
      return this.doctorName;
   }

   /*
    * This method calculates the total invoice charge for all procedures
    * performed on the patient.
    */
   public double calculateInvoiceCharge()
   {
      double totalInvoiceCharge = 0;

      if (this.procedureType == 1)
      {
         totalInvoiceCharge = EXPLORATORY_1 * totalProcedureTime;
      }
      else if (this.procedureType == 2)
      {
         totalInvoiceCharge = RECONSTRUCTIVE_2 * totalProcedureTime;
      }
      else if (this.procedureType == 3)
      {
         totalInvoiceCharge = FOLLOW_UP_3 * totalProcedureTime;
      }

      // This rounds the invoice charge value down to two decimal places.
      totalInvoiceCharge = (double) ((int) (totalInvoiceCharge * 100)) / 100;

      return totalInvoiceCharge;
   }

   /*
    * This method changes the patients status to A - Admitted if they are in the
    * S - Scheduled status, and returns a false if they are in any other status.
    */
   public boolean admitPatient()
   {
      boolean patientAdmitted = true;

      if (this.patientStatus != 'S')
      {
         patientAdmitted = false;
      }
      else if (this.patientStatus == 'S')
      {
         this.patientStatus = 'A';
      }

      return patientAdmitted;
   }

   /*
    * This method records information on any procedures performed on the
    * patient. It also changes their status to R - Recovery and adds procedure
    * time onto any procedure time already performed. If their status is not A -
    * Admitted or R - Recovery, then a false value is returned.
    */
   public boolean recordProcedure(String procedureNotes,
                                  int procedureLength)
   {
      boolean procedureRecorded = true;

      if (this.patientStatus != 'A' && this.patientStatus != 'R')
      {
         procedureRecorded = false;
         return procedureRecorded;
      }

      this.patientStatus = 'R';

      this.patientNotes += ("\n- " + procedureNotes);

      this.totalProcedureTime += procedureLength;

      return procedureRecorded;
   }

   /*
    * This method returns a NaN value if patient is not current in the R -
    * Recovery status. If patient is in the R - Recovery status, then the status
    * is changed to D - Discharged and the total invoice charge for the patient
    * is returned.
    */
   public double dischargePatient()
   {
      double patientDischarged = 0;

      if (this.patientStatus != 'R')
      {
         patientDischarged = Double.NaN;
         return patientDischarged;
      }

      this.patientStatus = 'D';

      return (calculateInvoiceCharge());
   }

   // This method displays all patients details on the screen.
   public void displayPatientRecord()
   {
      System.out.printf("\n%-20s%-20s", "Patient No:", this.patientNumber);
      System.out.printf("\n%-20s%-20s", "Patient Name:", this.patientName);

      /*
       * Creates a string to be displayed based on whether a patient is either S
       * - Scheduled, A - Admitted, R - Recovery or D - Discharged.
       */
      String status = "";
      switch (this.patientStatus)
      {
         case 'S':
            status = "Scheduled";
            break;
         case 'A':
            status = "Admitted";
            break;
         case 'R':
            status = "Recovery";
            break;
         case 'D':
            status = "Discharged";
            break;
      }

      System.out.printf("\n%-20s%-20s", "Patient Status:", status);
      System.out.println(" "); // Makes a blank line. Easier to read.
      System.out.printf("\n%-20s%-20s", "Procedure Date:",
                        this.procedureDate);
      System.out.printf("\n%-20s%-20d", "Procedure Type:",
                        this.procedureType);
      System.out.printf("\n%-20s%-20s", "Doctor Assigned:",
                        this.doctorName);

      /*
       * Creates a string for total procedure time to make it easier to display
       * in printf command. Otherwise difficult to display both an integer and a
       * string after on another in a column.
       */
      String duration = (this.totalProcedureTime + " hrs");
      System.out.printf("\n%-20s%-20s", "Procedure Duration:", duration);
      System.out.println(" ");

      /*
       * Creates a string for invoice charge, adds the $ character to the front.
       * This way it is easier to display in the printf command.
       */
      String invoiceCharge = ("$" + calculateInvoiceCharge());
      System.out.printf("\n%-20s%-20s", "Invoice Charge:", invoiceCharge);
      System.out.println(" ");
      System.out.println("\nPatient Notes:");
      System.out.println(this.patientNotes);
   }
}
