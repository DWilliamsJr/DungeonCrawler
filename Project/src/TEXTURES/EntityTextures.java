package textures;
// idk if this is the best possible way to do this...
	// but it works??
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class EntityTextures implements k_EntityTextures {

	private ImageIcon texture[];
	private int size;
	
	public EntityTextures(int size)
	{
		this.size = 0;
		texture = new ImageIcon[size];
	}
	
	public void genTexture(String picture)
	{
		try {
			BufferedImage img = ImageIO.read(this.getClass().getClassLoader().getResource(picture));
			texture[this.size] = new ImageIcon(img);
			this.size++;
		} 
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("index out of bounds: EntityTextures, genTexture: " + size);
			//e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			System.out.println("IllegalArguementException: EntityTextures, genTexture: " + picture);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException: EntityTextures, genTexture: " + picture);
			e.printStackTrace();
		}
		
	}
	
	public ImageIcon getTexture(short index) {
		try {
		return texture[index];
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("index out of bounds: EntityTextures, getTexture: " + index);
			e.printStackTrace();
			return null;
		}
	}

	
	

}
