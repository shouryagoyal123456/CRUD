import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addData extends JFrame{

    Connection conn = null;
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;




    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    addData frame = new addData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public addData() throws SQLException {

        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\goyal\\IdeaProjects\\rakshit\\src\\icons\\fifth.png");
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480, 10, 300, 500);
        add(l1);

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 260, 53);
        contentPane.add(lblName);


        JLabel l2 = new JLabel("FirstName :");
        l2.setBounds(35, 111, 200, 14);
        contentPane.add(l2);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel lblName_1 = new JLabel("LatName :");
        lblName_1.setBounds(35, 151, 200, 14);
        contentPane.add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);


        JLabel lblCountry = new JLabel("Address :");
        lblCountry.setBounds(35, 231, 200, 14);
        contentPane.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel("City :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 14);
        contentPane.add(lblReserveRoomNumber);



        JLabel lblCheckInStatus = new JLabel("Email :");
        lblCheckInStatus.setBounds(35, 316, 200, 14);
        contentPane.add(lblCheckInStatus);

        JLabel lblDeposite = new JLabel("PhoneNo :");
        lblDeposite.setBounds(35, 359, 200, 14);
        contentPane.add(lblDeposite);


        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        t4 = new JTextField();
        t4.setBounds(271, 280, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);


        t5 = new JTextField();
        t5.setBounds(271, 316, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        t6 = new JTextField();
        t6.setBounds(271, 359, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();



                try {


                    String s1 = t1.getText();
                    String s2 = t2.getText();
                    String s3 = t3.getText();
                    String s4 = t4.getText();
                    String s5 = t5.getText();
                    String s6 = t6.getText();

                    String q1 = "insert into details values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "')";
                    c.s.executeUpdate(q1);



                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");

                    setVisible(false);
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
