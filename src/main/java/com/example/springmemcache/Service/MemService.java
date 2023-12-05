package com.example.springmemcache.Service;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.regex.*;
@Service
public class MemService {
    private MemcachedClient client;

//    private HazelcastInstance hazelcastInstance;

    public MemService() throws IOException {
//        Config hazelcastConfig = new ClasspathXmlConfig("hazelcast.xml");
//        hazelcastInstance = Hazelcast.newHazelcastInstance();

        client = new MemcachedClient(AddrUtil.getAddresses("192.168.18.100:5701")); //192.168.18.100
//        client = new MemcachedClient(new InetSocketAddress( "192.168.18.100",5701)); //192.168.18.100
//        client = new MemcachedClient(new InetSocketAddress("localhost", 11211));

//        AuthDescriptor authDescriptor = new AuthDescriptor(new String[]{"PLAIN"}, new PlainCallbackHandler("root", "iamadmin1"));
//        client = new MemcachedClient(AddrUtil.getAddresses("192.168.18.100:5701"), authDescriptor);

    }

//    public void storeValue(String key, String value) {
//        hazelcastInstance.getMap("myMap").set(key, value);


//        ObjectMapper objectMapper = new ObjectMapper();
//        String serializedValue = objectMapper.writeValueAsString(value);

//        IMap<String, String> cache = hazelcastInstance.getMap("hz_memcache_default");
//        cache.put(key, serializedValue);


//        client.set(key, 0, value);
//        System.out.println(client.get(key));


//        System.out.println(hazelcastInstance.getMap("hz_memcache_default").get(key));
//        IMap<Integer, String> cache = hazelcastInstance.getMap("hz_memcache_default");
//        System.out.println(cache.get(key));
//    }

//    public String getValue(String key1) {
//         client.flush();
//        client.delete(key);

//        for (int key = 0; key < 10; key++) { // Assuming keys are numeric from 0 to 9999
//            client.delete("hz_memcache_default" + "_" + key); // Append the map name to each key
//        }

//        for (int key = 0; key < 10; key++) {
//            client.delete(String.valueOf(key));
//        }

//        client.getAvailableServers();
//        System.out.println(client.getAvailableServers().toString());

//        for (SocketAddress key : client.getAvailableServers()) {
//                client.delete(key.toString());
//        }

//        MemcachedMap<String, String> hazelcastMap = client.getMap("yourMapName");
//
//        for (String key : hazelcastMap.keySet()) {
//            hazelcastMap.delete(key);
//        }

    //        client.get(key); //for debugging
//        Object value = client.get(key);
//
//        if (value != null) {
//            String valueStr = value.toString();
//            return "Value = " + valueStr;
//        } else {
//            return "Key not found";
//        }
//        return "value";
//    }
    public void storeValue(String mapName, String key, String value) {
        String fullKey = mapName + ":" + key;
        client.set(fullKey, 0, value);
    }

    public String getValue(String mapName, String key) {
//        String fullKey = mapName + ":";
//        return client.getBulk(fullKey).toString();
//      map1:name, map1:age
        String fullKey = mapName + ":";

//        Set<String> keys = client.getBulk("map1:").keySet();
//        System.out.println(client.getBulk("map1:").keySet());
//        System.out.println(client.get("map1:(\\S+)"));
//        return (String) client.get("map1:(\\S+)");



        String prefix = "map1:";

        // Get all keys starting with the specified prefix
        Map<String, Object> keyValues = client.getBulk(prefix);

        // Iterate through the keys and values
        for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
            String key5 = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Key: " + key5 + ", Value: " + value);
        }

        return "value";
//        Set<String> keys = jedis.keys(prefix + "*");

//        for (String key1 : keys) {
//            System.out.println(key1);
//            String value = client.get(key).toString();
//            System.out.println(value);
//        }

//        String prefix = "map1:";
//
//        List<String> keys = new ArrayList<>();
//        Map<String, Object> allKeys = client.getBulk();
//        System.out.println(client.getBulk());
//        System.out.println(client.getBulk().hashCode());
//        System.out.println(client.getBulk().entrySet());
//        System.out.println(client.getBulk().getClass());
//        System.out.println(client.getBulk().values());
//        System.out.println(client.getBulk().toString());
//        System.out.println(client.get("hz_memcache_"));
//        System.out.println(client.get("hz_memcache_map1"));
//        System.out.println(client.get("map1:**"));
//        System.out.println(allKeys);
//        System.out.println("break1");






//        Pattern pattern = Pattern.compile("map1:(\\S+)");
//        Matcher matcher = pattern.matcher(client.get());
////        client.get(matcher);
//        if (matcher.find()) {
//            String matchedKey = matcher.group(1);
//            String value = (String) client.get(matchedKey);
//            System.out.println(matchedKey + ": " + value);
//        }




//        for (String key2 : allKeys.keySet()) {
//            if (key2.startsWith(prefix)) {
//                keys.add(key2);
//                System.out.println(keys);
//                System.out.println("break2");
//
//            }
//        }

        // Retrieve values for the selected keys
//        Map<String, Object> results = client.getBulk(keys);
//
//        for (Map.Entry<String, Object> entry : results.entrySet()) {
//            String key3 = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println("Key: " + key3);
//            System.out.println("Value: " + value);
//            System.out.println("break3");
//
//        }

//        String fullKey = mapName + ":";
//        client.get(fullKey);
    }
//    public void clear() {
//        //flush hazelcast map
////        IMap<String, String> hazelcastMap = hazelcastInstance.getMap("hz_memcache_default");
//////        for (String key1 : hazelcastMap.keySet()) {
//////            System.out.println("Key: " + key1);
//////        }
////        hazelcastMap.clear();
//    }

//    public List<String> getMatchingKeys(String pattern) {
//        List<String> matchingKeys = new ArrayList<>();
//
//        Map<SocketAddress, Map<String, String>> stats = client.getStats();
//        System.out.println(stats.toString());
//        for (Map<String, String> serverStats : stats.values()) {
//            for (Map.Entry<String, String> entry : serverStats.entrySet()) {
//                if (entry.getKey().startsWith("map:") && entry.getKey().matches(pattern)) {
//                    matchingKeys.add(entry.getKey().substring(4));
//                }
//            }
//        }
//        System.out.println(matchingKeys);
//
//        return matchingKeys;
//    }


    public void clear(String mapName) {
//        client.flush();
//        client.shutdown();

//        Map<SocketAddress, Map<String, String>> stats =  client.getStats();
//        for (SocketAddress key : stats.keySet()) {
//            if (key.startsWith(mapName + ":")) {
//                client.delete(key.toString());
//            }
//        }


//        Map<SocketAddress, Map<String, String>> stats = client.getStats();
//        String fullKeyPrefix = mapName + ":";
//        Set<String> keysToDelete = new HashSet<>();
//
//        for (Map.Entry<SocketAddress, Map<String, String>> entry : stats.entrySet()) {
//            String serverAddress = entry.getKey().toString();
//            Map<String, String> serverStats = entry.getValue();
//
//            for (Map.Entry<String, String> statEntry : serverStats.entrySet()) {
//                String key = statEntry.getKey();
//
//                if (key.startsWith(fullKeyPrefix)) {
//                    keysToDelete.add(key);
//                }
//            }
//        }
//
//        for (String key : keysToDelete) {
//            client.delete(key);
//        }


//        String fullKey = mapName + ":";
//        System.out.println(client.get(fullKey + "**"));


//        String fullKey = mapName + ":";
//
//        Set<String> allKeys = client.getAvailableServers().stream()
//                .map(server -> server + fullKey)
//                .collect(Collectors.toSet());
//
//        for (String key : allKeys) {
//            client.delete(key);
//        }


//        String fullKey = mapName + ":";
//        Set<String> allKeys = client.getAvailableServers()
//                .stream()
//                .map(Object::toString)
//                .flatMap(server -> client.getStats(server).keySet().stream())
//                .map(Object::toString)
//                .filter(key -> key.startsWith(fullKey))
//                .collect(Collectors.toSet());
//
//        for (String key : allKeys) {
//            client.delete(key);
//        }

//        System.out.println(client.getAvailableServers().stream().map(Object::toString)
//                .filter(key -> key.startsWith(fullKey)).collect(Collectors.toSet()));
//        System.out.println(allKeys);
//        for (String key : client.getUnavailableServers()) {
//            if (key.startsWith(mapName + ":")) {
//                client.delete(key);
//            }
//        }


        String fullKey = mapName + ":";
        client.delete(fullKey);

//        for (int key = 0; key < 10000; key++) {
//            String fullKey = mapName + ":" + key;
//            Object value = client.get(fullKey);
//
//            if (value != null) {
//                if (!value.toString().isEmpty()) {
//                    client.delete(fullKey);
//                }
//            }
//        }


//        Enumeration<String> allKeys = client.getKey();
//        String fullKey = mapName + ":";
//        Set<String> allKeys = (Set<String>) client.get(fullKey);
//
//
//
//        Set<String> mapKeys = allKeys.stream()
//                .filter(key -> key.startsWith(mapName + ":"))
//                .collect(Collectors.toSet());
//
//        // Delete the keys associated with the map
//        mapKeys.forEach(client::delete);

//        List<String> values = new ArrayList<>();
//        // Assuming keys in your map are stored as "mapName:key"
//        String prefix = mapName + ":";
//        // Use CAS to get all the keys in Memcached
//        CASValue<Object> casValue = client.gets(prefix);
//        System.out.println(casValue.toString());
//        if (casValue != null) {
//            do {
//                String key = casValue.getValue().toString();
//                String value = (String) casValue.getValue();
//                values.add(value);
//                // Fetch the next key-value pair
//                casValue = client.gets(key);
//            } while (casValue != null);
//        }
//        System.out.println(values);


        // Iterate through all keys in Memcached
//        Enumeration<String> allKeys = client.getAvailableServers()
//                .stream()
//                .flatMap(server -> client.getStats(server.toString()).entrySet().stream())
//                .filter(key -> key.startsWith(mapName + ":"))
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toSet());
//
//        // Delete the keys associated with the map
//        allKeys.forEach(client::delete);
//

//        System.out.println("Clearing map: " + mapName);
//
//        // Get all keys from Hazelcast
//        Set<String> allKeys = new HashSet<>();
//        for (SocketAddress socketAddress : client.getAvailableServers()) {
//            String server = socketAddress.toString();
//            for (SocketAddress address : client.getStats(server).keySet()) {
//                allKeys.add(address.toString());
//            }
//        }
//
//        if (allKeys.isEmpty()) {
//            System.out.println("The map is empty or does not exist.");
//            return;
//        }
//
//        for (String key : allKeys) {
//            Object value = client.get(key);
//
//            if (value != null && value instanceof String && !((String) value).isEmpty()) {
//                client.delete(key);
//                System.out.println("Deleted key: " + key);
//                System.out.println("Value: " + value);
//            }
//        }
    }


//    public void clear(String mapName) {
//        System.out.println("Clearing map: " + mapName);
//
//        // Collect all keys for the specified map
//        Set<String> allKeys = Collections.singleton(client.getAvailableServers()
//                .stream()
////                .map(Object::toString)
////                .flatMap(server -> client.getStats(server).keySet().stream())
//                .map(Object::toString)
////                .filter(key -> key.startsWith(mapName + ":"))
//                .filter(key -> key.startsWith("600"))
//                .collect(Collectors.toSet()).toString());
//        System.out.println(allKeys);
//        if (allKeys.isEmpty()) {
//            System.out.println("The map is empty or does not exist.");
//            return;
//        }
//
//        for (String key : allKeys) {
//            client.delete(key);
//            System.out.println("Deleted key: " + key);
//        }
//    }


}


//        import com.hazelcast.core.HazelcastInstance;
//        import net.spy.memcached.MemcachedClient;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.beans.factory.annotation.Qualifier;
//        import org.springframework.stereotype.Service;
//        import redis.clients.jedis.Jedis;
//
//@Service
//public class MemService {
//
//    @Autowired
//    private MemcachedClient memcachedClient;
//
//    @Qualifier("hazelcastInstance")
//    @Autowired(required = false)
//    private HazelcastInstance hazelcastInstance;
//
//    @Autowired(required = false)
//    @Qualifier("redisJedis")
//    private Jedis redisJedis;
//
//    private final boolean useHazelcast = false;
//    private final boolean useRedis = true;
//    public void storeValue(String key, String value) {
//        memcachedClient.set(key, 0, value);
//
//        if (useHazelcast) {
//            hazelcastInstance.getMap("myMap").put(key, value);
//        }
//
//        else if (useRedis) {
//            redisJedis.set(key, value);
//        }
//    }
//
//    public String getValue(String key) {
//        String memcachedValue = (String) memcachedClient.get(key);
//
//        if (memcachedValue != null) {
//            return memcachedValue;
//        } else {
//            if (useHazelcast) {
//                String hazelcastValue = (String) hazelcastInstance.getMap("myMap").get(key);
//                if (hazelcastValue != null) {
//                    memcachedClient.set(key, 0, hazelcastValue);
//
//                    return hazelcastValue;
//                }
//            }
//
//            else if (useRedis) {
//                String redisValue = redisJedis.get(key);
//                if (redisValue != null) {
//                    memcachedClient.set(key, 0, redisValue);
//                    return redisValue;
//                }
//            }
//
//            return null;
//        }
//    }
//}