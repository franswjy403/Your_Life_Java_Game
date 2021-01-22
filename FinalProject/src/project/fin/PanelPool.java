package project.fin;

public class PanelPool {
	public static GameOverPanel OverPage;
	public static MainMenuPanel MainMenu;
	public static LosePanel LosePage;
	public static InstructionPanel InstructPage;
	public static RolePanel RolePage;
	public PanelPool() {
		// TODO Auto-generated constructor stub
		PanelPool.OverPage = new GameOverPanel("background/bg finish.png");
		PanelPool.MainMenu = new MainMenuPanel("background/Universe_r.jpg");
		PanelPool.LosePage = new LosePanel("background/gameover new.png");
		PanelPool.InstructPage = new InstructionPanel("background/bg finish.png");
		PanelPool.RolePage = new RolePanel("background/Universe_r.jpg");
	}
}
