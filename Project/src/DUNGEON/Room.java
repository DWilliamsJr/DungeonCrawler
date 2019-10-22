package dungeon;
import javax.swing.ImageIcon;

//todo
	// error checking
	// constructor to take roomTexture

public class Room implements k_Room {
	
	private k_Room Top;
	private k_Room Bottom;
	private k_Room Left;
	private k_Room Right;
	private boolean isMain;
	private short mobID;
	
	private ImageIcon roomTexture;
	
	public Room(k_Room TR, k_Room LR, k_Room RR, k_Room BR, boolean set, ImageIcon rText, short mobID) {
		this.setAdjRoom(BR, 'b');
		this.setAdjRoom(TR, 't');
		this.setAdjRoom(LR, 'l');
		this.setAdjRoom(RR, 'r');
		this.setIsMain(set);
		this.setTexture(rText);
		this.mobID = mobID;
		
	}
	
	public Room(boolean set, ImageIcon rText, short roomID) {
		this(null, null, null, null, set, rText, roomID);
	}

	@Override
	public ImageIcon getTexture() {
		return roomTexture;
	}

	@Override
	public void setTexture(ImageIcon texture) {
		this.roomTexture = texture;

	}
	
	@Override
	public void setAdjRoom(k_Room room, char R) {
		
		switch (R)
		{
			case 'R':
			case 'r':
			{
				this.Right = room;
				break;
			}
			case 'L':
			case 'l':
			{
				this.Left = room;
				break;
			}
			case 'T':
			case 't':
			{
				this.Top = room;
				break;
			}
			case 'B':
			case 'b':
			{
				this.Bottom = room;
				break;
			}
			default:
			{
				System.out.println("default case: Room, getRoom");
			}
		}
	}
	
	@Override
	public k_Room getAdjRoom(char R) {
		
		switch (R)
		{
			case 'R':
			case 'r':
			{
				return this.Right;
			}
			case 'L':
			case 'l':
			{
				return this.Left;
			}
			case 'T':
			case 't':
			{
				return this.Top;
			}
			case 'B':
			case 'b':
			{
				return this.Bottom;
			}
			default:
			{
				System.out.println("default case: Room, getRoom");
				return null;
			}
		}
	}

	@Override
	public void setIsMain(boolean set) {
		this.isMain = set;
	}
	
	public boolean getIsMain() {
		return this.isMain;
	}
	
	@Override
	public short roomID()
	{
		return mobID;
	}
}

