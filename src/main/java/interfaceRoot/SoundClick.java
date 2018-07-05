package interfaceRoot;

import db.CreateDB;
import db.TableDB;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.*;
import java.sql.*;

public class SoundClick implements TableDB
{
    public void soundClick(int id) {
//        try {
//            ResultSet resultSet = CreateDB.connection().executeQuery("SELECT mp3 FROM music WHERE id ="+ id +";");
//            while (resultSet.next()){
////                String bip = resultSet.getString("mp3");
//                File file = new File("click.wav");
//                Media hit = new Media(file.toURI().toString());
//                MediaPlayer mediaPlayer = new MediaPlayer(hit);
//                mediaPlayer.play();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
