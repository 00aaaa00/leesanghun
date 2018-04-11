/*
 * �α��� ���̵� ��й�ȣ @../image/login.png �̹��� �ּ�
 * �α����ϸ� loginController�� �̵�
 * �α���/��� ��ư ����, ���빰�� ��������� ���.
 * ���̵� ���� ����, admin, 1234, getTest().equals("admin") ������.
 * �� ���̵�� �α����� �� ��� �������� �Ű���. 
 * ���� fxml maxHeight�� width, height="-Infinity"
 * <TabPane>
 * tabClosingPolicy="UNAVAILABLE" javafx/8�� ���
 * <tabs> Tab text="ù��°"> <content>�� �Ŀ� <AnchorPane> anchor�� ��ǥ��� layoutX���� ��.
 * 
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
			Parent login = loader.load();
			Scene loginScene = new Scene(login);
			primaryStage.setTitle("�α���");
			primaryStage.setScene(loginScene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
