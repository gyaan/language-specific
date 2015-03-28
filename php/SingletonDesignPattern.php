<?php
/**
 * Created by JetBrains PhpStorm.
 * User: root
 * Date: 28/3/15
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */

class SingletonDesignPattern {

    //just for demo there will be only one instance
    private static $instanceCount =0;

    //create the private instance variable
    private static $myInstance=null;

    //make constructor private so no one create object using new Keyword
    private function  __construct(){}

    //no one clone the object
    private function  __clone(){}

    //avoid serialazation
    public function __wakeup(){}

    //ony one way to create  object
    public static  function  getInstance(){

        if(self::$myInstance==null){
            self::$myInstance=new SingletonDesignPattern();
            self::$instanceCount++;
        }
        return self::$myInstance;
    }

    public static function getInstanceCount(){
        return self::$instanceCount;
    }


}


//now lets play with singleton design pattern

$instance = SingletonDesignPattern::getInstance();
$instance = SingletonDesignPattern::getInstance();
$instance = SingletonDesignPattern::getInstance();
$instance = SingletonDesignPattern::getInstance();

echo "number of instances: ".SingletonDesignPattern::getInstanceCount();
