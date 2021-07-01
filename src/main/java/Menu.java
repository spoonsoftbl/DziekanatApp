import entities.Major;
import entities.Student;
import entities.Subject;
import repository.impl.*;

import java.util.Scanner;

public class Menu {

     LecturerRepositoryImpl lecturerRepositoryImpl = new LecturerRepositoryImpl();
     MajorRepositoryImpl majorRepositoryImpl = new MajorRepositoryImpl();
     RegisterRepositoryImpl registerRepositoryImpl = new RegisterRepositoryImpl();
     StudentRepositoryImpl studentRepositoryImpl = new StudentRepositoryImpl();
     SubjectRepositoryImpl subjectRepositoryImpl = new SubjectRepositoryImpl();

//    public static void menu() {
//        LecturerRepositoryImpl lecturerRepositoryImpl = new LecturerRepositoryImpl();
//        MajorRepositoryImpl majorRepositoryImpl = new MajorRepositoryImpl();
//        RegisterRepositoryImpl registerRepositoryImpl = new RegisterRepositoryImpl();
//        StudentRepositoryImpl studentRepositoryImpl = new StudentRepositoryImpl();
//        SubjectRepositoryImpl subjectRepositoryImpl = new SubjectRepositoryImpl();
//
//        Scanner scan = new Scanner(System.in);
//        try {
//            System.out.println("Select operations menu: ");
//            System.out.println("1 - Student");
//            System.out.println("2 - Lecturer");
//            System.out.println("3 - Register");
//            System.out.println("4 - Administration");
//            System.out.println("");
//            System.out.println("Insert number of chosen operation:");
//            int x = scan.nextInt();
//            int y;
//            if (x == 1) {
//                System.out.println("STUDENT MENU");
//                System.out.println("1 - Search for student by name and last name");
//                System.out.println("2 - Search for student by student ID");
//                System.out.println("3 - Set major for student");
//                System.out.println("4 - Update student");
//                System.out.println("5 - Create new student");
//                System.out.println("6 - Delete student");
//                System.out.println("0 - Main menu");
//                System.out.println("");
//                System.out.println("Select next operation");
//                y = scan.nextInt();
//                scan.nextLine();
//                switch (y) { //do wybierania operacji z menu podanej przez uzytkowniak
//                    case 0:
//                        menu();
//                        break;
//
//                    case 1:
//                        System.out.println("Insert student's name: ");
//                        String tempStudName = scan.nextLine();
//                        System.out.println("Insert student's last name: ");
//                        String tempStudLastName = scan.nextLine();
//                        studentRepositoryImpl.getStudentByNameAndLastName(tempStudName, tempStudLastName);
//                        break;
//
//                    case 2:
//                        System.out.println("Insert student's ID: ");
//                        int tempStudId = scan.nextInt();
//                        scan.nextLine();
//                        studentRepositoryImpl.deleteStudent(tempStudId);
//                        break;
//
//                    case 3:
//                        System.out.println("Insert student's id: ");
//                        tempStudId = scan.nextInt();
//                        scan.nextLine();
//                        majorRepositoryImpl.getAllMajors();
//                        System.out.println("Select major id from the list above: ");
//                        int tempMajorId = scan.nextInt();
//                        scan.nextLine();
//                        studentRepositoryImpl.setStudentMajor(tempStudId, tempMajorId);
//                        break;
//
//                    case 4:
//                        System.out.println("Insert student's ID: ");
//                        tempStudId = scan.nextInt();
//                        scan.nextLine();
//                        studentRepositoryImpl.updateStudent(tempStudId);
//                        break;
//
//                    case 5:
//                        studentRepositoryImpl.saveStudent();
//                        break;
//
//                    case 6:
//                        System.out.println("To delete student insert student's ID: ");
//                        tempStudId = scan.nextInt();
//                        scan.nextLine();
//                        studentRepositoryImpl.deleteStudent(tempStudId);
//                        break;
//
//                    default:
//                        System.out.println("Choose the right operation!");
//                        break;
//                }
//
//                menu(); //porwort to menu glownego
//            }
//
//            if(x == 2){
//
//                System.out.println("LECTURER MENU");
//                System.out.println("Select operation number");
//                System.out.println("1 - Search for lecturer by ID");
//                System.out.println("2 - Search for lecturer by last name");
//                System.out.println("3 - Get lecturers subject list (by ID)");
//                System.out.println("4 - Create new lecturer");
//                System.out.println("5 - Set subject for lecturer");
//                System.out.println("6 - Delete lecturer");
//                System.out.println("0 - Main menu");
//                System.out.println("");
//                System.out.println("Select next operation: ");
//                y = scan.nextInt();
//                scan.nextLine(); //catches enter
//
//                switch(y){
//                    case 0:
//                        menu();
//                        break;
//                    case 1:
//                        System.out.println("Insert lecturer's ID: ");
//                        int lecturerId = scan.nextInt();
//                        scan.nextLine();
//                        lecturerRepositoryImpl.getLecturerById(lecturerId);
//                        break;
//
//                    case 2:
//                        System.out.println("Insert lecturer's last name: ");
//                        String lecturerLastName = scan.nextLine();
//                        lecturerRepositoryImpl.getLecturerByLastName(lecturerLastName);
//                        break;
//
//                    case 3:
//                        System.out.println("Insert lecturer's ID: ");
//                        lecturerId = scan.nextInt();
//                        scan.nextLine();
//                        lecturerRepositoryImpl.getLecturersSubjectList(lecturerId);
//                        break;
//
//                    case 4:
//                        lecturerRepositoryImpl.saveLecturer();
//                        break;
//
//                    case 5:
//                        System.out.println("Insert lecturer's ID: ");
//                        lecturerId = scan.nextInt();
//                        scan.nextLine();
//                        System.out.println("Insert subject's ID: ");
//                        int subjectId = scan.nextInt();
//                        scan.nextLine();
//                        lecturerRepositoryImpl.setSubjectForLecturer(lecturerId, subjectId);
//                        break;
//
//                    case 6:
//                        System.out.println("To delete lecturer insert lecturer's ID: ");
//                        lecturerId = scan.nextInt();
//                        scan.nextLine();
//                        lecturerRepositoryImpl.deleteLecturer(lecturerId);
//                        break;
//
//                    default:
//                        System.out.println("Choose the right operation!");
//                        break;
//                }
//
//            }
//
//            if (x == 3) {
//                System.out.println("REGISTER MENU");
//                System.out.println("1 - Set grade for student");
//                System.out.println("2 - Set grade and grade comment for student");
//                System.out.println("3 - Search for student's subjects");
//                System.out.println("4 - Search for subject's list of students");
//                System.out.println("5 - Search for student's average");
//                System.out.println("6 - Search for student's average");
//                System.out.println("7 - Assign new subject to student");
//                System.out.println("0 - Main menu");
//                System.out.println("");
//                System.out.println("Select next operation: ");
//                y = scan.nextInt();
//                scan.nextLine();
//                switch (y) {
//                    case 0:
//                        menu();
//                    default: //dla innej wartosci niz przewidziana
//                        System.out.println("Insert correct transaction");
//                        break;
//                    case 1:
//                        System.out.println("Insert student's ID");
//                        int tempStudId = scan.nextInt();
//                        scan.nextLine();
//
//                        Student tempStudent = studentRepositoryImpl.getStudentById(tempStudId);
//                        registerRepositoryImpl.getSubjectListForStudent(tempStudent.getStudentId());
//
//                        System.out.println("Select subject ID to set the grade for " + tempStudent.getStudentName() +
//                                tempStudent.getStudentLastname());
//                        int tempSubId = scan.nextInt();
//                        scan.nextLine();
//
//                        Subject tempSubject = subjectRepositoryImpl.findSubjectById(tempSubId);
//
//                        System.out.println("Insert grade (from range 2 - 5): ");
//                        float tempGrade = scan.nextFloat();
//                        scan.nextLine();
//
//                        registerRepositoryImpl.setMarkForStudent(tempStudent, tempSubject, tempGrade);
//
//                        break;
//
//                    case 2:
//                        System.out.println("Insert student's ID");
//                        tempStudId = scan.nextInt();
//                        scan.nextLine();
//
//                        tempStudent = studentRepositoryImpl.getStudentById(tempStudId);
//                        registerRepositoryImpl.getSubjectListForStudent(tempStudent.getStudentId());
//
//                        System.out.println("Select subject ID to set the grade for " + tempStudent.getStudentName() +
//                                tempStudent.getStudentLastname());
//                        tempSubId = scan.nextInt();
//                        scan.nextLine();
//
//                        tempSubject = subjectRepositoryImpl.findSubjectById(tempSubId);
//
//                        System.out.println("Insert grade (from range 2 - 5): ");
//                        tempGrade = scan.nextFloat();
//                        scan.nextLine();
//
//                        System.out.println("Insert comment to mark: ");
//                        String tempComment = scan.nextLine();
//
//                        registerRepositoryImpl.setMarkAndComment(tempStudent, tempSubject, tempGrade, tempComment);
//
//                        break;
//
//                    case 3:
//                        System.out.println("Insert student's ID");
//                        tempStudId = scan.nextInt();
//                        scan.nextLine();
//                        registerRepositoryImpl.getSubjectListForStudent(tempStudId);
//                        break;
//
//                    case 4:
//                        System.out.println("Search for subject by name to get subjects ID. ");
//                        System.out.println("Insert searched subjects name: ");
//                        String tempSubjectName = scan.nextLine();
//                        subjectRepositoryImpl.findSubjectByName(tempSubjectName);
//
//                        System.out.println("Insert subjects ID from list above: ");
//                        int tempSubjectId = scan.nextInt();
//                        scan.nextLine();
//
//                        registerRepositoryImpl.getStudentListForSubject(tempSubjectId);
//
//                        break;
//
//                    case 5:
//                        System.out.println("Insert student's ID: ");
//                        tempStudId = scan.nextInt();
//                        scan.nextLine();
//                        registerRepositoryImpl.getStudentAverage(tempStudId);
//                        break;
//
//                    case 6:
//                        System.out.println("Search for subject by name to get subjects ID. ");
//                        System.out.println("Insert searched subjects name: ");
//                        tempSubjectName = scan.nextLine();
//                        subjectRepositoryImpl.findSubjectByName(tempSubjectName);
//
//                        System.out.println("Insert subjects ID from list above: ");
//                        tempSubjectId = scan.nextInt();
//                        scan.nextLine();
//
//                        registerRepositoryImpl.getSubjectAverage(tempSubjectId);
//                        break;
//
//                    case 7:
//                        System.out.println("Insert student's ID");
//                        tempStudId = scan.nextInt();
//                        scan.nextLine();
//
//                        System.out.println("Search for subject by name to get subjects ID. ");
//                        System.out.println("Insert searched subjects name: ");
//                        tempSubjectName = scan.nextLine();
//                        subjectRepositoryImpl.findSubjectByName(tempSubjectName);
//
//                        System.out.println("Insert subjects ID from list above: ");
//                        tempSubjectId = scan.nextInt();
//                        scan.nextLine();
//
//                        registerRepositoryImpl.setSubjectForStudent(tempStudId, tempSubjectId);
//                        break;
//
//                }
//                menu();
//
//
//            }
//
//            if (x == 3) {
//                System.out.println("ADMINISTRATION MENU");
//                System.out.println("1 - Create new major");
//                System.out.println("2 - Assign new subject to major");
//                System.out.println("3 - Delete major");
//                System.out.println("4 - Create new subject");
//                System.out.println("5 - Assign major to subject");
//                System.out.println("6 - Assign lecturer to subject");
//                System.out.println("7 - Delete subject");
//                System.out.println("0 - Main menu");
//                System.out.println("");
//                System.out.println("Select next operation: ");
//                y = scan.nextInt();
//                scan.nextLine();
//
//                switch (y){
//                    case 0:
//                        menu();
//                        break;
//
//                    case 1:
//                        System.out.println("Insert major name: ");
//                        String tempMajorName = scan.nextLine();
//                        Major tempMajor = new Major(tempMajorName);
//
//                        majorRepositoryImpl.saveMajor(tempMajor);
//                        break;
//
//                    case 2:
//
//
//                }
//
//
//
//            }
//
//            else { //jezeli zostanie wpisana inna wartosc niz z podanych w menu
//                System.out.println("Wybierz poprawną operację!");
//                menu();
//            }
//    } catch (java.util.InputMismatchException e){ //catch missmatchexc dla niepoprawnie wpisanego znaku
//            System.out.println("Podaj poprawną wartość!");
//            menu();
//        }
//
//        }
}
