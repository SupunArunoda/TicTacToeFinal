
package tictactoe_2;

import java.sql.*;
import java.util.Stack;

public class saveDB{
    Stack namelist;
    Stack scorelist;
    private Connection con;
    private String namearr[]= new String[5];
    private int scoresarr[]=new int[5];
   
    private String query = "select * from scores";
public saveDB(){
    namelist =new Stack();
    scorelist=new Stack();
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoedb","root","");
        System.out.println("connected");
    }
    catch(Exception ex){
        System.out.println("error3" + ex);
    }
}
    
    private void getData(){
        
            
        try{
            Statement st;
            ResultSet rs;
            st =con.createStatement();
            
            rs=st.executeQuery(query);
            int i=0;
            while(rs.next()){
                String name =rs.getString(1);
                String score =rs.getString("Score");
                namelist.push(name);
                scorelist.push(Integer.parseInt(score));
                System.out.println(namelist);
                
            }
            
        }
        catch(Exception ex){
            System.out.println("Error   "+ex);
        
    }
        System.out.println(namelist);
        System.out.println(scorelist);
        
        System.out.println("");
}
    public void saveData(String name,int score){
        try{
            
            Statement wst;
            ResultSet wrs;
            wst = con.createStatement();
            PreparedStatement ps =con.prepareStatement("insert into scores values(?,?,DEFAULT)");
            ps.setString(1, name);
            ps.setInt(2, score);
            ps.executeUpdate();
        }
        catch(Exception ex2){
            System.out.println("Error2"+ex2);
        }
    }
    public void preparelists(){
        getData();
        
        int j=0;
        
        Stack s=(Stack)scorelist.clone();
        s.sort(null);
        while(!s.isEmpty() && j<5){
        
            namearr[j]=(String)namelist.get(scorelist.indexOf(s.lastElement()));
            scoresarr[j]=(int)s.lastElement();
            j+=1;
            s.remove(s.lastElement());
        }
        
        
    }
    public String[] getNamelist(){
        return namearr;
    }
    public int[] getScorelist(){
        return scoresarr;
    }
    //public Stack top10Namelist(){
        
    //}
    
}

