/*
 * 로그인 아이디 비밀번호 @../image/login.png 이미지 주소
 * 로그인하면 loginController로 이동
 * 로그인/취소 버튼 존재, 내용물이 비어있으면 경고문.
 * 아이디가 따로 정의, admin, 1234, getTest().equals("admin") 같은거.
 * 저 아이디로 로그인을 할 경우 메인으로 옮겨짐. 
 * 메인 fxml maxHeight및 width, height="-Infinity"
 * <TabPane>
 * tabClosingPolicy="UNAVAILABLE" javafx/8도 사용
 * <tabs> Tab text="첫번째"> <content>순 후에 <AnchorPane> anchor은 좌표사용 layoutX같은 것.
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
			primaryStage.setTitle("로그인");
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
