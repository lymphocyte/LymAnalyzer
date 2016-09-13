package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class test {
	//private static final String Pilot = null;
	static String DB4OFILENAME = "something";
	public static void main(String[] args) throws SQLException {
		
		// accessDb4o
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
		        .newConfiguration(), DB4OFILENAME);
		try {
			Pilot pilot2 = new Pilot("Rubens Barrichello", 99);
			db.store(pilot2);
			System.out.println("Stored " + pilot2);
			pilot2.addPoints(10);
			System.out.println(pilot2);
			System.out.println("after change");
			ObjectSet result = db.queryByExample(Pilot.class);
			System.out.println(result.next());
			// retrieveAllPilots
			//ObjectSet result2 = db.queryByExample(Pilot.class);
			//listResult(result2);
			deleteAll(db);
		} finally {
		    db.close();
		}
		
	
		
	
	}

	

public static void listResult(ObjectSet result) {
    System.out.println(result.size());
    while(result.hasNext()) {
        System.out.println(result.next());
    }
}
public static void accessDb4o() {
    ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
            .newConfiguration(), DB4OFILENAME);
    try {
        // do something with db4o
    } finally {
        db.close();
    }
}
public static void storeFirstPilot(ObjectContainer db) {
    Pilot pilot1 = new Pilot("Michael Schumacher", 100);
    db.store(pilot1);
    System.out.println("Stored " + pilot1);
}
public static void storeSecondPilot(ObjectContainer db) {
    Pilot pilot2 = new Pilot("Rubens Barrichello", 99);
    db.store(pilot2);
    System.out.println("Stored " + pilot2);
}
public static void retrieveAllPilotQBE(ObjectContainer db) {
    Pilot proto = new Pilot(null, 0);
    ObjectSet result = db.queryByExample(proto);
    listResult(result);
}
public static void retrieveAllPilots(ObjectContainer db) {
    ObjectSet result = db.queryByExample(Pilot.class);
    listResult(result);
}
public static void retrievePilotByName(ObjectContainer db) {
    Pilot proto = new Pilot("Michael Schumacher", 0);
    ObjectSet result = db.queryByExample(proto);
    listResult(result);
}
public static void retrievePilotByExactPoints(ObjectContainer db) {
    Pilot proto = new Pilot(null, 100);
    ObjectSet result = db.queryByExample(proto);
    listResult(result);
}
public static void updatePilot(ObjectContainer db) {
    ObjectSet result = db
            .queryByExample(new Pilot("Michael Schumacher", 0));
    Pilot found = (Pilot) result.next();
    found.addPoints(11);
    db.store(found);
    System.out.println("Added 11 points for " + found);
    retrieveAllPilots(db);
}
public static void deleteFirstPilotByName(ObjectContainer db) {
    ObjectSet result = db
            .queryByExample(new Pilot("Michael Schumacher", 0));
    Pilot found = (Pilot) result.next();
    db.delete(found);
    System.out.println("Deleted " + found);
    retrieveAllPilots(db);
}
public static void deleteAll(ObjectContainer db) {
    ObjectSet result = db
            .queryByExample(Pilot.class);
    while(result.hasNext())
    {
    Pilot found = (Pilot) result.next();
    
    db.delete(found);
    System.out.println("Deleted " + found);
    }
    retrieveAllPilots(db);
}
}




