/*
 * PROGRAMMED BY: Andrew Wimer
* DATE CREATED: Aug 9 2021
* LAST UPDATED: Aug 11 2021
 */
package datamemberparse;


import datamemberparse.DataMemberMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andr00
 */
public class DataMemberMapTest {
   
   public DataMemberMapTest() {
   }

   /**
    * Test of putDataMember method, of class DataMemberMap.
    */
   @Test
   public void testPutDataMember() {
      System.out.println("PutDataMember");
      DataMemberMap instance = new DataMemberMap();
      instance.put("name", "String");
      String value = instance.get("name");
      String expValue = "String";
      assertEquals(expValue, value);
      
   }

   /**
    * Test of clearMap method, of class DataMemberMap.
    */
   @Test
   public void testClearMap() {
      System.out.println("ClearMap");
      DataMemberMap instance = new DataMemberMap();
      
      System.out.println("");
      instance.put("name", "String");
      instance.clear();
      boolean expResult = true;
      boolean result = instance.isEmpty();
      assertEquals(expResult, result);
   }

   /**
    * Test of isEmpty method, of class DataMemberMap.
    */
   @Test
   public void testIsEmpty() {
      System.out.println("IsEmpty");
      DataMemberMap instance = new DataMemberMap();
      System.out.println("");
      instance.put("name", "String");
      boolean expResult = false;
      boolean result = instance.isEmpty();
      assertEquals(expResult, result);
   }

   /**
    * Test of entrySet method, of class DataMemberMap.
    */
   @Test
   public void testEntrySet() {
      System.out.println("EntrySet");
      DataMemberMap instance = new DataMemberMap();
      instance.put("name", "String");
      LinkedHashMap<String, String> hashMap = new LinkedHashMap();
      hashMap.put("name", "String");
      Set set = new TreeSet();
      set = instance.entrySet();
      Set expSet = new TreeSet();
      expSet = hashMap.entrySet();
      
      assertEquals(expSet, set);
      //assert
      
      
   }

   /**
    * Test of get method, of class DataMemberMap.
    */
   @Test
   public void testGet() {
      DataMemberMap instance = new DataMemberMap();
      instance.put("name", "String");
      //LinkedHashMap<String, String> hashMap = new LinkedHashMap();
      //hashMap.put("name", "String");
      String result = instance.get("name");
      String expResult = "String";
      assertEquals(expResult, result);
   }

   /**
    * Test of size method, of class DataMemberMap.
    */
   @Test
   public void testSize() {
      DataMemberMap instance = new DataMemberMap();
      instance.put("name", "String");
      instance.put("name", "int");
      int result = instance.size();
      int expResult = 1;
      assertEquals(expResult, result);
   }
   
}
