import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class paint {
	static Color temp;
	static JButton redButton;
	static JButton blackButton;
	static JButton magentaButton;
	static JButton greenButton;
	static JButton colorChooser;
	static JButton blueButton;
	public static void main(String[] args) {

		Icon iconB = new ImageIcon("blue.gif");

		Icon iconM = new ImageIcon("magenta.gif");

		Icon iconR = new ImageIcon("red.gif");

		Icon iconBl = new ImageIcon("black.gif");

		Icon iconG = new ImageIcon("green.gif");

		final JFrame frame = new JFrame("Paint - CPS613 Lab3");
		frame.setLocation(15, 15);
		frame.setResizable(false);
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());

		final PadDraw drawPad = new PadDraw();
		content.add(drawPad, BorderLayout.CENTER);
		// drawPad.color(Color.BLACK);
		final JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(32, 68));
		panel.setMinimumSize(new Dimension(32, 68));
		panel.setMaximumSize(new Dimension(32, 68));

		JButton clearButton = new JButton("Clear");
		clearButton.setBackground(Color.WHITE);
		try {
			File file = new File("src/clear.png");
			Image img = ImageIO.read(file);
			clearButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enable();
				drawPad.clear();
			}
		});

		redButton = new JButton(iconR);
		redButton.setBackground(Color.RED);
		try {
			File file = new File("src/red.png");
			Image img = ImageIO.read(file);
			redButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.red();
			}

		});
		 blackButton = new JButton(iconBl);
		try {
			File file = new File("src/black2.png");
			Image img = ImageIO.read(file);
			blackButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		blackButton.setBackground(Color.BLACK);
		blackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.black();
			}
		});

		 magentaButton = new JButton(iconM);
		magentaButton.setBackground(Color.MAGENTA);
		try {
			File file = new File("src/magenta.png");
			Image img = ImageIO.read(file);
			magentaButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		magentaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.magenta();
			}
		});

		 blueButton = new JButton(iconB);
		try {
			File file = new File("src/blue.png");
			Image img = ImageIO.read(file);
			blueButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		blueButton.setBackground(Color.BLUE);
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.blue();
			}
		});

		 greenButton = new JButton(iconG);
		try {
			File file = new File("src/green1.png");
			Image img = ImageIO.read(file);
			greenButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		greenButton.setBackground(Color.GREEN);
		greenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.green();
			}
		});

		JButton erase = new JButton("Eraser");
		try {
			File file = new File("src/eraser.png");
			Image img = ImageIO.read(file);
			erase.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		erase.setBackground(Color.WHITE);
		erase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disable();
				final Stroke INK_STROKE = new BasicStroke(8.0f,
						BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
				drawPad.graphics2D.setStroke(INK_STROKE);
				drawPad.white();
			}
		});


		 colorChooser = new JButton("Colors");
		try {
			File file = new File("src/circle.png");
			Image img = ImageIO.read(file);
			colorChooser.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		colorChooser.setBackground(Color.BLACK);
		colorChooser.setForeground(Color.WHITE);
		colorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(drawPad,
						"Choose text color", Color.BLACK);
				drawPad.color(tmp);
			}
		});

		JButton fileChooser = new JButton("Open Image");
		try {
			File file = new File("src/open.png");
			Image img = ImageIO.read(file);
			fileChooser.setIcon(new ImageIcon(img));
			fileChooser.setBackground(Color.WHITE);
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					drawPad.openPicture();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		final JButton pencil = new JButton("Pencil");
		try {
			File file = new File("src/pencil.png");
			Image img = ImageIO.read(file);
			pencil.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}

		pencil.setBackground(Color.WHITE);
		pencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enable();
				final Stroke INK_STROKE = new BasicStroke(1.4f,
						BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
				drawPad.graphics2D.setStroke(INK_STROKE);
				final Color color = drawPad.graphics2D.getColor();
				if (color == Color.WHITE) {
					drawPad.black();
				} else
					drawPad.color(color);
			}
		});

		JButton brush = new JButton("Brush");
		try {
			File file = new File("src/brush2.png");
			Image img = ImageIO.read(file);
			brush.setIcon(new ImageIcon(img));
			brush.setBackground(Color.WHITE);
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		brush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enable();
				final Stroke INK_STROKE = new BasicStroke(15.0f,
						BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
				drawPad.graphics2D.setStroke(INK_STROKE);
				final Color color = drawPad.graphics2D.getColor();
				if (color == Color.WHITE) {
					drawPad.black();
				} else
					drawPad.color(color);
			}
		});

		final JToggleButton lineButton = new JToggleButton("Line");
		try {
			File file = new File("src/line.png");
			Image img = ImageIO.read(file);
			lineButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("file not found");
		}
		lineButton.setBackground(Color.WHITE);
		lineButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				enable();
				 final Color color;
				 //final Color temp = color;
				// System.out.println(color + " before ");
				 if (lineButton.isSelected()) {
						// colorChooser.setEnabled(false);
					 temp =  drawPad.graphics2D.getColor();
					 drawPad.check = 1;
						float alpha = (float) 0.0;
						drawPad.graphics2D.setColor(new Color(1, 0, 0, alpha));
						
						drawPad.addMouseListener(new MouseAdapter() {
							Point startPoint;
							Point endPoint;

							public void mousePressed(MouseEvent e) {
								startPoint = e.getPoint();
							}

							public void mouseReleased(MouseEvent e) {
								endPoint = e.getPoint();
								if (lineButton.isSelected() &&  drawPad.check == 1 ) {
									//color = drawPad.graphics2D.getColor();
									// if(drawPad.check == 1){
									drawPad.graphics2D.setColor(temp);
									drawPad.graphics2D.drawLine(startPoint.x,
											startPoint.y, endPoint.x, endPoint.y);
									lineButton.setSelected(false);
									 pencil.setSelected(true);
								
								//	 drawPad.graphics2D.setColor(Color.RED);
							//		 System.out.println(color);
									 drawPad.check = 0;
								} //else
									
							}
						});
					}
				}
});

		final JToolBar toolBar;
		toolBar = new JToolBar("Functions");
		toolBar.setBackground(new Color(235, 245, 255));
		toolBar.setFloatable(false);
		blackButton.setPreferredSize(new Dimension(16, 16));
		magentaButton.setPreferredSize(new Dimension(16, 16));
		redButton.setPreferredSize(new Dimension(16, 16));
		blueButton.setPreferredSize(new Dimension(16, 16));
		greenButton.setPreferredSize(new Dimension(16, 16));
		toolBar.add(clearButton);
		toolBar.add(fileChooser);
		toolBar.addSeparator();
		toolBar.add(erase);
		toolBar.add(brush);
		toolBar.add(pencil);
		toolBar.add(lineButton);
		toolBar.addSeparator();
		toolBar.addSeparator();
		toolBar.addSeparator();
		toolBar.addSeparator();

		toolBar.add(colorChooser);
		toolBar.add(greenButton);
		toolBar.add(blueButton);
		toolBar.add(magentaButton);
		toolBar.add(blackButton);
		toolBar.add(redButton);

		content.add(toolBar, BorderLayout.NORTH);
		frame.setSize(950, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void disable(){
		colorChooser.setEnabled(false);
		blueButton.setEnabled(false);
		greenButton.setEnabled(false);
		magentaButton.setEnabled(false);
		redButton.setEnabled(false);
		blackButton.setEnabled(false);
	}
	public static void enable(){
		colorChooser.setEnabled(true);
		blueButton.setEnabled(true);
		greenButton.setEnabled(true);
		magentaButton.setEnabled(true);
		redButton.setEnabled(true);
		blackButton.setEnabled(true);
	}
}


class PadDraw extends JComponent {
	BufferedImage image;
	Graphics2D graphics2D;
	Graphics graphics;
	int i = 0;
	int currentX, currentY, oldX, oldY;
	int check = 0;

	PadDraw() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				if (graphics2D != null && check == 0)
					graphics2D.drawLine(oldX, oldY, currentX, currentY);
				repaint();
				oldX = currentX;
				oldY = currentY;
			}
		});
	}

	public void openPicture() throws IOException {
		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String sname = file.getAbsolutePath(); // THIS WAS THE PROBLEM
			BufferedImage img = ImageIO.read(file);
			image = img;
			graphics2D = (Graphics2D) image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
	}

	public void paintComponent(Graphics g) {

		if (image == null) {
			image = new BufferedImage(this.getWidth(), this.getHeight(),
					BufferedImage.TYPE_INT_ARGB);
			graphics2D = (Graphics2D) image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		} else {
		//	final Color color = graphics2D.getColor();
		//graphics2D.setColor(color);
			g.drawImage(image, 0, 0, this);
			repaint();
			
		}
		i++;
	}

	
	public void clear() {
		if (i != 0) {
			image = new BufferedImage(this.getWidth(), this.getHeight(),
					BufferedImage.TYPE_INT_ARGB);
			graphics2D = (Graphics2D) image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			i = 0;
		}
		graphics2D.setPaint(Color.white);
		this.checkImage(image, 950, 700, this);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}

	public void red() {
		graphics2D.setPaint(Color.red);
		repaint();
	}

	public void black() {
		graphics2D.setPaint(Color.black);
		repaint();
	}

	public void magenta() {
		graphics2D.setPaint(Color.magenta);
		repaint();
	}

	public void white() {
		graphics2D.setPaint(Color.WHITE);
		repaint();
	}

	public void blue() {
		graphics2D.setPaint(Color.blue);
		repaint();
	}

	public void green() {
		graphics2D.setPaint(Color.green);
		repaint();
	}

	public void color(Color c) {
		graphics2D.setPaint(c);
		repaint();
	}
}
