package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Button btnLogin;
	@FXML
	private Button btnCancel;
	@FXML
	private AnchorPane pane;
	private Stage primaryStage;
	private static String password = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getPasswordFromSQL();
		btnLogin.setOnAction(event -> {
			LoginAction();
		});
		btnCancel.setOnAction(event -> CancelAction());
		
		pane.setOnKeyPressed((event) -> {
			if (event.getCode() == KeyCode.ENTER) {
				LoginAction();
			}
		});
	}

	public void CancelAction() {
		Platform.exit();
	}

	public static void setPasswordtoSQL(String newpassword) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("update adminpassword set password = '" + newpassword + "'");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	public String getPasswordFromSQL() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from adminpassword");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString("password");
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return password;
	}

	public void LoginAction() {
		Alert alert;
		if (txtPassword.getText().equals("")) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("로그인 실패");
			alert.setHeaderText("비밀번호 미입력");
			alert.setContentText("비밀번호를 입력하지 않았습니다. 입력해주십시오.");
			alert.setResizable(false);
			alert.showAndWait();
			return;
		}
		if (EqualPassword(txtPassword.getText())) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PosMain.fxml"));
			Parent mainView = null;
			try {
				mainView = (Parent) loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Scene scane = new Scene(mainView);
			Stage mainMtage = new Stage();
			mainMtage.setTitle("MELLOW BRUNCH POS");
			mainMtage.setScene(scane);
			MainController controller = loader.getController();
			controller.setPrimaryStage(primaryStage);
			Stage oldStage = (Stage) btnLogin.getScene().getWindow();
			oldStage.close();
			mainMtage.show();
		} else

		{
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("로그인 실패");
			alert.setHeaderText("비밀번호 불일치");
			alert.setContentText("비밀번호가 일치하지 않습니다." + "다시 제대로 입력하시오.");
			alert.showAndWait();
		}
	}

	public static boolean EqualPassword(String passwords) {
		if (passwords.equals(LoginController.getPasswords())) {
			return true;
		} else {
			return false;
		}
	}

	public static String getPasswords() {
		return LoginController.password;
	}

	public static void setPasswords(String newpassword) {
		LoginController.password = newpassword;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
