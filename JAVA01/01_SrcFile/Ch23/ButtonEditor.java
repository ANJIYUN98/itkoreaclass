package Ch23;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
	   private JButton button;

	    public ButtonEditor() {
	        button = new JButton("버튼");
	        button.setOpaque(true);
	        button.addActionListener(this);
	    }

	    @Override
	    public Object getCellEditorValue() {
	        return button;
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        if (value instanceof Component) {
	            return (Component) value;
	        } else {
	            button.setText((value == null) ? "" : "버튼");
	            return button;
	        }
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // 버튼 클릭 시 동작 작성
	        System.out.println("Button clicked!");
	        //fireEditingStopped(); // 에디터를 중지하고 편집값을 저장
	        JFrame frm = new JFrame();
	        frm.setBounds(10,10,100,100);
	        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frm.setVisible(true);
	        
	    }
}
