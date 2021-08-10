/**
* PROGRAMMED BY: Andrew Wimer
* DATE CREATED: Aug 8 2021
* LAST UPDATED: Aug 9 2021
*/

package getset;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * CLASS DESCRIPTION: dataMemberMap is a mapping of identifiers (keys) and
 data types/return types (values) for Data Members
 * @author Andrew Wimer
 * 
 */
public class dataMemberMap {
   
   //map that stores data members
   private Map<String, String> map = new LinkedHashMap();
   
   /**
    * Default constructor.
    */
   public dataMemberMap()
   {
      
   }
   
   /**
    * Constructs data member map from existing data member map
    * @param map 
    */
    public dataMemberMap(Map map)
   {
      this.map = (LinkedHashMap<String, String>) map;
   }
   
    /**
     * Adds data member's identifier key and data type/return type value to 
     * the data member map. 
     * @param identifier Data member's identifier.
     * @param returnType  Data member's return type.
     */
   public void putDataMember(String identifier, String returnType)
   {
      map.put(identifier, returnType);
   }
   
   /**
    * Clears the map. 
    */
   public void clearMap()
   {
      map.clear();
   }
   

   /**
    * @return true if there are no key-value mappings in this map
    */
   public boolean isEmpty()
   {
      return map.isEmpty();
   }
   
   /**
    * Returns a Set view of the mappings contained in this map.
    * @return 
    */
   public Set<Map.Entry<String, String>> entrySet()
   {
      return map.entrySet();
   }
   
   /**
    * Returns the value to which the specified key is mapped, or null if this 
   * map contains no mapping for the key.
   */  
   public String get(String key)
   {
      return map.get(key);
   }
   
   /**
    * Returns the integer value of the number of key-value entries in the map.
   */  
   public int size()
   {
      return map.size();
   }
}
