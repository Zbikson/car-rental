package me.carrent.pl;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginFrame extends JFrame{
    private static TextField userLogin;
    private static JPasswordField userPassword;

    public void loginFrame() {
        RegisterFrame register = new RegisterFrame();
        Menu menu = new Menu();
        JFrame frame = new JFrame("Logowanie");
        frame.setSize(400,500);
        frame.setLocation(960, 640);
        frame.setResizable(false);
        frame.setLayout(null);

        JLabel topText = new JLabel("Wpożyczalnia samochodów J&M");
        topText.setBounds(90,10, 300,70);
        frame.add(topText);

        JLabel textLogin = new JLabel("Login");   // tekst "Wpisz login"
        textLogin.setBounds(60, 100, 60, 30);
        frame.add(textLogin);

        JLabel textPassword = new JLabel("Hasło");    // tekst "Wpisz haslo"
        textPassword.setBounds(60, 200, 60, 30);
        frame.add(textPassword);

        JLabel textFooter = new JLabel("© Jakub & Mateusz");   //stopka J&M
        textFooter.setForeground(Color.lightGray);
        textFooter.setBounds(260, 425, 200, 30);
        frame.add(textFooter);

        userLogin = new TextField();  //okno do wpisania loginu
        userLogin.setBounds(120, 105, 200, 25);
        frame.add(userLogin);

        userPassword = new JPasswordField();   //okno do wpisania hasła
        userPassword.setBounds(120, 205, 200, 25);
        frame.add(userPassword);

        JButton loginBtn = new JButton("Zaloguj");  //przycik Zaloguj
        loginBtn.setBounds(140,300,100,40);
        loginBtn.addActionListener(e -> {//button login listener

            try {
                Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bazaprojekt", "root", "root"); //tworzy connector
                PreparedStatement myStmt;
                String query = "SELECT `Login`, `Password` FROM `user` WHERE Login=? and Password=?";
                myStmt = myCon.prepareStatement(query);
                ResultSet rs = null;

                myStmt.setString(1, userLogin.getText());
                myStmt.setString(2, userPassword.getText());
                rs = myStmt.executeQuery();


                if(rs.next()){
                    menu.menuFrame();
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Niepoprawne dane!");
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Niepoprawne dane!");
            }

        });
        frame.add(loginBtn);

        JButton registerBtn = new JButton("Rejestracja");  //przycik Zaloguj
        registerBtn.setBounds(140,350,100,40);
        registerBtn.addActionListener(e -> {
            register.registerFrame();
            frame.setVisible(false);
        });
        frame.add(registerBtn);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
