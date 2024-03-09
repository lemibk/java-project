/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tabbedpane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Tabbedpane {
 

    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        
       Frame frame = new JFrame("Tabbed Pane Example");
        frame.setVisible(false);
        String num= JOptionPane.showInputDialog("username");
        String numt=JOptionPane.showInputDialog("enter password");
       
        if (num.equals("admin")&&numt.equals("123")){
           JOptionPane.showMessageDialog(null,"login success");
           frame.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"login failed");
        }
JComboBox combo4=new JComboBox();
combo4.addItem("MALE");
combo4.addItem("FEMALE");
JComboBox combo5=new JComboBox();
combo5.addItem(" ");
combo5.addItem("MALE");
combo5.addItem("FEMALE");
JComboBox combo6=new JComboBox();
combo6.addItem(" ");
combo6.addItem("MALE");
combo6.addItem("FEMALE");


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setVisible(true);
        JComboBox comboid=new JComboBox();
        
        JComboBox combo=new JComboBox();
        
        JComboBox comboDorm=new JComboBox();
        JComboBox combo3=new JComboBox();
       
        for (int i = 1; i <=18; i++) {
           comboDorm.addItem(i);
           
        }
        for (int i = 101; i <=118; i++) {
           comboDorm.addItem(i);
           
        }
        for (int i = 201; i <=218; i++) {
           comboDorm.addItem(i);
          
        }
        
        combo3.addItem("MALE");
        combo3.addItem("FEMALE");
        
        
       
       
   JButton add=new JButton("ADD");
                                                      //THE STUDENT INFORMATION TAB BEGINS
       JPanel panel2 = new JPanel();
       panel2.setLayout(new GridLayout(6,5));
      JLabel stdName=new JLabel("ENTER THE STUDENTS NAME");
      JTextField nameField=new JTextField();
      JLabel stdId=new JLabel("ENTER THE STUDENTS ID");
         JTextField idField=new JTextField();
         JLabel stdDepartment=new JLabel("ENTER THE STUDENTS DEPARTMENT");
        JTextField departmentField=new JTextField();
        JLabel stdYear=new JLabel("ENTER THE STUDENTS YEAR");
      JTextField yearField=new JTextField();
       JLabel stdGender=new JLabel("ENTER THE STUDENTS GENDER");
      JTextField GenderField=new JTextField();
      
      panel2.add(stdName);
      panel2.add(nameField);
      panel2.add(stdId);
      panel2.add(idField);
      panel2.add(stdDepartment);
      panel2.add(departmentField);
      panel2.add(stdYear);
      panel2.add(yearField);
      panel2.add(stdGender);
      panel2.add( combo3);
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is loaded");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dormitory","root","admin123");
        System.out.println("connection is created");
        Statement st=con.createStatement();
        System.out.println("statement is created");
       
       add.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
       try{ 
           st.executeUpdate("insert into students(name,id,department,year,gender)"+" values( '"+nameField.getText()+"' ,'"+idField.getText()+"','"+departmentField.getText()+"','"+yearField.getText()+"','"+combo3.getSelectedItem()+"')");
      JOptionPane.showMessageDialog(null,"inserted successfully");
      
          
     
      
       }
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"invalid");
       }
   
       
       }
       
       
       });
       
        panel2.add(add);
        JButton clear=new JButton("clear");
        clear.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
       nameField.setText(" ");
       idField.setText(" ");
       departmentField.setText(" ");
       yearField.setText(" ");
       }
        });
        panel2.add(clear);
        
        
                                                      //THE STUDENT INFORMATION TAB END
                                                      //THE DORM INFORMATION TAB BEGIN
       JLabel gndr=new JLabel("SELECT MALE OR FEMALE BLOCK");
                                                      
                                                      JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4,2));
        JLabel dormBlock=new JLabel("INSERT THE BLOCK NUMBER");
        JTextField BlockNum=new JTextField();
  // JLabel dormNum=new JLabel("INSERT THE DORM NUMBER");
          
        //  JLabel dormCap=new JLabel("INSERT THE DORM capacity");
          //JTextField DormCapf=new JTextField();
           
          JButton addDorm=new JButton("ADD");
          addDorm.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
             try{ 
           st.executeUpdate("INSERT INTO dorms (block_num,gender) " +
                 "VALUES ('" + BlockNum.getText() + "', '" +  combo4.getSelectedItem() + "')");

      JOptionPane.showMessageDialog(null,"inserted successfully");
      
     
      combo.addItem(BlockNum.getText());
     
     
      
       }
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"invalid");
       }
       
       }
        });
          
          
            JButton clearDorm=new JButton("CLEAR");
            clearDorm.addActionListener(new ActionListener(){
       public void actionPerformed (ActionEvent e){
           BlockNum.setText(" ");
           //DormNum.setText(" ");
         //  DormCapf.setText(" ");
           
           
       }
            });
            panel3.add(gndr);
            panel3.add(combo4);
      panel3.add(dormBlock);
      panel3.add(BlockNum);
     
    
   //   panel3.add(dormCap);
    //  panel3.add(DormCapf);
      panel3.add(addDorm);
      panel3.add(clearDorm);
      
      
      
      
       
        
        
        
        
        
    //THE  ASSIGN TAB INFORMATION
        
        JPanel panel4 = new JPanel();
        
        
         JLabel gndra=new JLabel("SELECT MALE OR FEMALE ");
          panel4.add(gndra);
          
panel4.add(combo5);
//             JButton sell=new JButton("MALE");
//             sell.addActionListener(new ActionListener(){
//       public void actionPerformed  (ActionEvent e){
//          combo5.setSelectedIndex(0);
//        }});
//             JButton sellC=new JButton("FEMALE");
//             sell.addActionListener(new ActionListener(){
//       public void actionPerformed  (ActionEvent e){
//          combo5.setSelectedIndex(1);
//        }});
     
//      JOptionPane.showMessageDialog(null,combo5.getSelectedItem());
        combo5.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            
          
            try{ 
                combo.removeAllItems();
                comboid.removeAllItems();
          
         Statement s=con.createStatement();
        String sqlstid="select id from students where gender='"+combo5.getSelectedItem()+"'";
        ResultSet rsstid =st.executeQuery(sqlstid);
         String sqlstbl="select block_num from dorms where gender ='"+combo5.getSelectedItem()+"'";
          ResultSet rsstbl =s.executeQuery(sqlstbl);
           
          
while(rsstbl.next()){
            //  rsstbl.getString(1);
         combo.addItem( rsstbl.getString(1));  
          }
        
while(rsstid.next()){
            //rsstid.getString(1);
       comboid.addItem( rsstid.getString(1));
        }
            }
       catch(SQLException s){
           System.out.println(s);
           JOptionPane.showMessageDialog(null,"invalid");
       }}
        
        
        });
        
        
        
                
                 
         
        panel4.setLayout(new GridLayout(5,3));
       JLabel selectID= new JLabel("SELECT THE ID OF THE STUDENT TBA ");
      
       JLabel selectdormB= new JLabel("SELECT THE BLOCK  TBA ");
       
       JLabel selectdormN= new JLabel("SELECT THE DORM NUMBER TBA ");
       
       
//      panel4.add(sell);
    // panel4.add(combo5);
       panel4.add(selectID);
         panel4.add(comboid);
         panel4.add(selectdormB);
        panel4.add(combo);
        panel4.add(selectdormN);
         panel4.add(comboDorm);
         JButton addas=new JButton("ASSIGN");
             addas.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
             try{ 
           st.executeUpdate("INSERT INTO assign (id,block_num,dorm_num) " +
                 "VALUES ('" + comboid.getSelectedItem() + "', '" + combo.getSelectedItem() + "', '" + comboDorm.getSelectedItem() + "')");

      JOptionPane.showMessageDialog(null,"inserted successfully");
     
      
      //combo.addItem(BlockNum.getText());
     
     
      
       }
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"invalid");
       }
       
       }
        });
             panel4.add(addas);
           
        
        
        
       //THE ASSIGN TAB INFORMATION END
       //THE DISPLAY TAB INFORMATION BEGIN
        JPanel panel5 = new JPanel();
       JTextArea ta=new JTextArea();
       panel5.setLayout(new GridLayout(2,2));
       JButton display=new JButton("DISPLAY");
        display.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
             try{ 
               
          
               String sql="select * from assign";
          ResultSet rs =st.executeQuery(sql);
          
          while(rs.next()){
           //(rs.getString(1)+"\t"+rs.getString(2) + "\t"+rs.getString(3)+"\t");
           ta.append("STUDENT ID"+"\t"+"\t BLOCK NUMBER"+"\t"+"\tDORM NUMBER"+"\n");
           ta.append(rs.getString(1)+"  \t\t  "+rs.getString(2) + "        \t\t\t "+rs.getString(3)+"\t"+"\n");
          }
         
       con.close();
     
    
     
      
       }
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"invalid");
       }
       
       }
        });
        
        
       
       
       
       
       
       
       panel5.add(ta);
        panel5.add(display);
        
        
        
        
        
        
        
        
        
        
         //THE DISPLAY TAB INFORMATION END
         //THE SEARCH TAB BEGINS
       
         JPanel panel6 = new JPanel();
         panel6.setLayout(new GridLayout(2,3));
         JLabel Enter=new JLabel("ENTER THE STUDENT ID");
         JTextField SearchField=new JTextField();
         JTextArea information=new JTextArea();
         JButton Search=new JButton("SEARCH");
         information.append("NAME\t"+"ID\t"+"DEPARTMENT\t"+"YEAR\t"+"BLOCK\t"+"DORM\t"+"\n");
          Search.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
             try{ 
                 Connection nw=DriverManager.getConnection("jdbc:mysql://localhost/dormitory","root","admin123");
                 Statement src=nw.createStatement();
           String ser="select name,id,department,year,gender from students where id="+SearchField.getText();
          ResultSet sear =src.executeQuery(ser);
     while(sear.next()){
           
           information.append(sear.getString(1)+"\t"+sear.getString(2)+"\t"+sear.getString(3)+"\t\t"+sear.getString(4)+"\t");
     }
         String search="select  block_num,dorm_num from assign where id="+SearchField.getText();
          ResultSet sea =st.executeQuery(search);
          while(sea.next()){
           
           information.append(sea.getString("block_num")+"\t"+sea.getString("dorm_num")+"\t"+"\n");
          }
     
       }
           
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"invalid");
           System.out.println(s);
       }
       
       }
        });
         
        JPanel panel9=new JPanel();
        panel9.setLayout(new GridLayout(2,2));
          panel9.add(Enter);
         panel9.add(SearchField);
         panel9.add(Search);
         
         JPanel panel1=new JPanel();
         panel1.setLayout(new GridLayout(1,1));
         panel1.add(information);
       
               panel6.setLayout(new GridLayout(2,1));
         panel6.add(panel9);
         panel6.add(panel1);
         
         
        
       
       
        
        
         
//THE SEARCH TAB ENDS
//THE UPDATE TAB BEGINS
Statement po=con.createStatement();
 JPanel panel7 = new JPanel();
 JLabel upID=new JLabel("ENTER ID");
 JTextField enterId=new JTextField();
 
  JLabel upBL=new JLabel("UPDATE TO BLOCK");
  JTextField enterBlock=new JTextField();
   JLabel upNM=new JLabel("UPDATE TO DORM");
   JTextField enterDorm=new JTextField();
   JButton update=new JButton("UPDATE");
   update.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
             try{ 
    
     String updateQuery = "UPDATE assign SET block_num = '" + enterBlock.getText() + "', dorm_num = '" + enterDorm.getText() + "' WHERE id = " + enterId.getText();

     po.executeUpdate(updateQuery);
     JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY");
       }
           
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"INVALID INPUT");
       }
       
       }
        });
   panel7.setLayout(new GridLayout(4,3));
   
   panel7.add(upID);
   panel7.add(enterId);
    panel7.add(upBL);
     panel7.add(enterBlock);
      panel7.add(upNM);
       panel7.add(enterDorm);
        panel7.add(update);
 
       
        







//THE UPDATE TAB ENDS
//THE DELETE TAB BEGINS
JPanel panel8 = new JPanel();
JPanel panel10=new JPanel();
JPanel panel11=new JPanel();
JLabel delete=new JLabel("INSERT ID");
JTextField dl=new JTextField();
JLabel dlBl=new JLabel("INSERT BLOCK");
JTextField dlbf=new JTextField();
JButton dlst=new JButton("DELETE STD INFO");
JButton dlbl=new JButton("DELETE BLOCK INFO");
dlst.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
             try{ 
    
     String deleteQuery = "delete from students  WHERE id = " + dl.getText();
      String deleteStd = "delete from assign  WHERE id = " + dl.getText();
     

     st.executeUpdate(deleteQuery);
       st.executeUpdate(deleteStd);
     JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY");
       }
           
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"INVALID INPUT");
       }
       
       }
        });
dlbl.addActionListener(new ActionListener(){
       public void actionPerformed  (ActionEvent e){
             try{ 
    
     
      String deleteblock = "delete from dorms WHERE block_num = " + dlbf.getText();
     

     st.executeUpdate(deleteblock);
     
     JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY");
       }
           
       catch(SQLException s){
           JOptionPane.showMessageDialog(null,"INVALID INPUT");
       }
       
       }
        });
panel10.add(delete);
panel10.add(dl);
panel10.add(dlst);
panel10.setLayout(new GridLayout(2,2));
panel11.add(dlBl);
panel11.add(dlbf);
panel11.add(dlbl);
panel11.setLayout(new GridLayout(2,2));
panel8.add(panel10);
panel8.add(panel11);
panel8.setLayout(new GridLayout(2,1));






//THE DELETE TAB ENDS
        tabbedPane.addTab("STUDENT INFO", panel2);
         tabbedPane.addTab("DORM INFO", panel3);
       
        
       
        tabbedPane.addTab("STUDENT ASSIGN", panel4);
        tabbedPane.addTab("DISPLAY", panel5);
         tabbedPane.addTab("SEARCH", panel6);
        tabbedPane.addTab("UPDATE", panel7);
        tabbedPane.addTab("DELETE",panel8);
       
        frame.add(tabbedPane);
        frame.setSize(700, 700);
       
        frame.setVisible(true);
        
    }
        
     
    }
    


