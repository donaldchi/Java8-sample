/*
	Test stream class
	Author : chi
	Time   : 2017/2/8
*/

interface PersonFactory <P extends Person> {
	P create(String firstName, String lastName);
}