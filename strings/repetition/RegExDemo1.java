import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo1 {
	public String text;
	public static void main(String[] args) {
		RegExDemo1 textObject = new RegExDemo1();
		List<String> tokens = new ArrayList<>();
		textObject.text = new String("Hello hello?");
		tokens = textObject.getTokens("e");
		if(tokens != null){
			System.out.println(tokens.toString());;
		}
	}
	
	public List<String> getTokens(String pattern){
		Pattern regularExp = Pattern.compile(pattern);
		Matcher matcher = regularExp.matcher(text);
		List<String> tokensList = new ArrayList<>();
		while (matcher.find()) {
			tokensList.add(matcher.group());
		}
		return tokensList;
	}

}
