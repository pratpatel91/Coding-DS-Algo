
public class _4_StringRotation {
	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "CDBA";
		System.out.println("Is string rotation valid? " + isStringRotationValid(s1,s2));
	}
	
	public static boolean isStringRotationValid(String s1, String s2)
	{
		boolean isRotationValid;
		String concatenatedString = s1+s2; //ABCDCDAB
		
		if(s1.length() == s2.length() && concatenatedString.indexOf(s2)!=-1)
		{
			isRotationValid=true; //assignment of value
			return isRotationValid;
		}
		
		return false;
	
	}
	
	
}
