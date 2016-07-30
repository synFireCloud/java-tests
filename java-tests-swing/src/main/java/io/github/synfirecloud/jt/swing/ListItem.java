package io.github.synfirecloud.jt.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by synFireCloud on 7/19/16.
 */
public class ListItem extends JPanel implements ListCellRenderer<ListItemModel> {
	private JLabel name,state,mac;
	public ListItem() {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(new LineBorder(Color.lightGray));
		name = new JLabel();
		state = new JLabel();
		state.setFont(new Font(null,10,10));
		state.setForeground(Color.BLUE);
		mac = new JLabel();
		mac.setFont(new Font(null,10,10));
		mac.setForeground(Color.GRAY);
		add(name);
		add(state);
		add(mac);
		setBackground(Color.WHITE);
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends ListItemModel> jList, ListItemModel listItemModel, int index, boolean isSelected, boolean cellHasFocus) {
		name.setText(listItemModel.name);
		state.setText(listItemModel.state);
		mac.setText(listItemModel.mac);
		setBackground(Color.WHITE);
		if(cellHasFocus){
			setBackground(Color.lightGray);
		}
		if(isSelected){
			setBackground(new Color(200,200,255));
		}
		return this;
	}
}
