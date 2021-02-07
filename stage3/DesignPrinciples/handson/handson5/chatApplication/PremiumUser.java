package chatApplication;

public class PremiumUser implements IUser{
	public static ChatMediator mediator =new ChatMediator();
	private String name;
	public PremiumUser(String name) {
		super();
		this.name = name;
	}
	@Override
	public void sendMessage(String msg) {
		mediator.sendMessage(msg);
		
	}
	@Override
	public void receiveMessage(String msg) {
		System.out.println(name+" :: "+msg);
		
	}
	

}
