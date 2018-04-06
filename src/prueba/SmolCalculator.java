package prueba;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SmolCalculator extends JFrame implements ActionListener //WithoutLayoutManagers
{
    JButton [][] Numbers = new JButton[3][3];
    JButton zero, one, two, three, four, five, six, seven, eight, nine, backspace, add, subs, mult, div, equal, decpt, clear;
    JTextField txt1, txt2;
    String temp="", tempAns="", operator="", lastOperator="";
    double ans=0, subAns=0;
    Boolean firstSolve=true;
    public static final Font DISPLAY = new Font(Font.SANS_SERIF, Font.ITALIC, 21);
    public static final Font FONT = new Font(Font.SANS_SERIF, Font.ITALIC, 11);
    
    SmolCalculator()
    {
        setVisible(true);
        setSize(245,303);
        setTitle("MiniCalc");
        setResizable(false);
        setLayout(null); //*must edit, use a layout instead of doing maths with dimensions and coordinates
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        txt1 = new JTextField("");
        txt1.setBounds(20, 30, 198, 25);
        add(txt1);
        txt1.setEnabled(false);
        txt1.setFont(DISPLAY);
        txt2 = new JTextField("");
        txt2.setBounds(20, 55, 198, 25);
        add(txt2);
        txt2.setEnabled(false);
        txt2.setFont(DISPLAY);
        
        mult = new JButton("*");
        mult.setBounds(140,100,40,35);
        mult.addActionListener(this);
        mult.setFont(FONT);
        add(mult);

        div = new JButton("/");
        div.setBounds(180,100,40,35);
        div.addActionListener(this);
        div.setFont(FONT);
        add(div);

        add = new JButton("+");
        add.setBounds(140,140,40,35);
        add.addActionListener(this);
        add.setFont(FONT);
        add(add);

        subs = new JButton("-");
        subs.setBounds(180,140,40,35);
        subs.addActionListener(this);
        subs.setFont(FONT);
        add(subs);
        
        zero = new JButton("0");
        zero.setBounds(20, 220, 75, 35);
        zero.addActionListener(this);
        add(zero);
        zero.setFont(FONT);
        
        int b=0, c=1;
        for(int i=0; i<3; i++)
        {
            int a=0;
            for(int j=0; j<3; j++)
            {
                Numbers[i][j]=new JButton(""+c);
                Numbers[i][j].setBounds(20+a, 180-b, 40, 35);
                Numbers[i][j].addActionListener(this);
                Numbers[i][j].setFont(FONT);
                add(Numbers[i][j]);
                a+=40; 
                c++;
            }
            b+=40;
        }
        
        one=Numbers[0][0];
        two=Numbers[0][1];
        three=Numbers[0][2];
        four=Numbers[1][0];
        five=Numbers[1][1];
        six=Numbers[1][2];
        seven=Numbers[2][0];
        eight=Numbers[2][1];
        nine=Numbers[2][2];

        equal = new JButton("=");
        equal.setBounds(145,180,75,35);
        equal.addActionListener(this);
        equal.setFont(FONT);
        add(equal);

        decpt = new JButton(".");
        decpt.setBounds(100,220,40,35);
        decpt.addActionListener(this);
        decpt.setFont(FONT);
        add(decpt);
        
        clear = new JButton("Clear");
        clear.setBounds(145,220,75,35);
        clear.addActionListener(this);
        clear.setFont(FONT);
        add(clear);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==one){
                temp +="1";
                txt1.setText(temp);
                tempAns += "1";
        }
        if(e.getSource()==two){
                temp+= "2";
                txt1.setText(temp);
                tempAns +="2";
        }
        if(e.getSource()==three){
                temp+= "3";
                txt1.setText(temp);
                tempAns +="3";
        }
        if(e.getSource()==four){
                temp+= "4";
                txt1.setText(temp);
                tempAns +="4";
        }
        if(e.getSource()==five){
                temp+= "5";
                txt1.setText(temp);
                tempAns +="5";
        }
        if(e.getSource()==six){
                temp+= "6";
                txt1.setText(temp);
                tempAns +="6";
        }
        if(e.getSource()==seven){
                temp+= "7";
                txt1.setText(temp);
                tempAns +="7";
        }
        if(e.getSource()==eight){
                temp+= "8";
                txt1.setText(temp);
                tempAns +="8";
        }
        if(e.getSource()==nine){
                temp+= "9";
                txt1.setText(temp);
                tempAns +="9";
        }
        if(e.getSource()==zero){
                temp+= "0";
                txt1.setText(temp);
                tempAns +="0";
        }
        if(e.getSource()==decpt){
                temp+=".";
                txt1.setText(temp);
                tempAns +=".";
        }
        if(e.getSource()==add){
            temp+="+";
            txt2.setText(temp);
            operator+="+";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==subs){
            temp+="-";
            txt2.setText(temp);
            operator+="-";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==mult){
            temp+="*";
            txt2.setText(temp);
            operator+="*";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==div){
            temp+="/";
            txt2.setText(temp);
            operator+="/";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==clear){
            txt1.setText("");
            txt2.setText("");
            temp+="";
            tempAns="";
            operator = "";
            subAns = 0;
            firstSolve = true;
        }
        if(e.getSource()==equal){
            process();
            txt2.setText(""+ans);
            temp = "";
            tempAns = "";
        }
    }
    
    public void process()
    {
        ans = Double.parseDouble(tempAns);

        switch(lastOperator)
        {
            case "+":
                ans = subAns + ans;
                break;
            case "-":
                ans = subAns - ans;
                break;
            case "*":
                ans = subAns * ans;
                break;
            case "/":
                ans = subAns / ans;
                break;
            default:
                break;
        }

        lastOperator = operator;
        subAns = ans;
        operator = "";
        tempAns="";
    }            
                
    public static void main(String[] xd)
    {
        SmolCalculator MyCalc = new SmolCalculator();        
    }   
}
