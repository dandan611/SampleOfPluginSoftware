package pluginapp;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.*;
import java.util.*;
import java.util.jar.*;

import javax.swing.*;

public class SamplePluginApp extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JTextField result;
    private JComboBox pluginsCombo;
    private JPanel panel;

    private ArrayList <SamplePluginAppPlugin>plugins;
    private SamplePluginAppPlugin selectedPlugin;
    private JPanel selectedPluginPanel;
    
    public static void main(String[] args) {
        new SamplePluginApp().setVisible(true);
    }
    
    // �R���X�g���N�^�B��{GUI�̍쐬
    public SamplePluginApp(){
        result = new JTextField();
        this.add(result,BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
    	
        pluginsCombo = this.getPluginComboBox();
        pluginsCombo.setBounds(new Rectangle(50,50,100,40));
        pluginsCombo.addActionListener(new pluginComboAction());
        panel.add(pluginsCombo,BorderLayout.NORTH);
    	
    	panel.add(selectedPlugin.getPanel(),BorderLayout.CENTER);
    	
        this.add(panel,BorderLayout.CENTER);
        
    	JButton button = new JButton("calc");
        button.addActionListener(new buttonAction());
        this.add(button,BorderLayout.SOUTH);
        this.setSize(new Dimension(400,300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // JComboBox�̍쐬
    public JComboBox getPluginComboBox(){
        JComboBox<SamplePluginAppPlugin> combo = new JComboBox<SamplePluginAppPlugin>();
        plugins = getPlugins();
        // �f�t�H���g�v���O�C���̏���
        selectedPlugin = new DefaultPlugin();
        selectedPluginPanel = selectedPlugin.getPanel();
        combo.addItem(selectedPlugin);
        
        for(int i = 0;i < plugins.size();i++){
            SamplePluginAppPlugin plugin = plugins.get(i);
            combo.addItem(plugin);
        }
        return combo;
    }
	
    // JComboBox��ActionListener
    class pluginComboAction implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            panel.removeAll();
            panel.add(pluginsCombo,BorderLayout.NORTH);
            selectedPlugin = (SamplePluginAppPlugin)(pluginsCombo.getSelectedItem());
            selectedPluginPanel = selectedPlugin.getPanel();
        	
            panel.add(selectedPluginPanel);
            panel.updateUI();
        }
    }
	
    // JButton��ActionListener
    class buttonAction implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            result.setText(selectedPlugin.getResult());
        }
    }
	
    // �v���O�C���N���X�̃C���X�^���X��ArrayList�ɂ܂Ƃ߂ĕԂ�
    public ArrayList<SamplePluginAppPlugin> getPlugins() {
        ArrayList <SamplePluginAppPlugin>plugins =
                new ArrayList<SamplePluginAppPlugin>();
        String cpath = System.getProperty("user.dir") +
                File.separator + "plugins";
        try {
            File f = new File(cpath);
            String[] files = f.list();
            for (int i = 0; i < files.length; i++) {
                if (files[i].endsWith(".jar")) {
                    File file = new File(cpath + File.separator +
                            files[i]);
                    JarFile jar = new JarFile(file);
                    Manifest mf = jar.getManifest();
                    Attributes att = mf.getMainAttributes();
                    String cname = att.getValue("Plugin-Class");
                    URL url = file.getCanonicalFile().toURI().toURL();
                    URLClassLoader loader = new URLClassLoader(
                            new URL[] { url });
                    Class cobj = loader.loadClass(cname);
                    Class[] ifnames = cobj.getInterfaces();
                    for (int j = 0; j < ifnames.length; j++) {
                        if (ifnames[j] == SamplePluginAppPlugin.class) {
                            System.out.println("load..... " + cname);
                            SamplePluginAppPlugin plugin =
                                (SamplePluginAppPlugin)cobj.newInstance();
                            plugins.add(plugin);
                            break;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return plugins;
    }
}

// �T���v���v���O�C���̃N���X
class DefaultPlugin implements SamplePluginAppPlugin {
    private JTextField input;
    private JPanel currentPanel;
    
    public String toString(){
        return "Default(tax)";
    }

    public String getResult() {
        String inputData = input.getText();
        if (inputData == null) inputData = "0";
        int n;
        try {
            n = Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            n = 0;
        }
        double res = ((int)(n * 1.08 * 100)) / 100;
        return Double.toString(res);
    }

    public void setInputData(String str) {
        input.setText(str);
    }
    
    public String getInputData(){
        return input.getText();
    }

    public JPanel getPanel() {
        currentPanel = new JPanel();
        currentPanel.setLayout(null);
        input = new JTextField();
        input.setBounds(new Rectangle(50,50,100,40));
        currentPanel.add(input);
        return currentPanel;
    }
    
}

