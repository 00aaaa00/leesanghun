package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.OrderingVO;
import model.ProductVO;

public class MainController implements Initializable {
	@FXML
	private AnchorPane mainpane;
	@FXML
	private TableView<OrderingVO> tableView = new TableView<>();
	@FXML
	private Button btn_selectall;
	@FXML
	private Button btn_plus;
	@FXML
	private Button btn_minus;
	@FXML
	private Button btn_orderreset;
	@FXML
	private Button btn_one;
	@FXML
	private Button btn_two;
	@FXML
	private Button btn_three;
	@FXML
	private Button btn_four;
	@FXML
	private Button btn_five;
	@FXML
	private Button btn_six;
	@FXML
	private Button btn_seven;
	@FXML
	private Button btn_eight;
	@FXML
	private Button btn_nine;
	@FXML
	private Button btn_o;
	@FXML
	private Button btn_moneyconfirm;
	@FXML
	private Button btn_moneyreset;
	@FXML
	private Button btn_cash;
	@FXML
	private Button btn_card;
	@FXML
	private Button btn_productadd;
	@FXML
	private Button btn_productedit;
	@FXML
	private Button btn_productdelete;
	@FXML
	private Button btn_exit;
	@FXML
	private Button btn_passwordchange;
	@FXML
	private Button IB_1;
	@FXML
	private Button IB_2;
	@FXML
	private Button IB_3;
	@FXML
	private Button IB_4;
	@FXML
	private Button IB_5;
	@FXML
	private Button IB_6;
	@FXML
	private Button IB_7;
	@FXML
	private Button IB_8;
	@FXML
	private Button IB_9;
	@FXML
	private Button IB_10;
	@FXML
	private Button IB_11;
	@FXML
	private Button IB_12;
	@FXML
	private Button IB_13;
	@FXML
	private Button IB_14;
	@FXML
	private Button IB_15;
	@FXML
	private Button IB_16;
	@FXML
	private Button IB_17;
	@FXML
	private Button IB_18;
	@FXML
	private Button IB_19;
	@FXML
	private Button IB_20;
	@FXML
	private Button IB_21;
	@FXML
	private Button IB_22;
	@FXML
	private Button IB_23;
	@FXML
	private Button IB_24;
	@FXML
	private Button IB_25;
	@FXML
	private Button btn_excel;
	@FXML
	private Button btn_pdf;
	@FXML
	private Button btn_savefiledir;

	@FXML
	private TextField tf_costamount;
	@FXML
	private TextField tf_totalsales;
	@FXML
	private TextField tf_discount;
	@FXML
	private TextField tf_acquire;
	@FXML
	private TextField tf_receivemoney;
	@FXML
	private TextField tf_change;
	@FXML
	private TextField tf_savefiledir;

	@FXML
	private ImageView IV_1;
	@FXML
	private ImageView IV_2;
	@FXML
	private ImageView IV_3;
	@FXML
	private ImageView IV_4;
	@FXML
	private ImageView IV_5;
	@FXML
	private ImageView IV_6;
	@FXML
	private ImageView IV_7;
	@FXML
	private ImageView IV_8;
	@FXML
	private ImageView IV_9;
	@FXML
	private ImageView IV_10;
	@FXML
	private ImageView IV_11;
	@FXML
	private ImageView IV_12;
	@FXML
	private ImageView IV_13;
	@FXML
	private ImageView IV_14;
	@FXML
	private ImageView IV_15;
	@FXML
	private ImageView IV_16;
	@FXML
	private ImageView IV_17;
	@FXML
	private ImageView IV_18;
	@FXML
	private ImageView IV_19;
	@FXML
	private ImageView IV_20;
	@FXML
	private ImageView IV_21;
	@FXML
	private ImageView IV_22;
	@FXML
	private ImageView IV_23;
	@FXML
	private ImageView IV_24;
	@FXML
	private ImageView IV_25;

	private ObservableList<OrderingVO> data = FXCollections.observableArrayList();
	private ObservableList<ProductVO> p_data = FXCollections.observableArrayList();
	int selectedIndex;
	OrderingVO orderEdit;
	private Stage primaryStage;
	File selectedFile = null;
	String selectFileName = "";
	String localUrl = "";
	Image localImage;
	private int checkingbutton;
	private File dirSave = new File("@../image/product/");
	private int existMenuNum = 0;
	private KeyCode inputKey;
	private ObservableList<ProductVO> selectedMenu = null;
	private int lastOrderNo = 0;
	private int productNum = 0;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialize(URL location, ResourceBundle resources) {
		OrderingDAO DAO = new OrderingDAO();
		ProductDAO PDAO = new ProductDAO();
		lastOrderNo = DAO.getOrderLastNo();
		lastOrderNo++;
		productNum = PDAO.getProductLastNo();
		productNum++;
		try {
			imageReset();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		tf_totalsales.setText("0");
		tf_discount.setText("0");
		tf_acquire.setText("0");
		tf_change.setText("0");
		tf_receivemoney.setText("0");
		btn_cash.setDisable(true);
		tf_totalsales.setDisable(true);
		tf_discount.setDisable(true);
		tf_receivemoney.setDisable(true);
		tf_change.setDisable(true);
		tf_acquire.setDisable(true);
		btn_excel.setDisable(true);
		btn_pdf.setDisable(true);
		tf_savefiledir.setEditable(false);
		tableView.setEditable(false);

		localUrl = "/image/default.png";
		localImage = new Image(localUrl, false);
		totalOrderList();
		TableColumn colNo = new TableColumn("No.");
		colNo.setMaxWidth(140);
		colNo.setStyle("-fx-allignment: CENTER");
		colNo.setCellValueFactory(new PropertyValueFactory<>("orderno"));

		TableColumn colName = new TableColumn("이름");
		colName.setMaxWidth(140);
		colName.setStyle("-fx-allignment: CENTER");
		colName.setCellValueFactory(new PropertyValueFactory<>("productname"));

		TableColumn colPrice = new TableColumn("가격");
		colPrice.setMaxWidth(80);
		colPrice.setStyle("-fx-allignment: CENTER");
		colPrice.setCellValueFactory(new PropertyValueFactory<>("productprice"));

		TableColumn colAmount = new TableColumn("갯수");
		colAmount.setMaxWidth(50);
		colAmount.setStyle("-fx-allignment: CENTER");
		colAmount.setCellValueFactory(new PropertyValueFactory<>("productamount"));
		tableView.getColumns().addAll(colNo, colName, colPrice, colAmount);
		tableView.setItems(data);
		btn_productadd.setOnAction(event -> {
			try {
				showAddPopup(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btn_productedit.setOnAction(event -> {
			try {
				showEditPopup(event);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		btn_productdelete.setOnAction(event -> {
			try {
				showDeletePopup(event);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btn_passwordchange.setOnAction(event -> {
			try {
				showPasswordPopup();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		btn_cash.setOnAction(event -> {
			Alert alert;
			String textme;
			if (tf_receivemoney.getText().equals(""))
				return;
			if (Integer.parseInt(tf_acquire.getText()) > Integer.parseInt(tf_receivemoney.getText())) {
				textme = " 금액이 부족합니다.";
			} else {
				textme = " 합계: " + tf_totalsales.getText() + "\n" + "할인값: " + tf_discount.getText() + "\n" + "받을 현금: "
						+ tf_acquire.getText() + "\n" + "받은 현금: " + tf_receivemoney.getText() + "\n" + "거스름돈: "
						+ tf_change.getText() + "\n" + "이용해주셔서 대단히 감사합니다.";
			}
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("상품 현금 결제");
			alert.setHeaderText("상품 현금 결제");
			alert.setContentText(textme);
			alert.showAndWait();
			MakeOrderPDF(event);
			/*
			 * try { DAO.ClearOrder(); } catch (Exception e) {
			 * e.printStackTrace(); }
			 */
			totalOrderList();
			data.removeAll(data);
			txtMoneyReset();
			lastOrderNo++;
		});

		btn_orderreset.setOnAction(event -> {
			try {
				// DAO.ClearOrder();
				totalOrderList();
				data.removeAll(data);
				txtMoneyReset();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		btn_one.setOnAction(event -> {
			calculateNum(1);
		});
		btn_two.setOnAction(event -> {
			calculateNum(2);
		});
		btn_three.setOnAction(event -> {
			calculateNum(3);
		});
		btn_four.setOnAction(event -> {
			calculateNum(4);
		});
		btn_five.setOnAction(event -> {
			calculateNum(5);
		});
		btn_six.setOnAction(event -> {
			calculateNum(6);
		});
		btn_seven.setOnAction(event -> {
			calculateNum(7);
		});
		btn_eight.setOnAction(event -> {
			calculateNum(8);
		});
		btn_nine.setOnAction(event -> {
			calculateNum(9);
		});
		btn_o.setOnAction(event -> {
			calculateNum(0);
		});

		btn_plus.setOnAction(event -> {
			orderEdit = tableView.getSelectionModel().getSelectedItem();
			selectedIndex = tableView.getSelectionModel().getSelectedIndex();
			OrderingVO VO = new OrderingVO();
			ArrayList<OrderingVO> list;
			list = DAO.getOrderTotal();
			VO = list.get(selectedIndex);
			int newAmount = VO.getProductamount() + 1;
			VO.setProductamount(newAmount);
			try {
				DAO.updateOrderingAmount(VO, VO.getProductno());
			} catch (Exception e) {
				e.printStackTrace();
			}
			totalOrderList();
		});
		btn_minus.setOnAction(event -> {
			orderEdit = tableView.getSelectionModel().getSelectedItem();
			selectedIndex = tableView.getSelectionModel().getSelectedIndex();
			OrderingVO VO = new OrderingVO();
			ArrayList<OrderingVO> list;
			list = DAO.getOrderTotal();
			VO = list.get(selectedIndex);
			int newAmount = VO.getProductamount() - 1;
			VO.setProductamount(newAmount);
			try {
				DAO.updateOrderingAmount(VO, VO.getProductno());
			} catch (Exception e) {
				e.printStackTrace();
			}
			totalOrderList();
		});
		btn_moneyconfirm.setOnAction(event -> {
			btn_cash.setDisable(false);
			calculateALL();
		});
		mainpane.setOnKeyPressed((event) -> {
			inputKey = event.getCode();
			if (inputKey == KeyCode.NUMPAD0)
				calculateNum(0);
			else if (inputKey == KeyCode.NUMPAD1)
				calculateNum(1);
			else if (inputKey == KeyCode.NUMPAD2)
				calculateNum(2);
			else if (inputKey == KeyCode.NUMPAD3)
				calculateNum(3);
			else if (inputKey == KeyCode.NUMPAD4)
				calculateNum(4);
			else if (inputKey == KeyCode.NUMPAD5)
				calculateNum(5);
			else if (inputKey == KeyCode.NUMPAD6)
				calculateNum(6);
			else if (inputKey == KeyCode.NUMPAD7)
				calculateNum(7);
			else if (inputKey == KeyCode.NUMPAD8)
				calculateNum(8);
			else if (inputKey == KeyCode.NUMPAD9)
				calculateNum(9);
			else if (inputKey == KeyCode.ESCAPE)
				Platform.exit();
			else if (inputKey == KeyCode.ENTER) {
				btn_cash.setDisable(false);
				calculateALL();
			} else
				return;
		});
		for (checkingbutton = 0; checkingbutton <= 25; checkingbutton++) {
			checkButton(checkingbutton).setOnMouseReleased(event -> {
				try {
					checkMouseClicked(event);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		imageButtonRefresh();
		btn_excel.setOnAction(event -> MakeExcel(event)); // 엑셀파일생성
		btn_savefiledir.setOnAction(event -> SaveFileDIR(event)); // 파일저장폴더선택
		btn_pdf.setOnAction(event -> MakeProductPDF(event)); // PDF파일생성

	}

	private void calculateALL() {
		int receive;
		int acquire;
		int result;
		String resultSt;
		tf_receivemoney.setText(tf_costamount.getText());
		if (tf_receivemoney.getText().equals(""))
			return;
		receive = Integer.parseInt(tf_receivemoney.getText());
		acquire = Integer.parseInt(tf_acquire.getText());
		result = receive - acquire;
		resultSt = result + "";
		tf_change.setText(resultSt);
	}

	private void calculateNum(int numba) {
		String result = tf_costamount.getText();
		result = result + numba;
		tf_costamount.setText(result);
	}

	@FXML
	private void EndAction() {
		Platform.exit();
	}

	@FXML
	private void ActionMoneyReset() {
		String result = tf_costamount.getText();
		result = "";
		tf_costamount.setText(result);
	}

	@FXML
	private void ActionMoneyConfirm() {
		String result = tf_costamount.getText();
		if (result.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("금액 입력 오류");
			alert.setHeaderText("금액을 입력하시오.");
			alert.setContentText("다음에는 주의하세요 !");
			alert.showAndWait();
		}
		tf_costamount.setText(result);
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void showAddPopup(ActionEvent event) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/PosAdd.fxml"));
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btn_plus.getScene().getWindow());
			dialog.setTitle("상품 추가");
			Parent parentADD = (Parent) loader.load();
			ImageView IV_picture = (ImageView) parentADD.lookup("#IV_picture");
			Button btn_searchpath = (Button) parentADD.lookup("#btn_searchpath");
			Button btn_addnew = (Button) parentADD.lookup("#btn_addnew");
			Button btn_addcancel = (Button) parentADD.lookup("#btn_addcancel");
			TextField tf_newproductname = (TextField) parentADD.lookup("#tf_newproductname");
			TextField tf_newproductprice = (TextField) parentADD.lookup("#tf_newproductprice");
			Scene scene = new Scene(parentADD);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			btn_addnew.setDisable(true);
			btn_searchpath.setOnAction(e -> {
				FileChooser fileChooser = new FileChooser();
				fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif"));
				try {
					selectedFile = fileChooser.showOpenDialog(primaryStage);
					if (selectedFile != null) {
						localUrl = selectedFile.toURI().toURL().toString();
					}
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				localImage = new Image(localUrl, false);
				IV_picture.setImage(localImage);
				btn_addnew.setDisable(false);
				if (selectedFile != null) {
					selectFileName = selectedFile.getName();
				}
			});

			btn_addnew.setOnAction(e -> {
				try {
					data.removeAll(data);
					File dirMake = new File(dirSave.getAbsolutePath());
					if (!dirMake.exists()) {
						dirMake.mkdir();
					}
					ProductVO pVo = null;
					ProductDAO pDAO = new ProductDAO();
					String fileName = "/image/product/" + selectedFile.getName();
					pVo = new ProductVO(productNum, tf_newproductname.getText(),
							Integer.parseInt(tf_newproductprice.getText().trim()), fileName);
					productNum++;
					pDAO = new ProductDAO();
					pDAO.addNewProduct(pVo);
					if (pDAO != null) {
						localUrl = "/image/default.png";
						localImage = new Image(localUrl, false);
						IV_picture.setImage(localImage);
						Alert alert;
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("상품 추가 완료");
						alert.setHeaderText("상품 추가 완료");
						alert.setContentText("상품 " + tf_newproductname.getText() + "이 추가되었습니다.");
						alert.showAndWait();
					}
					imageReset();
					imageButtonRefresh();
					dialog.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			});
			btn_addcancel.setOnAction(e -> {
				dialog.close();
			});
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void showEditPopup(ActionEvent event) throws Exception {
		try {
			p_data.removeAll();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/PosEdit.fxml"));
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btn_plus.getScene().getWindow());
			dialog.setTitle("상품 수정");
			Parent EDIT = (Parent) loader.load();
			TextField tf_editname = (TextField) EDIT.lookup("#tf_editname");
			TextField tf_editprice = (TextField) EDIT.lookup("#tf_editprice");
			ImageView IV_picture = (ImageView) EDIT.lookup("#IV_picture");
			Button btn_searchpath = (Button) EDIT.lookup("#btn_searchpath");
			Button btn_editconfirm = (Button) EDIT.lookup("#btn_editconfirm");
			Button btn_editcancel = (Button) EDIT.lookup("#btn_editcancel");
			TableView<ProductVO> edit_tableView = (TableView) EDIT.lookup("#edit_tableView");
			edit_tableView.setEditable(false);
			totalProductList();
			TableColumn coNo = new TableColumn("No.");
			coNo.setMaxWidth(140);
			coNo.setStyle("-fx-allignment: CENTER");
			coNo.setCellValueFactory(new PropertyValueFactory<>("productno"));
			TableColumn coName = new TableColumn("이름");
			coName.setMaxWidth(140);
			coName.setStyle("-fx-allignment: CENTER");
			coName.setCellValueFactory(new PropertyValueFactory<>("productname"));
			TableColumn coPrice = new TableColumn("가격");
			coPrice.setMaxWidth(80);
			coPrice.setStyle("-fx-allignment: CENTER");
			coPrice.setCellValueFactory(new PropertyValueFactory<>("productprice"));
			edit_tableView.getColumns().addAll(coNo, coName, coPrice);
			edit_tableView.setItems(p_data);
			Scene scene = new Scene(EDIT);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			btn_editconfirm.setDisable(true);
			edit_tableView.setOnMouseClicked(e -> {
				if (edit_tableView.hasProperties() == false) {
					return;
				}
				selectedMenu = edit_tableView.getSelectionModel().getSelectedItems();
				tf_editname.setText(selectedMenu.get(0).getProductname());
				tf_editprice.setText(selectedMenu.get(0).getProductprice() + "");
				String paths = selectedMenu.get(0).getProductpicpath();
				Image IMAGE = new Image(paths);
				IV_picture.setImage(IMAGE);
			});

			btn_searchpath.setOnAction(e -> {
				FileChooser fileChooser = new FileChooser();
				fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif"));
				try {
					selectedFile = fileChooser.showOpenDialog(primaryStage);
					if (selectedFile != null) {
						localUrl = selectedFile.toURI().toURL().toString();
					}
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				localImage = new Image(localUrl, false);
				IV_picture.setImage(localImage);
				btn_editconfirm.setDisable(false);
				if (selectedFile != null) {
					selectFileName = selectedFile.getName();
				}
			});

			btn_editconfirm.setOnAction(e -> {
				try {
					ProductVO pVo = null;
					ProductDAO pDAO = new ProductDAO();
					String fileName = "/image/product/" + selectedFile.getName();
					pVo = new ProductVO(selectedMenu.get(0).getProductno(), tf_editname.getText(),
							Integer.parseInt(tf_editprice.getText()), fileName);
					pDAO = new ProductDAO();
					pDAO.updateProduct(pVo, selectedMenu.get(0).getProductno());
					if (pDAO != null) {
						imageReset();
						imageButtonRefresh();
						localUrl = "/image/default.png";
						localImage = new Image(localUrl, false);
						IV_picture.setImage(localImage);
						Alert alert;
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("상품 수정 완료");
						alert.setHeaderText("상품 수정 완료");
						alert.setContentText("상품 " + tf_editname.getText() + "이 수정되었습니다.");
						alert.showAndWait();
					}
					dialog.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			});
			btn_editcancel.setOnAction(e -> {
				dialog.close();
			});
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void showDeletePopup(ActionEvent event) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/PosDelete.fxml"));
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btn_plus.getScene().getWindow());
			dialog.setTitle("상품 삭제");
			Parent EDIT = (Parent) loader.load();
			Button btn_delconfirm = (Button) EDIT.lookup("#btn_delconfirm");
			Button btn_delcancel = (Button) EDIT.lookup("#btn_delcancel");
			TableView<ProductVO> del_tableView = (TableView) EDIT.lookup("#del_tableView");
			del_tableView.setEditable(false);
			totalProductList();
			TableColumn coNo = new TableColumn("No.");
			coNo.setMaxWidth(140);
			coNo.setStyle("-fx-allignment: CENTER");
			coNo.setCellValueFactory(new PropertyValueFactory<>("productno"));
			TableColumn coName = new TableColumn("이름");
			coName.setMaxWidth(140);
			coName.setStyle("-fx-allignment: CENTER");
			coName.setCellValueFactory(new PropertyValueFactory<>("productname"));
			TableColumn coPrice = new TableColumn("가격");
			coPrice.setMaxWidth(80);
			coPrice.setStyle("-fx-allignment: CENTER");
			coPrice.setCellValueFactory(new PropertyValueFactory<>("productprice"));
			del_tableView.getColumns().addAll(coNo, coName, coPrice);
			del_tableView.setItems(p_data);
			Scene scene = new Scene(EDIT);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			del_tableView.setOnMouseClicked(e -> {
				if (del_tableView.hasProperties() == false) {
					return;
				}
				selectedMenu = del_tableView.getSelectionModel().getSelectedItems();
			});
			btn_delcancel.setOnAction(e -> {
				dialog.close();
			});
			btn_delconfirm.setOnAction(e -> {
				try {
					ProductDAO pDAO = new ProductDAO();
					pDAO = new ProductDAO();
					pDAO.deleteFromProduct(selectedMenu.get(0).getProductno());
					if (pDAO != null) {
						Alert alert;
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("상품 삭제 완료");
						alert.setHeaderText("상품 삭제 완료");
						alert.setContentText("선택한 상품이 삭제되었습니다.");
						alert.showAndWait();
					}
					imageReset();
					imageButtonRefresh();
					totalProductList();
					dialog.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPasswordPopup() throws Exception {
		Alert alert;
		alert = new Alert(AlertType.INFORMATION);
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/newpassword.fxml"));
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btn_plus.getScene().getWindow());
			dialog.setTitle("비밀번호 변경");
			Parent parentEdit = (Parent) loader.load();
			Button btn_passwordchange = (Button) parentEdit.lookup("#btn_passwordchange");
			Button btn_passwordcancel = (Button) parentEdit.lookup("#btn_passwordcancel");
			TextField tf_password = (TextField) parentEdit.lookup("#tf_password");
			TextField tf_newpassword = (TextField) parentEdit.lookup("#tf_newpassword");
			Scene scene = new Scene(parentEdit);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			btn_passwordchange.setOnAction(e -> {
				System.out.println(tf_newpassword.getText());
				try {
					if (LoginController.EqualPassword(tf_password.getText()) == true) {
						LoginController.setPasswordtoSQL(tf_newpassword.getText());
						dialog.close();
						alert.setTitle("비밀번호 변경 완료");
						alert.setHeaderText("비밀번호 변경 완료");
						alert.setContentText("로그인 비밀번호가 변경되었습니다.");
						alert.showAndWait();
					} else {
						alert.setTitle("비밀번호 변경 실패");
						alert.setHeaderText("비밀번호 변경 실패");
						alert.setContentText("기존 비밀번호가 틀립니다.\n\n다시 입력해주십시오.");
						alert.showAndWait();
					}
				} catch (Exception e2) {
					System.out.println(e2);
				}
			});
			btn_passwordcancel.setOnAction(e -> {
				dialog.close();
			});
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public String imageSave(File file) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		int data = -1;
		String fileName = null;
		try {
			// 이미지 파일명 생성
			fileName = "product" + System.currentTimeMillis() + "_" + file.getAbsolutePath();
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(dirSave.getAbsolutePath() + "\\" + fileName));
			// 선택한 이미지 파일 InputStream의 마지막에 이르렀을 경우는 -1
			while ((data = bis.read()) != -1) {
				bos.write(data);
				bos.flush();
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.getMessage();
			}
		}
		return fileName;
	}

	public void imageRefresh(int IMAGE, Image image) {
		switch (IMAGE) {
		case 0:
		case 1:
			IV_1.setImage(image);
			break;
		case 2:
			IV_2.setImage(image);
			break;
		case 3:
			IV_3.setImage(image);
			break;
		case 4:
			IV_4.setImage(image);
			break;
		case 5:
			IV_5.setImage(image);
			break;
		case 6:
			IV_6.setImage(image);
			break;
		case 7:
			IV_7.setImage(image);
			break;
		case 8:
			IV_8.setImage(image);
			break;
		case 9:
			IV_9.setImage(image);
			break;
		case 10:
			IV_10.setImage(image);
			break;
		case 11:
			IV_11.setImage(image);
			break;
		case 12:
			IV_12.setImage(image);
			break;
		case 13:
			IV_13.setImage(image);
			break;
		case 14:
			IV_14.setImage(image);
			break;
		case 15:
			IV_15.setImage(image);
			break;
		case 16:
			IV_16.setImage(image);
			break;
		case 17:
			IV_17.setImage(image);
			break;
		case 18:
			IV_18.setImage(image);
			break;
		case 19:
			IV_19.setImage(image);
			break;
		case 20:
			IV_20.setImage(image);
			break;
		case 21:
			IV_21.setImage(image);
			break;
		case 22:
			IV_22.setImage(image);
			break;
		case 23:
			IV_23.setImage(image);
			break;
		case 24:
			IV_24.setImage(image);
			break;
		case 25:
			IV_25.setImage(image);
			break;
		}
	}

	public void imageButtonRefresh() {
		for (int i = 0; i <= 25; i++) {
			switch (i) {
			case 1:
				IB_1.setGraphic(IV_1);
			case 2:
				IB_2.setGraphic(IV_2);
			case 3:
				IB_3.setGraphic(IV_3);
			case 4:
				IB_4.setGraphic(IV_4);
			case 5:
				IB_5.setGraphic(IV_5);
			case 6:
				IB_6.setGraphic(IV_6);
			case 7:
				IB_7.setGraphic(IV_7);
			case 8:
				IB_8.setGraphic(IV_8);
			case 9:
				IB_9.setGraphic(IV_9);
			case 10:
				IB_10.setGraphic(IV_10);
			case 11:
				IB_11.setGraphic(IV_11);
			case 12:
				IB_12.setGraphic(IV_12);
			case 13:
				IB_13.setGraphic(IV_13);
			case 14:
				IB_14.setGraphic(IV_14);
			case 15:
				IB_15.setGraphic(IV_15);
			case 16:
				IB_16.setGraphic(IV_16);
			case 17:
				IB_17.setGraphic(IV_17);
			case 18:
				IB_18.setGraphic(IV_18);
			case 19:
				IB_19.setGraphic(IV_19);
			case 20:
				IB_20.setGraphic(IV_20);
			case 21:
				IB_21.setGraphic(IV_21);
			case 22:
				IB_22.setGraphic(IV_22);
			case 23:
				IB_23.setGraphic(IV_23);
			case 24:
				IB_24.setGraphic(IV_24);
			case 25:
				IB_25.setGraphic(IV_25);
			}
		}
	}

	public void imageReset() throws Exception {
		ProductVO VO = new ProductVO();
		ProductDAO DAO = new ProductDAO();
		System.out.println("메뉴 사진을 불러오는 중...");
		existMenuNum = DAO.countProduct();
		for (int i = 1; i <= 25; i++) {
			VO = DAO.getProductCheck(i);
			if (VO != null) {
				String paths = VO.getProductpicpath();
				Image IMAGE = new Image(paths);
				imageRefresh(i, IMAGE);
				imageButtonRefresh();
			}
		}
	}

	public void orderTableView(int num) throws Exception {
		int check = 0;
		ProductDAO PDAO = new ProductDAO();
		OrderingVO VO = new OrderingVO();
		OrderingVO checkVO = new OrderingVO();
		OrderingVO checkedVO = new OrderingVO();
		OrderingDAO DAO = new OrderingDAO();
		ProductVO PVO = PDAO.getProductCheck(num);
		if (PVO == null) {
			existMenuNum = num;
			return;
		}
		VO.setOrderno(lastOrderNo);
		VO.setProductno(num);
		VO.setProductname(PVO.getProductname());
		VO.setProductprice(PVO.getProductprice());
		VO.setProductamount(1);
		ArrayList<OrderingVO> list;
		list = DAO.getOrderTotal(); // 전체 주문 내역을 조회.
		int rowCount = list.size();
		for (int index = 0; index < rowCount; index++) {
			checkVO = list.get(index); // checkVO에 전체 주문 내역을 하나하나 대입함.
			if (VO.getProductname().equals(checkVO.getProductname()) && VO.getOrderno() == checkVO.getOrderno()) {
				check = 1;
				checkedVO = list.get(index);
			}
		}
		try {
			if (check == 0) {
				DAO.addNewOrder(VO);
			} else {
				if (checkedVO.getOrderno() == lastOrderNo) {
					int amount = checkedVO.getProductamount();
					amount = amount + 1;
					checkedVO.setProductamount(amount);
					DAO.updateOrderingAmount(checkedVO, checkedVO.getProductno());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		totalOrderList();
	}

	public Button checkButton(int a) {
		switch (a) {
		case 1:
			return IB_1;
		case 2:
			return IB_2;
		case 3:
			return IB_3;
		case 4:
			return IB_4;
		case 5:
			return IB_5;
		case 6:
			return IB_6;
		case 7:
			return IB_7;
		case 8:
			return IB_8;
		case 9:
			return IB_9;
		case 10:
			return IB_10;
		case 11:
			return IB_11;
		case 12:
			return IB_12;
		case 13:
			return IB_13;
		case 14:
			return IB_14;
		case 15:
			return IB_15;
		case 16:
			return IB_16;
		case 17:
			return IB_17;
		case 18:
			return IB_18;
		case 19:
			return IB_19;
		case 20:
			return IB_20;
		case 21:
			return IB_21;
		case 22:
			return IB_22;
		case 23:
			return IB_23;
		case 24:
			return IB_24;
		case 25:
			return IB_25;
		default:
			break;
		}
		return IB_1;
	}

	public void checkMouseClicked(MouseEvent event) throws Exception {
		EventTarget target = event.getTarget();
		if (target == checkButton(1))
			orderTableView(1);
		else if (target == checkButton(2))
			orderTableView(2);
		else if (target == checkButton(3))
			orderTableView(3);
		else if (target == checkButton(4))
			orderTableView(4);
		else if (target == checkButton(5))
			orderTableView(5);
		else if (target == checkButton(6))
			orderTableView(6);
		else if (target == checkButton(7))
			orderTableView(7);
		else if (target == checkButton(8))
			orderTableView(8);
		else if (target == checkButton(9))
			orderTableView(9);
		else if (target == checkButton(10))
			orderTableView(10);
		else if (target == checkButton(11))
			orderTableView(11);
		else if (target == checkButton(12))
			orderTableView(12);
		else if (target == checkButton(13))
			orderTableView(13);
		else if (target == checkButton(14))
			orderTableView(14);
		else if (target == checkButton(15))
			orderTableView(15);
		else if (target == checkButton(16))
			orderTableView(16);
		else if (target == checkButton(17))
			orderTableView(17);
		else if (target == checkButton(18))
			orderTableView(18);
		else if (target == checkButton(19))
			orderTableView(19);
		else if (target == checkButton(20))
			orderTableView(20);
		else if (target == checkButton(21))
			orderTableView(21);
		else if (target == checkButton(22))
			orderTableView(22);
		else if (target == checkButton(23))
			orderTableView(23);
		else if (target == checkButton(24))
			orderTableView(24);
		else if (target == checkButton(25))
			orderTableView(25);
		imageButtonRefresh();
	}

	public void totalProductList() throws Exception {
		p_data.removeAll(p_data);
		ProductDAO DAO = new ProductDAO();
		ProductVO VO = new ProductVO();
		ArrayList<ProductVO> list;
		list = DAO.getProductTotal();
		int rowCount = list.size();
		for (int index = 0; index < rowCount; index++) {
			VO = list.get(index);
			p_data.add(VO);
		}
		existMenuNum = DAO.countProduct();
	}

	public void totalOrderList() {
		int checking = 0;
		int newPrice = 0;
		int price = 0;
		int acquire = 0;
		data.removeAll(data);
		OrderingDAO DAO = new OrderingDAO();
		OrderingVO VO = new OrderingVO();
		ArrayList<OrderingVO> list;
		list = DAO.getOrderTotal();
		int rowCount = list.size();
		for (int index = 0; index < rowCount; index++) {
			VO = list.get(index);
			if (VO.getOrderno() == lastOrderNo) {
				if (VO.getProductamount() != 0)
					data.add(VO);
				if (checking == 0) {
					if (VO.getProductprice() <= -1) {
						tf_discount.setText(Integer.parseInt(tf_discount.getText()) + VO.getProductprice() + "");
					}
					if (VO.getProductprice() >= 1) {
						price = VO.getProductprice() * VO.getProductamount();
						newPrice = newPrice + price;
					}
				}
			}
		}
		tf_totalsales.setText(newPrice + "");
		acquire = Integer.parseInt(tf_totalsales.getText()) + Integer.parseInt(tf_discount.getText());
		tf_acquire.setText(acquire + "");
	}

	public void txtMoneyReset() {
		tf_totalsales.setText("0");
		tf_discount.setText("0");
		tf_acquire.setText("0");
		tf_change.setText("0");
		tf_receivemoney.setText("0");
		tf_costamount.clear();
	}

	public void MakeExcel(ActionEvent event) {

		ProductDAO sDao = new ProductDAO();
		boolean saveSuccess;

		ArrayList<ProductVO> list;
		list = sDao.getProductTotal();

		ProductExcel excelWriter = new ProductExcel();

		saveSuccess = excelWriter.xlsxWiter(list, tf_savefiledir.getText());
		if (saveSuccess) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("엑셀 파일 생성");
			alert.setHeaderText("학생 목록 엑셀 파일 생성 성공.");
			alert.setContentText("학생 목록 엑셀 파일.");
			alert.showAndWait();
		}
		tf_savefiledir.clear();
		btn_excel.setDisable(true);
		btn_pdf.setDisable(true);
	}

	public void MakeProductPDF(ActionEvent event) {
		try {
			// pdf document 선언.
			// (Rectangle pageSize, float marginLeft, float marginRight, float
			// marginTop, float marginBottom)
			Document document = new Document(PageSize.A4, 0, 0, 30, 30);
			// pdf 파일을 저장할 공간을 선언. pdf파일이 생성된다. 그후 스트림으로 저장.
			String strReportPDFName = "product_" + System.currentTimeMillis() + ".pdf";
			PdfWriter.getInstance(document, new FileOutputStream(tf_savefiledir.getText() + "\\" + strReportPDFName));
			// document를 열어 pdf문서를 쓸수있도록한다..
			document.open();
			// 한글지원폰트 설정..
			BaseFont bf = BaseFont.createFont("font/MALGUN.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 8, Font.NORMAL);
			Font font2 = new Font(bf, 14, Font.BOLD);
			// 타이틀
			Paragraph title = new Paragraph("상품", font2);
			// 중간정렬
			title.setAlignment(Element.ALIGN_CENTER);
			// 문서에 추가
			document.add(title);
			document.add(new Paragraph("\r\n"));
			// 생성 날짜
			Date date = new Date();
			Paragraph writeDay = new Paragraph(date.toString(), font);
			// 오른쪽 정렬
			writeDay.setAlignment(Element.ALIGN_RIGHT);
			// 문서에 추가
			document.add(writeDay);
			document.add(new Paragraph("\r\n"));

			// 테이블생성 Table객체보다 PdfPTable객체가 더 정교하게 테이블을 만들수 있다.
			// 생성자에 컬럼수를 써준다.
			PdfPTable table = new PdfPTable(4);
			// 각각의 컬럼에 width를 정한다.
			table.setWidths(new int[] { 30, 50, 30, 100 });

			// 컬럼 타이틀..
			PdfPCell header1 = new PdfPCell(new Paragraph("상품 번호", font));
			PdfPCell header2 = new PdfPCell(new Paragraph("상품명", font));
			PdfPCell header3 = new PdfPCell(new Paragraph("상품 가격", font));
			PdfPCell header4 = new PdfPCell(new Paragraph("사진 주소", font));
			// 가로정렬
			header1.setHorizontalAlignment(Element.ALIGN_CENTER);
			header2.setHorizontalAlignment(Element.ALIGN_CENTER);
			header3.setHorizontalAlignment(Element.ALIGN_CENTER);
			header4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// 세로정렬
			header1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// 테이블에 추가..
			table.addCell(header1);
			table.addCell(header2);
			table.addCell(header3);
			table.addCell(header4);
			// DB 연결 및 리스트 선택
			ProductDAO sDao = new ProductDAO();
			ProductVO sVo = new ProductVO();
			ArrayList<ProductVO> list;
			list = sDao.getProductTotal();
			int rowCount = list.size();

			PdfPCell cell1 = null;
			PdfPCell cell2 = null;
			PdfPCell cell3 = null;
			PdfPCell cell4 = null;
			for (int index = 0; index < rowCount; index++) {

				sVo = list.get(index);

				cell1 = new PdfPCell(new Paragraph(sVo.getProductno() + "", font));
				cell2 = new PdfPCell(new Paragraph(sVo.getProductname(), font));
				cell3 = new PdfPCell(new Paragraph(sVo.getProductprice() + "", font));
				cell4 = new PdfPCell(new Paragraph(sVo.getProductpicpath(), font));
				// 가로정렬
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				// 세로정렬
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				// 테이블에 셀 추가
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
			}
			// 문서에 테이블추가..
			document.add(table);
			// 문서를 닫는다.. 쓰기 종료..
			document.close();
			tf_savefiledir.clear();
			btn_pdf.setDisable(true);
			btn_excel.setDisable(true);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("PDF 파일 생성");
			alert.setHeaderText("상품 목록 PDF 파일 생성 성공.");
			alert.setContentText("상품 목록 PDF 파일.");
			alert.showAndWait();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void MakeOrderPDF(ActionEvent event) {
		try {
			// pdf document 선언.
			// (Rectangle pageSize, float marginLeft, float marginRight, float
			// marginTop, float marginBottom)
			File pdfDIR = new File("F:/MellowBrunchPOS/src/PDFs/");
			Document document = new Document(PageSize.A4, 0, 0, 30, 30);
			// pdf 파일을 저장할 공간을 선언. pdf파일이 생성된다. 그후 스트림으로 저장.
			String strReportPDFName = "order_" + System.currentTimeMillis() + ".pdf";
			if (tf_savefiledir.getText().equals("")) {
				PdfWriter.getInstance(document, new FileOutputStream(pdfDIR + "\\" + strReportPDFName));
			} else {
				PdfWriter.getInstance(document,
						new FileOutputStream(tf_savefiledir.getText() + "\\" + strReportPDFName));
			}
			// document를 열어 pdf문서를 쓸수있도록한다..
			document.open();
			// 한글지원폰트 설정..
			BaseFont bf = BaseFont.createFont("font/MALGUN.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 8, Font.NORMAL);
			Font font2 = new Font(bf, 14, Font.BOLD);
			// 타이틀
			Paragraph title = new Paragraph("주문 내역", font2);
			// 중간정렬
			title.setAlignment(Element.ALIGN_CENTER);
			// 문서에 추가
			document.add(title);
			document.add(new Paragraph("\r\n"));
			// 생성 날짜
			Date date = new Date();
			Paragraph writeDay = new Paragraph(date.toString(), font);
			// 오른쪽 정렬
			writeDay.setAlignment(Element.ALIGN_RIGHT);
			// 문서에 추가
			document.add(writeDay);
			document.add(new Paragraph("\r\n"));
			// 테이블생성 Table객체보다 PdfPTable객체가 더 정교하게 테이블을 만들수 있다.
			// 생성자에 컬럼수를 써준다.
			PdfPTable table = new PdfPTable(5);
			// 각각의 컬럼에 width를 정한다.
			table.setWidths(new int[] { 30, 50, 30, 50, 30 });
			// 컬럼 타이틀..
			PdfPCell header1 = new PdfPCell(new Paragraph("주문 번호", font));
			PdfPCell header2 = new PdfPCell(new Paragraph("상품 번호", font));
			PdfPCell header3 = new PdfPCell(new Paragraph("상품명", font));
			PdfPCell header4 = new PdfPCell(new Paragraph("상품 가격", font));
			PdfPCell header5 = new PdfPCell(new Paragraph("상품 갯수", font));
			// 가로정렬
			header1.setHorizontalAlignment(Element.ALIGN_CENTER);
			header2.setHorizontalAlignment(Element.ALIGN_CENTER);
			header3.setHorizontalAlignment(Element.ALIGN_CENTER);
			header4.setHorizontalAlignment(Element.ALIGN_CENTER);
			header5.setHorizontalAlignment(Element.ALIGN_CENTER);
			// 세로정렬
			header1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// 테이블에 추가..
			table.addCell(header1);
			table.addCell(header2);
			table.addCell(header3);
			table.addCell(header4);
			table.addCell(header5);
			// DB 연결 및 리스트 선택
			OrderingDAO sDao = new OrderingDAO();
			OrderingVO sVo = new OrderingVO();
			ArrayList<OrderingVO> list;
			list = sDao.getOrderTotal();
			int rowCount = list.size();

			PdfPCell cell1 = null;
			PdfPCell cell2 = null;
			PdfPCell cell3 = null;
			PdfPCell cell4 = null;
			PdfPCell cell5 = null;
			for (int index = 0; index < rowCount; index++) {
				sVo = list.get(index);
				if (sVo.getOrderno() == lastOrderNo) {
					cell1 = new PdfPCell(new Paragraph(sVo.getOrderno() + "", font));
					cell2 = new PdfPCell(new Paragraph(sVo.getProductno() + "", font));
					cell3 = new PdfPCell(new Paragraph(sVo.getProductname(), font));
					cell4 = new PdfPCell(new Paragraph(sVo.getProductprice() + "", font));
					cell5 = new PdfPCell(new Paragraph(sVo.getProductamount() + "", font));
					// 가로정렬
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					// 세로정렬
					cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
					// 테이블에 셀 추가
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
				}
			}
			// 문서에 테이블추가..
			document.add(table);
			document.add(new Paragraph("\r\n"));
			PdfPTable tableCost = new PdfPTable(5);
			// 각각의 컬럼에 width를 정한다.
			tableCost.setWidths(new int[] { 50, 50, 50, 50, 50 });
			// 컬럼 타이틀..
			PdfPCell header1_c = new PdfPCell(new Paragraph("전체 금액", font));
			PdfPCell header2_c = new PdfPCell(new Paragraph("할인 금액", font));
			PdfPCell header3_c = new PdfPCell(new Paragraph("받을 금액", font));
			PdfPCell header4_c = new PdfPCell(new Paragraph("받은 금액", font));
			PdfPCell header5_c = new PdfPCell(new Paragraph("거스름돈", font));
			// 가로정렬
			header1_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			header2_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			header3_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			header4_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			header5_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			// 세로정렬
			header1_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header2_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header3_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header4_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header5_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// 테이블에 추가..
			tableCost.addCell(header1_c);
			tableCost.addCell(header2_c);
			tableCost.addCell(header3_c);
			tableCost.addCell(header4_c);
			tableCost.addCell(header5_c);
			// DB 연결 및 리스트 선택
			PdfPCell cell1_c = null;
			PdfPCell cell2_c = null;
			PdfPCell cell3_c = null;
			PdfPCell cell4_c = null;
			PdfPCell cell5_c = null;

			cell1_c = new PdfPCell(new Paragraph(tf_totalsales.getText(), font));
			cell2_c = new PdfPCell(new Paragraph(tf_discount.getText(), font));
			cell3_c = new PdfPCell(new Paragraph(tf_acquire.getText(), font));
			cell4_c = new PdfPCell(new Paragraph(tf_receivemoney.getText(), font));
			cell5_c = new PdfPCell(new Paragraph(tf_change.getText(), font));
			// 가로정렬
			cell1_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			cell2_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			cell3_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			cell4_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			cell5_c.setHorizontalAlignment(Element.ALIGN_BOTTOM);
			// 세로정렬
			cell1_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell2_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell3_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell4_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell5_c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// 테이블에 셀 추가
			tableCost.addCell(cell1_c);
			tableCost.addCell(cell2_c);
			tableCost.addCell(cell3_c);
			tableCost.addCell(cell4_c);
			tableCost.addCell(cell5_c);
			// 문서를 닫는다.. 쓰기 종료..
			document.add(tableCost);
			document.close();
			tf_savefiledir.clear();
			btn_pdf.setDisable(true);
			btn_excel.setDisable(true);
			System.out.println("주문 내역 PDF 생성 성공.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SaveFileDIR(ActionEvent event) {

		final DirectoryChooser directoryChooser = new DirectoryChooser();
		final File selectedDirectory = directoryChooser.showDialog(primaryStage);
		if (selectedDirectory != null) {
			tf_savefiledir.setText(selectedDirectory.getAbsolutePath());
			btn_excel.setDisable(false);
			btn_pdf.setDisable(false);
		}

	}
}