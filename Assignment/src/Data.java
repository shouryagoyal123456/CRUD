import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Data extends JFrame{
    Connection conn = null;

    private JPanel contentPane;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblGender;
    private JTable table;
    private JLabel lblCountry;
    private JLabel lblRoom;
    private JLabel lblStatus;
    private JLabel lblNewLabel_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Data frame = new Data();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }
    public Data() throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JButton btnExit = new JButton("Add Data");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new addData().setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
        btnExit.setBounds(450, 510, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    conn c  = new conn();

                    String displayCustomersql = "select * from details" +
                            "";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }


        });
        btnLoadData.setBounds(300, 510, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);



        lblId = new JLabel("FirstName");
        lblId.setBounds(31, 11, 80, 14);
        contentPane.add(lblId);

        JLabel l1 = new JLabel("LastName");
        l1.setBounds(150, 11, 80, 14);
        contentPane.add(l1);

        lblNewLabel = new JLabel("Address");
        lblNewLabel.setBounds(270, 11, 65, 14);
        contentPane.add(lblNewLabel);

        lblGender = new JLabel("City");
        lblGender.setBounds(360, 11, 46, 14);
        contentPane.add(lblGender);

        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        contentPane.add(table);

        lblCountry = new JLabel("Email");
        lblCountry.setBounds(480, 11, 46, 14);
        contentPane.add(lblCountry);

        lblRoom = new JLabel("PhoneNo");
        lblRoom.setBounds(600, 11, 80, 14);
        contentPane.add(lblRoom);



        getContentPane().setBackground(Color.WHITE);
    }
}
