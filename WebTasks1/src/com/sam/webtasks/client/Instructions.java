package com.sam.webtasks.client;

import com.sam.webtasks.basictools.Counterbalance;

public class Instructions {

	public static String Get(int index) {
		String i = "";

		switch (index) {
		case 0:
			i = "In this experiment you will have a simple task to do.<br><br>"
					+ "You will see several yellow circles inside a box. Inside each circle will be a number. <br><br>"
					+ "You can move them around with your finger. Your task is to drag them to the bottom of the box in sequence.<br><br>"
					+ " Please start by dragging 1 all the way to the bottom. This will make it disappear. <br><br>"
					+ "Then drag 2 to the bottom, then 3, and so on.";
			break;

		case 1:
			i="Now you will continue the task with more circles on the screen. ";
			break;
			
		case 2:
			i="Now you will continue the same task, but sometimes there will be something else to do. <br><br>"
					+ "As well as dragging each circle in turn to the "
					+ "bottom of the screen, you will be instructed to drag one or more "
					+ "of the circles to another part of the box. For instance, you might be told that you should drag number 5 "
					+ "to the left of the box instead of the bottom.<br><br>"
					+ "You will still be able to drag any circle to the bottom of the box, but you should try to "
					+ "remember to drag these special circles to the instructed location. ";
			break;

		case 3:
			i="Now you will do the task again, but this time there will be three special circles to remember.";
			break;

		case 4:
			i="Some people find it helpful to drag "
					+ "the special circles near to the edge of the box to help them remember.<br><br> "
					+ "For example, if you had to remember to drag 5 to the left of the box, "
					+ "you could drag it near to there at the beginning, before you drag the 1. "
					+ "Then when you eventually got to 5, its location would remind you "
					+ "what to do. You should feel free to use this strategy if you like, but "
					+ "it's up to you.<br><br> "
					+ "Click below to continue.";
			break;
			
		case 5:
			i = "Now the experiment will start for real.<br><br>"
					+ "When you do the task, sometimes you will have one special circle to remember "
					+ "and sometimes you will have three to remember.";
			break;
			
		case 6:
			i = "On this next group of trials, you will <b>NOT</b> be able to drag the circles out of "
					+ "order as a reminder of where the targets should be moved. You will have to use "
					+ "your own memory.<br><br>"
					+ "How <b>accurate</b> do you expect to be on this next group of trials?<br><br>"
					+ "Please use the slider below to select a number, where 0 means that you will "
					+ "not get any responses correct and 100 means that you will get all responses correct.";
			break;
			
		case 7:
			i = "How much <b>effort</b> do you expect it to take for you to perform this next group of trials?<br><br>"
					+ "Please use the slider below to select a number, where 0 means no effort "
					+ "and 100 means complete effort.";
			break;
			
		case 8:
			i = "On this next group of trials, you <b>WILL</b> be able to drag the circles out of "
					+ "order as a reminder of where the targets should be moved.<br><br>"
					+ "How <b>accurate</b> do you expect to be on this next group of trials?<br><br>"
					+ "Please use the slider below to select a number, where 0 means that you will "
					+ "not get any responses correct and 100 means that you will get all responses correct.";
			break;
			
		case 9:
			i = "How much <b>effort</b> do you expect it to take for you to perform this next group of trials?<br><br>"
					+ "Please use the slider below to select a number, where 0 means no effort "
					+ "and 100 means complete effort.";
			break;

		}

		return (i);
	}
}
