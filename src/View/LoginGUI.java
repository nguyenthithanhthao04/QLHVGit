package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginGUI() {
        setTitle("ĐĂNG NHẬP");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.put("Panel.background", new Color(250, 235, 215));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Thêm khoảng trống 10px cho viền

        lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
        txtUsername = new JTextField();
        txtUsername.setColumns(5);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));

        lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
        txtPassword = new JPasswordField();
        txtPassword.setColumns(7);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));

        btnLogin = new JButton("Đăng nhập");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(new JLabel());
        panel.add(btnLogin);

        Border border = BorderFactory.createLineBorder(Color.BLACK); // Tạo viền đen cho thành phần
        panel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Thêm viền cho panel

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    openQLHVGUI();
                } else {
                    int option = JOptionPane.showOptionDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!"
                            + "\n Vui lòng thử lại !", "Lỗi đăng nhập", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[] { "Thoát", "Thử lại" }, "Thoát");

                    if (option == JOptionPane.YES_OPTION) {
                        // Xử lý khi người dùng nhấp vào nút "Thoát"
                        System.exit(0);
                    } else if (option == JOptionPane.NO_OPTION) {
                        // Xử lý khi người dùng nhấp vào nút "Thử lại"
                        txtUsername.setText("");
                        txtPassword.setText("");
                    }
                }
            }
        });

        getContentPane().add(panel);
        setLocationRelativeTo(null);
    }

    private void openQLHVGUI() {
        QLHV qlhv = new QLHV();
        qlhv.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginGUI loginGUI = new LoginGUI();
                loginGUI.setVisible(true);
            }
        });
    }
}