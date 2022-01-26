package ua.com.sourceit.str;
import static java.lang.System.out;

//String str = String.format("%s : %d", "Petya", 25);
//out.println(str);

public class search {

	public static void main(String[] args) {
		String s = "Мы знаем, что монохромный цвет - это градации серого";
		String txt = "хром";
		String word;
		int indexTxt = s.indexOf(txt);
		if (indexTxt > -1) {
			int wordFirstIndex  = s.lastIndexOf(" ", indexTxt) + 1;
			int wordlastIndex = s.indexOf(" ", indexTxt);
			word = s.substring(wordFirstIndex, wordlastIndex);           
			out.println(word);
		} else {
			out.println("Sorry, but your word was not found");
		}
	}

}
