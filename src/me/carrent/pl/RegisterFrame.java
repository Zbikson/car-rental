package me.carrent.pl;

import javax.swing.*;
import java.sql.*;

public class RegisterFrame extends JFrame{

    private static JTextField userName;
    private static JTextField userLastName;
    private static JTextField userPesel;
    private static JTextField userTown;
    private static JTextField userMail;
    private static JTextField userStreet;
    private static JTextField userPostalCode;
    private static JTextField userPhone;
    private static JTextField userLogin;
    private static JPasswordField userPassword;
    private static JTextField userRodzaj;

    public void registerFrame() {


        JFrame frame = new JFrame("Rejestracja");
        frame.setSize(450, 600);
        frame.setLocation(960, 640);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        LoginFrame login = new LoginFrame();
        JButton backToLogin = new JButton("\uD83E\uDC14");
        backToLogin.setBounds(5,5,50,20);
        backToLogin.setFont(backToLogin.getFont().deriveFont(16.0f));
        backToLogin.addActionListener(e -> {
            login.loginFrame();
            frame.setVisible(false);
        });
        frame.add(backToLogin);

        JLabel loginText = new JLabel("Login");
        loginText.setBounds(155,50, 40, 15);
        frame.add(loginText);

        userLogin = new JTextField();
        userLogin.setBounds(220, 45, 100, 20);
        frame.add(userLogin);

        JLabel passwordText = new JLabel("Hasło");
        passwordText.setBounds(155,75, 40, 15);
        frame.add(passwordText);

        userPassword = new JPasswordField();
        userPassword.setBounds(220, 70, 100, 20);
        frame.add(userPassword);

        JLabel nameText = new JLabel("Imie");
        nameText.setBounds(155,125, 40, 15);
        frame.add(nameText);

        userName = new JTextField();
        userName.setBounds(220, 120, 100, 20);
        frame.add(userName);

        JLabel lastNameText = new JLabel("Nazwisko");
        lastNameText.setBounds(155,100, 70, 15);
        frame.add(lastNameText);

        userLastName = new JTextField();
        userLastName.setBounds(220, 95, 100, 20);
        frame.add(userLastName);

        JLabel peselText = new JLabel("Pesel");
        peselText.setBounds(155,150, 70, 15);
        frame.add(peselText);

        userPesel = new JTextField();
        userPesel.setBounds(220, 145, 100, 20);
        frame.add(userPesel);

        JLabel townText = new JLabel("Miasto");
        townText.setBounds(155,175, 70, 15);
        frame.add(townText);

        userTown = new JTextField();
        userTown.setBounds(220, 170, 100, 20);
        frame.add(userTown);

        JLabel streetText = new JLabel("Ulica");
        streetText.setBounds(155,200, 70, 15);
        frame.add(streetText);

        userStreet = new JTextField();
        userStreet.setBounds(220, 195, 100, 20);
        frame.add(userStreet);

        JLabel postalCodeText = new JLabel("Kod pocztowy");
        postalCodeText.setBounds(155,225, 70, 15);
        frame.add(postalCodeText);

        userPostalCode = new JTextField();
        userPostalCode.setBounds(220, 220, 100, 20);
        frame.add(userPostalCode);

        JLabel phoneText = new JLabel("Telefon");
        phoneText.setBounds(155,250, 70, 15);
        frame.add(phoneText);

        userPhone = new JTextField();
        userPhone.setBounds(220, 245, 100, 20);
        frame.add(userPhone);

        JLabel mailText = new JLabel("Email");
        mailText.setBounds(155,275, 70, 15);
        frame.add(mailText);

        userMail = new JTextField();
        userMail.setBounds(220, 270, 100, 20);
        frame.add(userMail);

        userRodzaj = new JTextField("klient");
        userRodzaj.setBounds(0, 0, 100, 30);
        userRodzaj.setVisible(false);
        frame.add(userPassword);


        JButton registerBtn = new JButton("Zarejestruj");
        registerBtn.setBounds(180, 295, 100, 30);
        registerBtn.addActionListener(e -> {

            String loginn = userLogin.getText();
            String password = userPassword.getText();
            String name = userName.getText();
            String lastName = userLastName.getText();
            String pesel = userPesel.getText();
            String mail = userMail.getText();
            String town = userTown.getText();
            String street = userStreet.getText();
            String postalCode = userPostalCode.getText();
            String phone = userPhone.getText();
            String rodzaj = userRodzaj.getText();

            try {
                Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/bazaprojekt", "root", "root"); //tworzy connector
                PreparedStatement myStmt;
                String query = "INSERT INTO `user`(`Login`, `Password`, `Nazwisko`, `Imie`, `Pesel`, `Miasto`, `Ulica`, `Kod_pocztowy`, `Telefon`, `Email`, `Rodzaj`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                myStmt = myCon.prepareStatement(query);

                myStmt.setString(1, loginn);
                myStmt.setString(2, password);
                myStmt.setString(3, lastName);
                myStmt.setString(4, name);
                myStmt.setString(5, pesel);
                myStmt.setString(6, town);
                myStmt.setString(7, street);
                myStmt.setString(8, postalCode);
                myStmt.setString(9, phone);
                myStmt.setString(10, mail);
                myStmt.setString(11, rodzaj);

                myStmt.executeUpdate();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.loginFrame();
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "Zarejestowano! Możesz się zalogować :)");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
                System.out.println(ex);
            }

        });
        frame.add(registerBtn);

    }

}
