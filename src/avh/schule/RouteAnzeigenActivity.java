package avh.schule;

import java.util.ArrayList;
import java.util.Vector;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class RouteAnzeigenActivity extends ListActivity{

	private String[] anzeigeListe;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		anzeigeListe = extras.getStringArray("anzeigeListe");
		
		
		
		
		setListAdapter(new ArrayAdapter<String>(this,R.layout.listitem, R.id.tvListItem ,anzeigeListe ));
	}
	
	
}
