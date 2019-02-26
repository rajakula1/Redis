package redis.clients.jedis;

import redis.clients.jedis.Jedis;
//import io.lettuce.*;
import redis.clients.jedis.JedisShardInfo;

import io.lettuce.core.RedisClient;
//import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	   
        RedisClient redisClient = RedisClient.create("rediss://VxjYJqZ8WUsS781lhwBv9ZKNJGoLFgOEBIV6+LbcSTg=@rajakula.redis.cache.windows.net:6380/0");

        StatefulRedisConnection<String, String> connection = redisClient.connect();
        System.out.println("Connected to Redis using SSL");
        
        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set("key", "Hello, Raj");
        String v = syncCommands.get("key");

        System.out.println("Raj..."+v);

        System.out.println(connection.async().clientList());
       // connection.async().command().
        connection.close();
        redisClient.shutdown();
        
    	/* Jedis code
    	boolean useSSL=true;
    	JedisShardInfo sInfo = new JedisShardInfo("rajakula.redis.cache.windows.net",6380,useSSL);
    	sInfo.setPassword("VxjYJqZ8WUsS781lhwBv9ZKNJGoLFgOEBIV6+LbcSTg=");
    	//boolean useSSL=false;
    	//JedisShardInfo sInfo = new JedisShardInfo("13.77.162.83",6379,useSSL);
    	//JedisShardInfo sInfo = new JedisShardInfo("rakula@redisraj.westus2.cloudapp.azure.com",6379,useSSL);
    	
    	//sInfo.setPassword("marpally@321");
    	Jedis jedis = new Jedis(sInfo);
    	
    	
    	System.out.println("Jedis..." +jedis.getDB());
    	
    	System.out.println( "\nCache Command  : Ping" );
        System.out.println( "Cache Response : " + jedis.ping());
        
        //Redis streams
        //jedis.xadd

        // Simple get and put of integral data types into the cache
        System.out.println( "\nCache Command  : GET Message" );
        System.out.println( "Cache Response : " + jedis.get("Message"));

        System.out.println( "\nCache Command  : SET Message" );
        System.out.println( "Cache Response : " + jedis.set("Message", "Hello! The cache is working from Java!"));

        // Demonstrate "SET Message" executed as expected...
        System.out.println( "\nCache Command  : GET Message" );
        System.out.println( "Cache Response : " + jedis.get("Message"));

        // Get the client list, useful to see if connection list is growing...
        System.out.println( "\nCache Command  : CLIENT LIST" );
        System.out.println( "Cache Response : " + jedis.clientList());
        
        //jedis.getS

        jedis.close();*/
    	
        //System.out.println( "Hello World!" );
    }
}
