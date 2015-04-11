package com.example.jumpbar;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class JumpBarMain extends ActionBarActivity {
	private int BTN_START_ID = 0x1;
	private BeatView mBeatView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jump_bar_main);
		
		mBeatView = (BeatView) findViewById(R.id.beatView);

		Button start = new Button(this);
		RelativeLayout.LayoutParams startParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		startParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		start.setLayoutParams(startParams);
		start.setText("START");
		start.setTextColor(Color.WHITE);
		start.setBackgroundColor(Color.RED);
		start.setOnClickListener(new ClickListener());
		start.setId(BTN_START_ID);
		((RelativeLayout) findViewById(R.id.jump_bar_main)).addView(start);
		
		Button pause = new Button(this);
		RelativeLayout.LayoutParams pauseParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		pauseParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		pauseParams.addRule(RelativeLayout.RIGHT_OF, BTN_START_ID);
		pause.setLayoutParams(pauseParams);
		pause.setText("PAUSE");
		pause.setTextColor(Color.WHITE);
		pause.setBackgroundColor(Color.RED);
		pause.setOnClickListener(new ClickListener());
		pause.setId(BTN_START_ID + 1);
		((RelativeLayout) findViewById(R.id.jump_bar_main)).addView(pause);
		
		Button resume = new Button(this);
		RelativeLayout.LayoutParams resumeParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		resumeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		resumeParams.addRule(RelativeLayout.RIGHT_OF, BTN_START_ID + 1);
		resume.setLayoutParams(resumeParams);
		resume.setText("RESUME");
		resume.setTextColor(Color.WHITE);
		resume.setBackgroundColor(Color.RED);
		resume.setOnClickListener(new ClickListener());
		resume.setId(BTN_START_ID + 2);
		((RelativeLayout) findViewById(R.id.jump_bar_main)).addView(resume);
		
		Button stop = new Button(this);
		RelativeLayout.LayoutParams stopParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		stopParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		stopParams.addRule(RelativeLayout.RIGHT_OF, BTN_START_ID + 2);
		stop.setLayoutParams(stopParams);
		stop.setText("STOP");
		stop.setTextColor(Color.WHITE);
		stop.setBackgroundColor(Color.RED);
		stop.setOnClickListener(new ClickListener());
		((RelativeLayout) findViewById(R.id.jump_bar_main)).addView(stop);
	}
	
	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (v.getId() == BTN_START_ID) {
				mBeatView.start();
			} else if (v.getId() == BTN_START_ID + 1) {
				mBeatView.pause();
			} else if (v.getId() == BTN_START_ID + 2) {
				mBeatView.resume();
			} else {
				mBeatView.stop();
			}
		}
	}	
}