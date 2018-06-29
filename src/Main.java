import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main
{

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        JFrame frame = new MainFrame();
        frame.setSize(1000, 800);
        frame.setTitle("Ponto de Venda");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    });
  }
}