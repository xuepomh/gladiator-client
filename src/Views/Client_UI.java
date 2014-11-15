package Views;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class Client_UI extends JFrame {


  /**
   * @author: Nick Stanish
   * @author: Joey Imburgia
   */

  private static final long serialVersionUID = 1635915325136737729L;
  private JPanel mainPanel;
  private JButton connectButton;
  private JTextField username_field, password_field;

  public Client_UI() {
    initLogin();

  }

  private void initLogin() {
    Container contentPane = getContentPane();
    mainPanel = new JPanel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainPanel.setLayout(new MigLayout("fillx, nogrid"));
    mainPanel.setPreferredSize(new Dimension(300, 200));

    JLabel login_text = new JLabel();
    login_text.setText("Login");

    mainPanel.add(login_text, "span 3, wrap");

    JLabel username_field_text = new JLabel();
    username_field_text.setText("Username: ");
    username_field = new JTextField();

    mainPanel.add(username_field_text, "left");
    mainPanel.add(username_field, "growx, w ::100%, span 2, wrap");

    JLabel password_field_text = new JLabel();
    password_field_text.setText("Password:  ");
    password_field = new JTextField();

    mainPanel.add(password_field_text, "left");
    mainPanel.add(password_field, "growx, w ::100%, span 2, wrap");

    connectButton = new JButton("Connect");
    // java 8 lambda
    connectButton.addActionListener(event -> connect(event));
    mainPanel.add(connectButton);


    contentPane.add(mainPanel);
  }

  private void connect(ActionEvent event) {
    password_field.getText();
    username_field.getText();
    try {
      Socket socket = new Socket("localhost", 8080);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      // out.println("asdfkhgasdhjf");
      socket.close();
      // String validation = in.readLine();
    } catch (IOException e) {
    }

  }



}
