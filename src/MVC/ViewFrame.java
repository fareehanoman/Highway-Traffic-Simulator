package MVC;

public class ViewFrame extends javax.swing.JFrame {

    Modelable theModel;
    MyView view1;

    public ViewFrame(int view) {
        initComponents();
        if (view == 1) {
            setBounds(275, 0, Globals.getViewPortHeight(), Globals.getViewPortWidth());
        } else {
            setBounds(800, 0, Globals.getViewPortHeight(), Globals.getViewPortWidth());
        }
        view1 = new MyView(this, view, Globals.getViewPoint(view));
        add(view1);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
