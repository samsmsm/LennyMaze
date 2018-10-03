package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class finder extends Block {

	public finder(int x, int y) {
		Circle r = new Circle(15);
		r.setFill(Color.ORANGE);
		this.setTranslateX(x * Block.SIZE + Block.SIZE / 2);
		this.setTranslateY(y * Block.SIZE + Block.SIZE / 2);
		Text t = new Text("( ͡° ͜ʖ ͡°)");
		t.setTranslateX(t.getTranslateX() - 16);
		t.setTranslateY(t.getTranslateY() + 4);
		t.setFont(new Font(12));
		t.setFill(Color.BLACK);
		this.getChildren().addAll(r, t);
	}

}