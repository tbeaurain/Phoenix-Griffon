package IdentifiantIsep;

import IdentifiantIsep.ldap.LDAPAccess;
import IdentifiantIsep.ldap.LDAPObject;

class TestLDAP
{
	public static void main(String[] args)
	{
		LDAPAccess access = new LDAPAccess();
		try {
			LDAPObject test = access.LDAPget("tbeaurai", "Paris1!");
			if (test == null){
				System.out.println("login invalide");
				System.exit(1);
			}
			System.out.println(test.toString());
			System.exit(0);
		} catch(Exception e) {
		}
	}
}