package weather;

import com.temboo.Library.Yahoo.Weather.GetTemperature;
import com.temboo.Library.Yahoo.Weather.GetTemperature.GetTemperatureInputSet;
import com.temboo.Library.Yahoo.Weather.GetTemperature.GetTemperatureResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

public class testTambooWeather
{
	private String address;
	public testTambooWeather(String add)
	{
		address = add;
	}
	public String getTemp() throws TembooException
	{
		TembooSession session = new TembooSession("mwalls1", "myFirstApp", "3c25cb87eaee46ebaf2670726c16b71c");

		GetTemperature getTemperatureChoreo = new GetTemperature(session);

		// Get an InputSet object for the choreo
		GetTemperatureInputSet getTemperatureInputs = getTemperatureChoreo.newInputSet();

		// Set inputs
		getTemperatureInputs.set_Address(address);

		// Execute Choreo
		GetTemperatureResultSet getTemperatureResults = getTemperatureChoreo.execute(getTemperatureInputs);
		return getTemperatureResults.get_Temperature();
	}

}


