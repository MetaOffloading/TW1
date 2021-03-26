//The SequenceHandler is the piece of code that defines the sequence of events
//that constitute the experiment.
//
//SequenceHandler.Next() will run the next step in the sequence.
//
//We can also switch between the main sequence of events and a subsequence
//using the SequenceHandler.SetLoop command. This takes two inputs:
//The first sets which loop we are in. 0 is the main loop. 1 is the first
//subloop. 2 is the second subloop, and so on.
//
//The second input is a Boolean. If this is set to true we initialise the 
//position so that the sequence will start from the beginning. If it is
//set to false, we will continue from whichever position we were currently in.
//
//So SequenceHandler.SetLoop(1,true) will switch to the first subloop,
//starting from the beginning.
//
//SequenceHandler.SetLoop(0,false) will switch to the main loop,
//continuing from where we left off.

package com.sam.webtasks.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.sam.webtasks.basictools.CheckIdExists;
import com.sam.webtasks.basictools.CheckScreenSize;
import com.sam.webtasks.basictools.ClickPage;
import com.sam.webtasks.basictools.Consent;
import com.sam.webtasks.basictools.Counterbalance;
import com.sam.webtasks.basictools.InfoSheet;
import com.sam.webtasks.basictools.Initialise;
import com.sam.webtasks.basictools.Names;
import com.sam.webtasks.basictools.PHP;
import com.sam.webtasks.basictools.ProgressBar;
import com.sam.webtasks.basictools.Slider;
import com.sam.webtasks.basictools.TimeStamp;
import com.sam.webtasks.iotask1.IOtask1Block;
import com.sam.webtasks.iotask1.IOtask1BlockContext;
import com.sam.webtasks.iotask1.IOtask1DisplayParams;
import com.sam.webtasks.iotask1.IOtask1InitialiseTrial;
import com.sam.webtasks.iotask1.IOtask1RunTrial;

public class SequenceHandler {
	static int accuracy1, accuracy2, accuracy3, accuracy4, accuracy5, accuracy6;
	static int effort1, effort2, effort3, effort4, effort5, effort6;
	
	public static void Next() {	
		// move forward one step in whichever loop we are now in
		sequencePosition.set(whichLoop, sequencePosition.get(whichLoop) + 1);

		switch (whichLoop) {
		case 0: // MAIN LOOP
			switch (sequencePosition.get(0)) {
			/***********************************************************************
			 * The code here defines the main sequence of events in the experiment *
			 ********************************************************************/			
			case 1:
				ClickPage.Run(Instructions.Get(0), "Next");
				break;
			case 2:
				//practice 1: 6 circles, no targets
				IOtask1Block block1 = new IOtask1Block();
				block1.blockNum = -1;
				block1.nCircles = 6;
				block1.nTrials = 1;
				block1.nTargets = 0;
				block1.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block1.Run();
				break;
			case 3:
				ClickPage.Run(Instructions.Get(1), "Next");
				break;
			case 4:
				//practice 2: 10 circles, no targets
				IOtask1Block block2 = new IOtask1Block();
				block2.blockNum = -2;
				block2.nTrials = 1;
				block2.nTargets = 0;
				block2.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block2.Run();
				break;
			case 5:
				ClickPage.Run(Instructions.Get(2), "Next");
				break;
			case 6:
				//practice 3: 10 circles, 1 target
				IOtask1Block block3 = new IOtask1Block();
				block3.blockNum = -3;
				block3.nTrials = 1;
				block3.nTargets = 1;
				block3.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block3.Run();				
				break;	
			case 7:
				ClickPage.Run(Instructions.Get(3), "Next");
				break;
			case 8:
				//practice 4: 10 circles, 3 targets 
				IOtask1Block block4 = new IOtask1Block();
				block4.blockNum = -4;
				block4.nTrials = 1;
				block4.nTargets = 3;
				block4.offloadCondition = Names.REMINDERS_NOTALLOWED;		
				block4.Run();
				break;				
			case 9:
				ClickPage.Run(Instructions.Get(4), "Next");
				break;
			case 10:
				//practice 5: 10 circles, 1 target, optional reminders
				IOtask1Block block5 = new IOtask1Block();
				block5.blockNum = -5;
				block5.nTrials = 1;
				block5.nTargets = 1;
				block5.offloadCondition = Names.REMINDERS_OPTIONAL;	
				block5.Run();
				break;
			case 11:
				//practice 6: 10 circles, 3 targets, optional reminders
				IOtask1Block block6 = new IOtask1Block();
				block6.blockNum = -6;
				block6.nTrials = 1;
				block6.nTargets = 3;
				block6.offloadCondition = Names.REMINDERS_OPTIONAL;	
				block6.Run();
				break;
			case 12:
				ProgressBar.Initialise();
				ProgressBar.SetProgress(1,7);
				ProgressBar.Show();
				
				ClickPage.Run(Instructions.Get(5), "Next");
				break;
			case 13:
				//instructions for block 1
				Slider.Run(Instructions.Get(6),  "0",  "100");
				break;
			case 14:
				accuracy1 = Slider.getSliderValue();
				PHP.logData("accuracy1",  ""+accuracy1,  true);
				break;
			case 15:
				Slider.Run(Instructions.Get(7),  "0",  "100");
				break;
			case 16:
				effort1 = Slider.getSliderValue();
				PHP.logData("effort1",  ""+effort1,  true);
				break;
			case 17:
				//experimental block 1
				IOtask1Block block01 = new IOtask1Block();
				block01.blockNum = 1;
				block01.nTrials = 10;
				block01.offloadCondition = Names.REMINDERS_NOTALLOWED;	
				
				//we add five 1-target trialas and five 3-target trials
				//these will be presented in random order
				block01.targetList.add(1);
				block01.targetList.add(1);
				block01.targetList.add(1);
				block01.targetList.add(1);
				block01.targetList.add(1);
				block01.targetList.add(3);
				block01.targetList.add(3);
				block01.targetList.add(3);
				block01.targetList.add(3);
				block01.targetList.add(3);

				block01.Run();
				break;
			case 18:
				ProgressBar.SetProgress(2,7);
				//instructions for block 2
				Slider.Run(Instructions.Get(8),  "0",  "100");
				break;
			case 19:
				accuracy2 = Slider.getSliderValue();
				PHP.logData("accuracy2",  ""+accuracy2,  true);
				break;
			case 20:
				Slider.Run(Instructions.Get(9),  "0",  "100");
				break;
			case 21:
				effort2 = Slider.getSliderValue();
				PHP.logData("effort2",  ""+effort2,  true);
				break;
			case 22:
				//experimental block 2
				IOtask1Block block02 = new IOtask1Block();
				block02.blockNum = 1;
				block02.nTrials = 10;
				block02.offloadCondition = Names.REMINDERS_OPTIONAL;	
				
				//we add five 1-target trialas and five 3-target trials
				//these will be presented in random order
				block02.targetList.add(1);
				block02.targetList.add(1);
				block02.targetList.add(1);
				block02.targetList.add(1);
				block02.targetList.add(1);
				block02.targetList.add(3);
				block02.targetList.add(3);
				block02.targetList.add(3);
				block02.targetList.add(3);
				block02.targetList.add(3);

				block02.Run();
				break;
			case 23:
				ProgressBar.SetProgress(3,7);
				//instructions for block 3
				Slider.Run(Instructions.Get(6),  "0",  "100");
				break;
			case 24:
				accuracy3 = Slider.getSliderValue();
				PHP.logData("accuracy3",  ""+accuracy3,  true);
				break;
			case 25:
				Slider.Run(Instructions.Get(7),  "0",  "100");
				break;
			case 26:
				effort3 = Slider.getSliderValue();
				PHP.logData("effort3",  ""+effort3,  true);
				break;
			case 27:
				//experimental block 3
				IOtask1Block block03 = new IOtask1Block();
				block03.blockNum = 1;
				block03.nTrials = 10;
				block03.offloadCondition = Names.REMINDERS_NOTALLOWED;	
				
				//we add five 1-target trialas and five 3-target trials
				//these will be presented in random order
				block03.targetList.add(1);
				block03.targetList.add(1);
				block03.targetList.add(1);
				block03.targetList.add(1);
				block03.targetList.add(1);
				block03.targetList.add(3);
				block03.targetList.add(3);
				block03.targetList.add(3);
				block03.targetList.add(3);
				block03.targetList.add(3);

				block03.Run();
				break;
			case 28:
				ProgressBar.SetProgress(4,7);
				//instructions for block 4
				Slider.Run(Instructions.Get(8),  "0",  "100");
				break;
			case 29:
				accuracy4 = Slider.getSliderValue();
				PHP.logData("accuracy4",  ""+accuracy4,  true);
				break;
			case 30:
				Slider.Run(Instructions.Get(9),  "0",  "100");
				break;
			case 31:
				effort4 = Slider.getSliderValue();
				PHP.logData("effort4",  ""+effort4,  true);
				break;
			case 32:
				//experimental block 4
				IOtask1Block block04 = new IOtask1Block();
				block04.blockNum = 1;
				block04.nTrials = 10;
				block04.offloadCondition = Names.REMINDERS_OPTIONAL;	
				
				//we add five 1-target trialas and five 3-target trials
				//these will be presented in random order
				block04.targetList.add(1);
				block04.targetList.add(1);
				block04.targetList.add(1);
				block04.targetList.add(1);
				block04.targetList.add(1);
				block04.targetList.add(3);
				block04.targetList.add(3);
				block04.targetList.add(3);
				block04.targetList.add(3);
				block04.targetList.add(3);

				block04.Run();
				break;
			case 33:
				ProgressBar.SetProgress(5,7);
				//instructions for block 5
				Slider.Run(Instructions.Get(6),  "0",  "100");
				break;
			case 34:
				accuracy5 = Slider.getSliderValue();
				PHP.logData("accuracy5",  ""+accuracy5,  true);
				break;
			case 35:
				Slider.Run(Instructions.Get(7),  "0",  "100");
				break;
			case 36:
				effort5 = Slider.getSliderValue();
				PHP.logData("effort5",  ""+effort5,  true);
				break;
			case 37:
				//experimental block 5
				IOtask1Block block05 = new IOtask1Block();
				block05.blockNum = 1;
				block05.nTrials = 10;
				block05.offloadCondition = Names.REMINDERS_NOTALLOWED;	
				
				//we add five 1-target trialas and five 3-target trials
				//these will be presented in random order
				block05.targetList.add(1);
				block05.targetList.add(1);
				block05.targetList.add(1);
				block05.targetList.add(1);
				block05.targetList.add(1);
				block05.targetList.add(3);
				block05.targetList.add(3);
				block05.targetList.add(3);
				block05.targetList.add(3);
				block05.targetList.add(3);

				block05.Run();
				break;
			case 38:
				ProgressBar.SetProgress(6,7);
				//instructions for block 6
				Slider.Run(Instructions.Get(8),  "0",  "100");
				break;
			case 39:
				accuracy6 = Slider.getSliderValue();
				PHP.logData("accuracy6",  ""+accuracy6,  true);
				break;
			case 40:
				Slider.Run(Instructions.Get(9),  "0",  "100");
				break;
			case 41:
				effort6 = Slider.getSliderValue();
				PHP.logData("effort6",  ""+effort6,  true);
				break;
			case 42:
				//experimental block 6
				IOtask1Block block06 = new IOtask1Block();
				block06.blockNum = 1;
				block06.nTrials = 10;
				block06.offloadCondition = Names.REMINDERS_OPTIONAL;	
				
				//we add five 1-target trialas and five 3-target trials
				//these will be presented in random order
				block06.targetList.add(1);
				block06.targetList.add(1);
				block06.targetList.add(1);
				block06.targetList.add(1);
				block06.targetList.add(1);
				block06.targetList.add(3);
				block06.targetList.add(3);
				block06.targetList.add(3);
				block06.targetList.add(3);
				block06.targetList.add(3);

				block06.Run();
				break;
			case 43:
				ProgressBar.SetProgress(7,7);
				// log data and check that it saves
				String data = SessionInfo.gender + ",";
				data = data + SessionInfo.age + ",";
				data = data + TimeStamp.Now() + ",";
				data = data + accuracy1 + "," + effort1 + ",";
				data = data + accuracy2 + "," + effort2 + ",";
				data = data + accuracy3 + "," + effort3 + ",";
				data = data + accuracy4 + "," + effort4 + ",";
				data = data + accuracy5 + "," + effort5 + ",";
				data = data + accuracy6 + "," + effort6;

				PHP.logData("finish", data, true);
				break;
			case 44:
				// complete the experiment
				Finish.Run();
				break;
			}
			break;
		

		/********************************************/
		/* no need to edit the code below this line */
		/********************************************/

		case 1: // initialisation loop
			switch (sequencePosition.get(1)) {
			case 1:
				// initialise experiment settings
				Initialise.Run();
				break;
			case 2:
				// make sure that a participant ID has been registered.
				// If not, the participant may not have accepted the HIT
				CheckIdExists.Run();
				break;
			case 3:
				// check the status of this participant ID.
				// have they already accessed or completed the experiment? if so,
				// we may want to block them, depending on the setting of
				// SessionInfo.eligibility
				PHP.CheckStatus();
				break;
			case 4:
				// check whether this participant ID has been used to access a previous experiment
				PHP.CheckStatusPrevExp();
				break;
			case 5:
				// clear screen, now that initial checks have been done
				RootPanel.get().clear();

				// make sure the browser window is big enough
				CheckScreenSize.Run(SessionInfo.minScreenSize, SessionInfo.minScreenSize);
				break;
			case 6:
				if (SessionInfo.runInfoConsentPages) { 
					//InfoSheet.Run(Instructions.InfoText());
				} else {
					SequenceHandler.Next();
				}
				break;
			case 7:
				if (SessionInfo.runInfoConsentPages) { 
					Consent.Run();
				} else {
					SequenceHandler.Next();
				}
				break;
			case 8:
				SequenceHandler.SetLoop(0, true); // switch to and initialise the main loop
				SequenceHandler.Next(); // start the loop
				break;
			}
			break;
			
		case 2: // IOtask1 loop
			switch (sequencePosition.get(2)) {
			/*************************************************************
			 * The code here defines the sequence of events in subloop 2 *
			 * This runs a single trial of IOtask1                       *
			 *************************************************************/
			case 1:
				// first check if the block has ended. If so return control to the main sequence
				// handler
				IOtask1Block block = IOtask1BlockContext.getContext();

				if (block.currentTrial == block.nTrials) {
					SequenceHandler.SetLoop(0, false);
				}

				SequenceHandler.Next();
				break;
			case 2:
				// now initialise trial and present instructions
				IOtask1InitialiseTrial.Run();
				break;
			case 3:
				// now run the trial
				IOtask1RunTrial.Run();
				break;
			case 4:
				// we have reached the end, so we need to restart the loop
				SequenceHandler.SetLoop(2, true);
				SequenceHandler.Next();
				break;
				// TODO: mechanism to give post-trial feedback?
				
			}
		
		}
	}
	
	private static ArrayList<Integer> sequencePosition = new ArrayList<Integer>();
	private static int whichLoop;

	public static void SetLoop(int loop, Boolean init) {
		whichLoop = loop;

		while (whichLoop + 1 > sequencePosition.size()) { // is this a new loop?
			// if so, initialise the position in this loop to zero
			sequencePosition.add(0);
		}

		if (init) { // go the beginning of the sequence if init is true
			sequencePosition.set(whichLoop, 0);
		}
	}

	// set a new position
	public static void SetPosition(int newPosition) {
		sequencePosition.set(whichLoop, newPosition);
	}

	// get current position
	public static int GetPosition() {
		return (sequencePosition.get(whichLoop));
	}
}
