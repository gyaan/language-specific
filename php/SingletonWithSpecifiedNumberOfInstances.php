<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 28/3/15
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */

class SingletonWithSpecifiedNumberOfInstances {

    private static $numberOfInstances;
    private static $dbInstance=null;
    private static $dbInstanceCount;

    //avoid instance creation other then only one function
    private function  __construct(){}
    private function __clone(){}
    private function __wakeup(){}

    /**
     * @return mixed
     */
    public static function getDbInstanceCount()
    {
        return self::$dbInstanceCount;
    }

    public static function getInstance(){

        if(self::$dbInstance==null || self::getDbInstanceCount() < self::$numberOfInstances){
            self::$dbInstance=new SingletonWithSpecifiedNumberOfInstances();
            self::$dbInstanceCount++;
        }

        return self::$dbInstance;

    }


    /**
     * @return mixed
     */
    public static function getNumberOfInstances()
    {
        return self::$numberOfInstances;
    }

    /**
     * @param mixed $numberOfInstances
     */
    public static  function setNumberOfInstances($numberOfInstances)
    {
       self::$numberOfInstances = $numberOfInstances;
    }


}

//lets create objects and check whats going on

//set max instance count
SingletonWithSpecifiedNumberOfInstances::setNumberOfInstances(3);

//create instances
$instanceOne=SingletonWithSpecifiedNumberOfInstances::getInstance();
$instanceTwo=SingletonWithSpecifiedNumberOfInstances::getInstance();
$instanceThree=SingletonWithSpecifiedNumberOfInstances::getInstance();
$instanceFour=SingletonWithSpecifiedNumberOfInstances::getInstance();
$instanceFive=SingletonWithSpecifiedNumberOfInstances::getInstance();


//display object hash ids
//same id will repeat for forth and fifth instance

echo "firstObjectHashId: ".spl_object_hash($instanceOne)."\n";
echo "SecondObjectHashId: ".spl_object_hash($instanceTwo)."\n";
echo "ThirdObjectHashId: ".spl_object_hash($instanceThree)."\n";
echo "FourthObjectHashId: ".spl_object_hash($instanceFour)."\n";
echo "fifthObjectHashId: ".spl_object_hash($instanceFive)."\n";


echo "Total InstanceCount: ".SingletonWithSpecifiedNumberOfInstances::getDbInstanceCount();