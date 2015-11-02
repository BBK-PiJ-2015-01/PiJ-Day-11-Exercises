public class IntegerToStringSimpleMap implements SimpleMap {
    
    public static final int MAP_ARRAY_SIZE = 1000;
    private final String[] mapArray = new String[MAP_ARRAY_SIZE];

    @Override
    public void put(int key, String name) {
               
		int mapKey = HashUtilities.shortHash(key);
		
        if  (mapArray[mapKey] == null) {
            mapArray[mapKey] = name;
        }        
    }

    @Override
    public String get(int key) {
        
        int mapKey = HashUtilities.shortHash(key);
        return mapArray[mapKey];
    }

    @Override
    public void remove(int key) {
        
        int mapKey = HashUtilities.shortHash(key);
        mapArray[mapKey] = null;
    }

    @Override
    public boolean isEmpty() {
        
        for (String member: mapArray) {
            if (member != null) {
                return false;
            }
        }
        return true;
    }    
}
