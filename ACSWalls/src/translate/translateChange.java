package translate;

import com.temboo.Library.Microsoft.Translator.Translate;
import com.temboo.Library.Microsoft.Translator.Translate.TranslateInputSet;
import com.temboo.Library.Microsoft.Translator.Translate.TranslateResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

public class translateChange {
	private String text = "";
	private String tranText = "";
	public translateChange(String s)
	{
		text = s;
	}
	public void translate() throws TembooException
	{
		// Instantiate the Choreo, using a previously instantiated TembooSession object, eg:
		TembooSession session = new TembooSession("mwalls1", "myFirstApp", "3c25cb87eaee46ebaf2670726c16b71c");

		Translate translateChoreo = new Translate(session);

		// Get an InputSet object for the choreo
		TranslateInputSet translateInputs = translateChoreo.newInputSet();

		// Set inputs
		translateInputs.set_Text(text);
		translateInputs.set_ClientSecret("translatorACS1234567");
		translateInputs.set_To("ar");
		translateInputs.set_ClientID("1mwalls");
		translateInputs.set_From("en");

		// Execute Choreo
		TranslateResultSet translateResults = translateChoreo.execute(translateInputs);
		tranText = translateResults.get_TranslatedText();
	}
	public String toString()
	{
		String output = "";
		output+="Original String: "+text+"\n\n"+"Translated Text: "+tranText;
		return output;
	}

}

