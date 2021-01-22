package project.fin;

import java.util.ArrayList;

public class dogPackage extends Package{
	public dogPackage() {
		QuestionPool1 = new ArrayList<QuestionPackage>();
		QuestionPool2 = new ArrayList<QuestionPackage>();
		QuestionPool3 = new ArrayList<QuestionPackage>();
		QuestionPool1.add(new QuestionPackage("There's something that is green in your food! Vegetables! Gross, what would you do?" , "Eat it peacefully.", "Ugh! Rejects it", 20, 0, 20, 1, -20, 2, -20, 0, 0, 1, 20, 2));

		QuestionPool1.add(new QuestionPackage("You are playing with your father! He toss you up to the sky and catch you back several times, what would you do?", "Laugh Aloud! it's fun!", "Cry, What's this? it's no fun", 0, 0, 0, 1, 20, 2, 
				  0, 0, 0, 1, -20, 2));

		QuestionPool1.add(new QuestionPackage("What a peaceful night. Your parents seems to be asleep, and you feel uncomfortable. What would you do? ","Cry aloud and wake up your parents" , "Sleep and pretend there's nothing bothers you", -20, 0, 20, 1, 20, 2, 
				  20, 0, 0, 1, -20, 2));

		QuestionPool1.add(new QuestionPackage("You are about to say your first word, or are you?", "Gu Gu Ga Ga ","Mama Papa" , 0, 0, -20, 1, 0, 2, 
				  0, 0, 20, 1, 0, 2));

		QuestionPool1.add(new QuestionPackage("The black thing in the floor seems interesting, What would you do?","Pick it up and put it in your mouth" , "That is not so interesting, leave it for now", -20, 0,0, 1, 20, 2, 
				  20, 0, 0, 1, 20, 2));

		QuestionPool1.add(new QuestionPackage("You just peed in your diapers! What should you do?"," Cry Aloud, it feels uncomfortable!", "I'm too busy playing, forget it", 20, 0, 20, 1,-20, 2, 
				  -20, 0, -20, 1, 20, 2));

		QuestionPool1.add(new QuestionPackage("Mommy looks worried because you caught a flu, she gives you a spoonful of black liquid!"," Rejects it and cry", "Just Swallow it. Mom knows the best", -20, 0, 0, 1, -20, 2, 
				  20, 0, 0, 1, 20, 2));

		QuestionPool1.add(new QuestionPackage("You are upstair and mom tells you to sit still while she goes downstair"," I'm gonna stay right where i am untill she came back.", "That thing seems interesting.", 0, 0, 20, 1, 0, 2, 
				  0, 0, 0, 1, 20, 2));

		QuestionPool1.add(new QuestionPackage("There is a stranger smiling and waving his/her hand at you, what would you do?"," CRY, ITS CREEPY!", "New friends!", 0, 0, 20, 1, -20, 2, 
				  0, 0, -20, 1, 20, 2));

		QuestionPool1.add(new QuestionPackage("You want to go to the bookshelf to look around, what would you do?"," Crawl there" , "Cry without any reason", 0, 0, 20, 1, 20, 2, 
				  0, 0, -20, 1, 0, 2));

		QuestionPool2.add(new QuestionPackage("Your parents Come to your school and spoiled you as you are still a baby", "I have grown! I'm no longer a baby, go away please", "Whatever! I love my family", 0, 0, 20, 1, 0, 2, 
				  0, 0, 20, 1, 20, 2));

		QuestionPool2.add(new QuestionPackage("Someone bullies you in school, what should you do?"," Cry, they are so mean! ", "Ignores them and find a supportive circle", 0, 0, -20, 1, 0, 2, 
				  0, 0, 20, 1, 20, 2));

		QuestionPool2.add(new QuestionPackage("What would you rather choose", "I'm a sport guy!"," Nerds all the way!", 20, 0, 0, 1, 0, 2, 
				  0, 0, 20, 1, 0, 2));

		QuestionPool2.add(new QuestionPackage("You don't feel too well but your friends invite you to a party, what would you do?", "Take me there!", "Nah, you reject it", -20, 0, 20, 1, 0, 2, 
				  20, 0, 20, 1, 0, 2));

		QuestionPool2.add(new QuestionPackage("Your friend invited you to a club, he said it's fun there!", "Yes Let's rock the night!", "Bro, it's not good to go to a bar!", -20, 0, 20, 1, 0, 2, 
				  20, 0, -20, 1, 0, 2));

		QuestionPool2.add(new QuestionPackage("Next Week is an exam week, what should you do?", "STUDY ALL NIGHT, THIS EXAM IS IMPORTANT", "I'm balancing study, if i'm too tired, i'll stop", -20, 0, 0, 1, 20, 2, 
				  20, 0, 0, 1, -20, 2));

		QuestionPool2.add(new QuestionPackage("Which of this would you choose?", "Lots of Friends, but no girlfriend", "Few Friends, but with a girlfriend", 0, 0, 20, 1, 20, 2, 
				  20, 0, -20, 1, 20, 2));

		QuestionPool2.add(new QuestionPackage("You are about to get to university, what would you do?", "Just choose a moderate university, i will make more friends there!", "I’m about to enter one of the best in my country!", 0, 0, 0, 1, -20, 2, 
				  0, 0, 0, 1, 20, 2));

		QuestionPool2.add(new QuestionPackage("Your friend got into a fight with other people, what would you do?", "I'm avoiding problems, i should say sorry later", "I'm joining! I should stand by my friends's side!", 0, 0, -20, 1, 20, 2, 
				  -20, 0, 20, 1, 0, 2));

		QuestionPool2.add(new QuestionPackage("Your friend invited you to their gank, which smokes and drink alcohol. Which is pretty normal, but what will you do?", "I'm in!", "No, i'm not smoking and drinking.", -20, 0, 20, 1, 0, 2, 
				  20, 0, -20, 1, 0, 2));


		QuestionPool3.add(new QuestionPackage("You have finished your job at your office, and your parents ask you to go out with them", "Rejects it, i'm still very busy with new works", "Say yes and have fun with them", -20, 0, 0, 1, 0, 2, 
				  20, 0, 0, 1, 0, 2));

		QuestionPool3.add(new QuestionPackage("It’s sunny outside and you need to wait your child finish his/her course", "Go to ice cream store and buy your favorite ice cream", "Wait in the course place until your child finish him/her course", -20, 0, -20, 1, 0, 2, 
				  20, 0, 20, 1, 03, 2));

		QuestionPool3.add(new QuestionPackage("Your office friend is cute and she/he try to seduce you, but you already have a partner", "I'm good, i already have a partner", "I think it's fine to sometimes look for another partner", 20, 0, 0, 1, 0, 2, 
				  -20, 0, 0, 1, 0, 2));

		QuestionPool3.add(new QuestionPackage("You have a deadly disease which can be cured but with expensive treatment and your family doesn't know yet", "Tell them, even if it takes will.", "I'm keeping this myself, my child should save their money for themselves", 0, 0, -20, 1, 20, 2, 
				  -999, 0, -999, 1, -999, 2));

		QuestionPool3.add(new QuestionPackage("You have a disease which forbid you to eat your favorite food, but you are craving that food from where you are young", "Just eat it and nothing will happen if i eat it once in a while", "No, strict rules.", -999, 0, -999, 1, -999, 2, 
				  0, 0, 0, 1,20, 2));

		QuestionPool3.add(new QuestionPackage("You have already planned to a vacation with your family, suddenly one of your boss offered you an optional bussiness trip", "Family comes first, let's go to vacation", "I think my family will be happier if we got plenty of money", 20, 0, -20, 1, 0, 2, 
				  -20, 0, 20, 1, 0, 2));

		QuestionPool3.add(new QuestionPackage("Today is a very stressed day at work, there are traffic in the street and suddenly someone cut off the road and hit the front of your car", "Let it go, today is already a tiring day", "I'm going to fight this guy, Screw you mother father", 0, 0, -20, 1, 0, 2, 
				  0, 0, -20, 1, -20, 2));

		QuestionPool3.add(new QuestionPackage("Your child wants to marry a women/men you don't like, what would you do?", "No way, i'm not coming to the wedding!", "Well, everyone should have a chance to change", -20, 0, 0, 1, 0, 2, 
				  20, 0, 0, 1, 0, 2));

		QuestionPool3.add(new QuestionPackage("You run a big company and suddenly a pandemic strikes, and your revenues start to drop, what should you do?", "Tell your family and let them pray and open for suggestion of solution for you", "Keep it to yourself, your family should have fun and this is your own bussiness", 20, 0, -20, 1, 0, 2, 
				  -20, 0, 20, 1, -20, 2));

		QuestionPool3.add(new QuestionPackage("Your kid is begging you to buy them the brand new gadgets for them. what should you do?", "Buy them, my kids should always be happy", "Of course not, my kids should work hard for their wanting", 20, 0, -20, 1, 0, 2, 
				  -20, 0, 20, 1, 0, 2));

		QuestionPool3.add(new QuestionPackage("Your doctor suggest you to excercise daily, but you feel like you are too old and too tired.", "I'm too old, too tired, this is my time to rest and enjoy life", "Age is just a number, let's keep on fighting untill the end", 0, 0, 0, 1, -20, 2, 
				  0, 0, 0, 1, 20, 2));
	}
}
