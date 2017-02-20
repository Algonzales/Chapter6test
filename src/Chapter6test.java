
/*Alexander Gonzales
 *CSC 160
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Chapter6test extends JFrame {

	public Chapter6test() {

		setLayout(null);

		setTitle("Math Tutor");
		setSize(640, 480);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel appLabel = new JLabel("Welcome to Math Tutor");
		add(appLabel);
		appLabel.setBounds(10, 10, 200, 20); // setBounds(x, y, width, height)

		JMenuBar appMenuBar = new JMenuBar();
		setJMenuBar(appMenuBar);

		JMenu fileMenu = new JMenu("Math Tutor");// Adds File drop-down menu

		appMenuBar.add(fileMenu);

		JMenuItem addTutorMenuItem = new JMenuItem("Addition Tutor");// addition
																		// tutor
																		// button
		// for drop-down
		// menu
		JMenuItem subtractTutorMenuItem = new JMenuItem("Subtraction Tutor");// subtraction
																				// tutor
																				// button
																				// for
																				// drop-down
																				// menu
		JMenuItem multiplyTutorMenuItem = new JMenuItem("Multiplication Tutor");
		JMenuItem divideTutorMenuItem = new JMenuItem("Division Tutor");
		JMenuItem exitMenuItem = new JMenuItem("Exit");// exit button for
														// drop-down menu

		fileMenu.add(addTutorMenuItem);
		fileMenu.add(subtractTutorMenuItem);
		fileMenu.add(multiplyTutorMenuItem);
		fileMenu.add(divideTutorMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		addTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayTutor("Add");
			}

		});

		subtractTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long lStartTime = System.nanoTime();
				int correctAnswer = 0;
				int questionNumber = 1;
				JTextField userAnswerField = new JTextField(5);
				JPanel myPanel = new JPanel();
				while (correctAnswer < 4) {
					int num1 = (int) (Math.random() * 10 + 1);
					int num2 = (int) (Math.random() * 10 + 1);
					int answer = 0;
					myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
					myPanel.add(new JLabel("Question " + questionNumber));
					if (num1 > num2) {
						answer = num1 - num2;
						myPanel.add(new JLabel("Get 4 questions correct to exit"));
						myPanel.add(new JLabel("Questions correct so far " + correctAnswer));
						myPanel.add(new JLabel("What is " + num1 + " - " + num2 + "?"));
					} else if (num2 > num1) {
						answer = num2 - num1;
						myPanel.add(new JLabel("Get 4 questions correct to exit"));
						myPanel.add(new JLabel("Questions correct so far " + correctAnswer));
						myPanel.add(new JLabel("What is " + num2 + " - " + num1 + "?"));
					} else {
						answer = num1 - num2;
						myPanel.add(new JLabel("Get 4 questions correct to exit"));
						myPanel.add(new JLabel("Questions correct so far " + correctAnswer));
						myPanel.add(new JLabel("What is " + num1 + " - " + num2 + "?"));
					}
					myPanel.add(new JLabel("Enter your answer:"));
					myPanel.add(userAnswerField);
					int result = JOptionPane.showConfirmDialog(null, myPanel, "Subtraction tutor",
							JOptionPane.OK_CANCEL_OPTION);
					int userAnswer = Integer.parseInt(userAnswerField.getText());

					if (result == JOptionPane.CANCEL_OPTION) {
						correctAnswer = 5;

					} else if (result == JOptionPane.OK_OPTION) {
						if (userAnswer == answer) {
							JOptionPane.showMessageDialog(null, "Correct, the answer is  " + answer, // message
									"Answer for number " + questionNumber, // title
									JOptionPane.PLAIN_MESSAGE);
							correctAnswer += 1;
							questionNumber += 1;
							// remove all components in panel.
							myPanel.removeAll();
							// refresh the panel.
							myPanel.updateUI();

						} else if (userAnswer != answer) {
							JOptionPane.showMessageDialog(null, "Incorrect, the correct answer is  " + answer, // message
									"Answer for number " + questionNumber, // title
									JOptionPane.PLAIN_MESSAGE);
							questionNumber += 1;
							// remove all components in panel.
							myPanel.removeAll();
							// refresh the panel.
							myPanel.updateUI();

						} else {
							correctAnswer = 5;
						}

					}
				}
				long lEndTime = System.nanoTime();
				long output = (lEndTime - lStartTime) / 1000000000;
				JOptionPane.showMessageDialog(null, "Time taken " + output + " Seconds", // message
						"Time taken", // title
						JOptionPane.PLAIN_MESSAGE);
			}

		});
		multiplyTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int correctAnswer = 0;
				int questionNumber = 1;
				long lStartTime = System.nanoTime();
				JTextField userAnswerField = new JTextField(5);

				JPanel myPanel = new JPanel();
				while (correctAnswer < 4) {
					int num1 = (int) (Math.random() * 10 + 1);
					int num2 = (int) (Math.random() * 10 + 1);
					myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
					myPanel.add(new JLabel("Question " + questionNumber));
					myPanel.add(new JLabel("Get 4 questions correct to exit"));
					myPanel.add(new JLabel("Questions correct so far " + correctAnswer));
					myPanel.add(new JLabel("What is " + num1 + " * " + num2 + "?"));
					myPanel.add(new JLabel("Enter your answer:"));
					myPanel.add(userAnswerField);
					int result = JOptionPane.showConfirmDialog(null, myPanel, "Multiplication tutor",
							JOptionPane.OK_CANCEL_OPTION);
					int userAnswer = Integer.parseInt(userAnswerField.getText());
					int answer = num1 * num2;
					if (result == JOptionPane.CANCEL_OPTION) {
						correctAnswer = 5;

					} else if (result == JOptionPane.OK_OPTION) {
						if (userAnswer == answer) {
							JOptionPane.showMessageDialog(null, "Correct, the answer is  " + answer, // message
									"Answer for number " + questionNumber, // title
									JOptionPane.PLAIN_MESSAGE);
							correctAnswer += 1;
							questionNumber += 1;
							// remove all components in panel.
							myPanel.removeAll();
							// refresh the panel.
							myPanel.updateUI();

						} else if (userAnswer != answer) {
							JOptionPane.showMessageDialog(null, "Incorrect, the correct answer is  " + answer, // message
									"Answer for number " + questionNumber, // title
									JOptionPane.PLAIN_MESSAGE);
							questionNumber += 1;
							// remove all components in panel.
							myPanel.removeAll();
							// refresh the panel.
							myPanel.updateUI();

						} else {
							correctAnswer = 5;
						}

					}
				}
				long lEndTime = System.nanoTime();
				long output = (lEndTime - lStartTime) / 1000000000;
				JOptionPane.showMessageDialog(null, "Time taken " + output + " Seconds", // message
						"Time taken", // title
						JOptionPane.PLAIN_MESSAGE);
			}

		});
		divideTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long lStartTime = System.nanoTime();
				int correctAnswer = 0;
				int questionNumber = 1;
				JTextField userAnswerField = new JTextField(5);

				JPanel myPanel = new JPanel();
				while (correctAnswer < 4) {
					int num1 = (int) (Math.random() * 10) + 1;
					int num2 = (int) (Math.random() * 10) + 1;
					int num3 = num1 * num2;
					int answer = num3 / num1;
					myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
					myPanel.add(new JLabel("Get 4 questions correct to exit or press cancel"));
					myPanel.add(new JLabel("Questions correct so far " + correctAnswer));
					myPanel.add(new JLabel("What is " + num3 + " / " + num1 + "?"));
					myPanel.add(new JLabel("Enter your answer:"));
					myPanel.add(userAnswerField);
					int result = JOptionPane.showConfirmDialog(null, myPanel, "Division tutor",
							JOptionPane.OK_CANCEL_OPTION);
					int userAnswer = Integer.parseInt(userAnswerField.getText());
					if (result == JOptionPane.CANCEL_OPTION) {
						correctAnswer = 5;

					} else if (result == JOptionPane.OK_OPTION) {
						if (userAnswer == answer) {
							JOptionPane.showMessageDialog(null, "Correct, the answer is  " + answer, // message
									"Answer for number " + questionNumber, // title
									JOptionPane.PLAIN_MESSAGE);
							correctAnswer += 1;
							questionNumber += 1;
							// remove all components in panel.
							myPanel.removeAll();
							// refresh the panel.
							myPanel.updateUI();

						} else if (userAnswer != answer) {
							JOptionPane.showMessageDialog(null, "Incorrect, the correct answer is  " + answer, // message
									"Answer for number " + questionNumber, // title
									JOptionPane.PLAIN_MESSAGE);
							questionNumber += 1;
							// remove all components in panel.
							myPanel.removeAll();
							// refresh the panel.
							myPanel.updateUI();

						} else {
							correctAnswer = 5;
						}

					}
				}
				long lEndTime = System.nanoTime();
				long output = (lEndTime - lStartTime) / 1000000000;
				JOptionPane.showMessageDialog(null, "Time taken " + output + " Seconds", // message
						"Time taken", // title
						JOptionPane.PLAIN_MESSAGE);
			}

		});

		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	public static void displayTutor(String tutorType){
		long lStartTime = System.nanoTime();
		int correctAnswer = 0;
		int questionNumber = 1;
		JTextField userAnswerField = new JTextField(5);

		JPanel myPanel = new JPanel();
		while (correctAnswer < 4) {
			int num1 = (int) (Math.random() * 10 + 1);
			int num2 = (int) (Math.random() * 10 + 1);
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			myPanel.add(new JLabel("Question " + questionNumber));
			myPanel.add(new JLabel("Get 4 questions correct to exit"));
			myPanel.add(new JLabel("Questions correct so far " + correctAnswer));
			myPanel.add(new JLabel("What is " + num1 + " + " + num2 + "?"));
			myPanel.add(new JLabel("Enter your answer:"));
			myPanel.add(userAnswerField);
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Addition tutor",
					JOptionPane.OK_CANCEL_OPTION);
			int userAnswer = Integer.parseInt(userAnswerField.getText());
			int answer = num1 + num2;
			if (result == JOptionPane.CANCEL_OPTION) {
				correctAnswer = 5;

			} else if (result == JOptionPane.OK_OPTION) {
				if (userAnswer == answer) {
					JOptionPane.showMessageDialog(null, "Correct, the answer is  " + answer, // message
							"Answer for number " + questionNumber, // title
							JOptionPane.PLAIN_MESSAGE);
					correctAnswer += 1;
					questionNumber += 1;
					// remove all components in panel.
					myPanel.removeAll();
					// refresh the panel.
					myPanel.updateUI();

				} else if (userAnswer != answer) {
					JOptionPane.showMessageDialog(null, "Incorrect, the correct answer is  " + answer, // message
							"Answer for number " + questionNumber, // title
							JOptionPane.PLAIN_MESSAGE);
					questionNumber += 1;
					// remove all components in panel.
					myPanel.removeAll();
					// refresh the panel.
					myPanel.updateUI();
				} else {
					correctAnswer = 5;
				}

			}
		}
		long lEndTime = System.nanoTime();
		long output = (lEndTime - lStartTime) / 1000000000;
		JOptionPane.showMessageDialog(null, "Time taken " + output + " Seconds", // message
				"Time taken", // title
				JOptionPane.PLAIN_MESSAGE);
		
	}

	public static void main(String[] args) {
		Chapter6test myApp = new Chapter6test();
		myApp.setVisible(true);
	}
}