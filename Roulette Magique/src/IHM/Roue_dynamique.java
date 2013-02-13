package IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Roue_dynamique extends JPanel {

	public BufferedImage image = null;
	private double angle = 0.0;

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, this);
		}
	}

	/**
	 * Constructeur de la roue dynamique
	 */
	public Roue_dynamique() {
		try {
			image = ImageIO.read(getClass().getResource("roulette.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setFocusable(true);
		setBackground(new Color(17, 53, 100));

	}

	/**
	 * Rotation de l'image
	 */
	public void rotation() {
		AffineTransform transformer = new AffineTransform();
		transformer.rotate(angle, this.getWidth() / 2, this.getHeight() / 2);
		AffineTransformOp op = new AffineTransformOp(transformer,
				AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		repaint();
	}

	public void setAngle(double angle) {
		this.angle = angle % 6;
	}

	public double getAngle() {
		return angle;
	}

}
