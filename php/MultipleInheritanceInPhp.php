<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 6/4/15
 * Time: 10:11 PM
 * multiple Inheritance  is not possible in php but we can implement using interface but still interface is build only for
 * blue print we still can't create concrete methods in interface so in php we can't extend class horizontally.trait is concept in
 * php using this we can support horizontally inheritance like multiple inheritance
 */


trait hello {

    function hello(){
        echo "say hello to trait a \n";
    }


}

trait bye{

    function bye(){
        echo "say bye to train b \n";
    }

}

trait whatsup{

    function whatsup(){}

}


class ItsMyClass{
    use hello, bye,whatsup;

    function whatsup(){
        echo "whats up dude i am overriding trait function any problem  \n";
    }

}

$myClass = new ItsMyClass();

echo $myClass->hello();
echo $myClass->bye();
echo $myClass->whatsup();

