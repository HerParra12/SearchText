package co.edu.unbosque.view;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JPanel{

	private static final long serialVersionUID = 7533942115625784030L;
	private JFileChooser jf;
	private FileNameExtensionFilter filter;
	
	public FileChooser() {
		jf = new JFileChooser();
		jf.showOpenDialog(FileChooser.this);
		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jf.setFileFilter(filter);
	}
	
	public File checkFile() {
		File f = jf.getSelectedFile();
		while (f == null) {
			JOptionPane.showMessageDialog(null, "You must select a .txt", "Warning message", JOptionPane.WARNING_MESSAGE);
			jf.showOpenDialog(FileChooser.this);
			jf.setFileFilter(filter);
			f = jf.getSelectedFile();
		}
		return f;
	}
	
}
