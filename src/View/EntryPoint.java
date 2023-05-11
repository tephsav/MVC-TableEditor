package View;

import Controller.Controller;
import Model.Model;

public class EntryPoint {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        MainFrame mainFrame = new MainFrame(controller);
    }
}
