# Java Swing

### Basic reference library for java swing

```java
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
```

### Creating a basic GUI window

```java
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingInterface extends JFrame {
  public SwingInterface() {
    // set title for GUI
    setTitle("First Java GUI");
    // set GUI windows size(width, length)
    setSize(400,200);
    // close operation if click "X" button
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // declare new label inside GUI
    JLabel jl = new JLabel("This is a JFrame window.");

    // create container content
    Container c = getContentPane();
    // add label to container
    c.add(jl);
    // GUI windows visibility
    setVisible(true);
  }

  public static void main(String[] args) {
    // execute SwingInterface()
    new SwingInterface();
  }
}
```

```java
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame jf = new JFrame("Second Java GUI");
    // direction and size(to right, to down,width, height)
    jf.setBounds(300, 100, 400, 200);
    JPanel jp = new JPanel();
    JLabel jl = new JLabel("This is a label.");

    jp.setBackground(Color.white);
    // put label inside frame
    jp.add(jl);
    jf.add(jp);
    jf.setVisible(true);
  }
}
```

### Java Swing Border Layout

* It consist of multiple layout that can be used to design software graphical interface, it also can combined multiple border layout together during the implementation of GUI interface.
* Java swing border design are based on the below direction:

  ![Swing Layout area](./Pictures/swing-border.gif "Border design")

#### 1. Border Layout

```java
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Simple Border Interface");
    frame.setSize(400,200);
    frame.setLayout(new BorderLayout());

    JButton button1 = new JButton("UP");
    JButton button2 = new JButton("LEFT");
    JButton button3 = new JButton("MID");
    JButton button4 = new JButton("RIGHT");
    JButton button5 = new JButton("DOWN");

    // set border position
    frame.add(button1,BorderLayout.NORTH);
    frame.add(button2,BorderLayout.WEST);
    frame.add(button3,BorderLayout.CENTER);
    frame.add(button4,BorderLayout.EAST);
    frame.add(button5,BorderLayout.SOUTH);

    frame.setBounds(300,200,600,300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

#### 2. Flow Layout (box display flex)

```java
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Flexbox Layout");
    JPanel jPanel = new JPanel();
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");

    // Add button to JPanel
    jPanel.add(btn1);
    jPanel.add(btn2);
    jPanel.add(btn3);
    jPanel.add(btn4);
    jPanel.add(btn5);
    jPanel.add(btn6);
    jPanel.add(btn7);
    jPanel.add(btn8);
    jPanel.add(btn9);

    jPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
    jPanel.setBackground(Color.gray);
    frame.add(jPanel);
    frame.setBounds(300,200,300,150);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

#### 3. Card Layout

```java
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Login Interface");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel cards = new JPanel(new CardLayout());

    // button
    p1.add(new JButton("Login"));
    p1.add(new JButton("Register"));
    p1.add(new JButton("Forgot Password"));

    // textbox
    p2.add(new JTextField("Login name box"));
    p2.add(new JTextField("Password box"));
    p2.add(new JTextField("Code box"));

    cards.add(p1,"card1");
    cards.add(p2,"card2");
    CardLayout cl = (CardLayout)(cards.getLayout());
    // to show cards layout,change "cards2" to "cards1" will change interface
    cl.show(cards, "card2");

    frame.add(cards);
    frame.setBounds(300,200,400,200);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

#### 4. Grid Layout

```java
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Simple Calculator Layout");
    JPanel panel = new JPanel();

    // GridLayout(row,col,pixel left right, top bottom)
    panel.setLayout(new GridLayout(4,4,5,5));
    panel.add(new JButton("7"));
    panel.add(new JButton("8"));
    panel.add(new JButton("9"));
    panel.add(new JButton("/"));
    panel.add(new JButton("4"));
    panel.add(new JButton("5"));
    panel.add(new JButton("6"));
    panel.add(new JButton("*"));
    panel.add(new JButton("1"));
    panel.add(new JButton("2"));
    panel.add(new JButton("3"));
    panel.add(new JButton("-"));
    panel.add(new JButton("0"));
    panel.add(new JButton("."));
    panel.add(new JButton("="));
    panel.add(new JButton("+"));
    frame.add(panel);

    frame.setBounds(300,200,200,150);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

#### 5. Grid Bag Layout

* It is the most flexible grid layout and most complicated layout to be use to creating a GUI interface.

```java
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SwingInterface  {
  public static void makeButton(String title,JFrame frame, GridBagLayout gridBagLayout, GridBagConstraints constraints) {
    JButton button = new JButton(title);
    gridBagLayout.setConstraints(button, constraints);
    frame.add(button);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Grid Bag Interface");
    GridBagLayout gbaglayout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    frame.setLayout(gbaglayout);
    // constraints.fill = grid fill in horizontal,vertical or both
    constraints.fill = GridBagConstraints.BOTH;
    constraints.weightx = 0.0;
    // GridBagConstraints.REMAINDER = stop this row,put before last grid
    constraints.gridwidth = GridBagConstraints.REMAINDER;

    JTextField tf = new JTextField("13612345678");
    gbaglayout.setConstraints(tf, constraints);
    frame.add(tf);
    constraints.weightx = 0.5;
    constraints.weighty = 0.2;
    constraints.gridwidth = 1;
    makeButton("7",frame,gbaglayout,constraints);
    makeButton("8",frame,gbaglayout,constraints);
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    makeButton("9",frame,gbaglayout,constraints);

    // declare gridwidth for new row grid(default = 1)
    constraints.gridwidth = 1;
    makeButton("4",frame,gbaglayout,constraints);
    makeButton("5",frame,gbaglayout,constraints);
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    makeButton("6",frame,gbaglayout,constraints);
    constraints.gridwidth = 1;
    makeButton("1",frame,gbaglayout,constraints);
    makeButton("2",frame,gbaglayout,constraints);
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    makeButton("3",frame,gbaglayout,constraints);
    constraints.gridwidth = 1;
    makeButton("Back",frame,gbaglayout,constraints);
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    makeButton("Call",frame,gbaglayout,constraints);
    constraints.gridwidth = 1;

    frame.setBounds(400,400,400,400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

#### 6. Box Layout

* set horizontal or vertical value to put the button

```java
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Box layout GUI");
    Box b1 = Box.createHorizontalBox();
    Box b2 = Box.createVerticalBox();
    frame.add(b1);

    b1.add(Box.createVerticalStrut(200));
    b1.add(new JButton("West"));
    b1.add(Box.createHorizontalStrut(140));
    b1.add(new JButton("East"));
    b1.add(Box.createHorizontalGlue());
    b1.add(b2);
    b2.add(Box.createRigidArea(new Dimension(100,20)));
    b2.add(new JButton("North"));
    b2.add(Box.createVerticalGlue());
    b2.add(new JButton("South"));
    b2.add(Box.createVerticalStrut(40));

    frame.setBounds(100,100,400,200);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

### JLabel

```java
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Label GUI");
    JPanel jp = new JPanel();
    JLabel label1 = new JLabel("Basic label");
    JLabel label2 = new JLabel();
    label2.setText("setText()method");
    ImageIcon img = new ImageIcon("C:\\Temp\\newfile\\testicon.png");

    JLabel label3 = new JLabel("Start",img,JLabel.CENTER);
    jp.add(label1);
    jp.add(label2);
    jp.add(label3);
    frame.add(jp);

    frame.setBounds(300,200,400,100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

### JButton

```java
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Button GUI");
    frame.setSize(400,200);

    JPanel jp = new JPanel();
    JButton btn1 = new JButton("Normal Btn");
    JButton btn2 = new JButton("color btn");
    JButton btn3 = new JButton("disabled btn");
    JButton btn4 = new JButton("algin btm btn");

    jp.add(btn1);
    // set button background color
    btn2.setBackground(Color.YELLOW);
    jp.add(btn2);
    // disable click
    btn3.setEnabled(false);
    jp.add(btn3);

    // button size
    Dimension preferredSize = new Dimension(160,60);
    // set to btn4
    btn4.setPreferredSize(preferredSize);
    // button alignment to bottom
    btn4.setVerticalAlignment(SwingConstants.BOTTOM);
    jp.add(btn4);

    frame.add(jp);
    frame.setBounds(300,200,600,300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

### JTextField (Input box)

```java
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Textfield GUI");
    JPanel jp = new JPanel();

    JTextField txtfield1 = new JTextField();
    txtfield1.setText("Normal text field");
    JTextField txtfield2 = new JTextField(28);
    // set font style and size
    txtfield2.setFont(new Font("楷体",Font.BOLD,16));
    txtfield2.setText("Sized and font text field");
    JTextField txtfield3 = new JTextField(30);
    txtfield3.setText("align center text");
    // text align center
    txtfield3.setHorizontalAlignment(JTextField.CENTER);

    jp.add(txtfield1);
    jp.add(txtfield2);
    jp.add(txtfield3);
    frame.add(jp);
    frame.setBounds(300,200,400,100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

### JTextArea (Textarea)

```java
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Textarea GUI");
    JPanel jp = new JPanel();

    // JTextArea(String text,int row,int col);
    JTextArea jta = new JTextArea("Please input string",7,30);
    // textarea auto newline
    jta.setLineWrap(true);
    jta.setForeground(Color.BLACK);
    jta.setFont(new Font("楷体",Font.BOLD,16));
    jta.setBackground(Color.YELLOW);

    // put textarea into scroll pane
    JScrollPane jsp = new JScrollPane(jta);
    Dimension size = jta.getPreferredSize();
    jsp.setBounds(110,90,size.width,size.height);
    jp.add(jsp);
    frame.add(jp);
    frame.setBackground(Color.LIGHT_GRAY);
    frame.setSize(400,200);
    frame.setVisible(true);
  }
}
```

### JCheckBox (check box)

```java
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Checkbox GUI");
    JPanel jp = new JPanel();
    JLabel label = new JLabel("Popular languages are: ");
    label.setFont(new Font("楷体",Font.BOLD,16));

    // JCheckBox("string",boolean true/false(selected));
    JCheckBox chkbox1 = new JCheckBox("C#",true);
    JCheckBox chkbox2 = new JCheckBox("C++");
    JCheckBox chkbox3 = new JCheckBox("Java");
    JCheckBox chkbox4 = new JCheckBox("Python");
    JCheckBox chkbox5 = new JCheckBox("PHP");
    JCheckBox chkbox6 = new JCheckBox("Perl");

    jp.add(label);
    jp.add(chkbox1);
    jp.add(chkbox2);
    jp.add(chkbox3);
    jp.add(chkbox4);
    jp.add(chkbox5);
    jp.add(chkbox6);

    frame.add(jp);
    frame.setBounds(300,200,400,100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

### JRadioButton (Radio box)

```java
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Checkbox GUI");
    JPanel jp = new JPanel();
    JLabel label1 = new JLabel("Seasons for now: ");
    JRadioButton rb1 = new JRadioButton("Spring");
    JRadioButton rb2 = new JRadioButton("Summer");
    JRadioButton rb3 = new JRadioButton("Fall");
    JRadioButton rb4 = new JRadioButton("Winter");
    label1.setFont(new Font("楷体",Font.BOLD,16));

    // add radiobutton into button group,use for design like choose male or female
    ButtonGroup group = new ButtonGroup();
    group.add(rb1);
    group.add(rb2);
    group.add(rb3);
    group.add(rb4);
    jp.add(label1);
    jp.add(rb1);
    jp.add(rb2);
    jp.add(rb3);
    jp.add(rb4);

    frame.add(jp);
    frame.setBounds(300,200,400,100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

### JComboBox (Select box)

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class SwingInterface {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Combobox GUI");
    JPanel jp = new JPanel();
    JLabel label1 = new JLabel("Document type: ");

    JComboBox cmb = new JComboBox();
    //create select box
    // <select>
    cmb.addItem("--Please select--");
    cmb.addItem("Identity Card");
    // <option>Identity card</option>
    cmb.addItem("License");
    // <option>License</option>
    cmb.addItem("Passport");
    // <option>Passport</option>

    jp.add(label1);
    jp.add(cmb);
    frame.add(jp);
    frame.setBounds(300,200,400,100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

### JList (ListBox)

* Simple Jlist

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;

public class SwingInterface  {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Listbox GUI");
    JPanel jp = new JPanel();
    JLabel label1 = new JLabel("Document type: ");
    String[] items = new String[] {"Identity Card", "License", "Passport"};
    JList list = new JList(items);

    jp.add(label1);
    jp.add(list);
    frame.add(jp);
    frame.setBounds(300,200,400,100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
```

* Array JList

```java
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

// inherit SwingInterface from JFrame
public class SwingInterface extends JFrame  {
  // declare SwingInterface() function
  public SwingInterface() {
    setTitle("Java Element List");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,300,200);

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5,5,5,5));
    contentPane.setLayout(new BorderLayout(0,0));
    setContentPane(contentPane);
    JScrollPane scrollPane = new JScrollPane();
    contentPane.add(scrollPane,BorderLayout.CENTER);

    JList list = new JList();
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scrollPane.setViewportView(list);

    // create listData array
    String[] listData = new String[12];
    for(int i = 0;i <listData.length; i++) {
      //output listData
      listData[i] = "This is the " + (i+1) + "th elements";
    }
    // append listData value to list
    list.setListData(listData);
  }

  public static void main(String[] args) {
    // declare frame as SwingInterface() object
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
  }
}
```

### Calculator Design

```java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// inherit SwingInterface from JFrame
public class SwingInterface extends JFrame  {
  private JPanel contentPane;
  private JTextField textField;

  // declare SwingInterface() function
  public SwingInterface() {
    setTitle("Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,250,200);

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5,5,5,5));
    contentPane.setLayout(new BorderLayout(0,0));
    setContentPane(contentPane);

    JPanel panel1 = new JPanel();
    contentPane.add(panel1,BorderLayout.NORTH);
    textField = new JTextField();
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    panel1.add(textField);
    textField.setColumns(18);

    JPanel panel2 = new JPanel();
    contentPane.add(panel2,BorderLayout.CENTER);
    panel2.setLayout(new GridLayout(4,4,5,5));

    JButton button01 = new JButton("7");
    panel2.add(button01);
    JButton button02 = new JButton("8");
    panel2.add(button02);
    JButton button03 = new JButton("9");
    panel2.add(button03);
    JButton button04 = new JButton("+");
    panel2.add(button04);
    JButton button05 = new JButton("4");
    panel2.add(button05);
    JButton button06 = new JButton("5");
    panel2.add(button06);
    JButton button07 = new JButton("6");
    panel2.add(button07);
    JButton button08 = new JButton("-");
    panel2.add(button08);
    JButton button09 = new JButton("1");
    panel2.add(button09);
    JButton button10 = new JButton("2");
    panel2.add(button10);
    JButton button11 = new JButton("3");
    panel2.add(button11);
    JButton button12 = new JButton("*");
    panel2.add(button12);
    JButton button13 = new JButton("0");
    panel2.add(button13);
    JButton button14 = new JButton(".");
    panel2.add(button14);
    JButton button15 = new JButton("=");
    panel2.add(button15);
    JButton button16 = new JButton("/");
    panel2.add(button16);
  }

  public static void main(String[] args) {
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
  }
}
```

### Swing EventListener

#### 1. __Action Listener__  

* __use for button click count or action trigger__

```java
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

// inherit SwingInterface from JFrame
public class SwingInterface extends JFrame  {
  JList list;
  JLabel label;
  JButton button1;
  int clicks = 0;

  //declare SwingInterface() function
  public SwingInterface() {
    setTitle("Action Event Listener");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,400,200);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5,5,5,5));
    contentPane.setLayout(new BorderLayout(0,0));

    setContentPane(contentPane);
    label = new JLabel(" ");
    label.setFont(new Font("楷体",Font.BOLD,16));
    contentPane.add(label,BorderLayout.SOUTH);
    button1 = new JButton("I am normal button");
    button1.setFont(new Font("楷体",Font.BOLD,16));

    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        label.setText("Button pressed" + (clicks++) + " times.");
      }
    });

    contentPane.add(button1);
  }

  // comes from button1.addActionListener, can be same as upper function
  class button1ActionListener implements ActionListener {
  @Override
    public void actionPerformed(ActionEvent e) {
      label.setText("Button pressed " + (clicks++) + " times.");
    }
  }

  public static void main(String[] args) {
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
  }
}
```

#### 2. __Event Listener(Focus)__

* __2 types of FocusEvents, focusGained() and focusLost()__

```java
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

// inherit SwingInterface from JFrame
public class SwingInterface extends JFrame  {
  JList list;
  JLabel label;
  JButton button1;
  JTextField txtfield1;

  //declare SwingInterface() function
  public SwingInterface() {
    setTitle("Action Event Listener");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,400,200);

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5,5,5,5));
    contentPane.setLayout(new BorderLayout(0,0));
    setContentPane(contentPane);

    label = new JLabel(" ");
    label.setFont(new Font("楷体",Font.BOLD,16));
    contentPane.add(label,BorderLayout.SOUTH);

    txtfield1 = new JTextField();
    txtfield1.setFont(new Font("楷体",Font.BOLD,16));
    txtfield1.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent arg0) {
        // gained focus when click on the application
        label.setText("textfield gained focus, please input.");
      }
      @Override
      public void focusLost(FocusEvent arg0) {
        // lost focus when click outside of the application
        label.setText("textfield lost focus, input completed.");
      }
    });

    contentPane.add(txtfield1);
  }

  public static void main(String[] args) {
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
  }
}
```

#### 3. __ListSelectionListener__

```java
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// inherit SwingInterface from JFrame
public class SwingInterface extends JFrame  {
  JList list;
  JLabel label;

  //declare SwingInterface() function
  public SwingInterface() {
    setTitle("Action Event Listener");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,400,200);

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5,5,5,5));
    contentPane.setLayout(new BorderLayout(0,0));
    setContentPane(contentPane);

    label = new JLabel(" ");
    contentPane.add(label,BorderLayout.SOUTH);

    JScrollPane scrollPane = new JScrollPane();
    contentPane.add(scrollPane,BorderLayout.CENTER);

    list = new JList();
    scrollPane.setViewportView(list);
    String[] listData = new String[7];
    listData[0] = "Java";
    listData[1] = "PHP";
    listData[2] = "Visual Basic";
    listData[3] = "Visual C++";
    listData[4] = "Java OOP";
    listData[5] = "PHP Guide";
    listData[6] = "C++ Tutorial";

    list.setListData(listData);
    list.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        do_list_valueChanged(e);
      }
    });
  }

  protected void do_list_valueChanged(ListSelectionEvent e) {
    //get selectedvalue we choose at gui
    label.setText("Thanks for buying: " + list.getSelectedValue());
  }

  public static void main(String[] args) {
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
  }
}
```

#### 4. __Combination of ActionListener and EventListener__

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class SwingInterface {
  private JPanel panel = new JPanel();
  private JComboBox cmb = new JComboBox();
  private JLabel label = new JLabel("Add star: ");
  private JLabel showInfo = new JLabel();
  private JTextField jtf = new JTextField(16);
  private JButton buttonAdd = new JButton("Add");

  //declare SwingInterface() function
  public SwingInterface() {
    JFrame frame = new JFrame("Select your star");
    cmb.addItem("--Please Select--");
    cmb.addItem("Choice2");
    cmb.addItem("Choice3");
    panel.add(cmb);
    panel.add(label);
    panel.add(jtf);
    panel.add(buttonAdd);
    panel.add(buttonDel);
    frame.add(panel);

    //add function to buttonAdd
    buttonAdd.addActionListener(new MyActionListener());
    //add function to buttonDel
    buttonDel.addActionListener(new MyActionListener());
    cmb.addItemListener(new MyItemListener());

    frame.setBounds(300,200,600,200);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  class MyItemListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
      //use to show text on gui
      String str = e.getItem().toString();
      panel.add(showInfo);
      //show info of choices
      showInfo.setText("Your choice is: " + str);
    }
  }

  //MyactionListener implement ActionListener function
  class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      //get action command
      String command = e.getActionCommand();
      if(command.equals("Add")) {
        //if press add button and length is not 0,
        if(jtf.getText().length()!=0) {
          //add item from Jtextfield
          cmb.addItem(jtf.getText());
          //show info 
          panel.add(showInfo);
          //output string to gui
          showInfo.setText("Successful added: " + jtf.getText());
        } else {
          panel.add(showInfo);
          showInfo.setText("Please insert items to add");
        }
      }
      //if delete button is pressed
      if(command.equals("Del")) {
        if(cmb.getSelectedIndex()!=-1) {
          //get textfield string
          String strdel = cmb.getSelectedItem().toString();
          //remove combobox item
          cmb.removeItem(strdel);
          //show info
          panel.add(showInfo);
          // output string to gui
          showInfo.setText("Deleted successful, deleted: " + strdel);
        } else {
          panel.add(showInfo);
          showInfo.setText("Please choose the delete item");
        }
      }
    }
  }

  public static void main(String[] args) {
    new SwingInterface();
  }
}
```

### JSlider

```java
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class SwingInterface {
  public static void main(String[] args) {
    JFrame frame = new JFrame("JSlider");
    frame.setSize(100,100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();
    JSlider slider = new JSlider(0,100);
    //big tick spacing
    slider.setMajorTickSpacing(10);
    //small tick spacing
    slider.setMinorTickSpacing(5);
    //show labels ticks,if false no number
    slider.setPaintLabels(true);
    //show paint ticks,if false no ticks
    slider.setPaintTicks(true);
    //add slider to contentPane
    contentPane.add(slider);
    frame.setVisible(true);
  }
}
```

### JProgressbar

```java
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class SwingInterface extends JFrame {
  private class Progress extends Thread {
    JProgressBar progressBar;
    JButton button;
    int[] progressValues = {6,18,27,39,51,66,81,100};

    Progress(JProgressBar progressBar, JButton button) {
      this.progressBar = progressBar;
      this.button = button;
    }

  public void run() {
    for(int i=0;i<progressValues.length;i++) {
      try {
        //set thread update time 3000millisecond
        Thread.sleep(3000);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }

    progressBar.setValue(progressValues[i]);
  }

  //progressBar.setIndeterminate(false);
  //set unconfirmed status bar effects, box will move between progressbar
  progressBar.setString("Update Completed");
  button.setEnabled(true);
  }
  }

  public SwingInterface() {
    setTitle("Progress Bar");
    JLabel label = new JLabel("Online Update system");
    JProgressBar progressBar = new JProgressBar();

    JButton button = new JButton("Completed");
    button.setEnabled(false);

    Container container = getContentPane();
    container.setLayout(new GridLayout(3,1));
    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    panel1.add(label);
    panel2.add(progressBar);
    panel3.add(button);
    container.add(panel1);
    container.add(panel2);
    container.add(panel3);
    progressBar.setStringPainted(true);
    //progressBar.setString("Updating....");
    //if comment this line, progressbar will shows up array value when update
    //progressBar.setIndeterminate(true);
    //statusbox will move between progressbar during update

    //execute Progress(param1,param2) function
    new Progress(progressBar,button).start();
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // exit after press button
        dispose();
        System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
  }
}
```

### Progressbar(Timer type)

```java
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingInterface implements ActionListener,ChangeListener {
  JFrame frame = null;
  JProgressBar progressbar;
  JLabel label;
  Timer timer;
  JButton b;

  public SwingInterface() {
        frame = new JFrame("Software install");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        label = new JLabel(" ",JLabel.CENTER);

        progressbar = new JProgressBar();
        progressbar.setOrientation(JProgressBar.HORIZONTAL);
        progressbar.setMinimum(0);
        progressbar.setMaximum(100);
        progressbar.setValue(0);
        progressbar.setStringPainted(true);
        progressbar.addChangeListener(this);
        progressbar.setBackground(Color.pink);

        JPanel panel = new JPanel();
        b = new JButton("Install");
        b.setForeground(Color.blue);
        b.addActionListener(this);
        panel.add(b);
        timer = new Timer(100,this);

        contentPane.add(panel,BorderLayout.NORTH);
        contentPane.add(progressbar,BorderLayout.CENTER);
        contentPane.add(label,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    //if button pressed
    if(e.getSource() == b)
      // count start
      timer.start();
      //if timer = result
      if(e.getSource() == timer) {
        int value = progressbar.getValue();
        if(value<100) {
          //set value into progressbar
          progressbar.setValue(++value);
        } else {
          //if value == 100,stop timer
          timer.stop();
          //close frame
          frame.dispose();
        }
    }
  }

  public void stateChanged(ChangeEvent e1) {
    int value = progressbar.getValue();
    if(e1.getSource() == progressbar) {
            //output label to frame
            label.setText("Installing: " + Integer.toString(value) + "%");
            label.setForeground(Color.blue);
        }
  }

  public static void main(String[] args) {
    new SwingInterface();
  }
}
```

### Menubar

```java
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class SwingInterface extends JMenuBar {
  public SwingInterface() {
    add(createFileMenu());
    add(createEditMenu());
    setVisible(true);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Menu bar");
    frame.setSize(300,200);
    frame.setJMenuBar(new SwingInterface());
    frame.setVisible(true);
  }

  private JMenu createFileMenu() {
    JMenu menu = new JMenu("File(F)");
    menu.setMnemonic(KeyEvent.VK_F);
    JMenuItem item = new JMenuItem("New(N)",KeyEvent.VK_N);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
    menu.add(item);
    item = new JMenuItem("Open(O)",KeyEvent.VK_O);

    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
    menu.add(item);
    item = new JMenuItem("Save(S)",KeyEvent.VK_S);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
    menu.add(item);
    menu.addSeparator();
    item = new JMenuItem("Exit(E)",KeyEvent.VK_E);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
    menu.add(item);
    return menu;
  }
  
  private JMenu createEditMenu() {
    JMenu menu = new JMenu("Edit(E)");
    menu.setMnemonic(KeyEvent.VK_E);
    JMenuItem item = new JMenuItem("Undo(U)",KeyEvent.VK_U);
    item.setEnabled(false);
    menu.add(item);
    menu.addSeparator();
    item = new JMenuItem("Cut(T)",KeyEvent.VK_T);
    menu.add(item);
    item = new JMenuItem("Copy(C)",KeyEvent.VK_C);
    menu.add(item);
    menu.addSeparator();
    JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("NewLine");
    menu.add(cbMenuItem);
    return menu;
  }
}
```

### Right click Menu popup bar

```java
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class SwingInterface extends JFrame {
  JMenu fileMenu;
  JPopupMenu jPopupMenuOne;
  JMenuItem openFile,closeFile,exit;
  JRadioButtonMenuItem copyFile,pasteFile;
  ButtonGroup buttonGroupOne;
  
  class PopupListener extends MouseAdapter {
    JPopupMenu popupMenu;
    PopupListener(JPopupMenu popupMenu) {
      this.popupMenu = popupMenu;
    }
    
    public void mousePressed(MouseEvent e) {
      showPopupMenu(e);
    }
    
    public void mouseReleased(MouseEvent e) {
      showPopupMenu(e);
    }
    
    private void showPopupMenu(MouseEvent e) {
      if(e.isPopupTrigger()) {
        popupMenu.show(e.getComponent(),e.getX(),e.getY());
      }
    }
  }
  
  public SwingInterface() {
    jPopupMenuOne = new JPopupMenu();
    buttonGroupOne = new ButtonGroup();
    fileMenu = new JMenu("File");
    openFile = new JMenuItem("Open");
    closeFile = new JMenuItem("Close");
    fileMenu.add(openFile);
    fileMenu.add(closeFile);
    
    jPopupMenuOne.add(fileMenu);
    jPopupMenuOne.addSeparator();
    
    copyFile = new JRadioButtonMenuItem("Copy");
    pasteFile = new JRadioButtonMenuItem("Paste");
    buttonGroupOne.add(copyFile);
    buttonGroupOne.add(pasteFile);
    
    jPopupMenuOne.add(copyFile);
    jPopupMenuOne.add(pasteFile);
    jPopupMenuOne.addSeparator();
    
    exit = new JMenuItem("Exit");
    jPopupMenuOne.add(exit);
    
    MouseListener popupListener = new PopupListener(jPopupMenuOne);
    this.addMouseListener(popupListener);
    this.setTitle("PopupMenu");
    this.setBounds(100,100,250,150);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    new SwingInterface();
  }
}
```

### JToolBar

```java
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class SwingInterface extends JPanel implements ActionListener {
  protected JTextArea textArea;
  protected String newline = "\n";
  static final private String OPEN = "OPEN";
  static final private String SAVE = "SAVE";
  static final private String NEW = "NEW";
  
  protected void displayResult(String actionDescription) {
    textArea.append(actionDescription + newline);
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Toolbar");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SwingInterface newContentPane = new SwingInterface();
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);
    frame.pack();
    frame.setVisible(true);
  }
    
  @Override
  public void actionPerformed(ActionEvent e) {
        
    }
    
    public SwingInterface() {
      super(new BorderLayout());
      JToolBar toolBar = new JToolBar();
      addButtons(toolBar);
      textArea = new JTextArea(15,30);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      setPreferredSize(new Dimension(450,110));
      add(toolBar,BorderLayout.PAGE_START);
      add(scrollPane,BorderLayout.CENTER);
    }
    
    protected void addButtons(JToolBar toolBar) {
      JButton button = null;
      button = makeNavigationButton("new1",NEW,"Create New Folder","Create");
      toolBar.add(button);
      button = makeNavigationButton("open1",OPEN,"Open a File","Open");
      toolBar.add(button);
      button = makeNavigationButton("save1",SAVE,"Save existing file","Save");
      toolBar.add(button);
    }
    
    protected JButton makeNavigationButton(String imageName,String actionCommand,String toolTipText,String altText) {
      String imgLocation = imageName + ".jpg";
      URL imageURL = SwingInterface.class.getResource(imgLocation);
      JButton button = new JButton();
      button.setActionCommand(actionCommand);
      button.setToolTipText(toolTipText);
      button.addActionListener(this);
      if(imageURL != null) {
        button.setIcon(new ImageIcon(imageURL));
      } else {
        button.setText(altText);
        System.err.println("Resource not found: " + imgLocation);
      }
      
      return button;
    }
}
```

### JFileChooser

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingInterface {
  private JLabel label = new JLabel("Open file Location: ");
  private JTextField jtf = new JTextField(25);
  private JButton button = new JButton("Browse");
  
  public static void main(String[] args) {
    new SwingInterface();
  }
  
  public SwingInterface() {
    JFrame frame = new JFrame("FileChooser");
    JPanel panel = new JPanel();
    panel.add(label);
    panel.add(jtf);
    panel.add(button);
    frame.add(panel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    button.addActionListener(new MyActionListener());
  }
  
  class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent arg0) {
      JFileChooser fc = new JFileChooser("D:\\");
      int val = fc.showOpenDialog(null);
      
      if(val == fc.APPROVE_OPTION) {
        jtf.setText(fc.getSelectedFile().toString());
      } else {
        jtf.setText("No choice");
      }
    }
  }
}
```

### JColorChooser

```java
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class SwingInterface {
  public static void main(String[] args) {
    JFrame frame = new JFrame("ColorChooser");
    JColorChooser cc = new JColorChooser();
    cc.showDialog(frame, "Color Chooser", Color.white);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setBounds(100,100,400,200);
  }
}
```

### JOPtionPane(Popup GUI)

```java
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class SwingInterface {
  public static void main(String[] args) {
    //still got error in p variable
    JOptionPane.showConfirmDialog(p,"Delete?","Delete alert",0);
  }
}
```

### JTable

#### Static Table

```java
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SwingInterface {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Student result table");
    frame.setSize(500,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    
    Object[][] tableDate = new Object[5][8];
    for(int i=0; i<5; i++) {
      tableDate[i][0] = "1000" + i;
      for(int j =1; j<8; j++) {
        tableDate[i][j] = 0;
      }
    }
    
    String[] name = {"StuID", "SoftEng", "Java", "Networking", "DataStructure", "Database", "TotalScore", "AvgScore"};
    JTable table = new JTable(tableDate,name);
    contentPane.add(new JScrollPane(table));
    frame.setVisible(true);
  }
}
```

#### Dynamic Table

```java
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SwingInterface extends JFrame {
  private JPanel contentPane;
  private JTable table;
  
  //Launch the application
  public static void main(String[] args) {
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
  }
  
  //Create frame
  public SwingInterface() {
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowActivated(WindowEvent e) {
        do_this_windowActivated(e);
      }
    });
    
    setTitle("Books DataList");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,450,200);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5,5,5,5));
    contentPane.setLayout(new BorderLayout(0,0));
    setContentPane(contentPane);
    JPanel panel = new JPanel();
    contentPane.add(panel,BorderLayout.SOUTH);
    JButton button = new JButton("Delete");
    button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //delete action performed
                do_button_actionPerformed(e);
            }
    });
    
    panel.add(button);
    JScrollPane scrollPane = new JScrollPane();
    contentPane.add(scrollPane,BorderLayout.CENTER);
    table = new JTable();
    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    scrollPane.setViewportView(table);
  }
  
  protected void do_this_windowActivated(WindowEvent e) {
    //get table model
    DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
    //clear table data
    tableModel.setRowCount(0);
    //setup table title
    tableModel.setColumnIdentifiers(new Object[] {"BooksName","Publisher","PublishedDate","Type","Price"});
    tableModel.addRow(new Object[] {"Java Beginner(Revision2)","QingHua University","2010-07-01","Software Engineering","$59.8"});
    tableModel.addRow(new Object[] {"PHP Beginner(Revision2)","QingHua University","2010-07-01","Software Engineering","$69.8"});
    tableModel.addRow(new Object[] {"Visual Basic for Beginner","QingHua University","2010-07-01","Software Engineering","$69.8"});
    tableModel.addRow(new Object[] {"Visual C++ Beginner(Revision2)","QingHua University","2010-07-01","Software Engineering","$69.8"});
    table.setRowHeight(30);
    table.setModel(tableModel);
  }
  
  protected void do_button_actionPerformed(ActionEvent e) {
    //get table model
    DefaultTableModel model = (DefaultTableModel)table.getModel();
    int[] selectedRows = table.getSelectedRows();
    //delete from first line
    for(int i = selectedRows[0];i<selectedRows.length;i++) {
      model.removeRow(selectedRows[0]);
    }
    table.setModel(model);
  }
}
```

### JTree(TreeList)

#### Similar as html list design

```html
<ul>
  <li></li>
  <li></li>
</ul>
```

```java
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class SwingInterface extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Education Level");
    frame.setSize(330,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new SwingInterface().createComponent());
    frame.pack();
    frame.setVisible(true);
  }
  
  private JPanel createComponent() {
    JPanel panel = new JPanel();
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Education Level");
    String Teachers[][] = new String[3][];
    //Degree level(child node)
    Teachers[0] = new String[] {"Name1","Name2","Name3","Name4","Name5","Name6"};
    //Master level(child node)
    Teachers[1] = new String[] {"Name7","Name8","Name9","Name10","Name11","Name12","Name13"};
    //Doctoral level(child node)
    Teachers[2] = new String[] {"Name14","Name15","Name16","Name17","Name18"};
    //parent node
    String gradeNames[] = {"Degree","Master","Doctoral"};
    
    DefaultMutableTreeNode node = null;
    DefaultMutableTreeNode childNode = null;
    int length = 0;
    for(int i =0;i<3;i++) {
    length = Teachers[i].length;
    //add parent node
    node = new DefaultMutableTreeNode(gradeNames[i]);
    for(int j=0;j<length;j++) {
      childNode = new DefaultMutableTreeNode(Teachers[i][j]);
      //add child node to parent node
      node.add(childNode);
    }
    root.add(node);
  }
    
    JTree tree = new JTree(root);
    panel.add(tree);
    panel.setVisible(true);
    return panel;
  }
}
```

### JTabbedPane (Tab like GUI page)

```java
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JPanel;

public class SwingInterface extends JPanel {
  protected JComponent makeTextPanel(String text) {
    // create tab
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel(text);
    filler.setHorizontalAlignment(JLabel.CENTER);
    panel.setLayout(new GridLayout(1,1));
    panel.add(filler);
    return panel;
  }
  
  protected static ImageIcon createImageIcon(String path) {
    //create image icon with path
    java.net.URL imgURL = SwingInterface.class.getResource(path);
    if(imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("My PC - Properties");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new SwingInterface(), BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
  
  public SwingInterface() {
    super(new GridLayout(1,1));
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon icon = createImageIcon("tab.jpg");
    // tab 1
    JComponent panel1 = makeTextPanel("Computer Name");
    tabbedPane.addTab("Computer Name", icon, panel1, "Does nothing");
    // press alt +1
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    // tab 2
    JComponent panel2 = makeTextPanel("Hardware");
    tabbedPane.addTab("Hardware", icon, panel2, "Does twice as much nothing");
    // press alt + 2
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    // tab 3
    JComponent panel3 = makeTextPanel("System");
    tabbedPane.addTab("System", icon, panel3, "Still does nothing");
    // press alt + 3
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    // tab 4
    JComponent panel4 = makeTextPanel("Maintenance");
    panel4.setPreferredSize(new Dimension(410,50));
    tabbedPane.addTab("Maintenance", icon, panel4, "Does nothing at all");
    // press alt + 4
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
    // add tabPane
    add(tabbedPane);
  }
}
```

### text file opener(open text file and output text details)

```java
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SwingInterface extends JFrame {
    private static final long serialVersionUID = -9077023825514749548L;
    private JTextArea ta_showText;
    private JTextArea ta_showProperty;
    
    public void openTextFile() {
      JFileChooser fileChooser = new JFileChooser();
      // declare document type
      fileChooser.setFileFilter(new FileNameExtensionFilter("File Document","txt"));
      // return text file values
      int returnValue = fileChooser.showOpenDialog(getContentPane());
      // if returnValue true
      if(returnValue == JFileChooser.APPROVE_OPTION) {
        //get file path and details
        File file = fileChooser.getSelectedFile();
        // append file path
        ta_showProperty.append("Absolute path is: " + file.getAbsolutePath() + "\n");
        // append file hidden property
        ta_showProperty.append("Hidden File?" + file.isHidden() + "\n");
        FileReader reader;
        BufferedReader in;
        try {
          reader = new FileReader(file);
          in = new BufferedReader(reader);
          String info = in.readLine();
          while(info != null) {
            // append text 
            ta_showText.append(info + "\n");
            // read file line
            info = in.readLine();
          }
          // close buffer reader
          in.close();
          // close file
          reader.close();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }
  }
  
  public static void main(String[] args) {
    SwingInterface frame = new SwingInterface();
    frame.setVisible(true);
  }
  
  public SwingInterface() {
    setTitle("Notepad Editor");
    setBounds(100,100,400,250);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // create menu bar
    final JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    // create menu bar - File
    final JMenu mn_file = new JMenu();
    mn_file.setText("File");
    menuBar.add(mn_file);
    final JMenuItem mi_open = new JMenuItem();
    mi_open.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        // if menu bar File clicked, action performed(open file)
        openTextFile();
      }
    });
    mi_open.setText("Open");
    mn_file.add(mi_open);
    mn_file.addSeparator();
    // create menu bar - Exit
    final JMenuItem mi_exit = new JMenuItem();
    mi_exit.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        // if menu bar exit clicked, action performed(exit software)
        System.exit(0);
      }
    });
    mi_exit.setText("Exit");
    mn_file.add(mi_exit);
    // create menu bar - Edit
    final JMenu mn_edit = new JMenu();
    mn_edit.setText("Edit");
    menuBar.add(mn_edit);
    // create menu bar - Copy
    final JMenuItem mi_copy = new JMenuItem();
    mi_copy.setText("Copy");
    mn_edit.add(mi_copy);
    // create menu bar - cut
    final JMenuItem mi_cut = new JMenuItem();
    mn_edit.add(mi_cut);
    // create menu bar - paste
    final JMenuItem mi_paste = new JMenuItem();
    mi_paste.setText("Paste");
    mn_edit.add(mi_paste);
    // create tool bar 
    final JToolBar toolBar = new JToolBar();
    getContentPane().add(toolBar, BorderLayout.NORTH);
    // create tool bar button - Open
    final JButton btn_open = new JButton();
    btn_open.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        // if toolbar button - Open clicked, action performed(open file)
        openTextFile();
      }
    });
    btn_open.setText("Open File");
    toolBar.add(btn_open);
    // create tool bar button - Exit
    final JButton btn_exit = new JButton();
    btn_exit.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        // if toolbar button - Exit clicked, action performed(exit software)
        System.exit(0);
      }
    });
    btn_exit.setText("Exit...");
    toolBar.add(btn_exit);
    //create tab pane
    final JTabbedPane tabbedPane = new JTabbedPane();
    getContentPane().add(tabbedPane, BorderLayout.CENTER);
    // create scroll pane for text area
    final JScrollPane scrollPane1 = new JScrollPane();
    tabbedPane.addTab("File Properties", null, scrollPane1, null);
    ta_showProperty = new JTextArea();
    scrollPane1.setViewportView(ta_showProperty);
    
    final JScrollPane scrollPane2 = new JScrollPane();
    tabbedPane.addTab("File Details", null, scrollPane2, null);
    ta_showText = new JTextArea();
    scrollPane2.setViewportView(ta_showText);
  }
}
```
