package tictactoe_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.xml.transform.Source;


public class TicTacToe_2 extends JFrame {
private int numberOfGames;
private BufferedImage board;
private BufferedImage blueX;
private BufferedImage redO;
private JFrame frame;
private JButton endButton,newGameButton,clearBoardButton,saveButton;
private int cellCount=0;

//private final int WIDTH = 660;
//private final int HEIGHT = 527;
Dimension buttonDimension =new Dimension(150,50);
private saveDB db;
private JPanel panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7,panel_8,panel_9,detail_panel,upscore,downscore;
private JLabel lable_1,lable_2,lable_3,lable_4,lable_5,lable_6,lable_7,lable_8,lable_9,yourScore1,yourScore2,opScore1,opScore2;
private JLabel lableArray[]=new JLabel[9];
private Point userpoint;
private Point computerpoint;
private  Board userboard;
private int user=0;
private int userScore;
private int opponentScore;
private int k1;
private int k2;
private String redCirclepath="src/res/redCircle.png";
private String bluCrosspath="src/res/blueX.png";
private String upScoreString ;
private String downScoreString;

private int clickedbutton;
private boolean enables[]=new boolean[9];
private static int choise;//static for allow in main method
private String mode;
public TicTacToe_2(int user,int opponent,int game,int choise){
    
    
    //mode="EASY";
    upScoreString ="Your Score is       \n";
    downScoreString="Opponent Score is \n";
    this.userScore=user;
    this.opponentScore=opponent;
    this.numberOfGames=game;
    k1=((numberOfGames)-(userScore+opponentScore))+(2*userScore);
    k2=((numberOfGames)-(userScore+opponentScore))+(2*opponentScore);
    System.out.println(k1+"   "+k2); 
    
    try {
        board = ImageIO.read(getClass().getResourceAsStream("/board.png"));
        redO=ImageIO.read(getClass().getResourceAsStream("/redCircle.png"));
        blueX=ImageIO.read(getClass().getResourceAsStream("/blueX.png"));
    } catch (IOException ex) {
        Logger.getLogger(TicTacToe_2.class.getName()).log(Level.SEVERE, null, ex);
    }
    userboard=new Board();
panel_1=new JPanel(new FlowLayout());
panel_2=new JPanel(new FlowLayout());
panel_3=new JPanel(new FlowLayout());
panel_4=new JPanel(new FlowLayout());
panel_5=new JPanel(new FlowLayout());
panel_6=new JPanel(new FlowLayout());
panel_7=new JPanel(new FlowLayout());
panel_8=new JPanel(new FlowLayout());
panel_9=new JPanel(new FlowLayout());
detail_panel=new JPanel(new FlowLayout());
upscore=new JPanel(new FlowLayout());
downscore=new JPanel(new FlowLayout());



endButton=new JButton();
clearBoardButton=new JButton();
newGameButton=new JButton();
saveButton=new JButton();


endButton.setText("END GAME");
clearBoardButton.setText("CLEAR BOARD");
newGameButton.setText("NEW GAME");
saveButton.setText("SAVE GAME");

endButton.setPreferredSize(buttonDimension);
newGameButton.setPreferredSize(buttonDimension);
clearBoardButton.setPreferredSize(buttonDimension);
saveButton.setPreferredSize(buttonDimension);




lable_1=new JLabel();
lable_2=new JLabel();
lable_3=new JLabel();
lable_4=new JLabel();
lable_5=new JLabel();
lable_6=new JLabel();
lable_7=new JLabel();
lable_8=new JLabel();
lable_9=new JLabel();

yourScore1=new JLabel();
opScore1=new JLabel();

yourScore2=new JLabel();
opScore2=new JLabel();


yourScore1.setText(upScoreString);
opScore1.setText(downScoreString);

yourScore2.setText(String.valueOf(k1));
opScore2.setText(String.valueOf(k2));

yourScore1.setFont(new Font("Serif", Font.BOLD, 20));
opScore1.setFont(new Font("Serif", Font.BOLD, 18));

yourScore2.setFont(new Font("Serif", Font.BOLD, 40));
opScore2.setFont(new Font("Serif", Font.BOLD,40));

 lableArray[0]=lable_1;lableArray[1]=lable_2;lableArray[2]=lable_3;
 lableArray[3]=lable_4;lableArray[4]=lable_5;lableArray[5]=lable_6;
 lableArray[6]=lable_7;lableArray[7]=lable_8;lableArray[8]=lable_9;
 
 enables[0]=true;enables[1]=true;enables[2]=true;enables[3]=true;enables[4]=true;
 enables[5]=true;enables[6]=true;enables[7]=true;enables[8]=true;
 
 
panel_1.setBounds(0, 0, 160, 160);
panel_2.setBounds(170, 0, 160, 160);
panel_3.setBounds(340, 0, 160, 160);
panel_4.setBounds(0, 170, 160, 160);
panel_5.setBounds(170, 170, 160, 160);
panel_6.setBounds(340, 170, 160, 160);
panel_7.setBounds(0, 340, 160, 160);
panel_8.setBounds(170, 340, 160, 160);
panel_9.setBounds(340, 340, 160, 160);
detail_panel.setBounds(530, 100, 150, 250);
upscore.setBounds(530,0,150,150);
downscore.setBounds(530,350,150,150);

panel_1.add(lable_1);
panel_2.add(lable_2);
panel_3.add(lable_3);
panel_4.add(lable_4);
panel_5.add(lable_5);
panel_6.add(lable_6);
panel_7.add(lable_7);
panel_8.add(lable_8);
panel_9.add(lable_9);

detail_panel.add(endButton);
detail_panel.add(saveButton);
detail_panel.add(clearBoardButton);
detail_panel.add(newGameButton);

upscore.add(yourScore1);
upscore.add(yourScore2);
downscore.add(opScore1);
downscore.add(opScore2);

loadListners();
ColorPanel panel=new ColorPanel(board);
    frame = new JFrame();
		frame.setTitle("Tic-Tac-Toe");
              //frame.add(but);
                frame.add(panel_1);
                frame.add(panel_2);
                frame.add(panel_3);
                frame.add(panel_4);
                frame.add(panel_5);
                frame.add(panel_6);
                frame.add(panel_7);
                frame.add(panel_8);
                frame.add(panel_9);
                frame.add(detail_panel);
                frame.add(upscore);
                frame.add(downscore);
		//frame.add(board);
                frame.getContentPane().add(panel);
                  
                
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(400, 100);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setSize(700, 539);
    
    if(choise==2){
        AIStart();
    }
}

public void AIStart(){
    Random r=new Random();
    int x=r.nextInt(3);
    int y=r.nextInt(3);
    if(x==0){
        if(y==0){
             lable_1.setIcon(new ImageIcon(blueX));
             enables[0]=false;
        }else if(y==1){
             lable_2.setIcon(new ImageIcon(blueX));
             enables[1]=false;
        }else{
             lable_3.setIcon(new ImageIcon(blueX));
             enables[2]=false;
        }
    }
    if(x==1){
        if(y==0){
             lable_4.setIcon(new ImageIcon(blueX));
             enables[3]=false;
        }else if(y==1){
             lable_5.setIcon(new ImageIcon(blueX));
             enables[4]=false;
        }else{
             lable_6.setIcon(new ImageIcon(blueX));
             enables[5]=false;
        }
    }
    if(x==2){
        if(y==0){
             lable_7.setIcon(new ImageIcon(blueX));
             enables[6]=false;
        }else if(y==1){
             lable_8.setIcon(new ImageIcon(blueX));
             enables[7]=false;
        }else{
             lable_9.setIcon(new ImageIcon(blueX));
             enables[8]=false;
        }
    }
    userpoint=new Point(x, y);
     userboard.placeAMove(userpoint, 1); //2 for user 1 is the opponent
            
     userboard.displayBoard();
         
}
public void loadListners(){
    saveButton.addActionListener(new ActionListener(){

        
        public void actionPerformed(ActionEvent e) {
            db= new saveDB();
            k1=((numberOfGames)-(userScore+opponentScore))+(2*userScore);
            System.out.println(k1);
            String name=JOptionPane.showInputDialog("Enter Your name");
            db.saveData(name,k1);
            
            
        }
        
        
        
    });
    clearBoardButton.addActionListener(new ActionListener(){

        
        public void actionPerformed(ActionEvent e) {
            db= new saveDB();
            
            frame.dispose();
            Choise1 choise= new Choise1(0,0,0);
            choise.setVisible(true);
            
        }

    });
    newGameButton.addActionListener(new ActionListener(){

        
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Choise1 choise=new Choise1(userScore,opponentScore,numberOfGames);
            choise.setVisible(true);
        }
        
        
        
    });
    endButton.addActionListener(new ActionListener(){

        
        public void actionPerformed(ActionEvent e) {
            
            frame.dispose();
            System.exit(0);
           
        }
        
    });
    
    //panel 1
    
   panel_1.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[0]==true){
        clickedbutton=1;
        try{
    lable_1.setIcon(new ImageIcon(redO));
    userpoint=new Point(0, 0);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
            
            userboard.callMinimax(0, 1);
           
             userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
            System.out.println("panel 1 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
           
           
        }catch(Exception ex){
            tiedGame();
        }  
           
    }       }
@Override
public void mouseReleased(MouseEvent e) {
enables[0]=false;
enables[user-1]=false;
                }
});
   //panel 2
      panel_2.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[1]==true){
        clickedbutton=2;
        try{
    lable_2.setIcon(new ImageIcon(redO));
    userpoint=new Point(0, 1);
     userboard.placeAMove(userpoint, 2); //2 for O and 1 is the user
         
            userboard.callMinimax(0, 1);
          
            userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 2 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
          
             }catch(Exception ex){tiedGame();}
             
                }}
@Override
public void mouseReleased(MouseEvent e) {
enables[1]=false;
enables[user-1]=false;
                }
});
        //panel 3
      panel_3.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[2]==true){
        clickedbutton=3;
        try{
  lable_3.setIcon(new ImageIcon(redO));
    userpoint=new Point(0, 2);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
             
            userboard.callMinimax(0, 1);
           
             userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 3 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
          
            }catch(Exception ex){tiedGame();}
           
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[2]=false;
enables[user-1]=false;
                }
});
      //panel 4
      panel_4.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[3]==true){
        clickedbutton=4;
        try{
 lable_4.setIcon(new ImageIcon(redO));
    userpoint=new Point(1, 0);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
            userboard.callMinimax(0, 1);
          
             userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 4 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
         
            }catch(Exception ex){tiedGame();}
               
           
                }}
@Override
public void mouseReleased(MouseEvent e) {
enables[3]=false;
enables[user-1]=false;
                }
});
      //panel 5
      panel_5.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[4]==true){
        clickedbutton=5;
        try{
 lable_5.setIcon(new ImageIcon(redO));
    userpoint=new Point(1, 1);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
            
            userboard.callMinimax(0, 1);
           
            userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 5 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
       
            }catch(Exception ex){tiedGame();}
          
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[4]=false;
enables[user-1]=false;
                }
});
      //panel 6
      panel_6.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[5]==true){
        clickedbutton=6;
        try{
 lable_6.setIcon(new ImageIcon(redO));
    userpoint=new Point(1, 2);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
            userboard.callMinimax(0, 1);
            
             userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 6 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
          
           }catch(Exception ex){tiedGame();}
          
    }}
@Override
public void mouseReleased(MouseEvent e) {
    
        enables[5]=false;
        enables[user-1]=false;

                }
});
      //panel 7
      panel_7.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[6]==true){
        clickedbutton=7;
        try{
 lable_7.setIcon(new ImageIcon(redO));
    userpoint=new Point(2, 0);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
             
            userboard.callMinimax(0, 1);
           
             userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 7 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
          
            }catch(Exception ex){tiedGame();}
          
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[6]=false;
enables[user-1]=false;
                }
});
      //panel 8
      panel_8.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[7]==true){
        clickedbutton=8;
        try{
 lable_8.setIcon(new ImageIcon(redO));
    userpoint=new Point(2, 1);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
      
            userboard.callMinimax(0, 1);
          
            userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 8 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
          // }
           }catch(Exception ex){tiedGame();}
          
                }}
@Override
public void mouseReleased(MouseEvent e) {
enables[7]=false;
enables[user-1]=false;
                }
});
      //panel 9
      panel_9.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[8]==true){
        clickedbutton=9;
        try{
     lable_9.setIcon(new ImageIcon(redO));
    userpoint=new Point(2, 2);
     userboard.placeAMove(userpoint, 2); //2 for user 1 is the opponent
            
            userboard.callMinimax(0, 1);
          
           userboard.placeAMove(userboard.returnBestMove(), 1);
           user= getBestPosition();
           System.out.println("panel 9 "+user);
           lableArray[user-1].setIcon(new ImageIcon(blueX));
           userboard.displayBoard();
          gameOver();   
           
            }catch(Exception ex){tiedGame();}
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[8]=false;
enables[user-1]=false;
                }
});
}
    void tiedGame(){
        numberOfGames+=1;
                    k1=((numberOfGames)-(userScore+opponentScore))+(2*userScore);
                    k2=((numberOfGames)-(userScore+opponentScore))+(2*opponentScore);
                    yourScore2.setText(String.valueOf(k1));
                    opScore2.setText(String.valueOf(k2));
                            
                    JOptionPane.showMessageDialog(null, "Game TIED");//choise=JOptionPane.showConfirmDialog(null, "Game TIED\nDo You wish to play again?");
    }
 int getBestPosition(){
     for (PointsAndScores pas : userboard.rootsChildrenScores) {
                if(pas.score==1){
            if(pas.point.x==0){
                if(pas.point.y==0){
                    return 1;
                }else if(pas.point.y==1){
                    return 2;
                }else{
                    return 3;
                }
            }else if(pas.point.x==1){
                if(pas.point.y==0){
                    return 4;
                }else if(pas.point.y==1){
                    return 5;
                }else{
                    return 6;
                }
            }if(pas.point.x==2){
                if(pas.point.y==0){
                    return 7;
                }else if(pas.point.y==1){
                    return 8;
                }else{
                    return 9;
                }
            }
         }
                else if(pas.score==0){
            if(pas.point.x==0){
                if(pas.point.y==0){
                    return 1;
                }else if(pas.point.y==1){
                    return 2;
                }else{
                    return 3;
                }
            }else if(pas.point.x==1){
                if(pas.point.y==0){
                    return 4;
                }else if(pas.point.y==1){
                    return 5;
                }else{
                    return 6;
                }
            }if(pas.point.x==2){
                if(pas.point.y==0){
                    return 7;
                }else if(pas.point.y==1){
                    return 8;
                }else{
                    return 9;
                }
            }
         }
            }
     return 0;
}

void gameOver(){
     if (userboard.isGameOver()) {
                if (userboard.hasXWon()) {
                    opponentScore+=1;
                    numberOfGames+=1;
                    k1=((numberOfGames)-(userScore+opponentScore))+(2*userScore);
                    k2=((numberOfGames)-(userScore+opponentScore))+(2*opponentScore);
                    yourScore2.setText(String.valueOf(k1));
                    opScore2.setText(String.valueOf(k2));
                    
                    JOptionPane.showMessageDialog(null,"OOPS.... \n You have lost the game...");
            
        } 
                else if (userboard.hasOWon()) {
                    userScore+=1;
                    numberOfGames+=1;
                    k1=((numberOfGames)-(userScore+opponentScore))+(2*userScore);
                    k2=((numberOfGames)-(userScore+opponentScore))+(2*opponentScore);
                    yourScore2.setText(String.valueOf(k1));
                    opScore2.setText(String.valueOf(k2));
                    JOptionPane.showMessageDialog(null, "Congratulations!!!!! \nYou have won the game...");//choise=JOptionPane.showConfirmDialog(null, "Congratulations!!!!! \nYou have won the game...\nDo You wish to play again?");
            
        } 
                else {
                    
                    numberOfGames+=1;
                    k1=((numberOfGames)-(userScore+opponentScore))+(2*userScore);
                    k2=((numberOfGames)-(userScore+opponentScore))+(2*opponentScore);
                    yourScore2.setText(String.valueOf(k1));
                    opScore2.setText(String.valueOf(k2));
                            
                    JOptionPane.showMessageDialog(null, "Game TIED");//choise=JOptionPane.showConfirmDialog(null, "Game TIED\nDo You wish to play again?");
            
        }
                return;
            } 
}
 

}
class ColorPanel extends JPanel{
	BufferedImage theCat;
	public ColorPanel(BufferedImage image){
	theCat = image;
	}
 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(theCat, 0, 0, null);
	}
}
