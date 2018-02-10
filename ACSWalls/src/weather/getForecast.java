package weather;

import com.temboo.Library.Yahoo.Weather.GetWeatherByAddress;
import com.temboo.Library.Yahoo.Weather.GetWeatherByAddress.GetWeatherByAddressInputSet;
import com.temboo.Library.Yahoo.Weather.GetWeatherByAddress.GetWeatherByAddressResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

public class getForecast 
{
	private String address = "";
	private String cond = "";
	private String forcast = "";
	private String hi = "";
	private String humid = "";
	private String low = "";
	private String pressure = "";
	private String temperature = "";
	private String visibility = "";
	private String woeid = "";
	private String outs = "";
	public getForecast(String add)
	{
		address = add;
	}
	public void getFor() throws TembooException
	{
		// Instantiate the Choreo, using a previously instantiated TembooSession object, eg:
		TembooSession session = new TembooSession("mwalls1", "myFirstApp", "3c25cb87eaee46ebaf2670726c16b71c");

		GetWeatherByAddress getWeatherByAddressChoreo = new GetWeatherByAddress(session);

		// Get an InputSet object for the choreo
		GetWeatherByAddressInputSet getWeatherByAddressInputs = getWeatherByAddressChoreo.newInputSet();

		// Set inputs
		getWeatherByAddressInputs.set_Address(address);

		// Execute Choreo
		GetWeatherByAddressResultSet getWeatherByAddressResults = getWeatherByAddressChoreo.execute(getWeatherByAddressInputs);
		cond += getWeatherByAddressResults.get_ConditionText();
		forcast += getWeatherByAddressResults.get_ForecastText();
		hi += getWeatherByAddressResults.get_High();
		humid += getWeatherByAddressResults.get_Humidity();
		low += getWeatherByAddressResults.get_Low();
		pressure += getWeatherByAddressResults.get_Pressure();
		temperature += getWeatherByAddressResults.get_Temperature();
		visibility += getWeatherByAddressResults.get_Visibility();
		woeid += getWeatherByAddressResults.get_WOEID();
	}
	public String toString()
	{
		return "Address: "+address+"\nCondition: "+cond+"\nForecast: "+forcast+"\nHigh: "+hi+"\nHumidity: "+humid+"\nLow: "+low+"\nPressure: "+pressure+"\nTemperature: "+temperature+"\nVisibility: "+visibility+"\nWOEID: "+woeid;
		
	}
}
