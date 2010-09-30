package net.sweetmonster.android.hocuspocusdroid;

import net.sweetmonster.android.automagicdroid.R;
import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class AutomagicDroid extends TabActivity implements
		TabHost.TabContentFactory {

	TextView mProgressText;
	TextView mTrackingText;
	Context c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); 
		tabHost.setup();
//		
//		TabHost.TabSpec spec = tabs.newTabSpec("tag1");
//		spec.setContent(R.id.Tab1ListLayout);
		//spec.setIndicator("Tab 1");
		//tabs.addTab(spec);
		
		//spec = tabs.newTabSpec("tag2");
		//spec.setContent(R.id.tab2);
		//spec.setIndicator("Tab 2");
		//tabs.addTab(spec);

		 c = getApplicationContext();
		
		 //final TabHost tabHost = getTabHost();
		 //tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("tab1") // ,
		 // getResources().getDrawable(R.drawable.star_big_on))
		 //.setContent(R.layout.main));
		 tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("tab2")
		 .setContent(this));
		 tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab3")
		 .setContent(this));
	}

	public View createTabContent(String tag) {
		final TextView tv = new TextView(this);
		tv.setText("Content for tab with tag " + tag);

		LinearLayout l = new LinearLayout(c);

		SeekBar[] mSeekBar = new SeekBar[5];

		for (int i = 0; i < 5; i++) {

			mSeekBar[i] = new SeekBar(c);

			mSeekBar[i]
					.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

						public void onStopTrackingTouch(SeekBar seekBar) {
							// TODO Auto-generated method stub
							// mTrackingText.setText("qq5");
						}

						public void onStartTrackingTouch(SeekBar seekBar) {
							// mTrackingText.setText("qq2");
						}

						public void onProgressChanged(SeekBar seekBar,
								int progress, boolean fromUser) {
							// mProgressText.setText(progress + " " + "q1");
							// getString( R.string.seekbar_from_touch "q1")
						}

					});

			l.addView(mSeekBar[i]);
		}

		return l;
	}

}
