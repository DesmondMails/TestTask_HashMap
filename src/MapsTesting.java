import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;

public class MapsTesting {
        @Test
        public void testForPut(){
                HashMap<Integer,Long> hashMap = new HashMap<>();
                LinkedHashMap<Integer,Long> linkedHashMap = new LinkedHashMap<>();
                IdentityHashMap<Integer,Long> identityHashMap = new IdentityHashMap<>();
                OpenAdressHashMap openAdressHashMap = new OpenAdressHashMap();

                Date hashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        hashMap.put(i,(long)i);
                }
                Date hashMap_date_end = new Date();

                long timeForHashMap = hashMap_date_end.getTime() - hashMap_date_begin.getTime();

                Date linkedhashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        linkedHashMap.put(i,(long)i);
                }
                Date linkedHashMap_date_end = new Date();

                long timeForLinkedHashMap = linkedHashMap_date_end.getTime() - linkedhashMap_date_begin.getTime();

                Date identityHashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        identityHashMap.put(i,(long)i);
                }
                Date identityHashMap_date_end = new Date();

                long timeForIdentityHashMap = identityHashMap_date_end.getTime() - identityHashMap_date_begin.getTime();

                Date openAdressHashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        openAdressHashMap.put(i,i);
                }
                Date openAdressHashMap_date_end = new Date();

                long timeForOpenAdressHashMap = openAdressHashMap_date_end.getTime() - openAdressHashMap_date_begin.getTime();

                System.out.println("Time for HashMap = "+timeForHashMap+" ms");
                System.out.println("Time for LinkedHashMap = "+timeForLinkedHashMap+" ms");
                System.out.println("Time for IdentityHashMap = " + timeForIdentityHashMap+" ms");
                System.out.println("Time for OpenAdressingHashMap = "+timeForOpenAdressHashMap+" ms");

                Assert.assertTrue(timeForOpenAdressHashMap < timeForHashMap);
                Assert.assertTrue(timeForOpenAdressHashMap < timeForLinkedHashMap);
                Assert.assertTrue(timeForOpenAdressHashMap < timeForIdentityHashMap);
        }
        @Test
        public void testForGet(){
                HashMap<Integer,Long> hashMap = new HashMap<>();
                LinkedHashMap<Integer,Long> linkedHashMap = new LinkedHashMap<>();
                IdentityHashMap<Integer,Long> identityHashMap = new IdentityHashMap<>();
                OpenAdressHashMap openAdressHashMap = new OpenAdressHashMap();

                Date hashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        hashMap.put(i,(long)i);
                        hashMap.get(i);
                }
                Date hashMap_date_end = new Date();

                long timeForHashMap = hashMap_date_end.getTime() - hashMap_date_begin.getTime();

                Date linkedhashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        linkedHashMap.put(i,(long)i);
                        linkedHashMap.get(i);
                }
                Date linkedHashMap_date_end = new Date();

                long timeForLinkedHashMap = linkedHashMap_date_end.getTime() - linkedhashMap_date_begin.getTime();

                Date identityHashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        identityHashMap.put(i,(long)i);
                        identityHashMap.get(i);
                }
                Date identityHashMap_date_end = new Date();

                long timeForIdentityHashMap = identityHashMap_date_end.getTime() - identityHashMap_date_begin.getTime();

                Date openAdressHashMap_date_begin = new Date();
                for (int i = 1; i < 10000000; i++) {
                        openAdressHashMap.put(i,i);
                        openAdressHashMap.get(i);
                }
                Date openAdressHashMap_date_end = new Date();

                long timeForOpenAdressHashMap = openAdressHashMap_date_end.getTime() - openAdressHashMap_date_begin.getTime();

                System.out.println("Time for HashMap = "+timeForHashMap+" ms");
                System.out.println("Time for LinkedHashMap = "+timeForLinkedHashMap+" ms");
                System.out.println("Time for IdentityHashMap = " + timeForIdentityHashMap+" ms");
                System.out.println("Time for OpenAdressingHashMap = "+timeForOpenAdressHashMap+" ms");

                Assert.assertTrue(timeForOpenAdressHashMap < timeForHashMap);
                Assert.assertTrue(timeForOpenAdressHashMap < timeForLinkedHashMap);
                Assert.assertTrue(timeForOpenAdressHashMap < timeForIdentityHashMap);
        }
        @Test
        public void testForSize(){
                OpenAdressHashMap openAdressHashMap = new OpenAdressHashMap();
                HashMap<Integer,Long> hashMap = new HashMap<>();

                for (int i = 1; i < 12345; i++) {
                        openAdressHashMap.put(i,i);
                }
                for (int i = 1; i < 12345; i++) {
                        hashMap.put(i,(long)i);
                }
                int openAdressHashMapSize = openAdressHashMap.size();
                int hashMapSize = hashMap.size();
                System.out.println("Size of OpenAdressHashMap = " + openAdressHashMapSize);
                System.out.println("Size of HashMap = " + hashMapSize);

                Assert.assertEquals(openAdressHashMapSize,hashMapSize);
        }
}
