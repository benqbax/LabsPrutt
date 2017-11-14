import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.net.*;
import java.io.*;
import java.util.*;

class RPSSkel extends JFrame implements ActionListener {
    private Gameboard myboard, computersboard;
    private SettingsBoard settings;
    int counter; // To count ONE ... TWO  and on THREE you play
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JButton closebutton;
    private JToggleButton soundToggle;
    private boolean soundToggleState;
    private AudioInputStream as;


    RPSSkel () {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		closebutton = new JButton("Close");
		closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //avsluta programmet
                out.println("\u0000"); out.flush();
                System.exit(0);
            }
        });

		soundToggle = new JToggleButton("Sound on");
        soundToggle.setSelected(true);
        soundToggleState = true;
		soundToggle.addItemListener(new ItemListener() {
            //https://stackoverflow.com/questions/28382432/java-swing-making-on-off-button
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                if(state == 1){
                    soundToggle.setText("Sound on");
                    soundToggleState = true;
                    System.out.println("enable sound");
                }
                else{
                    soundToggle.setText("Sound off");

                    soundToggleState = false;
                    System.out.println("disabled sound");
                }
                soundToggle.setSelected(soundToggleState);
            }
        });


		myboard = new Gameboard("Myself", this); // Must be changed
		computersboard = new Gameboard("Computer");
		JPanel boards = new JPanel();
		boards.setLayout(new GridLayout(1,2));
		boards.add(myboard);
		boards.add(computersboard);
		add(boards, BorderLayout.CENTER);
		add(soundToggle, BorderLayout.NORTH);
		add(closebutton, BorderLayout.SOUTH);

		setSize(300, 550);
		setVisible(true);
        setUpConnection();
    }
    private void setUpConnection(){
        try {
            socket=new Socket("localhost",4713);
            in=new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());
            out.println("Spelare 1");
            out.flush();
            System.out.println(in.readLine());

        } catch (UnknownHostException e) {
            System.out.println("Ingen anslutning");
        } catch (IOException e) {
            System.out.println("Ingen anslutning");
        }
    }

    public static void main (String[] u) {
        new RPSSkel();

    }

    /*
    void checkMove(String myMove, String compMove){
        String combined = myMove + compMove;

        switch(combined){
            case "STENSTEN":
                myboard.setLower("TIE");
                computersboard.setLower("TIE");
                break;
            case "STENSAX":
                myboard.wins();
                myboard.setLower("WON");
                computersboard.setLower("LOST");
                break;
            case "STENPASE":
                computersboard.wins();
                myboard.setLower("LOST");
                computersboard.setLower("WON");
                break;
            case "SAXSTEN":
                computersboard.wins();
                myboard.setLower("LOST");
                computersboard.setLower("WON");
                break;
            case "SAXSAX":
                myboard.setLower("TIE");
                computersboard.setLower("TIE");
                break;
            case "SAXPASE":
                myboard.wins();
                myboard.setLower("WON");
                computersboard.setLower("LOST");
                break;
            case "PASEPASE":
                myboard.setLower("TIE");
                computersboard.setLower("TIE");
                break;
            case "PASESTEN":
                myboard.wins();
                myboard.setLower("WON");
                computersboard.setLower("LOST");
                break;
            case "PASESAX":
                computersboard.wins();
                myboard.setLower("LOST");
                computersboard.setLower("WON");
                break;
        }



    } */

    private void checkMove(String playerChoice, String compChoice) {
        // Matrix of win/lose where 1 win, 0 tie and -1 lose
        Integer[][] winMatrix = {{0,-1,1},{1,0,-1},{-1,1,0}};
        int player = mapChoice(playerChoice);
        int computer = mapChoice(compChoice);
        URL file=null;
        switch (winMatrix[computer][player]) {
            case 1:
                myboard.wins();
                myboard.setLower("WINS");
                computersboard.setLower("LOST");
                file = RPSSkel.class.getResource("/recources/win.wav");
                break;
            case 0:
                myboard.setLower("TIE");
                computersboard.setLower("TIE");
                file = RPSSkel.class.getResource("/recources/tie.wav");
                break;
            case -1:
                computersboard.wins();
                myboard.setLower("LOST");
                computersboard.setLower("WINS");
                file = RPSSkel.class.getResource("/recources/lose.wav");
                break;
        }
        if(soundToggleState){
            playSound(file);
        }
    }

    private int mapChoice(String choice) {
        int numChoice = -1;

        switch(choice) {
            case "STEN":
                numChoice = 0;
                break;
            case "SAX":
                numChoice = 1;
                break;
            case "PASE":
                numChoice = 2;
                break;
        }

        if (numChoice == -1) {
            throw new java.lang.Error("Something went wrong");
        }

        return numChoice;
    }

    private void playSound(URL soundfile){
       //https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
        try {

            as = AudioSystem.getAudioInputStream(soundfile);
            Clip clip = AudioSystem.getClip();
            clip.open(as);
            clip.start();

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myboard.resetColor();
        computersboard.resetColor();
        String raknare="";
        counter++;

        switch(counter){
            case 1:
                raknare="ETT";
                myboard.setLower(raknare);
                break;
            case 2:
                raknare="TVÅ";
                myboard.setLower(raknare);
                break;
            case 3:
                JButton button = (JButton) e.getSource();
                myboard.markPlayed(button);
                String move = button.getActionCommand();
                //System.out.println("You made your move: " + move);
                counter = 0;
                out.println(move); out.flush();
                try {
                    String compMove = in.readLine();
                    computersboard.markPlayed(compMove);
                    checkMove(move, compMove);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
        }




    }
}





