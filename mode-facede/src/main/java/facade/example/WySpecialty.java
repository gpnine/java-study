package facade.example;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class WySpecialty extends JPanel implements TreeSelectionListener {

    private static final long serialVersionUID = -8517425330417411841L;

    final JTree tree;
    JLabel label;
    private Specialty1 s1 = new Specialty1();
    private Specialty2 s2 = new Specialty2();
    private Specialty3 s3 = new Specialty3();
    private Specialty4 s4 = new Specialty4();
    private Specialty5 s5 = new Specialty5();
    private Specialty6 s6 = new Specialty6();

    public WySpecialty() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("特产");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("四大特产（红、绿、黑、白）");
        node1.add(new DefaultMutableTreeNode("红"));
        node1.add(new DefaultMutableTreeNode("绿"));
        node1.add(new DefaultMutableTreeNode("黑"));
        node1.add(new DefaultMutableTreeNode("白"));
        top.add(node1);

        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("其他特产");
        node2.add(new DefaultMutableTreeNode("1"));
        node2.add(new DefaultMutableTreeNode("2"));
        top.add(node2);
        tree = new JTree(top);
        tree.addTreeSelectionListener(this);
        label = new JLabel();
    }


    @Override
    public void valueChanged(TreeSelectionEvent e) {
        if (e.getSource() == tree) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node == null) return;
            if (node.isLeaf()) {
                Object object = node.getUserObject();
                String sele = object.toString();
                label.setText(sele);
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setVerticalTextPosition(JLabel.BOTTOM);
                if (sele.equalsIgnoreCase("红")) label.setIcon(s1);
                else if (sele.equalsIgnoreCase("绿")) label.setIcon(s2);
                else if (sele.equalsIgnoreCase("黑")) label.setIcon(s3);
                else if (sele.equalsIgnoreCase("白")) label.setIcon(s4);
                else if (sele.equalsIgnoreCase("1")) label.setIcon(s5);
                else if (sele.equalsIgnoreCase("2")) label.setIcon(s6);
                label.setHorizontalAlignment(JLabel.CENTER);
            }
        }
    }
}
