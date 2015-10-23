package lab04;
//Name -

//Date -
//Class -
//Lab  -
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import javax.swing.JOptionPane;
import java.io.IOException;

public class NameChanger {
	//Translator translate = Translator.getInstance();
	String translatedText = new String();
	String first = "";
	String last = "";
	String sport = "";
	int[] asci;
	char[] charr;

	public NameChanger(String f, String l, String spor) throws IOException {
		first = f;
		last = l;
		sport = spor;
		charr = new char[first.length() - 1];
		asci = new int[first.length() - 1];

		for (int i = 0; i < first.length() - 1; i++) {
			charr[i] = first.charAt(i);
			asci[i] = (int) charr[i];
		}

	}


	public void scramble() {
		last = last.replace(last.charAt(last.length() - 1), 'z');
	}

	public void setNames(String f, String l) {
		first = f;
		last = l;
		for (int i = 0; i < first.length() - 1; i++) {
			charr[i] = first.charAt(i);
			asci[i] = (int) charr[i];
		}
	}

	public void reverse() {
		String temp = "";
		String tempp = "";
		for (int i = first.length() - 1; i >= 0; i--) {
			temp += first.substring(i, i + 1);
		}
		first = temp;
		tempp += last.substring(last.length() / 2);
		tempp += last.substring(0, last.length() / 2);
		last = tempp;

	}

	private void showError(String err) {
		JOptionPane.showMessageDialog(null, "Unfortunately there is an error: \n" + err, "Error reading the text",
				JOptionPane.WARNING_MESSAGE);
	}

	public String toString() {
		String out = "";
		for (int i = 0; i < asci.length; i++)
			System.out.print(asci[i]);
			out += "\n\nLast name: " + last + "\n\nSport:" + translatedText;
			return out;

		}

		// TODO Auto-generated method stub

	}
