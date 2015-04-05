<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 5/4/15
 * Time: 3:44 PM
 *  magic methods implementation __call for function overloading  __set __get __isset __unset for property overloading
 */

class OverLoadingInPhp {

    private  $data = array();

    //set unspecified property
    function __set($name,$value){
        $this->data[$name]=$value;
    }

    //get unspecified property
    function  __get($name){

        if(array_key_exists($name,$this->data))
            return $this->data[$name];
        else
            throw new Exception("accessing undefined property");

    }

    // check if unspecified property set or not
    function __isset($name){

        if(isset($data[$name]))
            return true;
        else
            return false;

    }

    // unset the property
    function  __unset($name){
        unset($this->data[$name]);
    }

// override the methods using __call() magic methods

    function  __call($methodName,$arguments){

        $numberOfArguments=count($arguments);

        if($numberOfArguments==2 && $methodName=='area'){
            return $arguments[0]*$arguments[1];
        }
        else if($numberOfArguments==1 && $methodName=='area'){
            return round(3.14*pow($arguments[0],2),4);
        }

    }

}


$myObj = new OverLoadingInPhp();

$myObj->unspecifiedProperty = "just testing dude";

echo "here you go: ".$myObj->unspecifiedProperty;
echo "\n";
//just for demo
echo "area of rectangle: ".$myObj->area(2.3,5)."\n";
echo "area of circle: ".$myObj->area(4);

