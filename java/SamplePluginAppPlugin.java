package pluginapp;

import javax.swing.JPanel;

public interface SamplePluginAppPlugin {
    public String getResult();              // �v�Z���ʂ̎擾
    public void setInputData(String input); // �f�[�^��Setter
    public String getInputData();           // �f�[�^��Getter
    public JPanel getPanel();               // GUI�ƂȂ�JPanel��Ԃ�
}
