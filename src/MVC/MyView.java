package MVC;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Prototype Viewable
 *
 * @author levenick
 */
public class MyView extends javax.swing.JPanel implements Viewable {

    Modelable theModel;
    ViewFrame theFrame;
    int view;
    int startViewLocation;
    int width = Globals.getViewPortWidth();
    int height = Globals.getViewPortHeight();

    public MyView(ViewFrame f, int view, int startViewLocation) {
        initComponents();
        theFrame = f;
        this.startViewLocation = startViewLocation;
        setBounds(0, 0, 500, 500);
        this.view = view;
    }

    /**
     * repaint the Frame which will cause paintComponent to be sent with the
     * Graphics context
     */
    public void display() {
        theFrame.repaint();
    }

    /**
     * Displays theModel
     *
     * @param g
     */
    public void paintComponent(Graphics g) {

        int count = 0;
        
        //sky
        g.setColor(Color.BLUE.brighter());
        g.fillRect(0, 0, width, Globals.getLane(1));
        
        //grass
        g.setColor(Color.GREEN.darker());
        g.fillRect(0, 150, width, height);
        
        //road
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 125, width, 150);
        //g.fillRect(0, Globals.getLane(1), width, Globals.getLane(Globals.getNumLanes()));
        
        //lines
        for (int i = Globals.getLane(1); count < Globals.getNumLanes() + 1; i += Globals.LaneSize) {
            if(i == Globals.getLane(1)|| i == 275){
                g.setColor(Color.YELLOW);
                g.fillRect(0, i, width, 2);
            }
            else{
                for(int s = 0; s<= width; s+=20){
                    g.setColor(Color.WHITE);
                    g.fillRect(s, i, 5, 2);
                }
            }
            count++;
        }//draws lines of the lane

        if (view == 1) {
            paintIt(g, 1);
        } else {
            paintIt(g, 2);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged

    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

    private void paintIt(Graphics g, int view) {

        //g.drawLine(width, 0, width, height);
        if (theModel == null) return;
        if ((theModel.viewSees(Globals.getViewPoint(view), Globals.getViewPoint(view) + width)) == null) {
            return;
        }
        for (Vehicles v : theModel.viewSees(Globals.getViewPoint(view), Globals.getViewPoint(view) + width)) {
            if (v != null) {
                v.paint(g, startViewLocation);
            } else {
                return;
            }
        }
    }

}
