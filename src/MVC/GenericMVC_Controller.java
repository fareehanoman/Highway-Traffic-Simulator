package MVC;

/**
 * Generic Controller for the Model/View/Controller pattern using interfaces
 * NB: it knows *nothing* about what is is the model or the view
 * 
 * @author levenick
 */
public class GenericMVC_Controller extends Thread {

    private boolean running = false;
    theController control;
    ViewFrame theView;
    ViewFrame theView2;
    Modelable theModel;
    private boolean stepping;
    

    
    GenericMVC_Controller(ViewFrame view, ViewFrame view2) {
        this.theView = view;
        this.theView2 = view2;
        theModel = new MyModel();
        theView.view1.theModel = theModel;
        theView2.view1.theModel = theModel;
    }

    public void run() {
        for (;;) {
            if (running || stepping) {
                step();
                stepping = false;  // only take one step per button press
            }
            delay();
        }
    }

   private void delay() {
        try {
            Thread.sleep(40);
        } catch (Exception ex) {
        }
    }

    void toggleRunning() {
        running = !running;
    }

    private void step() {
        theModel.step();
        
        theView.view1.display();
        theView2.view1.display();
        

    }

    void setStep() {
        stepping = true;        // set stepping
        running = false;        // unset running (so it stops if you press step)
    }

    Modelable getModel() {
        return theModel;
    }

    boolean getRunning() {
        return running;
    }

}
