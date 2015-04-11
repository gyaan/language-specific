<?php
/**
 * Created by JetBrains PhpStorm.
 * User: root
 * Date: 11/4/15
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */

class FindPivotInAIncreasingAndDecreasingArray {

    private $testArray;
    public function __construct(Array $myArray){

        $this->testArray=$myArray;

    }


    public function getPivot(){
        $left = (int)0;
        $right = (int)sizeof($this->testArray)-1;
        return $this->recursivePivotFunction($this->testArray,$left,$right);
    }

    private function recursivePivotFunction($array,$left,$right){

        $mid = (int)$right-$left/2;

        if($array[$mid]>=$array[$mid-1] && $array[$mid]>=$array[$mid+1])
            return $array[$mid];
        else if($array[$mid]>$array[$mid-1] && $array[$mid]<$array[$mid+1])
            return $this->recursivePivotFunction($array,$mid+1,$right);
        else if($array[$mid]<$array[$mid-1] && $array[$mid]>$array[$mid+1])
            return $this->recursivePivotFunction($array,$left,$mid-1);
        else //you never gone come here
            return -1;

    }


}

//lets see

$myArr= array(1,2,2,3,3,4,5,6,5,4,3,2,1,-1);    //pivot will be 6

//create object
$myObj = new FindPivotInAIncreasingAndDecreasingArray($myArr);

echo "pivot Value is:".$myObj->getPivot();

