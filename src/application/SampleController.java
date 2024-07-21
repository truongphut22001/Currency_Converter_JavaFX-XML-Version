package application;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SampleController {
	@FXML
	private TextField textField1;

	@FXML
	private TextField textField2;

	@FXML
	private TextField textField3;

	@FXML
	private TextField textField4;

	@FXML
	private TextField textField5;

	@FXML
	private TextField textField6;

	@FXML
	private MenuButton menuButton1;

	@FXML
	private MenuButton menuButton2;

	@FXML
	private MenuButton menuButton3;

	@FXML
	private MenuButton menuButton4;

	@FXML
	private MenuButton menuButton5;

	@FXML
	private MenuButton selectedMenuButton;

	@FXML
	private TextField selectedTextField;

	@FXML
	private ImageView imageview1;

	@FXML
	private ImageView imageview2;

	@FXML
	private ImageView imageview3;

	@FXML
	private ImageView imageview4;

	@FXML
	private ImageView imageview5;

	@FXML
	private Image vndFlag = new Image("application/Flag_of_Vietnam.svg.png");

	@FXML
	private Image usdFlag = new Image("application/Flag_of_the_United_States.png");

	@FXML
	private Image audFlag = new Image("application/Flag_of_Victoria_(Australia).svg.png");

	@FXML
	private Image jpyFlag = new Image("application/2560px-Japan_flag_-_variant.png");

	@FXML
	private Image krwFlag = new Image("application/Flag_of_South_Korea.png");

	private ObservableList<String> items = FXCollections.observableArrayList();

	public String formatNumber(Double n) {
		if (n % 1 == 0) {
			int intNumber = n.intValue();
			DecimalFormat decimalFormat = new DecimalFormat("#,##0");
			return decimalFormat.format(intNumber);
		}
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
		return decimalFormat.format(n);
	}

	@FXML
	private void handleNumberButton(ActionEvent event) {
		Button button = (Button) event.getSource();
		String buttonText = button.getText();

		// Lấy văn bản hiện tại trong textField1
		String currentText = textField1.getText();

		// Thêm số vừa click vào văn bản hiện tại
		currentText += buttonText;

		// Chỉnh sửa văn bản để thêm dấu phẩy ngăn cách hàng ngàn
		String formattedText = addThousandSeparator(currentText);

		// Cập nhật văn bản trong textField1
		textField1.setText(formattedText);
	}

	private String addThousandSeparator(String text) {
		// Kiểm tra xem văn bản có dấu phẩy không
		boolean hasComma = text.contains(",");

		// Tạo một đối tượng DecimalFormat với mẫu "#,###" để thêm dấu phẩy phân cách
		// hàng ngàn
		DecimalFormat decimalFormat = new DecimalFormat("#,###");

		// Chuyển đổi văn bản thành số nguyên
		BigInteger number;
		try {
			// Xóa dấu phẩy nếu có
			number = new BigInteger(text.replace(",", ""));
		} catch (NumberFormatException e) {
			// Trường hợp số không hợp lệ, trả về văn bản không thay đổi
			return text;
		}

		// Định dạng số nguyên để thêm dấu phẩy
		String formattedNumber = decimalFormat.format(number);

		// Nếu văn bản ban đầu có dấu phẩy, hãy trả về kết quả với dấu phẩy
		if (hasComma) {
			return formattedNumber;
		}

		// Nếu không, hãy xóa dấu phẩy cuối cùng
		return formattedNumber.replaceAll(",$", "");
	}

	@FXML
	private void handleDotButton(ActionEvent event) {
		Button button = (Button) event.getSource();
		String buttonText = button.getText();
		if (!textField1.getText().contains(".")) {
			textField1.appendText(buttonText);
		}
	}

	public void setCurrencyFlagImg(String menuItemText) {
		if (menuItemText.equals("VND")) {
			imageview1.setImage(vndFlag);
		}
		if (menuItemText.equals("USD")) {
			imageview1.setImage(krwFlag);
		}
		if (menuItemText.equals("AUD")) {
			imageview1.setImage(audFlag);
		}
		if (menuItemText.equals("JPY")) {
			imageview1.setImage(jpyFlag);
		}
		if (menuItemText.equals("KRW")) {
			imageview1.setImage(krwFlag);
		}
	}

	@FXML
	private void handleMenuItemClick1(ActionEvent event) {
		MenuItem menuItem = (MenuItem) event.getSource();
		String menuItemText = menuItem.getText();
		menuButton1.setText(menuItemText);
		if (menuItemText.equals("VND")) {
			imageview1.setImage(vndFlag);
		}
		if (menuItemText.equals("USD")) {
			imageview1.setImage(usdFlag);
		}
		if (menuItemText.equals("AUD")) {
			imageview1.setImage(audFlag);
		}
		if (menuItemText.equals("JPY")) {
			imageview1.setImage(jpyFlag);
		}
		if (menuItemText.equals("KRW")) {
			imageview1.setImage(krwFlag);
		}

	}

	@FXML
	private void handleMenuItemClick2(ActionEvent event) {
		MenuItem menuItem = (MenuItem) event.getSource();
		String menuItemText = menuItem.getText();
		menuButton2.setText(menuItemText);
		if (menuItemText.equals("VND")) {
			imageview2.setImage(vndFlag);
		}
		if (menuItemText.equals("USD")) {
			imageview2.setImage(usdFlag);
		}
		if (menuItemText.equals("AUD")) {
			imageview2.setImage(audFlag);
		}
		if (menuItemText.equals("JPY")) {
			imageview2.setImage(jpyFlag);
		}
		if (menuItemText.equals("KRW")) {
			imageview2.setImage(krwFlag);
		}
	}

	@FXML
	private void handleMenuItemClick3(ActionEvent event) {
		MenuItem menuItem = (MenuItem) event.getSource();
		String menuItemText = menuItem.getText();
		menuButton3.setText(menuItemText);
		if (menuItemText.equals("VND")) {
			imageview3.setImage(vndFlag);
		}
		if (menuItemText.equals("USD")) {
			imageview3.setImage(usdFlag);
		}
		if (menuItemText.equals("AUD")) {
			imageview3.setImage(audFlag);
		}
		if (menuItemText.equals("JPY")) {
			imageview3.setImage(jpyFlag);
		}
		if (menuItemText.equals("KRW")) {
			imageview3.setImage(krwFlag);
		}
	}

	@FXML
	private void handleMenuItemClick4(ActionEvent event) {
		MenuItem menuItem = (MenuItem) event.getSource();
		String menuItemText = menuItem.getText();
		menuButton4.setText(menuItemText);
		if (menuItemText.equals("VND")) {
			imageview4.setImage(vndFlag);
		}
		if (menuItemText.equals("USD")) {
			imageview4.setImage(usdFlag);
		}
		if (menuItemText.equals("AUD")) {
			imageview4.setImage(audFlag);
		}
		if (menuItemText.equals("JPY")) {
			imageview4.setImage(jpyFlag);
		}
		if (menuItemText.equals("KRW")) {
			imageview4.setImage(krwFlag);
		}
	}

	@FXML
	private void handleMenuItemClick5(ActionEvent event) {
		MenuItem menuItem = (MenuItem) event.getSource();
		String menuItemText = menuItem.getText();
		menuButton5.setText(menuItemText);
		if (menuItemText.equals("VND")) {
			imageview5.setImage(vndFlag);
		}
		if (menuItemText.equals("USD")) {
			imageview5.setImage(usdFlag);
		}
		if (menuItemText.equals("AUD")) {
			imageview5.setImage(audFlag);
		}
		if (menuItemText.equals("JPY")) {
			imageview5.setImage(jpyFlag);
		}
		if (menuItemText.equals("KRW")) {
			imageview5.setImage(krwFlag);
		}
	}

	@FXML
	private void handleDelButton(ActionEvent event) {
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
	}

	public static final double USDTOVND = 25335;
	public static final double USDTOAUD = 1.53;
	public static final double USDTOJPY = 155.56;
	public static final double USDTOKRW = 1376.12;
	double amountInUSD = 0.0;
	double amountVND = 0.0;
	double amountUSD = 0.0;
	double amountAUD = 0.0;
	double amountJPY = 0.0;
	double amountKRW = 0.0;

	@FXML
	private void handleExchangeButton(ActionEvent event) {
		// checkTextField1 to get currency
		checkTextField1();
		exchangeTextField2();
		exchangeTextField3();
		exchangeTextField4();
		exchangeTextField5();
		String reString = textField1.getText() + menuButton1.getText() + " = " + textField2.getText()
				+ menuButton2.getText() + " = " + textField3.getText() + menuButton3.getText() + " = "
				+ textField4.getText() + menuButton4.getText() + " = " + textField5.getText() + menuButton5.getText();
		// Add the values from text fields to the observable list
		items.add(0, reString);
	}

	@FXML
	private void handleHistoryButton(ActionEvent event) throws IOException {
		try {
			// Load the FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
			Parent root = loader.load();

			// Get the controller for history.fxml
			HistoryController historyController;
			historyController = loader.getController();

			// Add the values from text fields to the observable list
			historyController.viewList(items);

			// Create a new stage for history window
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("History");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkTextField1() {
		if (menuButton1.getText().equals("VND")) {
			amountInUSD = 1 / (USDTOVND) * Double.parseDouble(textField1.getText().replace(",", ""));
		}

		if (menuButton1.getText().equals("USD")) {
			amountInUSD = Double.parseDouble(textField1.getText().replace(",", ""));
		}

		if (menuButton1.getText().equals("AUD")) {
			amountInUSD = 1 / (USDTOAUD) * Double.parseDouble(textField1.getText().replace(",", ""));
		}

		if (menuButton1.getText().equals("JPY")) {
			amountInUSD = 1 / (USDTOJPY) * Double.parseDouble(textField1.getText().replace(",", ""));
		}

		if (menuButton1.getText().equals("KRW")) {
			amountInUSD = 1 / (USDTOKRW) * Double.parseDouble(textField1.getText().replace(",", ""));
		}
		amountVND = USDTOVND * amountInUSD;
		amountUSD = amountInUSD;
		amountAUD = USDTOAUD * amountInUSD;
		amountJPY = USDTOJPY * amountInUSD;
		amountKRW = USDTOKRW * amountInUSD;
	}

	public void exchangeTextField2() {
		switch (menuButton2.getText()) {
		case "VND":
			textField2.setText(formatNumber(amountVND));
			break;

		case "USD":
			textField2.setText(formatNumber(amountUSD));
			break;

		case "AUD":
			textField2.setText(formatNumber(amountAUD));
			break;

		case "JPY":
			textField2.setText(formatNumber(amountJPY));
			break;

		case "KRW":
			textField2.setText(formatNumber(amountKRW));
			break;

		default:
			break;
		}
	}

	public void exchangeTextField3() {
		switch (menuButton3.getText()) {
		case "VND":
			textField3.setText(formatNumber(amountVND));
			break;

		case "USD":
			textField3.setText(formatNumber(amountUSD));
			break;

		case "AUD":
			textField3.setText(formatNumber(amountAUD));
			break;

		case "JPY":
			textField3.setText(formatNumber(amountJPY));
			break;

		case "KRW":
			textField3.setText(formatNumber(amountKRW));
			break;

		default:
			break;
		}
	}

	public void exchangeTextField4() {
		switch (menuButton4.getText()) {
		case "VND":
			textField4.setText(formatNumber(amountVND));
			break;

		case "USD":
			textField4.setText(formatNumber(amountUSD));
			break;

		case "AUD":
			textField4.setText(formatNumber(amountAUD));
			break;

		case "JPY":
			textField4.setText(formatNumber(amountJPY));
			break;

		case "KRW":
			textField4.setText(formatNumber(amountKRW));
			break;

		default:
			break;
		}
	}

	public void exchangeTextField5() {
		switch (menuButton5.getText()) {
		case "VND":
			textField5.setText(formatNumber(amountVND));
			break;

		case "USD":
			textField5.setText(formatNumber(amountUSD));
			break;

		case "AUD":
			textField5.setText(formatNumber(amountAUD));
			break;

		case "JPY":
			textField5.setText(formatNumber(amountJPY));
			break;

		case "KRW":
			textField5.setText(formatNumber(amountKRW));
			break;

		default:
			break;
		}
	}
}
