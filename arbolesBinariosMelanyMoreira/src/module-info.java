module QuickSort {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens controler to javafx.fxml;
	opens aplication to javafx.graphics, javafx.fxml;
}
