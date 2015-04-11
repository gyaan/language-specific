<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 4/4/15
 * Time: 3:31 PM
 * in distributed system php default session doesn't work we have to implement db or file  or cached (memcached or radis) based session where all server
 * access session values form a specific server.
 */

class mySession implements SessionHandlerInterface {

    private  $dbConnection;
    private  $sessionLifeTime;

    function  __construct(){

        //set session handler
        session_set_save_handler(array(&$this,"open"),
            array(&$this,"close"),
            array(&$this,"read"),
            array(&$this,"write"),
            array(&$this,"destroy"),
            array(&$this,"gc"));
    }

    //function to create session
    function open($savePath,$sessionName){

        //get the db connection
        $this->dbConnection = new PDO('mysql:dbname=db_based_session;host:localhost','XXX','XXX');

        //set the default session expiration time
        $this->sessionLifeTime= get_cfg_var('session.gc_maxlifetime');

        if($this->dbConnection)
            return true;
        else
            return false;
        //if it was a file based then we have to create file for all session and have to store in specified path

    }

    function close(){

        //expire time for this session
        $this->gc(get_cfg_var('session.gc_maxlifetime'));

        //destroy db connection
        $this->dbConnection=null;

    }

    function read($sessionId){

        //read data
        $query = "SELECT session_data FROM my_sessions WHERE session_id = :session_id AND session_expires > :session_expires";
        $preparedQuery = $this->dbConnection->prepare($query);
        $resultSet = $preparedQuery->execute(array(":session_id"=>$sessionId,":session_expires"=>time()));
        if($resultSet)
            return $resultSet->session_data;
        else
            return "";
    }

    function write($sessionId,$sessionData){

        echo $sessionId;
        //set expiration time
        $newExpirationTime= time()+$this->sessionLifeTime;

        //check if session is already there with specified id
        $query ="SELECT * FROM my_sessions WHERE session_id = :session_id";
        $preparedQuery = $this->dbConnection->prepare($query);
        $preparedQuery->execute(array(":session_id"=>$sessionId));
        $output=$preparedQuery->fetch(PDO::FETCH_COLUMN, 0);

        if($output){
            $result = $output->fetch(PDO::FETCH_COLUMN, 0);
            //yes there is session with specified id then increase then update the session expiration time
            if($result){
                $updateQuery= "UPDATE my_sessions SET session_expires = ?, session_data = ? WHERE session_id = ?";
                $preparedQuery = $this->dbConnection->prepare($updateQuery);
                $preparedQuery->execute(array($newExpirationTime,$sessionData,$sessionId));
                if($updateQuery)
                    return true;
                else
                    return false;
            }

        }

        //new session
        $insertQuery = " INSERT INTO my_sessions (session_id,session_expires,session_data) VALUES(:session_id,:session_expires,:session_data)";
        $preparedQuery= $this->dbConnection->prepare($insertQuery);

        $result =$preparedQuery->execute(array(
            ":session_id" => $sessionId,
            ":session_expires"=>$newExpirationTime,
            ":session_data"=>$sessionData));

        if($result)
            return true;

        //at the end if there is any issue
        return false;

    }

    //session destroy function

    function  destroy($sessionId){
        $deleteQuery= "DELETE FROM my_sessions WHERE session_id =?";
        $deleteQueryResult = $this->dbConnection->prepare($deleteQuery);
        $deleteQueryResult->execute(array($sessionId));
        if($deleteQueryResult)
            return true;
        else
            return false;
    }

    function gc($sessMaxLifeTime) {

        $deleteQuery="DELETE FROM my_sessions WHERE session_expires < ?";
        $preparedQuery= $this->dbConnection->prepare($deleteQuery);
        $result = $preparedQuery->execute(array(time()));
        if($result)
            return true;
        else
            return false;
    }

}

$session = new mySession();
session_start();
echo session_id();
$_SESSION['abc']="whats up";
$_SESSION['kk']="hello";

echo $_SESSION['kk'];

//session_destroy();
