package settings;

import db.TableDB;
import interfaceRoot.ArgumentsSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class UpdateColorTable implements ArgumentsSettings, TableDB
{
    void addColorExamExercise(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(examColorOneL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 1;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 1;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorExamPressNumber(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(examColorTwoL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 2;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 2;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorTranslation(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(exerciseColorOneL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 3;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 3;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorExamMistakes(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(exerciseColorTwoL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 4;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 4;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorExamConter(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(counterColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 5;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 5;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorSectionExercise(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(sectionColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 6;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 6;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorScene(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(sceneColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 7;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 7;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorTime(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(timeColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 8;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 8;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorButton(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(buttonColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 9;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 9;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void addColorIllumination(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            String hex = null;
            try {
                hex = Integer.toHexString(buttonIlluminationL.getValue().hashCode()).substring(0, 6).toUpperCase();
            } catch (Exception e) {
                statement.executeUpdate("UPDATE settings SET actions = '1a1a1a' WHERE id = 10;");
            }
            statement.executeUpdate("UPDATE settings SET actions = '" + hex + "' WHERE id = 10;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
