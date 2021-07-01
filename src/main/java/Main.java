import repository.impl.SubjectRepositoryImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //Menu.menu();

        SubjectRepositoryImpl sri = new SubjectRepositoryImpl();
        
        sri.deleteSubject(37);

    }
}
