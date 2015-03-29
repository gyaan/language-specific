<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 29/3/15
 * Time: 4:37 PM
 * simple implementation of memcache how its work and how values stors and get back
 */

class myMemCache {

    //let implement using singleton
    private static  $memCacheInstance=null;
    private static $host="127.0.0.1";
    private static $expireTime=43200;
    private static $port=11211;

    private function __construct(){}

    public static function getMyMemCacheInstance(){

        if(self::$memCacheInstance==null){

            $memCache = new Memcache();
            try{
                $memCache->connect(self::$host,self::$port,self::$expireTime);
            }
            catch(Exception $e){
                echo $e->getMessage();
            }
            self::$memCacheInstance=$memCache;

        }
        return self::$memCacheInstance;

    }

}



//now lets store some values


$kk = "hi whats going on";

$memCacheInstance = myMemCache::getMyMemCacheInstance();
$memCacheInstance->set('key',$kk);
$test = $memCacheInstance->get('key');

echo $test;

