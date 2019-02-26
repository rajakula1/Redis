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
    	   //Using Lettuce client
    	//Connection string  - rediss://password@DNS or IP:port/0
        RedisClient redisClient = RedisClient.create("Connection String");

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
    	JedisShardInfo sInfo = new JedisShardInfo("XXXX",6380,useSSL);
    	sInfo.setPassword("password");
    	//boolean useSSL=false;
    	//JedisShardInfo sInfo = new JedisShardInfo("iP address",6379,useSSL);
    	//JedisShardInfo sInfo = new JedisShardInfo("azure URL",6379,useSSL);
    	
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
