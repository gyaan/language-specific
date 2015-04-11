<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 5/4/15
 * Time: 11:32 PM
 * To change this template use File | Settings | File Templates.
 */

class FindLeadersInArray{

    private $arraySize;
    private $arr;

    function  __construct($array){
        $this->arr=$array;
        $this->arraySize=count($array);

    }

    function getTheLeadersInArray(){

        $maxElement=$this->arr[$this->arraySize-1];
        $leaders= array();
        //last element will be always leader ::no one is behind him :)
        $leaders[]=$maxElement;

        //start loop from end
        for($i=$this->arraySize-2;$i>=0;$i--){

            //here is your next leader
            if($maxElement<$this->arr[$i])
            {
                $leaders[]=$this->arr[$i];
                $maxElement=$this->arr[$i];
            }
        }

        //we got all leaders
        return $leaders;
    }

}

//lets use above mention class;

$arr =array(900,56,3042,89,567,417);
$findLeadersInArray=new FindLeadersInArray($arr);
$leaders=$findLeadersInArray->getTheLeadersInArray();

//display leaders
print_r($leaders);
