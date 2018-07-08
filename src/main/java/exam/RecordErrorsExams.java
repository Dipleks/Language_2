package exam;

import db.CreateDB;
import db.TableDB;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static interfaceRoot.ArgumentsExam.improve;
import static interfaceRoot.ArgumentsExam.nameExam;

class RecordErrorsExams
{
    static void mistakesINdb(Label[] arrayOfOffersExam, Label[] number, int i, int START, IExam iExam){
        try {
            arrayOfOffersExam[i].setText(iExam.getExamENG(i, START));
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            String localDateTime = LocalDateTime.now().format(format);
            CreateDB.connection().executeUpdate("INSERT INTO counter " +
                    "(date_time, numb, original, mistakes, part)" +
                    "VALUES ('"+localDateTime+"', '"+number[i].getText()+"', '"+
                    arrayOfOffersExam[i].getText()+"', '"+improve.getText()+"', '"+ nameExam.getText() +"');");
            arrayOfOffersExam[i].setText(iExam.getExamRUS(i, START));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
