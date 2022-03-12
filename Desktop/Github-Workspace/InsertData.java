import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class InsertData extends Frame implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==b3)
   System.exit(0);
 else if(e.getSource()==b2)
{
  t1.setText("");
  t2.setText("");
  t3.setText("");
}
else
{
    String s1=t1.getText();
    String s2=t2.getText();
    String s3=t3.getText();
if(s2.equals(s3)==false)
 {
    javax.swing.JOptionPane.showMessageDialog(this,"Retype Correct Password");
    return;
}
else
{
     try
{
    String s4=c1.getSelectedItem().toString();
    /* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:testdsn");*/
  Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:\\JasvaPractice\\Database1.mdb");
     Statement stmt=con.createStatement();
     stmt.executeUpdate("insert into LoginTab values('"+s1+"','"+s2+"','"+s4+"')");
con.close();
    javax.swing.JOptionPane.showMessageDialog(this,"Data Successfully inserted");
    
}catch(Exception ee)
{
  System.out.println(ee);
}
}
}
}
Button b1=new Button("Insert");
Button b2=new Button("Reset");
Button b3=new Button("Exit");
Label l1=new Label("User Name");
Label l2=new Label("Password");
Label l3=new Label("Confirm Password");
Label l4=new Label("User Type");
TextField t1=new TextField(20);
TextField t2=new TextField(20);
TextField t3=new TextField(20);
Choice c1=new Choice();
public static void main(String a[])
{
new InsertData();
}
InsertData()
{
setLayout(null);
c1.addItem("General");
c1.addItem("Admin");
c1.addItem("Supervisor");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
add(l1);
add(t1);
add(l2);
add(t2);
add(l3);
add(t3);
add(l4);
add(c1);
add(b1);
add(b2);
add(b3);
setSize(400,400);
setVisible(true);
setLocation(100,100);
l1.setBounds(20,50,100,25);
t1.setBounds(130,50,100,25);
l2.setBounds(20,80,100,25);
t2.setBounds(130,80,100,25);
l3.setBounds(20,110,100,25);
t3.setBounds(130,110,100,25);
l4.setBounds(20,140,100,25);
c1.setBounds(130,140,100,25);
b1.setBounds(20,170,100,25);
b2.setBounds(130,170,100,25);
b3.setBounds(240,170,100,25);
t2.setEchoChar('*');
t3.setEchoChar('*');
}
}
