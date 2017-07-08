package tw.jason.j2ee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jason26")
public class Jason26 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		
		String imgPath =
			getServletContext().getInitParameter("upload-path");	
		File imgFile = new File(imgPath,"java.png");
		
		BufferedImage bimg = ImageIO.read(imgFile);
		Graphics2D g2d = bimg.createGraphics();
		
		//draw
		Font font = new Font(null,Font.BOLD+Font.ITALIC,40);
		
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(45),100,0);
		Font newfont = font.deriveFont(tran);
		
		g2d.setFont(newfont);
		g2d.setColor(Color.ORANGE);
		g2d.drawString("Hello,World資策會", 40, 180);
		
		
		
		//output
		File outFile = new File(imgPath,"jason.png");
		OutputStream out = response.getOutputStream();
		ImageIO.write(bimg, "png", out);
		
		ImageIO.write(bimg, "png", outFile);
		
		out.flush();
		out.close();
		
		//output to file
		
	
		
		
		
		
	}

	
}
